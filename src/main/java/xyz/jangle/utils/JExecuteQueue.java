package xyz.jangle.utils;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import xyz.jangle.demoname.model.BsExcuteHistory;

/**
 *  执行记录队列管理
 * @author jangle
 *
 */
public class JExecuteQueue {

	private static Queue<BsExcuteHistory> concurrentLinkedQueue = new ConcurrentLinkedQueue<BsExcuteHistory>();
	
	/**
	 *  获取队列中的记录
	 * @return
	 */
	public static BsExcuteHistory poll() {
		return concurrentLinkedQueue.poll();
	}
	
	/**
	 * 向队列中添加记录
	 * @param bsExcuteHistory
	 * @return
	 */
	public static boolean add(BsExcuteHistory bsExcuteHistory) {
		return concurrentLinkedQueue.add(bsExcuteHistory);
	}
	
	/**
	 * 是否为空
	 * @return
	 */
	public static boolean isEmpty() {
		return concurrentLinkedQueue.isEmpty();
	}
	
}
