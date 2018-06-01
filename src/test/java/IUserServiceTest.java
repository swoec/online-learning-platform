package test.java;

import static org.junit.Assert.fail;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.angular.model.UserEntity;
import main.java.com.angular.service.IUserService;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring.xml","classpath*:spring-hibernate.xml","classpath*:spring-mvc.xml"})
public class IUserServiceTest {
	private static Logger logger = Logger.getLogger(IUserServiceTest.class);
	@Resource
	@Autowired(required=true)
	@Qualifier("userService")
	IUserService userservice;
	
	@Test
	public void testAdduser() {
		UserEntity user = new UserEntity();
		user.setName("111");
		user.setAccount("dddd");
		user.setPassword("88888");
		user.setPhone("88888");
		user.setSex("male");
		boolean tres= userservice.adduser(user);
		if(tres){
			//success("");
		}else{
			fail("Not yet implemented");
		}
		//fail("Not yet implemented");
	}

}
