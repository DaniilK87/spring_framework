package org.example.spring_framework.homework7.repo;

import org.example.spring_framework.homework7.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findRoleById(Long id);
}
