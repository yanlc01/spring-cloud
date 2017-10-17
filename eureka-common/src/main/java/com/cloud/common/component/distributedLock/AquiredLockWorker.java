package com.cloud.common.component.distributedLock;

/**
 * 获取锁后需要处理的逻辑
 */
public interface AquiredLockWorker<T> {
	
	T invokeAfterLockAquire() throws Exception;
	
}
