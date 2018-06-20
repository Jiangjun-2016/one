package spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author fxf
 * @create 2018-06-20 10:43
 **/
@Component
@Aspect
public class DemoAOP {

	//@Resource
	//BaseDAO jdbcDAO;

	//切到具体方法
	@Pointcut("execution(* com.zdwl.service.process.impl.BizJbpmProcessServiceImpl.next(..))")
	public void pushNum() {
	}

	// 返回后通知： 在调用目标方法结束后执行 【出现异常不执行】
	@AfterReturning("pushNum()")
	public void afterReturning(JoinPoint joinPoint) {
		System.out.println("*****************AOP切点： 开始");

		System.out.println("***************AOP切点： 结束");
	}
	/**
	 *
	 * 切点获取参数joinPoint.getArgs()[i]：
	 * 切点获取方法名joinPoint.getSignature().getName()：next
	 * 是否注入jdbc：jdbcDAO.hashCode()
	 *
	 */


}