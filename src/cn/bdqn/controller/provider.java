package cn.bdqn.controller;

import cn.bdqn.pojo.User;
import cn.bdqn.service.ProviderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author: 赵林
 * @Date: 2019/9/4 8:47
 * @Description:
 */
@Controller
public class provider {
    @Resource
    private ProviderService providerService;
    @RequestMapping(value = "/t.html")
    public String getCha1(Model model){
        List<User> userList = providerService.getUser();
        model.addAttribute("userList",userList);
        return "getCha";
    }
    @RequestMapping(value = "/getCha.html")
    public String getCha(Model model, @RequestParam(value = "proCode",required = false)String proCode,@RequestParam(value = "proName",required = false)String proName) {

//        String d = new String(proName.getBytes("ISO8859-1"), "UTF-8");
        System.out.println(proCode+proName+"================================");
        try {
            String fou = new String(proName.getBytes("ISO8859-1"), "UTF-8");
            List<User> userList=providerService.getCha(proCode,fou);
            model.addAttribute("userList",userList);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return "getCha";
    }
    @RequestMapping(value = "/Add1.html")
    public String getAdd1(){
        return "Add";
    }
    @RequestMapping(value = "/Add.html")
    public String getAdd(HttpServletRequest request) throws UnsupportedEncodingException {
        String proCode=new String(request.getParameter("proCode").getBytes("ISO-8859-1"),"UTF-8");
        String proName=new String(request.getParameter("proName").getBytes("ISO-8859-1"),"UTF-8");
        String name=new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
        String phone=new String(request.getParameter("phone").getBytes("ISO-8859-1"),"UTF-8");
        String address=new String(request.getParameter("address").getBytes("ISO-8859-1"),"UTF-8");
        String date=new String(request.getParameter("date").getBytes("ISO-8859-1"),"UTF-8");
        User user=new User(proCode,proName,name,phone,address,date);
        int num=providerService.getinsert(user);
        if(num>0){
            return "redirect:/t.html";
        }else{
            return "Add";
        }
    }
    @RequestMapping(value = "/del/{id}")
    public String getdelete(@PathVariable Integer id){
        int num=providerService.getdelete(id);
        if(num>0){
            return "redirect:/t.html";
        }
        return "getCha";
    }
    @RequestMapping(value = "/getId.html")
    public String getChaId(Model model,@RequestParam(value = "id")int userid){
        User user=providerService.getChaId(userid);
        model.addAttribute("user",user);
        return "update";
    }
    @RequestMapping(value = "/update.html")
    public String getupdate(HttpServletRequest request) throws UnsupportedEncodingException {
        Integer id=Integer.parseInt(request.getParameter("id"));
        String proCode=new String(request.getParameter("proCode").getBytes("ISO-8859-1"),"UTF-8");
        String proName=new String(request.getParameter("proName").getBytes("ISO-8859-1"),"UTF-8");
        String name=new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
        String phone=new String(request.getParameter("phone").getBytes("ISO-8859-1"),"UTF-8");
        String address=new String(request.getParameter("address").getBytes("ISO-8859-1"),"UTF-8");
        String date=new String(request.getParameter("date").getBytes("ISO-8859-1"),"UTF-8");
        User user=new User(id,proCode,proName,name,phone,address,date);
        int num=providerService.getupdate(user);

        if(num>0){
            return "redirect:/t.html";
        }else{
            return "update";
        }
    }
}
