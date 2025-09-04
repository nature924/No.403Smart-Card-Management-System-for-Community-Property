package com.entity.model;

import com.entity.FeiyongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 费用信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FeiyongModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 标题
     */
    private String feiyongName;


    /**
     * 费用类型
     */
    private Integer feiyongTypes;


    /**
     * 涉及金额
     */
    private Double feiyongMoney;


    /**
     * 业主
     */
    private Integer yonghuId;


    /**
     * 收费结果
     */
    private String renyuanJieguo;


    /**
     * 详情
     */
    private String feiyongContent;


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
	 * 获取：标题
	 */
    public String getFeiyongName() {
        return feiyongName;
    }


    /**
	 * 设置：标题
	 */
    public void setFeiyongName(String feiyongName) {
        this.feiyongName = feiyongName;
    }
    /**
	 * 获取：费用类型
	 */
    public Integer getFeiyongTypes() {
        return feiyongTypes;
    }


    /**
	 * 设置：费用类型
	 */
    public void setFeiyongTypes(Integer feiyongTypes) {
        this.feiyongTypes = feiyongTypes;
    }
    /**
	 * 获取：涉及金额
	 */
    public Double getFeiyongMoney() {
        return feiyongMoney;
    }


    /**
	 * 设置：涉及金额
	 */
    public void setFeiyongMoney(Double feiyongMoney) {
        this.feiyongMoney = feiyongMoney;
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
	 * 获取：收费结果
	 */
    public String getRenyuanJieguo() {
        return renyuanJieguo;
    }


    /**
	 * 设置：收费结果
	 */
    public void setRenyuanJieguo(String renyuanJieguo) {
        this.renyuanJieguo = renyuanJieguo;
    }
    /**
	 * 获取：详情
	 */
    public String getFeiyongContent() {
        return feiyongContent;
    }


    /**
	 * 设置：详情
	 */
    public void setFeiyongContent(String feiyongContent) {
        this.feiyongContent = feiyongContent;
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
