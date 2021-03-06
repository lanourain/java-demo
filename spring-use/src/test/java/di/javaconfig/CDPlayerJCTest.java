package di.javaconfig;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
// 从特定xml或者配置类中获取相应的配置
@ContextConfiguration(classes = CDPlayerConfigJC.class)
public class CDPlayerJCTest {

    @Autowired
    private CompactDiscJC cd;

    @Test
    public void test_bean_not_null() {
        assertNotNull(cd);
    }
}
