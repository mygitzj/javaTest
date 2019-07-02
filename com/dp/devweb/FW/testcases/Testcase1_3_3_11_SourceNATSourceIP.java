package dp.devweb.FW.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dp.devweb.FW.tasks.DiagnosisTool;
import dp.devweb.FW.tasks.IpAddr;
import dp.devweb.FW.tasks.Nat;
import dp.devweb.FW.tasks.NetConf;
import dp.devweb.FW.tasks.PacketFilter;
import dp.devweb.FW.tasks.SecurityZone;
import dp.devweb.FW.tasks.StaticRoute;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;
import dp.devweb.common.Config;

/**
 * 
* @Title: Testcase1_3_1_11_SourceNATSourceIP.java 
* @Description: TODO(源NAT发起方源IP功能测试) 
* @author z01674 
* @date 2015年5月11日 上午11:44:26 
* @version V4.4
 */

public class Testcase1_3_3_11_SourceNATSourceIP extends CommonObjectScript{
	public CommonOperator opr = new CommonOperator();
	public NetConf netc = new NetConf();
	public SecurityZone seczon = new SecurityZone();
	public Nat Nat = new Nat();
	public StaticRoute SRoute = new StaticRoute();
	public PacketFilter pacflt = new PacketFilter();
	public DiagnosisTool diaTool = new DiagnosisTool();
	public IpAddr ipAdd = new IpAddr();
	
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
	public String pfname1 = "pf-1";
	public String pfname2 = "pf-2";
	public String pfname3 = "pf-3";	
	public String sNAT = "nat"; 
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
	
	public String nameip = "IPv4-1";
	public String IP = "10.1.1.1";
	public String maskIp = "24";
	public String expIp = null;
	public String expMask = null;
	
	
	//启动浏览器
    @BeforeClass
	public void setUp() throws Exception {
		// 启动脚本
		startScript(getClassName());
		// 启动浏览器
		driver(Config.browserPath, Config.browserDriverPath);
	}
    
    //打开设备1的页面按照测试用例对设备1进行操作
    @Test(enabled = true, priority = 0)
    public void ConfDUT1() throws Exception {
    	Info("打开设备1的页面");
    	driver1(Config.webUrl1);
    	//接口配置IP地址
    	Info("对设备1进行操作，给两个接口配置IP地址");  	
    	Info("接口" + name1_0 + "配置IP地址" + ip1_0);
    	netc.configIntfIpAddr(name1_0, type1, ip1_0, mask1_0);
    	
    	Info("接口" + name1_1 + "配置IP地址" + ip1_1);
    	netc.configIntfIpAddr(name1_1, type2, ip1_1, mask1_1);
    		
    	//将接口加入到对应的安全域中                  
    	Info("将接口" +name1_0 + "加入到" +secname1 + "安全域中"); 	
    	seczon.modifySecurityZone(secname1, name1_0, true); 
    	sleep(1);
    	
    	Info("接口"+name1_1 +"加入到" + secname2 + "安全域中");
    	seczon.modifySecurityZone(secname2, name1_1, true);
    	
    	Info("配置包过滤策略" + pfname);
    	pacflt.addPacketFilter(pfname, sZone, dZone, sName, dName, service, serviceNames, time, action, state);	
    	
    	//进入防火墙配置源NAT
    	Info("配置源nat" + sNAT);
    	Nat.addSourceNat(sNAT, name1_1);
    	
    	Info("增加IPv4地址");
    	ipAdd.AddAddrObject(nameip, IP, maskIp, expIp, expMask);
    	
    }
        
/////////////////////////////////////////对辅测设备2进行操作//////////////////////////////////////////////////
    @Test(enabled = true, priority = 1) 
    public void setUp2() throws Exception {
    	opr.SwitchToDefault();
    	Info("退出设备1的页面");
    	logout();
    	sleep(1);
    	Info("打开设备2的页面");
    	driver1(Config.webUrl2);
    	
    	Info("对设备2 的接口配置IP地址并加入Trust安全域");
    	netc.configIntfIpAddr(name2_0, type1, ip2_0, mask1_0);
    	sleep(1);
    
    	//将接口加入到对应的安全域中
    	Info("将接口" +name2_0 + "加入到" +secname2 + "安全域中"); 	
    	seczon.modifySecurityZone(secname2, name2_0, true); 
    	sleep(1);
    	
    	//配置默认路由
    	SRoute.addStaticRoute(sroute, smask, name2_0, snesthop);
    	  	
    }   
    
    //////////////////////////////////////////////对设备3进行操作///////////////////////////////////////////////  	
    @Test(enabled = true, priority = 2)
    public void logoug2 () throws Exception {
    	//切换到默认页面
    	opr.SwitchToDefault();
    	Info("退出设备2的页面");
    	logout();
    	sleep(1);
    	driver1(Config.webUrl3);
    }
    
    //给设备3的接口配置Ip地址并将接口加入到trust安全域中
    @Test(enabled = true, priority = 3)
    public void setUp3() throws Exception {
    	netc.configIntfIpAddr(name3_0, type1, ip3_0, mask1_0);
    	
    	//将接口加入到对应的安全域中
    	Info("将接口" +name3_0 + "加入到" +secname2 + "安全域中"); 	
    	seczon.modifySecurityZone(secname2, name3_0, true);
    }
   
/////////////////////////////////对结果进行诊断///////////////////////////////////////////////////////////
//	退出设备3，设备2ping设备3，通过
  	public String ip= "2.1.1.2";
  	public String number = null;
  	public String keywords1 = "5 packets received, 0% packet loss";
 
	@Test(enabled = true, priority = 4)
	public void diagnosisPass0() throws Exception {
		//切换到默认页面
    	opr.SwitchToDefault();
    	Info("退出设备3的页面");
    	logout();
    	sleep(1);
    	driver1(Config.webUrl2);
    	
    	diaTool.goDiagnosisTool(); 
    	Info("对目的IP"+ ip + "进行检测");
    	diaTool.Diagnosis( number,  ip);
	 
    	Info("测试结果");
    	diaTool.resultDianosis(keywords1); 
	}


//	退出设备2的页面进入设备1
	@Test(enabled = true, priority = 5)
    public void logoug4 () throws Exception {
    	//切换到默认页面
    	opr.SwitchToDefault();
    	Info("退出设备2的页面");
    	logout();
    	sleep(1);
    	driver1(Config.webUrl1);
    }
	
	//更改FW1中的源NAT策略发起方源IP为IPv4-1
	public String natName = "nat";
	public String addrObject = "地址对象";
	public String IpObject = "IPv4-1";
	@Test(enabled = true, priority = 6)
	 public void modifyFW1 () throws Exception {
		 Nat.modifySourceNatSourceIP(natName, addrObject, IpObject);
	 }
    
	//退出设备1进入设备2
	@Test(enabled = true, priority = 7)
    public void logoug5() throws Exception {
    	//切换到默认页面
    	opr.SwitchToDefault();
    	Info("退出设备1的页面");
    	logout();
    	sleep(1);
    	driver1(Config.webUrl2);
    }
	
	//设备2ping设备3，ping不通 ，诊断结果为100% packet loss
	public String keywords2 = "0 packets received, 100% packet loss";
	
	@Test(enabled = true, priority = 8)
	public void diagnosisPass1() throws Exception {
		 diaTool.goDiagnosisTool(); 
		 Info("对目的IP"+ ip + "进行检测");
		 diaTool.Diagnosis( number,  ip);
		 
		 Info("测试结果");
		 diaTool.resultDianosis(keywords2); 
		}
	
	//退出设备2进入设备1
	@Test(enabled = true, priority = 9)
    public void logoug6 () throws Exception {
    	//切换到默认页面
    	opr.SwitchToDefault();
    	Info("退出设备2的页面");
    	logout();
    	sleep(1);
    	driver1(Config.webUrl1);
    }
	
	//更改FW1中的源NAT发起方源Ip恢复为any
	@Test(enabled = true, priority = 10)
	 public void modifyFW12 () throws Exception {
		 Nat.trueAny(natName);
		 
		 //退出设备1进入设备2，
		 opr.SwitchToDefault();
	     Info("退出设备1的页面");
	     logout();
	     sleep(1);
	     driver1(Config.webUrl2);
	     
	     //设备2可以ping通设备3
		 diaTool.goDiagnosisTool(); 
		 Info("对目的IP"+ ip + "进行检测");
		 diaTool.Diagnosis( number,  ip);		 
		 Info("测试结果");
		 diaTool.resultDianosis(keywords1); 
	 }
	
	//删除配置
		@Test(enabled = true, priority = 11)
	  	public void deleteConfig() throws Exception {
	  		
	  		//删除设备2的配置，删除安全域中的接口及默认路由
			SRoute.deleteStaticRoute(sroute);
			Info("接口" + name2_0 + "从安全域" + secname2 + "中删除");
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
	    	Nat.deleteSourceNat(sNAT);
	    	ipAdd.DeleteAddrObject(nameip);
	    	
	    	//删除设备3的配置，删除安全域中的接口及默认路由
	    	Info("退出设备1的页面");
		    opr.SwitchToDefault();
		    logout();
		    sleep(1);
		    Info("打开设备3的页面");
		    driver1(Config.webUrl3);
		    
//		    staRout.deleteStaticRoute(ip2_s);
		    seczon.modifySecurityZone(secname2, name3_0, false);
		    opr.SwitchToDefault();
		    logout();
	  		
	  	}
	  	
	  	@AfterClass
	  	public void tearDown3() throws Exception {
			driver.quit();	
		 }
	  	
	  	
     
	

}
