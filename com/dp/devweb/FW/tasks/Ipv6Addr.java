package dp.devweb.FW.tasks;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import dp.devweb.FW.appobject.Ipv6AddrPage;
import dp.devweb.FW.appobject.TreeMenuPage;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;
import dp.devweb.common.CommonTable;

/**
 * 
* @Title: Ipv6Addr.java 
* @Description: TODO(IPv6地址页面操作) 
* @author z01674 
* @date 2015年6月15日 下午3:28:15 
* @version V4.4
 */
public class Ipv6Addr extends  CommonObjectScript{
	public CommonOperator opr = new CommonOperator();
	public TreeMenuPage pTree = new TreeMenuPage();
	public Ipv6AddrPage pIPv6 = new Ipv6AddrPage();
	
	//进入Ipv6地址配置界面
	public boolean goIpv6AddrPage() throws Exception {
		try {
			opr.SwitchToDefault();
			//网络管理-网络对象-Ipv6地址
			opr.ClickToOpen(pTree.liNetManagement(), pTree.lnkNetManagement());
			sleep(1);
			opr.ClickToOpen(pTree.liNetObject(), pTree.lnkNetObject());
			sleep(1);
			opr.Click(pTree.lnkIpv6Addr());
			sleep(1);
			return true;
		}catch (Exception e) {
			Error ("进入ipv6配置界面异常");
			return false;
		}
	}
	
	//增加Ipv6地址对象
	public boolean addIpv6AddrObj(String name) throws Exception {
		try {
			goIpv6AddrPage();
			opr.SwitchToFrame();
			//点击复制
			opr.Click(pIPv6.buttonCopy());
			//确定复制的在哪一行
			int count=CommonTable.getRowCounts(pIPv6.tblIPv6AddrObj());
//			System.out.print(count);
			sleep (1);
			opr.Click(CommonTable.getCellObject(pIPv6.tblIPv6AddrObj(), count-1, 1));
			sleep(1);
			opr.SendKeys(pIPv6.textName(), name);
			opr.Click(CommonTable.getCellObject(pIPv6.tblIPv6AddrObj(), count-1, 3));
			//点击确认
			opr.Click(pTree.btnConfirm());
			return true;
		}catch (Exception e) {
			Error("增加Ipv6地址异常");
			return false;
		}
		
	}
	
	/**
	 * 文件导入
	 */
	public boolean importFile(String path) throws Exception {
		try {
			goIpv6AddrPage();
			opr.SwitchToFrame();
			sleep(1);
			Debug("输入导入文件路径" + path);
			pIPv6.pathFile().sendKeys(path);
//			opr.SendKeys(pIPv6.pathFile(), path);
			sleep(1);
			Debug("点击导入按钮");
			opr.JsClick(pIPv6.buttonImport());
			return  true;
		}catch (Exception e) {
			Error("导入文件错误");
			return false ;
		}
	}
	
	/**
	 * 文件导出
	 */
	public boolean exportFile() throws Exception {
		try{
			goIpv6AddrPage();
			opr.SwitchToFrame();
			sleep(2);
			Debug("点击导出");
//			pIPv6.buttonExport().click();
			opr.JsClick(pIPv6.buttonExport());
			sleep(5);
			Actions action = new Actions(driver);
		    action.keyDown(Keys.ENTER);		
			return true;
		}catch (Exception e) {
			Error("导出文件异常");
			return false;
		}
	}
	
	/**
	 * 全部删除
	 */
	public boolean deleAll() throws Exception {
		try{
			goIpv6AddrPage();
			opr.SwitchToFrame();
			sleep(2);
			Debug("点击全部删除");
			pIPv6.butDelAll().click();
			return true;
		}catch (Exception e) {
			Error("导出文件异常");
			return false;
		}
	}

}
