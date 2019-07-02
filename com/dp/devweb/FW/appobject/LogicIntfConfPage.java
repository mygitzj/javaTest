package dp.devweb.FW.appobject;

import org.openqa.selenium.WebElement;

import dp.devweb.common.CommonObject;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonTable;



/**   
 * @Title: LogicIntfConfPage.java 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author w01866 
 * @date 2014年12月2日 上午10:05:22 
 * @version V4.4   
 */
public class LogicIntfConfPage extends CommonObjectScript{
	
	// 公共对象类
	public CommonObject objCom = new CommonObject();
	
	/**
	 * top loopback接口配置 
	 * @return loopback接口配置对象
	 * @throws Exception
	 */
	public WebElement tblLoopbackIntfConf() throws Exception{
		return objCom.getElementById("T_Config_LoopInterface");		
	}
	
	/**
	 * loopback接口页面table表
	 * @return table对象
	 * @throws Exception
	 */
	public WebElement tblLoopbackIntf() throws Exception{
		return objCom.getElementById("loopbackInterface");
	}
	
	/**
	 * 文本输入框
	 * @return 文本输入框对象
	 * @throws Exception
	 */
	public WebElement txtLoopback() throws Exception{
		return objCom.getElementById("loopbackinput");
	}
	
	/**
	 * “增加”按键
	 * @return 按键对象
	 * @throws Exception
	 */
	public WebElement spnAddLoopback() throws Exception{
		WebElement obj = CommonTable.getCellObject(tblLoopbackIntf(), 0, 3);
		return objCom.getElementByXpath(obj, "//span[@class='gop GOP_COPY']");
	}
	
	/**
	 * “删除”按键
	 * @return 按键对象
	 * @throws Exception
	 */
	public WebElement spnDelLoopback(int row) throws Exception{
		return objCom.getElementByXpath("//table[@id='loopbackInterface']/tbody/tr[" + (row+1) + "]/td[4]/span[2]");
	}
}
