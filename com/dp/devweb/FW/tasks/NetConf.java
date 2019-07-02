package dp.devweb.FW.tasks;

import org.openqa.selenium.WebElement;

import dp.devweb.FW.appobject.NetConfPage;
import dp.devweb.FW.appobject.TreeMenuPage;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;
import dp.devweb.common.CommonTable;

/**
 * 
* @Title: NetConf.java 
* @Description: TODO(组网配置界面操作方法) 
* @author z01674 
* @date 2015年4月2日 上午9:51:41 
* @version V4.4
 */
public class NetConf extends CommonObjectScript {

	public TreeMenuPage pTree = new TreeMenuPage();
	public NetConfPage pNet = new NetConfPage();
	public CommonOperator opr = new CommonOperator();
	
	//进入到组网配置界面
	public boolean goNetworkConfigPage() throws Exception {
		try {
			// 切换到左侧windows
			opr.SwitchToDefault();

			Debug("网络管理 → 接口管理 → 组网配置");
			opr.ClickToOpen(pTree.liNetManagement(), pTree.lnkNetManagement());
			sleep(1);
			opr.ClickToOpen(pTree.liIntfManagement(), pTree.lnkIntfManagement());
			sleep(1);
			pTree.lnkNetConf().click();
			return true;
		} catch (Exception e) {
			Error("进入组网配置页面异常");
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 组网配置界面配置接口静态IP
	 * 
	 * @param name
	 *            接口名
	 * @param ip
	 *            接口IP
	 * @param mask
	 *            接口子网掩码
	 * @return 执行成功返回true，失败返回false
	 * @throws Exception
	 */
	public boolean configLoopbackIp(String name, String ip, String mask)
			throws Exception {
		try {
			opr.SwitchToDefault();
			// 进入组网配置页面
			goNetworkConfigPage();

			// 切换到右侧frame
			opr.SwitchToFrame();

			Debug("点击" + name);
			WebElement obj = CommonTable.getCellObjByColString(pNet.tblNetConf(),
					name, 0, 4);
			opr.JsClick(obj);
			Debug("输入  " + name + "  口的静态IP为：" + ip);
			pNet.txtIpAddr().click();
			pNet.txtIpAddr().sendKeys(ip);

			Debug("输入  " + name + "  口的子网掩码为：：" + mask);
			opr.Select(pNet.sltMask(), mask);

			Debug("点击 确定");
			pTree.btnOK().click();

			Debug("点击 确认");
			pTree.btnConfirm().click();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			Error("接口配置Ip地址异常");
			return false;
		}
	}

	public boolean configIntfIpAddr(String name, String type, String ip,
			String mask) throws Exception {
		try {
			opr.SwitchToDefault();
			// 进入组网配置页面
			goNetworkConfigPage();

			// 配置接口IP地址
			opr.SwitchToFrame();

			Debug("配置接口： " + name);
			opr.Click(CommonTable.getCellObjByColString(pNet.tblNetConf(), name,
					0, 4));

			Debug("选择IP类型： " + type);
			opr.Select(pNet.sltIpConfig(), type);

			Debug("输入IPv4地址/掩码： " + ip + "/" + mask);
			opr.SendKeys(pNet.txtIpAddr(), ip);
			opr.Select(pNet.sltMask(), mask);

			Debug("点击 确定");
			opr.Click(pTree.btnOK());

			Debug("点击 确认");
			opr.Click(pTree.btnConfirm());

			return true;
		} catch (Exception e) {
			Error("配置接口IP地址异常");
			e.printStackTrace();
			return false;
		}
	}

	public boolean verifyIntfIpAddr(String name, String expectedIp)
			throws Exception {
		try {
			opr.SwitchToDefault();
			// 进入组网配置页面
			goNetworkConfigPage();

			// 配置接口IP地址
			opr.SwitchToFrame();

			String actualText = CommonTable.getCellObjByColString(
					pNet.tblNetConf(), name, 0, 4).getText();

			if (actualText.equals("无")) {
				return true;
			} else {
				String actualIp = actualText.substring(actualText.indexOf("："));

				if (actualIp.contains(expectedIp)) {
					Debug("期望值： " + expectedIp + "\t" + "实际值： " + actualIp
							+ "\t" + "相等");
					return true;
				} else {
					Debug("期望值： " + expectedIp + "\t" + "实际值： " + actualIp
							+ "\t" + "不相等");
					return false;
				}
			}
		} catch (Exception e) {
			Error("验证接口IP地址异常");
			e.printStackTrace();
			return false;
		}
	}

	public boolean modifyIntfIpAddr(String name, String type, String ip,
			String mask) throws Exception {
		try {
			opr.SwitchToDefault();
			// 进入组网配置页面
			goNetworkConfigPage();

			// 配置接口IP地址
			opr.SwitchToFrame();

			Debug("配置接口： " + name);
			opr.Click(CommonTable.getCellObjByColString(pNet.tblNetConf(), name,
					0, 4));

			Debug("选择IP类型： " + type);
			opr.Select(pNet.sltIpConfig(), type);

			Debug("输入IPv4地址/掩码： " + ip + "/" + mask);
			opr.SendKeys(pNet.txtIpAddr(), ip);
			opr.Select(pNet.sltMask(), mask);

			Debug("点击 确定");
			opr.Click(pTree.btnOK());

			Debug("点击 确认");
			opr.Click(pTree.btnConfirm());

			return true;
		} catch (Exception e) {
			Error("配置接口IP地址异常");
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteIntfIpAddr(String name, String type) throws Exception {
		try {
			opr.SwitchToDefault();
			// 进入组网配置页面
			goNetworkConfigPage();

			// 配置接口IP地址
			opr.SwitchToFrame();

			Debug("配置接口： " + name);
			opr.Click(CommonTable.getCellObjByColString(pNet.tblNetConf(), name,
					0, 4));

			Debug("选择IP类型： " + type);
			opr.Select(pNet.sltIpConfig(), type);

			Debug("点击 确定");
			opr.JsClick(pTree.btnOK());

			Debug("点击 确认");
			opr.Click(pTree.btnConfirm());

			return true;
		} catch (Exception e) {
			Error("配置接口IP地址异常");
			e.printStackTrace();
			return false;
		}
	}

}
