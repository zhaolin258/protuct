package cn.bdqn.dao;

import cn.bdqn.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: 赵林
 * @Date: 2019/9/4 8:43
 * @Description:
 */
public interface UserMapper {
    List<User> getCha(@Param("proCode")String proCode,@Param("proName")String proName);
    List<User> getUser();
    User getChaId(@Param("id")int id);
    int getinsert(User user);
    int getdelete(@Param("id")Integer id);
    int getupdate(User user);
}
