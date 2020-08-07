package xyz8.live.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import xyz8.live.entity.User;

/**
 * 用户信息表(User)表数据库访问层
 *
 * @author liangw
 * @since 2020-08-06 17:10:55
 */
@Mapper
public interface UserDao extends BaseMapper<User> {

}