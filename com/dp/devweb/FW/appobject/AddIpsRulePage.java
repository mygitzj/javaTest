package dp.devweb.FW.appobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dp.devweb.common.CommonObject;

/**   
 * @Title: AddIpsRulePage.java 
 * @Description: TODO(增加ipv4路由) 
 * @author Administrator 
 * @date 2015年2月13日 上午10:23:37 
 * @version V4.4   
 */
public class AddIpsRulePage {
	
//	实例化公共对象
	public  CommonObject  obj = new CommonObject();
	
	/**
	 * 业务
	 */
	public WebElement yewu() {
		return  obj.getElement(By.linkText("业务"));
		
	}
	public WebElement ipS() {
		return obj.getElement(By.linkText("IPS"));
		
	}
	public WebElement liIPS() {
		return obj.getElement(By.id("menu_M_IPS"));	
	}
	
	public WebElement basicCharaDefend() {
		return obj.getElement(By.linkText("基本特征防护"));
	}
	
	public WebElement liBasicCharaDefend() {
		return obj.getElement(By.id("menu_S_IPS_SIG_PROTECT"));	
	}
	
	public WebElement ipsRlue() {
		return obj.getElement(By.linkText("IPS规则"));
	}
	
//	获取表格
	public WebElement tablIps() {
		return obj.getElement(By.id("table"));
	}

//	获取复制
	public WebElement copy() {
		return obj.getElement(By.xpath("//*[@id='table1']/tbody/tr[1]/td[9]/span[1]"));
	}
	
//	获取输入名称框
	public WebElement inpName() {
		return obj.getElement(By.xpath("//*[@id='input_rule_name']"));
	}
	
// 获取IT资源输入框
	public WebElement inpIT() {
		return obj.getElement(By.xpath("//*[@id='table1']/tbody/tr[2]/td[2]"));
	}
	
//	获取全选
	public WebElement selectAll() {
		return obj.getElement(By.xpath("//*[@id='popup_it_src']/table/tbody/tr[1]/td[1]/label[2]"));
	}
	
//	获取协议相关输入框
	public WebElement attackType() {
		return obj.getElement(By.xpath("//*[@id='table1']/tbody/tr[2]/td[3]"));
	}
	
//	获取全选
	public WebElement selectAll1() {
		return obj.getElement(By.xpath("//*[@id='select_all_attack']"));
	}
//	
	
}
