package dp.devweb.FW.appobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dp.devweb.common.CommonObject;

/**
 * 
* @Title: SslVpnPage.java 
* @Description: TODO(获取ssl vpn界面元素) 
* @author z01674 
* @date 2015年7月2日 下午2:13:55 
* @version V4.4
 */

public class SslVpnPage {
	public CommonObject obj = new CommonObject();
	
	//继续浏览此网站按钮
//	public WebElement buttonGO() throws Exception {
//		return obj.getElement(By.id("continueToSite"));
//	}
	
	public WebElement buttonGO() throws Exception {
		return obj.getElement(By.xpath("//*[@id='continueToSite']"));
	}
	
	//用户名文本输入框
	public WebElement textUserName() throws Exception {
		return obj.getElement(By.id("username"));
	}
	
	//密码文本输入框
	public WebElement textPassword() throws Exception {
		return obj.getElement(By.id("password"));
	}
	
	//登陆按钮
	public WebElement buttonLogin() throws Exception {
//		return obj.getElement(By.id(""));
		return obj.getElement(By.name("Submit"));
	}
	
	//退出页面按钮
	public WebElement buttonLogOut() throws Exception {
		return obj.getElement(By.id("logoutvpn"));
//		return obj.getElement(By.partialLinkText(linkText))
	}
	
	
}
