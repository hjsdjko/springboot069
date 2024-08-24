package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JueyuangongxuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JueyuangongxuView;


/**
 * 绝缘工序
 *
 * @author 
 * @email 
 * @date 2024-04-08 17:40:02
 */
public interface JueyuangongxuService extends IService<JueyuangongxuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JueyuangongxuView> selectListView(Wrapper<JueyuangongxuEntity> wrapper);
   	
   	JueyuangongxuView selectView(@Param("ew") Wrapper<JueyuangongxuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JueyuangongxuEntity> wrapper);
   	

}

