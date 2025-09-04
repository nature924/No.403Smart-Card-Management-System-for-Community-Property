
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 服务评价
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yezhufuwuCommentback")
public class YezhufuwuCommentbackController {
    private static final Logger logger = LoggerFactory.getLogger(YezhufuwuCommentbackController.class);

    @Autowired
    private YezhufuwuCommentbackService yezhufuwuCommentbackService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private YezhufuwuService yezhufuwuService;
    @Autowired
    private YonghuService yonghuService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("业主".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = yezhufuwuCommentbackService.queryPage(params);

        //字典表数据转换
        List<YezhufuwuCommentbackView> list =(List<YezhufuwuCommentbackView>)page.getList();
        for(YezhufuwuCommentbackView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YezhufuwuCommentbackEntity yezhufuwuCommentback = yezhufuwuCommentbackService.selectById(id);
        if(yezhufuwuCommentback !=null){
            //entity转view
            YezhufuwuCommentbackView view = new YezhufuwuCommentbackView();
            BeanUtils.copyProperties( yezhufuwuCommentback , view );//把实体数据重构到view中

                //级联表
                YezhufuwuEntity yezhufuwu = yezhufuwuService.selectById(yezhufuwuCommentback.getYezhufuwuId());
                if(yezhufuwu != null){
                    BeanUtils.copyProperties( yezhufuwu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYezhufuwuId(yezhufuwu.getId());
                    view.setYezhufuwuYonghuId(yezhufuwu.getYonghuId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(yezhufuwuCommentback.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody YezhufuwuCommentbackEntity yezhufuwuCommentback, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yezhufuwuCommentback:{}",this.getClass().getName(),yezhufuwuCommentback.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("业主".equals(role))
            yezhufuwuCommentback.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        yezhufuwuCommentback.setInsertTime(new Date());
        yezhufuwuCommentback.setCreateTime(new Date());
        yezhufuwuCommentbackService.insert(yezhufuwuCommentback);
        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YezhufuwuCommentbackEntity yezhufuwuCommentback, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,yezhufuwuCommentback:{}",this.getClass().getName(),yezhufuwuCommentback.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("业主".equals(role))
//            yezhufuwuCommentback.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<YezhufuwuCommentbackEntity> queryWrapper = new EntityWrapper<YezhufuwuCommentbackEntity>()
            .eq("id",0)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YezhufuwuCommentbackEntity yezhufuwuCommentbackEntity = yezhufuwuCommentbackService.selectOne(queryWrapper);
        yezhufuwuCommentback.setUpdateTime(new Date());
        if(yezhufuwuCommentbackEntity==null){
            yezhufuwuCommentbackService.updateById(yezhufuwuCommentback);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        yezhufuwuCommentbackService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<YezhufuwuCommentbackEntity> yezhufuwuCommentbackList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            YezhufuwuCommentbackEntity yezhufuwuCommentbackEntity = new YezhufuwuCommentbackEntity();
//                            yezhufuwuCommentbackEntity.setYezhufuwuId(Integer.valueOf(data.get(0)));   //服务 要改的
//                            yezhufuwuCommentbackEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            yezhufuwuCommentbackEntity.setYezhufuwuCommentbackText(data.get(0));                    //评价内容 要改的
//                            yezhufuwuCommentbackEntity.setInsertTime(date);//时间
//                            yezhufuwuCommentbackEntity.setReplyText(data.get(0));                    //回复内容 要改的
//                            yezhufuwuCommentbackEntity.setUpdateTime(sdf.parse(data.get(0)));          //回复时间 要改的
//                            yezhufuwuCommentbackEntity.setCreateTime(date);//时间
                            yezhufuwuCommentbackList.add(yezhufuwuCommentbackEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        yezhufuwuCommentbackService.insertBatch(yezhufuwuCommentbackList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
