package com.bgn.loginPage.service;

import com.bgn.loginPage.dto.UserDTO;
import com.bgn.loginPage.entity.User;

public interface LoginService {
    // public User addUser(UserDTO userDTO);
    public User saveUser(User user);
    public User getCustomer(String emailId);
    public User getUserByEmailIdAndPassword(String emailId, String password);
    
}
