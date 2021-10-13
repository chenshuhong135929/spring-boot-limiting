package com.chenshuhong.blog.exception;

/**
 * 自定义业务异常，有明确的业务语义，不需要记录Error日志，不需要Retry
 * @author jam
 * @date 2021/9/23 3:01 下午
 */
public class BizException extends BaseException{
    private static final long serialVersionUID = 1L;

    private static final int DEFAULT_ERROR_CODE = 510;

    public BizException(String errorMessage){
        super(DEFAULT_ERROR_CODE,errorMessage);
    }

    public BizException(int errorCode,String errorMessage){
        super(errorCode,errorMessage);
    }

    public BizException(String errorMessage,Throwable e){
        super(errorMessage,e);
    }

    public BizException(int errorCode,String errorMessage,Throwable e){
        super(errorCode,errorMessage,e);
    }
}
