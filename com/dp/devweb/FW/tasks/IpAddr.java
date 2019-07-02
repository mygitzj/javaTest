package dp.devweb.FW.tasks;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.gargoylesoftware.htmlunit.javascript.host.ActiveXObject;

import dp.devweb.FW.appobject.IpAddrPage;
import dp.devweb.FW.appobject.TreeMenuPage;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;
import dp.devweb.common.CommonTable;

/**
 * @Title: IpAddr.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author w01866
 * @date 2014年12月8日 上午11:16:55
 * @version V4.4
 */
public class IpAddr extends CommonObjectScript {
	public TreeMenuPage pageTree = new TreeMenuPage();
	public IpAddrPage pageIp = new IpAddrPage();
	public CommonOperator oprCom = new CommonOperator();
	
	public boolean goIpAddrPage() throws Exception {
		try {
			// 切换到左侧windows
			oprCom.SwitchToDefault();

			Debug("进入 IP地址 页面");
			Debug("点击 网络管理 → 网络对象 → ip地址");
			oprCom.ClickToOpen(pageTree.liNetManagement(),
					pageTree.lnkNetManagement());
			Thread.sleep(1000);
			oprCom.ClickToOpen(pageTree.liNetObject(), pageTree.lnkNetObject());
			Thread.sleep(1000);
			pageTree.lnkIpAddr().click();
			return true;
		} catch (Exception e) {
			Error("进入IP地址 页面异常");
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 判断IP地址对象是否存在
	 * 
	 * @param name
	 *            IP地址对象名
	 * @return 存在返回true，不存在返回false
	 * @throws Exception
	 */
	public boolean VerifyAddrObject(String name) throws Exception {
		//进入默认配置界面
		oprCom.SwitchToDefault();
		
		// 进入 地址对象 页面
		goIpAddrPage();

		// 切换到右侧frame
		oprCom.SwitchToFrame();
		Debug("查看IP地址对象是否存在：" + name);
		return CommonTable.isStringExsited(pageIp.tblAddrObject(), name, 1);
	}

	/**
	 * 增加ip地址对象 地址/掩码
	 * 
	 * @param name
	 *            ip地址对象名称
	 * @param ip
	 *            ip地址
	 * @param mask
	 *            子网掩码
	 * @param expIp
	 *            例外IP
	 * @param expMask
	 *            例外子网掩码
	 * @return
	 * @throws Exception
	 */
	public boolean AddAddrObject(String name, String ip, String mask,
			String expIp, String expMask) throws Exception {
		
		goIpAddrPage();

		// 切换到右侧frame
		oprCom.SwitchToFrame();

		Debug("点击 增加一条地址对象信息");
		pageIp.spnAddIpAddr().click();

		Debug("输入名称： " + name);
		int counts = CommonTable.getRowCounts(pageIp.tblAddrObject());
		CommonTable.getCellObject(pageIp.tblAddrObject(), counts - 1, 1)
				.click();
		oprCom.SendKeys(pageIp.txtAddrObjectName(), name);

		// 点击其他区域，触发错误提示窗口
		CommonTable.getCellObject(pageIp.tblAddrObject(), counts - 1, 4)
				.click();

		// 判断地址名是否合法
		try {
			Alert alert = driver.switchTo().alert();
			if (alert.getText().contains("非法字符")) {
				Debug("成功判断非法字符： " + name);
				alert.accept();
				// 清空文本
				pageIp.txtAddrObjectName().clear();
				return false;
			}
		} catch (Exception e) {
		}

		if (ip != null) {
			Debug("点击内容，切换至IP地址/掩码");
			CommonTable.getCellObject(pageIp.tblAddrObject(), counts - 1, 2)
					.click();
			sleep(1);
			pageIp.rdoIpAndMask().click();

			Debug("输入IP地址/掩码： " + ip + "/" + mask);
			oprCom.SendKeys(pageIp.txtIp(), ip);
			oprCom.Select(pageIp.sltMask(), mask);

			if (expIp != null) {
				oprCom.SendKeys(pageIp.txtExpIp(), expIp);
				pageIp.btnAppend2().click();

				// 判断例外IP是否合法
				try {
					Alert alert = driver.switchTo().alert();
					if (alert.getText().contains(
							"IPv4地址必须为点分十进制格式，且四个段的数字都不能超过255")
							|| alert.getText().contains("例外IP不在IP地址范围内")) {
						Debug("成功判断例外IP不合法 ");
						alert.accept();
						return false;
					}
				} catch (Exception e) {
				}

			}

			Debug("点击 确定");
			pageTree.btnOK().click();

			try {
				Alert alert = driver.switchTo().alert();
				if (alert.getText()
						.contains("IPv4地址必须为点分十进制格式，且四个段的数字都不能超过255")) {
					Debug("成功判断IP地址不合法 ");
					alert.accept();
					return false;
				}
			} catch (Exception e) {
			}
		}

		Debug("点击 确认");
		pageTree.btnConfirm().click();
		
		

		// 判断安全域名是否合法
		try {
			Alert alert = driver.switchTo().alert();
			if (alert.getText().contains("请输入名称")) {
				Debug("成功判断空名称 ");
				alert.accept();
				return false;
			}
		} catch (Exception e) {
		}
		return true;
	}

//	public boolean goIpAddrPage() throws Exception {
//		try {
//			// 切换到左侧windows
//			oprCom.SwitchToDefault();
//
//			Debug("进入 IP地址 界面");
//			Debug("点击 网络管理 → 网络对象 → ip地址");
//			oprCom.ClickToOpen(pageTree.liNetManagement(),
//					pageTree.lnkNetManagement());
//			Thread.sleep(1000);
//			oprCom.ClickToOpen(pageTree.liNetObject(), pageTree.lnkNetObject());
//			Thread.sleep(1000);
//			pageTree.lnkIpAddr().click();
//			
//			return true;
//		}catch (Exception e) {
//			Error("进入IP地址页面异常");
//			return false;
//		}
//		
//	}
	
	public boolean AddAddrObjectArea(String name, String startIp, String endIp,
			String startExpIp, String endExpIp) throws Exception {
		
		try {
			oprCom.SwitchToDefault();
			goIpAddrPage();
			// 切换到右侧frame
			oprCom.SwitchToFrame();
		
			Debug("点击 增加一条地址对象信息");
			oprCom.JsClick(pageIp.spnAddIpAddr());
			
			Debug("输入名称： " + name);
			int counts = CommonTable.getRowCounts(pageIp.tblAddrObject());
			oprCom.JsClick(CommonTable.getCellObject(pageIp.tblAddrObject(), counts - 1, 1));
			oprCom.SendKeys(pageIp.txtAddrObjectName(), name);

			// 点击其他区域，触发错误提示窗口
			CommonTable.getCellObject(pageIp.tblAddrObject(), counts - 1, 4)
					.click();
			
			if(startIp != null) {
				Debug("点击内容 → IP地址范围");
				CommonTable.getCellObject(pageIp.tblAddrObject(), counts - 1, 2)
						.click();
				sleep(1);
				pageIp.rdoIpArea().click();

				Debug("输入IP地址范围起始IP： " + startIp + "\t" + "IP地址范围结束IP： " + endIp);
				oprCom.SendKeys(pageIp.txtRangeStartIp(), startIp);
				oprCom.SendKeys(pageIp.txtRangeEndIp(), endIp);
				Debug("输入例外IP地址起始IP： " + startExpIp + "\t" + "例外IP地址结束IP： " + endExpIp);
				oprCom.SendKeys(pageIp.txtExpRangeStartIp(), startExpIp);
				oprCom.SendKeys(pageIp.txtExpRangeEndIp(), endExpIp);

				Debug("点击 添加");
				pageIp.btnAppend1().click();
			
			}
			Debug("点击 确认");
			pageTree.btnConfirm().click();
			return true;
		}catch(Exception e) {
			Error("增加IP地址对象异常");
			return false;
			}
		
	}

	/**
	 * 增加地址对象组
	 * 
	 * @param grpName
	 *            组名称
	 * @param names
	 *            地址对象名
	 * @throws Exception
	 */
	public void AddAddrObjectGpr(String grpName, String[] names)
			throws Exception {
		goIpAddrPage();

		// 切换到右侧frame
		oprCom.SwitchToFrame();

		Debug("点击 地址组对象");
		pageIp.tblTopAddrObjectGrp().click();
		sleep(1);

		// 定义变量，用于传递表格行数变量
//		int counts = 0;
		
		
		String str = CommonTable.getCellString(pageIp.tblAddrObjectGrp(), 0, 1);
		

		if (str.equals("请输入名称")) {
			Debug("输入地址对象组名称： " + grpName);
			CommonTable.getCellObject(pageIp.tblAddrObjectGrp(), 0, 1).click();
//			pageIp.txtAddrObjectGrpName().clear();
			pageIp.txtAddrObjectGrpName().sendKeys(grpName);

			CommonTable.getCellObject(pageIp.tblAddrObjectGrp(), 0, 2).click();
			sleep(2);
			
			for (int i = 0; i < names.length; i++) {
				Debug("选择地址对象： " + names[i]);
				oprCom.Select(pageIp.sltAddrObject(), names[i]);
				pageIp.btnAdd().click();
				sleep(1);
			}

			Debug("点击 确定");
			pageTree.btnOK().click();

			Debug("点击 确认");
			pageTree.btnConfirm().click();
		} else {
			Debug("增加一条地址对象组数据");
			oprCom.JsClick(pageIp.spnAddIpAddrGrp());
//			pageIp.spnAddIpAddrGrp().click();
 
			sleep(2);
			// 传递表格行数
			int counts = CommonTable.getRowCounts(pageIp.tblAddrObjectGrp());

			Debug("输入地址对象组名称： " + grpName);
			oprCom.JsClick(CommonTable.getCellObject(pageIp.tblAddrObjectGrp(), counts -1 , 1));
//			CommonTable.getCellObject(pageIp.tblAddrObjectGrp(), counts -1 , 1)
//					.click();
//			pageIp.txtAddrObjectGrpName().clear();
			pageIp.txtAddrObjectGrpName().sendKeys(grpName);

			oprCom.JsClick(CommonTable.getCellObject(pageIp.tblAddrObjectGrp(), counts -1, 2));
//			CommonTable.getCellObject(pageIp.tblAddrObjectGrp(), counts -1, 2)
//					.click();
			sleep(1);

			// 清空已选地址对象
			Select slt = new Select(pageIp.sltAddrObjectSelected());
			List<WebElement> slts = slt.getOptions();
			for (int i = 0; i < slts.size(); i++) {
				slt.getOptions().get(0).click();
				sleep(1);
				oprCom.JsClick(pageIp.btnDel());
//				pageIp.btnDel().click();
				sleep(1);
			}

			for (int i = 0; i < names.length; i++) {
				Debug("选择地址对象： " + names[i]);
				oprCom.Select(pageIp.sltAddrObject(), names[i]);
				oprCom.JsClick(pageIp.btnAdd());
				sleep(1);
//				pageIp.btnAdd().click();
			}

			Debug("点击 确定");
//			pageTree.btnOK().click();
			oprCom.JsClick(pageTree.btnOK());

			Debug("点击 确认");
			pageTree.btnConfirm().click();
		}
	}

	public boolean DeleteAddrObject(String name) throws Exception {
		goIpAddrPage();

		// 切换到右侧frame
		oprCom.SwitchToFrame();

		Debug("删除IP地址" + name);
		pageIp.spnDel(name).click();

		Debug("点击 确认");
		pageTree.btnConfirm().click();
		return true;
	}
	
	/**
	 * @param path
	 * @return 导入地址对象
	 * @throws Exception
	 */
	
	public boolean ImportIpAddrObj(String path) throws Exception {
		try {
			goIpAddrPage();

			// 切换到右侧frame
			oprCom.SwitchToFrame();

			Debug("导入文件" + path);
			pageIp.btnSelectFile().sendKeys(path);
		
			Debug("点击导入按钮");
			pageIp.btnImport().click();
			sleep(10);
//		pageIp.btnImport().click();

		// 判断例外IP是否合法
		
//			Alert alert = driver.switchTo().alert();
//			if (alert.getText().contains("IPv4地址必须为点分十进制格式，且四个段的数字都不能超过255")
//					|| alert.getText().contains("例外IP不在IP地址范围内")
//					|| alert.getText().contains("结束IP大于起始IP")) {
//				Debug("成功判断例外IP不合法 ");
//				alert.accept();
				return true;
		}catch(Exception e) {
			return false;
		}
		
	}
	
	

	/**
	 * 导出地址对象
	 */
	public boolean ExportIpAddrObject() throws Exception {
		try{
			goIpAddrPage();

			// 切换到右侧frame
			oprCom.SwitchToFrame();
			
			//点击导出
			oprCom.JsClick(pageIp.btnExport());
			sleep(2);
			Actions action = new Actions(driver);
		    action.keyDown(Keys.ENTER);	
			return true;
		}catch (Exception e) {
			Error("导出Ip地址对象异常");
			return false;
		}
	}
	
	
	/**
	 * 全部删除
	 */
	public boolean deltAll() throws Exception {
		try {
			
			goIpAddrPage();

			// 切换到右侧frame
			oprCom.SwitchToFrame();
			
			//点击全部删除
			oprCom.JsClick(pageIp.deleAll());
			
			Alert alert = driver.switchTo().alert();
			alert.accept();		
			return true;
		}catch (Exception e) {
			Error("全部删除异常");
			return false;
		}
	}
	
	
	/**
	 * 导出地址对象组
	 */
	public boolean ExportIpAddrObjectGrp() throws Exception {
		try{
			goIpAddrPage();
			// 切换到右侧frame
			oprCom.SwitchToFrame();
			sleep(1);

			Debug("点击 地址组对象");
			pageIp.tblTopAddrObjectGrp().click();
			sleep(1);
			
			//点击导出
			oprCom.JsClick(pageIp.btnExport());
			sleep(2);
			Actions action = new Actions(driver);
		    action.keyDown(Keys.ENTER);	
			return true;
		}catch (Exception e) {
			Error("导出Ip地址对象异常");
			return false;
		}
	}
	
	
//	public boolean Run(String strPath) throws Exception {
//		try{
//		    var objShell= new ActiveXObject("wscript.shell");
//			objShell.Run(strPath);
//			objShell = null;
//			return true;
//		}catch(Exception e){
//			e.printStackTrace();
//			alert("找不到文件"+ strPath+"请确定路径或文件名称是否正确");
//			return false;
//		}
//	}
//	
	
	/**
	 * 导入地址对象组
	 */
	public boolean ImportAddrObjectGrp(String path) throws Exception {
		try {
			goIpAddrPage();

			// 切换到右侧frame
			oprCom.SwitchToFrame();
			
			Debug("点击 地址组对象");
			pageIp.tblTopAddrObjectGrp().click();
			
			Debug("导入文件" + path);
			
			Debug("点击文件选择按钮");
			pageIp.filePathAddrGrp().click();
			sleep(2);
		
			driver.switchTo().defaultContent();
			sleep(2);
						
//			System.out.println(pageIp.filePathAddrGrp().getAttribute("onchange"));
//			pageIp.filePathAddrGrp().sendKeys(path);
//			pageIp.btnSelectFile().sendKeys(path);
		
			//调用autoit程序
			Process process = Runtime.getRuntime().exec("D://software//upfile.exe");
//			System.out.printf("Subprocess object:%x\n", process);
			process.waitFor();
		    sleep(1);
            oprCom.SwitchToFrame();

			Debug("点击导入按钮");
			oprCom.JsClick(pageIp.btnImport());
			
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			Error("导入地址对象组错误");
			return false;
		}
	}
	
	
}