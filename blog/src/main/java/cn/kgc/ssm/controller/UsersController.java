package cn.kgc.ssm.controller;

import cn.kgc.ssm.pojo.Blog;
import cn.kgc.ssm.pojo.Users;
import cn.kgc.ssm.service.BlogService;
import cn.kgc.ssm.service.UsersService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 李锡良
 * @create 2020-09-22 20:38
 */
@Controller
public class UsersController {

    @Resource
    UsersService usersService;

    @Resource
    BlogService blogService;

    @RequestMapping("/")
    public String toIndex(){
        return "/jsp/index";
    }

    @RequestMapping("/doLogin")
    public String doLogin(Model model, String nickname, String password, HttpSession session){
        Users login1 = usersService.login(nickname);
        if (login1==null){
            model.addAttribute("error","用户名不存在");
            return "/jsp/index";
        }else if (login1.getPassword().equals(password)==false){
            model.addAttribute("error","密码错误");
            return "/jsp/index";
        }else{
            session.setAttribute("userSession",login1);
            return "/jsp/index2";
        }
    }

    @RequestMapping("/doIndex2")
    @ResponseBody
    public Map<String,Object> index2(Integer pageIndex, Integer pageSize){
        Map<String,Object> map = new HashMap<>();
        System.out.println(pageIndex+","+pageSize);
        List<Blog> blogs = blogService.bList(pageIndex, pageSize);
        PageInfo<Blog> pageInfo=new PageInfo<>(blogs);
        map.put("data",pageInfo);
        return map;
    }


}
