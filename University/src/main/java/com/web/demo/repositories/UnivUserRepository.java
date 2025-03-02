package com.web.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.demo.entites.UnivUser;

@Repository
public interface UnivUserRepository extends JpaRepository<UnivUser, Integer>{

	UnivUser findByEmail(String email);
}
