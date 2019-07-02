package dp.devweb.FW.testcases_press;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dp.devweb.FW.tasks.SSLVPNBasicConfig;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.Config;

/**
 * 
* @Title: Testcase1_1_6_enableSSLVPN_sunhanglu.java 
* @Description: TODO(反复使能去使能sslVPN) 
* @author z01674 
* @date 2015年7月9日 下午5:08:49 
* @version V4.4
 */

public class Testcase1_1_6_enableSSLVPN_sunhanglu extends CommonObjectScript {
	
	public SSLVPNBasicConfig basicConf = new SSLVPNBasicConfig();
	
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
    		basicConf.enableSSLVPNService("启用");
    		sleep(1);
    		basicConf.enableSSLVPNService("不启用");
   }
   }
}
