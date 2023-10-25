package com.bgn.loginPage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bgn.loginPage.entity.User;


public interface LoginRepository extends JpaRepository<User, Integer>{

    public User findByEmailId(String emailId);
    public User findByEmailIdAndPassword(String emailId, String password);
    
}
