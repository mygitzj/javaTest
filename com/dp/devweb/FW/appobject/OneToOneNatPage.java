package dp.devweb.FW.appobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dp.devweb.common.CommonObject;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonTable;

/**
 * 
* @Title: OneToOneNetPage.java 
* @Description: TODO(一对一NAT配置界面) 
* @author z01674 
* @date 2015年4月24日 下午3:55:30 
* @version V4.4
 */

public class OneToOneNatPage extends CommonObjectScript{
	
	//实例化公共对象
	public CommonObject obj = new CommonObject();
	
	/**
	 * 基本--防火墙--一对一NAT
	 * @return table对象
	 */
	
	public WebElement tabOneToOneNet() throws Exception {
		return obj.getElement(By.id("nat_1to1"));
	}
	
	/**
	 * tabl
	 * @return 第一行最后一列列的Copy对象
	 */
	public WebElement spnCopy() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='nat_1to1']/tbody/tr[1]/td[7]/span[2]"));
	}
	
	/**
	 * tabel
	 * @return name 
	 */
	public WebElement  confName() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='nat_1to1']/tbody/tr/td[2]/a"));
	}
	
	/**
	 * @return 名称文本输入框
	 */
	public WebElement textName() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='input_name']"));
	}
	
	/**
	 * @return black
	 */
	public WebElement black() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='INNER']/div[2]/div[2]"));
	}
	
	/**
	 * @return 公网接口文本输入框对象
	 */
	public WebElement cellNetInterface() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='nat_1to1']/tbody/tr/td[3]"));
	}
	
	
	/**
	 * table
	 * @return Net Interface 公网接口选择框
	 */
	public WebElement slecNetInterface() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='select_interface']"));
	}
	
	/**
	 * table
	 * @return 内网地址text
	 */
	public WebElement textIntranetAddress() throws Exception {
		return obj.getElement(By.id("input_innet_ip"));
	}
	
	/**
	 * table
	 * @return 公网地址text
	 */
	public WebElement textNetAddr() throws Exception {
		return obj.getElement(By.id("input_net_ip"));
	}
	
	
	/**
	 * 删除按钮
	 */
	public WebElement spnDelete1T1Nat(int row) throws Exception {
		return obj.getElement(By.xpath(".//*[@id='nat_1to1']/tbody/tr["+(row+1)+"]/td[7]/span[3]"));

	}
	
}
