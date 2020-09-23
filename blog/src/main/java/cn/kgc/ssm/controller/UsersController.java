package cn.kgc.ssm.controller;

import cn.kgc.ssm.pojo.Blog;
import cn.kgc.ssm.pojo.Users;
import cn.kgc.ssm.service.BlogService;
import cn.kgc.ssm.service.UsersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
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
            session.setAttribute("id",login1.getId());
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
    @RequestMapping("/insertuser")
    public String insertuser(){
        return "/jsp/adduser";
    }

    @RequestMapping("/addUser")
    public String addUser(Users users, MultipartFile pic, HttpSession session, HttpServletRequest request){
        String realPath = session.getServletContext().getRealPath("statics/uploadfiles");
        String originalFilename = pic.getOriginalFilename();
        String extension = FilenameUtils.getExtension(originalFilename);
        String fileName=System.currentTimeMillis()+ RandomUtils.nextInt(10000)+"_."+extension;
        File file=new File(realPath,fileName);
        try {
            pic.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        users.setPicpath(fileName);
        usersService.add(users);
        return "redirect:/";
    }
    @RequestMapping("/insertblog")
    public String insertblog(){
        return "/jsp/addblog";
    }

    @RequestMapping("/addBlog")
    public String addBlog(Blog blog,Model model){
        blogService.add(blog);
        return "/jsp/index2";
    }

    @RequestMapping("/toindex2")
    public String toindex2() {
        return "/jsp/index2";
    }

    @RequestMapping("/tousers")
    public String string() {
        return "/jsp/users";
    }

    @RequestMapping("/dousers")
    @ResponseBody
    public Map<String, Object> dousers(Integer pageIndex, Integer pageSize, HttpSession session) throws Exception {
        Map<String, Object> map = new HashMap<>();
        String order = "id desc";
        PageHelper.startPage(pageIndex, pageSize, order);
        List<Users> users = usersService.USERS();
        PageInfo<Users> pageInfo = new PageInfo<>(users);
        map.put("pageInfo", pageInfo);
        Users usersnum = (Users) session.getAttribute("userSession");
        map.put("usernum", usersnum.getSupper());
        map.put("userid", usersnum.getId());
        return map;
    }

    @RequestMapping("/toupdate")
    public String toupdate(Integer id, HttpSession session) {
        Users users = usersService.getUser(id);
        session.setAttribute("userA", users);
        return "/jsp/update";
    }

    @RequestMapping("/doupdate")
    public String doupdate(String nickname, String password, HttpSession session) {
        if (nickname.length() == 0 || password.length() == 0) {
            session.setAttribute("error1", "必填项未填写！!");
            return "redirect:/toupdate";
        }
        Users userB = (Users) session.getAttribute("userSession");
        userB.setNickname(nickname);
        userB.setPassword(password);
        int a = usersService.update(userB);
        if (a > 0) {
            return "/jsp/users";
        } else {
            session.setAttribute("error1", "修改失败!");
            return "redirect:/toupdate";
        }

    }
    @RequestMapping("/delUsers{id}")

    public  String delUsers(Integer id,HttpSession session){
        int delUser = usersService.delUser(id);
        int re=1;
        session.setAttribute("re",re);


        return "jsp/users";
    }

}
