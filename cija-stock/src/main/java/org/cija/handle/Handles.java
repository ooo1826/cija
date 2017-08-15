/**
 * 文件名： MacdHandles.java
 * 包名： org.cija.tools
 * 描述： []
 * 创建时间： 2017年7月29日 下午9:11:33
 * @author FC
 */

package org.cija.handle;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cija.Const;
import org.cija.date.DateUtils;
import org.cija.tools.CsvUtils;

import com.cija.task.bo.HistoryPojo;

/**
 * 类名： MacdHandles
 * 公司名称： []
 * 描述：[]
 * 创建时间： 2017年7月29日 下午9:11:33
 * @author FC
 */
public class Handles{
	
	/**
	 * 
	 * 方法名： h
	 * 描述：[]
	 * 创建时间： 2017年7月30日 下午1:16:09
	 * @param param
	 */
	public static void h(Map<String,Object> param){
		// 每次调整区间振幅，开始调整的价格，结束调整的价格
		// 本次下跌多少，回调多少
		// 什么样的diff开始回调幅度最高--
		// 最高点、最低点、回调最高点、向上交叉点、向下交叉点、MW低个数（每次起伏算一个低）
		// 最新的macd
		// 最新diff与dea的差
	}
	
	/**
	 * 
	 * 方法名： m
	 * 描述：[计算调整波次、最后一波调整V型个数、本次调整幅度（最高价-最低价）、小阳星个数]
	 * 创建时间： 2017年7月30日 下午1:50:13
	 * @param param
	 */
	
	/**
	 * 
	 * 方法名： month
	 * 描述：[月线处理]
	 * 创建时间： 2017年8月15日 下午8:29:46
	 * @param param
	 */
	public static void month(final String file){
		List<HistoryPojo> histories=new ArrayList<HistoryPojo>();
		Map<String,Object> param=new HashMap<String,Object>();
		// 解析股票数据
		CsvUtils.readCsv(file,histories,HistoryPojo.class);
		MacdUtils.macd(histories,param,false);
		List<List<HistoryPojo>> result=new ArrayList<List<HistoryPojo>>();
		
		monthHandle(histories,result);
		int size=result.size()-1;
		for(int i=0;i<size;i++){
			
		}
		
		for(List<HistoryPojo> list:result){
			System.out.println("===================================="+DateUtils.dateToStr(list.get(0).getDate(),"yyyy-MM-dd"));
			for(HistoryPojo historyPojo:list){
				System.out.println(historyPojo.getMacd());
			}
			System.out.println("===================================="+DateUtils.dateToStr(list.get(list.size()-1).getDate(),"yyyy-MM-dd"));
		}
	}
	
	/**
	 * 方法名： monthHandle
	 * 描述：[]
	 * 创建时间： 2017年8月15日 下午8:48:38
	 * @param histories
	 */
	private static void monthHandle(List<HistoryPojo> histories,List<List<HistoryPojo>> result){
		// TODO Auto-generated method stub
		if(histories!=null){
			boolean status=false;// true时创建新对象，false时继续遍历
			
			List<HistoryPojo> hiss=null;
			int size=histories.size()-1;
			for(int i=0;i<size;i++){
				HistoryPojo his=histories.get(i);
				
				if(status){
					hiss=new ArrayList<HistoryPojo>();
					status=false;
				}
				if(hiss!=null){
					hiss.add(his);
				}
				
				BigDecimal his_i_macd=his.getMacd();
				BigDecimal his_i_1_macd=histories.get(i+1).getMacd();
				BigDecimal num0=new BigDecimal(0);
				if((his_i_macd.compareTo(num0)>=0&&his_i_1_macd.compareTo(num0)>=0)||(his_i_macd.compareTo(num0)<0&&his_i_1_macd.compareTo(num0)<0)){
					status=false;
				}else{
					if(hiss!=null){
						result.add(hiss);
					}
					status=true;
				}
			}
		}
		
	}
	
	public static void main(String[] args){
		month("C:/new_gdzq_v6/wstock/SZ/SZ300017.csv");
	}
}
