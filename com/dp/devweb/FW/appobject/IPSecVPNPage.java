package dp.devweb.FW.appobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dp.devweb.common.CommonObject;
import dp.devweb.common.CommonObjectScript;

/**
* @Title: IPSecVPNPage.java 
* @Description: TODO(IPsecVPN配置界面操作) 
* @author z01674 
* @date 2015年7月4日 下午2:24:43 
* @version V4.4
 */

public class IPSecVPNPage extends CommonObjectScript{
	public CommonObject obj = new CommonObject();
	
	/**
	 * top 系统配置
	 */
	public WebElement topSystemConf() throws Exception {
		return obj.getElement(By.id("T_Security_IPSec_Sysconfig2"));
	}
	
	/**
	 * top 系统配置——check是否启用IPSec
	 */
	public WebElement checkIPSec() throws Exception {
		return obj.getElement(By.id("ipsec_status"));
	}
	
	/**
	 * top 策略方式
	 */
	public WebElement topPolicyMode() throws Exception {
		return obj.getElement(By.id("T_Security_IPSec_PolicyMode2"));
	}
	
	/**
	 * top 策略方式 网关-网关模式表格
	 */
	public WebElement tableGateway() throws Exception {
		return obj.getElement(By.id("IPsecVPNPolicyConn"));
	}
	
	/**
	 * top 策略方式 网关—网关模式  连接名称文本输入框
	 */
	public WebElement textNameGateway() throws Exception {
		return obj.getElement(By.xpath("connname"));
	}
	
	/**
	 * top 策略方式 网关—网关模式  本端设备ＩＰ
	 */
	public WebElement textLocalIP() throws Exception {
		return obj.getElement(By.id("net_local_ip"));
	}
	
	/**
	 * top 策略方式  网关-网关模式  对端IP
	 */
	public WebElement textRemoteIP() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='net_remoteip_ip']"));
	}
	
	/**
	 * top策略方式 确定按钮
	 */
	public WebElement buttonOKRemoteIP() throws Exception {
		return obj.getElement(By.xpath("html/body/div[4]/div[3]/div/button[1]"));
	}
	
	/**
	 * top策略方式  网关 网关模式  高级配置  协商模式选择框
	 */
	public WebElement selXieShangMode() throws Exception {
		return obj.getElement(By.id("net_negotiate_mode_select"));
	}
	
	/**
	 * top策略方式  网关-网关模式  高级配置  安全提议选择框
	 */
	public WebElement selSecProAdvancConf() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='net_advanced_sa_proposal_select']"));
	}
	
	/**
	 * top策略方式  网关-网关模式  高级配置  加密失败动作选择框
	 */
	public WebElement selAction() throws Exception {
		return obj.getElement(By.id("net_advanced_encrypt_fail_action_select"));
	}	

	/**
	 * top保护网段
	 */
	public WebElement topProtectSubnet() throws Exception {
		return obj.getElement(By.id("T_Security_IPSec_IPsecNetprotect2"));
	}
	
	/**
	 * top保护网段 ——添加按钮
	 */
	public WebElement buttonAddProtectSubent() throws Exception {
		return obj.getElement(By.id("add_btn"));
	}
	
	/**
	 * top保护网段——删除按钮
	 */
	public WebElement buttonDelProtectSubent() throws Exception {
		return obj.getElement(By.id("del_btn"));
	}
	
	/**
	 * top保护网段——li网关-网关IPV4网段组
	 */
	public WebElement liGatway4Subnet() throws Exception {
		return obj.getElement(By.id("2147483643"));
	}
	
	/**
	 * top保护网段——lnk网关-网关IPv4网段组
	 */
	public WebElement lnkGatway4Subnet() throws Exception {
		return obj.getElement(By.linkText("网关-网关IPv4网段组"));
	}
	
	/**
	 * top保护网段——网关—网关IPv4网段组——li1
	 */
	public WebElement liNameProtectSubnet(int count) throws Exception {
		return obj.getElement(By.id("'"+ count +"'"));
	}


	/**
	 * top保护网段——lnklnk网关-网关IPv4网段组——lnk新建name
	 */
	public WebElement lnkNameProtectSubnet(String name ) throws Exception {
		return obj.getElement(By.linkText("'" +name + "'"));
	}
	
	
	/**
	 * top保护网段——名称文本输入框
	 */
	public WebElement textNameProtectSubnet(int count) throws Exception {
//		return obj.getElement(By.xpath(".//*[@value='新建保护网段组结点']/input"));
		return obj.getElement(By.xpath(".//*[@id='" + count+"']/input"));
	}
	
	/**
	 * top保护网段——table保护网段信息列表
	 */
	public WebElement tableProtectSubnet() throws Exception {
		return obj.getElement(By.id("IPsecNetProtect_Gw"));
	}        
	
	/**
	 * top保护网段——table保护网段信息列表——复制按钮
	 */
	public WebElement buttonCopyProtectSubnet() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='IPsecNetProtect_Gw']/tbody/tr/td[8]/span[1]"));
	}
                                   	
	/**
	 * top保护网段——保护网段信息列表——本端保护网段文本输入框
	 */
	public WebElement textLocalProtectSubnet() throws Exception {
		return obj.getElement(By.id("ipsec_gw_src_ip"));
	}
	
	/**
	 * top保护网段——保护信息列表——本端保护网段子网掩码文本输入框
	 */
	public WebElement textMaskLocal() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='ipsec_gw_src_mask']"));
	}                                      
	
	/**
	 * top保护网段——保护信息列表——对端保护网段文本输入框
	 */
	public WebElement textRemoteProtectSubnet() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='ipsec_gw_net_des']"));
	}
	
	/**
	 * top保护网段——保护信息列表——对端保护网段子网掩码文本输入框
	 */
	public WebElement textMaskRemeote() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='ipsec_gw_des_mask']"));
	}
	
	
	
	
	
	
	
		
	/**
	 * top 安全提议
	 */
	public WebElement topSecurityProposal() throws Exception {
		return obj.getElement(By.id("T_Security_IPSec_SaConfig2"));
	}
	
	/**
	 * top安全提议——table
	 */    
	public WebElement tableSecProposal() throws Exception {
		return obj.getElement(By.id("ipsec_sa_grid"));
	}
	
	/**
	 * top安全提议——复制按钮
	 */
	public WebElement copSecProposal() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='ipsec_sa_grid']/tbody/tr/td[7]/span[1]"));
	}
	
	/**
	 * top安全提议——安全提议标题栏
	 */
	public WebElement blackSecPro() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='INNER']/div[4]/div[2]/div/table/thead/tr/th[1]/div"));
	}
	
	/**
	 * top安全提议——ID文本输入框
	 */
	public WebElement textIDSecProposal() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='said_input']"));
	}
	
	/**
	 * top安全提议——协议类型选择框
	 */
	public WebElement selSecProType() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='protocal_type_input']"));
	}
	
	/**
	 * top安全协议——IKE SA重协商
	 */
	public WebElement textIKEReInter()throws Exception {
		return obj.getElement(By.id("ike_lifetime_input                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            nnnnnnnnnnnnnn                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "));
	}
	
	/**
	 * top安全协议——IPSec SA重协商
	 */
	public WebElement textIPSecReInter() throws Exception {
		return obj.getElement(By.id("ipsec_lifetime_input"));
	}
	
	/**
	 * top安全协议——PFDHgroup 选择框
	 */
	public WebElement selPFGroup() throws Exception {
		return obj.getElement(By.id("pfs_dhgroup_input"));
	}
	
	/**
	 * top安全协议——IKE安全提议——加密算法文本选择框
	 */
	public WebElement selEncryptionAlgIKE() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='ike_left_list']/select[1]"));
	}
	
	/**
	 * top安全协议——IKE安全提议——认证算法文本选择框
	 */
	public WebElement selAuthAlgIKE() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='ike_left_list']/select[2]"));
	}
	
	/**
	 * top安全协议——IKE安全提议——DH组文本选择框
	 */
	public WebElement selDHGroupIKE() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='ike_left_list']/select[3]"));
	}
	
	/**
	 * top安全协议——IKE安全提议——向右增加按钮
	 */
	public WebElement buttonAddIKE() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='ike_add_button']"));
	}
	
	/**
	 * top安全协议——IKE安全提议——向左移除按钮
	 */
	public WebElement buttonDelIKE() throws Exception {
		return obj.getElement(By.id("ike_remove_button"));
	}
	
	/**
	 * top安全协议——IKE安全协议——已选项
	 */
	public WebElement selSeltedIKEPro() throws Exception {
		return obj.getElement(By.id("ike_right_list"));
	}
	
	/**
	 * top安全协议——IKE安全协议——确定按钮
	 */
	public WebElement buttonOKSec() throws Exception {
		return obj.getElement(By.xpath("html/body/div[4]/div[3]/div/button[1]"));
	}
	
	/**
	 * top安全协议——IPSec安全协议——加密算法
	 */
	public WebElement selEncryptionAlgIPSec() throws Exception {
		return obj.getElement(By.id("ipsec_enc_alg"));
	}
	
	/**
	 * top安全协议——IPSec安全协议——认证算法
	 */
	public WebElement selAuthAlgIPS() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='ipsec_left_list']/select[2]"));
	}
	
	/**
	 * top安全协议——IPSec安全协议——向右增加按钮
	 */
	public WebElement buttonAddIPS() throws Exception {
		return obj.getElement(By.id("ipsec_add_button"));
	}
	
	/**
	 * top安全协议——IPSec安全协议——向左移除
	 */
	public WebElement buttonDelIPS() throws Exception {
		return obj.getElement(By.id("ipsec_remove_button"));
	}
	
	/**
	 * top安全协议——IPSec安全协议——已选安全协议
	 */
	public WebElement selSeltedIPSecPro() throws Exception {
		return obj.getElement(By.id("ipsec_right_list"));
	}
	
	
	/**
	 * top Tunnel接口
	 */
	public WebElement topTunnelInterface() throws Exception {
		return obj.getElement(By.id("T_Security_IPSec_iface2"));
	}
	
	/**
	 * tunnel接口配置表格
	 */
	public WebElement tableTunnelInterface() throws Exception {
		return obj.getElement(By.id("IPsecInterface"));
	
	}
	
	/**
	 * top Tunnel接口——接口编号文本输入框
	 */
	public WebElement textInterID() throws Exception {
//		return obj.getElement(By.xpath("//input[@id='ipsec_tunnel_id']"));
//		return obj.getElement(By.id("ipsec_tunnel_id"));
		return obj.getElement(By.xpath("//html/body/div[2]/div/div[2]/input"));
	}                                
	
	/**
	 * top Tunnel接口——tunnel接口IP地址——radioIPv4
	 */
	public WebElement radioIpv4() throws Exception {
		return obj.getElement(By.id("tunnel_ipv4_radio"));
	}
	
	/**
	 * top Tunnel接口——tunnel接口IP地址——radioIPv6
	 */
	public WebElement radioIpv6() throws Exception {
		return obj.getElement(By.id("tunnel_ipv6_radio"));
	}
	
	/**
	 * top Tunnel接口——tunnel接口IP地址文本输入框
	 */
	public WebElement textInterIP() throws Exception {
		return obj.getElement(By.xpath("//*[@id='unicast_addr']"));
	}
	
	/**
	 * top Tunnel接口——tunnel接口IP地址——子网掩码
	 */
	public WebElement textMask() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='subnet_mask']"));
	}
	
	/**
	 * top Tunnel接口——tunnel接口IP地址——确定按钮
	 */
	public WebElement buttonOK() throws Exception {
		return obj.getElement(By.xpath("html/body/div[3]/div[1]/div/button[1]"));
	}                                   
	                                   
	/**
	 * top Tunnel接口——隧道应用模式选择框
	 */
	public WebElement selTunnelMode() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='ipsec_mode']"));
	}                         
	
	/**
	 * top Tunnel接口——描述文本输入框
	 */
	public WebElement textDescription() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='ipsec_descrip']"));
	}
	
	/**
	 * top Tunnel接口——复制按钮
	 */
	public WebElement butCoppyTunnelInter() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='IPsecInterface']/tbody/tr/td[5]/span[1]"));
	}

}
