package com.cjy.party.dao;

import com.cjy.party.domain.SubjectProblem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectProblemMapper {
    SubjectProblem getSubProblemById(int id);

    List<SubjectProblem> getAllSubProblem();
}
