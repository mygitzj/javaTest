package dp.devweb.common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @Title: CommonObject.java
 * @Description: 获取页面元素公共方法
 * @author w01866
 * @date 2014年12月21日 下午15:28:52
 * @version V4.4
 */
public class CommonObject extends CommonObjectScript {

	// 实例化公共操作方法
	public CommonOperator opr = new CommonOperator();
	
	/**
	 * 根据链接文本内容定位link页面元素
	 * 
	 * @param str
	 *            文本内容
	 * @return 链接对象
	 */
	public WebElement getElementByLink(String str) {
		return driver.findElement(By.linkText(str));
	}

	/**
	 * 根据父对象、链接文本内容定位link页面元素
	 * 
	 * @param obj
	 *            父对象
	 * @param str
	 *            文本内容
	 * @return 链接对象
	 */
	public WebElement getElementByLink(WebElement obj, String str) {
		return obj.findElement(By.linkText(str));
	}

	/**
	 * 根据ID值定位页面元素
	 * 
	 * @param str
	 *            文本内容
	 * @return 页面元素
	 */
	public WebElement getElementById(String str) {
		return driver.findElement(By.id(str));
	}

	/**
	 * 根据父对象、ID值定位页面元素
	 * 
	 * @param obj
	 *            父对象
	 * @param str
	 *            文本内容
	 * @return 页面元素
	 */
	public WebElement getElementById(WebElement obj, String str) {
		return obj.findElement(By.id(str));
	}

	/**
	 * 根据xpath定位页面元素
	 * 
	 * @param str
	 *            xpath值
	 * 
	 * @return 页面元素
	 */
	public WebElement getElementByXpath(String str) {
		return driver.findElement(By.xpath(str));
	}
	

	/**
	 * 根据父对象、xpath值定位页面元素
	 * 
	 * @param obj
	 *            父对象
	 * @param str
	 *            xpath值
	 * @return 页面元素
	 */
	public WebElement getElementByXpath(WebElement obj, String str) {
		return obj.findElement(By.xpath(str));
	}

	/**
	 * 根据xpath值定位页面元素
	 * 
	 * @param str
	 *            xpath值
	 * @return 页面元素列表
	 */
	public List<WebElement> getElementsByXpath(String str) {
		return driver.findElements(By.xpath(str));
	}
	
	/**
	 * 根据tagName定位页面元素
	 * 
	 * @param str
	 *            tagName
	 * @return 页面元素列表
	 */
	public List<WebElement> getElementsByTagname(String str) {
		return driver.findElements(By.tagName(str));
	}

	/**
	 * 根据className定位页面元素
	 * 
	 * @param str
	 *            class值
	 * @return
	 */
	public WebElement getElementsByClassname(String str) {
		return driver.findElement(By.className(str));
	}
	
	/**
	 * 根据父对象、className定位页面元素
	 * 
	 * @param obj
	 *            父对象
	 * @param str
	 *            class值
	 * @return
	 */
	public WebElement getElementByClassname(WebElement obj, String str) {
		return obj.findElement(By.className(str));
	}
	
	
	//----------------------------------------------------------
	/**
	 * 定位页面元素，超时时间内反复判断元素是否出现。若元素定位失败，则截图
	 * 
	 * @param by
	 *            页面元素
	 * @param timeout
	 *            超时时间
	 * @return 页面元素
	 */
	public WebElement getElement(By by, long timeout) {
		try {
			if (opr.isElementPresent(by, timeout)) {				
				return driver.findElement(by);
			}
		} catch (Exception e) {
			System.out.println(e + "");
		}
		return null;
	}
	
	/**
	 * 定位页面元素，超时时间内反复判断元素是否出现。若元素定位失败，则截图
	 * 
	 * @param obj
	 *            父对象
	 * 
	 * @param by
	 *            页面元素
	 * @param timeout
	 *            超时时间
	 * @return 页面元素
	 */
	public WebElement getElement(By by) {
		return getElement(by, 0);
	}
	
	public WebElement getElement(WebElement obj, By by, long timeout) {
//		boolean isSucceed = false;
		try {
			if (opr.isElementPresent(obj, by, timeout)) {				
//				isSucceed = true;
			}
		} catch (Exception e) {
			System.out.println(e + "");
		}
//		operationCheck("getElement", isSucceed);
		return obj.findElement(by);
	}
	
	/**
	 * 定位页面元素，超时时间内反复判断元素是否出现。若元素定位失败，则截图
	 * 
	 * @param obj 父对象
	 * 
	 * @param by
	 *            页面元素
	 * @param timeout
	 *            超时时间
	 * @return 页面元素
	 */
	public WebElement getElement(WebElement obj, By by) {
		return getElement(obj, by, 0);
	}
	
	/**
	 * 定位页面元素，超时时间内反复判断元素是否出现。若元素定位失败，则截图
	 * 
	 * @param by
	 *            页面元素
	 * @param timeout
	 *            超时时间
	 * @return 页面元素
	 */
	public List<WebElement> getElements(By by, long timeout) {
//		boolean isSucceed = false;
		try {
			if (opr.isElementPresent(by, timeout)) {				
//				isSucceed = true;
			}
		} catch (Exception e) {
			System.out.println(e + "");
		}
//		operationCheck("getElement", isSucceed);
		return driver.findElements(by);
	}
	
	/**
	 * 定位页面元素，超时时间内反复判断元素是否出现。若元素定位失败，则截图
	 * 
	 * @param by
	 *            页面元素
	 * @param timeout
	 *            超时时间
	 * @return 页面元素
	 */
	public List<WebElement> getElements(By by) {
		return getElements(by, 0);
	}
	
	/**
	 * 定位页面元素，超时时间内反复判断元素是否出现。若元素定位失败，则截图
	 * 
	 * @param by
	 *            页面元素
	 * @param timeout
	 *            超时时间
	 * @return 页面元素
	 */
	public List<WebElement> getElements(WebElement obj, By by, long timeout) {
//		boolean isSucceed = false;
		try {
			if (opr.isElementPresent(obj, by, timeout)) {				
//				isSucceed = true;
			}
		} catch (Exception e) {
			System.out.println(e + "");
		}
//		operationCheck("getElement", isSucceed);
		return driver.findElements(by);
	}
	
	/**
	 * 定位页面元素，超时时间内反复判断元素是否出现。若元素定位失败，则截图
	 * 
	 * @param by
	 *            页面元素
	 * @param timeout
	 *            超时时间
	 * @return 页面元素
	 */
	public List<WebElement> getElements(WebElement obj, By by) {
		return getElements(obj, by, 0);
	}

}
