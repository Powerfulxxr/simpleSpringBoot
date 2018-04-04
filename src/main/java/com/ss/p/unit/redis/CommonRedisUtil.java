package com.ss.p.unit.redis;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author：22
 * @create-time：2018/4/2 13:30
 **/
public class CommonRedisUtil {
	private static final Logger logger = LoggerFactory.getLogger(CommonRedisUtil.class);
	@Resource
	private RedisTemplate<String, Object> redisTemplate;
	
	public boolean expire(String key, long time) {
		logger.info("expire key:" + key + "time:" + time);
		if (StringUtils.isBlank(key)) {
			return false;
		} else {
			try {
				if (time > 0L) {
					this.redisTemplate.expire(key, time, TimeUnit.SECONDS);
				}
				
				return true;
			} catch (Exception var5) {
				logger.error("redis处理异常 expire key:" + key, var5);
				return false;
			}
		}
	}
	
	public long getExpire(String key) {
		logger.info("key:" + key);
		return StringUtils.isBlank(key) ? 0L : this.redisTemplate.getExpire(key, TimeUnit.SECONDS);
	}
	
	public boolean hasKey(String key) {
		logger.info("key:" + key);
		if (StringUtils.isBlank(key)) {
			return false;
		} else {
			try {
				return this.redisTemplate.hasKey(key);
			} catch (Exception var3) {
				logger.error("redis处理异常  hasKey key:" + key, var3);
				return false;
			}
		}
	}
	
	public void del(String... key) {
		logger.info("key:" + key);
		if (key != null && key.length > 0) {
			if (key.length == 1) {
				this.redisTemplate.delete(key[0]);
			} else {
				this.redisTemplate.delete(CollectionUtils.arrayToList(key));
			}
		}
		
	}
	
	public void matchDel(String key) {
		Set<String> keys = this.redisTemplate.keys(key);
		this.redisTemplate.delete(keys);
		logger.info("{}, redis中用户收听历史被清空");
	}
}
