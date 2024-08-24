package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.ShengchanjihuaDao;
import com.cl.entity.ShengchanjihuaEntity;
import com.cl.service.ShengchanjihuaService;
import com.cl.entity.view.ShengchanjihuaView;

@Service("shengchanjihuaService")
public class ShengchanjihuaServiceImpl extends ServiceImpl<ShengchanjihuaDao, ShengchanjihuaEntity> implements ShengchanjihuaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShengchanjihuaEntity> page = this.selectPage(
                new Query<ShengchanjihuaEntity>(params).getPage(),
                new EntityWrapper<ShengchanjihuaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShengchanjihuaEntity> wrapper) {
		  Page<ShengchanjihuaView> page =new Query<ShengchanjihuaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ShengchanjihuaView> selectListView(Wrapper<ShengchanjihuaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShengchanjihuaView selectView(Wrapper<ShengchanjihuaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
