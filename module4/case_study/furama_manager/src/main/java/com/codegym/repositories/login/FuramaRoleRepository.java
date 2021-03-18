package com.codegym.repositories.login;

import com.codegym.models.employee.FuramaRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuramaRoleRepository extends JpaRepository<FuramaRole, Integer> {
}
