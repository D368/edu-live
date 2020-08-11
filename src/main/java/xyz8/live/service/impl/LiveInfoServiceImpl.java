package xyz8.live.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz8.live.dao.LiveInfoDao;
import xyz8.live.entity.LiveInfo;
import xyz8.live.service.LiveInfoService;

/**
 * 资源表(LiveInfo)表服务实现类
 *
 * @author liangw
 * @since 2020-08-11 13:08:58
 */
@Service("liveInfoService")
public class LiveInfoServiceImpl extends ServiceImpl<LiveInfoDao, LiveInfo> implements LiveInfoService {

}