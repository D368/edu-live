package xyz8.live.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import xyz8.live.common.constant.UserConstants;
import xyz8.live.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author LiangWei
 * @date 2020/8/7 10:50
 */
public class UserUtil {

    public static User getUser(){
        Map<String, Object> userInfoMap = JwtUtil.verifyToken(getToken());
        if (userInfoMap == null){
            return null;
        }
        User user = new User();
        user.setUserId(Long.valueOf((Integer)userInfoMap.get("userId")));
        return user;
    }

    private static String getToken() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request.getHeader(UserConstants.TOKEN_KEY);
    }
}
