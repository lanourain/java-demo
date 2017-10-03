package aop.aspectJ;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
// 从特定xml或者配置类中获取相应的配置
@ContextConfiguration(classes = ConcertConfig.class)
public class PerformanceTest {

    @Autowired
    Performance performance;

    @Test
    public void test_perform() {
        assertNotNull(performance);
        performance.perform();
        Encoreable encoreable = (Encoreable) performance;
        encoreable.performEncore();
    }

}
