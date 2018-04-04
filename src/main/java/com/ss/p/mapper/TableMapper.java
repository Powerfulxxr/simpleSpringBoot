package com.ss.p.mapper;

import java.util.List;

/**
 * 创建者：shanlin
 * 创建时间：2018/3/27 10:34
 * @author shanlin
 **/
public interface TableMapper {
	/**
	 * sas
	 * @return
	 */
	List<String> getTableAllDate();
	
	/**
	 * 更新
	 * @param name
	 * @return
	 */
	int updateName(String name);
}
