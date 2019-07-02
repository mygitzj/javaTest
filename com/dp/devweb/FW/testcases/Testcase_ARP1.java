package dp.devweb.FW.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dp.devweb.FW.tasks.ARPConfig;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;
import dp.devweb.common.Config;

/**
* @Title: Testcase_ARP.java 
* @Description: TODO(ARP用于拷机测试) 
* @author z01674 
* @date 2015年5月14日 上午10:40:49 
* @version V4.4
 */

public class Testcase_ARP1 extends CommonObjectScript{
	                            
	public CommonOperator opr = new CommonOperator();
	public ARPConfig ARP = new ARPConfig();
	
	   
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
	    public int i =1;
	    //反复勾选去勾选关闭ARP被动学习配置
	    @Test(enabled = true, priority = 1)
	    public void arp1() throws Exception {
	    	for(i=1;i<=5;i++) {
	    		ARP.undodoDisablePassiveARPLearning();
	    	}
	    	
	    }
	    
	    //退出设备页面
	    @Test(enabled = true, priority = 1)
	    public void logout1() throws Exception{
	    	Info("退出设备页面");
	    	logout();
	    }	
}
