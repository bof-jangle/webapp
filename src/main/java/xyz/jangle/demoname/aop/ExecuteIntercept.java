package xyz.jangle.demoname.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import xyz.jangle.utils.CME;
import xyz.jangle.utils.ResultModelMap;

@Aspect
@Service
public class ExecuteIntercept {
	@Autowired
	private DataSourceTransactionManager txManager;		//事务对象，在spring.xml中定义。

	private Logger logger = Logger.getLogger(getClass());
	
	// && 并 ! 非 。 即排除void返回值的方法。
	@Pointcut("execution (public * xyz.jangle.demoname.service.*.*(..)) && !execution (public void xyz.jangle.demoname.service.*.*(..))")
	public void myPointcut() {
	}

//	@Before("myPointcut()")
//	public void beforeExecute() {
//		System.out.println("before execute to do something");
//	}
//	
//	@After("myPointcut()")
//	public void afterExecute() {
//		System.out.println("after execute to do something");
//	}
//	
//	@AfterReturning("myPointcut()")
//	public void afterReturnExecute() {
//		System.out.println("afterReturning execute to do something");
//	}

	/*
	 * 濡傛灉鐜粫閫氱煡涓嶈缃繑鍥炵粨鏋滅殑璇濓紝閭ｄ箞service鎵ц鐨勬柟娉曚篃浼氳鏇夸唬涓轰笉杩斿洖濡備綍鏁版嵁 娴嬭瘯鐨勭粨鏋�
	 * 鍙互杩欐牱鐞嗚В锛� 鐜粫閫氱煡灏嗗垏鍏ョ偣鐨勬柟娉曡繘琛屼簡鍖呰锛屾垨鑰呰杩涜浜嗕唬鐞嗐��
	 * 鏁咃紝濡傛灉涓嶆墽琛宲.proceed()鏂规硶锛岄偅涔堣閫氱煡鐨勬柟娉曞皢琚樆濉烇紝鍗充笉鎵ц銆�
	 * 鑰屽鏋滀笉瀵筽.proceed()鏂规硶鐨勮繑鍥炵粨鏋滆繘琛岃繑鍥烇紝鍒欏彧鎵ц鍒囧叆鐐圭殑鏂规硶锛屼笉杩斿洖浠讳綍鏁版嵁銆�
	 * 杩欐槸闇�瑕佹敞鎰忕殑涓�鐐广��
	 */
	@Around("myPointcut()")
	public Object aroundExecute(ProceedingJoinPoint p) {
		Object res = null;
		//XXX 此处还可以添加方法调用的权限功能 或者考虑在Filter中做
		
		//事务的开始
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = txManager.getTransaction(def);
		try {
			System.out.println("around befroe");
			res = p.proceed();
			System.out.println("around after");
//			System.out.println(res);
		} catch (Throwable e) {
			logger.error(e.toString());
			txManager.rollback(status);//回滚事务
			ResultModelMap<Object> resm = new ResultModelMap<Object>(CME.exception);
			resm.appendMessage(e.getMessage());
			return resm;
		}
		txManager.commit(status);//提交事务
		return res;
	}

}
