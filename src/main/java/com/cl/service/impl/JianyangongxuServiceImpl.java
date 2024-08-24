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


import com.cl.dao.JianyangongxuDao;
import com.cl.entity.JianyangongxuEntity;
import com.cl.service.JianyangongxuService;
import com.cl.entity.view.JianyangongxuView;

@Service("jianyangongxuService")
public class JianyangongxuServiceImpl extends ServiceImpl<JianyangongxuDao, JianyangongxuEntity> implements JianyangongxuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JianyangongxuEntity> page = this.selectPage(
                new Query<JianyangongxuEntity>(params).getPage(),
                new EntityWrapper<JianyangongxuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JianyangongxuEntity> wrapper) {
		  Page<JianyangongxuView> page =new Query<JianyangongxuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JianyangongxuView> selectListView(Wrapper<JianyangongxuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JianyangongxuView selectView(Wrapper<JianyangongxuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
