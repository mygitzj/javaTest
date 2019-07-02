package dp.devweb.FW.testcases_press;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dp.devweb.FW.tasks.MacAddr;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;
import dp.devweb.common.Config;

/**
 * 
* @Title: Testcase1_3_2_5_MacAddrObjImportExport.java 
* @Description: TODO(mac地址对象导入导出测试) 
* @author z01674 
* @date 2015年6月16日 下午2:07:58 
* @version V4.4
 */

public class Testcase1_3_2_5_MacAddrObjImportExport extends CommonObjectScript{
	public CommonOperator opr = new CommonOperator();
	public MacAddr macAddr = new MacAddr();
	
	int i=1;
	public String[] macs={"00:11:11:11:11:77", "11:22:22:22:22:88","11:22:22:22:22:99"};
	public String path = "D:/Documents/Downloads/netmac_obj.csv";
	
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
	public void addMac() throws Exception {
		for(int i=1;i<=30;i++) {
		macAddr.addMacAddrObj(""+ i +"", macs);
		}
		
		for (int m=1; m<=20;m++) {
		//文件导出
		macAddr.exportFile();
		
		//全部删除
		macAddr.deleAllMac();
		
		//导入文件
		macAddr.importFile(path);
		}
		
		
	}
}
