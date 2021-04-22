package com.selenium.basics;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

public class DateConcept {

	@Test
	public void fbDateFormat(){
		SimpleDateFormat sdf=new SimpleDateFormat("MMddyyyy");
		Date d=new Date();
		String curDate=sdf.format(d);
		System.out.println(curDate);
		
		String month=curDate.substring(0, 2);
		String day=curDate.substring(2,4);
		String year=curDate.substring(4);
		
		System.out.println(month+" "+day+" "+year);
		int reqDate=Integer.parseInt(day)+7;
		int reqYear=Integer.parseInt(year)-16;
		int reqMonth=Integer.parseInt(month)+1;
		System.out.println(reqDate+" "+reqMonth+" "+reqYear);	
	}
}
