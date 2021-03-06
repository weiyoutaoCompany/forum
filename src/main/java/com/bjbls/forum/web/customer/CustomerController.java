package com.bjbls.forum.web.customer;

import com.bjbls.forum.model.Customer;
import com.bjbls.forum.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    @Resource
    private CustomerService customerService;
    //跳转列表页面
    @RequestMapping(value = "/list")
    public  String list(HttpServletRequest request){
        request.setAttribute("list",customerService.getCustomer());

        return "/customer/list.jsp";
    }
    //跳转登录页面
    @RequestMapping(value = "/login1")
    public  String login1(){
        return "/customer/login.jsp";
    }
    //跳转注册页面
    @RequestMapping(value = "/signup")
    public  String signup(){
        return "/customer/signup.jsp";
    }

    /*
	 * 跳转到登录页面
	 */
    @ResponseBody
    @RequestMapping(value = "/login")
    public Map<String,Integer>  login(String username, String password){
        Map<String,Integer> map=new HashMap<String,Integer>();//定义一个map集合
        if(customerService.login(username, password)){
            map.put("status", 1);
    }else{
            map.put("status", -1);
    }
    return  map;

    }
    //注册
    @ResponseBody
    @RequestMapping(value = "/add")
    public  Map<String,Integer>  add(Customer customer){
        Map<String,Integer> map=new HashMap<>();

              if ( customerService.add(customer)){

                  map.put("status", 1);

              }else {
                  map.put("status", -1);
              }

        return  map;
    }

    //更新密码
    @ResponseBody
    @RequestMapping(value = "/updatePassword")
    public  Map<String,Integer> updatePawword(String password,Integer id){
        Map<String,Integer> map=new HashMap<>();

        if (customerService.updatePassword(password,id)){

            map.put("status", 1);

        }else {
            map.put("status", -1);
        }
        return  map;
    }

}
