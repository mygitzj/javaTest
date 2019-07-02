package dp.devweb.DPX.Testcase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dp.devweb.DPX.task.Aut8021x;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.Config;

/**
 * 
* @Title: Testcase1_1_enDisableAuth8021x.java 
* @Description: TODO(反复选择是否启用802.1x认证) 
* @author z01674 
* @date 2015年7月15日 下午2:05:55 
* @version V4.4
 */

public class Testcase1_1_enDisableAuth8021x extends CommonObjectScript{
	
	public Aut8021x  aut802 = new Aut8021x();
	public String str = "启用";
	public String str1 = "禁用";
	
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
    	driver1(Config.webUrlDPX1);
    	for(int i=1; i<=10;i++) {
    		aut802.enDisable8021x(str);
    		sleep(1);
    		aut802.enDisable8021x(str1);
    	}
   }
}
