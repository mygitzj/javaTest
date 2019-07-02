package dp.devweb.FW.tasks;

import org.openqa.selenium.WebElement;

import dp.devweb.FW.appobject.PimPage;
import dp.devweb.FW.appobject.TreeMenuPage;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;
import dp.devweb.common.CommonTable;

/**
 * @Title: Pim.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author w01866
 * @date 2014年12月4日 上午9:31:48
 * @version V4.4
 */
public class Pim extends CommonObjectScript {

	public TreeMenuPage pageTree = new TreeMenuPage();
	public PimPage pagePim = new PimPage();
	public CommonOperator oprCom = new CommonOperator();

	/**
	 * 网络管理 → 组播IPv4路由 → PIM界面 ，配置候选BSR地址，启用、选接口等操作
	 * 
	 * @param name
	 *            接口名
	 * @param state
	 *            启用、禁用
	 * @return 执行成功返回true，失败返回false
	 * @throws Exception
	 */
	public boolean ConfCandidacyBsr(String name, String state) throws Exception {
		try {
			// 切换到左侧windows
			oprCom.SwitchToDefault();

			Debug("进入 PIM 界面");
			Debug("点击 网络管理");
			oprCom.ClickToOpen(pageTree.liNetManagement(),
					pageTree.lnkNetManagement());
			Debug("点击 组播IPv4路由");
			oprCom.ClickToOpen(pageTree.liGrpIPv4Route(),
					pageTree.lnkGrpIpv4Route());
			Thread.sleep(1000);
			Debug("点击 PIM");
			pageTree.lnkPim().click();

			Debug("配置候选BSR");

			// 切换到右侧frame
			oprCom.SwitchToFrame();

			Debug("进入 Top PIM");
			pagePim.tblTopPim().click();

			Debug("点击并配置候选BSR为： " + state);
			CommonTable.getCellObject(pagePim.tblCandidacyBsrConf(), 0, 0)
					.click();
			oprCom.Select(pagePim.sltState(), state);

			Debug("点击并选择候选BSR接口： " + name);
			CommonTable.getCellObject(pagePim.tblCandidacyBsrConf(), 0, 1)
					.click();
			oprCom.Select(pagePim.sltBsrIntf(), name);

			Debug("点击 确认");
			pageTree.btnConfirm().click();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			Error("配置候选BSR出现异常");
			return false;
		}
	}

	/**
	 * 网络管理 → 组播IPv4路由 → PIM界面 ，配置静态RP地址
	 * 
	 * @param ip
	 *            RP静态地址
	 * @param state
	 *            启用、禁用
	 * @return 执行成功返回true，失败返回false
	 * @throws Exception
	 */
	public boolean ConfStateRp(String ip, String state) throws Exception {
		try {
			// 切换到左侧windows
			oprCom.SwitchToDefault();

			Debug("进入 PIM 界面");
			Debug("点击 网络管理");
			oprCom.ClickToOpen(pageTree.liNetManagement(),
					pageTree.lnkNetManagement());
			Debug("点击 组播IPv4路由");
			oprCom.ClickToOpen(pageTree.liGrpIPv4Route(),
					pageTree.lnkGrpIpv4Route());
			Thread.sleep(1000);
			Debug("点击 PIM");
			pageTree.lnkPim().click();

			Debug("配置静态RP");

			// 切换到右侧frame
			oprCom.SwitchToFrame();

			Debug("进入 Top PIM");
			pagePim.tblTopPim().click();

			Debug("点击并配置静态RP为： " + state);
			CommonTable.getCellObject(pagePim.tblStaticRpConf(), 0, 0).click();
			oprCom.Select(pagePim.sltState(), state);

			Debug("点击并输入静态RP IP地址： " + ip);
			CommonTable.getCellObject(pagePim.tblStaticRpConf(), 0, 1).click();
			pagePim.txtStaticRp().sendKeys(ip);

			Debug("点击 确认");
			pageTree.btnConfirm().click();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			Error("配置静态RP出现异常");
			return false;
		}
	}

	/**
	 * 网络管理 → 组播IPv4路由 → PIM界面 ， 候选RP配置 ：启用、禁用
	 * 
	 * @param name
	 *            接口名
	 * @param state
	 *            接口状态：启用、禁用
	 * @return 执行成功返回true，失败返回false
	 * @throws Exception
	 */
	public boolean ConfigCandidacyRp(String name, String state)
			throws Exception {
		try {
			// 切换到左侧windows
			oprCom.SwitchToDefault();

			Debug("进入 PIM 界面");
			Debug("点击 网络管理");
			oprCom.ClickToOpen(pageTree.liNetManagement(),
					pageTree.lnkNetManagement());
			Debug("点击 组播IPv4路由");
			oprCom.ClickToOpen(pageTree.liGrpIPv4Route(),
					pageTree.lnkGrpIpv4Route());
			Thread.sleep(1000);
			Debug("点击 PIM");
			pageTree.lnkPim().click();

			Debug("配置候选RP");

			// 切换到右侧frame
			oprCom.SwitchToFrame();

			Debug("点击并配置  " + name + " 为：" + state);
			WebElement obj = CommonTable.getCellObjByColString(
					pagePim.tblCandidacyRpConf(), name, 0, 1);
			oprCom.JsClick(obj);

			oprCom.Select(pagePim.sltState(), state);

			Debug("点击 确认");
			pageTree.btnConfirm().click();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			Error("配置候选RP出现异常");
			return false;
		}
	}

	/**
	 * 网络管理 → 组播IPv4路由 → PIM界面 ， PIM接口配置 ：禁用、稀疏模式、密集模式
	 * 
	 * @param name
	 *            接口名
	 * @param state
	 *            接口状态：禁用、稀疏模式、密集模式
	 * @return 执行成功返回true，失败返回false
	 * @throws Exception
	 */
	public boolean ConfigPimIntfState(String name, String mode)
			throws Exception {
		try {
			// 切换到左侧windows
			oprCom.SwitchToDefault();

			Debug("进入 PIM 界面");
			Debug("点击 网络管理");
			oprCom.ClickToOpen(pageTree.liNetManagement(),
					pageTree.lnkNetManagement());
			Debug("点击 组播IPv4路由");
			oprCom.ClickToOpen(pageTree.liGrpIPv4Route(),
					pageTree.lnkGrpIpv4Route());
			Thread.sleep(1000);
			Debug("点击 PIM");
			pageTree.lnkPim().click();

			Debug("配置PIM接口");

			// 切换到右侧frame
			oprCom.SwitchToFrame();

			Debug("点击并配置  " + name + " 为：" + mode);
			WebElement obj = CommonTable.getCellObjByColString(
					pagePim.tblPimIntfConf(), name, 0, 1);
			oprCom.JsClick(obj);

			oprCom.Select(pagePim.sltMode(), mode);

			Debug("点击 确认");
			pageTree.btnConfirm().click();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			Error("配置PIM接口出现异常");
			return false;
		}
	}

	/**
	 * 网络管理 → 组播IPv4路由 → PIM界面 → BSR状态，验证首选BSR地址预期值与实际值是否一致
	 * 
	 * @param expectIp
	 *            首选BSR地址预期值
	 * @return 一致返回true，不一致或异常返回false
	 * @throws Exception
	 */
	public boolean assertBsrAddr(String expectIp) throws Exception {
		try {
			// 切换到左侧windows
			oprCom.SwitchToDefault();

			Debug("进入 PIM 界面");
			Debug("点击 网络管理");
			oprCom.ClickToOpen(pageTree.liNetManagement(),
					pageTree.lnkNetManagement());
			Debug("点击 组播IPv4路由");
			oprCom.ClickToOpen(pageTree.liGrpIPv4Route(),
					pageTree.lnkGrpIpv4Route());
			Thread.sleep(1000);
			Debug("点击 PIM");
			pageTree.lnkPim().click();

			Debug("配置PIM接口");

			// 切换到右侧frame
			oprCom.SwitchToFrame();
			Debug("点击 顶部BSR状态");
			pagePim.tblTopBsrState().click();

			Debug("点击 查询");
			pageTree.btnQuery().click();

			Debug("校验首选BSR地址");
			String realIp = CommonTable.getCellString(pagePim.tblBsrState(), 0,
					0);
			Debug("预期值为： " + expectIp + " ; " + "实际值为： " + realIp);
			if (expectIp.equals(realIp)) {
				Debug("预期值与实际值相符");
				return true;
			} else {
				Debug("预期值与实际值不符");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			Error("校验首选BSR地址出现异常");
			return false;
		}
	}

	/**
	 * 网络管理 → 组播IPv4路由 → PIM界面 → RP信息，验证RP地址预期值与实际值是否一致
	 * 
	 * @param groupIp
	 *            查询组地址
	 * @param expectIp
	 *            RP地址预期值
	 * @return 一致返回true，不一致或异常返回false
	 * @throws Exception
	 */
	public boolean assertRpInfo(String groupIp, String expectIp)
			throws Exception {
		try {
			// 切换到左侧windows
			oprCom.SwitchToDefault();

			Debug("进入 PIM 界面");
			Debug("点击 网络管理");
			oprCom.ClickToOpen(pageTree.liNetManagement(),
					pageTree.lnkNetManagement());
			Debug("点击 组播IPv4路由");
			oprCom.ClickToOpen(pageTree.liGrpIPv4Route(),
					pageTree.lnkGrpIpv4Route());
			Thread.sleep(1000);
			Debug("点击 PIM");
			pageTree.lnkPim().click();

			Debug("配置PIM接口");
			// 切换到右侧frame
			oprCom.SwitchToFrame();
			Debug("点击 顶部RP状态");
			pagePim.tblTopRpInfo().click();

			Debug("校验RP组地址");
			Debug("输入查询组地址： " + groupIp);
			pagePim.txtGrpAddr().sendKeys(groupIp);
			Debug("点击 查询 ");
			pageTree.btnQuery().click();

			String realIp = CommonTable
					.getCellString(pagePim.tblRpInfo(), 0, 1);
			Debug("预期值为： " + expectIp + " ; " + "实际值为： " + realIp);
			if (expectIp.equals(realIp)) {
				Debug("预期值与实际值相符");
				return true;
			} else {
				Debug("预期值与实际值不符");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			Error("校验RP组地址出现异常");
			return false;
		}
	}
}
