package xyz8.live.common.result;

import lombok.Data;
import xyz8.live.common.constant.ResCode;

/**
 * @author LiangWei
 * @date 2020/8/7 9:15
 */
@Data
public class ResResult<T> {

    /**
     * 状态码
     */
    private Integer code;
    /**
     * 消息
     */
    private String msg;
    /**
     * 数据
     */
    private T data;

    public ResResult() {
    }

    public ResResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResResult(ResCode resCode) {
        this.code = resCode.getCode();
        this.msg = resCode.getMessage();
    }

    public ResResult(ResCode resCode, T data) {
        this.code = resCode.getCode();
        this.msg = resCode.getMessage();
        this.data = data;
    }

    public static <T> ResResult<T> success(T data){
        return new ResResult<T>(ResCode.OK,data);
    }

    public static <T> ResResult<T> success(String msg) {
        return new ResResult<T>(ResCode.OK.getCode(),msg);
    }

    public static <T> ResResult<T> success() {
        return new ResResult<T>(ResCode.OK);
    }


    public static <T> ResResult<T> fail() {
        return new ResResult<T>(ResCode.FAILED);
    }

    public static <T> ResResult<T> fail(ResCode resCode) {
        return new ResResult<T>(resCode);
    }

    public static <T> ResResult<T> fail(String msg) {
        return new ResResult<T>(ResCode.FAILED.getCode(),msg);
    }
}
