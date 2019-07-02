package dp.devweb.FW.tasks;

import org.openqa.selenium.WebElement;

import dp.devweb.FW.appobject.CommonConfigPage;
import dp.devweb.FW.appobject.TreeMenuPage;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;
import dp.devweb.common.CommonTable;

/**
 * @Title: CommonConfig.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author w01866
 * @date 2014年12月3日 下午6:55:34
 * @version V4.4
 */
public class CommonConfig extends CommonObjectScript {

	public TreeMenuPage pageTree = new TreeMenuPage();
	public CommonOperator oprCom = new CommonOperator();
	public CommonConfigPage pageConf = new CommonConfigPage();
	
	
	/**
	 * 进入公共配置页面
	 * @return 成功true 失败false
	 * @throws Exception
	 */
	public boolean GoCommonConf() throws Exception {
		try {
			// 切换到左侧windows
			oprCom.SwitchToDefault();

			Debug("网络管理 → 组播IPv4路由 → 公共配置");
			oprCom.ClickToOpen(pageTree.liNetManagement(),
					pageTree.lnkNetManagement());
			sleep(1);
			oprCom.ClickToOpen(pageTree.liGrpIPv4Route(),
					pageTree.lnkGrpIpv4Route());
			sleep(1);
			pageTree.lnkCommonConf().click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			Error("进入公共配置页面异常");
			return false;
		}
	}

	/**
	 * 公共配置界面配置接口状态：启用、禁用
	 * 
	 * @param name
	 *            接口名
	 * @param state
	 *            接口状态：启用、禁用
	 * @return 执行成功返回true，失败返回false
	 * @throws Exception
	 */
	public boolean ConfigIntfState(String name, String state) throws Exception {
		try {
			// 进入公共配置页面
			GoCommonConf();
			
			// 切换到右侧frame
			oprCom.SwitchToFrame();

			Debug("点击 " + state + " " + name);
			WebElement obj = CommonTable.getCellObjByColString(
					pageConf.tblCommonConfig(), name, 0, 1);
			oprCom.JsClick(obj);
			oprCom.Select(pageTree.sltState(), state);

			Debug("点击 确认");
			pageTree.btnConfirm().click();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			Error("配置接口状态出现异常");
			return false;
		}
	}

}
