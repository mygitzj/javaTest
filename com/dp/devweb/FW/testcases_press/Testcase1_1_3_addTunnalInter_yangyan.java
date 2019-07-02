package dp.devweb.FW.testcases_press;

import org.openqa.selenium.JavascriptExecutor;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dp.devweb.FW.tasks.IPSecVPN;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.Config;

/**
* @Title: Testcase1_1_3_addTunnalInter_yangyan.java 
* @Description: TODO(增加tunnel接口) 
* @author z01674 
* @date 2015年7月9日 下午5:07:07 
* @version V4.4
 */

public class Testcase1_1_3_addTunnalInter_yangyan extends CommonObjectScript{
	
	public IPSecVPN ipsVPN = new IPSecVPN();
	public String ID = "1";
	public String IPtype = "ipv4";
	public String Ip = "1.1.1.1";
	public String mask = "24";
	public String mode = "点对多点模式";
	public String description = null;
	

	@BeforeClass
	public void setUp() throws Exception {
		// 启动脚本
		startScript(getClassName());
		// 启动浏览器
		driver(Config.browserPath, Config.browserDriverPath);
	}
    //打开设备1的页面 并退出
   @Test(enabled = true, priority = 0) 
   public void DUT1 () throws Exception {
    	Info("打开测试设备的页面");
    	driver1(Config.webUrl1);	
    	ipsVPN.addTunnelInterface(ID, IPtype, Ip, mask, mode, description);
   }

}
