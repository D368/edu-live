package xyz8.live.common.constant;

/**
 * @author LiangWei
 * @date 2020/8/7 9:31
 */
public enum ResCode {




    //========================登录（1000）=======================
    TOKEN_NULL(403, "未授权"),
    ACCOUNT_NOT_FOUND(1001, "账号不存在"),
    PASSWORD_FAIL(1002, "账号或密码不正确"),
    /**
     * 500 失败
     */
    FAILED(500, "请求失败"),

    /**
     * 200请求成功
     */
    OK(200, "请求成功");
    /**
     * 返回状态码
     */
    private Integer code;

    /**
     * 返回消息
     */
    private String message;

    ResCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
