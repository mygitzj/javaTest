package dp.devweb.FW.testcases_press;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dp.devweb.FW.tasks.IPSecVPN;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.Config;

/**
 * 
* @Title: Testcase1_2_enableIPSVPN_yangyang.java 
* @Description: TODO(反复使能去使能IPS VPN) 
* @author z01674 
* @date 2015年7月8日 下午12:00:20 
* @version V4.4
 */
public class Testcase1_1_2_enableIPSVPN_yangyang extends CommonObjectScript {
	public IPSecVPN ipsVPN = new IPSecVPN();
	public String str1 = "启用";
	public String str2 = "不启用";
	
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
    	for(int m =1 ;m<=30 ; m++) {
    		ipsVPN.enableIPSecOrNO(str1);
    		sleep(2);
    		ipsVPN.enableIPSecOrNO(str2);
    	}
    	
   }

}
