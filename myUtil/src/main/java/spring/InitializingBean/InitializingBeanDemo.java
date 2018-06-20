package spring.InitializingBean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author fxf
 * @create 2018-05-15 9:46
 * 容器加载完成后可以执行的方法
 **/
@Component
public class InitializingBeanDemo implements InitializingBean {

	public void afterPropertiesSet() throws Exception {
		System.out.println("容器启动成功后执行此方法。");
	}
}