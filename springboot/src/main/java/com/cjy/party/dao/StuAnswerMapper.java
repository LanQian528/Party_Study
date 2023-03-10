package com.cjy.party.dao;

import com.cjy.party.domain.StuAnswer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StuAnswerMapper {
    int insertStuAnswer(String stuId, int paperId, float objGrade, String eryi, String erer, String ersan, String ersi, String erwu, int status);

    List<StuAnswer> getAllAnswer();

    StuAnswer getAnswerById(int id);

    StuAnswer getAnswerByStuId(int stu_id);

    int insertSubGrade(int id, float subGrade);
}
