package dp.devweb.DPX.task;

import dp.devweb.DPX.appobject.Aut8021xPage;
import dp.devweb.DPX.appobject.TreeMenueDPXPage;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;
import dp.devweb.common.CommonTable;

/**
* @Title: Aut8021x.java 
* @Description: TODO(802.1x认证页面操作方法) 
* @author z01674 
* @date 2015年7月14日 下午7:36:02 
* @version V4.4
 */

public class Aut8021x extends CommonObjectScript{
	public Aut8021xPage p802 = new Aut8021xPage();
	public TreeMenueDPXPage pTree = new TreeMenueDPXPage();
	public CommonOperator opr = new CommonOperator();
	
	
	/**
	 * @return 进入802.1x认证配置界面
	 * @throws Exception
	 */
	public boolean goAuth8021() throws Exception {
		try {
			opr.SwitchToMenuFrame();
			sleep(2);
			opr.ClickToOpen(pTree.liAuthManagement(), pTree.lnkAuthManagement());
			sleep(1);
			opr.Click(pTree.lnk8021x());	
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			Error("进入802.1x认证界面异常");
			return false;
		}
	}
	
	
	/**
	 * 
	 * @param str
	 * @return 是否启用802.1x认证
	 * @throws Exception
	 */
	public boolean enDisable8021x(String str) throws Exception {
		try {
			goAuth8021();
			sleep(1);
			opr.SwitchToFrame1();
			sleep(1);
			Debug("选择"+str);
			if(str.equals("启用")) {
				opr.Click(p802.checkEnableAuth());
			}else if(str.equals("禁用")) {
				opr.Click(p802.checkDisableAuth());
			}
			Debug("点击确认");
			opr.clickConfirm();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			Error("选择是否启用认证异常");
			return false;
		}
	}
	
	/**
	 * 
	 * @param name
	 * @param password
	 * @param description
	 * @return 增加用户配置
	 * @throws Exception
	 */
	
	public boolean addUser(String name ,String password,String description) throws Exception {
		try {
			goAuth8021();
			sleep(1);
			opr.SwitchToFrame1();
			sleep(1);
			Debug("点击用户配置");
			opr.Click(p802.topUserConf());
			sleep(3);
			String str = CommonTable.getCellString(p802.tableUserConf(), 0, 1);
			if (str.equals("请配置用户名")) {
				opr.Click(CommonTable.getCellObject(p802.tableUserConf(), 0, 1));
				Debug("输入用户名");
				opr.SendKeysNoClear(p802.textUserName(), name);
				opr.Click(CommonTable.getCellObject(p802.tableUserConf(), 0, 2));
				Debug("输入密码");
				opr.SendKeysNoClear(p802.textpassword(), password);
				opr.Click(CommonTable.getCellObject(p802.tableUserConf(), 0, 3));
				Debug("输入确认密码");
				opr.SendKeysNoClear(p802.textConfimPassword(), password);
				opr.Click(CommonTable.getCellObject(p802.tableUserConf(), 0, 6));
				if(description != null) {
					Debug("输入描述");
					opr.SendKeysNoClear(p802.textDescription(), password);
				}
				Debug("点击确认");
				opr.clickConfirm();
			}else {
				Debug("点击复制");
				opr.Click(p802.buttonCopyUserConf());
				opr.Click(CommonTable.getCellObject(p802.tableUserConf(), 0, 7));
				int count = CommonTable.getRowByColString(p802.tableUserConf(), "请配置用户名", 1);
				opr.Click(CommonTable.getCellObject(p802.tableUserConf(), count, 1));
				Debug("输入用户名");
				opr.SendKeysNoClear(p802.textUserName(), name);
				opr.Click(CommonTable.getCellObject(p802.tableUserConf(), count, 2));
				Debug("输入密码");
				opr.SendKeysNoClear(p802.textpassword(), password);
				opr.Click(CommonTable.getCellObject(p802.tableUserConf(), count, 3));
				Debug("输入确认密码");
				opr.SendKeysNoClear(p802.textConfimPassword(), password);
				opr.Click(CommonTable.getCellObject(p802.tableUserConf(), count, 6));
				if(description != null) {
					Debug("输入描述");
					opr.SendKeysNoClear(p802.textDescription(), password);
				}
				Debug("点击确认");
				opr.clickConfirm();
			}
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			Error("增加用户配置异常");
			return false;
		}
	}
	
	/**
	 * @param name
	 * @return 根据给出的用户名删除用户
	 * @throws Exception
	 */
	
	public boolean delUserConf(String name) throws Exception {
		try {
			goAuth8021();
			sleep(1);
			opr.SwitchToFrame1();
			sleep(1);
			Debug("点击用户配置");
			opr.Click(p802.topUserConf());
			sleep(3);
			Debug("勾选删除按钮");
			int count = CommonTable.getRowByColString(p802.tableUserConf(), name, 1);
			System.out.print(count);
//			opr.Click(p802.buttonDeleUserConf(count));
			opr.ClickToState(p802.buttonDeleUserConf(count), true);
			Debug("点击确认");
			opr.clickConfirm();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			Error("删除用户配置异常");
		}return false;
	}
	
}
