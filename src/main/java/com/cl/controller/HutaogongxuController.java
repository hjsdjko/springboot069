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

import com.cl.entity.HutaogongxuEntity;
import com.cl.entity.view.HutaogongxuView;

import com.cl.service.HutaogongxuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 护套工序
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-08 17:40:03
 */
@RestController
@RequestMapping("/hutaogongxu")
public class HutaogongxuController {
    @Autowired
    private HutaogongxuService hutaogongxuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HutaogongxuEntity hutaogongxu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yuangong")) {
			hutaogongxu.setGonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<HutaogongxuEntity> ew = new EntityWrapper<HutaogongxuEntity>();

		PageUtils page = hutaogongxuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, hutaogongxu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HutaogongxuEntity hutaogongxu, 
		HttpServletRequest request){
        EntityWrapper<HutaogongxuEntity> ew = new EntityWrapper<HutaogongxuEntity>();

		PageUtils page = hutaogongxuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, hutaogongxu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HutaogongxuEntity hutaogongxu){
       	EntityWrapper<HutaogongxuEntity> ew = new EntityWrapper<HutaogongxuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( hutaogongxu, "hutaogongxu")); 
        return R.ok().put("data", hutaogongxuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HutaogongxuEntity hutaogongxu){
        EntityWrapper< HutaogongxuEntity> ew = new EntityWrapper< HutaogongxuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( hutaogongxu, "hutaogongxu")); 
		HutaogongxuView hutaogongxuView =  hutaogongxuService.selectView(ew);
		return R.ok("查询护套工序成功").put("data", hutaogongxuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HutaogongxuEntity hutaogongxu = hutaogongxuService.selectById(id);
		hutaogongxu = hutaogongxuService.selectView(new EntityWrapper<HutaogongxuEntity>().eq("id", id));
        return R.ok().put("data", hutaogongxu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HutaogongxuEntity hutaogongxu = hutaogongxuService.selectById(id);
		hutaogongxu = hutaogongxuService.selectView(new EntityWrapper<HutaogongxuEntity>().eq("id", id));
        return R.ok().put("data", hutaogongxu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HutaogongxuEntity hutaogongxu, HttpServletRequest request){
    	hutaogongxu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(hutaogongxu);
        hutaogongxuService.insert(hutaogongxu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HutaogongxuEntity hutaogongxu, HttpServletRequest request){
    	hutaogongxu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(hutaogongxu);
        hutaogongxuService.insert(hutaogongxu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody HutaogongxuEntity hutaogongxu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(hutaogongxu);
        hutaogongxuService.updateById(hutaogongxu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        hutaogongxuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
