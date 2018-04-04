package com.ss.p.model.base;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author：shanlin
 * @create-time：2018/3/28 16:07
 **/
public class BaseModel<T> {
	
	public static <T> Logger getLog(T t){
		return LoggerFactory.getLogger(t.getClass());
	}
	
}
