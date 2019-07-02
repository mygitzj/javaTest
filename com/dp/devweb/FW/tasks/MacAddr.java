package dp.devweb.FW.tasks;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import dp.devweb.FW.appobject.MacAddressPage;
import dp.devweb.FW.appobject.TreeMenuPage;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;
import dp.devweb.common.CommonTable;

public class MacAddr extends CommonObjectScript{
	public CommonOperator opr = new CommonOperator();
	
	public MacAddressPage pMacAddr = new MacAddressPage();
	public TreeMenuPage pTree = new TreeMenuPage();
	
	/**
	 * 进入mac地址配置界面
	 */
	public boolean goMacAddr() throws Exception{
		try{
			opr.SwitchToDefault();
			//网络管理-网络对象-mac地址
			opr.ClickToOpen(pTree.liNetManagement(), pTree.lnkNetManagement());
			sleep(1);
			opr.ClickToOpen(pTree.liNetObject(), pTree.lnkNetObject());
			sleep(1);
			opr.Click(pTree.lnkMacAddr());	
			return true;
		}catch(Exception e) {
		Error("进入mac地址配置界面异常");
		return false;
		}
	}
	
	/**
	 * 增加mac地址对象
	 */
	public boolean addMacAddrObj(String name , String[] macs) throws Exception {
		try {
			goMacAddr();
			opr.SwitchToFrame();
			//确定是否已经存在mac地址
			String str = CommonTable.getCellString(pMacAddr.tablMacObject(), 0 , 1);
			if (str.equals("请输入名称")) {
				opr.Click(CommonTable.getCellObject(pMacAddr.tablMacObject(), 0, 1));
				pMacAddr.textNameMac().sendKeys(name);
				opr.Click(CommonTable.getCellObject(pMacAddr.tablMacObject(), 0, 2));
				sleep(2);
				for(int i=0; i<macs.length; i++) {
					pMacAddr.textMac().clear();
					pMacAddr.textMac().sendKeys(macs[i]);
					sleep(1);
					opr.Click(pMacAddr.buttonAdd());
				}
				opr.Click(pMacAddr.buttonOK());		
			}else {
				//点击复制
				pMacAddr.copy().click();
				//确定复制的在哪一行
				int count = CommonTable.getRowByColString(pMacAddr.tablMacObject(), "请输入名称", 1);
				opr.Click(CommonTable.getCellObject(pMacAddr.tablMacObject(), count , 1));
				pMacAddr.textNameMac().sendKeys(name);
				opr.Click(CommonTable.getCellObject(pMacAddr.tablMacObject(), count , 2));
				sleep(2);
				
				//清除已存在的mac地址
				Select slt = new Select(pMacAddr.selectedMac());
				List<WebElement> slts = slt.getOptions();
				for (int i = 0; i < slts.size(); i++) {
					slt.getOptions().get(0).click();
					pMacAddr.buttonDelete().click();
					sleep(1);
				}
				
				//增加mac
				for(int i=0; i<macs.length; i++) {
					pMacAddr.textMac().clear();
					pMacAddr.textMac().sendKeys(macs[i]);
					sleep(1);
					opr.Click(pMacAddr.buttonAdd());
				}
				opr.Click(pMacAddr.buttonOK());	
			}
			//点击确认
			opr.Click(pTree.btnConfirm());
			return true;
		}catch (Exception e) {
			Error("增加mac地址对象异常");
			return false;
		}
	}
	
	/**
	 * 导出文件
	 */
	public boolean exportFile() throws Exception {
		try{
			goMacAddr();
			opr.SwitchToFrame();
			//点击导出
			opr.JsClick(pMacAddr.buttonExport());
//			pMacAddr.buttonExport().click();
			return true;
		}catch (Exception e) {
			Error("文件导出错误");
			return false;
		}
	}
	
	/**
	 * 文件导入
	 */
	public boolean importFile(String path) throws Exception {
		try{
			goMacAddr();
			opr.SwitchToFrame();
			pMacAddr.testFilePath().sendKeys(path);
			sleep(2);
			pMacAddr.buttonImport().click();	
			return true;
		}catch (Exception e) {
			Error("文件导入错误");
			return false;
		}
	}
	
	/**
	 * 删除全部已经存在的mac地址对象
	 */
	public boolean deleAllMac() throws Exception {
		try{
			goMacAddr();
			opr.SwitchToFrame();
			//确定表格中mac地址对象的数量
			int count = CommonTable.getRowCounts(pMacAddr.tablMacObject());
			for(int i=0;i<=count;i++) {
				opr.Click(pMacAddr.delet());
				//点击确认
				pTree.btnConfirm().click();
				sleep(2);
			}			
			return true;
		}catch (Exception e) {
			Error("全部删除错误");
			return false;
		}
	}
	
	/**
	 * 增加mac组
	 */
	public boolean addMacGroup(String name,String[] mac) throws Exception {
		try {
			goMacAddr();
			opr.SwitchToFrame();
			pMacAddr.topMacGroup().click();
			
			//判断是否存在mac组
			String str = CommonTable.getCellString(pMacAddr.tablMacGroup(), 0, 1);
			if(str.equals("请输入名称")) {
				CommonTable.getCellObject(pMacAddr.tablMacGroup(), 0, 1).click();
				Debug("输入mac组名称");
				opr.SendKeys(pMacAddr.textNameMacGroup(), name);
				CommonTable.getCellObject(pMacAddr.tablMacGroup(), 0, 2).click();
				Debug("选择mac地址对象");
				for(int i=0;i<=mac.length;i++) {
					opr.Select(pMacAddr.selAvailableMacGroup(), mac[i]);
					sleep(1);
					opr.Click(pMacAddr.buttonAddMacGroup());
					sleep(1);
					Debug("点击确定");
					pMacAddr.buttonOKMacGroup().click();
				}
				Debug("点击确认");
				pTree.btnConfirm().click();
				
			}else {
				//点击复制按钮
				opr.Click(pMacAddr.copyMacGroup());
				int count =CommonTable.getRowByColString(pMacAddr.tablMacGroup(), "请输入名称", 1);
				CommonTable.getCellObject(pMacAddr.tablMacGroup(), count-1, 1).click();
				Debug("输入mac组名称");
				opr.SendKeys(pMacAddr.textNameMac(), name);
				CommonTable.getCellObject(pMacAddr.tablMacGroup(), count-1, 2).click();
				Debug("选择mac地址对象");
				for(int i=0;i<=mac.length; i++) {
					opr.Select(pMacAddr.selAvailableMacGroup(), mac[i]);
					sleep(1);
					opr.Click(pMacAddr.buttonAddMacGroup());
					sleep(1);
					Debug("点击确定");
					pMacAddr.buttonOKMacGroup().click();
				}
				Debug("点击确认");
				pTree.btnConfirm().click();
			}				
			return true;
		}catch (Exception e) {
			Error("增加mac组异常");
			return false;
		}
	}
	
	
	
	
}
