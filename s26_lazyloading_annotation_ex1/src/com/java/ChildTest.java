package com.java;

public class ChildTest {

	public static void main(String[] args) {
		/**
		 * First we initialize a child
		 */
		Child child = new Child();
		/**
		 * A cool ben 10 action figure
		 */
		Toy ben10 = new Toy();
		ben10.setToyName("Ben 10 figure");

		/**
		 * A even more cooler spider man action figure
		 */
		Toy spiderMan = new Toy();
		spiderMan.setToyName("Spider man figure");

		child.setChildName("John");
		/**
		 * Add the toys to the collection
		 */
		child.addToy(ben10);
		child.addToy(spiderMan);
	}

}
