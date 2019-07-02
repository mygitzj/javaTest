package dp.devweb.FW.appobject;

import org.openqa.selenium.WebElement;

import dp.devweb.common.CommonObject;

/**   
 * @Title: CommonConfigPage.java 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author w01866 
 * @date 2014年12月3日 下午6:55:52 
 * @version V4.4   
 */
public class CommonConfigPage {
	// 公共对象类
	public CommonObject objCom = new CommonObject();
	
	/**
	 * 公共配置页面table
	 * @return table对象
	 * @throws Exception
	 */
	public WebElement tblCommonConfig() throws Exception{
		return objCom.getElementById("grid_basic_cfg");
	}
}
