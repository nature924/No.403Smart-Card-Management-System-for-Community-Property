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
 * 停车登记
 *
 * @author 
 * @email
 */
@TableName("cheliangruku")
public class CheliangrukuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public CheliangrukuEntity() {

	}

	public CheliangrukuEntity(T t) {
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
     * 车辆单位
     */
    @TableField(value = "cheliangruku_name")

    private String cheliangrukuName;


    /**
     * 车辆颜色
     */
    @TableField(value = "cheliangruku_yanse")

    private String cheliangrukuYanse;


    /**
     * 车辆状态
     */
    @TableField(value = "cheliangruku_types")

    private Integer cheliangrukuTypes;


    /**
     * 出入类型
     */
    @TableField(value = "churu_types")

    private Integer churuTypes;


    /**
     * 业主
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 出入库时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "cheliangruku_time")

    private Date cheliangrukuTime;


    /**
     * 车辆详情
     */
    @TableField(value = "cheliangruku_content")

    private String cheliangrukuContent;


    /**
     * 记录时间
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
	 * 设置：车辆单位
	 */
    public String getCheliangrukuName() {
        return cheliangrukuName;
    }
    /**
	 * 获取：车辆单位
	 */

    public void setCheliangrukuName(String cheliangrukuName) {
        this.cheliangrukuName = cheliangrukuName;
    }
    /**
	 * 设置：车辆颜色
	 */
    public String getCheliangrukuYanse() {
        return cheliangrukuYanse;
    }
    /**
	 * 获取：车辆颜色
	 */

    public void setCheliangrukuYanse(String cheliangrukuYanse) {
        this.cheliangrukuYanse = cheliangrukuYanse;
    }
    /**
	 * 设置：车辆状态
	 */
    public Integer getCheliangrukuTypes() {
        return cheliangrukuTypes;
    }
    /**
	 * 获取：车辆状态
	 */

    public void setCheliangrukuTypes(Integer cheliangrukuTypes) {
        this.cheliangrukuTypes = cheliangrukuTypes;
    }
    /**
	 * 设置：出入类型
	 */
    public Integer getChuruTypes() {
        return churuTypes;
    }
    /**
	 * 获取：出入类型
	 */

    public void setChuruTypes(Integer churuTypes) {
        this.churuTypes = churuTypes;
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
	 * 设置：出入库时间
	 */
    public Date getCheliangrukuTime() {
        return cheliangrukuTime;
    }
    /**
	 * 获取：出入库时间
	 */

    public void setCheliangrukuTime(Date cheliangrukuTime) {
        this.cheliangrukuTime = cheliangrukuTime;
    }
    /**
	 * 设置：车辆详情
	 */
    public String getCheliangrukuContent() {
        return cheliangrukuContent;
    }
    /**
	 * 获取：车辆详情
	 */

    public void setCheliangrukuContent(String cheliangrukuContent) {
        this.cheliangrukuContent = cheliangrukuContent;
    }
    /**
	 * 设置：记录时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：记录时间
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
        return "Cheliangruku{" +
            "id=" + id +
            ", cheliangrukuName=" + cheliangrukuName +
            ", cheliangrukuYanse=" + cheliangrukuYanse +
            ", cheliangrukuTypes=" + cheliangrukuTypes +
            ", churuTypes=" + churuTypes +
            ", yonghuId=" + yonghuId +
            ", cheliangrukuTime=" + cheliangrukuTime +
            ", cheliangrukuContent=" + cheliangrukuContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
