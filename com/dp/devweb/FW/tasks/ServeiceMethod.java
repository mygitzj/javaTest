package dp.devweb.FW.tasks;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import dp.devweb.FW.appobject.ServicePage;
import dp.devweb.FW.appobject.TreeMenuPage;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;
import dp.devweb.common.CommonTable;

/**
 * @Title: Service.java
 * @Description: TODO(对服务页面进行的操作)
 * @author w01866
 * @date 2014年12月9日 下午4:35:27
 * @version V4.4
 */
public class ServeiceMethod extends CommonObjectScript {
	public TreeMenuPage pageTree = new TreeMenuPage();
	public CommonOperator oprCom = new CommonOperator();
	public ServicePage pageSer = new ServicePage();

	
	public boolean goServicePage() throws Exception {
		try {
			oprCom.SwitchToDefault();
			Debug("进入 IP地址 界面");
			Debug("点击 网络管理");
			oprCom.ClickToOpen(pageTree.liNetManagement(),
					pageTree.lnkNetManagement());
			sleep(1);
			Debug("点击 网络对象");
			oprCom.ClickToOpen(pageTree.liNetObject(), pageTree.lnkNetObject());
			Thread.sleep(1000);
			Debug("点击 服务");
			pageTree.lnkService().click();	
			return true;
		}catch (Exception e) {
			Error("进入服务配置界面异常");
			return false;
		}
	}
	
	
	/**
	 * 判断自定义服务对象是否存在
	 * @param name 自定义服务对象名
	 * @return 存在返回true，不存在返回false
	 * @throws Exception
	 */
	public boolean VerifyUserdefindService(String name) throws Exception {
		
		goServicePage();
		// 切换到右侧frame
		oprCom.SwitchToFrame();
		
		Debug("点击 自定义服务对象");
		pageSer.tblUserdefineService().click();

		return CommonTable.isStringExsited(pageSer.tblUserdefine(), name, 1);
	}
	
	/**
	 * 增加自定义服务对象
	 * 
	 * @param name
	 *            自定义服务名称
	 * @param protocol
	 *            自定义服务协议
	 * @param sPort
	 *            TCP、UDP的起始端口号
	 * @param dPort
	 *            TCP、UDP的结束端口号
	 * @throws Exception
	 */
	public void AddUserdefindService(String name, String protocol, int sPorts, int sPortd, 
			int dPorts, int dPortd) throws Exception {
		
		goServicePage();
		
		// 切换到右侧frame
		oprCom.SwitchToFrame();

		Debug("点击 自定义服务对象");
		pageSer.tblUserdefineService().click();
		sleep(2);
		String str = CommonTable.getCellString(pageSer.tblUserdefine(), 0, 1);

		if (str.equals("请配置名称")) {
			Debug("输入自定义服务对象名称： " + name);
			// 根据字符串“请配置名称”确定行
			int row = CommonTable.getRowByColString(pageSer.tblUserdefine(),
					"请配置名称", 1);
			CommonTable.getCellObjByColString(pageSer.tblUserdefine(), "请配置名称", 1,
					1).click();
			oprCom.SendKeys(pageSer.txtUserdefineName(), name);

			Debug("点击 配置内容");
			CommonTable.getCellObject(pageSer.tblUserdefine(), row, 2).click();
			sleep(1);

			Debug("选择协议类型： " + protocol);
			oprCom.Select(pageSer.sltProtocol(), protocol);

			Debug("源端口范围起始： " + sPorts + "\t" + "源端口范围结束： " + sPortd );
			oprCom.SendKeys(pageSer.txtSportStart(), sPorts + "");
			oprCom.SendKeys(pageSer.txtSportEnd(), sPortd  + "");

			Debug("目的端口范围起始： " + dPorts + "\t" + "目的端口范围结束： " + dPortd);
			oprCom.SendKeys(pageSer.txtDportStart(), dPorts + "");
			oprCom.SendKeys(pageSer.txtDportEnd(), dPortd + "");

			Debug("点击 确定");
			pageTree.btnOK().click();

			Debug("点击 确认");
			pageTree.btnConfirm().click();
		} else {
			Debug("增加一条地址对象组数据");
//			pageSer.spnAddUserdefine().click();
			oprCom.JsClick(pageSer.spnAddUserdefine());
			
			Debug("输入自定义服务对象名称： " + name);
			// 根据字符串“请配置名称”确定行
			int row = CommonTable.getRowByColString(pageSer.tblUserdefine(),
					"请配置名称", 1);
//			CommonTable.getCellObjByColString(pageSer.tblUserdefine(), "请配置名称", 1,
//					1).click();
			oprCom.JsClick(CommonTable.getCellObjByColString(pageSer.tblUserdefine(), "请配置名称", 1,1));
			oprCom.SendKeys(pageSer.txtUserdefineName(), name);

			Debug("点击 配置内容");
//			CommonTable.getCellObject(pageSer.tblUserdefine(), row, 2).click();
			oprCom.JsClick(CommonTable.getCellObject(pageSer.tblUserdefine(), row, 2));
			sleep(1);

			Debug("选择协议类型： " + protocol);
			oprCom.Select(pageSer.sltProtocol(), protocol);

			Debug("源端口范围起始： " + sPorts + "\t" + "源端口范围结束： " + sPortd);
			oprCom.SendKeys(pageSer.txtSportStart(), sPorts + "");
			oprCom.SendKeys(pageSer.txtSportEnd(), sPortd + "");

			Debug("目的端口范围起始： " + dPorts + "\t" + "目的端口范围结束： " + dPortd);
			oprCom.SendKeys(pageSer.txtDportStart(), dPorts + "");
			oprCom.SendKeys(pageSer.txtDportEnd(), dPortd + "");

			Debug("点击 确定");
//			pageTree.btnOK().click();
			oprCom.JsClick(pageTree.btnOK());

			Debug("点击 确认");
			pageTree.btnConfirm().click();
		}
	}
	
	/**
	 * 增加服务对象组
	 * @param name 服务对象组名
	 * @throws Exception
	 */
	public void AddServiceGroup(String name,String selServiceObject ,String[] selAvailable) throws Exception {
		goServicePage();

		// 切换到右侧frame
		oprCom.SwitchToFrame();

		Debug("点击 服务对象组");
		pageSer.toplServiceGrp().click();
		sleep(1);

		String str = CommonTable.getCellString(pageSer.tblServiceGrp(), 0, 1);

		if (str.equals("请配置名称")) {
			Debug("输入服务对象组名称： " + name);
			CommonTable.getCellObject(pageSer.tblServiceGrp(), 0, 1).click();
//			CommonTable.getCellObjByColString(pageSer.tblServiceGrp(), "请配置名称", 1, 1)
//					.click();
			oprCom.SendKeys(pageSer.txtServiceName(), name);
			
			Debug("增加成员列表");
//			CommonTable.getCellObjByColString(pageSer.tblServiceGrp(), "请配置名称", 1, 2)
//			.click();
			CommonTable.getCellObject(pageSer.tblServiceGrp(), 0, 2).click();
			Debug("选择服务类型");
			oprCom.Select(pageSer.selService(), selServiceObject);
			
			Debug("在备选项中选择增加到已选项中");	
			int i = (selAvailable.length);
//			System.out.print("*******************************");
//			System.out.print(i);
//			System.out.print("***********************************");
			for(int m=0; m<=i-1; m ++) {
				oprCom.Select(pageSer.selAvailable(), selAvailable[m]);
//				System.out.print(selAvailable[m]);
				oprCom.Click(pageSer.addButton());
			}
			
			Debug("点击确定");
			oprCom.Click(pageSer.buttonOK());
				
			Debug("点击 确认");
			pageTree.btnConfirm().click();
		} else {
			Debug("增加一条地址对象组数据");
//			pageSer.spnAddService().click();
			oprCom.JsClick(pageSer.spnAddServiceGrp());
			sleep(1);
			
			Debug("输入自定义服务对象组名称： " + name);
			// 根据字符串“请配置名称”确定行
			 int row = CommonTable.getRowByColString(pageSer.tblServiceGrp(),
			 "请配置名称", 1);
//			CommonTable.getCellObjByColString(pageSer.tblService(), "请配置名称", 1, 1)
//					.click();
			
			oprCom.JsClick(CommonTable.getCellObject(pageSer.tblServiceGrp(), row, 1));
			oprCom.SendKeys(pageSer.txtServiceName(), name);
			Debug("增加成员列表");
			CommonTable.getCellObject(pageSer.tblServiceGrp(), row, 2).click();
			
			Debug("清空已选项中的内容");
			Select slt = new Select(pageSer.selSelected());
			List<WebElement> slts = slt.getOptions();
			sleep(1);
//			int q = slts.size();
//			System.out.print(q);
			for (int x = 0; x < slts.size(); x++) {
				slt.getOptions().get(0).click();
				sleep(1);
				oprCom.JsClick(pageSer.delButton());
				sleep(1);
			}
			
			Debug("选择服务类型");
			oprCom.Select(pageSer.selService(), selServiceObject);
			
			Debug("在备选项中选择增加到已选项中");	
			int i = (selAvailable.length);	
			for(int m=0; m<= i-1; m ++) {
				oprCom.Select(pageSer.selAvailable(), selAvailable[m]);
				sleep(1);
				oprCom.Click(pageSer.addButton());
				sleep(1);
			}
			sleep(1);
			Debug("点击确定");
			oprCom.JsClick(pageSer.buttonOK1());
			
//			Debug("点击确定");
//			oprCom.Click(pageSer.buttonOK());
			Debug("点击 确认");
			pageTree.btnConfirm().click();
		}
	}
	
	
	
	/**
	 * 自定义服务对象文件导入  
	 */
	public boolean fileImprot() throws Exception {
		try {
			Debug("进入服务配置界面");
			goServicePage();
			sleep(1);
			oprCom.SwitchToFrame();
			sleep(1);
			Debug("进入自定义服务对象界面");
			pageSer.tblUserdefineService().click();
			
			Debug("输入文件路径  D://software//serviceObjGrpImport.exe");
			pageSer.selFilePath().click();
			sleep(1);
			driver.switchTo().defaultContent();
			sleep(1);
			
			//调用autoit程序
			Process process = Runtime.getRuntime().exec("D://software//serviceUserDefindObj.exe");
			process.waitFor();
		    sleep(1);
            oprCom.SwitchToFrame();
			Debug("点击导入按钮");
			pageSer.buttonImport().click();
			sleep(2);
			Debug("弹出成功对话框，点击确定");
			Alert alert = driver.switchTo().alert();
			alert.accept();
//			Actions action = new Actions(driver);
//			sleep(1);
//		    action.keyDown(Keys.ENTER);		
		    return true;
		}catch (Exception e) {
			e.printStackTrace();
			Error("文件导入错误");
			return false;
		}
	}
	
	/**
	 * 文件导出
	 */
	public boolean fileExport() throws Exception {
		try {
			Debug("进入服务配置界面");
			goServicePage();
			oprCom.SwitchToFrame();
			Debug("进入自定义服务对象界面");
			sleep(1);
			pageSer.tblUserdefineService().click();
			Debug("点击文件导出按钮");
			sleep(1);
			oprCom.JsClick(pageSer.buttonExport());
//			pageSer.buttonExport();
//			Actions action = new Actions(driver);
//		    action.keyDown(Keys.ENTER);		
		    return true;			
		}catch (Exception e) {
			e.printStackTrace();
			Error("文件导出错误");	
			return false;
		}
	}
	
	//服务对象组文件导入
	public boolean fileImprotServGrp() throws Exception {
		try {
			Debug("进入服务配置界面");
			goServicePage();
			sleep(1);
			oprCom.SwitchToFrame();
			sleep(1);
			Debug("进入服务对象组界面");
			pageSer.toplServiceGrp().click();
			sleep(1);

			Debug("输入文件路径  D://software//serviceObjGrpImport.exe");
			pageSer.selFilePath().click();
			sleep(1);
			driver.switchTo().defaultContent();
			sleep(1);
			
			//调用autoit程序
			Process process = Runtime.getRuntime().exec("D://software//serviceObjGrpImport.exe");
			process.waitFor();
		    sleep(1);
            oprCom.SwitchToFrame();
			Debug("点击导入按钮");
			pageSer.buttonImport().click();
		    return true;
		}catch (Exception e) {
			e.printStackTrace();
			Error("文件导入错误");
			return false;
		}
	}
	
	
	/**
	 * 服务对象组文件导出
	 */
	public boolean fileExportServGrp() throws Exception {
		try {
			Debug("进入服务配置界面");
			goServicePage();
			oprCom.SwitchToFrame();
			Debug("进入服务对象组界面");
			sleep(1);
//			pageSer.tblUserdefineService().click();
			pageSer.toplServiceGrp().click();
			Debug("点击文件导出按钮");
			sleep(1);
			oprCom.JsClick(pageSer.buttonExport());
//			pageSer.buttonExport();
//			Actions action = new Actions(driver);
//		    action.keyDown(Keys.ENTER);		
		    return true;			
		}catch (Exception e) {
			e.printStackTrace();
			Error("文件导出错误");	
			return false;
		}
	}
	
	
	
}
