package cn.bdqn.service;

import cn.bdqn.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: 赵林
 * @Date: 2019/9/4 9:04
 * @Description:
 */
public interface ProviderService {
    List<User> getCha(String proCode,String proName);
    List<User> getUser();
    User getChaId(int id);
    int getinsert(User user);
    int getdelete(Integer id);
    int getupdate(User user);
}
