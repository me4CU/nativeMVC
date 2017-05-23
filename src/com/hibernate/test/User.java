package com.hibernate.test;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

/**
 * @author JoneM
 *
 */
public class User {  
	private String id;  
	private String username;  
	private String password;  
	private Date createTime;  
	private Date expireTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}
	@Override
	public String toString() {
		DateFormat dateFormat = new DateFormat() {
			@Override
			public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
				// TODO Auto-generated method stub
				
				return null;
			}

			@Override
			public Date parse(String source, ParsePosition pos) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		/*DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd:HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse("2018-04-16:13:32:84", dtf);
		System.out.println(dateTime.toString());*/
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		return "User [id=" + id + ", username=" + username + ", password=" + password + "\r\n , createTime=" + 
				sdf.format(createTime) + ", expireTime=" + sdf.format(expireTime) + "]";
	}
	
	private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
		@Override
		protected DateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
		}
	};
}

    
