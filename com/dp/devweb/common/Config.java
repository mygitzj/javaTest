package dp.devweb.common;


/**
 * @Title: Config.java
 * @Description: 运行环境配置
 * @author w01866
 * @date 2014年12月3日 上午11:54:11
 * @version V4.4
 */
public class Config {

	// chrome
	public static String browser = "webdriver.chrome.bin";
	public static String browserDriver = "webdriver.chrome.driver";
	public static String browserPath = "C:/Program Files (x86)/Google/Chrome/Application/chrome.exe";
	public static String browserDriverPath = "./chromedriver.exe";

	
	
//	 ie
//	 public static String browser = "webdriver.iexplore.bin";
//	 public static String browserDriver = "webdriver.ie.driver";
////	 public static String browserPath ="C:/Program Files/Internet Explorer/iexplore.exe";
//	 public static String browserPath ="webdriver.ie.driver";
//	 public static String browserDriverPath = "./IEDriverServer.exe";

	
	// web ip1
	public static String webIp1 = "http://10.18.21.121";
	public static String webUrl1 = webIp1
			+ "/func/web_main/login?user_name=%2589%2594%2590%2583%2586&password=%2567%2591%2566%2586%2581%2582%2583%25104%2589%2594%2590%2583%2586&password1=&code=umcccc&language=1&check=1&ovc=dd";
	
	// web ip2
	public static String webIp2 = "http://10.18.21.122";
	public static String webUrl2 = webIp2 
			+ "/func/web_main/login?user_name=%2589%2594%2590%2583%2586&password=%2567%2591%2566%2586%2581%2582%2583%25104%2589%2594%2590%2583%2586&password1=&code=umcccc&language=1&check=1&ovc=dd";
	
	// web ip3
		public static String webIp3 = "http://10.18.21.123";
		public static String webUrl3 = webIp3 
			+ "/func/web_main/login?user_name=%2589%2594%2590%2583%2586&password=%2567%2591%2566%2586%2581%2582%2583%25104%2589%2594%2590%2583%2586&password1=&code=umcccc&language=1&check=1&ovc=dd";
	
	// web ip4
		public static String webIp4 = "http://10.18.21.120";
		public static String webUrl4 = webIp4 
			+ "/func/web_main/login?user_name=%2589%2594%2590%2583%2586&password=%2567%2591%2566%2586%2581%2582%2583%25104%2589%2594%2590%2583%2586&password1=&code=umcccc&language=1&check=1&ovc=dd";

	//web DPX
		public static String webIPDPX = "http://10.18.36.68";
		public static String webUrlDPX = webIPDPX 
				+"/func/web_main/login?user_name=%2589%2594%2590%2583%2586&password=%2567%2591%2566%2586%2581%2582%2583%25104%2589%2594%2590%2583%2586&password1=&code=umcccc&language=1&check=1&ovc=dd";
		

	//web DPX
		public static String webIPDPX1 = "http://10.58.38.8";
		public static String webUrlDPX1 = webIPDPX1 
				+"/func/web_main/login?user_name=%2589%2594%2590%2583%2586&password=%2567%2591%2566%2586%2581%2582%2583%25104%2589%2594%2590%2583%2586&password1=&code=umcccc&language=1&check=1&ovc=dd";
				
		
		
	//web SSLVPn
		public static String webIPSSLVPN = "https://10.18.36.68:6443";
		
//	// 其他IP
//	public static String webIpADX = "http://10.23.33.1";
//	public static String webUrlADX = webIpADX
//			+ "/func/web_main/login?user_name=admin&password=admin_default&code=umcccc&language=1&check=1";
//
//	public static String webIp2 = "http://10.22.36.200";
//	public static String webUrl2 = webIp2
//			+ "/func/web_main/login?user_name=admin&password=admin_default&code=umcccc&language=1&check=1";
//
//	// web ip for liqiao
//	public static String webIpPF = "https://10.23.36.123";
//	public static String webUrlPF = webIpPF
//			+ "/func/web_main/login?user_name=admin&password=zzszf@2014&code=umcccc&language=1&check=1";
//
//	public static String webIpLB = "http://10.23.28.36";
//	public static String webUrlLB = webIpLB
//			+ "/func/web_main/login?user_name=admin&password=admin_default&code=umcccc&language=1&check=1";
//	
	
	// 截图路径
	public static String capturePath = "./Captures/";
	
	//配置文件存储路径及名称
	public static String filePath = "D:/配置文件/security_zone.csv";
	public static String filePath1 = "D:/配置文件/security_zone1.csv";
	
	//定义三台设备直连接口
	public static String interf12_2 = "gige0_1"; //设备2与设备1直连的接口
	public static String interf12_1 = "gige0_0"; //设备1与设备2直连的接口
	public static String interf13_1 = "gige0_1"; //设备2与设备3直连的接口
	public static String ingerf13_3 = "gige0_1"; //设备3与设备2直连的接口
}
