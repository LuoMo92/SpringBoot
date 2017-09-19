package com.luomo.study.spring.boot;

import com.luomo.study.spring.boot.chapter2.service.BlogProperties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by LiuMei on 2017-09-19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class Chapter2Tests {

    private static final Log log = LogFactory.getLog(ApplicationTests.class);

    @Autowired
    private BlogProperties blogProperties;

    @Test
    public void testBlogProp() throws Exception {
        Assert.assertEquals(blogProperties.getName(),"落墨");
        Assert.assertEquals(blogProperties.getTitle(),"Spring-Boot学习项目");
        Assert.assertEquals(blogProperties.getDesc(),"落墨正在进行Spring-Boot学习项目");
        log.info("随机数测试输出：");
        log.info("随机字符串 : " + blogProperties.getValue());
        log.info("随机int : " + blogProperties.getNumber());
        log.info("随机long : " + blogProperties.getBigNumber());
        log.info("随机10以下 : " + blogProperties.getWithin10());
        log.info("随机10-20 : " + blogProperties.getBetween());
    }
}
