package com.decoders.controllers;

public class Test {

	public static void main(String[] args) {
		
		String s = new String("15:59:08");
		String[] data=s.split(":");
		int time= Integer.parseInt(data[1]);
		time=time-(time%5);
		System.out.println("time" + time);

	}

}
