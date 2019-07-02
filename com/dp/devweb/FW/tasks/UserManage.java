package dp.devweb.FW.tasks;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import dp.devweb.FW.appobject.TreeMenuServicPage;
import dp.devweb.FW.appobject.UserManagePage;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;
import dp.devweb.common.CommonTable;

/**
* @Title: UserManage.java 
* @Description: TODO(对用户管理界面的操作) 
* @author z01674 
* @date 2015年7月10日 上午10:05:41 
* @version V4.4
 */

public class UserManage extends CommonObjectScript{

	public CommonOperator opr = new CommonOperator();
	public UserManagePage pUserManage = new UserManagePage();
	public TreeMenuServicPage pTree = new TreeMenuServicPage();
	
	
	/**
	 * @return 进入用户管理配置界面
	 * @throws Exception
	 */
	public boolean goUserManagePage() throws Exception {
		try {
			opr.SwitchToDefault();
			Debug("点击业务");
			opr.Click(pTree.topService());
			sleep(1);
			Debug("点击VPN");
			opr.ClickToOpen(pTree.liVPN(), pTree.lnkVPN());
			sleep(1);
			Debug("点击SSLVPN");
			opr.ClickToOpen(pTree.liSSLVPN(), pTree.lnkSSlVPN());
			sleep(1);
			Debug("点击用户管理");
			opr.Click(pTree.lnkUserManagement());			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			Error("进入用户管理界面异常");
			return false;
		}
	}
	
	/**
	 * @param name
	 * @return 增加用户组
	 * @throws Exception
	 */
	
	public boolean addUserGroup (String name) throws Exception {
		try {
			goUserManagePage();
			opr.SwitchToFrame();
			String str = CommonTable.getCellString(pUserManage.tablUserGroupConf(), 0, 0);
			if(str.equals("设置名称")) {
				Debug("配置用户组名称");
				opr.Click(CommonTable.getCellObject(pUserManage.tablUserGroupConf(), 0, 0));
				sleep(1);
				opr.SendKeysNoClear(pUserManage.textUserGroupName(), name);
				
				opr.Click(CommonTable.getCellObject(pUserManage.tablUserGroupConf(), 0, 1));
				sleep(1);
				Debug("点击确认");
				opr.clickConfirm();
			}else {
				Debug("点击复制");
				opr.Click(pUserManage.buttonCopy());
				int count = CommonTable.getRowByColString(pUserManage.tablUserGroupConf(), "无", 1);
				System.out.print(count);
				opr.SendKeysNoClear(pUserManage.textUserGroupName(), name);
				opr.Click(CommonTable.getCellObject(pUserManage.tablUserGroupConf(), count -1, 2));
				sleep(1);
				Debug("点击确认");
				opr.clickConfirm();
			}
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			Error("增加用户组配置异常");
			return false;
		}
	}
	
	
	/**
	 * 
	 * @param name
	 * @return 删除用户组配置
	 * @throws Exception
	 */
	public boolean deleteUserGroup(String name) throws Exception{
		try {
			goUserManagePage();
			opr.SwitchToFrame();
			sleep(1);
			int count = CommonTable.getRowByColString(pUserManage.tablUserGroupConf(), name, 0);
			opr.Click(pUserManage.buttonDel(count));
			Debug("点击确认");
			opr.clickConfirm();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			Error("删除用户组配置异常");
			return false;
		}
	}
	
	/**
	 * @param name
	 * @param password
	 * @param userGroup
	 * @return 增加用户信息配置
	 * @throws Exception
	 */
	public boolean addUser(String name, String password, String[] userGroup) throws Exception  {
		try {
			goUserManagePage();
			opr.SwitchToFrame();
			sleep(1);
			String str = CommonTable.getCellString(pUserManage.tableUser(), 0, 0);
			if(str.equals("设置名称")) {
				opr.Click(CommonTable.getCellObject(pUserManage.tableUser(), 0, 0));
				Debug("输入名称");
				opr.SendKeysNoClear(pUserManage.textUserName(), name);
				opr.Click(CommonTable.getCellObject(pUserManage.tableUser(), 0, 1));
				Debug("输入密码");
				sleep(1);
				opr.SendKeysNoClear(pUserManage.textPassword(), password);
				Debug("输入确认密码");
				opr.SendKeysNoClear(pUserManage.textPasswordConfirm(), password);
				sleep(1);
				Debug("点击确定");
				opr.Click(pUserManage.buttonOK());
				opr.Click(CommonTable.getCellObject(pUserManage.tableUser(), 0, 2));
//				sleep(1);
//				Debug("选择所属用户组");		
//				for (int i = 0; i < userGroup.length; i++) {
//					Debug("选择： " + userGroup[i] );
//					opr.Select(pUserManage.selAvailUserGroup(), userGroup[i]);
//					pUserManage.buttonAdd();
//					sleep(1);
//					Debug("点击确定");
//					opr.Click(pUserManage.buttonOK());
//				}
				Debug("点击确认");
				opr.clickConfirm();
			}else {
				Debug("点击复制");
				opr.Click(pUserManage.buttonCopyUser());
				Debug("输入名称");
				opr.SendKeysNoClear(pUserManage.textUserName(), name);
				int count = CommonTable.getRowByColString(pUserManage.tableUser(), "无", 1);
				opr.Click(CommonTable.getCellObject(pUserManage.tableUser(), count -1 , 1));
				sleep(2);
				Debug("输入密码");
				opr.SendKeys(pUserManage.textPassword(), password);
				Debug("输入确认密码");
		        sleep(1);
				opr.SendKeys(pUserManage.textPasswordConfirm(), password);
				sleep(2);
				Debug("点击确定");
				pUserManage.buttonOK().click();
				sleep(1);
//				opr.Click(pUserManage.buttonOK());
				opr.Click(CommonTable.getCellObject(pUserManage.tableUser(), count -1, 2));		
//				Debug("清空已选所属用户组中的内容");
//				Select slt = new Select(pUserManage.selSeltedUserGroup());
//				List<WebElement> slts = slt.getOptions();
//				sleep(1);
//				for (int x = 0; x < slts.size(); x++) {
//					slt.getOptions().get(0).click();
//					sleep(1);
//					opr.JsClick(pUserManage.buttonDelUser());
//					sleep(1);
//				}			
//				Debug("选择所属用户组");
//				for (int i = 0; i < userGroup.length; i++) {
//					Debug("选择： " + userGroup[i] );
//					opr.Select(pUserManage.selAvailUserGroup(), userGroup[i]);
//					pUserManage.buttonAdd();
//					sleep(1);
//					Debug("点击确定");
//					opr.Click(pUserManage.buttonOK());
//				}
				Debug("点击确认");
				opr.clickConfirm();
			}
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			Error("增加用户信息异常");
			return false;
		}
	}
	
	public boolean delUser(String name ) throws Exception {
		try{
			goUserManagePage();
			opr.SwitchToFrame();
			sleep(1);
			int count = CommonTable.getRowByColString(pUserManage.tableUser(), name, 0);
			opr.JsClick(pUserManage.buttonDelUser(count));
			sleep(1);
			opr.clickConfirm();		
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			Error("删除用户配置异常");
			return false;
		}
	}
	
	
	
}
