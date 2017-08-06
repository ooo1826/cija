/**
 * 文件名： ID.java
 * 包名： org.cija.tools
 * 描述： []
 * 创建时间： 2017年7月22日 上午12:40:55
 * @author FC
 */

package com.cija.task.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * 类名： ID
 * 公司名称： []
 * 描述：[]
 * 创建时间： 2017年7月22日 上午12:40:55
 * @author FC
 */
public class ID implements Serializable{
	/**
	 * 创建时间： 2017年7月22日 上午12:42:14
	 * @Fields serialVersionUID : TODO []
	 */
	private static final long serialVersionUID=4742205856599209173L;
	
	private String			  code;									/* 编码 */
	private Date			  date;									/* 日期及时间 */
																	
	/**
	 * @return the code
	 */
	public String getCode(){
		return code;
	}
	
	/**
	 * @param code
	 *        the code to set
	 */
	public void setCode(String code){
		this.code=code;
	}
	
	/**
	 * @return the date
	 */
	public Date getDate(){
		return date;
	}
	
	/**
	 * @param date
	 *        the date to set
	 */
	public void setDate(Date date){
		this.date=date;
	}
	
}
