package dp.devweb.FW.testcases_press;


//大量配置时，超过25个，有问题//////////////////////////////////////////////////////////////////////////////////////

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dp.devweb.FW.tasks.DomainName;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.Config;

/**
 * 
* @Title: Testcase1_3_2_8_DomainNameImportExport.java 
* @Description: TODO(域名导入导出测试) 
* @author z01674 
* @date 2015年6月18日 上午10:27:58 
* @version V4.4
 */

public class Testcase1_3_2_8_DomainNameImportExport extends CommonObjectScript {
	public DomainName domName = new DomainName();
	
	
	public String path = "D:/Documents/Downloads/netdns_obj.csv";
	
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
	public void addDomainName() throws Exception {
		
		//配置30条域名
		for(int i=2; i<=30 ; i++) {
			domName.addDomainName(i + "");
		}
	}
//		//文件导出
//		domName.fileExport();
//		
//		//文件导入
//		domName.fileImport(path);
		
	}
}
