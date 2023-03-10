package com.cjy.party.server.impl;

import com.cjy.party.dao.ObjectProblemMapper;
import com.cjy.party.domain.ObjectProblem;
import com.cjy.party.server.ObjectProblemServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjectProblemServerImpl implements ObjectProblemServer {
    @Autowired
    ObjectProblemMapper objectProblemMapper;

    @Override
    public List<ObjectProblem> getAllObjProblem() {
        return objectProblemMapper.getAllObjProblem();
    }

    @Override
    public int updateObjProblem(ObjectProblem objectProblem) {
        return objectProblemMapper.updateObjProblem(objectProblem);
    }

    @Override
    public int deleteProblem(int id) {
        return objectProblemMapper.deleteProblem(id);
    }

    @Override
    public int insertProblem(ObjectProblem objectProblem) {
        return objectProblemMapper.insertProblem(objectProblem);
    }
}
