package dp.devweb.FW.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dp.devweb.FW.tasks.Nat;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;
import dp.devweb.common.Config;

/**
 * @Title: Testcase_1_3_3_SourceNat.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author w01866
 * @date 2015年1月20日 下午2:12:20
 * @version V4.4
 */
public class Testcase_1_3_3_SourceNat extends CommonObjectScript {

	public CommonOperator opr = new CommonOperator();
	public Nat nat = new Nat();

	public String name = "Test_1_3_3_nat_";
	public String intf = "gige0_1";


	//启动浏览器
    @BeforeClass
	public void setUp() throws Exception {
		// 启动脚本
		startScript(getClassName());
		// 启动浏览器
		driver(Config.browserPath, Config.browserDriverPath);
	}
	
	//打开设备1的页面
    @Test(enabled = true, priority = 0) 
   public void setUp1() throws Exception {
    	Info("打开设备1的页面");
    	driver1(Config.webUrl1);  	
    }

	@Test(enabled = true, priority = 1)
	public void addSourceNat() throws Exception {
		Info("判断nat是否存在： " + name);
		if (nat.verifySourceNat(name)) {
			Info("删除nat： " + name);
			nat.deleteSourceNat(name);
		}
		Info("增加nat： " + name);
		nat.addSourceNat(name, intf);
		
//		Info("验证nat增加是否成功： " + name);
//		Assert.assertTrue(nat.verifySourceNat(name));
	}

//	@Test(dependsOnMethods = { "addSourceNat" })
//	public void deleteSourceNat() throws Exception {
//		Info("删除nat： " + name);
//		nat.deleteSourceNat(name);
//	}
//
//	@AfterClass
//	public void tearDown() throws Exception {
//		logout();
//		driver.quit();
//	}

}
