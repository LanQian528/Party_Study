package com.cjy.party.dao;


import com.cjy.party.domain.ResultData;
import com.cjy.party.domain.StuPaper;
import com.cjy.party.domain.Student;
import com.cjy.party.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentMapper {
    User verifyAccount(String stu_id, String stu_pass);

    Student getStuByStuID(String id);

    int getTeaByStu(String id);

    List<Student> getAllStudentInfo();

    int deleteStudent(String id);

    int updateStudentById(Student student);

    int insertStudent(Student student);

    List<ResultData> getMeigeSchoolRenshu();

    List<ResultData> getKaoheRenshu();

    List<Student> getStuByTeacherId(int id);

    int sendPaperToStudent(String stuId, int paperId);

    List<StuPaper> getMyPaper(String id);
}
