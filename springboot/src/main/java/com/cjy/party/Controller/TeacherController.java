package com.cjy.party.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cjy.party.dao.OrganizationerMapper;
import com.cjy.party.dao.SubjectProblemMapper;
import com.cjy.party.domain.*;
import com.cjy.party.server.PaperServer;
import com.cjy.party.server.impl.PaperServerImpl;
import com.cjy.party.server.impl.StuAnswerServerImpl;
import com.cjy.party.server.impl.StudentServerImpl;
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
public class TeacherController {
    @Autowired
    OrganizationerMapper organizationerMapper;
    @Autowired
    PaperServerImpl paperServer;
    @Autowired
    SubjectProblemMapper subjectProblemMapper;
    @Autowired
    StudentServerImpl studentServer;
    @Autowired
    StuAnswerServerImpl stuAnswerServer;

    @CrossOrigin
    @RequestMapping(value = "/api/getAllAnswer", method = RequestMethod.GET)
    public Object getAllAnswer() {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        List<StuAnswer> list = stuAnswerServer.getAllAnswer();
        class Datatype{
            int id;
            String stu_name;
            String paper_name;
            float objGrade;
            String eryi;
            String erer;
            String ersan;
            String ersi;
            String erwu;

            public int getId() {return id;}

            public void setId(int id) {this.id = id;}

            public String getStu_name() {return stu_name;}

            public void setStu_name(String stu_name) {this.stu_name = stu_name;}

            public String getPaper_name() {return paper_name;}

            public void setPaper_name(String paper_name) {this.paper_name = paper_name;}

            public float getObjGrade() {return objGrade;}

            public void setObjGrade(float objGrade) {this.objGrade = objGrade;}

            public String getEryi() {return eryi;}

            public void setEryi(String eryi) {this.eryi = eryi;}

            public String getErer() {return erer;}

            public void setErer(String erer) {this.erer = erer;}

            public String getErsan() {return ersan;}

            public void setErsan(String ersan) {this.ersan = ersan;}

            public String getErsi() {return ersi;}

            public void setErsi(String ersi) {this.ersi = ersi;}

            public String getErwu() {return erwu;}

            public void setErwu(String erwu) {this.erwu = erwu;}
        }
        for (StuAnswer stuAnswer : list) {
            Datatype datatype = new Datatype();
            datatype.setId(stuAnswer.getId());
            datatype.setStu_name(stuAnswer.getStuId().getStu_name());
            datatype.setPaper_name(stuAnswer.getPaper().getName());
            datatype.setObjGrade(stuAnswer.getObjGrade());
            datatype.setEryi(stuAnswer.getEryi());
            datatype.setErer(stuAnswer.getErer());
            datatype.setErsan(stuAnswer.getErsan());
            datatype.setErsi(stuAnswer.getErsi());
            datatype.setErwu(stuAnswer.getErwu());
            jsonArray.add(datatype);
        }
        jsonObject.put("info", jsonArray);
        return jsonObject;
    }

    @CrossOrigin
    @RequestMapping(value = "/api/getAnswerById", method = RequestMethod.GET)
    public Object getAnswerById(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        int id = Integer.parseInt(request.getParameter("id"));
        StuAnswer stuAnswer = stuAnswerServer.getAnswerById(id);
        jsonObject.put("info", stuAnswer);
        return jsonObject;
    }

    @CrossOrigin
    @RequestMapping(value = "/api/getTeacherInfo", method = RequestMethod.GET)
    public Object getTeacherInfo(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        int id = Integer.parseInt(request.getParameter("id"));
        Organizationer organizationer = organizationerMapper.getOrganizationInfoById(id);
        jsonObject.put("info", organizationer);
        return jsonObject;
    }

    @CrossOrigin
    @RequestMapping(value = "api/getPaperInfoByCreatorId", method = RequestMethod.GET)
    public Object getPaperInfoByCreatorId(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        String s = request.getParameter("id");
        List<Paper> list = paperServer.getPaperByCreatorId(Integer.parseInt(s));
        class Datatype {
            int id;
            String name;
            String creator;
            String createTime;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getCreator() {
                return creator;
            }

            public void setCreator(String creator) {
                this.creator = creator;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }
        }
        for (Paper paper : list) {
            Datatype datatype = new Datatype();
            datatype.setId(paper.getId());
            datatype.setName(paper.getName());
            datatype.setCreator(paper.getCreator());
            datatype.setCreateTime(paper.getCreateTime());
            jsonArray.add(datatype);
        }
        jsonObject.put("paperInfo", jsonArray);
        return jsonObject;
    }

    @CrossOrigin
    @RequestMapping(value = "api/getPaperInfoById", method = RequestMethod.GET)
    public Object getPaperInfoById(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        int id = Integer.parseInt(request.getParameter("id"));
        jsonObject.put("paperInfo", paperServer.getPaperInfoById(id));
        return jsonObject;
    }

    @CrossOrigin
    @RequestMapping(value = "api/getAllSubProblem", method = RequestMethod.GET)
    public Object getAllSubProblem() {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        List<SubjectProblem> list = subjectProblemMapper.getAllSubProblem();
        jsonArray.addAll(list);
        jsonObject.put("allsubProblem", jsonArray);
        return jsonObject;
    }

    @CrossOrigin
    @RequestMapping(value = "api/getSubById", method = RequestMethod.GET)
    public Object getSubById(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        int id = Integer.parseInt(request.getParameter("id"));
        SubjectProblem subjectProblem = subjectProblemMapper.getSubProblemById(id);
        jsonObject.put("subpro_id", subjectProblem.getSubpro_id());
        jsonObject.put("subpro_com", subjectProblem.getSubpro_com());
        jsonObject.put("subpro_ans", subjectProblem.getSubpro_ans());
        return jsonObject;
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "api/createPaper", method = RequestMethod.POST)
    public Object createPaper(HttpServletRequest request) throws IOException {
        String s = StreamUtils.copyToString(request.getInputStream(), StandardCharsets.UTF_8);
        new JSONObject();
        JSONObject jsonObject;
        jsonObject = JSON.parseObject(s);
        int creator = Integer.parseInt(jsonObject.get("creator").toString());
        String name = jsonObject.get("name").toString();
        new JSONArray();
        JSONArray jsonArrayObj;
        jsonArrayObj = JSONArray.parseArray(jsonObject.get("objProblem").toString());
        new JSONArray();
        JSONArray jsonArraySub;
        jsonArraySub = JSONArray.parseArray(jsonObject.get("subProblem").toString());
        int i = paperServer.insertPaper(name, creator, Integer.parseInt(jsonArrayObj.get(0).toString()),
                Integer.parseInt(jsonArrayObj.get(1).toString()), Integer.parseInt(jsonArrayObj.get(2).toString()),
                Integer.parseInt(jsonArrayObj.get(3).toString()), Integer.parseInt(jsonArrayObj.get(4).toString()),
                Integer.parseInt(jsonArrayObj.get(5).toString()), Integer.parseInt(jsonArrayObj.get(6).toString()),
                Integer.parseInt(jsonArrayObj.get(7).toString()), Integer.parseInt(jsonArrayObj.get(8).toString()),
                Integer.parseInt(jsonArrayObj.get(9).toString()), Integer.parseInt(jsonArrayObj.get(10).toString()),
                Integer.parseInt(jsonArrayObj.get(11).toString()), Integer.parseInt(jsonArrayObj.get(12).toString()),
                Integer.parseInt(jsonArrayObj.get(13).toString()), Integer.parseInt(jsonArrayObj.get(14).toString()),
                Integer.parseInt(jsonArrayObj.get(15).toString()), Integer.parseInt(jsonArrayObj.get(16).toString()),
                Integer.parseInt(jsonArrayObj.get(17).toString()), Integer.parseInt(jsonArrayObj.get(18).toString()),
                Integer.parseInt(jsonArrayObj.get(19).toString()), Integer.parseInt(jsonArraySub.get(0).toString()),
                Integer.parseInt(jsonArraySub.get(1).toString()), Integer.parseInt(jsonArraySub.get(2).toString()),
                Integer.parseInt(jsonArraySub.get(3).toString()), Integer.parseInt(jsonArraySub.get(4).toString())
        );
        JSONObject jsonObject1 = new JSONObject();
        if (i > 0) jsonObject1.put("code", 200);
        else jsonObject1.put("code", 400);
        return jsonObject1;
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "api/deletePaperById", method = RequestMethod.POST)
    public Object deletePaperById(HttpServletRequest request) throws IOException {
        String s = StreamUtils.copyToString(request.getInputStream(), StandardCharsets.UTF_8);
        new JSONObject();
        JSONObject jsonObject;
        jsonObject = JSON.parseObject(s);
        int id = Integer.parseInt(jsonObject.get("id").toString());
        int i = paperServer.deletePaperById(id);
        JSONObject jsonObject1 = new JSONObject();
        if (i > 0) jsonObject1.put("code", 200);
        else jsonObject1.put("code", 400);
        return jsonObject1;
    }

    @CrossOrigin
    @RequestMapping(value = "api/getAllstuByTeacherId", method = RequestMethod.GET)
    public Object getAllstuByTeacherId(HttpServletRequest request) {
        String s = request.getParameter("id");
        List<Student> students = studentServer.getStuByTeacherId(Integer.parseInt(s));
        JSONArray jsonArray = new JSONArray();
        jsonArray.addAll(students);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("studentInfo", jsonArray);
        return jsonObject;
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "api/addStudentPaper", method = RequestMethod.POST)
    public Object addStudentPaper(HttpServletRequest request) throws IOException {
        String s = StreamUtils.copyToString(request.getInputStream(), StandardCharsets.UTF_8);
        new JSONObject();
        JSONObject jsonObject;
        jsonObject = JSON.parseObject(s);
        int paperid = Integer.parseInt(jsonObject.get("paperId").toString());
        new JSONArray();
        JSONArray jsonArray;
        jsonArray = JSONArray.parseArray(jsonObject.get("stuIds").toString());
        int result = 0;
        for (Object o : jsonArray) {
            result += studentServer.sendPaperToStudent(o.toString(), paperid);
        }
        JSONObject jsonObject1 = new JSONObject();
        if (result == jsonArray.size())
            jsonObject1.put("code", 200);
        else jsonObject1.put("code", 400);
        return jsonObject1;
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "api/insertSubGrade", method = RequestMethod.POST)
    public Object insertSubGrade(HttpServletRequest request) throws IOException {
        String s = StreamUtils.copyToString(request.getInputStream(), StandardCharsets.UTF_8);
        new JSONObject();
        JSONObject jsonObject;
        jsonObject = JSON.parseObject(s);
        int id = Integer.parseInt(jsonObject.get("id").toString());
        float subGrade = Float.parseFloat(jsonObject.get("subGrade").toString());
        int i = stuAnswerServer.insertSubGrade(id, subGrade);
        JSONObject jsonObject1 = new JSONObject();
        if (i > 0) jsonObject1.put("code", 200);
        else jsonObject1.put("code", 400);
        return jsonObject1;
    }
}
