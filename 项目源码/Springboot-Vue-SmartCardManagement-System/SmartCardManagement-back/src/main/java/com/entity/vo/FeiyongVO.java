package com.entity.vo;

import com.entity.FeiyongEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 费用信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("feiyong")
public class FeiyongVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "create_time")
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

}
