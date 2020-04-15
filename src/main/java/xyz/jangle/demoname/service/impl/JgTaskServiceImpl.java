package xyz.jangle.demoname.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.jangle.demoname.service.BsExcuteHistoryService;
import xyz.jangle.demoname.service.BsMailService;
import xyz.jangle.demoname.service.JgTaskService;
import xyz.jangle.demoname.service.ResumeAccessRecordService;

@Service
public class JgTaskServiceImpl implements JgTaskService {

	@Autowired
	private BsMailService bsMailService;
	@Autowired
	private BsExcuteHistoryService bsExcuteHistoryService;
	@Autowired
	private ResumeAccessRecordService resumeAccessRecordService;

	@Override
	public void doSchedule() {
		bsMailService.doSendEmail();
		bsExcuteHistoryService.doSaveExcute();
		resumeAccessRecordService.doInsertRecordByQueue();
	}

}
