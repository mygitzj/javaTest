package dp.devweb.LB.tasks;

import dp.devweb.LB.appobject.TreeMenuPage;
import dp.devweb.LB.appobject.TCPHealthCheckPage;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;

/**
 * @Title: TCPHealthCheck.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author w01866
 * @date 2015年1月30日 下午2:49:39
 * @version V4.4
 */
public class TCPHealthCheck extends CommonObjectScript {
	public CommonOperator opr = new CommonOperator();
	public TCPHealthCheckPage pTCP = new TCPHealthCheckPage();
	public TreeMenuPage pTree = new TreeMenuPage();

	public boolean goTCPHealthCheckPage() throws Exception {
		try {
			// 切换至默认frame
			opr.SwitchToDefault();
			Debug("ADX → 服务器负载均衡 → 服务器健康检查 → TCP健康检查");
			pTree.lnkAdx().click();

			// 切换farme
			opr.SwitchToMenuFrame();
			sleep(1);

			opr.ClickToOpen(pTree.liServerLb(), pTree.lnkServerLb());
			sleep(1);
			opr.ClickToOpen(pTree.liServerHealthCheck(),
					pTree.lnkServerHealthCheck());
			sleep(1);
			opr.Click(pTree.lnkTCPHealthCheck());
			sleep(1);
			return true;
		} catch (Exception e) {
			Error("进入TCP健康检查页面异常");
			e.printStackTrace();
			return false;
		}
	}

	public boolean addTCPHealthCheck(String name, int timeout, int interval,
			int trytime, boolean bPass, String send, String receive,
			boolean bTriangle, String ip, int port) throws Exception {
		try {
			// 进入TCP健康检查页面
			goTCPHealthCheckPage();
			opr.SwitchToFrameFromMenu();

			// 点击 添加
			opr.Click(pTCP.btnAdd());

			// TCP健康检查
			opr.SendKeys(pTCP.txtName(), name);
			opr.SendKeys(pTCP.txtTimeout(), timeout + "");
			opr.SendKeys(pTCP.txtInterval(), interval + "");
			opr.SendKeys(pTCP.txtTryTime(), trytime + "");
			opr.ClickToState(pTCP.chkMustPass(), bPass);

			// 自定义检测内容
			if (send != null || receive != null) {
				if (pTCP.imgDefinedCheck().getAttribute("src").toString()
						.contains("up"))
					opr.Click(pTCP.imgDefinedCheck());
				if (send != null)
					opr.SendKeys(pTCP.txtSendContent(), send);
				if (receive != null)
					opr.SendKeys(pTCP.txtReceivePacket(), receive);
			}

			// 三件传输配置
			if (pTCP.imgTriangle().getAttribute("src").toString()
					.contains("up"))
				opr.Click(pTCP.imgTriangle());
			opr.ClickToState(pTCP.chkTriangle(), bTriangle);

			// 高级配置
			if (pTCP.imgAdvanced().getAttribute("src").toString()
					.contains("up"))
				opr.Click(pTCP.imgAdvanced());
			if (ip != null)
				opr.SendKeys(pTCP.txtIPAddress(), ip);
			if (port != 0)
				opr.SendKeys(pTCP.txtPort(), port + "");

			// 点击 确认
			opr.Click(pTree.btnConfirm());

			return true;
		} catch (Exception e) {
			Error("增加TCP健康检查异常\t" + e);
			return false;
		}
	}
}
