package cn.halo.test;

import static org.junit.Assert.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class testlog {

	@Test
	public void test() {
		Log log = LogFactory.getLog(getClass());
		log.debug("debug 级别");
		log.info("info 级别");
		log.warn("warn 级别");
		log.error("error 级别"); 
		log.fatal("fatal  level"); //致命
	}

}
