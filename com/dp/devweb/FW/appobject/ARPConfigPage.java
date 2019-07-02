package dp.devweb.FW.appobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dp.devweb.common.CommonObject;

/**
 * 
* @Title: ARPConfigPage.java 
* @Description: TODO(ARP配置界面) 
* @author z01674 
* @date 2015年5月13日 上午10:02:00 
* @version V4.4
 */

public class ARPConfigPage {
	
	//实例化公共对象
	public CommonObject obj = new CommonObject();
	
	/**
	 * 基本——网络管理
	 */
	public WebElement lnkNetManagement() throws Exception{
		return obj.getElement(By.linkText("网络管理"));
	}
	
	/**
	 * 查看网络管理是否为展开项
	 */
	public WebElement liNetManagement() throws Exception {
		return obj.getElement(By.id("menu_M_Net_Management"));
	}
	
	/**
	 * 网络管理——ARP
	 */
	public WebElement lnkARP() throws Exception {
		return obj.getElement(By.linkText("ARP"));
	}
	
	/**
	 * 查看ARP是否为展开项
	 */
	public WebElement liARP() throws Exception {
		return obj.getElement(By.id("menu_M_ARP"));
	}
	
	/**
	 * ARP——ARP配置
	 */
	public  WebElement lnkARPConfig() throws Exception {
		return obj.getElement(By.linkText("ARP配置"));
	}
	
	/**
	 * 动态ARP参数配置
	 */
	public WebElement dynaARPConfig() throws Exception {
		return obj.getElement(By.id("T_Arp_explore2"));
	}
	
	/**
	 * 关闭ARP被动学习功能checkBox 
	 */
	public WebElement checkDisablePassiveARPLearning() throws Exception {
		return obj.getElement(By.id("close_request_arp"));
	}
	
	/**
	 * 关闭ARP主动学习功能 checkBox
	 */
	public WebElement checkDisableActiveARPLearning() throws Exception {
		return obj.getElement(By.id("close_arp"));
	}
	
	/**
	 * 关闭ARP表项更新功能checkBox
	 */
	public WebElement checkDisableARPUpdate() throws Exception {
		return obj.getElement(By.id("close_arp_update"));
	}
	
	/**
	 * 开启ARP响应接口UP功能checkBox
	 */
	public WebElement checkEnableARPRespIntfUP() throws Exception {
		return obj.getElement(By.id("enable_arp_event"));
	}
	
	/**
	 * ARP老化时间文本框
	 */
	public WebElement textARPAging() throws Exception {
		return obj.getElement(By.id("old_time"));
	}
	
}
