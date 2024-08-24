package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.JianyangongxuEntity;
import com.cl.entity.view.JianyangongxuView;

import com.cl.service.JianyangongxuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 检验工序
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-08 17:40:03
 */
@RestController
@RequestMapping("/jianyangongxu")
public class JianyangongxuController {
    @Autowired
    private JianyangongxuService jianyangongxuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JianyangongxuEntity jianyangongxu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yuangong")) {
			jianyangongxu.setGonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JianyangongxuEntity> ew = new EntityWrapper<JianyangongxuEntity>();

		PageUtils page = jianyangongxuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianyangongxu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JianyangongxuEntity jianyangongxu, 
		HttpServletRequest request){
        EntityWrapper<JianyangongxuEntity> ew = new EntityWrapper<JianyangongxuEntity>();

		PageUtils page = jianyangongxuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianyangongxu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JianyangongxuEntity jianyangongxu){
       	EntityWrapper<JianyangongxuEntity> ew = new EntityWrapper<JianyangongxuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jianyangongxu, "jianyangongxu")); 
        return R.ok().put("data", jianyangongxuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JianyangongxuEntity jianyangongxu){
        EntityWrapper< JianyangongxuEntity> ew = new EntityWrapper< JianyangongxuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jianyangongxu, "jianyangongxu")); 
		JianyangongxuView jianyangongxuView =  jianyangongxuService.selectView(ew);
		return R.ok("查询检验工序成功").put("data", jianyangongxuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JianyangongxuEntity jianyangongxu = jianyangongxuService.selectById(id);
		jianyangongxu = jianyangongxuService.selectView(new EntityWrapper<JianyangongxuEntity>().eq("id", id));
        return R.ok().put("data", jianyangongxu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JianyangongxuEntity jianyangongxu = jianyangongxuService.selectById(id);
		jianyangongxu = jianyangongxuService.selectView(new EntityWrapper<JianyangongxuEntity>().eq("id", id));
        return R.ok().put("data", jianyangongxu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JianyangongxuEntity jianyangongxu, HttpServletRequest request){
    	jianyangongxu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jianyangongxu);
        jianyangongxuService.insert(jianyangongxu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JianyangongxuEntity jianyangongxu, HttpServletRequest request){
    	jianyangongxu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jianyangongxu);
        jianyangongxuService.insert(jianyangongxu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JianyangongxuEntity jianyangongxu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jianyangongxu);
        jianyangongxuService.updateById(jianyangongxu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jianyangongxuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
