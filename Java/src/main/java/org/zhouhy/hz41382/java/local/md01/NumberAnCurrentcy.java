package org.zhouhy.hz41382.java.local.md01;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
* <p>className: NumberAnCurrentcy</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年2月27日
*/
public class NumberAnCurrentcy {
	private static final Logger LOGGER = LoggerFactory.getLogger(NumberAnCurrentcy.class);
	
	public static void main(String[] args) {
		Locale aLocale=new Locale("zh","CN");
		Locale bLocale=new Locale("ru","RU");//俄语
		Locale cLocale=Locale.FRANCE;//欧洲
		
		Integer number=new Integer(123456);
		
		NumberAnCurrentcy n=new NumberAnCurrentcy();
		n.formatNumber(aLocale, number);
		n.formatNumber(bLocale, number);
		n.formatNumber(cLocale, number);
		
		n.formatCurrentcy(aLocale, number);
		n.formatCurrentcy(bLocale, number);
		n.formatCurrentcy(cLocale, number);


	}
	
	//本地化数字
	private  void formatNumber(Locale aLocale, Integer number) {
		//NumberFormat用来格式化数字，创建的时候使用静态方法，传的参数是国家和地区或者语言
		NumberFormat numberFormat=NumberFormat.getNumberInstance(aLocale);//参数表示确定的国家
		//使用本地的数字的格式 格式化目标数字
		String result=numberFormat.format(number);
		LOGGER.info(result);
	}
	
	//本地化货币
	private  void formatCurrentcy(Locale aLocale, Integer number) {
		NumberFormat numberFormat=NumberFormat.getCurrencyInstance(aLocale);//参数表示确定的国家
		String result=numberFormat.format(number);
		
		Currency c=Currency.getInstance(aLocale);//返回本地货币的对象
		LOGGER.info(c.getDisplayName()+"："+result);//getDisplayName方法显示货币的名字
	}

	

}
