package dp.devweb.FW.testcases_press;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dp.devweb.FW.tasks.SslVPN;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.Config;

/**
 * 
* @Title: Testcase1_1_logout_lipeng.java 
* @Description: TODO(反复进入、退出SSLvpn界面) 
* @author z01674 
* @date 2015年7月2日 上午11:04:40 
* @version V4.4
 */

public class Testcase1_1_1_logout_lipeng extends CommonObjectScript{
	public SslVPN ssl = new SslVPN();
	
	
	@BeforeClass
	public void setUp() throws Exception {
		// 启动脚本
		startScript(getClassName()); 
		// 启动浏览器
		driver(Config.browserPath, Config.browserDriverPath);
		//打开设备1的页面
		Info("打开测试设备的页面");                             
	    driver1(Config.webIPSSLVPN);
//		driver.get(arg0);
		}
	@Test(enabled = true, priority = 0) 
	public void DUT() throws Exception {
		
		for(int n = 1 ; n<=100000000; n++) {
			//进入设备
			ssl.login();
			sleep(3);
			//退出设备
			ssl.logoutvpn();
		}
	}
	
		

	
	
}
