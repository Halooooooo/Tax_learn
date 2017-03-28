package cn.halo.test;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mysql.jdbc.StringUtils;

import cn.halo.test.entity.person;
import cn.halo.test.service.Iservice;

public class test {
	ClassPathXmlApplicationContext context;
	@Before
	public void test() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	@Test
	public void testcal(){
		Calendar calendar = Calendar.getInstance();
		int o = calendar.get(Calendar.MONTH);
		System.out.println(o);
	}
	@Test
	public void testgc() { System.gc();	}	
	@Test
	public void testSpring() {
		Iservice s = (Iservice) context.getBean("service");
		s.say();
	}
	@Test
	public void testhibernate()
	{
		SessionFactory sf = (SessionFactory) context.getBean("sessionFactory");
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(new person("person1"));
		session.getTransaction().commit();
		session.close();
	}
	@Test
	public void testservice()
	{
		Iservice s = (Iservice) context.getBean("service");
		System.out.println(s.findPerson("4028474e5602333f0156023340c60000").getName());
	}
	@Test
	public void testtransaction()
	{
		Iservice s = (Iservice) context.getBean("service");
		System.out.println(s.findPerson("4028474e5602333f0156023340c60000").getName());
	}
	@Test
	public void testrollback()
	{
		Iservice s = (Iservice) context.getBean("service");
		s.save(new person("人员3"));
	}
	@Test
	public void testString()
	{
		String excel = "ef.jw.elx";
		String isexcel = excel.substring(excel.lastIndexOf("."));
		System.out.println(isexcel);
	}
	@Test
	public void testStringutil()
	{
		String s = "wer";
		
		System.out.println(StringUtils.isNullOrEmpty(s));
	}

}
