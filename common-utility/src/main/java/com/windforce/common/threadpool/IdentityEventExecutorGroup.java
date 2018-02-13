package com.windforce.common.threadpool;

import java.util.concurrent.TimeUnit;

import io.netty.util.concurrent.DefaultThreadFactory;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.ScheduledFuture;

/**
 * wsocket.任务调度器
 * 
 * @author Kuang Hao
 * @since v1.0 2018年2月3日
 *
 */
public class IdentityEventExecutorGroup {

	static private EventExecutor[] children;

	/**
	 * 初始化
	 * 
	 * @param nThreads
	 */
	synchronized public static void init(int nThreads) {
		if (children != null) {
			children = new EventExecutor[nThreads];
			for (int i = 0; i < nThreads; i++) {
				children[i] = new EventExecutor(null, new DefaultThreadFactory("Identity-dispatcher"), true);
			}
		}
	}

	/**
	 * 添加同步任务
	 * 
	 * @param dispatcherHashCode
	 * @return
	 */
	public static Future<?> addTask(AbstractDispatcherHashCodeRunable dispatcherHashCode) {
		EventExecutor eventExecutor = children[dispatcherHashCode.getDispatcherHashCode() % children.length];
		dispatcherHashCode.setEventExecutor(eventExecutor);
		return eventExecutor.addTask(dispatcherHashCode);
	}

	/**
	 * 添加延迟任务
	 * 
	 * @param dispatcherHashCode
	 * @param delay
	 * @param unit
	 * @return
	 */
	public static ScheduledFuture<?> addScheduleTask(AbstractDispatcherHashCodeRunable dispatcherHashCode, long delay,
			TimeUnit unit) {
		EventExecutor eventExecutor = children[dispatcherHashCode.getDispatcherHashCode() % children.length];
		dispatcherHashCode.setEventExecutor(eventExecutor);
		return eventExecutor.addScheduleTask(dispatcherHashCode, delay, unit);
	}
}
