package dp.devweb.FW.appobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dp.devweb.common.CommonObject;
import dp.devweb.common.CommonObjectScript;

/**
 * 
* @Title: RoutingTablePage.java 
* @Description: TODO(获取路由表页面元素) 
* @author z01674 
* @date 2015年4月23日 下午5:01:38 
* @version V4.4
 */

public class RoutingTablePage extends CommonObjectScript {

	//公共对象类
	public CommonObject obj= new CommonObject();
	
	//路由表表格
    public WebElement tabUnicastIpv4Route() throws Exception {
    	return obj.getElement(By.id("Route_List"));
    }
	
    //显示路由表基本信息对象
	  public  WebElement  basicRoutingTable() throws Exception {
		return obj.getElement(By.id("Basic Routing Table"));
	}
  

}
