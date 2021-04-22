package com.testngDemo;

import org.testng.annotations.Test;

public class Demo2 {
@Test(groups="JBK")
public void test01() {
	System.out.println(1);
}
@Test(groups="JBK1")
public void test02() {
	System.out.println(2);
}
@Test(groups="JBK")
public void test03() {
	System.out.println(3);
}
@Test(groups="JBK1")
public void test04() {
	System.out.println(4);
}
@Test(groups="JBK")
public void test05 () {
	System.out.println(5);
}}