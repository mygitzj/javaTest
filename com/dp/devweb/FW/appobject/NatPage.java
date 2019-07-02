package dp.devweb.FW.appobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dp.devweb.common.CommonObject;
import dp.devweb.common.CommonTable;

/**
 * @Title: SourceNatPage.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author w01866
 * @date 2015年1月16日 下午2:38:03
 * @version V4.4
 */

/**
 * 
* @Title: NatPage.java 
* @Description: TODO(增加源NAT源IP，目的IP，服务等方法等元素的获取) 
* @author z01674 
* @date 2015年5月12日 上午9:42:49 
* @version V4.4
 */
public class NatPage {
	public CommonObject obj = new CommonObject();

	/**
	 * 基本 → 防火墙 → 源NAT → 源NAT列表
	 * 
	 * @return table对象
	 */
	public WebElement tblSourceNat() throws Exception{
		return obj.getElement(By.id("snat_grid"));
	}

	/**
	 * 基本 → 防火墙 → 源NAT → 名称
	 * 
	 * @return text对象
	 */
	public WebElement txtName() throws Exception{
		return obj.getElement(By.id("name_input"));
	}

	/**
	 * 基本 → 防火墙 → 源NAT → 出接口
	 * 
	 * @return select对象
	 */
	public WebElement sltOutInterface() throws Exception{
		return obj.getElement(By.id("interface_select"));
	}
	
	//源Nat状态目标单元格
	public WebElement State() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='snat_grid']/tbody/tr/td[11]"));
	}
	
	//源Nat状态目标选择框
	public WebElement selState() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='state_select']"));
	}                  
	
	//源NAT发起方源IP操作对象
	
	/**
	 * any勾选框
	 */
	public WebElement checkAny() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='src_ip_popup']/table[1]/tbody/tr/td/input"));
	}
	                                    
	/**
	 * 选择地址对象
	 */
	public WebElement selObject() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='src_ip_popup']/table[2]/tbody/tr/td[1]/select"));
	}
	
	/**
	 * 备选框
	 */
	public WebElement selReserve() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='src_ip_popup']/table[3]/tbody/tr[2]/td[1]/select[1]"));
	}
	
	/**
	 * 向右添加按钮
	 */
	public WebElement moveRight() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='src_ip_popup']/table[3]/tbody/tr[2]/td[2]/button[1]"));
	}
	
	/**
	 * 已选项选择框
	 */
	public WebElement selExist() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='src_ip_popup']/table[3]/tbody/tr[2]/td[3]/select"));
	}
	
	/**
	 * 向左移除按钮
	 */
	public WebElement moveLeft() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='src_ip_popup']/table[3]/tbody/tr[2]/td[2]/button[2]"));
	}
	
	/**
	 * 确定按钮
	 */
	public WebElement buttonOK() throws Exception {
		return obj.getElement(By.xpath("html/body/div[4]/div[3]/div/button[1]"));
	}                                   
	
	//源NAT发起方目的Ip操作对象
	/**
	 * 目的Ip any勾选框
	 */
	public WebElement checkAnyDes() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='dst_ip_popup']/table[1]/tbody/tr/td/input"));
	}
	
	/**
	 * 目的IP地址对象选择框
	 */
	public WebElement selAddrObjectDes() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='dst_ip_popup']/table[2]/tbody/tr/td[1]/select"));
	}
	
	/**
	 * 目的Ip备选项选择框
	 */
	public WebElement selReserveDes() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='dst_ip_popup']/table[3]/tbody/tr[2]/td[1]/select[1]"));
	}
	
	/**
	 * 目的Ip已选项选择框
	 */
	public WebElement selExitDes() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='dst_ip_popup']/table[3]/tbody/tr[2]/td[3]/select"));
	}
	
	/**
	 * 目的IP向右增加按钮
	 */
	public WebElement moveRightDes() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='dst_ip_popup']/table[3]/tbody/tr[2]/td[2]/button[1]"));
	}                                   
	                                   
	/**
	 * 目的Ip向左移除按钮
	 */
	public WebElement moveLeftDes() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='dst_ip_popup']/table[3]/tbody/tr[2]/td[2]/button[2]"));
	}
	
	//源NAT服务对象操作
	/**
	 * any checkbox
	 */
	public WebElement checkAnyService() throws Exception {
		return obj.getElement(By.id("service_radio_all"));
	}
	
	/**
	 * 服务组 checkbox
	 */
	public WebElement checkServiceGroup() throws Exception {
		return obj.getElement(By.id("service_radio_group"));
	}
	
	/**
	 * 服务组文本选择框
	 */
	public WebElement selServiceGroup() throws Exception {
		return obj.getElement(By.id("service_select_group"));
	}
	
	/**
	 * 自定义服务对象 checkbox
	 */
	public WebElement checkUserServiceObj() throws Exception {
		return obj.getElement(By.id("service_radio_usrObj"));
	}
	
	/**
	 * 自定义服务对象文本选择框
	 */
	public WebElement selUserServiceObj() throws Exception {
		return obj.getElement(By.id("service_select_usrObj"));
	}
	
	/**
	 * 预定义服务对象checkbox
	 */
	public WebElement checkPreServiceObject() throws Exception {
		return obj.getElement(By.id("service_radio_preObj"));
	}
	
	/**
	 * 预定义服务对象文本选择框
	 */
	public WebElement selPreServiceObject() throws Exception {
		return obj.getElement(By.id("service_select_preObj"));
	}
	
	/**
	 * 服务中的确定
	 */
	public WebElement buttonOKService() throws Exception {
		return obj.getElement(By.xpath("html/body/div[4]/div[3]/div/button[1]"));
	}
	
/////////////////////////////////////////
	/**
	 * 基本 → 防火墙 → 源NAT → 复制
	 * 
	 * @return
	 */
	public WebElement spnCopy() throws Exception{
		WebElement cell = CommonTable.getCellObject(tblSourceNat(), 0, 9);
		return obj.getElement(cell, By.xpath("//span[contains(@class,'COPY')]"));
	}

	/**
	 * 动态端口NAT
	 * 
	 * @return
	 */
	public WebElement rdoDynamicPort() throws Exception{
		return obj.getElement(By.id("natType_dynamicPort"));
	}
	
	/**
	 * 序号
	 */
	public WebElement xuhao1() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='snat_grid']/tbody/tr/td[1]"));
	}
	
	/**
	 * 每条nat的删除按钮
	 * 
	 * @param row
	 *            指定nat所在行
	 * @return
	 */
	public WebElement spnDelete(int row) throws Exception{
		return obj.getElement(By.xpath("//*[@id='snat_grid']/tbody/tr["
				+ (row + 1) + "]/td[12]/span[4]"));
	}

	/**
	 * 目的NAT表格
	 * 
	 * @return 表格对象
	 */
	public WebElement tblDestNat() throws Exception{
		return obj.getElement(By.id("DNat_List"));
	}

	/**
	 * 目的NAT名称
	 * 
	 * @return 文本对象
	 */
	public WebElement txtDestName() throws Exception{
		return obj.getElement(By.id("name"));
	}

	/**
	 * 入接口
	 * 
	 * @return select对象
	 */
	public WebElement sltInInterface() throws Exception{
		return obj.getElement(By.id("interface"));
	}

	/**
	 * 公网IP
	 * 
	 * @return 文本对象
	 */
	public WebElement txtPublicIP() throws Exception{
		return obj.getElement(By.id("publicIp"));
	}
    /*
	//目的NAT服务的选择/////////////////////////////////////////////////////////////////////
	/**
	 * All checkbox
	 */
	public WebElement checkAllDestNat() throws Exception {
		return obj.getElement(By.id("service_any"));
	}
	
	/**
	 * 自定义 checkbox
	 */
	public WebElement checkSelectService() throws Exception {
		return obj.getElement(By.id("service_select"));
	}
	
	/**
	 * ftp勾选框
	 */
	public WebElement ftpServ() throws Exception {
		return obj.getElement(By.id("pre_service_check_1"));
	}
	
	/**
	 * telnet勾选框
	 */
	public WebElement telnetServ() throws Exception {
		return obj.getElement(By.id("pre_service_check_2"));
	}
	
	/**
	 * smtp勾选框
	 */
	public WebElement smtpServ() throws Exception {
		return obj.getElement(By.id("pre_service_check_3"));
	}
	
	/**
	 * http勾选框
	 */
	public WebElement httpServ() throws Exception {
		return obj.getElement(By.id("pre_service_check_4"));
	}
	
	/**
	 * https勾选框
	 */
	public WebElement httpsServ() throws Exception {
		return obj.getElement(By.id("pre_service_check_5"));
	}
	
	/**
	 * icmp勾选框
	 */
	public WebElement icmpServ() throws Exception {
		return obj.getElement(By.id("pre_service_check_6"));
	}
	
	/**
	 * tcp文本输入框
	 */
	public WebElement textTCP() throws Exception {
		return obj.getElement(By.id("tcp_port_id"));
	}
	
	/**
	 * udp文本输入框
	 */
	public WebElement textUDP() throws Exception {
		return obj.getElement(By.id("udp_port_id"));
	}
	
	/**
	 * 协议号文本输入框
	 */
	public WebElement textPro() throws Exception {
		return obj.getElement(By.id("proto_id"));
	}
	
	/**
	 * 目的NAT服务确定
	 */
	public WebElement OKDestNatServ() throws Exception {
		return obj.getElement(By.xpath("html/body/div[4]/div[3]/div/button[1]"));
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////
	/**
	 * 内网IP范围，最小IP
	 * @return 文本对象
	 */
	public WebElement txtMinIP() throws Exception{
		return obj.getElement(By.id("inaddressip_minip_id"));
	}

	/**
	 * 内网IP范围，最大IP
	 * 
	 * @return 文本对象
	 */
	public WebElement txtMaxIP() throws Exception{
		return obj.getElement(By.id("inaddressip_maxip_id"));
	}
	
	/**
	 * 目的NAT高级配置——内网端口勾选框
	 */
    public WebElement checkInnerPort() throws Exception {
    	return obj.getElement(By.id("innet_port_checkbox_id"));
    }
    
    /**
     * 目的NAT高级配置——内网端口文本输入框
     */
    public WebElement textInnerPort() throws Exception {
    	return obj.getElement(By.id("innet_port_id"));
    }
	
    /**
     * 目的NAT高级配置——状态选择框
     */
    public WebElement selectDestNATStates() throws Exception {
    	return obj.getElement(By.xpath(".//*[@id='select_state']"));
    }
    
	/**
	 * 目的NAT页面顶端标签
	 * 
	 * @return td对象
	 */
	public WebElement topDestNat() throws Exception{
		return obj.getElement(By.id("T_Security_DNAT_02"));
	}
	
	/**
	 * 基本 → 防火墙 → 目的NAT → 复制
	 * 
	 * @return
	 */
	public WebElement spnDestCopy() throws Exception{
		WebElement cell = CommonTable.getCellObject(tblDestNat(), 0, 9);
		return obj.getElement(cell, By.xpath("//span[contains(@class,'COPY')]"));
	}
	
	public WebElement spnDestDelete(int row) throws Exception{
		return obj.getElement(By.xpath("//*[@id='DNat_List']/tbody/tr["
				+ (row + 1) + "]/td[10]/span[3]"));		
	}
	

	/**
	 * @return 空白处
	 */
	public WebElement black() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='INNER']/div[1]"));
	}


	
}
