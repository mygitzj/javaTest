package dp.devweb.FW.tasks;

import dp.devweb.FW.appobject.StaticRoutePage;
import dp.devweb.FW.appobject.TreeMenuPage;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;
import dp.devweb.common.CommonTable;

/**
 * @Title: StaticRoute.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author w01866
 * @date 2015年1月19日 下午4:19:31
 * @version V4.4
 */
public class StaticRoute extends CommonObjectScript {

	public TreeMenuPage pTree = new TreeMenuPage();
	public StaticRoutePage pRoute = new StaticRoutePage();
	public CommonOperator opr = new CommonOperator();

	public boolean goStaticRoutePage() throws Exception {
		try {
			// 切换到左侧windows
			opr.SwitchToDefault();

			Debug("进入静态路由 页面");
			Debug("点击 网络管理 → 单播IPv4路由 → 静态路由");
			opr.ClickToOpen(pTree.liNetManagement(), pTree.lnkNetManagement());
			Thread.sleep(1000);
			opr.ClickToOpen(pTree.liUniIpv4Route(), pTree.lnkUniIpv4Route());
			Thread.sleep(1000);
			pTree.lnkStaticRoute().click();
			Thread.sleep(1000);
			return true;
		} catch (Exception e) {
			Error("进入静态路由页面异常");
			e.printStackTrace();
			return false;
		}
	}

	public boolean addStaticRoute(String ip, String mask, String intf,
			String hopIp) throws Exception {
		try {
			opr.SwitchToDefault();
			// 进入静态路由页面
			goStaticRoutePage();
			opr.SwitchToFrame();
			
			// 判断初始环境是否有静态路由，以便判断后续增加静态路由是否需要点击复制按钮。
			String str = CommonTable.getCellString(pRoute.tblStaticRoute(), 0, 0);
		    
			if (str.contains("请配置")) {
				Debug("输入目的网段： " + ip);
				opr.Click(CommonTable.getCellObject(pRoute.tblStaticRoute(),
						0, 0));
				opr.SendKeys(pRoute.txtIpSegment(), ip);

				Debug("输入子网掩码： " + mask);
				opr.Click(CommonTable.getCellObject(pRoute.tblStaticRoute(),
						0, 1));
				opr.Select(pRoute.sltMask(), mask);

				Debug("选择下一跳出接口： " + intf);
				opr.Click(CommonTable.getCellObject(pRoute.tblStaticRoute(),
						0, 3));
				sleep(1);
				opr.Select(pRoute.sltGateway(), intf);

				Debug("输入下一跳IP地址： " + hopIp);
				opr.SendKeys(pRoute.txtNexthop(), hopIp);
			} else {
				Debug("点击 复制");
				opr.Click(pRoute.spnCopy());

				// 确认要增加的路由所在行
				int row = CommonTable.getRowByColString(
						pRoute.tblStaticRoute(), "请配置", 0);

				Debug("输入目的网段： " + ip);
				opr.JsClick(CommonTable.getCellObject(pRoute.tblStaticRoute(),
						row, 0));
				opr.SendKeys(pRoute.txtIpSegment(), ip);

				Debug("输入子网掩码： " + mask);
				opr.JsClick(CommonTable.getCellObject(pRoute.tblStaticRoute(),
						row, 1));
				opr.Select(pRoute.sltMask(), mask);

				Debug("选择下一跳出接口： " + intf);
				opr.JsClick(CommonTable.getCellObject(pRoute.tblStaticRoute(),
						row, 3));
				sleep(1);
				opr.Select(pRoute.sltGateway(), intf);

				Debug("输入下一跳IP地址： " + hopIp);
				opr.SendKeys(pRoute.txtNexthop(), hopIp);
			}

			Debug("点击确定");
			opr.JsClick(pTree.btnOK());

			Debug("点击确认");
			opr.Click(pTree.btnConfirm());

			return true;
		} catch (Exception e) {
			Error("增加静态路由异常");
			e.printStackTrace();
			return false;
		}
	}

	public boolean verifyStaticRoute(String ip, String intf, String hopIp)
			throws Exception {
		try {
			opr.SwitchToDefault();
			// 进入静态路由页面
			goStaticRoutePage();
			opr.SwitchToFrame();

			if (CommonTable
					.isStringExsitedFuzzy(pRoute.tblStaticRoute(), ip, 0)
					// && CommonTable.isStringExsitedFuzzy(pRoute.tblStaticRoute(), mask, 1)
					&& CommonTable.isStringExsitedFuzzy(pRoute.tblStaticRoute(), intf, 3)
					&& CommonTable.isStringExsitedFuzzy(pRoute.tblStaticRoute(), hopIp, 3))
				return true;
			else{
				Error("静态路由不存在，增加失败");
			return false;
			}
		} catch (Exception e) {
			Error("验证静态路由异常");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteStaticRoute(String ip)
			throws Exception {
		try {
			opr.SwitchToDefault();
			// 进入静态路由页面
			goStaticRoutePage();
			opr.SwitchToFrame();

			// 获取指定静态路由所在行
			int row = CommonTable.getRowByColString(pRoute.tblStaticRoute(), ip, 0);
			
			// 点击删除
			Debug("删除静态路由： " + ip);
			opr.Click(pRoute.spnDelete(row));
			
			Debug("点击确认");
			opr.Click(pTree.btnConfirm());
			
			return true;
			
		} catch (Exception e) {
			Error("删除静态路由异常");
			e.printStackTrace();
			return false;
		}
	}

}
