package dp.devweb.FW.appobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dp.devweb.common.CommonObject;

public class VlanInterfaceConfPage {
/**
 * 
* @Title: AddVlanPage.java 
* @Description: TODO(用一句话描述该文件做什么) 
* @author z01674 
* @date 2015年3月09日 上午14:12:39 
* @version V4.4
 */

	
	//实例化公共对象
	public CommonObject obj = new CommonObject();
	
	//基本---网络管理
	public WebElement lnkNetManagement() throws Exception {
		return obj.getElement(By.linkText("网络管理"));
	}
	
	//判断是否为展开项
	public WebElement liNetManagement() throws Exception {
		return obj.getElement(By.id("menu_M_Net_Management"));	
	}
	
	//接口管理
	public WebElement intfManagement() throws Exception {
	return obj.getElement(By.xpath(".//*[@id='menu_T_Ifmode_Config']/a/span"));
		
	}                                                       
	
	//vlan接口配置
	public WebElement vlanConfig() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='menu_T_Vlan_INTER']/a/span"));
	}
	
	//获取vlan接口配置表格
	public WebElement tablVlanInt() throws Exception {
		return obj.getElement(By.id("VlanView_List"));
	}
	
	//获取复制(永远获取第一行中的复制)
	public WebElement copy() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='VlanView_List']/tbody/tr/td[9]/span"));
	}

   //获取第二行的“请配置”名称框
	public WebElement idConf() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='VlanView_List']/tbody/tr[2]/td[1]"));
	}
	
	//获取id输入框
	public WebElement textId() throws Exception {
		return obj.getElement(By.id("id"));
	}
	
	//获取空白出（做点击用）
	public WebElement blank() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='INNER']/div[3]/div[2]"));
	}
	
	//获取ip接口配置框
	public WebElement ipConf() throws Exception {
		return obj.getElement(By.id(".//*[@id='VlanView_List']/tbody/tr[2]/td[5]"));
	}
	
	//获取主地址ip文本输入框
	public WebElement  textIP() throws Exception {
		return obj.getElement(By.id("ip1_address"));
	}
	
	//获取子网掩码
	public WebElement sltmask() throws Exception {
		return obj.getElement(By.id("src_mask_id1"));
	}
	
	//获取第二行中的删除按钮
	public WebElement deletButton() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='VlanView_List']/tbody/tr[2]/td[9]/span[2]"));
	}
	
	
}
