package dp.devweb.LB.tasks;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;

import dp.devweb.LB.appobject.BasicLinkPage;
import dp.devweb.LB.appobject.TreeMenuPage;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;

/**
 * @Title: BasicLink.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author w01866
 * @date 2015年2月3日 下午4:01:44
 * @version V4.4
 */
public class BasicLink extends CommonObjectScript {
	public CommonOperator opr = new CommonOperator();
	public BasicLinkPage pBasic = new BasicLinkPage();
	public TreeMenuPage pTree = new TreeMenuPage();

	public void goBasicLinkPage() throws Exception {
		try {
			// 切换至默认frame
			opr.SwitchToDefault();
			Debug("ADX → 链路负载均衡 → 基础链路负载均衡");
			pTree.lnkAdx().click();

			// 切换farme
			opr.SwitchToMenuFrame();
			sleep(1);

			opr.ClickToOpen(pTree.liLinkLB(), pTree.lnkLinkLB());
			sleep(1);

			opr.Click(pTree.lnkBasicLinkLB());
			sleep(1);
		} catch (Exception e) {
			Error("进入基础链路负载均衡页面异常\n" + e);
			e.printStackTrace();
		}
	}

	public boolean addBasicLink(String name, int intf, String gateway,
			int bandwidth, int threshold, int weight, int priority,
			int operator, int lost, int latency, int passLeast,
			String sourceIP, String dns, boolean bRoute) throws Exception {
		try {
			// 进入基础链路负载均衡页面
			goBasicLinkPage();
			opr.SwitchToFrameFromMenu();

			// 点击添加
			opr.Click(pBasic.btnAdd());

			// 基础配置
			opr.SendKeys(pBasic.txtName(), name);
			opr.Select(pBasic.sltInterface(), intf);
			opr.SendKeys(pBasic.txtGateway(), gateway);
			sleep(1);
			opr.SendKeys(pBasic.txtBandwidth(), bandwidth + "");
			opr.SendKeys(pBasic.txtThreshold(), threshold + "");
			opr.SendKeys(pBasic.txtWeight(), weight + "");
			opr.SendKeys(pBasic.txtPriority(), priority + "");
			opr.Select(pBasic.sltOperators(), operator);

			// 获取健康检查list中的option
			List<WebElement> listRight = opr.getOptions(pBasic.sltGroupRight());
			for (int i = 0; i < listRight.size(); i++) {
				opr.Select(pBasic.sltGroupRight(), 0);
				opr.Click(pBasic.btnToLeft());
			}

			// 质量检查
			opr.SendKeys(pBasic.txtLostRate(), lost + "");
			opr.SendKeys(pBasic.txtLatency(), latency + "");
			opr.SendKeys(pBasic.txtPassLeast(), passLeast + "");
			if (sourceIP != null)
				opr.SendKeys(pBasic.txtSourceIP(), sourceIP);
			opr.SendKeys(pBasic.txtDNS(), dns);

			// 高级配置
			if (operator != 0)
				opr.ClickToState(pBasic.chkRoute(), bRoute);

			// 点击确认
			opr.Click(pTree.btnConfirm());

			return true;
		} catch (Exception e) {
			Error("增加基础链路负载均衡异常\n" + e);
			e.printStackTrace();
			return false;
		}
	}

	public boolean modifyBasicLink(String name, int intf, String gateway,
			int bandwidth, int threshold, int weight, int priority,
			int operator, int lost, int latency, int passLeast,
			String sourceIP, String dns, boolean bRoute) throws Exception {
		try {
			// 进入基础链路负载均衡页面
			goBasicLinkPage();
			opr.SwitchToFrameFromMenu();

			// 点击链路信息
			String spnName = null;
			for (int i = 0; i < pBasic.spnLists().size(); i++) {
				spnName = pBasic.spnLists().get(i).getText().trim();
				if (spnName.equals(name)) {
					opr.Click(pBasic.spnLists().get(i));
					break;
				}
			}
			sleep(2);

			// 基础配置
			// opr.SendKeys(pBasic.txtName(), "modify" + name); // 修改名称
			opr.Select(pBasic.sltInterface(), intf);
			opr.SendKeys(pBasic.txtGateway(), gateway);
			sleep(1);
			opr.SendKeys(pBasic.txtBandwidth(), bandwidth + "");
			opr.SendKeys(pBasic.txtThreshold(), threshold + "");
			opr.SendKeys(pBasic.txtWeight(), weight + "");
			opr.SendKeys(pBasic.txtPriority(), priority + "");
			opr.Select(pBasic.sltOperators(), operator);

			// 获取健康检查list中的option
			List<WebElement> listRight = opr.getOptions(pBasic.sltGroupRight());
			List<WebElement> listLeft = opr.getOptions(pBasic.sltGroupLeft());
			if (listLeft == null || listLeft.size() <= 0) {
				for (int i = 0; i < listRight.size(); i++) {
					opr.Select(pBasic.sltGroupRight(), 0);
					opr.Click(pBasic.btnToLeft());
				}
			}

			if (listRight == null || listRight.size() <= 0) {
				for (int i = 0; i < listLeft.size(); i++) {
					opr.Select(pBasic.sltGroupLeft(), 0);
					opr.Click(pBasic.btnToRight());
				}
			}

			// 质量检查
			opr.SendKeys(pBasic.txtLostRate(), lost + "");
			opr.SendKeys(pBasic.txtLatency(), latency + "");
			opr.SendKeys(pBasic.txtPassLeast(), passLeast + "");
			if (sourceIP != null)
				opr.SendKeys(pBasic.txtSourceIP(), sourceIP);
			opr.SendKeys(pBasic.txtDNS(), dns);

			// 高级配置
			if (operator != 0)
				opr.ClickToState(pBasic.chkRoute(), bRoute);

			// 点击确认
			opr.Click(pTree.btnConfirm());

			return true;
		} catch (Exception e) {
			Error("修改基础链路负载均衡异常\n" + e);
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteBasicLink() throws Exception {
		try {
			// 进入基础链路负载均衡页面
			goBasicLinkPage();
			opr.SwitchToFrameFromMenu();

			opr.Click(pBasic.chkAll());
			opr.Click(pBasic.btnDelete());
			opr.Alert(true);

			opr.Click(pTree.btnConfirm());

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public int getRandom(int n) throws Exception {
		Random r = new Random();
		return r.nextInt(n);
	}

	public int getRandom1ToN(int n) throws Exception {
		Random r = new Random();
		return (r.nextInt(n) + 1);
	}

	public int getRandom2ToN(int n) throws Exception {
		Random r = new Random();
		return (r.nextInt(n) + 2);
	}

}
