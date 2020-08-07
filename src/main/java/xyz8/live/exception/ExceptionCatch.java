package xyz8.live.exception;

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
public class ExceptionCatch {
    @ExceptionHandler(ServiceException.class)
    public ResResult serviceException(ServiceException serviceException){
        ResCode resCode = serviceException.getResCode();
        return ResResult.fail(resCode);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResResult exception(RuntimeException exception){
        String msg = exception.getMessage();
        exception.printStackTrace();
        return ResResult.fail(msg);
    }


}
