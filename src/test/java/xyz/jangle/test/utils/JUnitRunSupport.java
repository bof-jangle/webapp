package xyz.jangle.test.utils;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import xyz.jangle.demoname.model.BsUser2;
import xyz.jangle.demoname.service.BsUser2Service;

/**
 * @author huhj
 * @email jangle@jangle.xyz
 * @time 2018年6月26日 下午3:35:46
 */
// 表示整合JUnit4进行测试（需要 JUnit4.12及以上版本）
@RunWith(SpringJUnit4ClassRunner.class)
// 加载spring配置文件  超类是事务管理的相关功能，继承后默认Rollback(true)
@ContextConfiguration(locations = { "classpath:spring-test.xml" })
public abstract class JUnitRunSupport extends AbstractTransactionalJUnit4SpringContextTests{
	// 此处是以编码方式手动获取Spring的Bean对象的设计。
	/*
	 * private volatile static BeanFactory factory;
	 * 
	 * @Before public void setUp() throws Exception {
	 * System.out.println("加载spring配置开始 ............");
	 * 
	 * ArrayList<String> list = new ArrayList<String>(); list.add("spring.xml");
	 * // 将Sprint配置文件加入待加载列表 try { factory = new ClassPathXmlApplicationContext(
	 * list.toArray(new String[list.size()])); // 保证虚拟机退出之前
	 * spring中singtleton对象自定义销毁方法会执行 ((AbstractApplicationContext)
	 * factory).registerShutdownHook(); } catch (Exception e) {
	 * e.printStackTrace(); System.out.println("加载配置文件时发生错误" + e); }
	 * System.out.println("加载spring配置结束............."); }
	 * 
	 * public static Object getBean(Class<?> bean){ // return
	 * factory.getBean(bean); return null; }
	 */

	@Autowired
	protected BsUser2Service bsUser2Service;

	protected void login(){
		bsUser2Service.login(BsUser2.youkeCode, BsUser2.youkePassword, null);
	}
	
	protected void loginByTest() {
		bsUser2Service.login(BsUser2.testCode, BsUser2.testPassword, null);
	}

}
