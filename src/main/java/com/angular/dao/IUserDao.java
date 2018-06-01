package main.java.com.angular.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import main.java.com.angular.model.UserEntity;

/**
 * @author ls
 */
@Component
public interface IUserDao {
    public boolean isExist(UserEntity user);
    public boolean addUser(UserEntity user);
    public List<UserEntity> fetchUser();
    public boolean delUser(int id);
    public boolean updateUser(int id,UserEntity user);
    public UserEntity getUser(UserEntity user);
    
}
