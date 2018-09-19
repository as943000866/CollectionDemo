package com.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//动态代理的使用
interface Subject{
	public void action();
}
//被代理类
class RealSubject implements Subject{

	public void action() {
		System.out.println("被代理对象的方法执行了");
		
	}
	
}
//动态代理:创建一个实现了InvactionHandler接口的代理类对象
class MyInvactionHandler implements InvocationHandler{

	Object obj;//实现了接口的被代理类的对象的声明
	//①给被代理的对象实例化②返回一个代理类的对象
	public Object blind(Object obj) {
		this.obj = obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
	}
	//当代理类的对象发起对被重写方法的调用时,都会转换为对如下的invoke方法的调用
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return method.invoke(obj, args);
	}
	
}
public class TestProxy {
	public static void main(String[] args) {
		//1.被代理类的对象
		RealSubject subject = new RealSubject();
		//2.创建一个实现了InvactionHandler接口的类的对象
		MyInvactionHandler handler = new MyInvactionHandler();
		//3.调用blind()方法,动态的返回一个同样实现了real所在类实现的接口Subject的代理类的对象
		Subject proxy = (Subject) handler.blind(subject);
		proxy.action();
		
		NikeClothProductFactory nikeFactory = new NikeClothProductFactory();
		
		ClothProductFactory proxy1 = (ClothProductFactory) handler.blind(nikeFactory);
		proxy1.productCloth();
	}
}
