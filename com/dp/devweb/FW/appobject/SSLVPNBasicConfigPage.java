package dp.devweb.FW.appobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dp.devweb.common.CommonObject;
import dp.devweb.common.CommonTable;

/**
 * 
* @Title: SSLVPNBasicConfigPage.java 
* @Description: TODO(SSLVPN 基本配置界面元素) 
* @author z01674 
* @date 2015年7月3日 下午4:31:58 
* @version V4.4
 */

public class SSLVPNBasicConfigPage {
public CommonObject obj = new CommonObject();

	/**
	 * 表格对象
	 */
	public WebElement tableConfig() throws Exception {
		return obj.getElement(By.id("ssl_set_id"));
	}
	
	/**
	 * 顶端全局配置
	 */
	public WebElement topGlobalConfig() throws Exception {
		return obj.getElement(By.id("T_Vpn_Config2"));
	}
	
	/**
	 * 启动ssl-vpn勾选框
	 */
	public WebElement checkEnableSSL() throws Exception {
		return obj.getElement(By.id("ssl_start"));
	}
	
	/**
	 * 高级配置显示按钮
	 */
	public WebElement buttAdvanceConfig() throws Exception{
		return obj.getElement(By.id("img_id"));
	}
	
	/**
	 * 允许账户公用选项
	 */
	public WebElement butReuseAccount() throws Exception {
		return obj.getElement(By.id("user_unique_check_view_id"));
	}
	
	public WebElement selReuseAccount() throws Exception {
		return obj.getElement(By.id("user_unique_check"));
	}
	
	/**
	 * 允许用户修改密码
	 */
	public WebElement butModifyPassword() throws Exception {
		return obj.getElement(By.id("change_pwd_enble_view_id"));
	}
	
	public WebElement selModifyPassword() throws Exception {
		return obj.getElement(By.id("change_pwd_enble"));
	}
	
	/**
	 * 同步修改密码
	 */
	public WebElement butSyncChangePassword() throws Exception {
		return obj.getElement(By.id("sync_chpwd_enble_view_id"));
	}
	
	public WebElement selSyncChangePassword() throws Exception {
		return obj.getElement(By.id("sync_chpwd_enable"));
	}
	
	/**
	 * 只允许访问VPN
	 */
	public WebElement butOnlyAccessVPN() throws Exception {
		return obj.getElement(By.id("access_vpn_only"));
	}                           
	
	public WebElement selOnlyAccessVPN() throws Exception {
		return obj.getElement(By.id("access_vpn_only"));
	}
	
	/**
	 * 是否开启报表统计
	 */
	public WebElement butEnableStatFlux() throws Exception {
		return obj.getElement(By.id("form_stat_view_id"));
	}
	
	public WebElement selEnableStatFlux() throws Exception {
		return obj.getElement(By.id("form_stat"));
	}
	
	/**
	 * 允许VPN助手登陆
	 */
	public WebElement butPermitVPNHelperLogin() throws Exception {
		return obj.getElement(By.id("vpn_helper_access_view_id"));
	}
	
	public WebElement seltPermitVPNHelperLogin() throws Exception {
		return obj.getElement(By.id("vpn_helper_access"));
	}
	
	/**
	 * 允许浏览器登陆
	 */
	public WebElement butWebUserLogin() throws Exception {
		return obj.getElement(By.id("vpn_browser_access_view_id"));
	}
	
	public WebElement selWebUserLogin() throws Exception {
		return obj.getElement(By.id("vpn_browser_access"));	
	}
	
	/**
	 * 关闭浏览器时退出客户端
	 */
	public WebElement butClientexits() throws Exception {
		return obj.getElement(By.id("client_quit_view_id"));
	}	
	
	public WebElement selClientexits() throws Exception {
		return obj.getElement(By.id("client_quit"));
	}                              
	
	/**
	 * 启用校验和计算  
	 */
	public WebElement butEnableChecksu() throws Exception {
		return obj.getElement(By.id("udpchecksum_view_id"));
	}
	
	public WebElement selEnableChecksum() throws Exception {
		return obj.getElement(By.id("udpchecksum"));
	}
	
	/**
	 * 是否清楚缓存
	 */
	public WebElement butClearCatch() throws Exception {
		return obj.getElement(By.id("clear_cookie_buf_view_id"));
	}
	
	public WebElement selClearCatch() throws Exception {
		return obj.getElement(By.id("clear_cookie_buf"));
	}
	
	
	/**
	 * 是否记录日志
	 */
	public WebElement butEnableLog() throws Exception {
		return obj.getElement(By.id("enable_log_view_id"));
	}
	
	public WebElement selEnableLog() throws Exception {
		return obj.getElement(By.id("enable_log"));
	}
	
	/**
	 * 统计VPN在线时间
	 */
	public WebElement butVPNOnlineTime() throws Exception {
		return obj.getElement(By.id("online_time_view"));
	}
	
	public WebElement selVPNOnlineTime() throws Exception {
		return obj.getElement(By.id("online_time_mod"));
	}
	
	/**
	 * top IP地址池配置
	 */
	public WebElement topIPAddrPol() throws Exception {
		return obj.getElement(By.id("T_Vpn_Ip_Pool_Manage2"));
	}
	
	/**
	 * top IP地址池配置——表格
	 */
	public  WebElement tableIpAddrPol() throws Exception {
		return obj.getElement(By.id("ip_pool_list"));
	}
	
	/**
	 * top IP地址池配置——复制按钮
	 */
	public WebElement buttCopyIpAddrPol() throws Exception {
		
		return obj.getElement(By.xpath(".//*[@id='0']/td[7]/span[1]"));
	}
	
	/**
	 * top IP地址池配置——删除按钮
	 */
//	public WebElement buttonDeletIpAddrPol() throws Exception {
//		WebElement cell = CommonTable.getCellObject(tableIpAddrPol(), 2, 6);
//		return obj.getElementByXpath(cell, "//span[@class='gop GOP_DEL']");
//	}
	
	public WebElement buttonDeletIpAddrPol(String name ) throws Exception {	
		return obj.getElement(By.xpath(".//*[@name='" +name + "']/td[7]/span[2]"));
}
	
	
	/**
	 * top IP地址池配置——名称文本输入框
	 */
	public WebElement textNameIpAddrPol() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='mod_ip_pool_name']"));
	}
	
	/**
	 * top IP地址池配置——描述文本输入框
	 */
	public WebElement textDescript() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='mod_ip_pool_des']"));
	}
	
	/**
	 * top IP地址池配置——startIP
	 */
	public WebElement textStartIP() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='mod_IP_start']"));
	}
	
	/**
	 * top IP地址池配置——endIP
	 */
	public WebElement textEndIP() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='mod_IP_end']"));
	}
	
	/**
	 * top IP地址池配置——mask
	 */
	public WebElement selMaskIP() throws Exception {
		return obj.getElement(By.id("mod_netmask"));
	}
	
	/**
	 * top IP地址池配置——balck
	 */
	public WebElement blackIpAddrPol() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='INNER']/div[1]/div[2]/div/table/thead/tr/th[1]/div"));
	}

	
}
