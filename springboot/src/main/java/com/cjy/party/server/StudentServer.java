package com.cjy.party.server;


import com.cjy.party.domain.ResultData;
import com.cjy.party.domain.StuAnswer;
import com.cjy.party.domain.StuPaper;
import com.cjy.party.domain.Student;

import java.util.List;

public interface StudentServer {
    Student getStuByStuID(String id);

    int getTeaByStu(String id);

    List<Student> getAllStudentInfo();

    List<ResultData> getMeigeSchoolRenshu();

    List<ResultData> getKaoheRenshu();

    List<Student> getStuByTeacherId(int id);

    int sendPaperToStudent(String stu_id, int paper_id);

    List<StuPaper> getMyPaper(String id);

    StuAnswer getAnswerByStuId(int stu_id);
}
