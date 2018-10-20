package proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
//import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGLibProxy {

	public void test() {
		System.out.println("hello world");
	}

	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(CGLibProxy.class);
		enhancer.setCallback(new MethodInterceptor() {
			@Override
			public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
				System.out.println("before method run...");
				Object result = proxy.invokeSuper(obj, args);
				System.out.println("after method run...");
				return result;
			}
		});
		CGLibProxy sample = (CGLibProxy) enhancer.create();
		sample.test();
	}
}
// ---------------------
// 作者：DarkRanger1
// 来源：CSDN
// 原文：https://blog.csdn.net/danchu/article/details/70238002
// 版权声明：本文为博主原创文章，转载请附上博文链接！
