package com.cjy.party.server.impl;

import com.cjy.party.dao.AdminMapper;
import com.cjy.party.dao.OrganizationerMapper;
import com.cjy.party.dao.StudentMapper;
import com.cjy.party.domain.Login;
import com.cjy.party.domain.User;
import com.cjy.party.server.LoginServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServerImpl implements LoginServer {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    AdminMapper adminMapper;
    @Autowired
    OrganizationerMapper organizationerMapper;

    @Override
    public User verifyAccount(Login login) {
        if (login.getType() == 3 && studentMapper.verifyAccount(login.getId(), login.getPass()) != null && studentMapper.verifyAccount(login.getId(), login.getPass()).getType() == 3) {
            return studentMapper.verifyAccount(login.getId(), login.getPass());
        } else if (login.getType() == 1 && adminMapper.verifyAccount(login.getId(), login.getPass()) != null && adminMapper.verifyAccount(login.getId(), login.getPass()).getType() == 1) {
            return adminMapper.verifyAccount(login.getId(), login.getPass());
        } else if (login.getType() == 2 && organizationerMapper.verifyAccount(login.getId(), login.getPass()) != null && organizationerMapper.verifyAccount(login.getId(), login.getPass()).getType() == 2) {
            return organizationerMapper.verifyAccount(login.getId(), login.getPass());
        } else
            return new User(0, "error", "error");
    }
}
