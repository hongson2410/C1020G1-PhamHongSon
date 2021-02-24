package com.repository;

import com.model.Login;
import com.model.User;

public interface UserRepository {
    User checkLogin(Login login);
}
