package dp.devweb.DPX.appobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dp.devweb.common.CommonObject;

/**
* @Title: TreeMenuePage.java 
* @Description: TODO(DPX设备主控板菜单栏) 
* @author z01674 
* @date 2015年7月14日 下午5:20:49 
* @version V4.4
 */

public class TreeMenueDPXPage {
	public CommonObject obj = new CommonObject();
	
	
	/**
	 * 认证管理li
	 */
	public WebElement liAuthManagement() throws Exception {
		return obj.getElement(By.id("menu_M_Auth_Management"));
	}
	
	/**
	 * lnk认证管理
	 */
	public WebElement lnkAuthManagement() throws Exception {
		return obj.getElement(By.linkText("认证管理"));
	}
	
	/**
	 * lnk802.1x
	 */
	public WebElement lnk8021x() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='menu_T_Dot1x']/a/span"));
	}
	
}
