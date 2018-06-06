package test.java.com.online.test.library.jedis;

import javax.annotation.Resource;

import org.junit.Test;

import main.java.com.online.core.feature.cache.redis.RedisCache;
import main.java.com.online.core.feature.test.TestSupport;

/**
 * JedisTest : 测试 jedis 功能
 *
 * @author StarZou
 * @since 2015-03-20 10:32
 */
public class JedisTest extends TestSupport {


    @Resource
    private RedisCache redisCache;


    @Test
    public void testSet() {
        redisCache.cache("anchor", "StarZou", 1 * 60 * 24);
    }

    @Test
    public void testGet() {
        System.out.printf(redisCache.get("anchor"));
    }
}
