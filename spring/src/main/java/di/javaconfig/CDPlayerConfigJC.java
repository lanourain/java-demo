package di.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 表明该类是Spring配置类
 */
@Configuration
public class CDPlayerConfigJC {

    @Bean
    public CompactDiscJC sgtPeppersJC() {
        return new SgtPeppersJC();
    }
}
