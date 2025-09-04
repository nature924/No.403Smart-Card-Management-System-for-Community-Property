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
 * 费用信息
 *
 * @author 
 * @email
 */
@TableName("feiyong")
public class FeiyongEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FeiyongEntity() {

	}

	public FeiyongEntity(T t) {
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
     * 标题
     */
    @TableField(value = "feiyong_name")

    private String feiyongName;


    /**
     * 费用类型
     */
    @TableField(value = "feiyong_types")

    private Integer feiyongTypes;


    /**
     * 涉及金额
     */
    @TableField(value = "feiyong_money")

    private Double feiyongMoney;


    /**
     * 业主
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 收费结果
     */
    @TableField(value = "renyuan_jieguo")

    private String renyuanJieguo;


    /**
     * 详情
     */
    @TableField(value = "feiyong_content")

    private String feiyongContent;


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
	 * 设置：标题
	 */
    public String getFeiyongName() {
        return feiyongName;
    }
    /**
	 * 获取：标题
	 */

    public void setFeiyongName(String feiyongName) {
        this.feiyongName = feiyongName;
    }
    /**
	 * 设置：费用类型
	 */
    public Integer getFeiyongTypes() {
        return feiyongTypes;
    }
    /**
	 * 获取：费用类型
	 */

    public void setFeiyongTypes(Integer feiyongTypes) {
        this.feiyongTypes = feiyongTypes;
    }
    /**
	 * 设置：涉及金额
	 */
    public Double getFeiyongMoney() {
        return feiyongMoney;
    }
    /**
	 * 获取：涉及金额
	 */

    public void setFeiyongMoney(Double feiyongMoney) {
        this.feiyongMoney = feiyongMoney;
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
	 * 设置：收费结果
	 */
    public String getRenyuanJieguo() {
        return renyuanJieguo;
    }
    /**
	 * 获取：收费结果
	 */

    public void setRenyuanJieguo(String renyuanJieguo) {
        this.renyuanJieguo = renyuanJieguo;
    }
    /**
	 * 设置：详情
	 */
    public String getFeiyongContent() {
        return feiyongContent;
    }
    /**
	 * 获取：详情
	 */

    public void setFeiyongContent(String feiyongContent) {
        this.feiyongContent = feiyongContent;
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
        return "Feiyong{" +
            "id=" + id +
            ", feiyongName=" + feiyongName +
            ", feiyongTypes=" + feiyongTypes +
            ", feiyongMoney=" + feiyongMoney +
            ", yonghuId=" + yonghuId +
            ", renyuanJieguo=" + renyuanJieguo +
            ", feiyongContent=" + feiyongContent +
            ", createTime=" + createTime +
        "}";
    }
}
