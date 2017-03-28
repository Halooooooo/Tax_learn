package com.halo.nsfw.complain;

import java.util.Date;

public class MyQuartzTask {
	public void task(){
		System.out.println("guding time heiheihei"+new Date());
	}
	public void task2(){
		System.out.println("Cron guding time heiheihei"+new Date());
	}
}
