package cn.kgc.ssm.service.impl;

import cn.kgc.ssm.mapper.BlogMapper;
import cn.kgc.ssm.pojo.Blog;
import cn.kgc.ssm.pojo.BlogExample;
import cn.kgc.ssm.service.BlogService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 李锡良
 * @create 2020-09-22 20:36
 */
@Transactional
@Service("blogService")
public class BlogServiceImpl implements BlogService {

    @Resource
    BlogMapper blogMapper;

    @Override
    public List<Blog> bList(Integer pageIndex, Integer pageSize) {
        BlogExample example = new BlogExample();
        BlogExample.Criteria criteria = example.createCriteria();
        List<Blog> blogs = blogMapper.selectByExample(example);
        PageHelper.startPage(pageIndex,pageSize);
        PageHelper.orderBy("id desc");
        return blogs;
    }

    @Override
    public void add(Blog blog) {
        blogMapper.insert(blog);
    }
}
