package dp.devweb.FW.appobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dp.devweb.common.CommonObject;
import dp.devweb.common.CommonObjectScript;

/**
 * 
* @Title: NToNNatPage.java 
* @Description: TODO(获取多对多NAT配置界面的元素) 
* @author z01674 
* @date 2015年4月27日 上午9:23:18 
* @version V4.4
 */

public class NToNNatPage extends CommonObjectScript {
	
	//实例化公共对象
	CommonObject obj = new CommonObject();
	
	/**
	 * @return 多对多表格
	 */
	public WebElement tablNToNNat() throws Exception {
		return obj.getElement(By.id("nat_nton"));
	}
	
	/**
	 * @return 公网接口选择框
	 */
	public WebElement textNetInterface() throws Exception {
		return obj.getElement(By.id("select_interface"));
	}
	
	/**
	 * @return 内网地址文本输入框
	 */
	public WebElement textInAddr() throws Exception {
		return obj.getElement(By.id("input_innet_ip"));
	}
	
	/**
	 * @return 公网地址文本输入框
	 */
	public WebElement textNetAddr() throws Exception {
		return obj.getElement(By.id("input_net_ip"));
	}
	
	/**
	 * @return 复制按钮
	 */
	public WebElement spnCopy() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='nat_nton']/tbody/tr[1]/td[6]/span[1]"));
	}
	
	/**
	 * @return black
	 */
	public WebElement black() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='INNER']/div[2]/div[2]"));
	}
	
	/**
	 * 序号
	 */
	public WebElement xuhao() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='INNER']/div[2]/div[2]/div/table/thead/tr/th[1]/div"));
	}                                  
	
	/**
	 * 第一行中的删除按钮
	 */
	public WebElement spnDelet() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='nat_nton']/tbody/tr[1]/td[6]/span[2]"));
	}
	
}
