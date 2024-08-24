package com.cl.dao;

import com.cl.entity.JueyuangongxuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JueyuangongxuView;


/**
 * 绝缘工序
 * 
 * @author 
 * @email 
 * @date 2024-04-08 17:40:02
 */
public interface JueyuangongxuDao extends BaseMapper<JueyuangongxuEntity> {
	
	List<JueyuangongxuView> selectListView(@Param("ew") Wrapper<JueyuangongxuEntity> wrapper);

	List<JueyuangongxuView> selectListView(Pagination page,@Param("ew") Wrapper<JueyuangongxuEntity> wrapper);
	
	JueyuangongxuView selectView(@Param("ew") Wrapper<JueyuangongxuEntity> wrapper);
	

}
