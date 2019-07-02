package dp.devweb.common;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * @Title: CommonOperator.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author w01866
 * @date 2014年12月3日 下午4:26:52
 * @version V4.4
 */

/**
 * 
* @Title: CommonOperator.java 
* @Description: TODO(用一句话描述该文件做什么) 
* @author z01674 
* @date 2015年4月10日 下午2:57:49 
* @version V4.4
 */
public class CommonOperator extends CommonObjectScript {

	/**
	 * 打开链接，若链接已经打开，则不点击
	 * 
	 * @param win
	 *            判断展开状态的对象
	 * @param obj
	 *            需要点击的对象
	 */
	public void ClickToOpen(WebElement win, WebElement obj) throws Exception {
		if (win.getAttribute("class").toString().contains("close")) {
//			Debug("点击【" + obj + "】");
			obj.click();
		}
	}

	/**
	 * 切换frame (Default >>> HiddenSubWin)
	 */
	public void SwitchToFrame() throws Exception {
		SwitchToDefault();
		driver.switchTo().frame("HiddenSubWin");
	}

	/**
	 * 
	 */
	public void SwitchToFrame1() throws Exception {
		driver.switchTo().frame("HiddenSubWin");
	}
	
	
	/**
	 * 切换frame (Default >>> MenuWindows)
	 */
	public void SwitchToMenuFrame() {
		SwitchToDefault();
		driver.switchTo().frame("MenuWindow");
	}

	/**
	 * 切换frame (Default >>> MenuWindows >>> HiddenSubWin)
	 */
	public void SwitchToFrameFromMenu() {
		SwitchToMenuFrame();
		driver.switchTo().frame("HiddenSubWin");
	}

	/**
	 * 切出frame (Default)
	 */
	public void SwitchToDefault() {
		driver.switchTo().defaultContent();
	}

	/**
	 * 用JS执行点击操作，可解决点击不在当前页（需要拖动滑动条的类型）的对象
	 * 
	 * @param obj
	 *            点击对象
	 */
	public void JsClick(WebElement obj) throws Exception {
//		Debug("点击 【" + obj + "】");
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				obj);
	}

	/**
	 * 根据索引选择
	 * 
	 * @param obj
	 *            select类对象
	 * @param n
	 *            索引值
	 */
	public void Select(WebElement obj, int n) throws Exception {
		Debug("在元素【" + obj + "】中选择【" + n + "】");
		Select slt = new Select(obj);
		slt.selectByIndex(n);
	}

	/**
	 * 根据字符串选择
	 * 
	 * @param obj
	 *            select类对象
	 * @param str
	 *            字符串
	 */
	public void Select(WebElement obj, String str) throws Exception {
		Debug("在元素【" + obj + "】中选择【" + str + "】");
		Select slt = new Select(obj);
		slt.selectByVisibleText(str);
	}
	
	public void SelectByValue(WebElement obj,String str) throws Exception {
		Debug("在元素【" + obj + "】中选择【" + str + "】");
		Select sel = new Select(obj);
		sel.selectByValue(str);
	}
	
	public List<WebElement> getOptions(WebElement obj) throws Exception {
		Select slt = new Select(obj);
		List<WebElement> options = slt.getOptions();
		Debug("获取元素【" + obj + "】的option\t" + "长度为【" + options.size() + "】");		
		return options;
	}

	/**
	 * 输入字符前清空文本框
	 * 
	 * @param obj
	 *            文本框对象
	 * @param str
	 *            输入的内容
	 */
	public void SendKeys(WebElement obj, String str) throws Exception {
		Debug("清空文本【" + obj + "】\t输入内容【" + str + "】");
		obj.clear();
		obj.sendKeys(str);
	}
	
	/**
	 * 直接输入字符，不清空文本
	 */
	public void SendKeysNoClear(WebElement obj, String str) throws Exception {
		Debug("输入内容【" + str + "】");
		obj.sendKeys(str);
	}

	/**
	 * 单击操作，操作失败则截图
	 * 
	 * @param obj
	 *            操作元素
	 * @param timeout
	 *            超时时间
	 * @throws Exception
	 */
	public void Click(WebElement obj, long timeout) throws Exception {
		boolean isSucceed = false;
		long timeBegins = System.currentTimeMillis();
		do {
			try {
				obj.click();
				isSucceed = true;
				break;
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (System.currentTimeMillis() - timeBegins <= timeout * 1000);

		operationCheck("Click", isSucceed);

	}

	/**
	 * 单击操作，操作失败则截图
	 * 
	 * @param obj
	 *            操作元素
	 * @param timeout
	 *            超时时间
	 * @throws Exception
	 */
	public void Click(WebElement obj) throws Exception {
//		Debug("点击 【" + obj + "】");
//		Click(obj, 0);
		JsClick(obj);
	}

	/**
	 * 操作checkbox类
	 * 
	 * @param obj
	 *            checkbox对象
	 * @param b
	 *            ture为勾选，false去选
	 */
	public void ClickToState(WebElement obj, boolean b) throws Exception {
		sleep(1);
		if (b == true) {
			if (obj.isSelected() == false) {
				Debug("勾选【" + obj + "】");
				obj.click();
			}
		}
		if (b == false) {
			if (obj.isSelected() == true) {
				Debug("去选【" + obj + "】");
				obj.click();
			}
		}
	}

	/**
	 * 操作checkbox类
	 * 
	 * @param obj
	 *            checkbox对象
	 * @param b
	 *            ture为勾选，false去选
	 */
	public void JsClickToState(WebElement obj, boolean b) throws Exception {
		if (b == true) {
			if (obj.isSelected() == false) {
				JsClick(obj);
				;
			}
		}
		if (b == false) {
			if (obj.isSelected() == true) {
				JsClick(obj);
			}
		}
	}

	/**
	 * alert true确定；false取消
	 * @param type boolean值
	 * @throws Exception
	 */
	public void Alert(boolean type) throws Exception {
		// 获取alert
		Alert alert = driver.switchTo().alert();	
		if (type) {
			Debug("点击确定");
			alert.accept();
		}
		if (!type) {
			Debug("点击取消");
			alert.dismiss();
		}
	}

	/**
	 * 顺序生成（n+1）个ip地址，IP地址范围1.1.1.1 -- 254.254.254.254，去除了255这个数值
	 * 
	 * @param n
	 *            需要的IP地址数量
	 * @return IP地址数组
	 */
	public List<String> getIPSequence(int n) {
		List<String> ips = new ArrayList<String>();
		for (int a = 1; a < 255; a++) {
			for (int b = 1; b < 255; b++) {
				for (int c = 1; c < 255; c++) {
					for (int d = 1; d < 255; d++) {
						ips.add(a + "." + b + "." + c + "." + d);
						if ((n + 1) == ips.size()) {
							System.out.println(ips.size());
							return ips;
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * wait for the specified element appears with timeout setting.
	 * 
	 * @param locator
	 *            the element locator on the page
	 * @param timeout
	 *            超时时间，单位：秒
	 */
	public boolean isElementPresent(By locator, long timeout) throws Exception {
		boolean isSucceed = false;
		long timeBegins = System.currentTimeMillis();
		do {
			try {
				driver.findElement(locator);
				isSucceed = true;
				break;
			} catch (Exception e) {
				e.printStackTrace();
			}

		} while (System.currentTimeMillis() - timeBegins <= timeout * 1000);

		operationCheck("isElementPresent", isSucceed);
		return isSucceed;
	}

	/**
	 * wait for the specified element appears with timeout setting.
	 * 
	 * @param obj
	 *            the element locator's parent
	 * 
	 * @param locator
	 *            the element locator on the page
	 * @param timeout
	 *            超时时间，单位：秒
	 */
	public boolean isElementPresent(WebElement obj, By locator, long timeout)
			throws Exception {
		boolean isSucceed = false;
		long timeBegins = System.currentTimeMillis();
		do {
			try {
				obj.findElement(locator);
				isSucceed = true;
				break;
			} catch (Exception e) {
				e.printStackTrace();
			}

		} while (System.currentTimeMillis() - timeBegins <= timeout * 1000);

		operationCheck("isElementPresent", isSucceed);
		return isSucceed;
	}

	/**
	 * public method for handle assertions and screenshot.
	 * 
	 * @param isSucceed
	 *            if your operation success
	 */
	public void operationCheck(String methodName, boolean isSucceed)
			throws Exception {
		if (!isSucceed) {
			Date date = new Date();
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HHmmss");
			String time = format.format(date);
			StringBuffer sb = new StringBuffer();
			String captureName = sb.append(Config.capturePath)
					.append(methodName).append(time).append(".png").toString();
			captureScreenshot(captureName);
			Error("method 【" + methodName + "】 运行失败，请查看截图快照：" + captureName);
		}
	}

	/**
	 * 截取屏幕截图并保存到指定路径
	 * 
	 * @param filepath
	 *            保存屏幕截图完整文件名称及路径
	 * @return 无
	 */
	public void captureScreenshot(String filepath) {
		File screenShotFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShotFile, new File(filepath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 点击“确定”
	 * @throws Exception
	 */
	public void clickOK() throws Exception {
		List<WebElement> objs = driver
				.findElements(By.xpath("//span[text()='确定']"));
		WebElement obj = null;
		for (int i = 0; i < objs.size(); i++) {
			if (objs.get(i).getText().equals("确定")) {
				obj = objs.get(i);
				break;
			}
		}
		Click(obj);
	}
	
	public void clickConfirm() throws Exception {
		Click(driver.findElement(By.id("SUBMIT_BTN")));
	}
	
	
}
