package dp.devweb.FW.appobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dp.devweb.common.*;

/**   
 * @Title: INTsecuritydomainPage.java 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Administrator 
 * @date 2015年2月11日 下午2:15:09 
 * @version V4.4   
 */
public class INTsecuritydomainPage {
	
// 实例化公共对象
	public  CommonObject  obj = new CommonObject();
	
	/**
	 * 基本-》网络管理
	 */
	public WebElement lnkNetManagement() throws Exception{
		return obj.getElement(By.linkText("网络管理"));
	}
	
	/**
	 * 查看是否为展开项
	 */
		
	public WebElement liNetManagement() {
		return obj.getElement(By.id("menu_M_Net_Management"));	
	}
	
	
	/**
	 * 网络管理-》网络对象
	 */
	public WebElement NetObj() {
		return obj.getElement(By.linkText("网络对象"));
	}
	public WebElement liNetObj() {
		return obj.getElement(By.id("menu_T_Network_Object"));	
	}
	
	
	/**
	 * 安全域
	 */
	public WebElement lnkSecurityDomain() {
		return obj.getElement(By.id("menu_T_Network_Security_Zone"));
	}
	/**
	 * 获取trust栏中的接口
	 */
	public WebElement Interface() {
		return obj.getElement(By.xpath("//*[@id='securityzone']/tbody/tr[1]/td[3]"));
	}
//	/**
//	 * 获取端口1_4
//	 */
//	public WebElement Num() {
//		return obj.getElement(By.id("security_face_check_7"));	
//	}
	
	/**
	 * 获取表格
	 */
	public WebElement tblSecurityDomain() {
		return obj.getElement(By.id("securityzone"));
	}
	
	public WebElement labIntf (String str) {
		return obj.getElement(By.xpath("//label[text()='" + str + "']"));		
	}
	/**
	 * 点击确定
	 */
	public WebElement spnOK() {
		return obj.getElement(By.xpath("//span[text()='确定']"));
	}
	
	public WebElement btnConfirm() {
		return obj.getElement(By.xpath("//input[@value='确认']"));
	}
	}
	
