package xyz8.live.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.logging.Log;

/**
 * @Description MybatisPlusOutImpl，直接使用控制台输出日志
 * @Author zhengkai.blog.csdn.net
 **/
@Slf4j
public class MybatisPlusOutImpl implements Log {
    public MybatisPlusOutImpl(String clazz) {
//        System.out.println("MybatisPlusOutImpl::主要"+clazz);
    }
    @Override
    public boolean isDebugEnabled() {
        return true;
    }
    @Override
    public boolean isTraceEnabled() {
        return true;
    }
    @Override
    public void error(String s, Throwable e) {
        System.err.println(s);
        e.printStackTrace(System.err);
    }
    @Override
    public void error(String s) {
        System.err.println("MybatisPlusOutImpl::error"+s);
    }
    @Override
    public void debug(String s) {
        String prefixPreparing = "Preparing:";
        String prefixParameters = "Parameters:";
        String prefixTotal = "Total:";
        if (s.contains(prefixPreparing) || s.contains(prefixParameters) || s.contains(prefixTotal)){
//            String sql = s.replace(prefixPreparing, "");
//            sql = sql.replace("==>", "");
            if (s.contains(prefixPreparing)){
              s = "===========================================\n" + s;
            }
            System.out.println(s);
        }

//        System.out.println("MybatisPlusOutImpl::debug"+s);
    }
    @Override
    public void trace(String s) {
//        System.out.println("MybatisPlusOutImpl::trace"+s);
    }
    @Override
    public void warn(String s) {
//        System.out.println("MybatisPlusOutImpl::warn"+s);
    }
}