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

import com.cl.entity.ShengchanjihuaEntity;
import com.cl.entity.view.ShengchanjihuaView;

import com.cl.service.ShengchanjihuaService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 生产计划
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-08 17:40:02
 */
@RestController
@RequestMapping("/shengchanjihua")
public class ShengchanjihuaController {
    @Autowired
    private ShengchanjihuaService shengchanjihuaService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShengchanjihuaEntity shengchanjihua,
		HttpServletRequest request){
        EntityWrapper<ShengchanjihuaEntity> ew = new EntityWrapper<ShengchanjihuaEntity>();

		PageUtils page = shengchanjihuaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shengchanjihua), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShengchanjihuaEntity shengchanjihua, 
		HttpServletRequest request){
        EntityWrapper<ShengchanjihuaEntity> ew = new EntityWrapper<ShengchanjihuaEntity>();

		PageUtils page = shengchanjihuaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shengchanjihua), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShengchanjihuaEntity shengchanjihua){
       	EntityWrapper<ShengchanjihuaEntity> ew = new EntityWrapper<ShengchanjihuaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shengchanjihua, "shengchanjihua")); 
        return R.ok().put("data", shengchanjihuaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShengchanjihuaEntity shengchanjihua){
        EntityWrapper< ShengchanjihuaEntity> ew = new EntityWrapper< ShengchanjihuaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shengchanjihua, "shengchanjihua")); 
		ShengchanjihuaView shengchanjihuaView =  shengchanjihuaService.selectView(ew);
		return R.ok("查询生产计划成功").put("data", shengchanjihuaView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShengchanjihuaEntity shengchanjihua = shengchanjihuaService.selectById(id);
		shengchanjihua = shengchanjihuaService.selectView(new EntityWrapper<ShengchanjihuaEntity>().eq("id", id));
        return R.ok().put("data", shengchanjihua);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShengchanjihuaEntity shengchanjihua = shengchanjihuaService.selectById(id);
		shengchanjihua = shengchanjihuaService.selectView(new EntityWrapper<ShengchanjihuaEntity>().eq("id", id));
        return R.ok().put("data", shengchanjihua);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShengchanjihuaEntity shengchanjihua, HttpServletRequest request){
    	shengchanjihua.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shengchanjihua);
        shengchanjihuaService.insert(shengchanjihua);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShengchanjihuaEntity shengchanjihua, HttpServletRequest request){
    	shengchanjihua.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shengchanjihua);
        shengchanjihuaService.insert(shengchanjihua);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShengchanjihuaEntity shengchanjihua, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shengchanjihua);
        shengchanjihuaService.updateById(shengchanjihua);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shengchanjihuaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
