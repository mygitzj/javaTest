package dp.devweb.FW.tasks;

import dp.devweb.FW.appobject.LogicIntfConfPage;
import dp.devweb.FW.appobject.TreeMenuPage;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;
import dp.devweb.common.CommonTable;

/**
 * @Title: LogicIntfConf.java
 * @Description: 逻辑接口配置界面相关操作
 * @author w01866
 * @date 2014年12月2日 上午11:22:24
 * @version V4.4
 */
public class LogicIntfConf extends CommonObjectScript {

	public TreeMenuPage pageTree = new TreeMenuPage();
	public LogicIntfConfPage pageLogic = new LogicIntfConfPage();	
	public CommonOperator oprCom = new CommonOperator();

	/**
	 * 判断loopback口是否存在
	 * @return 存在返回true，不存在或失败返回false
	 * @throws Exception
	 */
	public boolean LoopbackExisted(String name) throws Exception {
		try {
			// 切换到左侧windows
			oprCom.SwitchToDefault();
			
			Debug("进入逻辑接口配置界面");
			Debug("点击 网络管理");
			oprCom.ClickToOpen(pageTree.liNetManagement(), pageTree.lnkNetManagement());
			Debug("点击 接口管理");
			oprCom.ClickToOpen(pageTree.liIntfManagement(), pageTree.lnkIntfManagement());
			Thread.sleep(1000);
			Debug("点击 逻辑接口配置");
			pageTree.lnkLogicIntfConf().click();
			
			// 获取loopback表行数
			int counts = CommonTable.getRowCounts(pageLogic.tblLoopbackIntf());
			
			for(int i = 0; i < counts; i++){
				String str = CommonTable.getCellString(pageLogic.tblLoopbackIntf(), i, 0);
				if (str.equals(name)){
					Debug(name + " 已存在");
					return true;
				}
			}			
			Debug(name + "不存在");
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			Error("增加loopback口出现异常");
			return false;
		}
	}	
	
	/**
	 * 增加loopback口
	 * @param counts
	 *            增加的loopback口数量
	 * @return 执行成功返回true，失败返回false
	 * @throws Exception
	 */
	public boolean AddLoopback(int counts) throws Exception {
		try {
			// 切换到左侧windows
			oprCom.SwitchToDefault();
			
			Debug("进入逻辑接口配置界面");
			Debug("点击 网络管理");
			oprCom.ClickToOpen(pageTree.liNetManagement(), pageTree.lnkNetManagement());
			Debug("点击 接口管理");
			oprCom.ClickToOpen(pageTree.liIntfManagement(), pageTree.lnkIntfManagement());
			Thread.sleep(1000);
			Debug("点击 逻辑接口配置");
			pageTree.lnkLogicIntfConf().click();
			
			// 切换到右侧frame
			oprCom.SwitchToFrame();

			Debug("点击 loopback口配置");
			pageLogic.tblLoopbackIntfConf().click();

			Debug("点击loopback口ID");
			CommonTable.getCellObject(pageLogic.tblLoopbackIntf(), 0, 1)
					.click();

			Debug("输入接口ID：" + 1);
			pageLogic.txtLoopback().sendKeys("1");

			for (int i = 1; i < counts; i++) {
				pageLogic.spnAddLoopback().click();
				Debug("输入接口ID：" + (i + 1));
				pageLogic.txtLoopback().sendKeys(Integer.toString(i + 1));
			}

			Debug("点击 确认");
			pageTree.btnConfirm().click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			Error("增加loopback口出现异常");
			return false;
		}
	}
	
	/**
	 * 增加loopback口
	 * @param counts
	 *            增加的loopback口数量
	 * @return 执行成功返回true，失败返回false
	 * @throws Exception
	 */
	public boolean DelAllLoopback() throws Exception {
		try {
			// 切换到左侧windows
			oprCom.SwitchToDefault();
			
			Debug("进入逻辑接口配置界面");
			Debug("点击 网络管理");
			oprCom.ClickToOpen(pageTree.liNetManagement(), pageTree.lnkNetManagement());
			Debug("点击 接口管理");
			oprCom.ClickToOpen(pageTree.liIntfManagement(), pageTree.lnkIntfManagement());
			Thread.sleep(1000);
			Debug("点击 逻辑接口配置");
			pageTree.lnkLogicIntfConf().click();
			
			// 切换到右侧frame
			oprCom.SwitchToFrame();

			Debug("点击 loopback口配置");
			pageLogic.tblLoopbackIntfConf().click();			

			// 获取loopback列表行数
			int counts = CommonTable.getRowCounts(pageLogic.tblLoopbackIntf());
			
			for (int i = 0; i < counts; i++) {				
				Debug("删除loopback " + (i + 1));
				CommonTable.getCellObject(pageLogic.tblLoopbackIntf(),0,2).click();
				pageLogic.spnDelLoopback(i).click();	
			}

			Debug("点击 确认");
			pageTree.btnConfirm().click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			Error("删除loopback口出现异常");
			return false;
		}
	}	
}
