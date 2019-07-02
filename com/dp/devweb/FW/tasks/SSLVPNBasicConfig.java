package dp.devweb.FW.tasks;

import dp.devweb.FW.appobject.SSLVPNBasicConfigPage;
import dp.devweb.FW.appobject.TreeMenuServicPage;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;
import dp.devweb.common.CommonTable;

/**
* @Title: BasicConfigSSLVPNPage.java 
* @Description: TODO(SSLVPN 基本配置操作界面) 
* @author z01674 
* @date 2015年7月3日 上午11:51:52 
* @version V4.4
 */

public class SSLVPNBasicConfig extends CommonObjectScript{
	public CommonOperator opr = new CommonOperator();
	public TreeMenuServicPage pTree = new TreeMenuServicPage();
	public SSLVPNBasicConfigPage pBasicConf = new SSLVPNBasicConfigPage();
	
	/**
	 * 进入SSLVPN基本配置界面
	 */
	public boolean goBasicConfig() throws Exception {
		try {
			opr.SwitchToDefault();
			Debug("点击业务");
			opr.Click(pTree.topService());
			sleep(1);
			Debug("点击VPN");
			opr.ClickToOpen(pTree.liVPN(), pTree.lnkVPN());
			sleep(1);
			Debug("点击SSLVPN");
			opr.ClickToOpen(pTree.liSSLVPN(), pTree.lnkSSlVPN());
			sleep(1);
			Debug("点击基本配置");
			opr.Click(pTree.lnkBaseConfigSSLVPNPage());
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			Error("进入SSLVPN基本配置界面错误");
			return false;
		}
	}
	
	/**
	 * 全局配置-开启SSLVPN服务
	 */
	public boolean enableSSLVPNService(String str) throws Exception {
		try {
			goBasicConfig();
			opr.SwitchToFrame();
			sleep(1);
			if (str.equals("启用")) {
				Debug("开启SSLVPN服务");
				opr.ClickToState(pBasicConf.checkEnableSSL(), true);
			}else if(str.equals("不启用")) {
				Debug("关闭SSLVPN服务");
				opr.ClickToState(pBasicConf.checkEnableSSL(), false);
			}
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			Error("开始SSLVPN异常");
			return false;
		}
	}
	
	/**
	 * 
	 * @param str
	 * @return 是否允许公用账户公用
	 * @throws Exception
	 */
	public boolean ReuseAccount(String str) throws Exception {
		try {
			goBasicConfig();
			opr.SwitchToFrame();
			sleep(1);
			Debug("显示高级配置");
			opr.Click(pBasicConf.buttAdvanceConfig());
//			pBasicConf.buttAdvanceConfig().click();
			opr.Click(pBasicConf.butReuseAccount());
			sleep(1);
			Info("是否允许公用账户选择" + str);
			opr.Select(pBasicConf.selReuseAccount(), str);
			sleep(1);
			Debug("点击确认");
			opr.clickConfirm();
			return true;
			}catch (Exception e) {
				e.printStackTrace();
				Error("选择是否允许账户公用错误");
				return false;
		}
	}
	
	/**
	 * 
	 * @param str
	 * @return 选择是否允许用户修改密码
	 * @throws Exception
	 */
	public boolean ModifyPassword(String str) throws Exception {
		try {
			goBasicConfig();
			opr.SwitchToFrame();
			sleep(1);
			Debug("显示高级配置");
			opr.Click(pBasicConf.buttAdvanceConfig());
			opr.Click(pBasicConf.butModifyPassword());
			sleep(1);
			Info("是否允许用户修改密码选择" + str);
			opr.Select(pBasicConf.selModifyPassword(), str);
			sleep(1);
			Debug("点击确认");
			opr.clickConfirm();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			Error("选择是否修改密码错误");
			return false;
		}
	}
	
	
	/**
	 * @return 选择是否同步修改密码
	 * @throws Exception
	 */
	public boolean  SynChangePassword(String str) throws Exception {
		try{
			goBasicConfig();
			opr.SwitchToFrame();
			sleep(1);
			Debug("显示高级配置");
			opr.Click(pBasicConf.buttAdvanceConfig());
			opr.Click(pBasicConf.butSyncChangePassword());
			sleep(1);
			Info("是否同步修改密码选择" + str);
			opr.Select(pBasicConf.selSyncChangePassword(), str);
			sleep(1);
			Debug("点击确认");
			opr.clickConfirm();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			Error("选择是否同步修改密码错误");
			return false;
		}
	}
	
	/**
	 * @param str
	 * @return 只允许访问VPN选择
	 * @throws Exception
	 */
	public boolean OnlyAccessVPN(String str) throws Exception {
		try {
			goBasicConfig();
			opr.SwitchToFrame();
			sleep(1);
			Debug("显示高级配置");
			opr.Click(pBasicConf.buttAdvanceConfig());
			opr.Click(pBasicConf.butOnlyAccessVPN());
			sleep(1);
			Info("是否只允许访问VPN选择" + str);
			opr.Select(pBasicConf.selSyncChangePassword(), str);
			sleep(1);
			Debug("点击确认");
			opr.clickConfirm();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			Error("选择是否允许访问VPN错误");
			return false;
		}
	}
	
	/**
	 * @param str
	 * @return 是否开启报表统计
	 * @throws Exception
	 */
	public boolean EnableStatFlux(String str) throws Exception {
		try {
			goBasicConfig();
			opr.SwitchToFrame();
			sleep(1);
			Debug("显示高级配置");
			opr.Click(pBasicConf.buttAdvanceConfig());
			opr.Click(pBasicConf.butEnableStatFlux());
			sleep(1);
			Info("是否开始报表统计选择" + str);
			opr.Select(pBasicConf.selEnableStatFlux(), str);
			sleep(1);
			Debug("点击确认");
			opr.clickConfirm();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			Error("选择是否开启报表统计错误");
			return false;
		}
	}
	
	/**
	 * @return 是否允许VPN助手登陆
	 * @throws Exception
	 */	
	public boolean PermitVPNHelper(String str) throws Exception {
		try {
			goBasicConfig();
			opr.SwitchToFrame();
			sleep(1);
			Debug("显示高级配置");
			opr.Click(pBasicConf.buttAdvanceConfig());
			opr.Click(pBasicConf.butPermitVPNHelperLogin());
			sleep(1);
			Info("是否允许VPN助手登陆选择" + str);
			opr.Select(pBasicConf.seltPermitVPNHelperLogin(), str);
			sleep(1);
			Debug("点击确认");
			opr.clickConfirm();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			Error("选择是否允许VPN助手登陆错误");
			return false;
		}
	}
	
	/**
	 * @return 是否允许WEB页面登陆
	 * @throws Exception
	 */
	public boolean WebUserLogin(String str) throws Exception {
		try {
			goBasicConfig();
			opr.SwitchToFrame();
			sleep(1);
			Debug("显示高级配置");
			opr.Click(pBasicConf.buttAdvanceConfig());
			opr.Click(pBasicConf.butWebUserLogin());
			sleep(1);
			Info("是否允许WEB页面登陆选择" + str);
			opr.Select(pBasicConf.selWebUserLogin(), str);
			sleep(1);
			Debug("点击确认");
			opr.clickConfirm();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			Error("选择是否允许WEB页面登陆错误");
			return false;
		}
	}
	
	
	/**
	 * @param str
	 * @return 关闭浏览器时是否退出窗口
	 * @throws Exception
	 */
	public boolean ClientExit(String str)  throws Exception {
		try {
			goBasicConfig();
			opr.SwitchToFrame();
			sleep(1);
			Debug("显示高级配置");
			opr.Click(pBasicConf.buttAdvanceConfig());
			opr.Click(pBasicConf.butClientexits());
			sleep(1);
			Info("关闭浏览器时是否退出窗口选择" + str);
			opr.Select(pBasicConf.selClientexits(), str);
			sleep(1);
			Debug("点击确认");
			opr.clickConfirm();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			Error("关闭浏览器时是否退出窗口选择错误");
			return false;
		}
	}
	
	/**
	 * @param str
	 * @return 选择是否使能校验和
	 * @throws Exception
	 */
	public boolean  EnableChecksum(String str) throws Exception {
		try {
			goBasicConfig();
			opr.SwitchToFrame();
			sleep(1);
			Debug("显示高级配置");
			opr.Click(pBasicConf.buttAdvanceConfig());
			opr.Click(pBasicConf.butEnableChecksu());
			sleep(1);
			Info("是否使能校验和：" + str);
			opr.Select(pBasicConf.selEnableChecksum(), str);
			sleep(1);
			Debug("点击确认");
			opr.clickConfirm();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			Error("是否使能校验和错误");
			return false;
		}
	}
	
	/**
	 * @param str
	 * @return 是否清除缓存
	 * @throws Exception
	 */
	public boolean ClearCache(String str) throws Exception {
		try {
			goBasicConfig();
			opr.SwitchToFrame();
			sleep(1);
			Debug("显示高级配置");
			opr.Click(pBasicConf.buttAdvanceConfig());
			opr.Click(pBasicConf.butClearCatch());
			sleep(1);
			Info("是否清除缓存数据：" + str);
			opr.Select(pBasicConf.selClearCatch(), str);
			sleep(1);
			Debug("点击确认");
			opr.clickConfirm();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			Error("是否清除缓存错误");
			return false;
		}
	}
	
	/**
	 * @param str
	 * @return 是否使能日志
	 * @throws Exception
	 */
	public boolean EnableLog(String str) throws Exception {
		try {
			goBasicConfig();
			opr.SwitchToFrame();
			sleep(1);
			Debug("显示高级配置");
			opr.Click(pBasicConf.buttAdvanceConfig());
			opr.Click(pBasicConf.butEnableLog());
			sleep(1);
			Info("是否使能日志：" + str);
			opr.Select(pBasicConf.selEnableLog(), str);
			sleep(1);
			Debug("点击确认");
			opr.clickConfirm();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			Error("是否使能日志错误");
			return false;
		}
	}
	
	
	/**
	 * @param str
	 * @return VPN上线时间统计
	 * @throws Exception
	 */	
	public boolean VPNOnlineTime(String str) throws Exception {
		try {
			goBasicConfig();
			opr.SwitchToFrame();
			sleep(1);
			Debug("显示高级配置");
			opr.Click(pBasicConf.buttAdvanceConfig());
			opr.Click(pBasicConf.butVPNOnlineTime());
			sleep(1);
			Info("是否统计VPN上线时间：" + str);
			opr.Select(pBasicConf.selVPNOnlineTime(), str);
			sleep(1);
			Debug("点击确认");
			opr.clickConfirm();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			Error("是否使统计VPN上线时间错误");
			return false;
		}
	}
	
	public boolean addIPAddrPol(String name, String description,String startIP ,String endIP,String mask) throws Exception {
		try {
			goBasicConfig();
			opr.SwitchToFrame();
			sleep(1);
			Debug("点击顶端IP地址池配置");
			pBasicConf.topIPAddrPol().click();
			sleep(5);
			Debug("点击复制");
			pBasicConf.buttCopyIpAddrPol().click();
			int count = CommonTable.getRowByColString(pBasicConf.tableIpAddrPol(), "设置起始地址", 2);

			Debug("增加ＩＰ地址池的名称");
//			opr.JsClick(CommonTable.getCellObject(pBasicConf.tableIpAddrPol(), count , 0));
//			sleep(1);
			opr.SendKeysNoClear(pBasicConf.textNameIpAddrPol(), name);
			if(description !=null) {
				Debug("增加IP地址池的描述");
				opr.JsClick(CommonTable.getCellObject(pBasicConf.tableIpAddrPol(), count , 1));
				sleep(1);
				opr.SendKeysNoClear(pBasicConf.textNameIpAddrPol(), description);
			}
			Debug("增加起始IP地址");
			opr.JsClick(CommonTable.getCellObject(pBasicConf.tableIpAddrPol(), count , 2));
			sleep(1);
			opr.SendKeys(pBasicConf.textStartIP(), startIP);
			Debug("增加结束IP地址");
			opr.JsClick(CommonTable.getCellObject(pBasicConf.tableIpAddrPol(), count , 3));
			sleep(1);
//			opr.SendKeysNoClear(pBasicConf.textEndIP(), endIP);
			opr.SendKeys(pBasicConf.textEndIP(), endIP);
			Debug("配置子网掩码");
			opr.JsClick(CommonTable.getCellObject(pBasicConf.tableIpAddrPol(), count , 4));
			sleep(1);
			opr.Select(pBasicConf.selMaskIP(), mask);
			sleep(1);
			opr.JsClick(CommonTable.getCellObject(pBasicConf.tableIpAddrPol(), count , 1));
			opr.clickConfirm();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			Error("增加IP地址池配置异常");
			return false;
		}
	}
	
	public boolean deleIPAddrpol(String name) throws Exception {
		try {
			goBasicConfig();
			opr.SwitchToFrame();
			sleep(1);
			Debug("点击顶端IP地址池配置");
			pBasicConf.topIPAddrPol().click();
			sleep(1);
			opr.Click(pBasicConf.buttonDeletIpAddrPol(name));
			sleep(1);
			opr.clickConfirm();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			Error("删除IP地址池配置错误");
			return false;
		}
	}
}
