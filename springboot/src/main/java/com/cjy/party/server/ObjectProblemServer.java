package com.cjy.party.server;

import com.cjy.party.domain.ObjectProblem;

import java.util.List;

public interface ObjectProblemServer {
    List<ObjectProblem> getAllObjProblem();

    int updateObjProblem(ObjectProblem objectProblem);

    int deleteProblem(int id);

    int insertProblem(ObjectProblem objectProblem);
}
