package com.cjy.party.server.impl;

import com.cjy.party.dao.StuAnswerMapper;
import com.cjy.party.domain.StuAnswer;
import com.cjy.party.server.StuAnswerServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuAnswerServerImpl implements StuAnswerServer {
    @Autowired
    StuAnswerMapper stuAnswerMapper;

    @Override
    public int insertStuAnswer(String stuId, int paperId, float objGrade, String eryi, String erer, String ersan, String ersi, String erwu,int status) {
        return stuAnswerMapper.insertStuAnswer(stuId, paperId, objGrade, eryi, erer, ersan, ersi, erwu, status);
    }

    @Override
    public List<StuAnswer> getAllAnswer() {
        return stuAnswerMapper.getAllAnswer();
    }

    @Override
    public StuAnswer getAnswerById(int id) {
        return stuAnswerMapper.getAnswerById(id);
    }

    @Override
    public int insertSubGrade(int id, float subGrade) {
        return stuAnswerMapper.insertSubGrade(id, subGrade);
    }
}
