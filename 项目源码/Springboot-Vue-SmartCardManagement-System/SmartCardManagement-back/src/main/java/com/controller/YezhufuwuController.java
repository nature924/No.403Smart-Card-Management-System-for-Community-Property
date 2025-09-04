
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
 * 业主服务
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yezhufuwu")
public class YezhufuwuController {
    private static final Logger logger = LoggerFactory.getLogger(YezhufuwuController.class);

    @Autowired
    private YezhufuwuService yezhufuwuService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
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
        PageUtils page = yezhufuwuService.queryPage(params);

        //字典表数据转换
        List<YezhufuwuView> list =(List<YezhufuwuView>)page.getList();
        for(YezhufuwuView c:list){
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
        YezhufuwuEntity yezhufuwu = yezhufuwuService.selectById(id);
        if(yezhufuwu !=null){
            //entity转view
            YezhufuwuView view = new YezhufuwuView();
            BeanUtils.copyProperties( yezhufuwu , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(yezhufuwu.getYonghuId());
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
    public R save(@RequestBody YezhufuwuEntity yezhufuwu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yezhufuwu:{}",this.getClass().getName(),yezhufuwu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("业主".equals(role))
            yezhufuwu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<YezhufuwuEntity> queryWrapper = new EntityWrapper<YezhufuwuEntity>()
            .eq("yonghu_id", yezhufuwu.getYonghuId())
            .eq("yezhufuwu_name", yezhufuwu.getYezhufuwuName())
            .eq("yezhufuwu_types", yezhufuwu.getYezhufuwuTypes())
            .eq("yezhufuwu_yesno_types", yezhufuwu.getYezhufuwuYesnoTypes())
            .eq("yezhufuwu_yesno_text", yezhufuwu.getYezhufuwuYesnoText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YezhufuwuEntity yezhufuwuEntity = yezhufuwuService.selectOne(queryWrapper);
        if(yezhufuwuEntity==null){
            yezhufuwu.setYezhufuwuYesnoTypes(1);
            yezhufuwu.setInsertTime(new Date());
            yezhufuwu.setCreateTime(new Date());
            yezhufuwuService.insert(yezhufuwu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YezhufuwuEntity yezhufuwu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,yezhufuwu:{}",this.getClass().getName(),yezhufuwu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("业主".equals(role))
//            yezhufuwu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<YezhufuwuEntity> queryWrapper = new EntityWrapper<YezhufuwuEntity>()
            .notIn("id",yezhufuwu.getId())
            .andNew()
            .eq("yonghu_id", yezhufuwu.getYonghuId())
            .eq("yezhufuwu_name", yezhufuwu.getYezhufuwuName())
            .eq("yezhufuwu_types", yezhufuwu.getYezhufuwuTypes())
            .eq("yezhufuwu_yesno_types", yezhufuwu.getYezhufuwuYesnoTypes())
            .eq("yezhufuwu_yesno_text", yezhufuwu.getYezhufuwuYesnoText())
            .eq("insert_time", yezhufuwu.getInsertTime())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YezhufuwuEntity yezhufuwuEntity = yezhufuwuService.selectOne(queryWrapper);
        if(yezhufuwuEntity==null){
            yezhufuwuService.updateById(yezhufuwu);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody YezhufuwuEntity yezhufuwu, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,yezhufuwu:{}",this.getClass().getName(),yezhufuwu.toString());

//        if(yezhufuwu.getYezhufuwuYesnoTypes() == 2){//通过
//            yezhufuwu.setYezhufuwuTypes();
//        }else if(yezhufuwu.getYezhufuwuYesnoTypes() == 3){//拒绝
//            yezhufuwu.setYezhufuwuTypes();
//        }
        yezhufuwuService.updateById(yezhufuwu);//审核
        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        yezhufuwuService.deleteBatchIds(Arrays.asList(ids));
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
            List<YezhufuwuEntity> yezhufuwuList = new ArrayList<>();//上传的东西
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
                            YezhufuwuEntity yezhufuwuEntity = new YezhufuwuEntity();
//                            yezhufuwuEntity.setYonghuId(Integer.valueOf(data.get(0)));   //业主 要改的
//                            yezhufuwuEntity.setYezhufuwuName(data.get(0));                    //服务标题 要改的
//                            yezhufuwuEntity.setYezhufuwuTypes(Integer.valueOf(data.get(0)));   //服务类型 要改的
//                            yezhufuwuEntity.setYezhufuwuContent("");//详情和图片
//                            yezhufuwuEntity.setYezhufuwuYesnoTypes(Integer.valueOf(data.get(0)));   //处理状态 要改的
//                            yezhufuwuEntity.setYezhufuwuYesnoText(data.get(0));                    //处理结果 要改的
//                            yezhufuwuEntity.setInsertTime(date);//时间
//                            yezhufuwuEntity.setCreateTime(date);//时间
                            yezhufuwuList.add(yezhufuwuEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        yezhufuwuService.insertBatch(yezhufuwuList);
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
