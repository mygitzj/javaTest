package dp.devweb.LB.appobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dp.devweb.common.CommonObject;
import dp.devweb.common.CommonObjectScript;

/**   
 * @Title: TreeMenuPage.java 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author w01866 
 * @date 2015年1月9日 上午11:28:15 
 * @version V4.4   
 */
public class TreeMenuPage extends CommonObjectScript{
	// 实例化公共对象类
	public CommonObject obj = new CommonObject();
	
	/**
	 * “确认”按键	 
	 * @return 按键对象
	 * @throws Exception
	 */
	public WebElement btnConfirm() throws Exception {
//		return obj.getElementById("SUBMIT_BTN");
		return obj.getElement(By.id("SUBMIT_BTN"));
	}
	
	/**
	 * ADX列表
	 * @return td对象
	 * @throws Exception
	 */
	public WebElement lnkAdx() throws Exception{
//		return obj.getElementByXpath("//td[@title='ADX']");
		return obj.getElement(By.xpath("//td[@title='ADX']"));
	}
	
	/**
	 * 服务器负载均衡展开后的界面，用于判断服务器负载均衡是否是open状态
	 * @return li对象
	 * @throws Exception
	 */
	public WebElement liServerLb() throws Exception{
//		return obj.getElementById("menu_New_S_SERVICE_13");
		return obj.getElement(By.id("menu_New_S_SERVICE_13"));
	}
	
	/**
	 * ADX → 服务器负载均衡链接
	 * @return lnk对象
	 * @throws Exception
	 */
	public WebElement lnkServerLb() throws Exception{
//		return obj.getElementByLink("服务器负载均衡");
		return obj.getElement(By.linkText("服务器负载均衡"));
	}
	
	/**
	 * ADX → 服务器负载均衡 → 真实服务链接
	 * @return
	 * @throws Exception
	 */
	public WebElement lnkRealServer() throws Exception{
//		return obj.getElementByLink("真实服务");
		return obj.getElement(By.linkText("真实服务"));
	}
	
	/**
	 * 服务器健康检查展开后的界面，用于判断服务器健康检查是否是open状态
	 * @return li对象
	 */
	public WebElement liServerHealthCheck() {
		return obj.getElement(By.id("menu_ID_adx_slb_hc"));
	}
	
	/**
	 * ADX → 服务器负载均衡 → 服务器健康检查 
	 * @return
	 */
	public WebElement lnkServerHealthCheck() {
		return obj.getElement(By.linkText("服务器健康检查"));
	}

	/**
	 * ADX → 服务器负载均衡 → 服务器健康检查 → TCP健康检查
	 * @return
	 */
	public WebElement lnkTCPHealthCheck() {
		return obj.getElement(By.linkText("TCP健康检查"));
	}
	
	/**
	 * ADX → 服务器负载均衡 → 服务器健康检查 → HTTP健康检查
	 * @return
	 */
	public WebElement lnkHTTPHealthCheck() {
		return obj.getElement(By.linkText("HTTP健康检查"));
	}
	
	/**
	 * ADX → 链路负载均衡
	 * @return
	 */
	public WebElement lnkLinkLB() {
		return obj.getElement(By.linkText("链路负载均衡"));
	}
	
	/**
	 * ADX → 链路负载均衡 ，用于判断是否已打开
	 * @return
	 */
	public WebElement liLinkLB() {
		return obj.getElement(By.id("menu_New_S_RDLB_13"));
	}
	
	/**
	 * ADX → 链路负载均衡 → 基础链路负载均衡
	 * @return
	 */
	public WebElement lnkBasicLinkLB() {
		return obj.getElement(By.linkText("基础链路负载均衡"));
	}
}
