package com.cl.dao;

import com.cl.entity.HutaogongxuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HutaogongxuView;


/**
 * 护套工序
 * 
 * @author 
 * @email 
 * @date 2024-04-08 17:40:03
 */
public interface HutaogongxuDao extends BaseMapper<HutaogongxuEntity> {
	
	List<HutaogongxuView> selectListView(@Param("ew") Wrapper<HutaogongxuEntity> wrapper);

	List<HutaogongxuView> selectListView(Pagination page,@Param("ew") Wrapper<HutaogongxuEntity> wrapper);
	
	HutaogongxuView selectView(@Param("ew") Wrapper<HutaogongxuEntity> wrapper);
	

}
