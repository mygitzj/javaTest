package dp.devweb.FW.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dp.devweb.FW.tasks.ConfigFile;
import dp.devweb.FW.tasks.IPSecVPN;
import dp.devweb.FW.tasks.IpAddr;
import dp.devweb.FW.tasks.Ipv6Addr;
import dp.devweb.FW.tasks.Nat;
import dp.devweb.FW.tasks.OneToOneNat;
import dp.devweb.FW.tasks.SSLVPNBasicConfig;
import dp.devweb.FW.tasks.SecurityZone;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.Config;



public class test1 extends CommonObjectScript {
	public IpAddr ipAdd = new IpAddr();
	public Nat Nat = new Nat();
	public SecurityZone seczon = new SecurityZone();
	public  OneToOneNat  OTONat = new OneToOneNat();
	 public ConfigFile confFile = new ConfigFile();
	 public SecurityZone sec = new SecurityZone();
	public IpAddr ipAddr = new IpAddr();
	public Ipv6Addr v6Addr = new Ipv6Addr();
	public IPSecVPN ipsVPN = new IPSecVPN();
	 
	 
	public String name1_0 = Config.interf12_1;
	public String nameip = "IPv4-1";
	public String IP = "10.1.1.1";
	public String maskIp = "24";
	public String expIp = "3.3.3.3";
	public String expMask1 = null;
	public String natName = "nat";
	public String state1 = "禁用";
	public String secname2 = "Trust";
	public String name3_0 = Config.ingerf13_3;
	public String name2_0 = Config.interf12_2;
	public String addrObject = "地址对象";
	public String IpObject = "IPv4-1";
	public String ServiceName = "Any";
	public String object = "FTP";
	public String sNAT = "nat";
	public String sNat2 = "nat2";
	public String destname = "dnat";
	public String pubIP = "1.1.1.3";
	public String minIP = "2.1.1.2";
	public String maxIP = "2.1.1.2";
	public String Interf = "gige0_1";
	public String Interf1 = "gige0_2"; 
    public String path = "D:/配置文件/init1";
	public String name = "123";
	
	public String ID = "1";
	public String IPtype = "ipv4";
	public String Ip = "1.1.1.1";
	public String mask = "23";
	public String mode = "点对多点模式";
	public String description = "!@#$%^&*I(OP{";
	public SSLVPNBasicConfig   basicSSL = new SSLVPNBasicConfig ();
	
	public String  str = "是";
	public String str1 = "启用";
	public String str2 = "不启用";
	
	  @BeforeClass
		public void setUp() throws Exception {
			// 启动脚本
			startScript(getClassName());
			// 启动浏览器
			driver(Config.browserPath, Config.browserDriverPath);
		}
	    //打开设备1的页面 并退出
	   @Test(enabled = true, priority = 0) 
	   public void DUT1 () throws Exception {
		
	    	Info("打开测试设备的页面");
	    	driver1(Config.webUrl1);

//	    	增加一对一NAT，
//	    	OTONat.add1To1Nat(sNAT, Interf, pubIP, minIP);

//	    	修改一对一NAT
//	    	OTONat.modify1To1Nat(sNAT, Interf1, expIp, IP);
	    	
//	    删除一对一Nat
//	    	OTONat.delet1To1Nat(sNat2);
//	    	导入配置文件
//	    	ipAddr.ImportIpAddr(Config.filePath1);
//	    	confFile.importFile(path);
//	    	v6Addr.addIpv6AddrObj(name);
	    	/**
	    	 * yangyan
	    	 */	
//	    	ipsVPN.addTunnelInterface(ID, IPtype, Ip, mask, mode, description);
//	    	for(int m =1 ;m<=30 ; m++) {
//	    		ipsVPN.enableIPSecOrNO(str1);
//	    		sleep(2);
//	    		ipsVPN.enableIPSecOrNO(str2);
//	    	}
//	    	for(int ID =1 ;ID<=30 ; ID++) {
//	    	ipsVPN.addSecPro(""+ID, type, timeIKE, timeIPS, DHGroup, IKEAlg, IKEAuthAlg, IKEDHgroup, IPSAlg, IPSAuthAlg);
//	    	}
//	    	
//	    	basicSSL.ClientExit(str);
				
	    	
	   }

}
