package xyz8.live.interceptor;

import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import xyz8.live.common.constant.ResCode;
import xyz8.live.common.constant.UserConstants;
import xyz8.live.entity.User;
import xyz8.live.exception.ExceptionCast;
import xyz8.live.utils.UserUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author LiangWei
 * @date 2020/8/7 14:10
 */
@Component
public class CustomInterceptor implements HandlerInterceptor {
    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(UserConstants.TOKEN_KEY);
        if (StrUtil.isBlank(token)){
            System.out.println(request.getRequestURI());
            ExceptionCast.cast(ResCode.TOKEN_NULL);
        }
        User user = UserUtil.getUser();
        if (null == user){
            ExceptionCast.cast(ResCode.TOKEN_NULL);
        }
        return true;
    }
}
