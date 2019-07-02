package dp.devweb.LB.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dp.devweb.LB.tasks.BasicLink;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.Config;

/**
 * @Title: Testcase_2_4_1_BasicLink.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author w01866
 * @date 2015年2月3日 下午4:47:28
 * @version V4.4
 */
public class Testcase_2_4_1_BasicLink extends CommonObjectScript {

	public BasicLink basic = new BasicLink();

	public String name = "basiclink";
	public String[] gateway = { "100.1.1.1", "101.1.1.1", "102.1.1.1",
			"103.1.1.1", "104.1.1.1", "105.1.1.1", "106.1.1.1", "107.1.1.1",
			"108.1.1.1", "109.1.1.1" };
	public int bandwidth = 2000; // 0 - 10000
	public int threshold = 90; // 0 - 100
	public int weight = 10; // 1 - 255
	public int priority = 10; // 6 - 12

	public int lost = 90; // 0 - 100
	public int latency = 2000;
	public int passLeast = 0;
	public String[] sourceIP = { "1.1.1.1", null };
	public String[] dns = { "1.1.1.1", null };
	boolean bRoute = true;

	@BeforeClass
	public void setUp() throws Exception {
		// 启动脚本
		startScript(getClassName());
		// 启动浏览器
//		driver(Config.browserPath, Config.browserDriverPath, Config.webUrl1);
	}

	@Test(priority = 0, enabled = true, invocationCount = 1000)
	public void addBasicLink() throws Exception {
		Info("增加");
		int randomAdd = basic.getRandom2ToN(7);
		basic.addBasicLink(name, randomAdd, gateway[randomAdd], bandwidth,
				threshold, weight, priority, basic.getRandom(4), lost, latency,
				passLeast, sourceIP[0], dns[0], bRoute);
		for (int i = 0; i < 50; i++) {
			Info("修改【【【" + i + "】】】");
			int random = basic.getRandom2ToN(7);
			basic.modifyBasicLink(name, random, gateway[random], bandwidth,
					threshold, weight, priority, basic.getRandom(4), lost,
					latency, passLeast, sourceIP[0], dns[0], bRoute);
		}

		Info("删除");
		basic.deleteBasicLink();
	}

	@Test(priority = 1, enabled = false)
	public void modifyBasicLink() throws Exception {

	}

	@Test(priority = 2, enabled = false)
	public void deleteBasicLink() throws Exception {

	}

	@AfterClass
	public void tearDown() throws Exception {
		logout();
		driver.quit();
	}

}
