/**
 * 文件名： History.java
 * 包名： org.cija.tools
 * 描述： []
 * 创建时间： 2017年7月22日 上午12:28:41
 * @author FC
 */

package com.cija.task.bo;

import java.math.BigDecimal;

/**
 * 类名： History
 * 公司名称： []
 * 描述：[]
 * 创建时间： 2017年7月22日 上午12:28:41
 * @author FC
 */
public class HistoryPojo extends MacdPojo{
	
	/**
	 * 创建时间： 2017年7月22日 上午12:40:20
	 * @Fields serialVersionUID : TODO []
	 */
	private static final long serialVersionUID=5400353746941795688L;
											  
	private BigDecimal		  open;									/* 开盘价 */
	private BigDecimal		  low;									/* 最低价 */
	private BigDecimal		  high;									/* 最高价 */
	private BigDecimal		  close;								/* 收盘价 */
	private BigDecimal		  volume;								/* 成交量 */
	private BigDecimal		  amount;								/* 成交金额 */
																	
	/**
	 * @return the open 开盘价
	 */
	public BigDecimal getOpen(){
		return open;
	}
	
	/**
	 * @param open
	 *        the open to set
	 */
	public void setOpen(BigDecimal open){
		this.open=open;
	}
	
	/**
	 * @return the low 最低价
	 */
	public BigDecimal getLow(){
		return low;
	}
	
	/**
	 * @param low
	 *        the low to set
	 */
	public void setLow(BigDecimal low){
		this.low=low;
	}
	
	/**
	 * @return the high 最高价
	 */
	public BigDecimal getHigh(){
		return high;
	}
	
	/**
	 * @param high
	 *        the high to set
	 */
	public void setHigh(BigDecimal high){
		this.high=high;
	}
	
	/**
	 * @return the close 收盘价
	 */
	public BigDecimal getClose(){
		return close;
	}
	
	/**
	 * @param close
	 *        the close to set
	 */
	public void setClose(BigDecimal close){
		this.close=close;
	}
	
	/**
	 * @return the volume 成交量
	 */
	public BigDecimal getVolume(){
		return volume;
	}
	
	/**
	 * @param volume
	 *        the volume to set
	 */
	public void setVolume(BigDecimal volume){
		this.volume=volume;
	}
	
	/**
	 * @return the amount 成交金额
	 */
	public BigDecimal getAmount(){
		return amount;
	}
	
	/**
	 * @param amount
	 *        the amount to set
	 */
	public void setAmount(BigDecimal amount){
		this.amount=amount;
	}
	
}
