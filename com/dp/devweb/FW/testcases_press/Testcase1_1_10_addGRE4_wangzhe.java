package dp.devweb.FW.testcases_press;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dp.devweb.FW.tasks.GRE;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.Config;

/**
* @Title: Testcase1_1_10_addGRE4_wangzhe.java 
* @Description: TODO(反复增加删除满规格GRE4隧道) 
* @author z01674 
* @date 2015年7月13日 下午7:42:57 
* @version V4.4
 */

public class Testcase1_1_10_addGRE4_wangzhe extends CommonObjectScript{
	public GRE gre = new GRE();
	public String intIP = "1.1.1.";
	public String  mask = "32";
	public String sourceIP = "1.2.1.";
	public String destIP = "1.3.1.1";
	public int m =1;
	
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
//    	for(int m =1 ;m<=30 ; m++) {
//    		gre.addGRE4(""+m, intIP + m, mask,sourceIP +m, destIP);
//    	}
    	
    	for(int m =2 ;m<=30 ; m++) {
		gre.delGRE4(m);
	}
    	
   }

}
