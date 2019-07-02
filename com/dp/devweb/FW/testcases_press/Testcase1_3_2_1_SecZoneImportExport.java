package dp.devweb.FW.testcases_press;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dp.devweb.FW.tasks.DiagnosisTool;
import dp.devweb.FW.tasks.NetConf;
import dp.devweb.FW.tasks.SecurityZone;
import dp.devweb.FW.tasks.StaticRoute;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;
import dp.devweb.common.Config;

/**
 * 
* @Title: Testcase1_3_2_1_SecZoneImportExport.java 
* @Description: TODO(压力测试：反复导入导出安全域配置) 
* @author z01674 
* @date 2015年6月11日 上午11:18:21 
* @version V4.4
 */

public class Testcase1_3_2_1_SecZoneImportExport extends CommonObjectScript {
	
	public SecurityZone secZon = new SecurityZone();
	public CommonOperator opr = new CommonOperator();
	public NetConf netc = new NetConf();
	public SecurityZone seczon = new SecurityZone();
	public DiagnosisTool diaTool = new DiagnosisTool();
   
   
   
	public String name1_0 = Config.interf12_1;
	public String name1_1 = Config.interf13_1;
	public String name2_0 = Config.interf12_2;
	public String name3_0 = Config.ingerf13_3;
	public String ip1_0 = "1.1.1.2";
	public String ip1_1 = "2.1.1.1";
	public String ip2_0 = "1.1.1.1";
	public String ip3_0 = "2.1.1.2";
	public String sroute = "0.0.0.0";
	public String smask = "0";
	public String snesthop = "1.1.1.2";
	public String mask1_0 = "30";
	public String mask1_1 = "30";
	public String type1 = "静态IP";
	public String type2 = "静态IP";
	public String secname1 = "Untrust";
	public String secname2 = "Trust";
   
   
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
   	
	   ////接口配置IP地址
	   Info("对设备1进行操作，给两个接口配置IP地址");  	
	   Info("接口" + name1_0 + "配置IP地址" + ip1_0);
	   netc.configIntfIpAddr(name1_0, type1, ip1_0, mask1_0);
	
	   Info("接口" + name1_1 + "配置IP地址" + ip1_1);
	   netc.configIntfIpAddr(name1_1, type2, ip1_1, mask1_1);
		
	   //将接口加入到对应的安全域中                  
	   Info("将接口" +name1_0 + "加入到" +secname2 + "安全域中"); 	
	   seczon.modifySecurityZone(secname2, name1_0, true); 
	   sleep(1);
	
	   Info("接口"+name1_1 +"加入到" + secname1 + "安全域中");
	   seczon.modifySecurityZone(secname1, name1_1, true);
	   
	   //进入安全域导出安全域配置
	   seczon.exportFile();
	   sleep(1);
	   
	   //将两个接口去加入安全域中
	   seczon.modifySecurityZone(secname2, name1_0, false); 
	   seczon.modifySecurityZone(secname1, name1_1, false);
	   
	   //退出设备1的页面
	   opr.SwitchToDefault();
	   Info("退出设备1的页面");
	   logout();
   }
   
   
   	public StaticRoute staRout= new StaticRoute();
    public String mask2_0 = "30";
 	public String ip2_s = "0.0.0.0";
 	public String mask = "0";
 	public String intf = Config.interf12_2;
 	public String hopIp = "1.1.1.2";
   
   @Test(enabled = true , priority = 1)
   public void setUp2() throws Exception {
	   
	   //进入设备2的页面  
	   Info("进入设备2的页面");
	   driver1(Config.webUrl2);
	   
	   //接口配置IP地址
	   Info("给接口gige0_0配置IP地址");
	   netc.configIntfIpAddr(name2_0, type1, ip2_0, mask1_0);
		  
	   Info("切换到默认的界面");
	   opr.SwitchToDefault();
	    	
	   Info("将接口" +name2_0 + "加入到" +secname2 + "安全域中"); 	
	   seczon.modifySecurityZone(secname2, name2_0, true); 
       
       Info("配置静态路由");
       staRout.addStaticRoute(ip2_s, mask, intf, hopIp);	  
	   
       //退出设备2
       opr.SwitchToDefault();
	   logout();
       
   }
   
   
   	public String mask3_0 = "30";
   	public String intf3 = Config.ingerf13_3;
   	public String hopIp3 = "2.1.1.1";
   
   @Test(enabled = true , priority = 2)
   public void setUp3() throws Exception {
	   
	   //进入设备3
	   Info("打开设备1的页面");
	   driver1(Config.webUrl3);
	   Info("给接口" + name3_0  + "配置IP地址" + ip3_0);
	   netc.configIntfIpAddr(name3_0, type1, ip3_0, mask3_0);
	    	
	   Info("将接口" +name3_0 + "加入到" +secname2 + "安全域中"); 	
	   seczon.modifySecurityZone(secname2, name3_0, true); 
     	
       Info("配置静态路由");
       staRout.addStaticRoute(ip2_s, mask, intf3, hopIp3);
	   
       
   }
   
   //反复导入导出安全域并验证结果的正确行
   public String ip= "2.1.1.2";
   public String number = null;
   public String keywords1 = "5 packets received, 0% packet loss";
   public String keywords2 = "100% packet loss";
   
   @Test(enabled = true ,priority = 3)
   public void result() throws Exception {
	   
	   //DUT1导入安全域配置，设备2能ping通设备1
	   //退出设备3进入设备1
	   opr.SwitchToDefault();
	   Info("退出设备3的页面");
	   logout();
	   Info("打开设备1的页面");
	   driver1(Config.webUrl1);
	   
	   seczon.ImportSecurityZone(Config.filePath );
	
	   opr.SwitchToDefault();
	   Info("退出设备3的页面");
	   logout();
	   sleep(1);
	   Info("打开设备1的页面");
	   driver1(Config.webUrl2);
	   
	   diaTool.goDiagnosisTool(); 
	   Info("对目的IP"+ ip + "进行检测");
	   diaTool.Diagnosis( number,  ip);
	 
	   Info("测试结果");
	   diaTool.resultDianosis(keywords1); 
	   
	   //进入设备1去安全域配置
	   opr.SwitchToDefault();
	   Info("退出设备2的页面");
	   logout();
	   Info("打开设备1的页面");
	   driver1(Config.webUrl1);
	   
	   //导出配置
	   seczon.exportFile();
	   
	   //去配置
	   seczon.modifySecurityZone(secname2, name1_0, false); 
	   seczon.modifySecurityZone(secname1, name1_1, false);
	   
	   //设备2ping设备3，不能ping通
	   opr.SwitchToDefault();
	   Info("退出设备2的页面");
	   logout();
	   Info("打开设备1的页面");
	   driver1(Config.webUrl2);
	   
	   Info("测试结果");
	   diaTool.resultDianosis(keywords2); 
	   
	   //设备1导入错误配置的安全域，设备2不能ping通设备3
	   opr.SwitchToDefault();
	   Info("退出设备2的页面");
	   logout();
	   Info("打开设备1的页面");
	   driver1(Config.webUrl1);
	   
	   //导入错误配置
	   seczon.ImportSecurityZone(Config.filePath1);
	   
	   //设备2不能ping通设备3
	   opr.SwitchToDefault();
	   Info("退出设备2的页面");
	   logout();
	   Info("打开设备1的页面");
	   driver1(Config.webUrl2);
	   
	   diaTool.resultDianosis(keywords2);
	   
   }
   
   @AfterClass
 	public void tearDown3() throws Exception {
	   	opr.SwitchToDefault();
	   	logout();
		driver.quit();	
	 }
   
   
   
   
   
}
