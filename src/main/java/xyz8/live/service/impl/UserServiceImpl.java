package xyz8.live.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz8.live.dao.UserDao;
import xyz8.live.entity.User;
import xyz8.live.service.UserService;

/**
 * 用户信息表(User)表服务实现类
 *
 * @author liangw
 * @since 2020-08-11 14:08:48
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

}