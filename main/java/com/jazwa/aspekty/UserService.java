package com.jazwa.aspekty;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    User user = new User("bartek", "12345698765");

    public String getUpperName(){
        return user.getName().toUpperCase();
    }

    public String getBirthDateFromPesel(){
        return user.getPesel().substring(0,6);
    }

    public Long error(){
        return Long.valueOf(user.getName());
    }
}
