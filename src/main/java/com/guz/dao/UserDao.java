package com.guz.dao;

import com.guz.entity.User;

import java.util.List;

/**
 * Created by lguz on 24.03.16.
 */
public interface UserDao {

    List<User> findAllWithoutCode(String codeName);
}
