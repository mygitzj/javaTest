package dp.devweb.FW.tasks;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import dp.devweb.FW.appobject.SecurityZonePage;
import dp.devweb.FW.appobject.TreeMenuPage;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;
import dp.devweb.common.CommonTable;

/**
 * @Title: SecurityZone.java
 * @Description: TODO(安全域页面的配置方法)
 * @author w01866
 * @date 2014年12月12日 下午4:38:18
 * @version V4.4
 */
public class SecurityZone extends CommonObjectScript {
	public TreeMenuPage pTree = new TreeMenuPage();
	public CommonOperator opr = new CommonOperator();
	public SecurityZonePage pSec = new SecurityZonePage();

	public boolean goSecurityZone() throws Exception {
		try {
			// 切换到左侧windows
			opr.SwitchToDefault();

			Debug("进入 安全域 页面");
			Debug("点击 网络管理 → 网络对象 → 安全域");
			opr.ClickToOpen(pTree.liNetManagement(), pTree.lnkNetManagement());
			Thread.sleep(1000);
			opr.ClickToOpen(pTree.liNetObject(), pTree.lnkNetObject());
			Thread.sleep(1000);
			pTree.lnkSecurityZone().click();

			return true;
		} catch (Exception e) {
			Error("进入安全域页面异常");
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 根据安全域名检查该域是否存在
	 * 
	 * @param name
	 *            安全域名
	 * @return 存在返回true，不存在返回false
	 * @throws Exception
	 */
	public boolean VerifySecurityZone(String name) throws Exception {
		opr.SwitchToDefault();
		goSecurityZone();

		// 切换到右侧frame
		opr.SwitchToFrame();
		return CommonTable.isStringExsited(pSec.tblSecurityZone(), name, 1);
	}

	public boolean AddSecurityZone(String name, String intf, String priority,
			String desc) throws Exception {
		opr.SwitchToDefault();
		goSecurityZone();

		// 切换到右侧frame
		opr.SwitchToFrame();

		Debug("增加一条安全域数据");
		pSec.spnAdd().click();

		// 获取新增数组所在行
		int row = -1;
		row = CommonTable.getRowByColString(pSec.tblSecurityZone(), "请配置安全域名",
				1);

		Debug("配置安全域名： " + name);
		CommonTable.getCellObject(pSec.tblSecurityZone(), row, 1).click();
		opr.SendKeys(pSec.txtSecurityZone(), name);
		CommonTable.getCellObject(pSec.tblSecurityZone(), row, 3).click();

		// 判断安全域名是否合法
		try {
			Alert alert = driver.switchTo().alert();
			if (alert.getText().contains("非法字符")) {
				Debug("成功判断非法字符： " + name);
				alert.accept();
				sleep(1);
				// 清空文本
				pSec.txtSecurityZone().clear();
				return false;
			}
		} catch (Exception e) {
		}

		if (intf != null) {
			Debug("选择接口： " + intf);
			CommonTable.getCellObject(pSec.tblSecurityZone(), row, 2).click();

			opr.ClickToState(pSec.chkInterface(intf), true);
			pTree.btnOK().click();
		}

		if (priority != null) {
			Debug("配置优先级： " + priority);
			CommonTable.getCellObject(pSec.tblSecurityZone(), row, 3).click();
			opr.SendKeys(pSec.txtPriority(), priority);
			CommonTable.getCellObject(pSec.tblSecurityZone(), row, 4).click();

			// 判断优先级是否合法
			try {
				Alert alert = driver.switchTo().alert();
				// 判断值是否小于0
				if (alert.getText().contains("请输入十进制整数")) {
					Debug("成功判断小于0的值： " + priority);
					alert.accept();
					// 清空文本
					pSec.txtPriority().clear();
					return false;
				}
				// 判断值是否大于100
				if (alert.getText().contains("整数类型的值超出范围")) {
					Debug("成功判断大于100的值： " + priority);
					alert.accept();
					// 清空文本
					pSec.txtPriority().clear();
					return false;
				}
			} catch (Exception e) {
			}
		}

		if (desc != null) {
			Debug("输入描述： " + desc);
			CommonTable.getCellObject(pSec.tblSecurityZone(), row, 4).click();
			opr.SendKeys(pSec.txtDescribe(), desc);
			CommonTable.getCellObject(pSec.tblSecurityZone(), row, 3).click();

			// 判断描述是否合法
			try {
				Alert alert = driver.switchTo().alert();
				// 描述是否有非法字符
				if (alert.getText().contains("非法字符")) {
					Debug("成功判断非法字符： " + desc);
					alert.accept();
					// 清空文本
					pSec.txtDescribe().clear();
					return false;
				}
			} catch (Exception e) {
			}

		}

		Debug("点击 确认");
		pTree.btnConfirm().click();

		// 判断安全域名是否为空
		try {
			Alert alert = driver.switchTo().alert();
			if (alert.getText().equals("请配置安全域名")) {
				alert.accept();
				Debug("成功判断安全域名为空");
			} else {
				Error("提示信息错误");
			}
			return false;
		} catch (Exception e) {
		}
		return true;
	}

	/**
	 * 验证提示非法字符
	 * 
	 * @param name
	 *            非法字符
	 * @return
	 * @throws Exception
	 */
	public boolean VerifyIllegalCharacters(String name) throws Exception {
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();
		// 清空文本
		pSec.txtSecurityZone().clear();

		if (alertText.contains("非法字符")) {
			Debug("成功判断非法数据： " + name);
			return true;
		} else {
			Error("未提示 非法字符");
			return false;
		}
	}

	/**
	 * 验证提示安全域名为空
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean VerifyNoName() throws Exception {
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();
		if (alertText.equals("请配置安全域名")) {
			Debug("成功判断安全域名为空");
			return true;
		} else {
			Error("未提示 请配置安全域名");
			return false;
		}
	}

	/**
	 * 删除安全域
	 * 
	 * @param name
	 *            删除的安全域名
	 * @return
	 * @throws Exception
	 */
	public boolean DeleteSecurityZone(String name) throws Exception {
		opr.SwitchToDefault();
		goSecurityZone();

		// 切换到右侧frame
		opr.SwitchToFrame();

		Debug("删除安全域" + name);
		int row = -1;
		row = CommonTable.getRowByColString(pSec.tblSecurityZone(), name, 1) + 1;
		pSec.spnDel(row).click();

		Debug("点击 确认");
		pTree.btnConfirm().click();
		return true;
	}
	
	/**
	 * 
	 * @param filePath
	 * @return 导入文件
	 * @throws Exception
	 */

	public boolean ImportSecurityZone(String filePath) throws Exception {
		try {	
			opr.SwitchToDefault();
			goSecurityZone();

			// 切换到右侧frame
			opr.SwitchToFrame();

			Debug("输入导入文件路径" + filePath);
			pSec.btnSelectFile().sendKeys(filePath);
			sleep(20);
	
			Debug("点击导入");
			opr.Click(pSec.btnImport());
			sleep(5);

//		try {
//			Alert alert = driver.switchTo().alert();
//			String alertText = alert.getText();
//			alert.accept();
//			if (alertText.contains("illegal characters")
//					|| alertText.contains("Parameters are error")
//					|| alertText.contains(" out of bound")
//					|| alertText.contains("description is error")) {
//				Debug("成功判断非法数据");
//				return false;
//			}
//		} catch (Exception e) {
//		}
//            sleep(5);
//			Debug("点击 确认");
//			opr.Click(pTree.btnConfirm());
			return true;
		}catch (Exception e) {
			Error("导入配置异常");
			return false;
		}
	}
	
	/**
	 * 
	 * @param name
	 * @param intf
	 * @return 配置安全域
	 * @throws Exception
	 */
	public boolean configSecurityZone(String name, String intf)
			throws Exception {
		try {
			opr.SwitchToDefault();
			// 进入安全域页面
			goSecurityZone();
			opr.SwitchToFrame();

			if (false == CommonTable.isStringExsited(pSec.tblSecurityZone(),
					name, 1)) {
				opr.Click(pSec.spnAdd());
				opr.Click(CommonTable.getCellObjByColString(
						pSec.tblSecurityZone(), "请配置安全域名", 1, 1));
				opr.SendKeys(pSec.txtSecurityZone(), name);
				opr.Click(pSec.topSecurityZone());
				sleep(1);
			}

			Debug("选择安全域： " + name + "\t接口： " + intf);
			opr.Click(CommonTable.getCellObjByColString(pSec.tblSecurityZone(),
					name, 1, 2));
			sleep(1);

			// 全选和其他checkbox结构不同，不能用同一方法
			if (!intf.equals("全选")) {
				// 点击两次全选，重新选择接口
				opr.Click(pSec.chkSelectAll());
				Thread.sleep(500);
				opr.Click(pSec.chkSelectAll());
				Thread.sleep(500);

				// 选择指定接口
				opr.ClickToState(pSec.chkInterface(intf), true);
			}else{
				// 全选
				opr.Click(pSec.chkSelectAll());
				Thread.sleep(500);
			}

			opr.Click(pTree.btnOK());

			opr.Click(pTree.btnConfirm());
			return true;
		} catch (Exception e) {
			Error("配置安全域异常");
			e.printStackTrace();
			return false;
		}
	}
	
	
	/**
	 * 
	 * @return 导出安全域配置
	 * @throws Exception
	 */
	public boolean exportFile() throws Exception {
		try {
			goSecurityZone();
			opr.SwitchToFrame();
			Debug("点击导出");
			opr.Click(pSec.butExport());
			sleep(5);
			Actions action = new Actions(driver);
		    action.keyDown(Keys.ENTER);		
			return true;
		}catch (Exception e) {
			Error("导出文件错误");
		}return false;
	}
	
	/**
	 * 
	 * @param name
	 * @param intf
	 * @param bClick
	 * @return 修改安全域
	 * @throws Exception
	 */
	public boolean modifySecurityZone(String name, String intf, boolean bClick)
			throws Exception {
		try {
			//转到默认配置界面
			opr.SwitchToDefault();
			// 进入安全域页面
			goSecurityZone();
			opr.SwitchToFrame();
			sleep(1);

//			Debug( "接口："+  intf + "加入到选安全域： " + name );
			
			opr.Click(CommonTable.getCellObjByColString(pSec.tblSecurityZone(),
					name, 1, 2));
			sleep(1);
			
			

			// 点击两次全选，重新选择接口
			// opr.Click(pSec.chkSelectAll());
			// Thread.sleep(500);
			// opr.Click(pSec.chkSelectAll());
			// Thread.sleep(500);

			// 选择指定接口
			opr.JsClickToState(pSec.chkInterface(intf), bClick);
			sleep(1);

			opr.JsClick(pTree.btnOK());

			opr.Click(pTree.btnConfirm());
			
			return true;
			
		} catch (Exception e) {
			Error("修改安全域异常");
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 
	 * @param name
	 * @param expectIntf
	 * @return 确认安全域存在
	 * @throws Exception
	 */

	public boolean verifySecurityZone(String name, String expectIntf)
			throws Exception {
		try {
			opr.SwitchToDefault();
			// 进入安全域页面
			goSecurityZone();
			opr.SwitchToFrame();

			Debug("验证安全域配置接口是否成功： " + name);
			String actualIntf = CommonTable
					.getCellObjByColString(pSec.tblSecurityZone(), name, 1, 2)
					.getText().trim();
			if (actualIntf.contains(expectIntf)) {
				Debug("预期值： " + expectIntf + "\t实际值： " + actualIntf + "\t相等");
				return true;
			} else {
				Debug("预期值： " + expectIntf + "\t实际值： " + actualIntf + "\t不相等");
				return false;
			}
		} catch (Exception e) {
			Error("验证安全域接口异常");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean verifySecurityZone(String name)throws Exception {
		try {
			opr.SwitchToDefault();
			// 进入安全域页面
			goSecurityZone();
			opr.SwitchToFrame();

			Debug("验证安全域是否存在： " + name);
			return CommonTable.isStringExsited(pSec.tblSecurityZone(), name, 1);
			
		} catch (Exception e) {
			Error("验证安全域异常");
			e.printStackTrace();
			return false;
		}
	}
	
}

