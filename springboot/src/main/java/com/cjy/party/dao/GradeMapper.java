package com.cjy.party.dao;

import com.cjy.party.domain.Grade;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeMapper {
    List<Grade> getAllGrade(String stu_id);

    void insertStuGrade(Grade grade);
}
