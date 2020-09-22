package cn.kgc.ssm.service.impl;

import cn.kgc.ssm.mapper.BlogMapper;
import cn.kgc.ssm.mapper.UsersMapper;
import cn.kgc.ssm.pojo.Blog;
import cn.kgc.ssm.pojo.BlogExample;
import cn.kgc.ssm.pojo.Users;
import cn.kgc.ssm.pojo.UsersExample;
import cn.kgc.ssm.service.UsersService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 李锡良
 * @create 2020-09-22 20:27
 */
@Transactional
@Service("usersService")
public class UserServiceImpl implements UsersService {

    @Resource
    UsersMapper usersMapper;

    @Override
    public Users login(String nickname) {
        Users users = null;
        UsersExample example = new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();
        criteria.andNicknameEqualTo(nickname);
        List<Users> users1 = usersMapper.selectByExample(example);
        if (users1 != null && users1.size() > 0) {
            users = users1.get(0);
        }
        return users;
    }

    @Override
    public void add(Users users) {
        usersMapper.insert(users);
    }

    @Override
    public List<Users> USERS() {
        return usersMapper.selectByExample(null);
    }

    @Override
    public Users getUser(int id) {
        return usersMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(Users users) {
        return usersMapper.updateByPrimaryKeySelective(users);
    }
}
