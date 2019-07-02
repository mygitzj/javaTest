package dp.devweb.FW.appobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dp.devweb.common.CommonObject;
import dp.devweb.common.CommonObjectScript;

/**
 * 
* @Title: Ipv6AddrPage.java 
* @Description: TODO(Ipv6地址配置界面) 
* @author z01674 
* @date 2015年6月15日 下午3:07:10 
* @version V4.4
 */

public class Ipv6AddrPage extends CommonObjectScript{
	
	public CommonObject obj = new CommonObject();
	
	/**
	 * IPv6地址对象表格
	 */
	public WebElement tblIPv6AddrObj() throws Exception {
		return obj.getElement(By.id("table3"));
	}
	
	/**
	 * button复制
	 */
	public WebElement buttonCopy() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='table3']/tbody/tr[1]/td[6]/span[1]"));
	}
    
	/**
	 * 名称输入框
	 */
	public WebElement textName() throws Exception {
		return obj.getElement(By.id("input_name"));
	}
	
	/**
	 * 导出按钮
	 */
	public WebElement buttonExport() throws Exception {
//		return obj.getElement(By.id("export"));
		return obj.getElement(By.xpath(".//*[@id='export']"));
	}
	
	/**
	 * 导入按钮
	 */
	public WebElement buttonImport() throws Exception {
		return obj.getElement(By.id("import"));
	}
	
	/**
	 * 文件导入路径
	 */
	public WebElement pathFile() throws Exception {
		return obj.getElement(By.id("select_file"));
	}
	
	/**
	 * 全部删除
	 */
	public WebElement butDelAll() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='del_all_btn']"));
	}
}
