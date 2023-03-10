package com.cjy.party.dao;

import com.cjy.party.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {
    User verifyAccount(String account, String password);
}
