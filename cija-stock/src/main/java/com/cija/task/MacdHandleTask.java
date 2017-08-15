
package com.cija.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cija.Const;
import org.cija.date.DateUtils;
import org.cija.handle.MacdUtils;
import org.cija.tools.CsvUtils;

import com.cija.task.bo.HistoryPojo;

/**
 * 
 * 类名： MacdHandleTask 
 * 公司名称： []
 * 描述：[]
 * 创建时间： 2017年8月14日 下午9:02:42 
 * @author FC
 */
public class MacdHandleTask{
	
	public void handle() throws Exception{
		
		// TODO macd
		List<HistoryPojo> histories=new ArrayList<HistoryPojo>();
		Map<String,Object> param=new HashMap<String,Object>();
		param.put(Const.INTERCEPT_start_date,DateUtils.strToDate("2014-01-01",Const.FORMAT01));
		param.put(Const.unit_of_time,Const.week);
		MacdUtils.paramValidate(param,Const.req);
		// 解析股票数据
		CsvUtils.readCsv("C:/new_gdzq_v6/wstock/SZ/SZ300017.csv",histories,HistoryPojo.class);
		// macd数据处理
		MacdUtils.handle(histories,param);
		
		Map<String,Object> result=new HashMap<String,Object>();
		param.put("",result);
		
		/*-----------------#-----------------------------*/
		
		System.out.println(MacdUtils.objToJSONString(param.get(Const.INTERCEPT_histories)));
		/*-----------------#-----------------------------*/
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws Exception{
		long start=System.currentTimeMillis();
		new MacdHandleTask().handle();
		new MacdHandleTask().handle();
		new MacdHandleTask().handle();
		new MacdHandleTask().handle();
		
		long end=System.currentTimeMillis();
		
		System.out.println(end-start);
		
	}
}
