package xyz.jangle.demoname.service.impl;

import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.mail.util.MailSSLSocketFactory;

import xyz.jangle.demoname.dao.BsMailMapper;
import xyz.jangle.demoname.model.BsMail;
import xyz.jangle.demoname.model.BsMailConfig;
import xyz.jangle.demoname.model.BsUser2;
import xyz.jangle.demoname.model.ZdUserApply;
import xyz.jangle.demoname.service.BsMailConfigService;
import xyz.jangle.demoname.service.BsMailService;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.JConstant;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;
import xyz.jangle.utils.ResultModelMap;

/**
 * 邮件发送记录表 业务层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
@Service
public class BsMailServiceImpl extends BaseServiceImpl implements BsMailService {
	
	private String sendFrom = null;// = bundle.getString("email.from");	//发件人
	private String username = null;// = bundle.getString("username");		//名称
	private String password = null;// = bundle.getString("password");		//授权码
	private String host = null;// = bundle.getString("email.host");		//主机
	private static final String succMsg = "发送成功";

	@Autowired
	private BsMailMapper bsMailMapper;
	
	@Autowired
	private BsMailConfigService bsMailConfigService;
	
	
	@Override
	public ResultModel<BsMail> insertOrUpdate(BsMail record) {
		int i = 0;
		if (Jutils.isGreatThan0(record.getId()) || Jutils.isNotEmpty(record.getUuid())) {
			i = bsMailMapper.updateByPrimaryKey(record);
		} else {
			record.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
			i = bsMailMapper.insert(record);
		}
		if (i > 0) {
			return new ResultModel<BsMail>(record);
		}
		return new ResultModel<BsMail>(CME.error);
	}

	@Override
	public ResultModel<BsMail> deleteByPrimaryKey(BsMail record) {
		int i = bsMailMapper.deleteByPrimaryKey(record.getId());
		if (i > 0) {
			return new ResultModel<BsMail>(CME.success);
		}
		logger.error(CME.error.getMessage());
		return new ResultModel<BsMail>(CME.error);
	}
	
	@Override
	public ResultModel<BsMail> updateByPrimaryKey(BsMail record) {
		int i = bsMailMapper.updateByPrimaryKey(record);
		if (i > 0) {
			return new ResultModel<BsMail>(CME.success);
		}
		return new ResultModel<BsMail>(CME.error);
	}
	
	@Override
	public ResultModel<BsMail> selectByPrimaryKey(BsMail record) {
		return new ResultModel<BsMail>(bsMailMapper.selectByPrimaryKey(record.getId()));
	}
	
	@Override
	public ResultModelList<BsMail> selectByParam(Map<String, Object> param) {
		List<BsMail> list = bsMailMapper.selectByParam(param);
		return new ResultModelList<>(list);
	}


	@Override
	public ResultModelList<BsMail> selectAll() {
		List<BsMail> list = bsMailMapper.selectAll();
		return new ResultModelList<BsMail>(list);
	}

	

	@Override
	public ResultModelList<BsMail> selectPage(BsMail record) {
		ResultModelList<BsMail> resultModelList = new ResultModelList<BsMail>(bsMailMapper.selectPage(record));
		resultModelList.setCount(bsMailMapper.selectPageCount(record));
		return resultModelList;
	}

	@Override
	public ResultModel<BsMail> batchDeleteByPrimaryKey(BsMail record) {
		if(Jutils.isEmpty(record.getIds())) {
			return new ResultModel<BsMail>(CME.unFindIdsToDelete);
		}
		record.setIdsArray(record.getIds().split(JConstant.ywdh));
		bsMailMapper.batchDeleteByPrimaryKey(record);
		return new ResultModel<BsMail>(CME.success);
	}

	@Override
	public ResultModel<BsMail> batchDeleteByPrimaryKeyActually(BsMail record) {
		if(Jutils.isEmpty(record.getIds())) {
			return new ResultModel<BsMail>(CME.unFindIdsToDelete);
		}
		record.setIdsArray(record.getIds().split(JConstant.ywdh));
		bsMailMapper.batchDeleteByPrimaryKeyActually(record);
		return new ResultModel<BsMail>(CME.success);
	}
	
	@Override
	public ResultModel<BsMail> selectByPrimaryKeyForAnnotation(BsMail record) {
		return new ResultModel<BsMail>(bsMailMapper.selectByPrimaryKeyForAnnotation(record.getId()));
	}

	@Override
	public void userApplyMsg(ZdUserApply zdUserApply) {
		BsMail record = new BsMail();
		record.setToEmail("jangle@jangle.xyz");
		record.setMailSubject("有用户申请帐号，需要审批");
		record.setMailContent("<a href=\"http://jangle.xyz\">阿景的战队</a></br>昵称："+zdUserApply.getZdUserName()+" </br>邮箱："+zdUserApply.getZdUserCode()+"</br>申请理由："+zdUserApply.getZdUserApplyReason());
		record.setStatus(JConstant.status_1);
		record.setMailType(BsMail.typeManage);
		bsMailMapper.insert(record);
	}

	@Override
	public void userApplySuccess(BsUser2 bsUser2) {
		BsMail record = new BsMail();
		record.setToEmail(bsUser2.getJgCode());
		record.setMailSubject("您在阿景的战队申请的用户已通过审批");
		record.setMailContent("您好："+bsUser2.getJgName()+"</br>您在<a href=\\\"http://jangle.xyz\\\">阿景的战队</a>申请的用户已通过审批 </br> 您帐号为："+bsUser2.getJgCode()+"</br> 您的密码为："+bsUser2.getJgPassword());
		record.setStatus(JConstant.status_1);
		record.setMailType(BsMail.typePassword);
		bsMailMapper.insert(record);
	}

	@Override
	public void doSendEmail() {
		// 1、邮件配置初始化
		if(sendFrom == null) {
			ResultModelMap<BsMailConfig> resultModelMap = bsMailConfigService.getConfigMap();
			Map<String, Object> mailConfig = resultModelMap.getMap();
			sendFrom = (String) mailConfig.get("sendFrom");
			username = (String) mailConfig.get("username");
			password = (String) mailConfig.get("password");
			host = (String) mailConfig.get("host");
		}
		if(sendFrom == null || username == null || password == null || host == null) {
			logger.error("邮件配置不完全，请完善配置项。");
			return;
		}
		// 2、查询待发送邮件的记录
		Map<String, Object> param = Jutils.getHashMapSO();
		param.put(JConstant.status, JConstant.status_1);
		logger.info("开始查询待发送的邮件");
		List<BsMail> toSendList = bsMailMapper.selectByParam(param);
		if(Jutils.isEmpty(toSendList)) {
			logger.info("没有待发送的邮件");
			return;
		}
		for(BsMail mail : toSendList) {
			String resultMsg = this.sendEmail(mail.getToEmail(), mail.getMailSubject(), mail.getMailContent());
			if(succMsg.equals(resultMsg)) {
				mail.setStatus(JConstant.status_6);
			}else {
				mail.setStatus(JConstant.status_2);
			}
			mail.setMailResult(resultMsg);
			bsMailMapper.updateResultByPrimaryKey(mail);	//更新发送结果
		}
		
	}

	/**
	 * 发送邮件
	 * @param toEmail
	 * @param subject
	 * @param content
	 */
	public String sendEmail(String toEmail, String subject, String content) {
		String msg = succMsg;
		Properties props = new Properties();
		props.setProperty("mail.host", host);
		props.setProperty("mail.smtp.auth", "true");
		MailSSLSocketFactory sf;
		try {
			sf = new MailSSLSocketFactory();
			sf.setTrustAllHosts(true);
			props.put("mail.smtp.ssl.enable", "true");
			props.put("mail.smtp.ssl.socketFactory", sf);
		} catch (GeneralSecurityException e1) {
			e1.printStackTrace();
		}
		Authenticator authenticator = new Authenticator() {
			@Override
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		};
		Session session = Session.getDefaultInstance(props, authenticator);
//		session.setDebug(true);
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(sendFrom));
			message.setRecipients(RecipientType.TO, InternetAddress.parse(toEmail));
			// message.setRecipients(RecipientType.TO,InternetAddress.parse("测试的接收的邮件多个以逗号隔开"));
			message.setSubject(subject);
			message.setContent(content, "text/html;charset=UTF-8");
			Transport.send(message);
		} catch (AddressException e) {
			msg = "邮件地址解析错误";
			logger.error(msg, e);
			return msg;
		} catch (MessagingException e) {
			msg = "邮件发送时异常";
			logger.error(msg, e);
			return msg;
		}
		return msg;
	}

}
