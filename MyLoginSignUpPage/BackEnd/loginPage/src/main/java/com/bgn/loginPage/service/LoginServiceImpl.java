package com.bgn.loginPage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bgn.loginPage.dto.UserDTO;
import com.bgn.loginPage.entity.User;
import com.bgn.loginPage.repository.LoginRepository;

@Service("loginService")
@Transactional
public class LoginServiceImpl implements LoginService{
    @Autowired
    private LoginRepository loginRepository;

    @Override
    // public User addUser(UserDTO userDTO) {
    //     // TODO Auto-generated method stub
    //     User userEntity = new User();
    //     userEntity.setId(userDTO.getId());
    //     userEntity.setEmailId(userDTO.getEmailId());
    //     userEntity.setUserName(userDTO.getUserName());
    //     userEntity.setPassword(userDTO.getPassword());
    //     // User userEntity2 = loginRepository.save(userEntity);
    //     return loginRepository.save(userEntity);
    // }
    public User saveUser(User user){
        return loginRepository.save(user);
    }

    @Override
    public User getCustomer(String emailId) {
        // TODO Auto-generated method stub
        return loginRepository.findByEmailId(emailId);

    }

    @Override
    public User getUserByEmailIdAndPassword(String emailId, String password) {
        // TODO Auto-generated method stub
        return loginRepository.findByEmailIdAndPassword(emailId, password);
    }
    
}
