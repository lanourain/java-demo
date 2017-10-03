package aop.aspectJ;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// java 配置文件
@Configuration
// 启用aspectj自动代理
@EnableAspectJAutoProxy
@ComponentScan
public class ConcertConfig {

    @Bean
    public Audience audience() {
        return new Audience();
    }

    @Bean
    public AudienceAround audienceAround() {
        return new AudienceAround();
    }

    @Bean
    public EncoreableIntroducer encoreableIntroducer() {
        return new EncoreableIntroducer();
    }
}
