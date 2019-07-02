package dp.devweb.DPX.Testcase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dp.devweb.DPX.task.Aut8021x;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.Config;

/**
 * 
* @Title: Testcase1_2_addUser.java 
* @Description: TODO(反复增加802.1x用户配置并删除) 
* @author z01674 
* @date 2015年7月15日 下午4:44:39 
* @version V4.4
 */
public class Testcase1_2_addUser extends CommonObjectScript{
	
	public Aut8021x aut = new Aut8021x();
	public String password = "12345";
	int i=11;
	
	public String name = "109";
	
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
//    	for(int i=100; i<=130;i++) {
//    		aut.addUser(""+i, password, null);
//    	}
    	
    	aut.delUserConf(name);
   }

}
