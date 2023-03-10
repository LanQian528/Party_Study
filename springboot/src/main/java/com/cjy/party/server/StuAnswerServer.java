package com.cjy.party.server;

import com.cjy.party.domain.StuAnswer;

import java.util.List;

public interface StuAnswerServer {
    int insertStuAnswer(String stuId, int paperId, float objGrade, String eryi, String erer, String ersan, String ersi, String erwu,int status);

    List<StuAnswer> getAllAnswer();

    StuAnswer getAnswerById(int id);

    int insertSubGrade(int id, float subGrade);
}
