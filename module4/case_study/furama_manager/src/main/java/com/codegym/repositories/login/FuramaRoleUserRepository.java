package com.codegym.repositories.login;

import com.codegym.models.employee.FuramaRoleUser;
import com.codegym.models.employee.FuramaUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuramaRoleUserRepository extends JpaRepository<FuramaRoleUser, Integer> {
    List<FuramaRoleUser> findByFuramaUser(FuramaUser furamaUser);
}
