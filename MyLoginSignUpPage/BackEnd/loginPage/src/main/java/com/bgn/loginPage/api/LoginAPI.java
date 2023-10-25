package com.bgn.loginPage.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bgn.loginPage.dto.UserDTO;
import com.bgn.loginPage.entity.User;
import com.bgn.loginPage.service.LoginService;

@RestController
@RequestMapping(value = "/bgn/loginpage")
public class LoginAPI {
    @Autowired
    private LoginService loginService;

    // @PostMapping(value = "/customers")//Add user means as the user click the
    // submit the data gets into the db;
    // public ResponseEntity<String> addCustomer(@RequestBody CustomerDTO customer)
    // throws InfyBankException {
    // Integer customerId = customerService.addCustomer(customer);
    // String successMessage = environment.getProperty("API.INSERT_SUCCESS") +
    // customerId;
    // return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
    // }

    // public ResponseEntity<String> addUser(@RequestBody UserDTO user){
    // loginService.addUser(user);
    // return null;
    // }
    @PostMapping(value = "/register")
    @CrossOrigin(origins = "http://localhost:4200")
    public User registerUser(@RequestBody User user) throws Exception {
        String tempEmail = user.getEmailId();
        if (tempEmail != null && !"".equals(tempEmail)) {
            User userObj = loginService.getCustomer(tempEmail);
            if (userObj != null) {
                throw new Exception("User with " + tempEmail + " already exists.");
            }
        }
        User userObj = null;
        userObj = loginService.saveUser(user);
        return userObj;
    }

    @PostMapping(value = "/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public User loginUser(@RequestBody User user) throws Exception {
        String tempEmailId = user.getEmailId();
        String tempPass = user.getPassword();
        User userObj = null;
        if (tempEmailId != null && tempPass != null) {
            userObj = loginService.getUserByEmailIdAndPassword(tempEmailId, tempPass);
        }
        if (userObj == null) {
            throw new Exception("Wrong Credentials");
        }
        return userObj;
    }

}
