package dp.devweb.FW.testcases_press;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dp.devweb.FW.tasks.IpAddr;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;
import dp.devweb.common.Config;

/**
 * 
* @Title: Testcase1_3_2_3IpAddrGrop.java 
* @Description: TODO(地址对象组反复导入导出) 
* @author z01674 
* @date 2015年6月13日 下午5:18:42 
* @version V4.4
 */

public class Testcase1_3_2_3IpAddrGropImportExport extends CommonObjectScript{
	public CommonOperator opr = new CommonOperator();
	public IpAddr ipAddr = new IpAddr();
	
	public String[] names = {"qqqq","aaa"};
	public String path = "D:/Documents/Downloads/netaddr_group.csv";
	
//	int i =1;
	
	 @BeforeClass
		public void setUp() throws Exception {
			// 启动脚本
			startScript(getClassName());
			// 启动浏览器
			driver(Config.browserPath, Config.browserDriverPath);
			//打开设备1的页面
			Info("打开测试设备的页面");
	    	driver1(Config.webUrl2);
		}
	 
	 	//配置1000条IP地址对象组，并保存，导出配置
	   @Test(enabled = true, priority = 0) 
	   public void DUT1 () throws Exception {
		   for (int i=1; i<=30 ;i++) {
			   ipAddr.AddAddrObjectGpr("" + i , names);	
			   sleep(1);
		   }
	   
		   //导出地址对象组
		   ipAddr.ExportIpAddrObjectGrp();
		   
//		   导入地址对象组
		   ipAddr.ImportAddrObjectGrp(path);  
		  
	   }
   
		   
	   
		
	    	
	    	
	    	
	    	
	   
}
