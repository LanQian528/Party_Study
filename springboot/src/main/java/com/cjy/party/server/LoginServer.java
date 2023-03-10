package com.cjy.party.server;

import com.cjy.party.domain.Login;
import com.cjy.party.domain.User;

public interface LoginServer {
    User verifyAccount(Login login);
}
