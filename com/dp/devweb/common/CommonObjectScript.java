package dp.devweb.common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @Title: CommonObjectScript.java
 * @Description: 公共方法
 * @author w01866
 * @date 2014年11月27日 下午14:25:51
 * @version V4.4
 */
public class CommonObjectScript {

	/**
	 * 定义脚本开始运行时的时间
	 */
	public static long startTime;

	/**
	 * 定义脚本结束时的时间
	 */
	public static long endTime;

	/**
	 * 定义脚本运行的时间
	 */
	public static int runTime;

	/**
	 * 定义log文件名
	 */
	public static String fileNameTime; // 时间

	public static String fileName; // 脚本名

	/**
	 * 定义浏览器对象
	 */
	public static WebDriver driver;

	// 启动脚本各参数、方法
	
	public WebDriver getWebDriver() {
		return driver;
	}
	
	/**
	 * 获取时间，用于日志
	 * 
	 * @return
	 */
	public static String time() {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("HH:mm:ss");
		String time = format.format(date);
		return time;
	}

	/**
	 * 获取有日期的时间，用于脚本开始，结束时的日志使用
	 * 
	 * @return
	 */
	public static String dateTime() {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(date);
		return time;
	}

	/**
	 * 获取时间，用于日志命名
	 */
	public static void logDateTime() {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HHmmss");
		String time = format.format(date);
		fileNameTime = time;
	}

	/**
	 * 开始脚本，启动浏览器并建立日志
	 * 
	 * @param className
	 *            类名称
	 * @throws Exception
	 */
	public static void startScript(String className) throws Exception {
		fileName = className;
		logDateTime();
		log(dateTime() + " " + className + " 开始运行");
		// 确定开始时间
		startTime = System.currentTimeMillis();
	}
	
//	/**
//	 * 启动browser浏览器
//	 * 
//	 * @param browserPath
//	 *            browser浏览器路径
//	 * @param browserDriverPath
//	 *            browserDriver路径
//	 * @param webUrl
//	 *            web页面URL
//	 * @throws Exception
//	 */
//	public static void driver(String browserPath, String browserDriverPath,
//			String webUrl) throws Exception {
//
//		// 如果你的 browser 没有安装在默认目录，那么必须在程序中设置
//		System.setProperty(Config.browser, browserPath);
//		// browserdriver驱动
//		System.setProperty(Config.browserDriver, browserDriverPath);
//		
//		if (Config.browser.contains("ie")) {
//			Debug("浏览器： Internet Explorer ");
//			driver = new InternetExplorerDriver();
//		}
//
//		if (Config.browser.contains("chrome")) {
//			Debug("浏览器：Google Chrome ");
//			driver = new ChromeDriver();
//		}
//		
//		// 最大化浏览器
//		driver.manage().window().maximize();
//
//		// 让浏览器访问 web
//		Debug("URL： " + webUrl);
//		driver.get(webUrl);
//		Thread.sleep(3000);
//
//		// 获取 网页的 title
//		log("打开页面:  " + driver.getTitle());
//	}

	//测试方法————————————————打开浏览器
	public static void driver(String browserPath, String browserDriverPath) throws Exception {

		// 如果你的 browser 没有安装在默认目录，那么必须在程序中设置
//		System.setProperty(Config.browser, browserPath);
		// browserdriver驱动
		System.setProperty(Config.browserDriver, browserDriverPath);

		if (Config.browser.contains("ie")) {
			Debug("浏览器： Internet Explorer ");
			
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			
			driver = new InternetExplorerDriver();
		}

		if (Config.browser.contains("chrome")) {
			Debug("浏览器：Google Chrome ");
			driver = new ChromeDriver();
		}

		// 最大化浏览器
		driver.manage().window().maximize();

		
	}
	
	//打开指定的URL
	public static void driver1(String webUrl) throws Exception {
		// 让浏览器访问 web
				Debug("URL： " + webUrl);
				driver.get(webUrl);
				Thread.sleep(3000);

				// 获取 网页的 title
				log("打开页面:  " + driver.getTitle());
	}
	
	
//	 WebDriver driver = new Chromexxxxxx
//			 driver.get("http://www.baidu.com");
//	控制多台设备的方法
	

	
	/**
	 * 注销用户
	 * 
	 * @throws Exception
	 */
	public static void logout() throws Exception {
		try {
			startTime = startTime / 1000;
			endTime = System.currentTimeMillis() / 1000;
			runTime = (int) endTime - (int) startTime;
			int s = runTime;
			int H = s / (60 * 60);
			int M = (s % (60 * 60)) / (60);
			int S = (s % (60));

			Debug(dateTime() + " 脚本运行结束");
			String runTime = "耗时： " + H + "时 " + M + "分 " + S + "秒";
			Debug(runTime);

			sleep(2);

			// 用户注销
			Debug("注销用户");
			driver.switchTo().defaultContent();
			WebElement obj = driver.findElement(By.id("test-top-right"))
					.findElement(By.xpath("//a[contains(@href,'logout')]"));
			obj.click();

			// 点击确定
			Alert alert = driver.switchTo().alert();
			alert.accept();

			// Runtime.getRuntime().exec(
			// new String[] { "cmd.exe", "/c",
			// "./logs/" + fileName + " " + fileNameTime + ".txt" });

		} catch (Exception e) {
			e.printStackTrace();
			Error("用户注销失败");
		}
	}

	// 获取注销用户时弹出框的button
	// public static String closeAlertAndGetItsText() {
	// Alert alert = driver.switchTo().alert();
	// String alertText = alert.getText();
	// alert.accept();
	// return alertText;
	// }

	public static void reboot() throws Exception {
		try {
			Debug("重启");
			driver.switchTo().defaultContent();
			driver.findElement(By.id("mainreboot")).click();
			// 点击确定
			Alert alert = driver.switchTo().alert();
			alert.accept();
			
			driver.quit();
			
		} catch (Exception e) {
			e.printStackTrace();
			Error("用户注销失败");
		}
	}

	
	// 日志信息
	public static void log(String str) throws IOException {
		if (str.contains("Error")) {
			System.err.println(str);
		} else {
			System.out.println(str);
		}

		// 创建新的文件：
		File file = new File("./logs/" + fileName + " " + fileNameTime + ".txt");
		file.createNewFile();
		BufferedWriter output = new BufferedWriter(new FileWriter(file, true));
		output.newLine();
		output.write(str);
		output.close();
	}

	/**
	 * 获取类名
	 * 
	 * @return
	 */
	public String getClassName() {
		String className = this.getClass().getName();
		return className.substring(className.lastIndexOf(".") + 1);
	}

	/**
	 * 脚本通过时打印报告信息
	 * 
	 * @return 类名 + 耗时 + 结果
	 * @throws Exception
	 */
	public String pass() throws Exception {

		String className = this.getClass().getName();
		String scriptName = className.substring(className.lastIndexOf(".") + 1);

		int s = runTime;
		int H = s / (60 * 60);
		int M = (s % (60 * 60)) / (60);
		int S = (s % (60));

		Debug("脚本运行成功");

		return scriptName + "&" + H + "时 " + M + "分 " + S + "秒" + "&" + "pass";
	}

	/**
	 * 脚本失败打印报告信息
	 * 
	 * @return 类名 + 耗时 + 结果
	 * @throws Exception
	 */
	public String fail() throws Exception {

		String className = this.getClass().getName();
		String scriptName = className.substring(className.lastIndexOf(".") + 1);

		int s = runTime;
		int H = s / (60 * 60);
		int M = (s % (60 * 60)) / (60);
		int S = (s % (60));

		Error("脚本运行失败");

		return scriptName + "&" + H + "时 " + M + "分 " + S + "秒" + "&" + "fail";
	}

	public static void Step(String str) throws Exception {
		String oStr = time() + " 【step】 " + str;
		log(oStr);
	}

	public static void Info(String str) throws Exception {
		String oStr = time() + " [Info] " + str;
		log(oStr);
	}

	public static void Debug(String str) throws Exception {
		String oStr = time() + " [Debug] " + str;
		log(oStr);
	}

	public static void Error(String str) throws Exception {
		String oStr = time() + " >>> Error <<< " + str;
		log(oStr);
	}

	public static void sleep(int n) throws Exception {
		// log(time() + " [sleep] " + n + " s");
		Thread.sleep(n * 1000);
	}

	public void Wait(WebElement obj) {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions
				.elementToBeClickable(obj));
	}

	/**
	 * 
	 * @param ip
	 *            目标主机IP地址
	 * @param n
	 *            ping次数
	 * @param l
	 *            ping的字节量 0-65500
	 * @throws Exception
	 */
	public void Ping(String ip, int n, int l) throws Exception {
		String line = null;
		try {
			Process pro = Runtime.getRuntime().exec(
					"ping " + ip + " -n " + n + " -l " + l);
			BufferedReader buf = new BufferedReader(new InputStreamReader(
					pro.getInputStream()));
			while ((line = buf.readLine()) != null)
				System.out.println(line);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	/**
	 * 
	 * @param ip
	 *            目标主机IP地址
	 * @param n
	 *            ping次数
	 * @throws Exception
	 */
	public void Ping(String ip, int n) throws Exception {
		String line = null;
		try {
			Process pro = Runtime.getRuntime().exec("ping " + ip + " -n " + n);
			BufferedReader buf = new BufferedReader(new InputStreamReader(
					pro.getInputStream()));
			while ((line = buf.readLine()) != null)
				System.out.println(line);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	/**
	 * 
	 * @param ip
	 *            目标主机IP地址
	 * @throws Exception
	 */
	public void Ping(String ip) throws Exception {
		String line = null;
		try {
			Process pro = Runtime.getRuntime().exec("ping " + ip);
			BufferedReader buf = new BufferedReader(new InputStreamReader(
					pro.getInputStream()));
			while ((line = buf.readLine()) != null)
				System.out.println(line);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
