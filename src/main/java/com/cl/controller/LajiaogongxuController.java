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

import com.cl.entity.LajiaogongxuEntity;
import com.cl.entity.view.LajiaogongxuView;

import com.cl.service.LajiaogongxuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 拉绞工序
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-08 17:40:02
 */
@RestController
@RequestMapping("/lajiaogongxu")
public class LajiaogongxuController {
    @Autowired
    private LajiaogongxuService lajiaogongxuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LajiaogongxuEntity lajiaogongxu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yuangong")) {
			lajiaogongxu.setGonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<LajiaogongxuEntity> ew = new EntityWrapper<LajiaogongxuEntity>();

		PageUtils page = lajiaogongxuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lajiaogongxu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LajiaogongxuEntity lajiaogongxu, 
		HttpServletRequest request){
        EntityWrapper<LajiaogongxuEntity> ew = new EntityWrapper<LajiaogongxuEntity>();

		PageUtils page = lajiaogongxuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lajiaogongxu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LajiaogongxuEntity lajiaogongxu){
       	EntityWrapper<LajiaogongxuEntity> ew = new EntityWrapper<LajiaogongxuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( lajiaogongxu, "lajiaogongxu")); 
        return R.ok().put("data", lajiaogongxuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LajiaogongxuEntity lajiaogongxu){
        EntityWrapper< LajiaogongxuEntity> ew = new EntityWrapper< LajiaogongxuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( lajiaogongxu, "lajiaogongxu")); 
		LajiaogongxuView lajiaogongxuView =  lajiaogongxuService.selectView(ew);
		return R.ok("查询拉绞工序成功").put("data", lajiaogongxuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LajiaogongxuEntity lajiaogongxu = lajiaogongxuService.selectById(id);
		lajiaogongxu = lajiaogongxuService.selectView(new EntityWrapper<LajiaogongxuEntity>().eq("id", id));
        return R.ok().put("data", lajiaogongxu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LajiaogongxuEntity lajiaogongxu = lajiaogongxuService.selectById(id);
		lajiaogongxu = lajiaogongxuService.selectView(new EntityWrapper<LajiaogongxuEntity>().eq("id", id));
        return R.ok().put("data", lajiaogongxu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LajiaogongxuEntity lajiaogongxu, HttpServletRequest request){
    	lajiaogongxu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(lajiaogongxu);
        lajiaogongxuService.insert(lajiaogongxu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LajiaogongxuEntity lajiaogongxu, HttpServletRequest request){
    	lajiaogongxu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(lajiaogongxu);
        lajiaogongxuService.insert(lajiaogongxu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody LajiaogongxuEntity lajiaogongxu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(lajiaogongxu);
        lajiaogongxuService.updateById(lajiaogongxu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        lajiaogongxuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
