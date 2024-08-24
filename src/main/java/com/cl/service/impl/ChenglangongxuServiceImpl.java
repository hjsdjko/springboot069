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


import com.cl.dao.ChenglangongxuDao;
import com.cl.entity.ChenglangongxuEntity;
import com.cl.service.ChenglangongxuService;
import com.cl.entity.view.ChenglangongxuView;

@Service("chenglangongxuService")
public class ChenglangongxuServiceImpl extends ServiceImpl<ChenglangongxuDao, ChenglangongxuEntity> implements ChenglangongxuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChenglangongxuEntity> page = this.selectPage(
                new Query<ChenglangongxuEntity>(params).getPage(),
                new EntityWrapper<ChenglangongxuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChenglangongxuEntity> wrapper) {
		  Page<ChenglangongxuView> page =new Query<ChenglangongxuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ChenglangongxuView> selectListView(Wrapper<ChenglangongxuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChenglangongxuView selectView(Wrapper<ChenglangongxuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
