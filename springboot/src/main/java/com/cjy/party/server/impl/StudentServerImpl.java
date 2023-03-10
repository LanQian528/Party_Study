package com.cjy.party.server.impl;

import com.cjy.party.dao.StuAnswerMapper;
import com.cjy.party.dao.StudentMapper;
import com.cjy.party.domain.ResultData;
import com.cjy.party.domain.StuAnswer;
import com.cjy.party.domain.StuPaper;
import com.cjy.party.domain.Student;
import com.cjy.party.server.StudentServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServerImpl implements StudentServer {
    @Autowired
    StudentMapper studentMapper;
    StuAnswerMapper stuAnswerMapper;

    @Override
    public Student getStuByStuID(String id) {
        return studentMapper.getStuByStuID(id);
    }

    @Override
    public int getTeaByStu(String id) {
        return studentMapper.getTeaByStu(id);
    }

    @Override
    public List<Student> getAllStudentInfo() {
        return studentMapper.getAllStudentInfo();
    }

    @Override
    public List<ResultData> getMeigeSchoolRenshu() {
        return studentMapper.getMeigeSchoolRenshu();
    }

    @Override
    public List<ResultData> getKaoheRenshu() {
        return studentMapper.getKaoheRenshu();
    }

    @Override
    public List<Student> getStuByTeacherId(int id) {
        return studentMapper.getStuByTeacherId(id);
    }

    @Override
    public int sendPaperToStudent(String stu_id, int paper_id) {
        return studentMapper.sendPaperToStudent(stu_id, paper_id);
    }

    @Override
    public List<StuPaper> getMyPaper(String id) {
        return studentMapper.getMyPaper(id);
    }

    @Override
    public StuAnswer getAnswerByStuId(int stu_id) {
        return stuAnswerMapper.getAnswerByStuId(stu_id);
    }
}
