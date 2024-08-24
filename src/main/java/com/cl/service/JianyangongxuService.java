package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JianyangongxuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JianyangongxuView;


/**
 * 检验工序
 *
 * @author 
 * @email 
 * @date 2024-04-08 17:40:03
 */
public interface JianyangongxuService extends IService<JianyangongxuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JianyangongxuView> selectListView(Wrapper<JianyangongxuEntity> wrapper);
   	
   	JianyangongxuView selectView(@Param("ew") Wrapper<JianyangongxuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JianyangongxuEntity> wrapper);
   	

}

