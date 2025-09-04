package com.dao;

import com.entity.YezhufuwuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YezhufuwuView;

/**
 * 业主服务 Dao 接口
 *
 * @author 
 */
public interface YezhufuwuDao extends BaseMapper<YezhufuwuEntity> {

   List<YezhufuwuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
