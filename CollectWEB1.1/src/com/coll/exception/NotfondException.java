package com.coll.exception;

/**
 * 找不到资源异常
*@author:liwengbincoll@foxmail.com
*@date:2017/10/25 0025 14:01
*@explain:
*/
public class NotfondException extends CollectException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotfondException() {
        super();
    }

    public NotfondException(String message) {
        super(message);
    }

    public NotfondException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotfondException(Throwable cause) {
        super(cause);
    }

    public NotfondException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
