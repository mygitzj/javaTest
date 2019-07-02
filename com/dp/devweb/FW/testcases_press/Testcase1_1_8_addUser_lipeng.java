package dp.devweb.FW.testcases_press;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dp.devweb.FW.tasks.UserManage;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.Config;

/**
 * 
* @Title: Testcase1_1_8_addUser_lipeng.java 
* @Description: TODO(反复增加用户信息配置) 
* @author z01674 
* @date 2015年7月10日 下午5:15:36 
* @version V4.4
 */
public class Testcase1_1_8_addUser_lipeng extends CommonObjectScript{
	public UserManage user = new UserManage();
	public String name = "1234";
    public String password = "1234";
    public String[] userGroup = {"VPN用户组"};
    
    
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
    	
    	while (1>0) {
    		for(int name = 1; name<=300; name++) {
    			user.addUser(""+name, password, userGroup);
    		}
    		for(int name =1; name<=3000;name++) {
    			user.delUser(""+name);
    		}
    	}
    	
    	
   }
   
}
