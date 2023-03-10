package com.cjy.party.server.impl;

import com.cjy.party.dao.OrganizationerMapper;
import com.cjy.party.dao.StudentMapper;
import com.cjy.party.domain.Organizationer;
import com.cjy.party.domain.Student;
import com.cjy.party.server.AdminServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServerImpl implements AdminServer {
    @Autowired
    OrganizationerMapper organizationerMapper;
    @Autowired
    StudentMapper studentMapper;

    @Override
    public List<Organizationer> getAllOrganizationer() {
        return organizationerMapper.getAllOrganizationer();
    }

    @Override
    public int updateInfo(Organizationer organizationer) {
        return organizationerMapper.updateInfo(organizationer);
    }

    @Override
    public int deleteTeacher(String account) {
        return organizationerMapper.deleteTeacher(account);
    }

    @Override
    public int insertTeacher(Organizationer organizationer) {
        return organizationerMapper.insertTeacher(organizationer);
    }

    @Override
    public int deleteStudent(String id) {
        return studentMapper.deleteStudent(id);
    }

    @Override
    public int updateStudent(String id, String pass, String name, String grade, String major, int school, int orgamem) {
        Student student = new Student();
        student.setStu_id(id);
        student.setStu_school(Integer.toString(school));
        student.setStu_orgamem(Integer.toString(orgamem));
        student.setStu_pass(pass);
        student.setStu_name(name);
        student.setStu_grade(grade);
        student.setMajor(major);
        return studentMapper.updateStudentById(student);
    }

    @Override
    public int insertStudent(Student student) {
        return studentMapper.insertStudent(student);
    }


}
