package dp.devweb.DPX.appobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dp.devweb.common.CommonObject;
import dp.devweb.common.CommonTable;

/**
 * 
* @Title: Aut8021xPage.java 
* @Description: TODO(DPX主控板802.1x认证配置界面元素) 
* @author z01674 
* @date 2015年7月14日 下午7:28:34 
* @version V4.4
 */

public class Aut8021xPage {
	public CommonObject obj = new CommonObject();
	
	/**
	 * top802.1x认证
	 */
	public WebElement top8021x() throws Exception {
		return obj.getElement(By.id("T_Dot1x_Auth_Config2"));
	}
    
	/**
	 * check 启用
	 */
	public WebElement checkEnableAuth() throws Exception {
		return obj.getElement(By.id("enable_auth"));
	}
	
	/**
	 * check 禁用
	 */
	public WebElement checkDisableAuth() throws Exception {
		return obj.getElement(By.id("disable_auth"));
	}
	
	/**
	 * top用户配置
	 */
	public WebElement topUserConf() throws Exception {
		return obj.getElement(By.id("T_Dot1x_Auth_User_Cfg2"));
	}
	
	/**
	 * top用户配置表格
	 */
	public WebElement tableUserConf() throws Exception {
		return obj.getElement(By.id("user_auth_info"));
	}
	
	/**
	 * top 用户配置——复制按钮
	 */
	
	public WebElement buttonCopyUserConf() throws Exception {
		WebElement cell = CommonTable.getCellObject(tableUserConf(), 0, 7);
		return obj.getElementByXpath(cell, "//span[@class='gop GOP_COPY']");
	}
	
	/**
	 * top用户配置——删除按钮
	 */
   public WebElement buttonDeleUserConf(int count) throws Exception {
	   return obj.getElement(By.xpath(".//*[@id='user_auth_info']/tbody/tr['"+count+"']/td[1]/input"));
   }
	
	                                  
	/**
	 * top用户配置——用户名文本输入框
	 */
	public WebElement  textUserName() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='userNameInput']"));
	}
	
	/**
	 * top用户配置——密码配置
	 */
	public WebElement textpassword() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='userPassInput']"));
	}
	
	/**
	 * top用户配置——确认密码文本输入框
	 */
	public WebElement textConfimPassword() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='userAPasInput']"));
	}

	/**
	 * top用户配置——描述文本输入框
	 */
	public WebElement textDescription() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='userDescInput']"));
	}
}
