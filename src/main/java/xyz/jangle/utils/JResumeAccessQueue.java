package xyz.jangle.utils;

import java.util.Date;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.servlet.http.HttpSession;

import xyz.jangle.demoname.model.ResumeAccessRecord;

/**
 * resume访问记录队列管理
 * 
 * @author jangle
 *
 */
public class JResumeAccessQueue {

	private static Queue<ResumeAccessRecord> concurrentLinkedQueue = new ConcurrentLinkedQueue<ResumeAccessRecord>();

	/**
	 * 获取队列中的记录
	 * 
	 * @return
	 */
	public static ResumeAccessRecord poll() {
		return concurrentLinkedQueue.poll();
	}

	/**
	 * 向队列中添加记录
	 * 
	 * @param bsExcuteHistory
	 * @return
	 */
	public static boolean add(ResumeAccessRecord resumeAccessRecord) {
		return concurrentLinkedQueue.add(resumeAccessRecord);
	}

	/**
	 * 向队列中添加记录
	 * 
	 * @param bsExcuteHistory
	 * @return
	 */
	public static boolean add(HttpSession session, String uri) {
		ResumeAccessRecord resumeAccessRecord = new ResumeAccessRecord();
		resumeAccessRecord.setDmDesc("" + session.getAttribute(JConstant.ip));
		resumeAccessRecord.setDmDesc2("" + session.getAttribute(JConstant.city));
		resumeAccessRecord.setResumeUri(uri);
		resumeAccessRecord.setStatus(JConstant.status_1);
		resumeAccessRecord.setCreateTime(new Date());
		return concurrentLinkedQueue.add(resumeAccessRecord);
	}

	/**
	 * 是否为空
	 * 
	 * @return
	 */
	public static boolean isEmpty() {
		return concurrentLinkedQueue.isEmpty();
	}

}
