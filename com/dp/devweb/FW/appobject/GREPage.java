package dp.devweb.FW.appobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dp.devweb.common.CommonObject;

/**
 * 
* @Title: GREPage.java 
* @Description: TODO(GRE页面元素) 
* @author z01674 
* @date 2015年7月13日 下午2:26:05 
* @version V4.4
 */

public class GREPage {
	public CommonObject obj = new CommonObject();
	
	/**
	 * GRE4配置表格
	 */
	public WebElement tableGRE4() throws Exception {
		return obj.getElement(By.id("greinfo_list"));
	}
	
	/**
	 * 复制按钮
	 */
	public WebElement buttonCopy4() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='greinfo_list']/tbody/tr/td[8]/span[1]"));
	}
	
	/**
	 * GRE删除按钮
	 */
	public WebElement buttonDel4(String name)throws Exception {
		return obj.getElement(By.xpath(".//*[@id='" + name + "']/td[8]/span[2]"));
	}                                  

	
	
	/**
	 * 确定按钮
	 */
	public WebElement buttonOK() throws Exception {
		return obj.getElement(By.xpath("html/body/div[4]/div[3]/div/button[1]"));
	}                                   
//	                                    html/body/div[4]/div[3]/div/button[1]
    
	/**
	 * GRE4配置表格——隧道接口编号文本输入框
	 */
	public WebElement textTunnlNamev4() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='tunnelname_input']"));
	}
	
	/**
	 * GRE4配置表格——隧道接口IP——IPV4文本输入框
	 */
	public WebElement textIPV4() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='tun_ip']"));
	}
	
	/**
	 * GRE4配置表格——隧道接口IP——IPV4子网掩码文本选择框
	 */
	public WebElement selMask4() throws Exception {
		return obj.getElement(By.id("tun_ip_mask"));
	}
	
	/**
	 * GR4配置表格——隧道接口IP——IPV6文本输入框
	 */
	public WebElement textIPV6() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='tun_ip6']"));
	}
	
	/**
	 * GRE4配置表格——隧道接口IP——源IP文本输入框
	 */
	public WebElement textSource4() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='sip_input']"));
	}
	
	/**
	 * GRE4配置表格——隧道接口IP——目的IP文本输入框
	 */
	public WebElement textDest4() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='dip_input']"));
	}
	
	/**
	 * GRE4配置表格——高级配置——启用GRE链接检测
	 */
	public WebElement checkGRElink() throws Exception {
		return obj.getElement(By.id("link_check"));
	}
	
	/**
	 * GRE4配置表格 ——高级配置——启用路径发现MTU
	 */
	public WebElement checkPathMTU() throws Exception {
		return obj.getElement(By.id("path_mtu"));
	}
	
	/**
	 * GRE4配置表格——高级配置——启用checksum校验
	 */
	public WebElement checkSum() throws Exception {
		return obj.getElement(By.id(".//*[@id='check_sum']"));
	}
	
	/**
	 * GRE4配置表格——高级配置——密码
	 */
	public WebElement textTunnelPassword() throws Exception {
		return obj.getElement(By.id(".//*[@id='tunnel_key']"));
	}
	
	/**
	 * GRE4配置表格 ——描述信息
	 */
	public WebElement textDescription4() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='desc_input']"));
	}
	
	/**
	 * GRE6配置表格
	 */
	public WebElement tableGRE6() throws Exception {
		return obj.getElement(By.id("gre6info_list"));
	}
	
	
}
