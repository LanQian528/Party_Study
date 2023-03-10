package com.cjy.party.server.impl;

import com.cjy.party.dao.GradeMapper;
import com.cjy.party.domain.Grade;
import com.cjy.party.server.GradeServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeServerImpl implements GradeServer {
    @Autowired
    GradeMapper gradeMapper;

    @Override
    public void insertStuGrade(Grade grade) {
        gradeMapper.insertStuGrade(grade);
    }
}
