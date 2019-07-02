package dp.devweb.FW.appobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dp.devweb.common.CommonObject;
import dp.devweb.common.CommonObjectScript;

/**
 * @Title: TreeMenuPage.java
 * @Description: 左树链接页面元素
 * @author w01866
 * @date 2014年12月2日 上午11:55:27
 * @version V4.4
 */

/**
 * 
* @Title: TreeMenuPage.java 
* @Description: TODO(补充目的NAT之后的防火墙配置界面) 
* @author z01674 
* @date 2015年4月25日 上午10:15:01 
* @version V4.4
 */
public class TreeMenuPage extends CommonObjectScript {

	// 公共对象类
	public CommonObject obj = new CommonObject();
	
	/**
	 * top防火墙按钮(适用于DPX设备)
	 */
	public WebElement topFirWall() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='test-top-tab']/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr/td[2]"));
	}

	/**
	 * “确认”按键
	 * 
	 * @return 按键对象
	 * @throws Exception
	 */
	public WebElement btnConfirm() throws Exception {
		return obj.getElement(By.id("SUBMIT_BTN"));
	}                          

	/**
	 * “取消”按键
	 * @return 按键对象
	 * @throws Exception
	 */
	public WebElement btnCancel() throws Exception {
		return obj.getElement(By.id("CANCEL_BTN"));
	}

	/**
	 * 根据“确定”文本获取按钮，会获得两个元素，取其中text值等于“确定”的元素
	 * 
	 * @return 确定按钮
	 * @throws Exception
	 */
	public WebElement btnOK() throws Exception {
		List<WebElement> objs = obj
				.getElements(By.xpath("//span[text()='确定']"));
		WebElement obj = null;
		for (int i = 0; i < objs.size(); i++) {
			if (objs.get(i).getText().equals("确定")) {
				obj = objs.get(i);
				break;
			}
		}
		return obj;
	}

	/**
	 * 
	 * @return 查询
	 * @throws Exception
	 */
	public WebElement btnQuery() throws Exception {
		return obj.getElement(By.id("sub_btn"));
	}

	/**
	 * 接口状态选择：启用、禁用
	 * 
	 * @return select对象
	 * @throws Exception
	 */
	public WebElement sltState() throws Exception {
		return obj.getElement(By.id("state_select"));
	}
	
	/**
	 * 配置文件
	 */
	public WebElement linConfigFile() throws Exception {
		return obj.getElement(By.linkText("配置文件"));
	}

	/**
	 * 用于判断网络管理链接是否打开
	 * 
	 * @return 网络管理的上级对象
	 */
	public WebElement liNetManagement() {
		return obj.getElement(By.id("menu_M_Net_Management"));
	}
	                                
	/**
	 * 用于判断接口管理是否打开
	 * 
	 * @return 接口管理的上级对象
	 */
	public WebElement liIntfManagement() {
		return obj.getElement(By.id("menu_T_Ifmode_Config"));
	}

	/**
	 * 用于判断组播IPv4路由是否打开
	 * 
	 * @return 组播IPv4路由的上级对象
	 */
	public WebElement liGrpIPv4Route() {
		return obj.getElement(By.id("menu_T_Net_MV4Route"));
	}

	/**
	 * 用于判断网络对象是否打开
	 * 
	 * @return 网络对象的上级对象
	 */
	public WebElement liNetObject() {
		return obj.getElement(By.id("menu_T_Network_Object"));
	}

	/**
	 * 
	 * @return 网络管理
	 */
	public WebElement lnkNetManagement() {
		return obj.getElement(By.linkText("网络管理"));
	}

	/**
	 * 
	 * @return 接口管理
	 */
	public WebElement lnkIntfManagement() {
		return obj.getElement(By.linkText("接口管理"));
	}

	/**
	 * 
	 * @return 网络对象
	 */
	public WebElement lnkNetObject() {
		return obj.getElement(By.linkText("网络对象"));
	}

	/**
	 * 
	 * @return 逻辑接口配置
	 */
	public WebElement lnkLogicIntfConf() {
		return obj.getElement(By.linkText("逻辑接口配置"));
	}
	
	/**
	 * 网络管理——接口管理——GRE隧道
	 */
	public WebElement lnkGRE() throws Exception {
		return obj.getElement(By.linkText("GRE"));
	}
	

	/**
	 * i
	 * @return 组网配置
	 */
	public WebElement lnkNetConf() {
		return obj.getElement(By.xpath(".//*[@id='menu_T_Config_Ifmode']/a"));
	}

	/**
	 * 
	 * @return 组播IPv4路由
	 */
	public WebElement lnkGrpIpv4Route() {
		return obj.getElement(By.linkText("组播IPv4路由"));
	}

	/**
	 * 
	 * @return 公共配置
	 */
	public WebElement lnkCommonConf() {
		return obj.getElement(By.linkText("公共配置"));
	}

	/**
	 * 
	 * @return PIM
	 */
	public WebElement lnkPim() {
		return obj.getElement(By.linkText("PIM"));
	}

	/**
	 * 
	 * @return IP地址
	 */
	public WebElement lnkIpAddr() {
		return obj.getElement(By.linkText("IP地址"));
	}

	/**
	 * ipv6地址
	 */
	public WebElement lnkIpv6Addr() throws Exception{
		return obj.getElement(By.linkText("IPV6地址"));
	}
	
	/**
	 * mac地址
	 */
	public WebElement lnkMacAddr() throws Exception {
		return obj.getElement(By.linkText("mac地址"));
	}
	
	/**
	 * 账号对象
	 */
	public WebElement lnkUserAccount() throws Exception {
		return obj.getElement(By.linkText("账号对象"));
	}
	
	/**
	 * 域名
	 */
	public WebElement lnkDomainName() throws Exception {
		return obj.getElement(By.linkText("域名"));
	}
		
	
	/**
	 * 基本 → 网络管理 → 网络对象
	 * 
	 * @return 服务
	 */
	public WebElement lnkService() throws Exception {
		return obj.getElement(By.linkText("服务"));
	}

	
	/**
	 * 基本 → 防火墙
	 * 
	 * @return 防火墙
	 */
	public WebElement lnkFireWall() {
		return obj.getElement(By.linkText("防火墙"));
	}

	
	/**
	 * 用于判断防火墙是否打开
	 * 
	 * @return 防火墙
	 */
	public WebElement liFireWall() {
		return obj.getElement(By.id("menu_M_Basic_FW"));
	}
	
	/**
	 * 用于判断防火墙是否打开(适用于DPX设备)
	 */
	public WebElement liFireWallDPX() {
		return obj.getElement(By.id("menu_M_Basic_FW_5"));
	}
	                            
	
	
	/**
	 * 基本 → 防火墙 → 包过滤策略
	 * 
	 * @return 包过滤策略
	 */
	public WebElement lnkPacketFilter() {
		return obj.getElement(By.linkText("包过滤策略"));
	}

	/**
	 * 基本 → 网络管理 → 网络对象 → 安全域
	 * 
	 * @return 安全域
	 */
	public WebElement lnkSecurityZone() {
		return obj.getElement(By.id("menu_T_Network_Security_Zone"));
	}

	/**
	 * 用于判断单播IPv4路由是否打开
	 * 
	 * @return
	 */
	public WebElement liUniIpv4Route() {
		return obj.getElement(By.id("menu_T_Net_Route_IPv4"));
	}

	/**
	 * 基本 → 网络管理 → 单播IPv4路由
	 * 
	 * @return 单播IPv4路由
	 */
	public WebElement lnkUniIpv4Route() {
		return obj.getElement(By.linkText("单播IPv4路由"));
	}

	/**
	 * 基本 → 网络管理 → 单播IPv4路由 → 静态路由
	 * 
	 * @return 静态路由
	 */
	public WebElement lnkStaticRoute() {
		return obj.getElement(liUniIpv4Route(), By.linkText("静态路由"));
	}

	/**
	 * 基本 → 防火墙 → 源NAT
	 * 
	 * @return 源NAT
	 */
	public WebElement lnkSourceNat() {
		return obj.getElement(By.linkText("源NAT"));
	}

	public List<WebElement> lnkSourceNats() {
		return obj.getElements(By.linkText("源NAT"));
	}

	/**
	 * 基本 → 防火墙 → 目的NAT
	 * 
	 * @return 目的NAT
	 */
	public WebElement lnkDestNat() {
		return obj.getElement(By.linkText("目的NAT"));
	}

	public List<WebElement> lnkDestNats() {
		return obj.getElements(By.linkText("目的NAT"));
	}
	
	/**
	 * 基本 → 防火墙 → 一对一NAT
	 * @return 一对一目的NAT
	 */
	public WebElement lnk1to1Nat() {
		return obj.getElement(By.linkText("一对一NAT"));
	}
	
	/**
	 * 基本 → 防火墙  → 多对多NAT
	 * @return 多对多NAt
	 */
	public WebElement lnkNtoNNat() {
		return obj.getElement(By.linkText("多对多NAT"));
	}
	
	/**
	 * 基本 → 防火墙  → NAT64
	 */
	public WebElement lnkNAT64() {
		return obj.getElement(By.linkText("NAT64"));
	}
	
}
