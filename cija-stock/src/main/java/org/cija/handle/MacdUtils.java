package org.cija.handle;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.cija.Const;
import org.cija.date.DateUtils;
import org.cija.tools.CsvUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.cija.task.bo.Adjust;
import com.cija.task.bo.HistoryPojo;

@SuppressWarnings("all")
public class MacdUtils{
	
	/**
	 * 方法名： objToJson
	 * 描述：[]
	 * 创建时间： 2017年7月23日 下午3:10:17
	 * @param map
	 */
	public static <T> String objToJSONString(T obj){
		return JSON.toJSONStringWithDateFormat(obj,"yyyy-MM-dd",SerializerFeature.UseISO8601DateFormat);
	}
	
	/**
	 * 方法名： paramValidate
	 * 描述：[]
	 * 创建时间： 2017年7月23日 上午11:10:00
	 * @param map
	 * @param req
	 */
	public static void paramValidate(Map<String,Object> map,String[] req){
		for(String key:req){
			if(map.get(key)==null){ throw new NullPointerException("请求参数["+key+"]不能为空."); }
		}
	}
	
	private static final int precision12=12;
	private static final int precision10=10;
	private static final int precision5	=5;
	private static final int precision4	=4;
										
	/**
	 * 
	 * 方法名： macd
	 * 描述：[计算macd、diff、dea]
	 * 创建时间： 2017年7月22日 下午2:33:17
	 * @param histories
	 * @param map
	 *        
	 */
	public static void macd(final List<HistoryPojo> histories,final Map<String,Object> map){
		// 最近一个高点时间--配置获取
		Date date=(Date)map.get(Const.INTERCEPT_start_date);
		
		BigDecimal ema12=new BigDecimal(0);
		BigDecimal ema12_front=new BigDecimal(0);
		
		BigDecimal ema26=new BigDecimal(0);
		BigDecimal ema26_front=new BigDecimal(0);
		
		BigDecimal dea_front=new BigDecimal(0);
		
		BigDecimal dea=new BigDecimal(0);
		BigDecimal diff=new BigDecimal(0);
		BigDecimal macd=new BigDecimal(0);
		
		BigDecimal max=new BigDecimal(0);
		
		for(int i=0;i<histories.size();i++){
			HistoryPojo history=histories.get(i);
			/* ==========================#计算macd开始========================== */
			if(i==0){
				// 第一天ema12、ema26=当日收盘价
				ema12_front=history.getClose();
				ema26_front=history.getClose();
				// 第一天macd、diff、dea都为0
				history.setMacd(macd);
				history.setDiff(diff);
				history.setDea(dea);
				continue;
			}
			BigDecimal close=history.getClose();
			// <1>计算12日和26日移动平均线EMA1和EMA2
			// 当日EMA(12)=前一日EMA(12)×11/13＋当日收盘价×2/13
			ema12=(ema12_front.multiply(divide_11_13())).add(close.multiply(divide_2_13())).setScale(MacdUtils.precision10,RoundingMode.HALF_UP);
			// 当日EMA(26)=前一日EMA(26)×25/27＋当日收盘价×2/27
			ema26=(ema26_front.multiply(divide_25_27())).add(close.multiply(divide_2_27())).setScale(MacdUtils.precision10,RoundingMode.HALF_UP);
			// <2>计算离差值(DIFF)
			// DIFF=当日EMA(12)－当日EMA(26)
			diff=ema12.subtract(ema26).setScale(MacdUtils.precision10,RoundingMode.HALF_UP);
			// <3>计算9日离差平均值DEA
			// 当日DEA=前一日DEA×8/10＋当日DIFF×2/10
			dea=(dea_front.multiply(divide_8_10())).add(diff.multiply(divide_2_10())).setScale(MacdUtils.precision10,RoundingMode.HALF_UP);
			// <4>计算MACD
			// MACD=2×(DIFF－DEA)
			macd=num2.multiply(diff.subtract(dea)).setScale(MacdUtils.precision5,RoundingMode.HALF_UP);
			
			history.setMacd(macd.setScale(MacdUtils.precision4,RoundingMode.HALF_UP));
			history.setDiff(diff.setScale(MacdUtils.precision4,RoundingMode.HALF_UP));
			history.setDea(dea.setScale(MacdUtils.precision4,RoundingMode.HALF_UP));
			
			ema12_front=ema12;
			ema26_front=ema26;
			dea_front=dea;
			/* ==========================#计算macd结束========================== */
			/* ==========================#计算最近至高点日期开始========================== */
			if(history.getDate().getTime()>date.getTime()){
				if(history.getClose().compareTo(max)>0){
					max=history.getClose();
					map.put(Const.INTERCEPT_max_colse,history);
				}
			}
			/* ==========================#计算最近至高点日期结束========================== */
		}
		map.put(Const.histories,histories);
		
	}
	
	/**
	 * 
	 * 方法名： handle
	 * 描述：[数据处理]
	 * 创建时间： 2017年7月22日 下午2:51:11
	 * @param histories
	 * @param map
	 */
	public static Map<String,Object> handle(final List<HistoryPojo> histories,final Map<String,Object> map){
		macd(histories,map);
		/* ==========================#短期最高收盘价往后的macd数据========================== */
		
		HistoryPojo INTERCEPT_max_colse=(HistoryPojo)map.get(Const.INTERCEPT_max_colse);
		// 存储最高点后的macd数据
		List<HistoryPojo> INTERCEPT_histories=new ArrayList<HistoryPojo>();
		// 入库
		for(HistoryPojo his:histories){
			if(his.getDate().getTime()>=INTERCEPT_max_colse.getDate().getTime()){
				INTERCEPT_histories.add(his);
			}
		}
		// 存放到map
		map.put(Const.INTERCEPT_histories,INTERCEPT_histories);
		return map;
	}
	
	public static BigDecimal divide_11_13(){
		return num11.divide(num13,MacdUtils.precision12,RoundingMode.HALF_UP);
	}
	
	public static BigDecimal divide_2_13(){
		return num2.divide(num13,MacdUtils.precision12,RoundingMode.HALF_UP);
	}
	
	public static BigDecimal divide_25_27(){
		return num25.divide(num27,MacdUtils.precision12,RoundingMode.HALF_UP);
	}
	
	public static BigDecimal divide_2_27(){
		return num2.divide(num27,MacdUtils.precision12,RoundingMode.HALF_UP);
	}
	
	public static BigDecimal divide_8_10(){
		return num8.divide(num10,MacdUtils.precision12,RoundingMode.HALF_UP);
	}
	
	public static BigDecimal divide_2_10(){
		return num2.divide(num10,MacdUtils.precision12,RoundingMode.HALF_UP);
	}
	
	private static final BigDecimal	num2 =new BigDecimal(2);
	private static final BigDecimal	num8 =new BigDecimal(8);
	private static final BigDecimal	num10=new BigDecimal(10);
	private static final BigDecimal	num11=new BigDecimal(11);
	private static final BigDecimal	num13=new BigDecimal(13);
	private static final BigDecimal	num25=new BigDecimal(25);
	private static final BigDecimal	num27=new BigDecimal(27);
										 
}
