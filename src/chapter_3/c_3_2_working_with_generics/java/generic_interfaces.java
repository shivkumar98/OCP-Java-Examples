package chapter_3.c_3_2_working_with_generics.java;

public class generic_interfaces {

}

interface Shippable<T>{
	void ship(T t);
}

class ShippableRobotCrate implements Shippable<Robot> {
	public void ship(Robot t) {}
}

class ShippableAbstractCrate<U> implements Shippable<U>{
	public void ship(U t) { }
}

class ShippableObject implements Shippable{
	public void ship(Object t) {}
}

