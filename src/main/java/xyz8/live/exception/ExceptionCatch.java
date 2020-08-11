package xyz8.live.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import xyz8.live.common.constant.ResCode;
import xyz8.live.common.result.ResResult;

/**
 * 自定义异常捕获类
 * @author LiangWei
 * @date 2020/8/7 14:40
 */
@RestControllerAdvice
@Slf4j
public class ExceptionCatch {
    @ExceptionHandler(ServiceException.class)
    public ResResult serviceException(ServiceException serviceException){
        ResCode resCode = serviceException.getResCode();
        log.error("业务异常 code:"+resCode.getCode()+" message:"+resCode.getMessage(),serviceException);
        return ResResult.fail(resCode);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResResult exception(RuntimeException exception){
        String msg = exception.getMessage();
        log.error("系统错误",exception);
        return ResResult.fail(msg);
    }


}
