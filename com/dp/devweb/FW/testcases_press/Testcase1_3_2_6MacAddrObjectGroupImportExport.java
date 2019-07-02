package dp.devweb.FW.testcases_press;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dp.devweb.FW.tasks.MacAddr;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;
import dp.devweb.common.Config;

/**
 * 
* @Title: Testcase1_3_2_6MacAddrObjectGroupImportExport.java 
* @Description: TODO(mac地址对象组导入导出功能) 
* @author z01674 
* @date 2015年6月17日 下午4:04:52 
* @version V4.4
 */

public class Testcase1_3_2_6MacAddrObjectGroupImportExport extends CommonObjectScript {
	public CommonOperator opr = new CommonOperator();
	public MacAddr macAddr = new MacAddr();
	
	
	public String[] macs = {"1","2"};
	public String path = "";
	int i =1;
	
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
	public void addMacGroup() throws Exception {
		for(int i=1;i<=30;i++) {
		macAddr.addMacGroup("" + i + "", macs);
		}
		
		//文件导出
		macAddr.exportFile();
		
		//文件导入
		macAddr.importFile(path);
	}
		
	

}
