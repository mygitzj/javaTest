package dp.devweb.LB.appobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dp.devweb.common.CommonObject;

/**   
 * @Title: TCPHealthCheckPage.java 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author w01866 
 * @date 2015年1月30日 下午2:00:36 
 * @version V4.4   
 */
public class TCPHealthCheckPage {
	public CommonObject obj = new CommonObject();
	
	public WebElement btnAdd() {
		return obj.getElement(By.xpath("//input[@value='添加']"));
	}
	
	public WebElement txtName() {
		return obj.getElement(By.id("mod_name"));
	}
	
	public WebElement txtTimeout() {
		return obj.getElement(By.id("mod_linkovertime"));
	}
	
	public WebElement txtInterval() {
		return obj.getElement(By.id("tcp_interval"));
	}
	
	public WebElement txtTryTime() {
		return obj.getElement(By.id("tcp_trytime"));
	}
	
	public WebElement chkMustPass() {
		return obj.getElement(By.id("tcp_necessary"));
	}
	
	public WebElement imgDefinedCheck() {
		return obj.getElement(By.id("img_id"));
	}
	
	public WebElement txtSendContent() {
		return obj.getElement(By.id("sendcontent"));
	}
	
	public WebElement txtReceivePacket(){
		return obj.getElement(By.id("checkcontent"));
	}
	
	public WebElement imgTriangle() {
		return obj.getElement(By.id("img_id2"));
	}
	
	public WebElement chkTriangle() {
		return obj.getElement(By.id("ttenable"));
	}
	
	public WebElement imgAdvanced() {
		return obj.getElement(By.id("img_id3"));
	}
	
	public WebElement txtIPAddress() {
		return obj.getElement(By.id("mod_addr"));
	}
	
	public WebElement txtPort() {
		return obj.getElement(By.id("mod_portnum"));
	}
}
