package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.HutaogongxuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HutaogongxuView;


/**
 * 护套工序
 *
 * @author 
 * @email 
 * @date 2024-04-08 17:40:03
 */
public interface HutaogongxuService extends IService<HutaogongxuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HutaogongxuView> selectListView(Wrapper<HutaogongxuEntity> wrapper);
   	
   	HutaogongxuView selectView(@Param("ew") Wrapper<HutaogongxuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HutaogongxuEntity> wrapper);
   	

}

