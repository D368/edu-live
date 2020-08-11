package xyz8.live.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import xyz8.live.entity.LiveInfo;

/**
 * 资源表(LiveInfo)表数据库访问层
 *
 * @author liangw
 * @since 2020-08-11 13:08:56
 */
@Mapper
public interface LiveInfoDao extends BaseMapper<LiveInfo> {

}