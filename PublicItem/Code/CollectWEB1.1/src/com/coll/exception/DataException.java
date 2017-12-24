package com.coll.exception;

/**
 *数据处理异常
*@author:liwengbincoll@foxmail.com
*@date:2017/10/25 0025 13:52
*@explain:
*/
public class DataException extends CollectException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataException() {
        super();
    }

    public DataException(String message) {
        super(message);
    }

    public DataException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataException(Throwable cause) {
        super(cause);
    }

    public DataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
