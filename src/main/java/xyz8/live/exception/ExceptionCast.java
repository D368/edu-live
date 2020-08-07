package xyz8.live.exception;

import xyz8.live.common.constant.ResCode;

/**
 * 自定义异常抛出
 * @author LiangWei
 * @date 2020/8/7 14:37
 */
public class ExceptionCast {

    public static void cast(ResCode resCode){
        throw new ServiceException(resCode);
    }
}
