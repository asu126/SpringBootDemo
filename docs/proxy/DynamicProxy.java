package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {
	interface IHello {
		void sayHello();
	}

	static class Hello implements IHello {
		public void sayHello() {
			System.out.println("hello world");
		}
	}

	static class DynamicProxyTest implements InvocationHandler {
		Object originalObj;

		Object bind(Object originalObj) {
			this.originalObj = originalObj;
			return Proxy.newProxyInstance(originalObj.getClass().getClassLoader(),
					originalObj.getClass().getInterfaces(), this);
		}

		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			System.out.println("Welcome");
			return method.invoke(originalObj, args);
		}
	}

	public static void main(String[] args) {
		// 设置这个值，在程序运行完成后，可以生成代理类
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		IHello hello = (IHello) new DynamicProxyTest().bind(new Hello());
		hello.sayHello();
	}
}
// ---------------------
// 作者：DarkRanger1
// 来源：CSDN
// 原文：https://blog.csdn.net/danchu/article/details/70146985
// 版权声明：本文为博主原创文章，转载请附上博文链接！
