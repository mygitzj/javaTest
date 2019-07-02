package dp.devweb.FW.testcases_press;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dp.devweb.FW.tasks.PacketFilter;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.Config;

/**
 * 
* @Title: Testcase_packFilter_liupeng.java 
* @Description: TODO(反复增加1W条包过滤策略) 
* @author z01674 
* @date 2015年6月29日 下午3:00:00 
* @version V4.4
 */

public class Testcase_packFilter_liupeng extends CommonObjectScript{
	public PacketFilter pacFil = new PacketFilter();
	
	public String sZone = "Trust";
	public String dZone = "Untrust";
	public String sName = null;
	public String dName = null;
	public String[] service = null;
	public String[] serviceNames = null;
	public String time = null;
	public String action = null;
	public String state = null;
//	int i= 1;
	
	
	@BeforeClass
	public void setUp() throws Exception {
		// 启动脚本
		startScript(getClassName()); 
		// 启动浏览器
		driver(Config.browserPath, Config.browserDriverPath);
		//打开设备1的页面
		Info("打开测试设备的页面");                             
	    driver1(Config.webUrlDPX);
		}
	
	@Test(enabled = true, priority = 0) 
	public void addDomainName() throws Exception {
		
		pacFil.goFirWall();
		//配置30条包过滤策略
		for(int i=231; i<=10000 ; i++) {
			
			pacFil.addPacketFilterDPX("" + i, sZone, dZone, sName, dName, service, serviceNames, time, action, state);
			sleep(3);
		}
		
		}
		
	
	

}
