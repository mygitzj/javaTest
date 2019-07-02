package dp.devweb.FW.appobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dp.devweb.common.CommonObject;
import dp.devweb.common.CommonObjectScript;

/**
 * 
* @Title: Nat64Page.java 
* @Description: TODO(用一句话描述该文件做什么) 
* @author z01674 
* @date 2015年4月27日 下午4:53:57 
* @version V4.4
 */

public class Nat64Page extends CommonObjectScript {
	
	//公共对象类
	public CommonObject obj = new CommonObject();
	
	//前缀配置界面元素
	
	/**
	 * @return topPrefix
	 */
	public WebElement topPrefix() throws Exception {
		return obj.getElement(By.id(".//*[@id='T_NAT64_PREFIX_02']"));
	}
	
	/**
	 * @return nat64开启
	 */
	public WebElement checkNat64enable() throws Exception {
		return obj.getElement(By.id("nat64_enable"));
	}
	
	/**
	 * @return tablePrefix
	 */
	public WebElement tablePrefixConf() throws Exception {
		return obj.getElement(By.id("table_nat64_prefix"));
	}
	
	/**
	 * @return ipv6Prefix文本框
	 */
	public WebElement textIpv6Prefix() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='input_prefix']"));
	}
	
	/**
	 * @return lengthIpv6Prefix 选择框
	 */
	public WebElement selectLenIp6Prefix() throws Exception {
		return obj.getElement(By.xpath("//*[@id='select_prefix_len']"));
	}
	
	/**
	 * @return ipv6PrefixCopy
	 */
	public WebElement butonCopyIp6Prefix() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='table_nat64_prefix']/tbody/tr/td[4]/span[1]"));
	}
	
	//NAT64转换配置
	
	/**
	 * @return topNAT64Address
	 */
	public WebElement topNAT64Adress () throws Exception {
		return obj.getElement(By.id("T_NAT64_ADDRESS_02"));
	}
	
	/**
	 * @return  tableNAT64Addr
	 */
	public WebElement tableNAT64Addr() throws Exception {
		return obj.getElement(By.id("nat_list"));
	}
	
	/**
	 * @return textNameNAT64
	 */
	public WebElement textNameNAT64() throws Exception {
		return obj.getElement(By.id("input_nat_name"));
	}
	
	/**
	 * @return selecInter
	 */
	public WebElement selecInterf() throws Exception {
		return obj.getElement(By.id("sel_ouif_name"));
	}
	
	/////////////////发起方源ipv6地址弹出框///////////////////////////
	/**
	 * @return 发起源IP地址———all选择按钮    
	 */
	public WebElement checkAllSourceIp() throws Exception {
		return obj.getElement(By.id("ip6_all_chk"));
	}
    
	/**
	 * @return 发起源IP地址——checkIPv6
	 */
	public WebElement checkIpv6() throws Exception {
		return obj.getElement(By.id("ip6_opt_chk"));
	}
	
	/**
	 * @return IPv6地址对象选择框
	 */
	public WebElement selIpv6Obj() throws Exception {
		return obj.getElement(By.id("ip6_type_sel"));
	}
	
	/**
	 * @return 左侧备选项选择框
	 */
	public WebElement selLeft() throws Exception {
		return obj.getElement(By.id("ip6Obj_item_sel"));
	}
	
	/**
	 * @return 向右增加按钮
	 */
	public WebElement movLeft() throws Exception {
		return obj.getElement(By.id("ip6_add_btn"));
	}
	
	/**
	 * @return 右侧已选项选择框
	 */
	public WebElement selRight() throws Exception {
		return obj.getElement(By.id("ip6_result_sel"));
	}
	
	/**
	 * @return 向左移除按钮
	 */
	public WebElement movRight() throws Exception {
		return obj.getElement(By.id("ip6_del_btn"));
	}
	
	/**
	 * @return 确定按钮
	 */
	public WebElement buttonConfim() throws Exception {
		return obj.getElement(By.xpath("html/body/div[4]/div[3]/div/button[1]"));
	}
	
	///////////////////////////服务弹出框/////////////////////////
	/**
	 * @return 服务选项中的all check按钮
	 */
	public WebElement checkAllService() throws Exception {
		return obj.getElement(By.id("service_all_chk"));
	}
	
	/**
	 * @return  服务组check按钮
	 */
	public WebElement checkServiceGroup() throws Exception {
		return obj.getElement(By.id("service_group_chk"));
	}
	
	/**
	 * @return 服务组文本选择框
	 */
	public WebElement selServiceGroup() throws Exception {
		return obj.getElement(By.id("service_group_sel"));
	}
	
	/**
	 * @return 自定义服务对象check按钮
	 */
	public WebElement userObj() throws Exception {
		return obj.getElement(By.id("service_usrObj_chk"));
	}
	
	/**
	 * @return 自定义服务对象文本选择框
	 */
	public WebElement sleUserObj() throws Exception {
		return obj.getElement(By.id("service_usrObj_sel"));
	}
	
	/**
	 * @return 预定义服务对象check按钮
	 */
	public WebElement checkPriService() throws Exception {
		return obj.getElement(By.id("service_preObj_chk"));
	}
	
	/**
	 * @return 预定义服务对象文本选择框
	 */
	public WebElement selPriServ() throws Exception {
		return obj.getElement(By.id("service_preObj_chk"));
	}
	
	/**
	 * @return 服务确定按钮
	 */
	public WebElement servButtonConfim() throws Exception {
		return obj.getElement(By.xpath("html/body/div[4]/div[3]/div/button[1]"));
	}
	
	/////////////公网IP地址池弹出窗口//////////////////////////////////////
	/**
	 * @return 公网Ip地址池————借用出接口check按钮
	 */
	public WebElement checkUseOutboundInterface() throws Exception {
		return obj.getElement(By.id("use_outIf_addr_radio_id"));
	}
	
	/**
	 * @return 选择已存在的地址check按钮
	 */
	public WebElement checkExistAddr() throws Exception {
		return obj.getElement(By.id("select_old_addrpool_radio_id"));
	}
	
	/**
	 * @return 左侧备选项地址池 old_addrpool_id
	 */
	public WebElement leftAddrPool() throws Exception {
		return obj.getElement(By.id("old_addrpool_id"));
	}
	
	/**
	 * @return 向右增加按钮
	 */
	public WebElement addButton() throws Exception {
		return obj.getElement(By.id("net_ip_add_btn"));
	}
	
	/**
	 * @return 右侧已选框地址池
	 */
	public WebElement RightAddrPool() throws Exception {
		return obj.getElement(By.id("net_ip_result_sel"));
	}
	
	/**
	 * @return 公网地址池确认按钮
	 */
	public WebElement pubIpButtonconfim() throws Exception {
		return obj.getElement(By.id("html/body/div[4]/div[3]/div/button[1]"));
	}
	
	//地址池表格对象
	/**
	 * @return 页面上部地址池
	 */
	public WebElement topAddrPool() throws Exception {
		return obj.getElement(By.id("T_NAT64_ADDRPOOL_02"));
	}
	
	/**
	 * @return 地址池表格
	 */
	public WebElement tablAddrPool() throws Exception {
		return obj.getElement(By.id("AddrpoolList"));
	}
	
	/**
	 * @return 地址池名称文本输入框
	 */
	public WebElement textNameAddrPool() throws Exception {
		return obj.getElement(By.id("name"));
	}
	
	/**
	 * @return 起始IP文本输入框
	 */
	public WebElement textBeginIp() throws Exception {
		return obj.getElement(By.id("min_ip"));
	}
	
	/**
	 * @return 结束Ip文本输入框
	 */
	public WebElement textEndIp() throws Exception {
		return obj.getElement(By.id("max_ip"));
	}
	
	
}
