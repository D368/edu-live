package xyz8.live.entity.dto.user;

import lombok.Data;

/**
 * @author LiangWei
 * @date 2020/8/7 10:03
 */
@Data
public class LoginUserDTO {


    /**
     * 用户邮箱/手机号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

}
