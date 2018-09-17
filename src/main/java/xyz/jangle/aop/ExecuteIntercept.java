package xyz.jangle.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class ExecuteIntercept {
	
	@Pointcut("execution (* xyz.jangle.service.*.*(..))")
	public void myPointcut() {}
	
	@Before("myPointcut()")
	public void beforeExecute() {
		System.out.println("before execute to do something");
	}
	
	@After("myPointcut()")
	public void afterExecute() {
		System.out.println("after execute to do something");
	}
	
	@AfterReturning("myPointcut()")
	public void afterReturnExecute() {
		System.out.println("afterReturning execute to do something");
	}
	
	/*濡傛灉鐜粫閫氱煡涓嶈缃繑鍥炵粨鏋滅殑璇濓紝閭ｄ箞service鎵ц鐨勬柟娉曚篃浼氳鏇夸唬涓轰笉杩斿洖濡備綍鏁版嵁  娴嬭瘯鐨勭粨鏋�
		鍙互杩欐牱鐞嗚В锛� 鐜粫閫氱煡灏嗗垏鍏ョ偣鐨勬柟娉曡繘琛屼簡鍖呰锛屾垨鑰呰杩涜浜嗕唬鐞嗐�� 鏁咃紝濡傛灉涓嶆墽琛宲.proceed()鏂规硶锛岄偅涔堣閫氱煡鐨勬柟娉曞皢琚樆濉烇紝鍗充笉鎵ц銆�
		鑰屽鏋滀笉瀵筽.proceed()鏂规硶鐨勮繑鍥炵粨鏋滆繘琛岃繑鍥烇紝鍒欏彧鎵ц鍒囧叆鐐圭殑鏂规硶锛屼笉杩斿洖浠讳綍鏁版嵁銆� 杩欐槸闇�瑕佹敞鎰忕殑涓�鐐广��
	*/
	@Around("myPointcut()")
	public Object aroundExecute(ProceedingJoinPoint p) {
		Object res =null;
		try {
			System.out.println("around befroe");
			res = p.proceed();
			System.out.println("around after");
//			System.out.println(res);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return res;
	}
	
	

}
