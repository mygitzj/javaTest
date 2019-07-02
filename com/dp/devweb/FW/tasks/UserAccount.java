package dp.devweb.FW.tasks;

import dp.devweb.FW.appobject.TreeMenuPage;
import dp.devweb.FW.appobject.UserAccountPage;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;
import dp.devweb.common.CommonTable;

/**
 * 
* @Title: UserAccount.java 
* @Description: TODO(账号对象页面操作) 
* @author z01674 
* @date 2015年6月18日 下午4:46:07 
* @version V4.4
 */

public class UserAccount extends CommonObjectScript{
	public CommonOperator opr = new CommonOperator();
	public UserAccountPage pUacc = new UserAccountPage();
	public TreeMenuPage pTree =new  TreeMenuPage();
	
	//进入账号对象页面
	public boolean goUserAccount() throws Exception {
		try {
			opr.SwitchToDefault();
			//网络管理-网络对象-账号对象
			opr.ClickToOpen(pTree.liNetManagement(), pTree.lnkNetManagement());
			sleep(1);
			opr.ClickToOpen(pTree.liNetObject(), pTree.lnkNetObject());
			sleep(1);
			pTree.lnkUserAccount().click();		
			return true;
		}catch (Exception e) {
			Error("进入账号对象页面错误");
			e.printStackTrace();
			return false;
		}
	}
	
	//增加账号对象
	public boolean addUserAccound(String name ,String accountname,String realname,String ip ) throws Exception {
		try {
			goUserAccount();
			opr.SwitchToFrame();
			//判断是否已经存在账号对象
			String str = CommonTable.getCellString(pUacc.tablUserAccount(), 0, 1);
			if(str.equals("请输入名称")) {
				//不存在账号对象
				Debug("输入名称");
				CommonTable.getCellObject(pUacc.tablUserAccount(), 0, 1).click();
				opr.SendKeys(pUacc.textName(), name);
				sleep(1);
				Debug("输入账号名称");
				CommonTable.getCellObject(pUacc.tablUserAccount(), 0, 2).click();
				opr.SendKeysNoClear(pUacc.textAccountName(), accountname);
				sleep(1);
				Debug("输入实名");
				opr.SendKeysNoClear(pUacc.textRealName(), realname);
				sleep(1);
				Debug("输入IP地址");
				opr.SendKeysNoClear(pUacc.textIP(), ip);
				Debug("手动添加");
				pUacc.butUserAdd().click();
				sleep(1);
				Debug("点击确定");
				opr.JsClick(pUacc.buttonOk());
//				pUacc.buttonOk().click();
				sleep(1);
				Debug("点击确认");
				pTree.btnConfirm().click();
			}else {
				//存在账号对象
				Debug("点击复制");
				opr.Click(pUacc.buttonCopy());
				//确定复制的内容在哪一行
				int count = CommonTable.getRowByColString(pUacc.tablUserAccount(), "请输入名称", 1);
				Debug("输入名称");
				opr.JsClick(CommonTable.getCellObject(pUacc.tablUserAccount(), count, 1));
//				CommonTable.getCellObject(pUacc.tablUserAccount(), count, 1).click();
				opr.SendKeysNoClear(pUacc.textName(), name);
				sleep(1);
				Debug("输入账号");
				opr.JsClick(CommonTable.getCellObject(pUacc.tablUserAccount(), count, 2));
//				CommonTable.getCellObject(pUacc.tablUserAccount(), count, 2).click();
				opr.SendKeysNoClear(pUacc.textAccountName(), accountname);
				sleep(1);
				Debug("输入实名");
				opr.SendKeys(pUacc.textRealName(), realname);
				sleep(1);
				Debug("输入IP地址");
				opr.SendKeysNoClear(pUacc.textIP(), ip);
				Debug("手动添加");
				opr.JsClick(pUacc.butUserAdd());
//				pUacc.butUserAdd().click();
				Debug("点击确定");
				opr.JsClick(pUacc.buttonOk());
//				pUacc.buttonOk().click();
				Debug("点击确认");
				pTree.btnConfirm().click();
			}		
			return true;
		}catch (Exception e) {
			Error("增加账号对象异常");
			e.printStackTrace();
			return false;
		}	
	}
	
	//导入文件
	public boolean fileImport(String path) throws Exception {
		try {
			goUserAccount();
			opr.SwitchToFrame();
			Debug("输入文件路径");
			opr.SendKeys(pUacc.selFilePath(), path);
			sleep(1);
			Debug("点击导入按钮，导入文件");
			pUacc.buttonImport().click();
			return true;
		}catch (Exception e) {
			Error("导入文件错误");
			e.printStackTrace();
			return false;
		}
	}
	
	//文件导出
	public boolean fileExport() throws Exception {
		try {
			Debug("进入账号对象配置界面");
			goUserAccount();
			opr.SwitchToFrame();
			Debug("点击文件导出按钮");
			pUacc.buttonExport();
			return true;
		}catch (Exception e) {
			Error("文件导出错误");
			e.printStackTrace();
			return false;
		}
	}
	
	
	

}
