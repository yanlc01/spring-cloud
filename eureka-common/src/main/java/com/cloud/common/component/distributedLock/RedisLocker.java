package com.cloud.common.component.distributedLock;

import java.util.concurrent.TimeUnit;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RedisLocker implements DistributedLocker {

	private final static String LOCKER_PREFIX = "lock:";
	
	@Autowired
	RedissonConnector redissonConnector;
	
	@Override
	public <T> T lock(String resourceName, AquiredLockWorker<T> worker) throws UnableToAquireLockException, Exception {
		
		return lock(resourceName, worker);
	}

	@Override
	public <T> T lock(String resourceName, AquiredLockWorker<T> worker, int lockTime)
			throws UnableToAquireLockException, Exception {
		
		RedissonClient redisson = redissonConnector.getClient();
		RLock lock = redisson.getLock(LOCKER_PREFIX + resourceName);
		//Wait for 100 seconds and automatically unlock it after lockTime seconds
		boolean success = lock.tryLock(100, lockTime, TimeUnit.SECONDS);
		if (success) {
			try {
				return worker.invokeAfterLockAquire();
			} finally {
				lock.unlink();
			}
		}
		throw new UnableToAquireLockException();
	}

}
