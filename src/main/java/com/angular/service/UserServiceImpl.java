package main.java.com.angular.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.angular.dao.IUserDao;
import main.java.com.angular.model.UserEntity;


/**
 * @author ls
 */

@Transactional
@Service("userService")
public class UserServiceImpl implements IUserService {
    @Resource
    private IUserDao userDao;
    
    @Override
    public boolean isExist(UserEntity user) {
        return userDao.isExist(user);
    }
   
    @Transactional
	@Override
	public boolean adduser(UserEntity user) {
		// TODO Auto-generated method stub
		return userDao.addUser(user);
	}
	@Override
	public List fetchUser() {
		// TODO Auto-generated method stub
		return userDao.fetchUser();
	}

	@Override
	public boolean updateUser(int id, UserEntity user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(id, user);
	}

	@Override
	public boolean delUser(int id) {
		// TODO Auto-generated method stub
		return userDao.delUser(id);
	}

	@Override
	public UserEntity searchuser(UserEntity user) {
		// TODO Auto-generated method stub
		return userDao.getUser(user);
	}
}
