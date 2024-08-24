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
 * 成缆工序
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-08 17:40:02
 */
@TableName("chenglangongxu")
public class ChenglangongxuEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ChenglangongxuEntity() {
		
	}
	
	public ChenglangongxuEntity(T t) {
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
	 * 订单编号
	 */
					
	private String dingdanbianhao;
	
	/**
	 * 创建日期
	 */
					
	private String chuangjianriqi;
	
	/**
	 * 交付日期
	 */
					
	private String jiaofuriqi;
	
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
	 * 上工序完成长度
	 */
					
	private String shanggongxuwanchengzhangdu;
	
	/**
	 * 本工序完成长度
	 */
					
	private String bengongxuwanchengzhangdu;
	
	/**
	 * 所用材料统计
	 */
					
	private String suoyongcailiaotongji;
	
	/**
	 * 是否完成
	 */
					
	private String shifouwancheng;
	
	/**
	 * 工号
	 */
					
	private String gonghao;
	
	/**
	 * 操作员工
	 */
					
	private String xingming;
	
	/**
	 * 完成日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date wanchengriqi;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	
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
	 * 设置：订单编号
	 */
	public void setDingdanbianhao(String dingdanbianhao) {
		this.dingdanbianhao = dingdanbianhao;
	}
	/**
	 * 获取：订单编号
	 */
	public String getDingdanbianhao() {
		return dingdanbianhao;
	}
	/**
	 * 设置：创建日期
	 */
	public void setChuangjianriqi(String chuangjianriqi) {
		this.chuangjianriqi = chuangjianriqi;
	}
	/**
	 * 获取：创建日期
	 */
	public String getChuangjianriqi() {
		return chuangjianriqi;
	}
	/**
	 * 设置：交付日期
	 */
	public void setJiaofuriqi(String jiaofuriqi) {
		this.jiaofuriqi = jiaofuriqi;
	}
	/**
	 * 获取：交付日期
	 */
	public String getJiaofuriqi() {
		return jiaofuriqi;
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
	 * 设置：上工序完成长度
	 */
	public void setShanggongxuwanchengzhangdu(String shanggongxuwanchengzhangdu) {
		this.shanggongxuwanchengzhangdu = shanggongxuwanchengzhangdu;
	}
	/**
	 * 获取：上工序完成长度
	 */
	public String getShanggongxuwanchengzhangdu() {
		return shanggongxuwanchengzhangdu;
	}
	/**
	 * 设置：本工序完成长度
	 */
	public void setBengongxuwanchengzhangdu(String bengongxuwanchengzhangdu) {
		this.bengongxuwanchengzhangdu = bengongxuwanchengzhangdu;
	}
	/**
	 * 获取：本工序完成长度
	 */
	public String getBengongxuwanchengzhangdu() {
		return bengongxuwanchengzhangdu;
	}
	/**
	 * 设置：所用材料统计
	 */
	public void setSuoyongcailiaotongji(String suoyongcailiaotongji) {
		this.suoyongcailiaotongji = suoyongcailiaotongji;
	}
	/**
	 * 获取：所用材料统计
	 */
	public String getSuoyongcailiaotongji() {
		return suoyongcailiaotongji;
	}
	/**
	 * 设置：是否完成
	 */
	public void setShifouwancheng(String shifouwancheng) {
		this.shifouwancheng = shifouwancheng;
	}
	/**
	 * 获取：是否完成
	 */
	public String getShifouwancheng() {
		return shifouwancheng;
	}
	/**
	 * 设置：工号
	 */
	public void setGonghao(String gonghao) {
		this.gonghao = gonghao;
	}
	/**
	 * 获取：工号
	 */
	public String getGonghao() {
		return gonghao;
	}
	/**
	 * 设置：操作员工
	 */
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	/**
	 * 获取：操作员工
	 */
	public String getXingming() {
		return xingming;
	}
	/**
	 * 设置：完成日期
	 */
	public void setWanchengriqi(Date wanchengriqi) {
		this.wanchengriqi = wanchengriqi;
	}
	/**
	 * 获取：完成日期
	 */
	public Date getWanchengriqi() {
		return wanchengriqi;
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

}
