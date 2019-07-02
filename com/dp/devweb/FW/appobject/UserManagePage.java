package dp.devweb.FW.appobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dp.devweb.common.CommonObject;

/**
 * 
* @Title: UserConfigPage.java 
* @Description: TODO(用户管理配置界面) 
* @author z01674 
* @date 2015年7月10日 上午9:44:33 
* @version V4.4
 */

public class UserManagePage {
	
	public CommonObject obj = new CommonObject();
	
	/**
	 * top用户配置
	 */
	public WebElement topUserConf() throws Exception {
		return obj.getElement(By.id("T_Vpn_User_Manage2"));
	}
	
	/**
	 * 用户组信息配置表格
	 */
	public  WebElement tablUserGroupConf() throws Exception {
		return obj.getElement(By.id("user_group_list"));
	}
	
	/**
	 * @return 用户组配置表格 ——复制按钮
	 * @throws Exception
	 */
	public WebElement buttonCopy() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='user_group_list']/tbody/tr/td[9]/span[1]"));
	}
	
	/**
	 * 用户组配置表格——删除按钮
	 */
	public WebElement buttonDel(int count) throws Exception {
		return obj.getElement(By.xpath(".//*[@id='user_group_list']/tbody/tr[' "+ count +" ']/td[9]/span[2]"));
	}
	
	/**
	 * @return 用户组配置表格——名称文本输入框
	 * @throws Exception
	 */
	public WebElement textUserGroupName() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='grpname']"));
	}
	
	
	/**
	 * 用户信息配置表格
	 */
	public WebElement tableUser() throws Exception {
		return obj.getElement(By.id("ssl_user_List"));
	}
	
	/**
	 * 用户信息配置表格 ——复制按钮
	 */
	public WebElement buttonCopyUser() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='ssl_user_List']/tbody/tr/td[5]/span[1]"));
	}
	
	/**
	 * 用户信息配置表格——删除按钮
	 */
	public WebElement buttonDelUser(int count) throws Exception {
		return obj.getElement(By.xpath(".//*[@id='ssl_user_List']/tbody/tr['" + count + "']/td[5]/span[2]"));
	}
	                                                                        
	
	/**
	 * 用户信息配置表格——用户账户文本输入框
	 */
	public WebElement textUserName() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='usrname']"));
	}
	
	/**
	 * 用户信息配置表格——用户密码文本输入框
	 */
	public WebElement textPassword() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='uPW']"));
	}
	
	/**
	 * 用户信息配置表格——用户密码确认文本输入框
	 */
	public WebElement textPasswordConfirm() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='uPW2']"));
	}
	
	/**
	 * 用户信息配置表格——用户密码——确定 //不同的设备由于确定按钮所在的位置不同，所以xpath不一样
	 */
	public WebElement buttonOK() throws Exception {
		return obj.getElement(By.xpath("html/body/div[3]/div[1]/div/button[1]"));
	}
	
	/**
	 * 用户信息配置表格——所属用户组——已有用户组列表
	 */
	public WebElement selAvailUserGroup() throws Exception {
		return obj.getElement(By.id("group_add_list"));
	}
	
	/**
	 * 用户信息配置表格——所属用户组——向右增加按钮
	 */
	public WebElement buttonAdd() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='group_add_s']"));
	}
	
	/**
	 * 用户信息配置表格 ——所属用户组——向左删除按钮
	 */
	public WebElement buttonDelUserGroup() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='group_del_s']"));
	}
	
	/**
	 * 用户信息配置表格——所属用户组——已选择用户列表
	 */
	public WebElement selSeltedUserGroup() throws Exception {
		return obj.getElement(By.id("group_list"));
	}
	
}
