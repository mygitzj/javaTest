package dp.devweb.FW.testcases_press;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dp.devweb.FW.tasks.ServeiceMethod;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.Config;

/**
 * 
* @Title: Testcase1_3_2_10_ServiceObjectGroupImExport.java 
* @Description: TODO(配置多条服务对象组后反复导入导出) 
* @author z01674 
* @date 2015年6月24日 下午3:49:24 
* @version V4.4
 */
public class Testcase1_3_2_10_ServiceObjectGroupImExport extends CommonObjectScript {
		public ServeiceMethod serMeth = new ServeiceMethod();
		
//		int name =1;
		public String selServiceObject = "预定义服务";
		public String[] selAvailable = {"FTP","SSH"};
		public String path = "D:/Documents/Downloads/netservice_objgroup.csv";
		
		//启动浏览器
		@BeforeClass
		public void SetUp() throws Exception {
			//启动脚本
			startScript(getClassName());
			//启动浏览器
			driver(Config.browserPath,Config.browserDriverPath);
			//打开设备1的页面
			driver1(Config.webUrl2);
		}
		
		@Test(enabled = true ,priority = 0)
		public void DUT() throws Exception {
			
			//配置多条服务对象组
			for(int name =3;name<=30 ;name++) {
				serMeth.AddServiceGroup(""+name, selServiceObject, selAvailable);
			}
		
//			导出服务对象组
			serMeth.fileExportServGrp();
			
			
//			导入服务对象组
			serMeth.fileImprotServGrp();  
		}
		


}
