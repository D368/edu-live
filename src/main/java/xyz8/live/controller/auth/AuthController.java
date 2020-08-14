package xyz8.live.controller.auth;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz8.live.common.constant.ResCode;
import xyz8.live.common.result.ResResult;

import xyz8.live.entity.User;
import xyz8.live.entity.dto.user.LoginUserDTO;
import xyz8.live.exception.ExceptionCast;
import xyz8.live.service.UserService;
import xyz8.live.utils.JwtUtil;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LiangWei
 * @date 2020/8/7 9:12
 */
@RestController
@Api(tags = "登录")
@RequestMapping("/auth")
@Slf4j
public class AuthController {

    @Resource
    private UserService userService;


    @PostMapping("/login")
    @ApiOperation(value = "授权")
    public ResResult<Map<String, Object>> auth(@RequestBody LoginUserDTO userDTO){
        User user = userService.getOne(new LambdaQueryWrapper<User>()
                .eq(StrUtil.isNotBlank(userDTO.getUsername()), User::getEmail, userDTO.getUsername()).or()
                .eq(StrUtil.isNotBlank(userDTO.getUsername()), User::getPhonenumber, userDTO.getUsername())
        );
        if (null == user){
            ExceptionCast.cast(ResCode.ACCOUNT_NOT_FOUND);
        }
        if (!user.getPassword().equals(userDTO.getPassword())){
            ExceptionCast.cast(ResCode.PASSWORD_FAIL);

        }
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("userId",user.getUserId());
        userMap.put("userName",user.getUserName());
        String token = JwtUtil.createToken(userMap);
        userMap.put("token",token);
        return ResResult.success(userMap);
    }
}
