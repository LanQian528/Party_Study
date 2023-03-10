package com.cjy.party.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface SchoolMapper {
    String getNameById(int id);
}
