package cn.kgc.ssm.service;

import cn.kgc.ssm.pojo.Users;

import java.util.List;


/**
 * @author 李锡良
 * @create 2020-09-22 20:26
 */
public interface UsersService {

    /**
     * 用户登录
     * @param nickname
     * @return
     */
    Users login(String nickname);

    void add(Users users);

    //春夏
    List<Users> USERS();

    //根据id查找对象
    Users getUser(int id);

    //修改
    int update(Users users);

}
