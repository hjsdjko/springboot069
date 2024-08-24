package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ChenglangongxuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChenglangongxuView;


/**
 * 成缆工序
 *
 * @author 
 * @email 
 * @date 2024-04-08 17:40:02
 */
public interface ChenglangongxuService extends IService<ChenglangongxuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChenglangongxuView> selectListView(Wrapper<ChenglangongxuEntity> wrapper);
   	
   	ChenglangongxuView selectView(@Param("ew") Wrapper<ChenglangongxuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChenglangongxuEntity> wrapper);
   	

}

