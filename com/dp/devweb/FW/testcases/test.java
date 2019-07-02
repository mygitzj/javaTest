package dp.devweb.FW.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dp.devweb.FW.tasks.DiagnosisTool;
import dp.devweb.FW.tasks.IpAddr;
import dp.devweb.FW.tasks.Nat;
import dp.devweb.FW.tasks.Nat64;
import dp.devweb.FW.tasks.NetConf;
import dp.devweb.FW.tasks.OneToOneNat;
import dp.devweb.FW.tasks.PacketFilter;
import dp.devweb.FW.tasks.SSLVPNBasicConfig;
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

public class test extends CommonObjectScript {
	public CommonOperator opr = new CommonOperator();
	  public StaticRoute staRout= new StaticRoute();
	  public OneToOneNat To1Nat = new OneToOneNat();
	  
	public Nat nat = new Nat();
	public NetConf netc = new NetConf();
	public SecurityZone seczon = new SecurityZone();
	public PacketFilter pacflt = new PacketFilter();
	public DiagnosisTool diaTool = new DiagnosisTool();
	public IpAddr ipAdd = new IpAddr();
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
	public String[] serviceNames = null;
	public String time = null;
	public String action = null;
	public String state = null;  
	public String sNAT = "nat";
	public String nameip = "IPv4-1";
	    public String name2_0 = Config.interf12_2;
	    public String ip2_0 = "1.1.1.1";
	    public String mask2_0 = "30";
	  
	 	public String ip2_s = "0.0.0.0";
	 	public String mask = "0";
	 	public String intf = Config.interf12_2;
	 	public String hopIp = "1.1.1.2";
		  
	      public String name3_0 = Config.ingerf13_3;
	      public String ip3_0 = "2.1.1.2";
	      public String mask3_0 = "30";

	      public String intf3 = Config.ingerf13_3;
	      public String hopIp3 = "2.1.1.1";
	      public String destname = "dnat";
	      public String Interf = "gige0_1";
	      public Nat64 nat64 = new Nat64();
	      public String IPv6 = "3:1::2";
	      public String maskIpv6 = "48";
	      
	      public SSLVPNBasicConfig sVPNBasConf = new SSLVPNBasicConfig();
	      public String str = "否";
	      
  //启动浏览器
    @BeforeClass
	public void setUp() throws Exception {
		// 启动脚本
		startScript(getClassName());
		// 启动浏览器
		driver(Config.browserPath, Config.browserDriverPath);
	}
    //打开设备1的页面 并退出
    public int a =1;
    public String nameNat = "1to1nat";
    public String netInterface1 = "gige0_1";
   @Test(enabled = true, priority = 0) 
   public void setUp1() throws Exception {

		Info("打开测试设备的页面");
    	driver1(Config.webUrl1);
//    	nat64.addPrefix(IPv6, maskIpv6);
    	
    	//增加Ipv6前缀配置
//    	To1Nat.modify1To1Nat(nameNat, netInterface1, null, null);
    	
    	//验证sslVPN高级配置
    	sVPNBasConf.ReuseAccount(str);
   } 
   
   

}
//    	driver1(Config.webUrl3);
//       
//   }
   
   
//    	//删除设备2的配置，删除安全域中的接口及默认路由
//		staRout.deleteStaticRoute(ip2_s);
//		seczon.modifySecurityZone(secname2, name2_0, false); 
//		
//		//删除设备1的配置，删除安全域中的接口及包过滤策略
//		Info("退出设备2的页面");
//    	opr.SwitchToDefault();
//    	logout();
//    	sleep(1);
//    	Info("打开设备1的页面");
//    	driver1(Config.webUrl1);
//	    
//    	Info("将接口" +name1_0 + "从" +secname1 + "安全域" + "中删除"); 	
//    	seczon.modifySecurityZone(secname1, name1_0, false); 	
//    	Info("接口"+name1_1 +"从" + secname2 + "安全域中"+ "中删除");
//    	seczon.modifySecurityZone(secname2, name1_1, false);
//    	pacflt.delPacketFilter(pfname);
//    	
////    	nat.deleteSourceNat(sNAT);
////    	ipAdd.DeleteAddrObject(nameip);
//    	nat.deleteDestNat(destname);
//    	
//    	//删除设备3的配置，删除安全域中的接口及默认路由
//    	Info("退出设备1的页面");
//    	opr.SwitchToDefault();
//    	logout();
//    	sleep(1);
//    	Info("打开设备3的页面");
//    	driver1(Config.webUrl3);
//	    
//    	staRout.deleteStaticRoute(ip2_s);
//    	seczon.modifySecurityZone(secname2, name3_0, false); 
//    	logout();
//   }
//		
   
   

    
    
    
    
    
    
    
    
    
 


