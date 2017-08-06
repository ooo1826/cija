package com.cija.task.bo;

import java.util.ArrayList;
import java.util.List;


public class Adjust extends ID{

	private static final long serialVersionUID=-9070665582849352920L;
											  
	private Integer			  adjust_macd;
	private Integer			  adjust_w;
	private List<HistoryPojo> historyPojos	  =new ArrayList<HistoryPojo>();
	private HistoryPojo		  max_close;
	private HistoryPojo		  min_close;
	private HistoryPojo		  max_macd;
	private HistoryPojo		  min_macd;
	private Boolean			  adjust_flag	  =true;						
	private HistoryPojo		  diff;
	
							  
	/**
	 * @return the diff
	 */
	public HistoryPojo getDiff(){
		return diff;
	}

	/**
	 * @param diff the diff to set
	 */
	public void setDiff(HistoryPojo diff){
		this.diff=diff;
	}

	/**
	 * @return the adjust_flag
	 */
	public Boolean getAdjust_flag(){
		return adjust_flag;
	}
	
	/**
	 * @param adjust_flag
	 *        the adjust_flag to set
	 */
	public void setAdjust_flag(Boolean adjust_flag){
		this.adjust_flag=adjust_flag;
	}
	
	/**
	 * @return the adjust_macd
	 */
	public Integer getAdjust_macd(){
		return adjust_macd;
	}
	
	/**
	 * @param adjust_macd
	 *        the adjust_macd to set
	 */
	public void setAdjust_macd(Integer adjust_macd){
		this.adjust_macd=adjust_macd;
	}
	
	/**
	 * @return the adjust_w
	 */
	public Integer getAdjust_w(){
		return adjust_w;
	}
	
	/**
	 * @param adjust_w
	 *        the adjust_w to set
	 */
	public void setAdjust_w(Integer adjust_w){
		this.adjust_w=adjust_w;
	}
	
	/**
	 * @return the historyPojos
	 */
	public List<HistoryPojo> getHistoryPojos(){
		return historyPojos;
	}
	
	/**
	 * @param historyPojos
	 *        the historyPojos to set
	 */
	public void setHistoryPojos(List<HistoryPojo> historyPojos){
		this.historyPojos=historyPojos;
	}
	
	/**
	 * @return the max_close
	 */
	public HistoryPojo getMax_close(){
		return max_close;
	}
	
	/**
	 * @param max_close
	 *        the max_close to set
	 */
	public void setMax_close(HistoryPojo max_close){
		this.max_close=max_close;
	}
	
	/**
	 * @return the min_close
	 */
	public HistoryPojo getMin_close(){
		return min_close;
	}
	
	/**
	 * @param min_close
	 *        the min_close to set
	 */
	public void setMin_close(HistoryPojo min_close){
		this.min_close=min_close;
	}
	
	/**
	 * @return the max_macd
	 */
	public HistoryPojo getMax_macd(){
		return max_macd;
	}
	
	/**
	 * @param max_macd
	 *        the max_macd to set
	 */
	public void setMax_macd(HistoryPojo max_macd){
		this.max_macd=max_macd;
	}
	
	/**
	 * @return the min_macd
	 */
	public HistoryPojo getMin_macd(){
		return min_macd;
	}
	
	/**
	 * @param min_macd
	 *        the min_macd to set
	 */
	public void setMin_macd(HistoryPojo min_macd){
		this.min_macd=min_macd;
	}
	
}
