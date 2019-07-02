package dp.devweb.LB.tasks;

import dp.devweb.LB.appobject.RealServerPage;
import dp.devweb.LB.appobject.TreeMenuPage;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;

/**   
 * @Title: RealServer.java 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author w01866 
 * @date 2015年1月9日 下午5:05:32 
 * @version V4.4   
 */
public class RealServer extends CommonObjectScript{
	public TreeMenuPage pTree = new TreeMenuPage();
	public RealServerPage pSer = new RealServerPage();
	public CommonOperator opr = new CommonOperator();
	
	public boolean GoRealServer() throws Exception {
		try {
			// 切换至默认frame
			opr.SwitchToDefault();
			Debug("ADX → 服务器负载均衡 → 真实服务");
			pTree.lnkAdx().click();
			
			// 切换farme
			opr.SwitchToMenuFrame();
			sleep(1);
			
			opr.ClickToOpen(pTree.liServerLb(), pTree.lnkServerLb());
			sleep(1);
			pTree.lnkRealServer().click();
			sleep(1);
			return true;
		} catch (Exception e) {
			Error("进入真实服务页面异常");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean AddRealServer(String name, String ip, String port, String weight, String cConnect, String newConnect, String health,
			String cpu, String memory, String recover, String warm, boolean b) throws Exception{
		try {
			// 进入真实服务页面
			GoRealServer();
			
			// 切换frame
			opr.SwitchToFrameFromMenu();
			
			Debug("点击 添加");
			pSer.btnAdd().click();			
			
			// 属性
			Debug("实服务名称： " + name);
			opr.SendKeys(pSer.txtRealServerName(), name);
//			opr.sendKeys(pSer.txtRealServerName(), name);
			
			Debug("IP地址： " + ip);
			opr.SendKeys(pSer.txtIpAddr(), ip);
//			opr.sendKeys(pSer.txtIpAddr(), ip);
			
			Debug("端口： " + port);
			opr.SendKeys(pSer.txtPort(), port);
//			opr.sendKeys(pSer.txtPort(), port);
			if(weight != null){
				Debug("权重： " + weight);
				opr.SendKeys(pSer.txtWeight(), weight);
//				opr.sendKeys(pSer.txtWeight(), weight);
			}
			
			if (cConnect != null){
				Debug("并发连接数限制： " + cConnect);
				opr.SendKeys(pSer.txtConcurrentConnection(), cConnect);
//				opr.sendKeys(pSer.txtConcurrentConnection(), cConnect);
			}
			
			if (newConnect != null){
				Debug("新建连接数限制： " + newConnect);
				opr.SendKeys(pSer.txtNewConnection(), newConnect);
//				opr.sendKeys(pSer.txtNewConnection(), newConnect);
			}
			
			if (health != null){
				Debug("健康检查： " + health);
				opr.Select(pSer.sltHealth(), health);
			}
			
			// 高级设置
			if (pSer.imgAdvancedOption().getAttribute("src").contains("up")){
				pSer.imgAdvancedOption().click();
			}
			
			if (cpu != null){
				Debug("CPU占用率权重： " + cpu);
				opr.SendKeys(pSer.txtCpuWeight(), cpu);
//				opr.sendKeys(pSer.txtCpuWeight(), cpu);
			}
			
			if (memory != null){
				Debug("内存使用率权重： " + memory);
				opr.SendKeys(pSer.txtMemoryWeight(), memory);
//				opr.sendKeys(pSer.txtMemoryWeight(), memory);
			}
			
			if (recover != null){
				Debug("恢复时间： " + recover);
				opr.SendKeys(pSer.txtRecoveryTime(), recover);
//				opr.sendKeys(pSer.txtRecoveryTime(), recover);
			}
			
			if (warm != null){
				Debug("温暖时间： " + warm);
				opr.SendKeys(pSer.txtWarmTime(), warm);
//				opr.sendKeys(pSer.txtWarmTime(), warm);
			}
			
			Debug("统计真实服务时延： " + b);
			opr.ClickToState(pSer.chkStatistics(), b);
			
			Debug("点击 确认");
			pTree.btnConfirm().click();
			
			return true;
		} catch (Exception e) {
			Error("增加真实服务异常");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean VerifyRealService(String name) throws Exception {
		try {
			// 进入真实服务页面
			GoRealServer();
			
			// 切换frame
			opr.SwitchToFrameFromMenu();
			
			Debug("查看真实服务配置中是否包含： " + name);
			for (int i = 0; i < pSer.liRealService().size(); i++){
				if (pSer.liRealService().get(i).getText().equals(name)){
					Debug("真实服务存在： " + name);
					return true;					
				}
			}		
			Debug("真实服务不存在： " + name);
			return false;
		} catch (Exception e) {
			Error("验证真实服务是否存在异常");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean DelRealService(String name) throws Exception {
		try {
			// 进入真实服务页面
			GoRealServer();
			
			// 切换frame
			opr.SwitchToFrameFromMenu();
			
			Debug("删除真实服务： " + name);
			opr.JsClickToState(pSer.chkRealService(name), true);	
			
			Debug("点击 删除");
			pSer.btnDel().click();
			
			Debug("点击 确认");
			pTree.btnConfirm().click();
			
			return true;
		} catch (Exception e) {
			Error("验证真实服务是否存在异常");
			e.printStackTrace();
			return false;
		}
	}
}
