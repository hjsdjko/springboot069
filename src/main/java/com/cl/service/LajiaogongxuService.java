package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.LajiaogongxuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.LajiaogongxuView;


/**
 * 拉绞工序
 *
 * @author 
 * @email 
 * @date 2024-04-08 17:40:02
 */
public interface LajiaogongxuService extends IService<LajiaogongxuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LajiaogongxuView> selectListView(Wrapper<LajiaogongxuEntity> wrapper);
   	
   	LajiaogongxuView selectView(@Param("ew") Wrapper<LajiaogongxuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LajiaogongxuEntity> wrapper);
   	

}

