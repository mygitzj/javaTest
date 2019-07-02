package dp.devweb.LB.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dp.devweb.LB.tasks.TCPHealthCheck;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.Config;

/**   
 * @Title: Testcase_2_3_5_1_TCPHealthCheck.java 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author w01866 
 * @date 2015年1月30日 下午5:23:03 
 * @version V4.4   
 */
public class Testcase_2_3_5_1_TCPHealthCheck extends CommonObjectScript{
	public TCPHealthCheck tcp = new TCPHealthCheck();
	
	public String name = "Testcase_2_3_5_1_tcp_";
	public int timeout = 5;
	public int interval = 15;
	public int trytime = 3;
	public boolean bPass = false;
	public String send = null;
	public String receive = null;
	public boolean bTriangle = false;
	public String ip = null;
	public int port = 0;

	
	@BeforeClass
	public void setUp() throws Exception {
		// 启动脚本
		startScript(getClassName());
		// 启动浏览器
//		driver(Config.browserPath, Config.browserDriverPath, Config.webUrl1);
	}	
	
	@Test (priority = 0, alwaysRun = true, invocationCount = 255)
	public void addTCPHealthCheck() throws Exception {
		tcp.addTCPHealthCheck(name, timeout, interval, trytime, bPass, send, receive, bTriangle, ip, port);
	}
	
	@Test (dependsOnMethods = "addTCPHealthCheck", alwaysRun = false)
	public void deleteTCPHealthCheck() throws Exception {				
		
	}
	
	
	@AfterClass
	public void tearDown() throws Exception {
		logout();
		driver.quit();
	}
}
