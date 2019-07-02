package dp.devweb.FW.tasks;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import dp.devweb.FW.appobject.IPSecVPNPage;
import dp.devweb.FW.appobject.TreeMenuServicPage;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;
import dp.devweb.common.CommonTable;

/**
* @Title: IPSecVPN.java 
* @Description: TODO(对IPsecVPN配置界面的操作) 
* @author z01674 
* @date 2015年7月4日 下午3:23:11 
* @version V4.4
 */

public class IPSecVPN extends CommonObjectScript{
	public CommonOperator opr = new CommonOperator();
	public IPSecVPNPage pIPSecVPN  = new IPSecVPNPage();
	public TreeMenuServicPage pTree = new TreeMenuServicPage();
	
	/**
	 * @return 进入IPSecVPN配置界面
	 * @throws Exception
	 */
	public boolean goIPSecVPNPage() throws Exception {
		try {
			opr.SwitchToDefault();
			Debug("点击业务");
			opr.Click(pTree.topService());
			sleep(1);
			Debug("点击VPN");
			opr.ClickToOpen(pTree.liVPN(), pTree.lnkVPN());
			sleep(1);
			Debug("点击IPSec");
			opr.ClickToOpen(pTree.liIPSec(), pTree.lnkIPSec());
			sleep(2);
			Debug("点击IPSecVPN");
			opr.Click(pTree.lnkIPSecVPN());	
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			Error("进入IPSecVPN配置界面异常");
			return false;
		}
	}
	
	/**
	 * @param str (str只能取值为“启用”或者为“不启用”)
	 * @return 根据str决定是否开启
	 * @throws Exception
	 */
	public boolean enableIPSecOrNO(String str) throws Exception {
		try {
			goIPSecVPNPage();
			opr.SwitchToFrame();
			sleep(1);
			if(str.equals("启用")) {
				Debug("勾选启用IPSec");
				opr.ClickToState(pIPSecVPN.checkIPSec(), true);
				Debug("点击确认");
				opr.clickConfirm();	
			}else if(str.equals("不启用")) {
				Debug("去勾选启用IPSec");
				opr.ClickToState(pIPSecVPN.checkIPSec(), false);
				Debug("点击确认");
				opr.clickConfirm();
			}	
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			Error("是否启用IPSecVPN错误");
			return false;
		}
	}
	
	/**
	 * @param ID
	 * @param type
	 * @param timeIKE
	 * @param timeIPS
	 * @param IKESA
	 * @param IPSecSA
	 * @return  addSecPro
	 * @throws Exception
	 */	
	public boolean addSecPro(String ID,String type,String timeIKE, String timeIPS,String DHGroup,String IKEAlg,
			String IKEAuthAlg, String IKEDHgroup,String IPSAlg, String IPSAuthAlg)throws Exception {
		try {
			goIPSecVPNPage();
			opr.SwitchToFrame();
			sleep(1);
			Debug("点击顶端安全提议按钮");
			pIPSecVPN.topSecurityProposal();
			sleep(1);
			String str = CommonTable.getCellString(pIPSecVPN.tableSecProposal(), 0, 0);
			if (str.equals("请配置")) {
				CommonTable.getCellObject(pIPSecVPN.tableSecProposal(), 0, 0).click();
				opr.SendKeysNoClear(pIPSecVPN.textIDSecProposal(), ID);
				if(type !=null) {
					CommonTable.getCellObject(pIPSecVPN.tableSecProposal(), 0, 1).click();	
					opr.Select(pIPSecVPN.selSecProType(), type);
				}
				if(timeIKE != null || timeIPS !=null) {
					CommonTable.getCellObject(pIPSecVPN.tableSecProposal(), 0, 2).click();
					opr.SendKeysNoClear(pIPSecVPN.textIKEReInter(), timeIKE);
					opr.SendKeysNoClear(pIPSecVPN.textIPSecReInter(), timeIPS);
				}
				if(DHGroup != null) {
					CommonTable.getCellObject(pIPSecVPN.tableSecProposal(), 0, 3).click();
					opr.Select(pIPSecVPN.selEncryptionAlgIKE(), DHGroup);
				}
				if(IKEAlg != null) {
					CommonTable.getCellObject(pIPSecVPN.tableSecProposal(), 0, 4).click();
					Debug("清除已经选择的安全提议");			
					Select slt = new Select(pIPSecVPN.selSeltedIKEPro());
					List<WebElement> slts = slt.getOptions();
					for (int i = 0; i < slts.size(); i++) {
						slt.getOptions().get(0).click();
						sleep(1);
						opr.JsClick(pIPSecVPN.buttonDelIKE());
					}					
					opr.Select(pIPSecVPN.selEncryptionAlgIKE(), IKEAlg);
					opr.Select(pIPSecVPN.selAuthAlgIKE(), IKEAuthAlg);
					opr.Select(pIPSecVPN.selDHGroupIKE(), IKEDHgroup);
					Debug("点击增加");
					opr.JsClick(pIPSecVPN.buttonAddIKE());
					opr.JsClick(pIPSecVPN.buttonOK());
				}
				if(IPSAlg != null) {
					CommonTable.getCellObject(pIPSecVPN.tableSecProposal(), 0, 5).click();
					Debug("清除已选安全提议");
					Select slt = new Select(pIPSecVPN.selSeltedIPSecPro());
					List<WebElement> slts = slt.getOptions();
					for (int i = 0; i < slts.size(); i++) {
						slt.getOptions().get(0).click();
						sleep(1);
						opr.JsClick(pIPSecVPN.buttonDelIPS());
					}
					opr.Select(pIPSecVPN.selEncryptionAlgIPSec(), IPSAlg);
					opr.Select(pIPSecVPN.selDHGroupIKE(), IPSAuthAlg);
					Debug("点击增加按钮");
					opr.JsClick(pIPSecVPN.buttonAddIPS());
					opr.JsClick(pIPSecVPN.buttonOK());
				}
				pIPSecVPN.blackSecPro();
				Debug("点击确认");
				opr.clickConfirm();		
			}else {
				int count = CommonTable.getRowByColString(pIPSecVPN.tableSecProposal(), "请配置", 0);
				opr.JsClick(CommonTable.getCellObject(pIPSecVPN.tableSecProposal(), count -1, 0));
				opr.SendKeysNoClear(pIPSecVPN.textIDSecProposal(), ID);
				if(type !=null) {
					opr.JsClick(CommonTable.getCellObject(pIPSecVPN.tableSecProposal(), count -1, 1));	
					opr.Select(pIPSecVPN.selSecProType(), type);
				}
				if(timeIKE != null || timeIPS !=null) {
					opr.JsClick(CommonTable.getCellObject(pIPSecVPN.tableSecProposal(), count -1, 2));
					opr.SendKeysNoClear(pIPSecVPN.textIKEReInter(), timeIKE);
					opr.SendKeysNoClear(pIPSecVPN.textIPSecReInter(), timeIPS);
				}
				if(DHGroup != null) {
					opr.JsClick(CommonTable.getCellObject(pIPSecVPN.tableSecProposal(), count -1, 3));
					opr.Select(pIPSecVPN.selPFGroup(), DHGroup);
				}
				if(IKEAlg != null) {
					CommonTable.getCellObject(pIPSecVPN.tableSecProposal(), count -1, 4).click();
					Debug("清除已经选择的安全提议");			
					Select slt = new Select(pIPSecVPN.selSeltedIKEPro());
					List<WebElement> slts = slt.getOptions();
					for (int i = 0; i < slts.size(); i++) {
						slt.getOptions().get(0).click();
						sleep(1);
						opr.JsClick(pIPSecVPN.buttonDelIKE());
					}					
					opr.Select(pIPSecVPN.selEncryptionAlgIKE(), IKEAlg);
					opr.Select(pIPSecVPN.selAuthAlgIKE(), IKEAuthAlg);
					opr.Select(pIPSecVPN.selDHGroupIKE(), IKEDHgroup);
					Debug("点击增加");
					opr.JsClick(pIPSecVPN.buttonAddIKE());
					opr.JsClick(pIPSecVPN.buttonOK());
				}
				if(IPSAlg != null) {
					CommonTable.getCellObject(pIPSecVPN.tableSecProposal(), count -1, 5).click();
					Debug("清除已选安全提议");
					Select slt = new Select(pIPSecVPN.selSeltedIPSecPro());
					List<WebElement> slts = slt.getOptions();
					for (int i = 0; i < slts.size(); i++) {
						slt.getOptions().get(0).click();
						sleep(1);
						opr.JsClick(pIPSecVPN.buttonDelIPS());
					}
					opr.Select(pIPSecVPN.selEncryptionAlgIPSec(), IPSAlg);
					opr.Select(pIPSecVPN.selDHGroupIKE(), IPSAuthAlg);
					Debug("点击增加按钮");
					opr.JsClick(pIPSecVPN.buttonAddIPS());
					opr.JsClick(pIPSecVPN.buttonOK());
				}
				pIPSecVPN.blackSecPro();
				Debug("点击确认");
				opr.clickConfirm();		
			}	
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			Error("增加安全提议异常");
			return false;
		}
	}
	
	/**
	 * @param ID
	 * @param IPtype
	 * @param IP
	 * @param mask
	 * @param description
	 * @return tunnel interface
	 */
	public boolean addTunnelInterface(String ID ,String IPtype,String IP,String mask,String mode,String description) throws Exception {
		try {
			Debug("进入IPSecVPN配置界面");
			goIPSecVPNPage();
			sleep(1);
			opr.SwitchToFrame();
			sleep(1);
			Debug("点击Tunnel接口");
			pIPSecVPN.topTunnelInterface().click();
			sleep(1);
			String str = CommonTable.getCellString(pIPSecVPN.tableTunnelInterface(), 0, 0);
			if(str.equals("请配置隧道编号")) {
				opr.Click(CommonTable.getCellObject(pIPSecVPN.tableTunnelInterface(), 0, 0));
				sleep(3);
				Debug("配置tunnel接口ID");
//				opr.SendKeysNoClear(pIPSecVPN.textInterID(), ID);
				JavascriptExecutor jsExecutor1 = (JavascriptExecutor)driver;
		    	String js2 = "document.getElementById('ipsec_tunnel_id').value='" +ID +"'";
		    	jsExecutor1.executeScript(js2);                        
					
//				pIPSecVPN.textInterID().sendKeys(ID);
//				opr.SendKeys(pIPSecVPN.textInterID(), ID);
				Debug("配置tunnel接口IP");
				opr.Click(CommonTable.getCellObject(pIPSecVPN.tableTunnelInterface(), 0, 1));
				if(IPtype.equals("ipv4")) {
					opr.ClickToState(pIPSecVPN.radioIpv4(), true);	
				}else {
					opr.ClickToState(pIPSecVPN.radioIpv6(), true);
				}
				opr.SendKeysNoClear(pIPSecVPN.textInterIP(), IP);
				opr.SendKeysNoClear(pIPSecVPN.textMask(), mask);
				opr.Click(pIPSecVPN.buttonOK());
				opr.Click(CommonTable.getCellObject(pIPSecVPN.tableTunnelInterface(), 0, 2));
				sleep(1);
				Debug("选择tunnel接口应用模式");
				opr.Select(pIPSecVPN.selTunnelMode(), mode);
				opr.Click(CommonTable.getCellObject(pIPSecVPN.tableTunnelInterface(), 0, 3));
				sleep(1);
				if(description != null) {
					Debug("配置接口描述");
					opr.SendKeysNoClear(pIPSecVPN.textDescription(), description);	
				}
			}else {
				Debug("点击复制");
				opr.Click(pIPSecVPN.butCoppyTunnelInter());
			    int count = CommonTable.getRowByColString(pIPSecVPN.tableTunnelInterface(), "请配置隧道IP", 1);
			    opr.Click(CommonTable.getCellObject(pIPSecVPN.tableTunnelInterface(), count -1, 0));
				sleep(1);
				Debug("配置tunnel接口ID");
				opr.SendKeysNoClear(pIPSecVPN.textInterID(), ID);
				Debug("配置tunnel接口IP");
				opr.Click(CommonTable.getCellObject(pIPSecVPN.tableTunnelInterface(), count-1, 1));
				if(IPtype.equals("ipv4")) {
					opr.ClickToState(pIPSecVPN.radioIpv4(), true);	
				}else {
					opr.ClickToState(pIPSecVPN.radioIpv6(), true);
				}
				opr.SendKeysNoClear(pIPSecVPN.textInterIP(), IP);
				opr.SendKeysNoClear(pIPSecVPN.textMask(), mask);
				opr.JsClick(pIPSecVPN.buttonOK());
				opr.Click(CommonTable.getCellObject(pIPSecVPN.tableTunnelInterface(), count -1, 2));
				Debug("选择tunnel接口应用模式");
				opr.Select(pIPSecVPN.selTunnelMode(), mode);
				opr.Click(CommonTable.getCellObject(pIPSecVPN.tableTunnelInterface(), count-1, 3));
				if(description != null) {
					Debug("配置接口描述");
					opr.SendKeysNoClear(pIPSecVPN.textDescription(), description);	
				}
			}
		return true;
		}catch(Exception e) {
			e.printStackTrace();
			Error("增加tunnel接口异常");
			return false;
		}
	}
	
	/**
	 * 更改安全策略中的高级配置的安全协议
	 */
	public boolean changeSecProPolicyMode(String name ,String mode,String secPro,String action) throws Exception {
		try {
			goIPSecVPNPage();
			sleep(1);
			opr.SwitchToFrame();
			sleep(3);
			opr.Click(pIPSecVPN.topPolicyMode());
			sleep(1);
			int count = CommonTable.getRowByColString(pIPSecVPN.tableGateway(),name,0);
			opr.Click(CommonTable.getCellObject(pIPSecVPN.tableGateway(), count, 9));
			sleep(1);
			opr.Select(pIPSecVPN.selXieShangMode(), mode);
			sleep(1);
			opr.JsClick(pIPSecVPN.selSecProAdvancConf());
			opr.SelectByValue(pIPSecVPN.selSecProAdvancConf(), secPro);
			sleep(1);
			opr.Select(pIPSecVPN.selAction(), action);
//			opr.Select(pIPSecVPN.selSecProAdvancConf(), secPro);
			sleep(1);
			opr.JsClick(pIPSecVPN.buttonOKSec());
//			opr.JsClick(pIPSecVPN.buttonOK());
			sleep(1);
			opr.clickConfirm();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			Error("更改策略模式安全协议异常");
			return false;
		}	
	}
	
	/**
	 * @param name
	 * @return 增加网段组列表
	 * @throws Exception
	 */
	public boolean addSubnetGroupList(int count,String name) throws Exception {
		try {
			goIPSecVPNPage();
			opr.SwitchToFrame();
			sleep(1);
			Debug("点击保护网段");
			opr.Click(pIPSecVPN.topProtectSubnet());
			sleep(1);
			Debug("点击网关IPv4网段组");
			opr.Click(pIPSecVPN.lnkGatway4Subnet());
			Debug("点击增加按钮");
			opr.Click(pIPSecVPN.buttonAddProtectSubent());
			sleep(2);
			Debug("输入网关IPV4网段组名称");
			opr.Click(pIPSecVPN.lnkGatway4Subnet());
			opr.SendKeys(pIPSecVPN.textNameProtectSubnet(count), name);
			sleep(1);
			opr.Click(CommonTable.getCellObject(pIPSecVPN.tableProtectSubnet(), 0, 6));
			sleep(1);
			Debug("点击确认");
			opr.clickConfirm();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			Error("增加网段组列表异常");
			return false;
		}
	}
	
	/**
	 * @param name
	 * @param localIP
	 * @param localMask
	 * @param remoteIP
	 * @param remoteMask
	 * @return 增加网关IPv4网段组
	 * @throws Exception
	 */
	public boolean addProtectSubnetList(int count,String name,String localIP,String localMask,String remoteIP,String remoteMask) throws Exception {
		try {
			goIPSecVPNPage();
			opr.SwitchToFrame();
			sleep(1);
			Debug("点击保护网段");
			opr.Click(pIPSecVPN.topProtectSubnet());
			sleep(1);
			Debug("点击网关IPv4网段组");
			opr.ClickToOpen(pIPSecVPN.liGatway4Subnet(), pIPSecVPN.lnkGatway4Subnet());
//			opr.Click(pIPSecVPN.lnkGatway4Subnet());
			sleep(1);
			Debug("点击 新建的网关IPv4网段组菜单");
//			opr.ClickToOpen(pIPSecVPN.liNameProtectSubnet(count), pIPSecVPN.lnkNameProtectSubnet(name));
//			opr.Click(pIPSecVPN.lnkNameProtectSubnet(name));
			opr.Click(pIPSecVPN.liNameProtectSubnet(count));
			sleep(1);
			String str = CommonTable.getCellString(pIPSecVPN.tableProtectSubnet(), 0, 0);
			if (str.equals(" ")) {
				Debug("输入本端保护网段");
				opr.Click(CommonTable.getCellObject(pIPSecVPN.tableProtectSubnet(), 0, 2));
				opr.SendKeysNoClear(pIPSecVPN.textLocalProtectSubnet(), localIP);
				sleep(1);
				Debug("输入本端子网掩码");
				opr.Click(CommonTable.getCellObject(pIPSecVPN.tableProtectSubnet(), 0, 3));
				opr.SendKeysNoClear(pIPSecVPN.textMaskLocal(), localMask);
				sleep(1);
				Debug("输入对端保护网段");
				opr.Click(CommonTable.getCellObject(pIPSecVPN.tableProtectSubnet(), 0, 4));
				opr.SendKeysNoClear(pIPSecVPN.textRemoteProtectSubnet(), remoteIP);
				sleep(1);
				Debug("输入对端子网掩码");
				opr.Click(CommonTable.getCellObject(pIPSecVPN.tableProtectSubnet(), 0, 5));
				sleep(1);
				opr.SendKeysNoClear(pIPSecVPN.textMaskRemeote(), remoteMask);
				opr.Click(CommonTable.getCellObject(pIPSecVPN.tableProtectSubnet(), 0, 6));
				Debug("点击确认");
				opr.clickConfirm();
			}else {
				Debug("点击复制");
				opr.Click(pIPSecVPN.buttonCopyProtectSubnet());
				sleep(1);
				int count1 = CommonTable.getRowByColString(pIPSecVPN.tableProtectSubnet(), "无", 2);
				Debug("输入本端保护网段");
				opr.Click(CommonTable.getCellObject(pIPSecVPN.tableProtectSubnet(), count1 -1, 2));
				opr.SendKeysNoClear(pIPSecVPN.textLocalProtectSubnet(), localIP);
				sleep(1);
				Debug("输入本端子网掩码");
				opr.Click(CommonTable.getCellObject(pIPSecVPN.tableProtectSubnet(), count1 -1, 3));
				opr.SendKeysNoClear(pIPSecVPN.textMaskLocal(), localMask);
				sleep(1);
				Debug("输入对端保护网段");
				opr.Click(CommonTable.getCellObject(pIPSecVPN.tableProtectSubnet(), count1 -1, 4));
				opr.SendKeysNoClear(pIPSecVPN.textRemoteProtectSubnet(), remoteIP);
				sleep(1);
				Debug("输入对端子网掩码");
				opr.Click(CommonTable.getCellObject(pIPSecVPN.tableProtectSubnet(), count1 -1, 5));
				sleep(1);
				opr.SendKeysNoClear(pIPSecVPN.textMaskRemeote(), remoteMask);
				opr.Click(CommonTable.getCellObject(pIPSecVPN.tableProtectSubnet(), count1 -1, 6));
				Debug("点击确认");
				opr.clickConfirm();
			}	
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			Error("增加网关IPv4网段组异常");
			return false;
		}
	}
	
//	public boolean addProtectSubnetList(String name,String localIP,String localMask,String remoteIP,String remoteMask) throws Exception {
//		try {
//			goIPSecVPNPage();
//			opr.SwitchToFrame();
//			sleep(1);
//			Debug("点击保护网段");
//			opr.Click(pIPSecVPN.topProtectSubnet());
//			sleep(1);
//			Debug("点击网关IPv4网段组");
//			opr.Click(pIPSecVPN.lnkGatway4Subnet());
//			sleep(1);
//			Debug("输入本端保护网段");
//			opr.Click(CommonTable.getCellObject(pIPSecVPN.tableProtectSubnet(), 0, 2));
//			opr.SendKeysNoClear(pIPSecVPN.textLocalProtectSubnet(), localIP);
//			sleep(1);
//			Debug("输入本端子网掩码");
//			opr.Click(CommonTable.getCellObject(pIPSecVPN.tableProtectSubnet(), 0, 3));
//			opr.SendKeysNoClear(pIPSecVPN.textMaskLocal(), localMask);
//			sleep(1);
//			Debug("输入对端保护网段");
//			opr.Click(CommonTable.getCellObject(pIPSecVPN.tableProtectSubnet(), 0, 4));
//			opr.SendKeysNoClear(pIPSecVPN.textRemoteProtectSubnet(), remoteIP);
//			sleep(1);
//			Debug("输入对端子网掩码");
//			opr.Click(CommonTable.getCellObject(pIPSecVPN.tableProtectSubnet(), 0, 5));
//			sleep(1);
//			opr.SendKeysNoClear(pIPSecVPN.textMaskRemeote(), remoteMask);
//			opr.Click(CommonTable.getCellObject(pIPSecVPN.tableProtectSubnet(), 0, 6));
//			Debug("点击确认");
//			opr.clickConfirm();	
//		return true;
//	}catch(Exception e) {
//		e.printStackTrace();
//		Error("增加网关IPv4网段组异常");
//		return false;
//	}
//}

//	public boolean delete
	
	
}
