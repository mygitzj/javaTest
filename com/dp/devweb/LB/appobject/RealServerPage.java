package dp.devweb.LB.appobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dp.devweb.common.CommonObject;

/**
 * @Title: RealServerPage.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author w01866
 * @date 2015年1月9日 下午5:05:00
 * @version V4.4
 */
public class RealServerPage {
	// 实例化公共方法类
	public CommonObject obj = new CommonObject();

	public WebElement btnAdd() throws Exception {
//		return obj.getElementByXpath("//input[@value='添加']");
		return obj.getElement(By.xpath("//input[@value='添加']"));
	}
	
	public WebElement btnDel() throws Exception {
//		return obj.getElementByXpath("//input[@value='删除']");
		return obj.getElement(By.xpath("//input[@value='删除']"));
	}

	public WebElement txtRealServerName() throws Exception {
//		return obj.getElementById("rs_name");
		return obj.getElement(By.id("rs_name"));
	}

	public WebElement txtIpAddr() throws Exception {
//		return obj.getElementById("rs_ipaddr");
		return obj.getElement(By.id("rs_ipaddr"));
		
	}

	public WebElement txtPort() throws Exception {
//		return obj.getElementById("rs_port");
		return obj.getElement(By.id("rs_port"));
	}

	public WebElement txtWeight() throws Exception {
//		return obj.getElementById("rs_weight");
		return obj.getElement(By.id("rs_weight"));
	}

	public WebElement txtConcurrentConnection() throws Exception {
		return obj.getElement(By.id("rs_clinum"));
	}

	public WebElement txtNewConnection() throws Exception {
//		return obj.getElementById("rs_clinum_new");
		return obj.getElement(By.id("rs_clinum_new"));
	}

	public WebElement sltHealth() throws Exception {
//		return obj.getElementById("rs_hc");
		return obj.getElement(By.id("rs_hc"));
	}

	public WebElement imgAdvancedOption() throws Exception {
		return obj.getElementById("img_id");
	}

	public WebElement txtCpuWeight() throws Exception {
//		return obj.getElementById("cpu_weight_set");
		return obj.getElement(By.id("cpu_weight_set"));
	}

	public WebElement txtMemoryWeight() throws Exception {
//		return obj.getElementById("mem_weight_set");
		return obj.getElement(By.id("mem_weight_set"));
	}

	public WebElement txtRecoveryTime() throws Exception {
//		return obj.getElementById("mod_warm_recover");
		return obj.getElement(By.id("mod_warm_recover"));
	}

	public WebElement txtWarmTime() throws Exception {
//		return obj.getElementById("mod_warm_warmming");
		return obj.getElement(By.id("mod_warm_warmming"));
	}

	public WebElement chkStatistics() throws Exception {
//		return obj.getElementById("necessrespond");
		return obj.getElement(By.id("necessrespond"));
	}
	
	public WebElement lstRealServiceConf() throws Exception {
//		return obj.getElementByXpath("//*[@id='1']/ul");
		return obj.getElement(By.xpath("//*[@id='1']/ul"));
	}
	
	public WebElement chkRealService(String name) throws Exception {
		List<WebElement> lsts = obj.getElements(By.xpath("//*[@id='1']/ul/child::li"));
		WebElement lst = null;
		for (int i = 0; i < lsts.size(); i++){
			if (lsts.get(i).getText().equals(name)){				
				lst = obj.getElement(By.xpath("//*[@id='1']/ul/child::li[" + (i+1) + "]//a/ins[1]"));
				break;
			}
		}
		return lst;
	}
	
	public List<WebElement> liRealService() throws Exception {
//		List<WebElement> lsts = obj.getElementsByXpath("//*[@id='1']/ul/child::li");
		List<WebElement> lsts = obj.getElements(By.xpath("//*[@id='1']/ul/child::li"));
		return lsts;
	}
	
	

}
