package com.cloud.common.component.distributedLock;

/**
 * 异常类：不能获取锁的异常类
 */
public class UnableToAquireLockException extends RuntimeException {

	private static final long serialVersionUID = -8099186208535919978L;

	public UnableToAquireLockException() {}
	
	public UnableToAquireLockException(String message) {
		super(message);
	}
	
	public UnableToAquireLockException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
