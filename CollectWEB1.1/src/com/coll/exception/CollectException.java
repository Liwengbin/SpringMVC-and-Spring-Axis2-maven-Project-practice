package com.coll.exception;

/**
 * 系统异常处理函数
*@author:liwengbincoll@foxmail.com
*@date:2017/10/25 0025 13:49
*@explain:
*/
public class CollectException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CollectException() {
        super();
    }

    public CollectException(String message) {
        super(message);
    }

    public CollectException(String message, Throwable cause) {
        super(message, cause);
    }

    public CollectException(Throwable cause) {
        super(cause);
    }

    public CollectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
