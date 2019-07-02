package dp.devweb.FW.testcases_press;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dp.devweb.FW.tasks.ServeiceMethod;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;
import dp.devweb.common.Config;

/**
 * 
* @Title: Testcase1_3_2_9_Service_UserDefinedImExport.java 
* @Description: TODO(自定义服务对象导入导出操作) 
* @author z01674 
* @date 2015年6月24日 上午10:39:37 
* @version V4.4
 */

public class Testcase1_3_2_9_Service_UserDefinedImExport extends CommonObjectScript{
	public CommonOperator opr = new CommonOperator();
	public ServeiceMethod serMethod = new ServeiceMethod();
	
	public String path = "D:/Documents/Downloads/netservice_usrobj.csv";
	public String protocol = "tcp";
	int sPorts = 15;
	int sPortd = 20;
	int dPorts = 25;
	int dPortd = 30;
	
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
	
	
	@Test(enabled= true,priority= 0)
	public void DUT1() throws Exception {
		
		//配置30条自定义服务对象
//		for(int name = 1; name<=30; name++) {
//			serMethod.AddUserdefindService(""+ name, protocol, sPorts, sPortd, dPorts, dPortd);
//		}
		
		//导出文件
//		serMethod.fileExport();
		
		//导入文件
		serMethod.fileImprot();
		
	
	}
	
		
	

}
