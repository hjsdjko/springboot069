package com.cl.dao;

import com.cl.entity.ShengchanjihuaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShengchanjihuaView;


/**
 * 生产计划
 * 
 * @author 
 * @email 
 * @date 2024-04-08 17:40:02
 */
public interface ShengchanjihuaDao extends BaseMapper<ShengchanjihuaEntity> {
	
	List<ShengchanjihuaView> selectListView(@Param("ew") Wrapper<ShengchanjihuaEntity> wrapper);

	List<ShengchanjihuaView> selectListView(Pagination page,@Param("ew") Wrapper<ShengchanjihuaEntity> wrapper);
	
	ShengchanjihuaView selectView(@Param("ew") Wrapper<ShengchanjihuaEntity> wrapper);
	

}
