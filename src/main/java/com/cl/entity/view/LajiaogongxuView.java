package com.cl.entity.view;

import com.cl.entity.LajiaogongxuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 拉绞工序
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-08 17:40:02
 */
@TableName("lajiaogongxu")
public class LajiaogongxuView  extends LajiaogongxuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LajiaogongxuView(){
	}
 
 	public LajiaogongxuView(LajiaogongxuEntity lajiaogongxuEntity){
 	try {
			BeanUtils.copyProperties(this, lajiaogongxuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
