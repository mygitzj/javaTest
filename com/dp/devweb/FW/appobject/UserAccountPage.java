package dp.devweb.FW.appobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dp.devweb.common.CommonObject;

/**
 * 
* @Title: UserAccountPage.java 
* @Description: TODO(账号对象界面元素) 
* @author z01674 
* @date 2015年6月18日 下午2:48:03 
* @version V4.4
 */

public class UserAccountPage {
	public CommonObject obj = new CommonObject();
	
	//账号对象表格
	public WebElement tablUserAccount() throws Exception {
		return obj.getElement(By.id("netuser_grid"));
	}
	
	//名称文本输入框
	public WebElement textName() throws Exception {
		return obj.getElement(By.id("name_input"));
	}
	
	//复制按钮
	public WebElement buttonCopy() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='netuser_grid']/tbody/tr[1]/td[5]/span[1]"));
	}
	
	//账号文本输入框
	public WebElement textAccountName() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='account_byhand_id']"));
	}
	
	//实名文本输入框
	public WebElement textRealName() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='realname_byhand_id']"));
	}
	
	//IP文本输入框
	public WebElement textIP() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='ipaddr_byhand_id']"));
	}
	
	//手动添加按钮
	public WebElement butUserAdd() throws Exception {
		return obj.getElement(By.id("net_user_add_byhand_btn"));
	}
	
	//添加按钮
	public WebElement butAdd() throws Exception {
		return obj.getElement(By.id("net_user_add_btn"));
	}
	
	//删除按钮
	public WebElement butDel() throws Exception {
		return obj.getElement(By.id("net_user_del_btn"));
	}
	
	//确定按钮
	public WebElement buttonOk() throws Exception {
		return obj.getElement(By.xpath("html/body/div[4]/div[3]/div/button[1]"));
	}
	
	//取消按钮
	public WebElement buttonCancel() throws Exception {
		return obj.getElement(By.xpath("html/body/div[4]/div[3]/div/button[2]"));
	}
	
	//导入文件路径
	public WebElement selFilePath() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='ex-import']/input[1]"));
	}
	
	//文件导入按钮
	public WebElement buttonImport() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='ex-import']/input[2]"));
	}
	
	//文件导出按钮
	public WebElement buttonExport() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='ex-import']/input[3]"));
	}
	
}
