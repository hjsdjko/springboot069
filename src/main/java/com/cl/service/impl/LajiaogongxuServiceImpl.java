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


import com.cl.dao.LajiaogongxuDao;
import com.cl.entity.LajiaogongxuEntity;
import com.cl.service.LajiaogongxuService;
import com.cl.entity.view.LajiaogongxuView;

@Service("lajiaogongxuService")
public class LajiaogongxuServiceImpl extends ServiceImpl<LajiaogongxuDao, LajiaogongxuEntity> implements LajiaogongxuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LajiaogongxuEntity> page = this.selectPage(
                new Query<LajiaogongxuEntity>(params).getPage(),
                new EntityWrapper<LajiaogongxuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LajiaogongxuEntity> wrapper) {
		  Page<LajiaogongxuView> page =new Query<LajiaogongxuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<LajiaogongxuView> selectListView(Wrapper<LajiaogongxuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LajiaogongxuView selectView(Wrapper<LajiaogongxuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
