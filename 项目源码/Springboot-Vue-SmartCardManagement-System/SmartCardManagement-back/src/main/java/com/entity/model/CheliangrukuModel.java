package com.entity.model;

import com.entity.CheliangrukuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 停车登记
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class CheliangrukuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 车辆单位
     */
    private String cheliangrukuName;


    /**
     * 车辆颜色
     */
    private String cheliangrukuYanse;


    /**
     * 车辆状态
     */
    private Integer cheliangrukuTypes;


    /**
     * 出入类型
     */
    private Integer churuTypes;


    /**
     * 业主
     */
    private Integer yonghuId;


    /**
     * 出入库时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date cheliangrukuTime;


    /**
     * 车辆详情
     */
    private String cheliangrukuContent;


    /**
     * 记录时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
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
	 * 获取：车辆单位
	 */
    public String getCheliangrukuName() {
        return cheliangrukuName;
    }


    /**
	 * 设置：车辆单位
	 */
    public void setCheliangrukuName(String cheliangrukuName) {
        this.cheliangrukuName = cheliangrukuName;
    }
    /**
	 * 获取：车辆颜色
	 */
    public String getCheliangrukuYanse() {
        return cheliangrukuYanse;
    }


    /**
	 * 设置：车辆颜色
	 */
    public void setCheliangrukuYanse(String cheliangrukuYanse) {
        this.cheliangrukuYanse = cheliangrukuYanse;
    }
    /**
	 * 获取：车辆状态
	 */
    public Integer getCheliangrukuTypes() {
        return cheliangrukuTypes;
    }


    /**
	 * 设置：车辆状态
	 */
    public void setCheliangrukuTypes(Integer cheliangrukuTypes) {
        this.cheliangrukuTypes = cheliangrukuTypes;
    }
    /**
	 * 获取：出入类型
	 */
    public Integer getChuruTypes() {
        return churuTypes;
    }


    /**
	 * 设置：出入类型
	 */
    public void setChuruTypes(Integer churuTypes) {
        this.churuTypes = churuTypes;
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
	 * 获取：出入库时间
	 */
    public Date getCheliangrukuTime() {
        return cheliangrukuTime;
    }


    /**
	 * 设置：出入库时间
	 */
    public void setCheliangrukuTime(Date cheliangrukuTime) {
        this.cheliangrukuTime = cheliangrukuTime;
    }
    /**
	 * 获取：车辆详情
	 */
    public String getCheliangrukuContent() {
        return cheliangrukuContent;
    }


    /**
	 * 设置：车辆详情
	 */
    public void setCheliangrukuContent(String cheliangrukuContent) {
        this.cheliangrukuContent = cheliangrukuContent;
    }
    /**
	 * 获取：记录时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：记录时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
