package dp.devweb.FW.appobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dp.devweb.common.CommonObject;

/**   
 * @Title: zhangmeiPage.java 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Administrator 
 * @date 2015年2月11日 上午9:32:48 
 * @version V4.4   
 */
public class zhangmeiPage {
	// 实例化公共对象
	public CommonObject obj = new CommonObject();
	
	/**
	 * 基本 -> 网络管理
	 * @return
	 */
	public WebElement lnkNetManagement() {
		return obj.getElement(By.linkText("网络管理"));
	}
	
	public WebElement liNetManagement() {
		return obj.getElement(By.id("menu_M_Net_Management"));
	}
	
	public WebElement lnkIntfManagement() {
		return obj.getElement(By.linkText("接口管理"));
	}
	
	public WebElement liIntfManagement() {
		return obj.getElement(By.id("menu_T_Ifmode_Config"));
	}
	
	public WebElement lnkNetConfig() {
		return obj.getElement(By.xpath("//*[@id='menu_T_Config_Ifmode']/a/span"));
	}
	
	public WebElement tblNetConfig() {
		return obj.getElement(By.id("ifmode_LIST"));
	}
	
	public WebElement sltIPAddr() {
		return obj.getElement(By.id("ipalloc_mode"));
	}
	
	public WebElement txtIP() {
		return obj.getElement(By.id("ipaddr"));
	}
	
	public WebElement sltMask() {
		return obj.getElement(By.id("mask"));
	}
	
	public WebElement spnOK() {
		return obj.getElement(By.xpath("//span[text()='确定']"));
	}
	
	public WebElement btnConfirm() {
		return obj.getElement(By.xpath("//input[@value='确认']"));
	}
}
