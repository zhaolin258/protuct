package cn.bdqn.service;

import cn.bdqn.dao.UserMapper;
import cn.bdqn.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: 赵林
 * @Date: 2019/9/4 9:04
 * @Description:
 */
@Service("Service")
public class ProviderServiceimpl implements ProviderService{
    @Resource(name = "userMapper")
    private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> getUser() {
        return userMapper.getUser();
    }

    @Override
    public List<User> getCha(String proCode, String proName) {
        return userMapper.getCha(proCode,proName);
    }

    @Override
    public int getinsert(User user) {
        return userMapper.getinsert(user);
    }

    @Override
    public User getChaId(int id) {
        return userMapper.getChaId(id);
    }

    @Override
    public int getdelete(Integer id) {
        return userMapper.getdelete(id);

    }

    @Override
    public int getupdate(User user) {
        return userMapper.getupdate(user);
    }
}
