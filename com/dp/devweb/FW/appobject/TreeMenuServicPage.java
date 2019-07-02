package dp.devweb.FW.appobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dp.devweb.common.CommonObject;

/**
 * 
* @Title: TreeMenuServicPage.java 
* @Description: TODO(业务菜单) 
* @author z01674 
* @date 2015年7月2日 下午4:41:54 
* @version V4.4
 */

public class TreeMenuServicPage {
	public CommonObject obj = new CommonObject();
	
	/**
	 * 顶端业务按钮
	 */
	public WebElement topService() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='test-top-tab']/table/tbody/tr/td[1]/table/tbody/tr/td[2]/table/tbody/tr/td[2]"));
	}
	
	/**
	 * vpn
	 */
	public WebElement liVPN() throws Exception {
		return obj.getElement(By.id("menu_M_VPN"));
	}
	
	public WebElement lnkVPN() throws Exception {
		return obj.getElement(By.linkText("VPN"));
	}
	
	/**
	 * IPSec
	 */
	public WebElement liIPSec() throws Exception {
		return obj.getElement(By.id("menu_T_Security_IPSec"));
	}
	
	public WebElement lnkIPSec() throws Exception {
		return obj.getElement(By.linkText("IPSec"));
	}
	
	
	/**
	 * IPSec VPN
	 */
	public WebElement liIPSecVPN() throws Exception {
		return obj.getElement(By.id("menu_T_Security_IPSec_Main"));
	}
	public WebElement lnkIPSecVPN() throws Exception {
		return obj.getElement(By.linkText("IPSec VPN"));
	}
	
	
	/**
	 * SSL VPN
	 */
	public WebElement liSSLVPN() throws Exception {
		return obj.getElement(By.id("menu_T_Security_SSL"));
	}
	
	public WebElement lnkSSlVPN() throws Exception {
		return obj.getElement(By.linkText("SSL VPN"));
	}
	
	
	/**
	 * @return 业务——VPN——SSLVPN——基本配置
	 * @throws Exception
	 */
	public WebElement lnkBaseConfigSSLVPNPage() throws Exception {
		return obj.getElement(By.linkText("基本配置"));
	}
	
	/**
	 * 业务——VPN——SSLVPN——用户管理
	 */
	public WebElement lnkUserManagement() throws Exception {
		return obj.getElement(By.linkText("用户管理"));
	}
	
	
	
}
