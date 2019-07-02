package dp.devweb.FW.testcases_press;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dp.devweb.FW.tasks.IPSecVPN;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.Config;

/**
* @Title: Textcase1_1_9_addProtectSubnet_yangyan.java 
* @Description: TODO(反复增加网关IPv4网段组) 
* @author z01674 
* @date 2015年7月11日 上午11:35:45 
* @version V4.4
 */
public class Textcase1_1_9_addProtectSubnet_yangyan extends CommonObjectScript {
	
	public IPSecVPN ipsVPN = new IPSecVPN();
	public String name = "1233";
	int i = 1;
	public String localIP = "192.168.20.";
	public String localMask = "32";
	public String remoteIP ="192.168.40.0";
	public String remoteMask = "32";
	
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
  
//    	ipsVPN.addSubnetGroupList(2,name);
    	
    	for(int i=1;i<=10;i++) {
    		ipsVPN.addProtectSubnetList(2,name,localIP + i, localMask, remoteIP, remoteMask);
    	}
   }

}
