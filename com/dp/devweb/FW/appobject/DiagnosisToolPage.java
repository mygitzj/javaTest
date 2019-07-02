package dp.devweb.FW.appobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dp.devweb.common.CommonObject;

/**
 * 
* @Title: DiagnosisToolPage.java 
* @Description: TODO(用一句话描述该文件做什么) 
* @author z01674 
* @date 2015年4月8日 下午3:17:25 
* @version V4.4
 */

public class DiagnosisToolPage {
	
	//实例化公共对象
	public  CommonObject  obj = new CommonObject();
	
	//基本——网络管理
	public WebElement lnkNetManagement() throws Exception {
		return obj.getElement(By.linkText("网络管理"));
	}

	//查看是否为展开项
	public WebElement liNetManagement() throws Exception {
		return obj.getElement(By.id("menu_M_Net_Management"));	
	}
	
	//诊断工具
		public WebElement lnkDiagnoseTool() throws Exception {
			return obj.getElement(By.linkText("诊断工具"));
		}
	
	//获取诊断表格
		public WebElement tabDiagnose() throws Exception{
			return obj.getElement(By.id("INNER"));
		}
	
	
	//参数文本输入框
	public WebElement parameterText()  throws Exception {
		return obj.getElement(By.xpath(".//*[@id='addroute_form']/table/tbody/tr[2]/td[2]/input"));
	}
	
	//ip地址文本输入框
	public WebElement ipAddressText() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='ip_disp']"));
	}
	
	//测试结果文本框
	public WebElement tsetResult() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='addroute_form']/table/tbody/tr[4]/td[2]"));
	}
	
	//测试按钮
	public WebElement btnTest() throws Exception {
		return obj.getElement(By.id("submit"));
	}

}
