package com.ss.p.controller;


import com.ss.p.model.base.BaseModel;
import com.ss.p.service.TableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.Serializable;
import java.util.List;

/**
 * 创建者：shanlin
 * 创建时间：2018/3/23 14:47
 * @author shanlin
 **/
@RestController
public class HelloController{
	Logger logger = LoggerFactory.getLogger(HelloController.class);
	@Value("${spring.profiles.active}")
	private  String profile;
	
	@Autowired
	private TableService service;
	
	@Autowired
	private ListOperations<String, Object> listOperations;
	@Autowired
	private ValueOperations<String, String> valueOperations;
	
	@RequestMapping("/")
	public ModelAndView hello(Model model){
		ModelAndView mv =new ModelAndView();
		model.addAttribute("say","hello spring boot");
		mv.setViewName("hello");
		logger.info("******************** profile :{}",profile);
		System.out.println("*********** : "+listOperations.index("com.ss.p.controller.HelloController.getList",0));
		return mv;
	}
	
	@Cacheable("dataList")
	@GetMapping("/getDataList")
	public List<String> getList(){
		System.out.println("*********** : "+listOperations.range("com.ss.p.controller.HelloController.getList",0,-1));
		return service.getList();
	}
	
	@CacheEvict(value = "dataList",allEntries = true)
	@GetMapping("/updateName")
	public int updateName(String name){
		int i = service.updateName(name);
		return i;
	}
	
}
