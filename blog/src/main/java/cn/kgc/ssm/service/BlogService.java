package cn.kgc.ssm.service;

import cn.kgc.ssm.pojo.Blog;

import java.util.List;

/**
 * @author 李锡良
 * @create 2020-09-22 20:35
 */
public interface BlogService {

    /**
     * 微博首页查询加分页
     * @return
     */
    List<Blog> bList(Integer pageIndex, Integer pageSize);

}
