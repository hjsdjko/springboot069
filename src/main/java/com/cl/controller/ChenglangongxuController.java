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

import com.cl.entity.ChenglangongxuEntity;
import com.cl.entity.view.ChenglangongxuView;

import com.cl.service.ChenglangongxuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 成缆工序
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-08 17:40:02
 */
@RestController
@RequestMapping("/chenglangongxu")
public class ChenglangongxuController {
    @Autowired
    private ChenglangongxuService chenglangongxuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChenglangongxuEntity chenglangongxu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yuangong")) {
			chenglangongxu.setGonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ChenglangongxuEntity> ew = new EntityWrapper<ChenglangongxuEntity>();

		PageUtils page = chenglangongxuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chenglangongxu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChenglangongxuEntity chenglangongxu, 
		HttpServletRequest request){
        EntityWrapper<ChenglangongxuEntity> ew = new EntityWrapper<ChenglangongxuEntity>();

		PageUtils page = chenglangongxuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chenglangongxu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChenglangongxuEntity chenglangongxu){
       	EntityWrapper<ChenglangongxuEntity> ew = new EntityWrapper<ChenglangongxuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( chenglangongxu, "chenglangongxu")); 
        return R.ok().put("data", chenglangongxuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChenglangongxuEntity chenglangongxu){
        EntityWrapper< ChenglangongxuEntity> ew = new EntityWrapper< ChenglangongxuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( chenglangongxu, "chenglangongxu")); 
		ChenglangongxuView chenglangongxuView =  chenglangongxuService.selectView(ew);
		return R.ok("查询成缆工序成功").put("data", chenglangongxuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChenglangongxuEntity chenglangongxu = chenglangongxuService.selectById(id);
		chenglangongxu = chenglangongxuService.selectView(new EntityWrapper<ChenglangongxuEntity>().eq("id", id));
        return R.ok().put("data", chenglangongxu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChenglangongxuEntity chenglangongxu = chenglangongxuService.selectById(id);
		chenglangongxu = chenglangongxuService.selectView(new EntityWrapper<ChenglangongxuEntity>().eq("id", id));
        return R.ok().put("data", chenglangongxu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChenglangongxuEntity chenglangongxu, HttpServletRequest request){
    	chenglangongxu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chenglangongxu);
        chenglangongxuService.insert(chenglangongxu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChenglangongxuEntity chenglangongxu, HttpServletRequest request){
    	chenglangongxu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chenglangongxu);
        chenglangongxuService.insert(chenglangongxu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChenglangongxuEntity chenglangongxu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chenglangongxu);
        chenglangongxuService.updateById(chenglangongxu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        chenglangongxuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
