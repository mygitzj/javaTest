package dp.devweb.FW.tasks;

import dp.devweb.FW.appobject.GREPage;
import dp.devweb.FW.appobject.TreeMenuPage;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;
import dp.devweb.common.CommonTable;

/**
 * 
* @Title: GRE.java 
* @Description: TODO(GRE配置界面操作) 
* @author z01674 
* @date 2015年7月13日 下午4:21:18 
* @version V4.4
 */

public class GRE extends CommonObjectScript{
	public CommonOperator opr = new CommonOperator();
	public TreeMenuPage  pTree = new TreeMenuPage();
	public GREPage pGRE = new GREPage(); 
	
	/**
	 * @return 进入GRE配置界面
	 * @throws Exception
	 */
	public boolean goGREPage() throws Exception {
		try {
			opr.SwitchToDefault();
			opr.ClickToOpen(pTree.liNetManagement(), pTree.lnkNetManagement());
			sleep(1);
			opr.ClickToOpen(pTree.liIntfManagement(), pTree.lnkIntfManagement());
			sleep(1);
			opr.Click(pTree.lnkGRE());
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			Error("进入GRE配置界面异常");
			return false;
		}
 	}
	
	/**
	 * 
	 * @param name
	 * @param intIP
	 * @param mask
	 * @param sourceIP
	 * @param destIP
	 * @return 增加GRE4
	 * @throws Exception
	 */
	
	public boolean addGRE4(String name,String intIP,String mask,String sourceIP,String destIP) throws Exception {
		try{
			goGREPage();
			opr.SwitchToFrame();
			String str = CommonTable.getCellString(pGRE.tableGRE4(), 0, 0);
			if(str.equals("请配置隧道编号")) {
				Debug("输入隧道编号");
				opr.Click(CommonTable.getCellObject(pGRE.tableGRE4(), 0, 0));
				opr.SendKeysNoClear(pGRE.textTunnlNamev4(), name);
				Debug("输入接口IP");
				opr.Click(CommonTable.getCellObject(pGRE.tableGRE4(), 0, 1));
				opr.SendKeysNoClear(pGRE.textIPV4(), intIP);
				sleep(1);
				Debug("选择子网掩码");
				opr.Select(pGRE.selMask4(), mask);
				sleep(1);
				Debug("点击确定");
				opr.JsClick(pGRE.buttonOK());
				Debug("输入源IP");
				opr.Click(CommonTable.getCellObject(pGRE.tableGRE4(), 0, 2));
				opr.SendKeysNoClear(pGRE.textSource4(), sourceIP);
				Debug("输入目的IP");
				opr.Click(CommonTable.getCellObject(pGRE.tableGRE4(), 0, 3));
				opr.SendKeysNoClear(pGRE.textDest4(), destIP);
				opr.Click(CommonTable.getCellObject(pGRE.tableGRE4(), 0, 5));
				Debug("点击确认");
				opr.clickConfirm();
			}else {
				Debug("点击复制");
				opr.Click(pGRE.buttonCopy4());
				sleep(1);
				int count = CommonTable.getRowByColString(pGRE.tableGRE4(), "请配置隧道IP", 1);
				Debug("输入隧道编号");
				opr.SendKeysNoClear(pGRE.textTunnlNamev4(), name);
				Debug("输入接口IP");
				opr.Click(CommonTable.getCellObject(pGRE.tableGRE4(), count , 1));
				opr.SendKeysNoClear(pGRE.textIPV4(), intIP);
				sleep(1);
				Debug("选择子网掩码");
				opr.Select(pGRE.selMask4(), mask);
				sleep(1);
				Debug("点击确定");
				opr.JsClick(pGRE.buttonOK());
				Debug("输入源IP");
				opr.Click(CommonTable.getCellObject(pGRE.tableGRE4(), count , 2));
				opr.SendKeysNoClear(pGRE.textSource4(), sourceIP);
				Debug("输入目的IP");
				opr.Click(CommonTable.getCellObject(pGRE.tableGRE4(), count , 3));
				opr.SendKeysNoClear(pGRE.textDest4(), destIP);
				opr.Click(CommonTable.getCellObject(pGRE.tableGRE4(), count , 5));
				Debug("点击确认");
				opr.clickConfirm();
			}
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			Error("增加GRE4隧道错误");
			return false;
		}
		
	}
	
	/**
	 * 
	 * @param name
	 * @return 根据给出的名称删除GRE4
	 * @throws Exception
	 */
	public  boolean delGRE4(int count) throws Exception {
		try{
			goGREPage();
			opr.SwitchToFrame();
			sleep(2);
			opr.Click(pGRE.buttonDel4("tunnel"+count));
			Debug("点击确认");
			opr.clickConfirm();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			Error("删除GRE4异常");
			return false;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
