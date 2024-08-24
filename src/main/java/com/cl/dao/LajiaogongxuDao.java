package com.cl.dao;

import com.cl.entity.LajiaogongxuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.LajiaogongxuView;


/**
 * 拉绞工序
 * 
 * @author 
 * @email 
 * @date 2024-04-08 17:40:02
 */
public interface LajiaogongxuDao extends BaseMapper<LajiaogongxuEntity> {
	
	List<LajiaogongxuView> selectListView(@Param("ew") Wrapper<LajiaogongxuEntity> wrapper);

	List<LajiaogongxuView> selectListView(Pagination page,@Param("ew") Wrapper<LajiaogongxuEntity> wrapper);
	
	LajiaogongxuView selectView(@Param("ew") Wrapper<LajiaogongxuEntity> wrapper);
	

}
