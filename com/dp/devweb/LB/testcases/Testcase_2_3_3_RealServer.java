package dp.devweb.LB.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dp.devweb.LB.tasks.RealServer;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.Config;

/**   
 * @Title: Testcase_2_3_3_RealServer.java 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author w01866 
 * @date 2015年1月9日 下午5:04:21 
 * @version V4.4   
 */
public class Testcase_2_3_3_RealServer extends CommonObjectScript{

	public RealServer ser = new RealServer();
	
	public String name = "Testcase_2_3_3_RealServer";
	public String ip = "2.2.2.1";
	public String port = "80";
	public String weight = "1";
	public String cConnect = "0";
	public String newConnect = "0";
	public String health = "通过真实服务组配置";
	public String cpu = "10";
	public String memory = "1";
	public String recover = "0";
	public String warm = "0";
	public boolean b = false;
	
	@BeforeClass (description = "启动脚本，启动浏览器")
	public void setUp() throws Exception {
		// 启动脚本
		startScript(getClassName());
		// 启动浏览器
//		driver(Config.browserPath, Config.browserDriverPath, Config.webUrl1);
	}
	
	@Test (description = "增加真实服务")
	public void AddRealService() throws Exception {

		Info("验证真实服务是否存在： " + name);
		if (ser.VerifyRealService(name)) {
			Info("删除已存在的真实服务： " + name);
			ser.DelRealService(name);			
		}
		
		Info("增加 真实服务： " + name);
		ser.AddRealServer(name, ip, port, weight, cConnect, newConnect,
				health, cpu, memory, recover, warm, b);
		
		// 断言
		Info("验证真实服务是否增加成功： " + name);
		Assert.assertEquals(ser.VerifyRealService(name), true);
	}
	
	@Test (description = "清理环境，删除增加的数据")
	public void CleanUp() throws Exception {
		Info("删除真实服务： " + name);
		ser.DelRealService(name);
	}
	
	@AfterClass(enabled = true)
	public void tearDown() throws Exception {
		logout();
		driver.quit();
	}
}
