package com.app.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.crud.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

}
