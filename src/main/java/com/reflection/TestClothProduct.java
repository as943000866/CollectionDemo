package com.reflection;

//静态代理
//共同的接口
interface ClothProductFactory{
	void productCloth();
}

//被代理类
class NikeClothProductFactory implements ClothProductFactory{

	public void productCloth() {
		System.out.println("Nike生产了一批衣服");
		
	}
	
}

//代理类对象
class ProxyClothProductFactory implements ClothProductFactory{

	//1.持有被代理类的引用
	ClothProductFactory productFactory;
	
	public ProxyClothProductFactory(ClothProductFactory productFactory) {
		this.productFactory = productFactory;
	}
	
	//2.通过代理类的方法调用被代理类的方法
	public void productCloth() {
		productFactory.productCloth();
		
	}
	
}
public class TestClothProduct {
	public static void main(String[] args) {
		//1.被代理类
		NikeClothProductFactory nikeFactory = new NikeClothProductFactory();
		//2.代理类
		ProxyClothProductFactory proxyFactory = new ProxyClothProductFactory(nikeFactory);
		//3.调用共同的方法
		proxyFactory.productCloth();
	}
}
