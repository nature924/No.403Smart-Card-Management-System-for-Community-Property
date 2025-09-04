package com.entity.model;

import com.entity.YezhufuwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 业主服务
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YezhufuwuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 业主
     */
    private Integer yonghuId;


    /**
     * 服务标题
     */
    private String yezhufuwuName;


    /**
     * 服务类型
     */
    private Integer yezhufuwuTypes;


    /**
     * 详情
     */
    private String yezhufuwuContent;


    /**
     * 处理状态
     */
    private Integer yezhufuwuYesnoTypes;


    /**
     * 处理结果
     */
    private String yezhufuwuYesnoText;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：业主
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：业主
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：服务标题
	 */
    public String getYezhufuwuName() {
        return yezhufuwuName;
    }


    /**
	 * 设置：服务标题
	 */
    public void setYezhufuwuName(String yezhufuwuName) {
        this.yezhufuwuName = yezhufuwuName;
    }
    /**
	 * 获取：服务类型
	 */
    public Integer getYezhufuwuTypes() {
        return yezhufuwuTypes;
    }


    /**
	 * 设置：服务类型
	 */
    public void setYezhufuwuTypes(Integer yezhufuwuTypes) {
        this.yezhufuwuTypes = yezhufuwuTypes;
    }
    /**
	 * 获取：详情
	 */
    public String getYezhufuwuContent() {
        return yezhufuwuContent;
    }


    /**
	 * 设置：详情
	 */
    public void setYezhufuwuContent(String yezhufuwuContent) {
        this.yezhufuwuContent = yezhufuwuContent;
    }
    /**
	 * 获取：处理状态
	 */
    public Integer getYezhufuwuYesnoTypes() {
        return yezhufuwuYesnoTypes;
    }


    /**
	 * 设置：处理状态
	 */
    public void setYezhufuwuYesnoTypes(Integer yezhufuwuYesnoTypes) {
        this.yezhufuwuYesnoTypes = yezhufuwuYesnoTypes;
    }
    /**
	 * 获取：处理结果
	 */
    public String getYezhufuwuYesnoText() {
        return yezhufuwuYesnoText;
    }


    /**
	 * 设置：处理结果
	 */
    public void setYezhufuwuYesnoText(String yezhufuwuYesnoText) {
        this.yezhufuwuYesnoText = yezhufuwuYesnoText;
    }
    /**
	 * 获取：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：申请时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
