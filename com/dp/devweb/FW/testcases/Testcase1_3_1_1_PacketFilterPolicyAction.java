package dp.devweb.FW.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dp.devweb.FW.tasks.DiagnosisTool;
import dp.devweb.FW.tasks.NetConf;
import dp.devweb.FW.tasks.PacketFilter;
import dp.devweb.FW.tasks.SecurityZone;
import dp.devweb.FW.tasks.StaticRoute;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;
import dp.devweb.common.Config;

/**
 * 
* @Title: Testcase1_3_1_1.java 
* @Description: TODO(包过滤策略动作功能测试) 
* @author z01674 
* @date 2015年4月2日 下午3:19:56 
* @version V4.4
 */

public class Testcase1_3_1_1_PacketFilterPolicyAction extends CommonObjectScript {
	public CommonOperator opr = new CommonOperator();
	public NetConf netc = new NetConf();
	public SecurityZone seczon = new SecurityZone();
	public PacketFilter pacflt = new PacketFilter();
	public DiagnosisTool diaTool = new DiagnosisTool();
	
	public String name1_0 = Config.interf12_1;
	public String name1_1 = Config.interf13_1;
	public String ip1_0 = "1.1.1.2";
	public String ip1_1 = "2.1.1.1";	
	public String mask1_0 = "30";
	public String mask1_1 = "30";
	public String type1 = "静态IP";
	public String type2 = "静态IP";
	public String secname1 = "Untrust";
	public String secname2 = "Trust";
	public String pfname = "pf";
	public String sZone = "Untrust";
	public String dZone = "Trust";
	public String sName = null; 
	public String dName = null;
	public String[] service = null;
	public String[]  serviceNames = null;
	public String time = null;
	public String action = null;
	public String state = null;   
	
	
    
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
    
    //按照测试用例对设备1进行操作
    @Test(enabled = true, priority = 1)
    public void packetFilterPolic() throws Exception {
    	
    	Info("对设备1进行操作，给两个接口配置IP地址");  	
    	Info("接口" + name1_0 + "配置IP地址" + ip1_0);
    	netc.configIntfIpAddr(name1_0, type1, ip1_0, mask1_0);
    	
    	Info("接口" + name1_1 + "配置IP地址" + ip1_1);
    	netc.configIntfIpAddr(name1_1, type2, ip1_1, mask1_1);
    	
    	Info("切换到默认界面");
    	opr.SwitchToDefault();
    	
    	Info("将接口" +name1_0 + "加入到" +secname1 + "安全域中"); 	
    	seczon.modifySecurityZone(secname1, name1_0, true); 
    	
    	Info("接口"+name1_1 +"加入到" + secname2 + "安全域中");
    	seczon.modifySecurityZone(secname2, name1_1, true);
    	
    	Info("切换到默认界面");
    	opr.SwitchToDefault();
    	
    	Info("配置包过滤策略" + pfname);
    	pacflt.addPacketFilter(pfname, sZone, dZone, sName, dName, service, serviceNames, time, action, state);	
    	
    }
    
    
/////////////////////////////////////////对辅测设备2进行操作//////////////////////////////////////////////////
    @Test(enabled = true, priority = 2) 
    public void setUp2() throws Exception {
    	opr.SwitchToDefault();
    	Info("退出设备1的页面");
    	logout();
    	sleep(1);
    	Info("打开设备2的页面");
    	driver1(Config.webUrl2);
    }
    public StaticRoute staRout= new StaticRoute();
    public String name2_0 = Config.interf12_2;
    public String ip2_0 = "1.1.1.1";
    public String mask2_0 = "30";
  
 	public String ip2_s = "0.0.0.0";
 	public String mask = "0";
 	public String intf = Config.interf12_2;
 	public String hopIp = "1.1.1.2";
    
 	
 	@Test(enabled = true, priority = 3)
	  	public void packetFilterPolicy2() throws Exception {
		  
		  Info("给接口gige0_0配置IP地址");
		  netc.configIntfIpAddr(name2_0, type1, ip2_0, mask1_0);
		  
		  Info("切换到默认的界面");
	      opr.SwitchToDefault();
	    	
	      Info("将接口" +name2_0 + "加入到" +secname2 + "安全域中"); 	
	      seczon.modifySecurityZone(secname2, name2_0, true); 
          
          Info("配置静态路由");
          staRout.addStaticRoute(ip2_s, mask, intf, hopIp);	  
		   
	  }
 		
	
///////////////////////////////对设备3进行操作//////////////////////////////////////////////////////
 	@Test(enabled = true, priority = 4)
	  public void setUp3() throws Exception {
 			Info("退出设备2的页面");
 			opr.SwitchToDefault();
 			logout();
 			sleep(1);
	    	Info("打开设备3的页面");
	    	driver1(Config.webUrl3);
	    }
	  
      public String name3_0 = Config.ingerf13_3;
      public String ip3_0 = "2.1.1.2";
      public String mask3_0 = "30";

      public String intf3 = Config.ingerf13_3;
      public String hopIp3 = "2.1.1.1";
    

	@Test(enabled = true, priority = 5)
	  	public void packetFilterPolicy3() throws Exception {
		  
		  Info("给接口" + name3_0  + "配置IP地址" + ip3_0);
		  netc.configIntfIpAddr(name3_0, type1, ip3_0, mask3_0);
		  
		  Info("切换到默认界面");
	      opr.SwitchToDefault();
	    	
	      Info("将接口" +name3_0 + "加入到" +secname2 + "安全域中"); 	
        	seczon.modifySecurityZone(secname2, name3_0, true); 
        	
          Info("配置静态路由");
          staRout.addStaticRoute(ip2_s, mask, intf3, hopIp3);	  
		   
	  }

	  	////////////////////////////对结果进行检查//////////////////////////////////////
	  	//打开设备2的页面
	  	@Test(enabled = true, priority = 6)
		  public void setUp4() throws Exception {
	  			Info("退出设备3的页面");
	  			opr.SwitchToDefault();
	  			logout();
	  			sleep(1);
		    	Info("打开设备2的页面");
		    	driver1(Config.webUrl2);
		    }
     
		//设备2ping设备3，通过
	  	public String ip= "2.1.1.2";
	  	public String number = null;
	  	public String keywords1 = "5 packets received, 0% packet loss";
     
    	@Test(enabled = true, priority = 7)
    	public void diagnosisPass0() throws Exception {
    	 diaTool.goDiagnosisTool();
    	 
    	 Info("对目的IP"+ ip + "进行检测");
    	 diaTool.Diagnosis( number,  ip);
    	 
    	 Info("测试结果");
    	 diaTool.resultDianosis(keywords1); 
    	}
    
    	 //测试用例21步，将包过滤策略pf的动作改为丢包
    	 //打开设备1的页面
  	  	@Test(enabled = true, priority = 8)
  		  public void setUp5() throws Exception {
  	  		Info("退出设备2的页面");
  	  		opr.SwitchToDefault();
  	  		logout();
  	  		sleep(1);
  		    Info("打开设备1的页面");
  		    driver1(Config.webUrl1);
  	  	}  
        
        public  String name1= "pf";
        public  String sZone1 = null;
        public  String dZone1 = null;
        public  String sAddr1= null;
        public  String dAddr1 = null;
        public  String[] service1 = null;
        public  String[] serviceNames1 = null;
        public  String time1 = null;
        public  String state1 = null;
        public  String action1 = "丢包";
        
        //更改设备1的包过滤策略为丢弃
        @Test(enabled = true, priority =9) 
        public void packetLoss() throws Exception {	 
        	Info("转到表格界面");
        	opr.SwitchToFrame();
        	pacflt.modifyPacketFilter(name1, sZone1, dZone1, sAddr1, dAddr1, service1, serviceNames1, time1, action1, state1);

        }
       
        //退出设备1的页面进入设备2的页面
        @Test(enabled = true, priority = 10)
	    public void logout5() throws Exception {
	  		Info("退出设备1的页面");
	    	opr.SwitchToDefault();
	    	logout();
	    	sleep(1);
	    	driver1(Config.webUrl2);
	    }
        
		//设备2ping设备3，不通过

	  	public String keywords2 = "100% packet loss";
     
    	@Test(enabled = true, priority = 11)
    	public void diagnosisTool() throws Exception {
    	 diaTool.goDiagnosisTool();
    	 
    	 Info("对目的IP"+ ip + "进行检测");
    	 diaTool.Diagnosis( number,  ip);
    	 
    	 Info("测试结果");
    	 diaTool.resultDianosis(keywords2); 
    	}
    	  
    	 //退出设备2打开设备1的页面，将FW1中的包过滤策略恢复为直接连通
    	  @Test(enabled = true, priority = 12)
  		  public void setUp6() throws Exception {
    		  	Info("退出设备2的页面");
  	    		opr.SwitchToDefault();
  	    		logout();
  	    		sleep(1);
  		    	Info("打开设备1的页面");
  		    	driver1(Config.webUrl1);
  	  	}  
    	  
    	  public  String action2 = "直接通过";
    	  
    	  @Test(enabled = true, priority = 13)
    	  public void packetpass() throws Exception {	 
          	Info("转到表格界面");
          	opr.SwitchToFrame();
          	pacflt.modifyPacketFilter(name1, sZone1, dZone1, sAddr1, dAddr1, service1, serviceNames1, time1, action2, state1);

          }
    	  
        //退出设备1，打开设备2的页面
    	  @Test(enabled = true, priority = 14)
  	    public void logout7() throws Exception {
  	  		Info("退出设备1的页面");
  	    	opr.SwitchToDefault();
  	    	logout();
  	    	sleep(1);
  	    	Info("打开设备2的页面");
		    driver1(Config.webUrl2);
  	    }
    	
  		//设备2ping设备3，通过     
      	@Test(enabled = true, priority = 15)
      	public void diagnosispass() throws Exception {
      	 diaTool.goDiagnosisTool();
      	 
      	 Info("对目的IP"+ ip + "进行检测");
      	 diaTool.Diagnosis( number,  ip);
      	 
      	 Info("测试结果");
      	 diaTool.resultDianosis(keywords1); 
      	}
      	
      	//删除配置
      	@Test(enabled = true, priority = 16)
      	public void deleteConfig() throws Exception {
      		
      		//删除设备2的配置，删除安全域中的接口及默认路由
      		staRout.deleteStaticRoute(ip2_s);
      		seczon.modifySecurityZone(secname2, name2_0, false); 
      		
      		//删除设备1的配置，删除安全域中的接口及包过滤策略
      		Info("退出设备2的页面");
  	    	opr.SwitchToDefault();
  	    	logout();
  	    	sleep(1);
  	    	Info("打开设备1的页面");
		    driver1(Config.webUrl1);
		    
		  	Info("将接口" +name1_0 + "从" +secname1 + "安全域" + "中删除"); 	
	    	seczon.modifySecurityZone(secname1, name1_0, false); 	
	    	Info("接口"+name1_1 +"从" + secname2 + "安全域中"+ "中删除");
	    	seczon.modifySecurityZone(secname2, name1_1, false);
	    	pacflt.delPacketFilter(pfname);
	    	
	    	//删除设备3的配置，删除安全域中的接口及默认路由
	    	Info("退出设备1的页面");
  	    	opr.SwitchToDefault();
  	    	logout();
  	    	sleep(1);
  	    	Info("打开设备3的页面");
		    driver1(Config.webUrl3);
		    
		    staRout.deleteStaticRoute(ip2_s);
		    seczon.modifySecurityZone(secname2, name3_0, false); 
		    logout();
      		
      	}
      	
      	@AfterClass
      	public void tearDown3() throws Exception {
   		driver.quit();	
   	 }
	  
}