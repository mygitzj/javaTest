package dp.devweb.FW.appobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dp.devweb.common.CommonObject;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;

public class ConfigFilePage extends CommonObjectScript{
	
	//实例化公共对象
	public CommonObject obj = new CommonObject();
	public CommonOperator opr = new CommonOperator();
	
	/**
	 * 文件导入路径选择框
	 */    
	public WebElement textFilePath() throws Exception {
		return obj.getElement(By.id("select_file"));
	}
	
	/**
	 * button 文件下载
	 */
	public WebElement buttDownload() throws Exception {
		return obj.getElement(By.id("downapp"));
	}
	
}
