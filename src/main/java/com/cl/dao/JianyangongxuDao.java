package com.cl.dao;

import com.cl.entity.JianyangongxuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JianyangongxuView;


/**
 * 检验工序
 * 
 * @author 
 * @email 
 * @date 2024-04-08 17:40:03
 */
public interface JianyangongxuDao extends BaseMapper<JianyangongxuEntity> {
	
	List<JianyangongxuView> selectListView(@Param("ew") Wrapper<JianyangongxuEntity> wrapper);

	List<JianyangongxuView> selectListView(Pagination page,@Param("ew") Wrapper<JianyangongxuEntity> wrapper);
	
	JianyangongxuView selectView(@Param("ew") Wrapper<JianyangongxuEntity> wrapper);
	

}
