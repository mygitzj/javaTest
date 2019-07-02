package dp.devweb.FW.tasks;

import dp.devweb.FW.appobject.ARPConfigPage;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;

/**
 * 
* @Title: ARPConfig.java 
* @Description: TODO(对ARP配置界面的操作) 
* @author z01674 
* @date 2015年5月13日 下午3:39:28 
* @version V4.4
 */
public class ARPConfig extends CommonObjectScript{
	
	public ARPConfigPage  pARP = new ARPConfigPage();
	public CommonOperator opr = new CommonOperator();
	
	/**
	 * 
	 * @return ARP配置界面
	 * @throws Exception
	 */
	public void goARPConfig() throws Exception {
		try {
			
			Debug("网络管理——ARP——ARP配置");
			opr.ClickToOpen(pARP.liNetManagement(),pARP.lnkNetManagement() );
			sleep(1);
			opr.ClickToOpen(pARP.liARP(), pARP.lnkARP());
			sleep(1);
			opr.Click(pARP.lnkARPConfig());
			sleep(1);
		}catch(Exception e){
			Error("进入ARP配置界面异常\n" + e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 勾选关闭ARP被动学习功能
	 */
	public boolean trueDisablePassiveARPLearning() throws Exception {
		try {
			//进入到默认配置界面
			opr.SwitchToDefault();
			
			//进入ARP配置界面
			goARPConfig();
			
			//切换到右侧表格
			opr.SwitchToFrame();
			
			//点击动态ARP参数配置
			opr.Click(pARP.dynaARPConfig());
			sleep(1);
			
			//勾选关闭ARP被动学习异常
			opr.ClickToState(pARP.checkDisablePassiveARPLearning(), true);
			sleep(1);
			
			//点击确认
			opr.clickConfirm();
			return true;
		}catch(Exception e){
			Error("勾选关闭ARP被动学习异常\n" + e);
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 去勾选关闭ARP被动学习功能
	 */
	public boolean falseDisablePassiveARPLearning() throws Exception {
		try{
			//进入到默认配置界面
			opr.SwitchToDefault();
			
			//进入ARP配置界面
			goARPConfig();
			
			//切换到右侧表格
			opr.SwitchToFrame();
			
			//点击动态ARP参数配置
			opr.Click(pARP.dynaARPConfig());
			sleep(1);
			
			//勾选关闭ARP被动学习异常
			opr.ClickToState(pARP.checkDisablePassiveARPLearning(), false);
			sleep(1);
			
			
			return true;
		}catch(Exception e) {
			Error("去勾选关闭ARP被动学习异常\n" + e);
			e.printStackTrace();
			return false;
		}
	}
	
	//用于反复勾选去勾选关闭ARP被动学习功能
	public boolean undodoDisablePassiveARPLearning() throws Exception {
		try{
			//进入到默认配置界面
			opr.SwitchToDefault();
			
			//进入ARP配置界面
			goARPConfig();
			
			//切换到右侧表格
			opr.SwitchToFrame();
			
			//点击动态ARP参数配置
			opr.Click(pARP.dynaARPConfig());
			sleep(1);
			
			//勾选关闭ARP被动学习异常
			opr.ClickToState(pARP.checkDisablePassiveARPLearning(), true);
			sleep(1);
			
			opr.ClickToState(pARP.checkDisablePassiveARPLearning(), false);
			sleep(1);
			return true;
		}catch(Exception e) {
			Error("勾选去勾选关闭ARP被动学习异常\n" + e);
			e.printStackTrace();
			return false;
		}
	}
	
	//用于反复勾选去勾选关闭ARP主动学习功能
	public boolean undodoDisableActiveARPLearning() throws Exception {
		try{
			//进入到默认配置界面
			opr.SwitchToDefault();
			
			//进入ARP配置界面
			goARPConfig();
			
			//切换到右侧表格
			opr.SwitchToFrame();
			
			//点击动态ARP参数配置
			opr.Click(pARP.dynaARPConfig());
			sleep(1);
			
			//勾选关闭ARP被动学习异常
			opr.ClickToState(pARP.checkDisableActiveARPLearning(), true);
			sleep(1);
			
			opr.ClickToState(pARP.checkDisableActiveARPLearning(), false);
			sleep(1);
			return true;
		}catch(Exception e) {
			Error("勾选去勾选关闭ARP主动学习异常\n" + e);
			e.printStackTrace();
			return false;
		}
	}
	
	//用于反复勾选去勾选关闭ARP更行功能
	public boolean undodoDisableARPUpdate() throws Exception {
		try{
			//进入到默认配置界面
			opr.SwitchToDefault();
			
			//进入ARP配置界面
			goARPConfig();
			
			//切换到右侧表格
			opr.SwitchToFrame();
			
			//点击动态ARP参数配置
			opr.Click(pARP.dynaARPConfig());
			sleep(1);
			
			//勾选关闭ARP被动学习异常
			opr.ClickToState(pARP.checkDisableARPUpdate(), true);
			sleep(1);
			
			opr.ClickToState(pARP.checkDisableARPUpdate(), false);
			sleep(1);
			return true;
		}catch(Exception e) {
			Error("勾选去勾选关闭ARP主动学习异常\n" + e);
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	

