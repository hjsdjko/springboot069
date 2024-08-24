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


import com.cl.dao.HutaogongxuDao;
import com.cl.entity.HutaogongxuEntity;
import com.cl.service.HutaogongxuService;
import com.cl.entity.view.HutaogongxuView;

@Service("hutaogongxuService")
public class HutaogongxuServiceImpl extends ServiceImpl<HutaogongxuDao, HutaogongxuEntity> implements HutaogongxuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HutaogongxuEntity> page = this.selectPage(
                new Query<HutaogongxuEntity>(params).getPage(),
                new EntityWrapper<HutaogongxuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HutaogongxuEntity> wrapper) {
		  Page<HutaogongxuView> page =new Query<HutaogongxuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<HutaogongxuView> selectListView(Wrapper<HutaogongxuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HutaogongxuView selectView(Wrapper<HutaogongxuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
