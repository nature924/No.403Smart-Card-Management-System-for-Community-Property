package com.entity;

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
 * 业主服务
 *
 * @author 
 * @email
 */
@TableName("yezhufuwu")
public class YezhufuwuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YezhufuwuEntity() {

	}

	public YezhufuwuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 业主
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 服务标题
     */
    @TableField(value = "yezhufuwu_name")

    private String yezhufuwuName;


    /**
     * 服务类型
     */
    @TableField(value = "yezhufuwu_types")

    private Integer yezhufuwuTypes;


    /**
     * 详情
     */
    @TableField(value = "yezhufuwu_content")

    private String yezhufuwuContent;


    /**
     * 处理状态
     */
    @TableField(value = "yezhufuwu_yesno_types")

    private Integer yezhufuwuYesnoTypes;


    /**
     * 处理结果
     */
    @TableField(value = "yezhufuwu_yesno_text")

    private String yezhufuwuYesnoText;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：业主
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 获取：业主
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：服务标题
	 */
    public String getYezhufuwuName() {
        return yezhufuwuName;
    }
    /**
	 * 获取：服务标题
	 */

    public void setYezhufuwuName(String yezhufuwuName) {
        this.yezhufuwuName = yezhufuwuName;
    }
    /**
	 * 设置：服务类型
	 */
    public Integer getYezhufuwuTypes() {
        return yezhufuwuTypes;
    }
    /**
	 * 获取：服务类型
	 */

    public void setYezhufuwuTypes(Integer yezhufuwuTypes) {
        this.yezhufuwuTypes = yezhufuwuTypes;
    }
    /**
	 * 设置：详情
	 */
    public String getYezhufuwuContent() {
        return yezhufuwuContent;
    }
    /**
	 * 获取：详情
	 */

    public void setYezhufuwuContent(String yezhufuwuContent) {
        this.yezhufuwuContent = yezhufuwuContent;
    }
    /**
	 * 设置：处理状态
	 */
    public Integer getYezhufuwuYesnoTypes() {
        return yezhufuwuYesnoTypes;
    }
    /**
	 * 获取：处理状态
	 */

    public void setYezhufuwuYesnoTypes(Integer yezhufuwuYesnoTypes) {
        this.yezhufuwuYesnoTypes = yezhufuwuYesnoTypes;
    }
    /**
	 * 设置：处理结果
	 */
    public String getYezhufuwuYesnoText() {
        return yezhufuwuYesnoText;
    }
    /**
	 * 获取：处理结果
	 */

    public void setYezhufuwuYesnoText(String yezhufuwuYesnoText) {
        this.yezhufuwuYesnoText = yezhufuwuYesnoText;
    }
    /**
	 * 设置：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Yezhufuwu{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", yezhufuwuName=" + yezhufuwuName +
            ", yezhufuwuTypes=" + yezhufuwuTypes +
            ", yezhufuwuContent=" + yezhufuwuContent +
            ", yezhufuwuYesnoTypes=" + yezhufuwuYesnoTypes +
            ", yezhufuwuYesnoText=" + yezhufuwuYesnoText +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
