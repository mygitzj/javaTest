package dp.devweb.FW.testcases_press;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dp.devweb.FW.tasks.Ipv6Addr;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;
import dp.devweb.common.Config;

/**
 * 
* @Title: Testcase1_3_2_4_Ipv6AddrImportExport.java 
* @Description: TODO(IPv6地址反复导入导出操作) 
* @author z01674 
* @date 2015年6月30日 下午2:43:50 
* @version V4.4
 */
public class Testcase1_3_2_4_Ipv6AddrImportExport extends CommonObjectScript {
	public CommonOperator opr = new CommonOperator();
	public Ipv6Addr ipv6 = new Ipv6Addr();
	
	public String path = "D:/Documents/Downloads/ip6addr_obj.csv";
	                    
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
	public void addIpv6AddrObj() throws Exception {
		
		//配置50条Ipv6地址对象
		for(int name1 = 1 ; name1<=50 ; name1 ++) {
			ipv6.addIpv6AddrObj("" + name1 + "");
		}
		
		//导出配置
		ipv6.exportFile();
		
		//全部删除
		ipv6.deleAll();
		
		for(int i=1 ; i<=1000 ;i++) {
		//导入配置文件
		ipv6.importFile(path);
		//导出配置
		ipv6.exportFile();
		}
		
		
	}

}
