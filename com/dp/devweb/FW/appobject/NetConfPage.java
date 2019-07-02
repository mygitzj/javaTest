package dp.devweb.FW.appobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dp.devweb.common.CommonObject;
import dp.devweb.common.CommonObjectScript;

/**
 * @Title: NetConfPage.java
 * @Description: 组网配置页面对象
 * @author w01866
 * @date 2014年12月3日 下午3:04:49
 * @version V4.4
 */
public class NetConfPage extends CommonObjectScript {

	// 公共对象类
	public CommonObject obj = new CommonObject();

	/**
	 * 
	 * @return 组网配置表格对象
	 * @throws Exception
	 */
	public WebElement tblNetConf() throws Exception {
		return obj.getElement(By.id("ifmode_LIST"));
	}
	
	/**
	 * 
	 * @return IP地址文本框对象
	 * @throws Exception
	 */
	public WebElement txtIpAddr() throws Exception {
		return obj.getElement(By.id("ipaddr"));
	}

	/**
	 * 
	 * @return 子网掩码对象
	 * @throws Exception
	 */
	public WebElement sltMask() throws Exception {
		return obj.getElement(By.id("mask"));
	}
	
	/**
	 * 
	 * @return ip地址类型，select对象
	 * @throws Exception
	 */
	public WebElement sltIpConfig() throws Exception {
		return obj.getElement(By.id("ipalloc_mode"));
	}	
	
}
