package com.entity.view;

import com.entity.CheliangrukuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 停车登记
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("cheliangruku")
public class CheliangrukuView extends CheliangrukuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 车辆状态的值
		*/
		private String cheliangrukuValue;
		/**
		* 出入类型的值
		*/
		private String churuValue;



		//级联表 yonghu
			/**
			* 业主姓名
			*/
			private String yonghuName;
			/**
			* 头像
			*/
			private String yonghuPhoto;
			/**
			* 手机号
			*/
			private String yonghuPhone;
			/**
			* 电子邮箱
			*/
			private String yonghuEmail;
			/**
			* 假删
			*/
			private Integer yonghuDelete;

	public CheliangrukuView() {

	}

	public CheliangrukuView(CheliangrukuEntity cheliangrukuEntity) {
		try {
			BeanUtils.copyProperties(this, cheliangrukuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 车辆状态的值
			*/
			public String getCheliangrukuValue() {
				return cheliangrukuValue;
			}
			/**
			* 设置： 车辆状态的值
			*/
			public void setCheliangrukuValue(String cheliangrukuValue) {
				this.cheliangrukuValue = cheliangrukuValue;
			}
			/**
			* 获取： 出入类型的值
			*/
			public String getChuruValue() {
				return churuValue;
			}
			/**
			* 设置： 出入类型的值
			*/
			public void setChuruValue(String churuValue) {
				this.churuValue = churuValue;
			}


















				//级联表的get和set yonghu

					/**
					* 获取： 业主姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 业主姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}

					/**
					* 获取： 手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}

					/**
					* 获取： 假删
					*/
					public Integer getYonghuDelete() {
						return yonghuDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setYonghuDelete(Integer yonghuDelete) {
						this.yonghuDelete = yonghuDelete;
					}


}
