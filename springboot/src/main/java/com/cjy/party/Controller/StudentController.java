package com.cjy.party.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cjy.party.dao.SchoolMapper;
import com.cjy.party.domain.Grade;
import com.cjy.party.domain.ResultData;
import com.cjy.party.domain.StuPaper;
import com.cjy.party.domain.Student;
import com.cjy.party.server.impl.GradeServerImpl;
import com.cjy.party.server.impl.StuAnswerServerImpl;
import com.cjy.party.server.impl.StudentServerImpl;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@Controller
public class StudentController {
    @Autowired
    StudentServerImpl studentServer;
    @Autowired
    GradeServerImpl gradeServer;
    @Autowired
    SchoolMapper schoolMapper;
    @Autowired
    StuAnswerServerImpl stuAnswerServer;

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "api/insertStuAnswer", method = RequestMethod.POST)
    public Object insertStuAnswer(HttpServletRequest request) throws IOException {
        String s = StreamUtils.copyToString(request.getInputStream(), StandardCharsets.UTF_8);
        JSONObject jsonObject = JSON.parseObject(s);
        String stuId = jsonObject.get("stuId").toString();
        int paperId = Integer.parseInt(jsonObject.get("paperId").toString());
        int status = Integer.parseInt(jsonObject.get("status").toString());
        float objGrade = Float.parseFloat(jsonObject.get("objGrade").toString());
        JSONArray jsonArray = JSONArray.parseArray(jsonObject.get("subAnswer").toString());
        int i = stuAnswerServer.insertStuAnswer(stuId, paperId, objGrade, jsonArray.get(0).toString(),
                jsonArray.get(1).toString(), jsonArray.get(2).toString(), jsonArray.get(3).toString(),
                jsonArray.get(4).toString(),status);
        JSONObject jsonObject1 = new JSONObject();
        if (i > 0) jsonObject1.put("code", 200);
        else jsonObject1.put("code", 400);
        return jsonObject1;
    }

    @ResponseBody
    @CrossOrigin
    @RequestMapping(value = "/api/insertGrade", method = RequestMethod.POST)
    public void insertStuGrade(HttpServletRequest request) throws IOException {
        String s = StreamUtils.copyToString(request.getInputStream(), StandardCharsets.UTF_8);
        JSONObject jsonObject = JSONObject.parseObject(s);
        Grade accept_grade = new Grade(Integer.parseInt(jsonObject.get("CorrectedNum").toString()),
                Integer.parseInt(jsonObject.get("DisCorrectedNum").toString()),
                jsonObject.get("questionMaster").toString(),
                jsonObject.get("id").toString());
        gradeServer.insertStuGrade(accept_grade);
    }

    @CrossOrigin
    @RequestMapping(value = "api/getHistory", method = RequestMethod.GET)
    public Object getHistory(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        String s = request.getParameter("id");
        Student student = studentServer.getStuByStuID(s);
        @JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
        class Data {
            String name;
            int id;
            int CorrectedNum;
            int DisCorrectedNum;
            int grade;
            String questionMaster;
            String createTime;

            public Data(String name, int id, int correctedNum, int disCorrectedNum, int grade, String createTime, String questionMaster) {
                this.name = name;
                this.id = id;
                this.CorrectedNum = correctedNum;
                this.DisCorrectedNum = disCorrectedNum;
                this.grade = grade;
                this.createTime = createTime;
                this.questionMaster = questionMaster;
            }

            public String getQuestionMaster() {
                return questionMaster;
            }

            public String getName() {
                return name;
            }

            public int getId() {
                return id;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getCorrectedNum() {
                return CorrectedNum;
            }

            public void setCorrectedNum(int correctedNum) {
                CorrectedNum = correctedNum;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getDisCorrectedNum() {
                return DisCorrectedNum;
            }

            public void setDisCorrectedNum(int disCorrectedNum) {
                DisCorrectedNum = disCorrectedNum;
            }

            public int getGrade() {
                return grade;
            }

            public void setGrade(int grade) {
                this.grade = grade;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }
        }
        for (int i = 0; i < student.getGrades().size(); i++) {
            Data data = new Data(student.getStu_name(),
                    student.getGrades().get(i).getId(), student.getGrades().get(i).getCorrectedNum(),
                    student.getGrades().get(i).getDisCorrectedNum(),
                    student.getGrades().get(i).getCorrectedNum() * 4,
                    student.getGrades().get(i).getCreateTime().toString(),
                    student.getGrades().get(i).getQuestionMaster());
            jsonArray.add(data);
        }
        jsonObject.put("history", jsonArray);
        return jsonObject;
    }

    @CrossOrigin
    @RequestMapping(value = "api/getStuInfo", method = RequestMethod.GET)
    public Object getStuInfo(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id");
        Student student = studentServer.getStuByStuID(id);
        jsonObject.put("stu_id", student.getStu_id());
        jsonObject.put("stu_pass", student.getStu_pass());
        jsonObject.put("stu_name", student.getStu_name());
        jsonObject.put("stu_grade", student.getStu_grade());
        jsonObject.put("stu_school", student.getStu_school());
        jsonObject.put("stu_orgamem", student.getStu_orgamem());
        jsonObject.put("major", student.getMajor());
        return jsonObject;
    }

    @CrossOrigin
    @RequestMapping(value = "api/getTeaByStu", method = RequestMethod.GET)
    public Object getTeaByStu(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id");
        int org_id = studentServer.getTeaByStu(id);
        jsonObject.put("id", org_id);
        return jsonObject;
    }

    @CrossOrigin
    @RequestMapping(value = "api/getAllStuInfo", method = RequestMethod.GET)
    public Object getAllStuInfo(HttpServletRequest request) {
        List<Student> students = studentServer.getAllStudentInfo();
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        jsonArray.addAll(students);
        jsonObject.put("students", jsonArray);
        return jsonObject;
    }

    @CrossOrigin
    @RequestMapping(value = "api/getMypaper", method = RequestMethod.GET)
    public Object getMapaper(HttpServletRequest request) {
        String s = request.getParameter("id");
        List<StuPaper> list = studentServer.getMyPaper(s);
        JSONArray jsonArray = new JSONArray();
        class ResultData {
            String name;
            String creator;
            String createTime;
            int id;

            public int getId() {
                return id;
            }

            public String getName() {
                return name;
            }            public void setId(int id) {
                this.id = id;
            }

            public String getCreator() {
                return creator;
            }

            public void setCreator(String creator) {
                this.creator = creator;
            }            public void setName(String name) {
                this.name = name;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }
        }
        for (StuPaper stuPaper : list) {
            ResultData resultData = new ResultData();
            resultData.setId(stuPaper.getPaper().getId());
            resultData.setName(stuPaper.getPaper().getName());
            resultData.setCreator(stuPaper.getPaper().getCreator());
            resultData.setCreateTime(stuPaper.getPaper().getCreateTime());
            jsonArray.add(resultData);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("paperInfo", jsonArray);
        return jsonObject;
    }

    @CrossOrigin
    @RequestMapping(value = "api/getMeigeSchoolRenshu", method = RequestMethod.GET)
    public Object getMeigeSchoolRenshu() {
        List<ResultData> list = studentServer.getMeigeSchoolRenshu();
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        class Datatype {
            String name;
            int value;
            public String getName() {
                return name;
            }
            public int getValue() {
                return value;
            }
            public void setName(String name) {
                this.name = name;
            }
            public void setValue(int data) {
                this.value = data;
            }
        }
        for (ResultData resultData : list) {
            String s = schoolMapper.getNameById(resultData.getType());
            Datatype data = new Datatype();
            data.setName(s);
            data.setValue(resultData.getData());
            jsonArray.add(data);
        }
        jsonObject.put("data", jsonArray);
        return jsonObject;
    }
    @CrossOrigin
    @RequestMapping(value = "api/getKaoheRenshu", method = RequestMethod.GET)
    public Object getKaoheRenshu() {
        List<ResultData> list = studentServer.getKaoheRenshu();
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        class Datatype {
            String name;
            int value;
            public String getName() {
                return name;
            }
            public int getValue() {
                return value;
            }
            public void setName(String name) {
                this.name = name;
            }
            public void setValue(int data) {
                this.value = data;
            }
        }
        for (ResultData resultData : list) {
            String s = schoolMapper.getNameById(resultData.getType());
            Datatype data = new Datatype();
            data.setName(s);
            data.setValue(resultData.getData());
            jsonArray.add(data);
        }
        jsonObject.put("data", jsonArray);
        return jsonObject;
    }
}
