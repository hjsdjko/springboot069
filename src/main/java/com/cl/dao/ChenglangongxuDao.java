package com.cl.dao;

import com.cl.entity.ChenglangongxuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChenglangongxuView;


/**
 * 成缆工序
 * 
 * @author 
 * @email 
 * @date 2024-04-08 17:40:02
 */
public interface ChenglangongxuDao extends BaseMapper<ChenglangongxuEntity> {
	
	List<ChenglangongxuView> selectListView(@Param("ew") Wrapper<ChenglangongxuEntity> wrapper);

	List<ChenglangongxuView> selectListView(Pagination page,@Param("ew") Wrapper<ChenglangongxuEntity> wrapper);
	
	ChenglangongxuView selectView(@Param("ew") Wrapper<ChenglangongxuEntity> wrapper);
	

}
