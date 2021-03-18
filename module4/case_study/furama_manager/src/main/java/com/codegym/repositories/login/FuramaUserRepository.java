package com.codegym.repositories.login;

import com.codegym.models.employee.FuramaUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuramaUserRepository extends JpaRepository<FuramaUser, String> {
    FuramaUser findFuramaUserByUserName(String userName);
}
