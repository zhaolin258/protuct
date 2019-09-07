package cn.bdqn.controller;

import cn.bdqn.pojo.User;
import cn.bdqn.service.ProviderService;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author: 赵林
 * @Date: 2019/9/4 12:11
 * @Description:
 */
@Controller
@RequestMapping("/t")
public class json {
    @Resource
    private ProviderService providerService;
    @RequestMapping(value = "/user",method = RequestMethod.GET,produces =  {"application/json;charset=utf-8"})
    @ResponseBody
    public Object getAll(@RequestParam Integer id){
        String result="";
        if(null==id){
            return "nodata";
        }else{
            try {
                User queryid = providerService.getChaId(id);
                result= JSON.toJSONString(queryid);
            } catch (Exception e) {
                e.printStackTrace();
                return "error";
            }
        }
        return result;
    }
}
