package dp.devweb.FW.testcases_press;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dp.devweb.FW.tasks.IpAddr;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;
import dp.devweb.common.Config;

/**
 * 
* @Title: Testcase1_3_2_2IpAddrImportExport.java 
* @Description: TODO(IP地址-地址对象导入导出功能测试 ) 
* @author z01674 
* @date 2015年6月13日 上午10:04:13 
* @version V4.4
 */
public class Testcase1_3_2_2IpAddrImportExport extends CommonObjectScript{
	public CommonOperator opr = new CommonOperator();
	public IpAddr ipaddr = new IpAddr();
	
	public String path = "D:/配置文件/netaddr_obj.csv";
	
	int i=1;
	
	 @BeforeClass
	 public void setUp() throws Exception {
	   
			// 启动脚本
			startScript(getClassName());
			// 启动浏览器,进入设备1
			driver(Config.browserPath, Config.browserDriverPath);
			driver1(Config.webUrl2);
		}
	 
	 @Test(enabled = true, priority = 0) 
	 public void action() throws Exception {
//		 
//		//配置1000条地址对象
//		 for(int i=1;i<=50;i++) {
//			 ipaddr.AddAddrObjectArea("" + i + "", null, null, null, null);		 	 
//		 }
//		//导出配置
//		 ipaddr.ExportIpAddrObject();
//		 
//		 //全部删除
//		 ipaddr.deltAll();
//		 
//		 while (1 >0) {
			 //导入配置1
			 ipaddr.ImportIpAddrObj(path);
			 
//			//导出配置
//			 ipaddr.ExportIpAddrObject(); 
//		 
//			 //全部删除
//			 ipaddr.deltAll(); 
//	 }
	 }
}
