package aop.aspectJ;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

// 通过使用DeclareParents 来给类添加新功能
@Aspect
public class EncoreableIntroducer {
    @DeclareParents(value = "aop.aspectJ.Performance+",
            defaultImpl = EncoreableImpl.class)
    public static Encoreable encoreable;

}
