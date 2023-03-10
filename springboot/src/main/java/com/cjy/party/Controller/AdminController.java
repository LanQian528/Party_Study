package com.cjy.party.Controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cjy.party.domain.Organizationer;
import com.cjy.party.domain.Student;
import com.cjy.party.server.impl.AdminServerImpl;
import com.cjy.party.server.impl.ObjectProblemServerImpl;
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
public class AdminController {
    @Autowired
    AdminServerImpl adminServer;
    @Autowired
    ObjectProblemServerImpl objectProblemServer;

    @CrossOrigin
    @RequestMapping(value = "/api/getAllTeacherInfo", method = RequestMethod.GET)
    public Object getAllTeacherInfo() {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        List<Organizationer> list = adminServer.getAllOrganizationer();
        jsonArray.addAll(list);
        jsonObject.put("teacherInfo", jsonArray);
        return jsonObject;
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/api/updateTeacherInfo", method = RequestMethod.POST)
    public Object updateTeacherInfo(HttpServletRequest request) throws IOException {
        String s = StreamUtils.copyToString(request.getInputStream(), StandardCharsets.UTF_8);
        JSONObject jsonObject = JSONObject.parseObject(s);
        Organizationer organizationer = new Organizationer();
        organizationer.setSchool(jsonObject.get("school").toString());
        organizationer.setOrmem_acc(jsonObject.get("ormem_acc").toString());
        organizationer.setOrmem_name(jsonObject.get("ormem_name").toString());
        organizationer.setOrmem_pass(jsonObject.get("ormem_pass").toString());
        int i = adminServer.updateInfo(organizationer);
        JSONObject jsonObject1 = new JSONObject();
        if (i > 0) {
            jsonObject1.put("code", 200);
        } else {
            jsonObject1.put("code", 400);
        }
        return jsonObject1;
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/api/deleteTeacher", method = RequestMethod.POST)
    public Object deleteTeacher(HttpServletRequest request) throws IOException {
        String s = StreamUtils.copyToString(request.getInputStream(), StandardCharsets.UTF_8);
        JSONObject jsonObject = JSONObject.parseObject(s);
        adminServer.deleteTeacher(jsonObject.get("ormem_acc").toString());
        jsonObject.put("code", 200);
        return jsonObject;
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/api/insertTeacher", method = RequestMethod.POST)
    public Object insertTeacher(HttpServletRequest request) throws IOException {
        new JSONObject();
        JSONObject jsonObject;
        String s = StreamUtils.copyToString(request.getInputStream(), StandardCharsets.UTF_8);
        jsonObject = JSONObject.parseObject(s);
        Organizationer organizationer = new Organizationer();
        organizationer.setOrmem_acc(jsonObject.get("acc").toString());
        organizationer.setOrmem_pass(jsonObject.get("pass").toString());
        organizationer.setOrmem_name(jsonObject.get("name").toString());
        organizationer.setSchool(jsonObject.get("school").toString());
        int i = adminServer.insertTeacher(organizationer);
        if (i > 0) {
            jsonObject.put("code", 200);
        } else {
            jsonObject.put("code", 400);
        }
        return jsonObject;
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/api/deleteStudent", method = RequestMethod.POST)
    public Object deleteStudent(HttpServletRequest request) throws IOException {
        new JSONObject();
        JSONObject jsonObject;
        String s = StreamUtils.copyToString(request.getInputStream(), StandardCharsets.UTF_8);
        jsonObject = JSONObject.parseObject(s);
        int i = adminServer.deleteStudent(jsonObject.get("stu_id").toString());
        JSONObject jsonObject1 = new JSONObject();
        if (i > 0) jsonObject1.put("code", 200);
        else jsonObject1.put("code", 400);
        return jsonObject1;
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/api/updateStudent", method = RequestMethod.POST)
    public Object updateStudent(HttpServletRequest request) throws IOException {
        new JSONObject();
        JSONObject jsonObject;
        String s = StreamUtils.copyToString(request.getInputStream(), StandardCharsets.UTF_8);
        jsonObject = JSONObject.parseObject(s);
        int i = adminServer.updateStudent(
                jsonObject.get("stu_id").toString(),
                jsonObject.get("stu_pass").toString(),
                jsonObject.get("stu_name").toString(),
                jsonObject.get("stu_grade").toString(),
                jsonObject.get("major").toString(),
                jsonObject.getInteger("stu_school"),
                jsonObject.getInteger("stu_orgamem"));
        JSONObject jsonObject1 = new JSONObject();
        if (i > 0) jsonObject1.put("code", 200);
        else jsonObject1.put("code", 400);
        return jsonObject1;
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/api/insertStudent", method = RequestMethod.POST)
    public Object insertStudent(HttpServletRequest request) throws IOException {
        new JSONObject();
        JSONObject jsonObject;
        String s = StreamUtils.copyToString(request.getInputStream(), StandardCharsets.UTF_8);
        jsonObject = JSONObject.parseObject(s);
        Student student = new Student();
        student.setStu_id(jsonObject.get("id").toString());
        student.setStu_pass(jsonObject.get("pass").toString());
        student.setStu_name(jsonObject.get("name").toString());
        student.setStu_grade(jsonObject.get("grade").toString());
        student.setStu_school(jsonObject.get("school").toString());
        student.setStu_orgamem(jsonObject.get("orgamem").toString());
        student.setMajor(jsonObject.get("major").toString());
        adminServer.insertStudent(student);
        jsonObject.put("code", "200");
        return jsonObject;
    }


}
