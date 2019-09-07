package cn.bdqn;

import cn.bdqn.pojo.User;
import cn.bdqn.service.ProviderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author: 赵林
 * @Date: 2019/9/4 9:06
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext ac =new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
        ProviderService providerService=(ProviderService) ac.getBean("Service");
        List<User> cha = providerService.getCha("", "");
        for (User user : cha) {
            System.out.println(user);
        }
    }

}
