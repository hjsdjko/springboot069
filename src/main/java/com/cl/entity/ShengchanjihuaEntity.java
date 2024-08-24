package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 生产计划
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-08 17:40:02
 */
@TableName("shengchanjihua")
public class ShengchanjihuaEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ShengchanjihuaEntity() {
		
	}
	
	public ShengchanjihuaEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 编号
	 */
					
	private String bianhao;
	
	/**
	 * 创建日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date chuangjianriqi;
	
	/**
	 * 产品型号
	 */
					
	private String chanpinxinghao;
	
	/**
	 * 所需规格
	 */
					
	private String suoxuguige;
	
	/**
	 * 电压伏级
	 */
					
	private String dianyafuji;
	
	/**
	 * 所需长度
	 */
					
	private String suoxuzhangdu;
	
	/**
	 * 交付日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date jiaofuriqi;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	/**
	 * 详情
	 */
					
	private String xiangqing;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：编号
	 */
	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}
	/**
	 * 获取：编号
	 */
	public String getBianhao() {
		return bianhao;
	}
	/**
	 * 设置：创建日期
	 */
	public void setChuangjianriqi(Date chuangjianriqi) {
		this.chuangjianriqi = chuangjianriqi;
	}
	/**
	 * 获取：创建日期
	 */
	public Date getChuangjianriqi() {
		return chuangjianriqi;
	}
	/**
	 * 设置：产品型号
	 */
	public void setChanpinxinghao(String chanpinxinghao) {
		this.chanpinxinghao = chanpinxinghao;
	}
	/**
	 * 获取：产品型号
	 */
	public String getChanpinxinghao() {
		return chanpinxinghao;
	}
	/**
	 * 设置：所需规格
	 */
	public void setSuoxuguige(String suoxuguige) {
		this.suoxuguige = suoxuguige;
	}
	/**
	 * 获取：所需规格
	 */
	public String getSuoxuguige() {
		return suoxuguige;
	}
	/**
	 * 设置：电压伏级
	 */
	public void setDianyafuji(String dianyafuji) {
		this.dianyafuji = dianyafuji;
	}
	/**
	 * 获取：电压伏级
	 */
	public String getDianyafuji() {
		return dianyafuji;
	}
	/**
	 * 设置：所需长度
	 */
	public void setSuoxuzhangdu(String suoxuzhangdu) {
		this.suoxuzhangdu = suoxuzhangdu;
	}
	/**
	 * 获取：所需长度
	 */
	public String getSuoxuzhangdu() {
		return suoxuzhangdu;
	}
	/**
	 * 设置：交付日期
	 */
	public void setJiaofuriqi(Date jiaofuriqi) {
		this.jiaofuriqi = jiaofuriqi;
	}
	/**
	 * 获取：交付日期
	 */
	public Date getJiaofuriqi() {
		return jiaofuriqi;
	}
	/**
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
	/**
	 * 设置：详情
	 */
	public void setXiangqing(String xiangqing) {
		this.xiangqing = xiangqing;
	}
	/**
	 * 获取：详情
	 */
	public String getXiangqing() {
		return xiangqing;
	}

}
