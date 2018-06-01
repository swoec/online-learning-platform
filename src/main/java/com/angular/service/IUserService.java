package main.java.com.angular.service;

import java.util.List;

import org.springframework.stereotype.Component;

import main.java.com.angular.model.UserEntity;

/**
 * @author ls
 */
@Component
public interface IUserService {
    public boolean isExist(UserEntity user);
    public boolean adduser(UserEntity user);
    public List fetchUser();
    public boolean updateUser(int id,UserEntity user);
    public boolean delUser(int id);
    public UserEntity searchuser(UserEntity user);
}
