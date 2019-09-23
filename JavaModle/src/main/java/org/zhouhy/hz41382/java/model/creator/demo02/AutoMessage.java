package org.zhouhy.hz41382.java.model.creator.demo02;

import java.util.Date;
import org.apache.log4j.Logger;

/**
 * <p>
 * className: AutoMessage
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: Citi
 * </p>
 * 
 * @author hz41382
 * @date 2019年1月18日
 */
public abstract class AutoMessage {
	
	private static Logger logger = Logger.getLogger(AutoMessage.class);
	// 收件人地址
	private String to;
	// 发件人地址
	private String from;
	// 标题
	private String subject;
	// 内容
	private String body;
	// 发送日期
	private Date sendDate;
	
	public void send(){
		logger.info("收件人地址：" + to);
        logger.info("发件人地址：" + from);
        logger.info("标题：" + subject);
        logger.info("内容：" + body);
        logger.info("发送日期：" + sendDate);
	}
	
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}	
}
