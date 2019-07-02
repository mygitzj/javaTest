package dp.devweb.FW.appobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dp.devweb.common.CommonObject;

/**
 * 
* @Title: MacAddressPage.java 
* @Description: TODO(mac地址配置界面操作) 
* @author z01674 
* @date 2015年6月16日 下午2:11:20 
* @version V4.4
 */

public class MacAddressPage {
	
	//实例化公共对象
	public CommonObject obj = new CommonObject();
	
	//mac地址对象
	public WebElement topMacAddrObject() throws Exception{
		return obj.getElement(By.id("T_Network_Mac_Obj2"));
	}
	
	//mac组
	public WebElement topMacGroup() throws Exception {
		return obj.getElement(By.id("T_Network_Mac_Group2"));
	}
	
	//mac地址对象表格
	public WebElement tablMacObject() throws Exception {
		return obj.getElement(By.id("mac"));
	}
	
	//mac地址对象复制按钮
	public WebElement copy() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='mac']/tbody/tr/td[6]/span[1]"));
	}
	
	//mac地址对象表格——名称
	public WebElement textNameMac() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='input_name']"));
	}
	
	//mac文本输入框
	public WebElement textMac() throws Exception {
		return obj.getElement(By.id("mac_id"));
	}
	
	//添加按钮
	public WebElement buttonAdd() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='tb_mac_id']/tbody/tr/td[3]/input[1]"));
	}
	
	//加入mac时的删除按钮
	public WebElement buttonDelete() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='tb_mac_id']/tbody/tr/td[3]/input[2]"));
	}
		
	//mac一选项
	public WebElement selectedMac() throws Exception {
		return obj.getElement(By.id("mac_list_id"));
	}
	
	//确定按钮
	public WebElement buttonOK() throws Exception {
		return obj.getElement(By.xpath("html/body/div[4]/div[3]/div/button[1]"));
	}
	
	//导入文本路径选择框
	public WebElement testFilePath() throws Exception {
		return obj.getElement(By.id("select_file"));
	}
	
	//导入按钮
	public WebElement buttonImport() throws Exception {
		return obj.getElement(By.id("import"));
	}
	
	//导出按钮
	public WebElement buttonExport() throws Exception {
		return obj.getElement(By.id("export"));
	}
	
	//删除按钮
	public WebElement delet() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='mac']/tbody/tr[1]/td[6]/span[2]"));
	}
	
	//mac地址对象组表格
	public WebElement tablMacGroup() throws Exception {
		return obj.getElement(By.id("netmac_group_grid"));
	}
	
	//mac地址对象组——复制
	public WebElement copyMacGroup() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='netmac_group_grid']/tbody/tr/td[6]/span[1]"));
	}
	
	//地址对象组名称
	public WebElement textNameMacGroup() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='group_name_input']"));
	}
	
	//mac地址对象组备选项
	public WebElement selAvailableMacGroup() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='group_items_div']/table[3]/tbody/tr[2]/td[1]/select"));
	}
	
	//mac地址对象组——增加按钮
	public WebElement buttonAddMacGroup() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='group_items_div']/table[3]/tbody/tr[2]/td[2]/button[1]"));
	}
	
	//mac地址对象组——删除按钮
	public WebElement buttonDelMacGroup() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='group_items_div']/table[3]/tbody/tr[2]/td[2]/button[2]"));
	}
	
	//mac地址对象组——已选项
	public WebElement selSelectedMacGroup() throws Exception {
		return obj.getElement(By.xpath(".//*[@id='group_items_div']/table[3]/tbody/tr[2]/td[3]/select"));
	}
	
	//mac地址对象组——确定按钮
	public WebElement buttonOKMacGroup() throws Exception {
		return obj.getElement(By.xpath("html/body/div[4]/div[3]/div/button[1]"));
	}                                   
	                                  
}
