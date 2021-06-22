package com.example.proyectomaja.dao;

import com.example.proyectomaja.domain.User;

public interface UserDao {

    User findByMailAndPassword(String email, String password);
}
