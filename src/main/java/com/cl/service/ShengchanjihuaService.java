package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShengchanjihuaEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShengchanjihuaView;


/**
 * 生产计划
 *
 * @author 
 * @email 
 * @date 2024-04-08 17:40:02
 */
public interface ShengchanjihuaService extends IService<ShengchanjihuaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShengchanjihuaView> selectListView(Wrapper<ShengchanjihuaEntity> wrapper);
   	
   	ShengchanjihuaView selectView(@Param("ew") Wrapper<ShengchanjihuaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShengchanjihuaEntity> wrapper);
   	

}

