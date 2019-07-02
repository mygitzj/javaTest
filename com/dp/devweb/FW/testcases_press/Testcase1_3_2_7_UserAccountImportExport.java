package dp.devweb.FW.testcases_press;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dp.devweb.FW.tasks.UserAccount;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.Config;

/**
 * 
* @Title: Testcase1_3_2_7_UserAccount.java 
* @Description: TODO(用户账号反复导入导出) 
* @author z01674 
* @date 2015年6月18日 下午2:43:00 
* @version V4.4
 */

public class Testcase1_3_2_7_UserAccountImportExport extends CommonObjectScript{
	public UserAccount uAccount = new UserAccount();
	int accountname = 1;
	int name = 1;

	public String realname = "123";
	public String ip ="1.1.1.1";
	
	@BeforeClass
	public void setUp() throws Exception {
		// 启动脚本
		startScript(getClassName()); 
		// 启动浏览器
		driver(Config.browserPath, Config.browserDriverPath);
		//打开设备1的页面
		Info("打开测试设备的页面");                             
	    driver1(Config.webUrl1);
		}
	
	@Test(enabled = true, priority = 0) 
	public void DUT() throws Exception {
		
		//配置30条账号对象
		for(int i=26; i<=30;i++)
		uAccount.addUserAccound( "" +i , ""+i, realname, ip);
	
	}
	

}
