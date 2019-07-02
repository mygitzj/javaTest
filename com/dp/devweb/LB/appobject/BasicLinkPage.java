package dp.devweb.LB.appobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dp.devweb.common.CommonObject;

/**
 * @Title: BasicLinkPage.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author w01866
 * @date 2015年2月3日 下午3:29:52
 * @version V4.4
 */
public class BasicLinkPage {

	public CommonObject obj = new CommonObject();

	public WebElement btnAdd() {
		return obj.getElement(By.xpath("//input[@value='添加']"));
	}
	
	public WebElement btnDelete() {
		return obj.getElement(By.xpath("//input[@value='删除']"));
	}

	// 基础配置
	public WebElement txtName() {
		return obj.getElement(By.id("id_name"));
	}

	public WebElement sltInterface() {
		return obj.getElement(By.id("id_vlan_name"));
	}

	public WebElement txtGateway() {
		return obj.getElement(By.id("id_next_hop_str"));
	}

	public WebElement txtBandwidth() {
		return obj.getElement(By.id("id_bandwidth"));
	}

	public WebElement txtThreshold() {
		return obj.getElement(By.id("id_bandwidth_threshold"));
	}

	public WebElement txtWeight() {
		return obj.getElement(By.id("id_weight"));
	}

	public WebElement txtPriority() {
		return obj.getElement(By.id("id_priority"));
	}

	public WebElement sltOperators() {
		return obj.getElement(By.id("id_ispid"));
	}

	public WebElement sltType() {
		return obj.getElement(By.id("id_link_type"));
	}

	public WebElement sltGroupLeft() {
		return obj.getElement(By.id("hc_left_list"));
	}

	public WebElement sltGroupRight() {
		return obj.getElement(By.id("hc_right_list"));
	}

	public WebElement btnToLeft() {
		return obj.getElement(By.id("to_left"));
	}

	public WebElement btnToRight() {
		return obj.getElement(By.id("to_right"));
	}

	// 质量检查
	public WebElement txtLostRate() {
		return obj.getElement(By.id("id_lost_rate_threshold"));
	}

	public WebElement txtLatency() {
		return obj.getElement(By.id("id_latency_threshold"));
	}

	public WebElement txtPassLeast() {
		return obj.getElement(By.id("id_passleast"));
	}

	public WebElement txtSourceIP() {
		return obj.getElement(By.id("id_hc_sip_str"));
	}

	public WebElement txtDNS() {
		return obj.getElement(By.id("id_dns_server"));
	}

	// 高级配置
	public WebElement chkRoute() {
		return obj.getElement(By.id("id_rtmode"));
	}

	public WebElement chkThresholdControl() {
		return obj.getElement(By.id("id_show_or_hide"));
	}

	public WebElement txtTimeThreshold() {
		return obj.getElement(By.id("id_bandwidth_time_threshold"));
	}

	public WebElement liList() {
		return obj.getElement(By.id("1"));
	}

	public List<WebElement> spnLists() {
		return obj.getElements(liList(), By.tagName("span"));
	}

	public WebElement chkName(String name) {
		List<WebElement> lsts = obj.getElements(By.xpath("//*[@id='1']/ul/child::li"));
		WebElement lst = null;
		for (int i = 0; i < lsts.size(); i++){
			if (lsts.get(i).getText().equals(name)){				
				lst = obj.getElement(By.xpath("//*[@id='" + (i+2) + "']/a/ins[1]"));
				break;
			}
		}
		return lst;
	}
	
	public WebElement chkAll() {		
		return obj.getElement(By.xpath("//*[@id='1']/a/ins[1]"));
	}
}
