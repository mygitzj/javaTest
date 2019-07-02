package dp.devweb.LB.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.thoughtworks.selenium.webdriven.commands.Click;

import dp.devweb.common.CommonObjectScript;

/**
 * @Title: test.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author w01866
 * @date 2015年1月9日 下午5:39:37
 * @version V4.4
 */
public class test extends CommonObjectScript {

	public static void main(String[] args) throws Exception {

		// 指定浏览器路径
		System.setProperty("webdriver.chrome.bin",
				"C:/Program Files (x86)/Google/Chrome/Application/chrome.exe");

		// 指定驱动程序路径
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		
        // 实例化一个对象
		WebDriver driver = new ChromeDriver();

		driver.get("http://10.18.35.10/func/web_main/login?user_name=admin&password=admin_default&code=umcccc&language=1&check=1");
		Thread.sleep(1000);
		
		driver.findElement(By.linkText("网络管理")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.linkText("单播IPv4路由")).click();
		Thread.sleep(1000);
		
//		List<WebElement> list =  driver.findElements(By.linkText("静态路由"));
//		
//		for (int i = 0; i < list.size(); i++){
//		System.out.println(list.get(i));
//		}
		
		driver.findElement(By.xpath("//*[@id='menu_T_Manage_Static_Route_Main']/a/span")).click();
		Thread.sleep(1000);
		driver.switchTo().frame("HiddenSubWin");
		
		driver.findElement(By.xpath("//*[@id='Route_List']/tbody/tr/td[1]")).click();
		driver.findElement(By.id("ip_input")).sendKeys("0.0.0.0");
		driver.findElement(By.xpath("//*[@id='Route_List']/tbody/tr/td[2]")).click();
		WebElement slt = driver.findElement(By.id("netmask_select"));
		Select select = new Select(slt);
		select.selectByVisibleText("8");
		
//		driver.findElement(By.id("SUBMIT_BTN")).click();
		driver.findElement(By.xpath("//*[@id='Route_List']/tbody/tr/td[4]")).click();
		Thread.sleep(1000);
		Select str=new Select(driver.findElement(By.id("interface_select")));
		str.selectByVisibleText("gige0_0");
		driver.findElement(By.xpath("//span[text()='确定']")).click();
		driver.findElement(By.id("SUBMIT_BTN")).click();
			
	}
	

}