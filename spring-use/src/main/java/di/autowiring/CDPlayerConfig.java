package di.autowiring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 表明该类是Spring配置类
 */
@Configuration
/**
 * @ComponentScan 默认扫描与配置类相同的包，自动化装配
 */
@ComponentScan
public class CDPlayerConfig {
}
