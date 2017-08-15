import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 项目打包 jar包，通过java -jar XXX.jar 执行对应的main方法
 * 使用maven的maven-assembly-plugin插件可以打出包含依赖的jar
 */
public class ExecJarMainWithDependencies {
    private static final Logger logger = LoggerFactory.getLogger(ExecJarMainWithDependencies.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();
        logger.info("hello world, with dependencies");
    }
}
