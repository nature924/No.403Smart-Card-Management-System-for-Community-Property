package com.entity.view;

import com.entity.YezhufuwuCommentbackEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 服务评价
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("yezhufuwu_commentback")
public class YezhufuwuCommentbackView extends YezhufuwuCommentbackEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 yezhufuwu
			/**
			* 业主服务 的 业主
			*/
			private Integer yezhufuwuYonghuId;
			/**
			* 服务标题
			*/
			private String yezhufuwuName;
			/**
			* 服务类型
			*/
			private Integer yezhufuwuTypes;
				/**
				* 服务类型的值
				*/
				private String yezhufuwuValue;
			/**
			* 详情
			*/
			private String yezhufuwuContent;
			/**
			* 处理状态
			*/
			private Integer yezhufuwuYesnoTypes;
				/**
				* 处理状态的值
				*/
				private String yezhufuwuYesnoValue;
			/**
			* 处理结果
			*/
			private String yezhufuwuYesnoText;

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

	public YezhufuwuCommentbackView() {

	}

	public YezhufuwuCommentbackView(YezhufuwuCommentbackEntity yezhufuwuCommentbackEntity) {
		try {
			BeanUtils.copyProperties(this, yezhufuwuCommentbackEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}






















				//级联表的get和set yezhufuwu

					/**
					* 获取：业主服务 的 业主
					*/
					public Integer getYezhufuwuYonghuId() {
						return yezhufuwuYonghuId;
					}
					/**
					* 设置：业主服务 的 业主
					*/
					public void setYezhufuwuYonghuId(Integer yezhufuwuYonghuId) {
						this.yezhufuwuYonghuId = yezhufuwuYonghuId;
					}


					/**
					* 获取： 服务标题
					*/
					public String getYezhufuwuName() {
						return yezhufuwuName;
					}
					/**
					* 设置： 服务标题
					*/
					public void setYezhufuwuName(String yezhufuwuName) {
						this.yezhufuwuName = yezhufuwuName;
					}

					/**
					* 获取： 服务类型
					*/
					public Integer getYezhufuwuTypes() {
						return yezhufuwuTypes;
					}
					/**
					* 设置： 服务类型
					*/
					public void setYezhufuwuTypes(Integer yezhufuwuTypes) {
						this.yezhufuwuTypes = yezhufuwuTypes;
					}


						/**
						* 获取： 服务类型的值
						*/
						public String getYezhufuwuValue() {
							return yezhufuwuValue;
						}
						/**
						* 设置： 服务类型的值
						*/
						public void setYezhufuwuValue(String yezhufuwuValue) {
							this.yezhufuwuValue = yezhufuwuValue;
						}

					/**
					* 获取： 详情
					*/
					public String getYezhufuwuContent() {
						return yezhufuwuContent;
					}
					/**
					* 设置： 详情
					*/
					public void setYezhufuwuContent(String yezhufuwuContent) {
						this.yezhufuwuContent = yezhufuwuContent;
					}

					/**
					* 获取： 处理状态
					*/
					public Integer getYezhufuwuYesnoTypes() {
						return yezhufuwuYesnoTypes;
					}
					/**
					* 设置： 处理状态
					*/
					public void setYezhufuwuYesnoTypes(Integer yezhufuwuYesnoTypes) {
						this.yezhufuwuYesnoTypes = yezhufuwuYesnoTypes;
					}


						/**
						* 获取： 处理状态的值
						*/
						public String getYezhufuwuYesnoValue() {
							return yezhufuwuYesnoValue;
						}
						/**
						* 设置： 处理状态的值
						*/
						public void setYezhufuwuYesnoValue(String yezhufuwuYesnoValue) {
							this.yezhufuwuYesnoValue = yezhufuwuYesnoValue;
						}

					/**
					* 获取： 处理结果
					*/
					public String getYezhufuwuYesnoText() {
						return yezhufuwuYesnoText;
					}
					/**
					* 设置： 处理结果
					*/
					public void setYezhufuwuYesnoText(String yezhufuwuYesnoText) {
						this.yezhufuwuYesnoText = yezhufuwuYesnoText;
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
