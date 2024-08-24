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


import com.cl.dao.JueyuangongxuDao;
import com.cl.entity.JueyuangongxuEntity;
import com.cl.service.JueyuangongxuService;
import com.cl.entity.view.JueyuangongxuView;

@Service("jueyuangongxuService")
public class JueyuangongxuServiceImpl extends ServiceImpl<JueyuangongxuDao, JueyuangongxuEntity> implements JueyuangongxuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JueyuangongxuEntity> page = this.selectPage(
                new Query<JueyuangongxuEntity>(params).getPage(),
                new EntityWrapper<JueyuangongxuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JueyuangongxuEntity> wrapper) {
		  Page<JueyuangongxuView> page =new Query<JueyuangongxuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JueyuangongxuView> selectListView(Wrapper<JueyuangongxuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JueyuangongxuView selectView(Wrapper<JueyuangongxuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
