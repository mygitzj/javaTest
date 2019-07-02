package dp.devweb.LB.tasks;

import dp.devweb.LB.appobject.HTTPHealthCheckPage;
import dp.devweb.LB.appobject.TreeMenuPage;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;

/**
 * @Title: HTTPHealthCheck.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author w01866
 * @date 2015年2月3日 上午9:48:29
 * @version V4.4
 */
public class HTTPHealthCheck extends CommonObjectScript {

	public CommonOperator opr = new CommonOperator();
	public TreeMenuPage pTree = new TreeMenuPage();
	public HTTPHealthCheckPage pHTTP = new HTTPHealthCheckPage();

	public boolean goHTTPHealthCheckPage() throws Exception {
		try {
			// 切换至默认frame
			opr.SwitchToDefault();
			Debug("ADX → 服务器负载均衡 → 服务器健康检查 → HTTP健康检查");
			pTree.lnkAdx().click();

			// 切换farme
			opr.SwitchToMenuFrame();
			sleep(1);

			opr.ClickToOpen(pTree.liServerLb(), pTree.lnkServerLb());
			sleep(1);
			opr.ClickToOpen(pTree.liServerHealthCheck(),
					pTree.lnkServerHealthCheck());
			sleep(1);
			opr.Click(pTree.lnkHTTPHealthCheck());
			sleep(1);
			return true;
		} catch (Exception e) {
			Error("进入HTTP健康检查页面异常\n" + e);
			e.printStackTrace();
			return false;
		}
	}

	public boolean addHTTPHealthCheck(String name, String method, String url,
			String version, String host, int timeout, int interval,
			int trytime, boolean bPass, String normal, String exception,
			boolean bLog, String ip, int port) throws Exception {
		try {
			// 进入HTTP健康检查页面
			goHTTPHealthCheckPage();
			opr.SwitchToFrameFromMenu();

			// 点击添加
			opr.Click(pHTTP.btnAdd());

			// HTTP健康检查
			opr.SendKeys(pHTTP.txtName(), name);
			opr.Select(pHTTP.sltMethod(), method);
			opr.SendKeys(pHTTP.txtURL(), url);
			opr.Select(pHTTP.sltVersion(), version);
			if (host != null)
				opr.SendKeys(pHTTP.txtHost(), host);
			opr.SendKeys(pHTTP.txtTimeout(), timeout + "");
			opr.SendKeys(pHTTP.txtInterval(), interval + "");
			opr.SendKeys(pHTTP.txtTryTime(), trytime + "");
			opr.ClickToState(pHTTP.chkMustPass(), bPass);

			// 自定义检查内容
			if (pHTTP.imgDefinedCheck().getAttribute("src").toString()
					.contains("up"))
				opr.Click(pHTTP.imgDefinedCheck());
			if (normal != null)
				opr.SendKeys(pHTTP.txtNormal(), normal);
			if (exception != null)
				opr.SendKeys(pHTTP.txtException(), exception);
			opr.ClickToState(pHTTP.chkLogStorage(), bLog);

			// 高级配置
			if (pHTTP.imgAdvanced().getAttribute("src").toString()
					.contains("up"))
				opr.Click(pHTTP.imgAdvanced());
			if (ip != null)
				opr.SendKeys(pHTTP.txtIPAddress(), ip);
			if (port != 0)
				opr.SendKeys(pHTTP.txtPort(), port + "");

			// 点击确认
			opr.Click(pTree.btnConfirm());
			
			return true;
		} catch (Exception e) {
			Error("增加HTTP健康检查异常\n" + e);
			e.printStackTrace();
			return false;
		}
	}

}
