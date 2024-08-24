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

import com.cl.entity.JueyuangongxuEntity;
import com.cl.entity.view.JueyuangongxuView;

import com.cl.service.JueyuangongxuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 绝缘工序
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-08 17:40:02
 */
@RestController
@RequestMapping("/jueyuangongxu")
public class JueyuangongxuController {
    @Autowired
    private JueyuangongxuService jueyuangongxuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JueyuangongxuEntity jueyuangongxu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yuangong")) {
			jueyuangongxu.setGonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JueyuangongxuEntity> ew = new EntityWrapper<JueyuangongxuEntity>();

		PageUtils page = jueyuangongxuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jueyuangongxu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JueyuangongxuEntity jueyuangongxu, 
		HttpServletRequest request){
        EntityWrapper<JueyuangongxuEntity> ew = new EntityWrapper<JueyuangongxuEntity>();

		PageUtils page = jueyuangongxuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jueyuangongxu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JueyuangongxuEntity jueyuangongxu){
       	EntityWrapper<JueyuangongxuEntity> ew = new EntityWrapper<JueyuangongxuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jueyuangongxu, "jueyuangongxu")); 
        return R.ok().put("data", jueyuangongxuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JueyuangongxuEntity jueyuangongxu){
        EntityWrapper< JueyuangongxuEntity> ew = new EntityWrapper< JueyuangongxuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jueyuangongxu, "jueyuangongxu")); 
		JueyuangongxuView jueyuangongxuView =  jueyuangongxuService.selectView(ew);
		return R.ok("查询绝缘工序成功").put("data", jueyuangongxuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JueyuangongxuEntity jueyuangongxu = jueyuangongxuService.selectById(id);
		jueyuangongxu = jueyuangongxuService.selectView(new EntityWrapper<JueyuangongxuEntity>().eq("id", id));
        return R.ok().put("data", jueyuangongxu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JueyuangongxuEntity jueyuangongxu = jueyuangongxuService.selectById(id);
		jueyuangongxu = jueyuangongxuService.selectView(new EntityWrapper<JueyuangongxuEntity>().eq("id", id));
        return R.ok().put("data", jueyuangongxu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JueyuangongxuEntity jueyuangongxu, HttpServletRequest request){
    	jueyuangongxu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jueyuangongxu);
        jueyuangongxuService.insert(jueyuangongxu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JueyuangongxuEntity jueyuangongxu, HttpServletRequest request){
    	jueyuangongxu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jueyuangongxu);
        jueyuangongxuService.insert(jueyuangongxu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JueyuangongxuEntity jueyuangongxu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jueyuangongxu);
        jueyuangongxuService.updateById(jueyuangongxu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jueyuangongxuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
