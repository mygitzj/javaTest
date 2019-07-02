package dp.devweb.FW.tasks;


import dp.devweb.FW.appobject.OneToOneNatPage;
import dp.devweb.FW.appobject.TreeMenuPage;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;
import dp.devweb.common.CommonTable;

/**
 * 
* @Title: OneToOneNet.java 
* @Description: TODO(一对一Net操作) 
* @author z01674 
* @date 2015年4月24日 下午5:38:27 
* @version V4.4
 */

public class OneToOneNat  extends CommonObjectScript{
	public TreeMenuPage pTree = new TreeMenuPage();
	public CommonOperator opr = new CommonOperator();
	public OneToOneNatPage p1T1Nat =new OneToOneNatPage();
	
	/**
	 * @return 一对一NAT配置界面
	 * @throws Exception
	 */
		
	public boolean goOneToOnePage () throws Exception{
		try{
			//切换到左侧窗口
			opr.SwitchToDefault();
			Info("基本--防火墙--一对一NAT");
			opr.ClickToOpen(pTree.liFireWall(), pTree.lnkFireWall());
			sleep(2);
			opr.Click(pTree.lnk1to1Nat());
			sleep(1);
			return true;
		}catch (Exception e) {
			Error("进入一对一NAT页面异常");
			e.printStackTrace();
			return false;
	}
	}
	
	/**
	 * 
	 * @param name
	 * @param netInterface
	 * @param intranetAddress
	 * @param netAddress
	 * @return 增加一对一NAT
	 * @throws Exception
	 */
	public boolean add1To1Nat(String name, String netInterface, String intranetAddress,
			String netAddress) throws Exception {
		try{
			opr.SwitchToDefault();
			//进入到一对一配置界面
			goOneToOnePage ();
			//切换到表格栏
			opr.SwitchToFrame();
			
			//判断是否存在一对一NAT，如果存在则复制并配置，如果不存在则在第一行配置
			String str = CommonTable.getCellString(p1T1Nat.tabOneToOneNet(), 0, 1);
			
			if (str.equals("请配置名称")) {
				
				Debug("输入名称" + name);
				opr.Click(CommonTable.getCellObject(p1T1Nat.tabOneToOneNet(), 0, 1));
			    opr.SendKeys(p1T1Nat.textName(), name);
			    sleep(1);
			    
			    //点击序号，名称配置生效
			    p1T1Nat.black().click();
			    
			    //根据给出的接口名称选择接口
			    Debug("输入公网接口" + netInterface);
			    opr.Click(CommonTable.getCellObject(p1T1Nat.tabOneToOneNet(), 0, 2));
			    opr.Select(p1T1Nat.slecNetInterface(), netInterface);
			    sleep(2);
			    
			    Debug("输入内网地址" +intranetAddress);
			    opr.Click(CommonTable.getCellObject(p1T1Nat.tabOneToOneNet(), 0, 3));
			    opr.SendKeys(p1T1Nat.textIntranetAddress(), intranetAddress);
			    sleep(2);
			    
			    Debug("输入公网地址");
			    opr.Click(CommonTable.getCellObject(p1T1Nat.tabOneToOneNet(), 0, 4));
			    opr.SendKeys(p1T1Nat.textNetAddr(), netAddress);
			    sleep(1);
			    
			    p1T1Nat.black().click();
			  
			}else {
				Debug("点击复制");
				opr.Click(p1T1Nat.spnCopy());
				
				//确认新复制的内容所在的行
				int row = CommonTable.getRowByColString(
						p1T1Nat.tabOneToOneNet(),"请输入内网地址", 3);
				
				Debug("输入名称" + name);
				opr.Click(CommonTable.getCellObject(p1T1Nat.tabOneToOneNet(), row, 1));
			    opr.SendKeys(p1T1Nat.textName(), name);
			    sleep(1);
			    
			    Info("fghhhhoj");
			    //点击序号，名称配置生效
			    p1T1Nat.black().click();
			    
			    Info("6767r823");
			    //根据给出的接口名称选择接口
			    Debug("输入公网接口" + netInterface);
			    opr.Click(CommonTable.getCellObject(p1T1Nat.tabOneToOneNet(), row, 2));
			    opr.Select(p1T1Nat.slecNetInterface(), netInterface);
			    sleep(2);
			    
			    Debug("输入内网地址" +intranetAddress);
			    opr.Click(CommonTable.getCellObject(p1T1Nat.tabOneToOneNet(), row, 3));
			    opr.SendKeys(p1T1Nat.textIntranetAddress(), intranetAddress);
			    sleep(2);
			    
			    Debug("输入公网地址" + netAddress);
			    opr.Click(CommonTable.getCellObject(p1T1Nat.tabOneToOneNet(), row, 4));
			    opr.SendKeys(p1T1Nat.textNetAddr(), netAddress);
			    sleep(1);
			    
			    //点击其他地方
			    p1T1Nat.black().click();
			}
			Debug("点击确认");
			opr.Click(pTree.btnConfirm());
			return true;
		}catch (Exception e) {
				Error("增加一对一NAT异常");
				e.printStackTrace();
				return false;
		}
	}
	
	/**
	 * 
	 * @param name
	 * @param netInterface
	 * @param intranetAddress
	 * @param netAddress
	 * @return 修改一对一NAT
	 * @throws Exception
	 */
	public boolean modify1To1Nat(String name, String netInterface, String intranetAddress,
			String netAddress) throws Exception {
		try {
			opr.SwitchToDefault();
			goOneToOnePage();
			opr.SwitchToFrame();
			
			//根据名称确定要修改的是哪一行
			int con = CommonTable.getRowByColString(p1T1Nat.tabOneToOneNet(), name, 1);
			
			//配置公网接口
			if(netInterface != null) {
				opr.Click(CommonTable.getCellObject(p1T1Nat.tabOneToOneNet(), con, 2));
				opr.Select(p1T1Nat.slecNetInterface(), netInterface);
				sleep(1);
			}
			
			//配置内网地址
			if(intranetAddress != null) {
				opr.Click(CommonTable.getCellObject(p1T1Nat.tabOneToOneNet(), con, 3));
				opr.SendKeys(p1T1Nat.textIntranetAddress(), intranetAddress);
				sleep(1);
			}
			
			//配置公网地址
			if(intranetAddress != null) {
				opr.Click(CommonTable.getCellObject(p1T1Nat.tabOneToOneNet(), con, 4));
				opr.SendKeys(p1T1Nat.textNetAddr(), netAddress);
				sleep(1);
			}
			
			opr.Click(CommonTable.getCellObject(p1T1Nat.tabOneToOneNet(), con, 5));
			
			//点击确认
			opr.Click(pTree.btnConfirm());		
			return true;
		}catch (Exception e) {
			Error("修改一对一NAT异常");
			e.printStackTrace();
			return false;
	}
	}	
	
	public boolean delet1To1Nat(String name) throws Exception {
		try {
			opr.SwitchToDefault();
			goOneToOnePage();
			opr.SwitchToFrame();
			
			//确定要删除的对象在哪一行
			int con = CommonTable.getRowByColString(p1T1Nat.tabOneToOneNet(), name, 1);
			opr.Click(p1T1Nat.spnDelete1T1Nat(con));			
			//点击确认
			opr.Click(pTree.btnConfirm());
			return true;		
		}catch (Exception e) {
			Error("删除一对一NAT异常");
			e.printStackTrace();
			return false;
	}
	
	}
	
}
