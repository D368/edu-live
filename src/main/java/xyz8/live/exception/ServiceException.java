package xyz8.live.exception;

import lombok.Getter;
import xyz8.live.common.constant.ResCode;

/**
 * @author LiangWei
 * @date 2020/8/7 14:34
 */
@Getter
public class ServiceException extends BaseException {
    ResCode resCode;

    public ServiceException(ResCode resCode){
        this.resCode = resCode;
    }


}
