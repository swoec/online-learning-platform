package test.java.com.online.test.bean;

import javax.annotation.Resource;

import org.junit.Test;

import main.java.com.online.core.feature.test.TestSupport;

/**
 * SpiderTest : 爬虫测试类
 *
 * @author StarZou
 * @since 2014-10-27 22:44
 */
public class SpiderTest extends TestSupport {

    @Resource
    private Spider spider;

    @Test
    public void testInjectSpider() throws Exception {
        System.out.println(spider);
    }
}
