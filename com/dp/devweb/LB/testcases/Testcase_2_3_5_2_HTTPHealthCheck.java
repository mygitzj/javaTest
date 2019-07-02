package dp.devweb.LB.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dp.devweb.LB.tasks.HTTPHealthCheck;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.Config;

/**
 * @Title: Testcase_2_3_5_2_HTTPHealthCheck.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author w01866
 * @date 2015年2月3日 上午10:08:28
 * @version V4.4
 */
public class Testcase_2_3_5_2_HTTPHealthCheck extends CommonObjectScript {
	public HTTPHealthCheck http = new HTTPHealthCheck();

	public String name = "Testcase_2_3_5_2_http_";
	public String method = "GET";
	public String url = "GET / HTTP/1.1";
	public String version = "HTTP/1.1";
	public String host = null;
	public int timeout = 5;
	public int interval = 15;
	public int trytime = 3;
	public boolean bPass = false;
	public String normal = null;
	public String exception = null;
	public boolean bLog = false;
	public String ip = null;
	public int port = 0;

	@BeforeClass
	public void setUp() throws Exception {
		// 启动脚本
		startScript(getClassName());
		// 启动浏览器
//		driver(Config.browserPath, Config.browserDriverPath, Config.webUrl1);
	}

	@Test(priority = 0, alwaysRun = true, invocationCount = 255)
	public void addHTTPHealthCheck() throws Exception {
		Assert.assertTrue(http.addHTTPHealthCheck(name, method, url, version,
				host, timeout, interval, trytime, bPass, normal, exception,
				bLog, ip, port));
	}

	@Test(dependsOnMethods = "addHTTPHealthCheck", alwaysRun = false)
	public void deleteHTTPHealthCheck() throws Exception {

	}

	@AfterClass
	public void tearDown() throws Exception {
		logout();
		driver.quit();
	}

}
