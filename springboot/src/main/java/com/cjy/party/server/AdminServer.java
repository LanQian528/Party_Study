package com.cjy.party.server;

import com.cjy.party.domain.Organizationer;
import com.cjy.party.domain.Student;

import java.util.List;


public interface AdminServer {
    List<Organizationer> getAllOrganizationer();

    int updateInfo(Organizationer organizationer);

    int deleteTeacher(String account);

    int insertTeacher(Organizationer organizationer);

    int deleteStudent(String id);

    int updateStudent(String id, String pass, String name, String grade, String major, int school, int orgamem);

    int insertStudent(Student student);
}
