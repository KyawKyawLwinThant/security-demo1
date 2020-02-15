package com.example.mvcsecuritydemo.repository;

import com.example.mvcsecuritydemo.domain.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Roles,Integer> {
}
