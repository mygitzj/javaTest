package dp.devweb.FW.tasks;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import dp.devweb.FW.appobject.SslVpnPage;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;

/**
 * 
* @Title: SslVpn.java 
* @Description: TODO(对SslVpn页面的操作) 
* @author z01674 
* @date 2015年7月2日 下午3:00:38 
* @version V4.4
 */

public class SslVPN extends CommonObjectScript{
	public SslVpnPage pSSl = new SslVpnPage();
	public CommonOperator opr = new CommonOperator();
	
	/**
	 * 登陆界面
	 */
	
	public boolean login() throws Exception {
		try {
//			Debug("点击继续浏览此网站");
//			opr.Click(pSSl.buttonGO());
			sleep(1);
			Debug("输入用户名");
			opr.SendKeysNoClear(pSSl.textUserName(), "test");
			Debug("输入密码");
			opr.SendKeysNoClear(pSSl.textPassword(), "test");
			Debug("点击登陆按钮");
			opr.Click(pSSl.buttonLogin());
			return true;
		}catch (Exception e) {
			Error("登陆页面异常");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean logoutvpn() throws Exception {
		try {
			Debug("退出页面");
//			opr.Click(pSSl.buttonLogOut());
			pSSl.buttonLogOut().click();
			sleep(2);			
			Debug("弹出成功对话框，点击确定");			
//			Actions action = new Actions(driver);
//		    action.keyDown(Keys.ENTER);			
			Alert alert = driver.switchTo().alert();
			alert.accept();
			return true;
		}catch (Exception e) {
			Error("退出sslvpn页面异常");
			e.printStackTrace();
			return false;
		}
	}
		
	}
