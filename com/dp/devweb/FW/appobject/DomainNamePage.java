package dp.devweb.FW.appobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dp.devweb.common.CommonObject;

/**
 * 
* @Title: DomainNamePage.java 
* @Description: TODO(域名界面元素) 
* @author z01674 
* @date 2015年6月17日 下午7:30:02 
* @version V4.4
 */

public class DomainNamePage {
	public CommonObject obj = new CommonObject();
	
	//复制按钮
	public WebElement buttonCopy() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='netdns']/tbody/tr[1]/td[4]/span[1]"));
	}
   
	//域名表格对象
	public WebElement tablDomainName() throws Exception {
		return obj.getElement(By.id("netdns"));
	}
	
	//域名文本输入框
	public WebElement textName() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='nameInput']"));
	}
	
	//文件导出按钮
	public WebElement buttonExport() throws Exception {
		return obj.getElement(By.id("export"));
	}
	
	//文件导入路径
	public WebElement filePath() throws Exception {
		return obj.getElement(By.id("select_file"));
	}
	
	//文件导入按钮
	public WebElement buttonImport() throws Exception {
		return obj.getElement(By.id("import"));
	}
}
