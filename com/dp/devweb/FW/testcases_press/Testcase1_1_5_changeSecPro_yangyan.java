package dp.devweb.FW.testcases_press;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dp.devweb.FW.tasks.IPSecVPN;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.Config;
/**
 * 
* @Title: Testcase1_1_5_changeSecPro.java 
* @Description: TODO(鉴定测试，更换选择安全协议) 
* @author z01674 
* @date 2015年7月9日 下午5:05:33 
* @version V4.4
 */

public class Testcase1_1_5_changeSecPro_yangyan extends CommonObjectScript{
		
	public IPSecVPN ipsVPN = new IPSecVPN();
	public String name = "123";
	public String secPro1 = "1";
	public String secPro2 = "2";
	public String mode = "野蛮模式";
	public String action1 = "忽略";
	public String action2 = "丢弃";
	
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
    	
    	for (int i = 1; i<=5; i++) {
    		ipsVPN.changeSecProPolicyMode(name, mode,secPro1,action1);
    		sleep(2);
    		ipsVPN.changeSecProPolicyMode(name,mode, secPro1,action2);
    	}
   }

}
