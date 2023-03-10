package com.cjy.party.dao;

import com.cjy.party.domain.ObjectProblem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObjectProblemMapper {
    List<ObjectProblem> getAllObjProblem();

    List<ObjectProblem> getTestProblem();

    int updateObjProblem(ObjectProblem objectProblem);

    int deleteProblem(int id);

    int insertProblem(ObjectProblem objectProblem);

    ObjectProblem getObjectInfoById(int id);
}
