package test.java.com.online.test.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import main.java.com.online.core.feature.orm.mybatis.Page;
import main.java.com.online.core.feature.test.TestSupport;
import main.java.com.online.web.dao.UserMapper;
import main.java.com.online.web.model.User;
import main.java.com.online.web.model.UserExample;

public class UserMapperTest extends TestSupport {
    @Resource
    private UserMapper userMapper;

    @Test
    public void test_selectByExampleAndPage() {
        start();
        Page<User> page = new Page<>(1, 3);
        UserExample example = new UserExample();
        example.createCriteria().andIdGreaterThan(0L);
        final List<User> users = userMapper.selectByExampleAndPage(page, example);
        for (User user : users) {
            System.err.println(user);
        }
        end();
    }
}
