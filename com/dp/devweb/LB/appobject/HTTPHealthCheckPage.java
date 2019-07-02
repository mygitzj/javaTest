package dp.devweb.LB.appobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dp.devweb.common.CommonObject;

/**   
 * @Title: HTTPHealthCheckPage.java 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author w01866 
 * @date 2015年2月3日 上午9:38:25 
 * @version V4.4   
 */
public class HTTPHealthCheckPage {
	public CommonObject obj = new CommonObject();
	
	public WebElement btnAdd() {
		return obj.getElement(By.xpath("//input[@value='添加']"));
	}
	
	public WebElement txtName() {
		return obj.getElement(By.id("mod_name"));
	}
	
	public WebElement sltMethod() {
		return obj.getElement(By.id("mode"));
	}
	
	public WebElement txtURL() {
		return obj.getElement(By.id("http_url"));
	}
	
	public WebElement sltVersion() {
		return obj.getElement(By.id("http_versions"));
	}
	
	public WebElement txtHost() {
		return obj.getElement(By.id("mod_host"));
	}
	
	public WebElement txtTimeout() {
		return obj.getElement(By.id("http_timeout"));
	}
	
	public WebElement txtInterval() {
		return obj.getElement(By.id("http_interval"));
	}
	
	public WebElement txtTryTime() {
		return obj.getElement(By.id("http_trytime"));
	}	
	
	public WebElement chkMustPass() {
		return obj.getElement(By.id("http_necessary"));
	}
	
	public WebElement imgDefinedCheck() {
		return obj.getElement(By.id("img_id"));
	}
	
	public WebElement txtNormal() {
		return obj.getElement(By.id("normal"));
	}
	
	public WebElement txtException() {
		return obj.getElement(By.id("exceptions"));
	}
	
	public WebElement chkLogStorage() {
		return obj.getElement(By.id("logstore"));
	}
	
	public WebElement imgAdvanced() {
		return obj.getElement(By.id("img_id2"));
	}
	
	public WebElement txtIPAddress() {
		return obj.getElement(By.id("mod_addr"));
	}
	
	public WebElement txtPort() {
		return obj.getElement(By.id("mod_port"));
	}
	
	
}
