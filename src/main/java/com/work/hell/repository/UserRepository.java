package com.work.hell.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.work.hell.domian.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
