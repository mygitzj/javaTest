package dp.devweb.FW.testcases_press;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dp.devweb.FW.tasks.SSLVPNBasicConfig;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.Config;

/**
 * 
* @Title: Testcase1_1_4_addIPAddrPol_lipeng.java 
* @Description: TODO(反复增加ＩＰ地址池——李鹏) 
* @author z01674 
* @date 2015年7月9日 下午5:06:19 
* @version V4.4
 */

public class Testcase1_1_4_addIPAddrPol_lipeng extends CommonObjectScript{
	public SSLVPNBasicConfig  basicConf = new SSLVPNBasicConfig();
	
	int n = 1;
	public String description = null;
	public String startIP = "1.1.1.1";
	public String endIP = "1.1.1.1";
	public String mask = "24";
	
	
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
    	driver1(Config.webUrlDPX);
    	while (n >0) {
    	for (int i=1;i<=127;i++) {
    		basicConf.addIPAddrPol(""+i, description, startIP, endIP, mask);
    	}
    	for(int m=1; m<=127; m++) {
    		basicConf.deleIPAddrpol(""+m);
    	}
    	}
    	
   }

}
