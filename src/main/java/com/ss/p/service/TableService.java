package com.ss.p.service;

import com.ss.p.mapper.TableMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 创建者：shanlin
 * 创建时间：2018/3/27 10:34
 **/
@Service
public class TableService {
	Logger log = LoggerFactory.getLogger(TableService.class);
	@Autowired
	private TableMapper mapper;
	
	public List<String> getList(){
		List<String> tableAllDate = mapper.getTableAllDate();
//		int a = 1/0;
		return tableAllDate;
	}
	
	/**
	 * update
	 * @param name
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public int updateName(String name){
		int i = mapper.updateName(name);
		int a = 1/0;
		return i;
	}
}
