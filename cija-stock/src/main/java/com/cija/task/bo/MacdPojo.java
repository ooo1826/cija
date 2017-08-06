/**
 * 文件名： Macd.java
 * 包名： org.cija.tools
 * 描述： []
 * 创建时间： 2017年7月22日 上午12:38:03
 * @author FC
 */

package com.cija.task.bo;

import java.math.BigDecimal;

/**
 * 类名： Macd
 * 公司名称： []
 * 描述：[]
 * 创建时间： 2017年7月22日 上午12:38:03
 * @author FC
 */
public class MacdPojo extends ID{
	
	/**
	 * 
	 */
	public MacdPojo(){
		super();
	}
	
	/**
	 * 创建时间： 2017年7月22日 上午12:43:16
	 * @Fields serialVersionUID : TODO []
	 */
	private static final long serialVersionUID=-7194196598936849987L;
											  
	private BigDecimal		  macd;
	private BigDecimal		  diff;
	private BigDecimal		  dea;
							  
	/**
	 * @return the macd
	 */
	public BigDecimal getMacd(){
		return macd;
	}
	
	/**
	 * @param macd
	 * @param diff
	 * @param dea
	 */
	public MacdPojo(BigDecimal macd,BigDecimal diff,BigDecimal dea){
		super();
		this.macd=macd;
		this.diff=diff;
		this.dea=dea;
	}
	
	/**
	 * @param macd
	 *        the macd to set
	 */
	public void setMacd(BigDecimal macd){
		this.macd=macd;
	}
	
	/**
	 * @return the diff
	 */
	public BigDecimal getDiff(){
		return diff;
	}
	
	/**
	 * @param diff
	 *        the diff to set
	 */
	public void setDiff(BigDecimal diff){
		this.diff=diff;
	}
	
	/**
	 * @return the dea
	 */
	public BigDecimal getDea(){
		return dea;
	}
	
	/**
	 * @param dea
	 *        the dea to set
	 */
	public void setDea(BigDecimal dea){
		this.dea=dea;
	}
	
}
