package dp.devweb.FW.tasks;

import dp.devweb.FW.appobject.NatPage;
import dp.devweb.FW.appobject.TreeMenuPage;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;
import dp.devweb.common.CommonTable;

/**   
 * @Title: SourceNat.java 
 * @Description: TODO(对源NAT及目的NAT的操作) 
 * @author z01674 
 * @date 2015年5月12日 上午11:32:31 
 * @version V4.4   
 */
public class Nat extends CommonObjectScript {

	public TreeMenuPage pTree = new TreeMenuPage();
	public NatPage pNat = new NatPage();	
	public CommonOperator opr = new CommonOperator();

	public boolean goSourceNatPage() throws Exception {
		try {
			// 切换到左侧windows
			opr.SwitchToDefault();
			Debug("进入 源NAT 页面");
			Debug("点击 防火墙 → 源NAT");      
			opr.ClickToOpen(pTree.liFireWall(), pTree.lnkFireWall());
			Thread.sleep(1000);
//			opr.Click(pTree.lnkSourceNat());
			// 根据源NAT定位链接，有两个元素，取第二个操作
			opr.Click(pTree.lnkSourceNats().get(1));
			
			Thread.sleep(1000);
			return true;
		} catch (Exception e) {
			Error("进入 源NAT页面异常");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean addSourceNat(String name, String intf) throws Exception {
		try {
			// 进入源NAT页面
			opr.SwitchToDefault();
			goSourceNatPage();
			opr.SwitchToFrame();
			
			// 获取第一行nat名称，判断nat列表是否为空
			String firstName = CommonTable.getCellString(pNat.tblSourceNat(), 0, 1);
			
			if (firstName.equals("请输入名称")) {				

				Debug("输入名称： " + name);
				opr.Click(CommonTable.getCellObject(pNat.tblSourceNat(), 0, 1));
				sleep(1);
				opr.SendKeys(pNat.txtName(), name);
				sleep(1);
				
				// 名称文本会遮挡端口，点击动态端口NAT
				opr.Click(pNat.rdoDynamicPort());
				sleep(1);

				Debug("选择接口： " + intf);
				opr.Click(CommonTable.getCellObject(pNat.tblSourceNat(), 0, 2));
				sleep(1);
				opr.Select(pNat.sltOutInterface(), intf);
				sleep(2);
				
				Debug("发起方");
				opr.Click(CommonTable.getCellObject(pNat.tblSourceNat(), 0, 3));
				sleep(1);
				//点击确定
				opr.clickOK();
				//点击空白处
				opr.Click(pNat.xuhao1());
				sleep(2);
				Debug("点击确认");
				opr.Click(pTree.btnConfirm());
				
			} else {
				Debug("点击 复制");
				opr.Click(pNat.spnCopy());

				// 确认要增加的路由所在行
				int row = CommonTable.getRowByColString(
						pNat.tblSourceNat(), "请输入名称", 1);

				Debug("输入名称： " + name);
				opr.Click(CommonTable.getCellObject(pNat.tblSourceNat(), row, 1));				
				opr.SendKeys(pNat.txtName(), name);
				
				// 名称文本会遮挡端口，点击动态端口NAT
				opr.Click(pNat.rdoDynamicPort());

				Debug("选择接口： " + intf);
				opr.Click(CommonTable.getCellObject(pNat.tblSourceNat(), row, 2));	
				sleep(1);
				opr.Select(pNat.sltOutInterface(), intf);
				sleep(1);
				
				//点击空白处
				opr.Click(pNat.rdoDynamicPort());
				sleep(2);
				Debug("点击确认");
				opr.Click(pTree.btnConfirm());
				
			}
			
			
			return true;
		} catch (Exception e) {
			Error("增加源NAT异常");
			e.printStackTrace();
			return false;
		}
	}
	
	//修改源Nat出接口
	public boolean modifySourceNatOutIntf(String name, String outIntf) throws Exception {
		try{
			// 进入源NAT页面
			opr.SwitchToDefault();
			goSourceNatPage();
			opr.SwitchToFrame();
			//确定要更改的是哪一行
			opr.Click(CommonTable.getCellObject(pNat.tblSourceNat(), 0, 2));
			sleep(1);
			//修改出接口
			opr.Select(pNat.sltOutInterface(), outIntf);
			sleep(1);
			//点击发起房触发接口选择
			opr.Click(CommonTable.getCellObject(pNat.tblSourceNat(), 0, 3));
			sleep(1);
			//点击确定
			opr.clickOK();
//			//点击空白处
//			opr.Click(pNat.xuhao1());
//			sleep(2);
			Debug("点击确认");
			opr.Click(pTree.btnConfirm());
			return true;
		}catch (Exception e) {
			Error("修改源NAT异常");
			e.printStackTrace();
			return false;
		}
	}
	
	//修改发起方源IP为any
	public boolean trueAny(String name ) throws Exception {
		try{
			// 进入源NAT页面
			opr.SwitchToDefault();
			goSourceNatPage();
			opr.SwitchToFrame();
			//确定要更改的行
			int con = CommonTable.getRowByColString(pNat.tblSourceNat(), name, 1);
			//点击源nat发起方源IP地址对象
			opr.Click(CommonTable.getCellObject(pNat.tblSourceNat(), con, 3));
			//点击要更改的对象
			opr.ClickToState(pNat.checkAny(), true);
			sleep(1);	
			//点击确定
			opr.JsClick(pTree.btnOK());;
			//点击确认
			opr.clickConfirm();
			return true;
		}catch (Exception e) {
			Error("源IP修改为any异常");
			e.printStackTrace();
			return false;
		}
	}
	
	//修改源NAT发起方源IP
	public boolean modifySourceNatSourceIP(String name ,String addrObject , String IpObject) throws Exception{
		try{
			// 进入源NAT页面
			opr.SwitchToDefault();
			goSourceNatPage();
			opr.SwitchToFrame();
			
			//点击要更改的对象
			opr.Click(CommonTable.getCellObject(pNat.tblSourceNat(), 0, 3));
			sleep(1);
			
			//将any选项去勾选
			opr.ClickToState(pNat.checkAny(), false);
			sleep(1);
			
			//选择地址对象
			opr.Select(pNat.selObject(), addrObject);
			sleep(1);
			
			//选择已选项
			opr.Select(pNat.selReserve(), IpObject);
			sleep(1);
			
			//向右增加
			opr.Click(pNat.moveRight());
			sleep(1);
			
			//点击确定按钮
			opr.JsClick(pNat.buttonOK());
			
			//点击确认
			opr.clickConfirm();
			return true;
		}catch (Exception e) {
			Error("修改源NAT发起方源IP异常");
			e.printStackTrace();
			return false;
		}
	}
	
	//修改发起方目的IP为any
	public boolean trueAnyDes(String name) throws Exception {
		try{
			// 进入源NAT页面
			opr.SwitchToDefault();
			goSourceNatPage();
			opr.SwitchToFrame();
			//确定要更改的行
			int con1 = CommonTable.getRowByColString(pNat.tblSourceNat(), name, 1);
			//点击源nat发起方源IP地址对象
			opr.Click(CommonTable.getCellObject(pNat.tblSourceNat(), con1, 4));
			//点击要更改的对象
			opr.ClickToState(pNat.checkAnyDes(), true);
		    sleep(1);	
			//点击确定
			opr.JsClick(pTree.btnOK());;
			//点击确认
			opr.clickConfirm();
			return true;
		}catch (Exception e) {
			Error("目的IP修改为any异常");
			e.printStackTrace();
			return false;
		}
	}
	
	
	//修改源NAT发起方目的IP
	public boolean modifySourceNatDesIp(String name,String addrObject , String IpObject) throws Exception {
		try {
			// 进入源NAT页面
			opr.SwitchToDefault();
			goSourceNatPage();
			opr.SwitchToFrame();
			
			//点击源Nat发起方目的IP
			opr.Click(CommonTable.getCellObject(pNat.tblSourceNat(), 0, 4));
			sleep(1);
			
			//any选项去勾选
			opr.ClickToState(pNat.checkAnyDes(), false);
			
			//选择地址对象
			opr.Select(pNat.selAddrObjectDes(), addrObject);
			sleep(1);
			
			//选择备选项
			opr.Select(pNat.selReserveDes(), IpObject);
			sleep(1);
			
			//向右增加
			opr.Click(pNat.moveRightDes());
			sleep(1);
                    
			//点击确定
			opr.JsClick(pNat.buttonOK());
			
			//点击确认
			opr.clickConfirm();		
			return true;
		}catch (Exception e) {
			Error("修改源NAT发起方目的IP异常");
			e.printStackTrace();
			return false;
		}
	}
	
	//修改源NAT服务
	public boolean modifySourceNatService(String name , String Service, String object) throws Exception {
		
		try{
			// 进入源NAT页面
			opr.SwitchToDefault();
			goSourceNatPage();
			opr.SwitchToFrame();
			
			//根据要修改的名称确定在哪一行
			int con = CommonTable.getRowByColString(pNat.tblSourceNat(), name, 1);
			
			//点击源Nat服务
			opr.Click(CommonTable.getCellObject(pNat.tblSourceNat(), con, 5));
			sleep(1);
			
			if(Service.equals("Any")) {
				//勾选any
				opr.ClickToState(pNat.checkAnyService(), true);
				sleep(1);
				//点击确定
//				opr.JsClick(pNat.buttonOKService());
			}else if(Service.equals("服务组")) {
				opr.ClickToState(pNat.checkServiceGroup(), true);
				sleep(1);
				opr.Select(pNat.selServiceGroup(), object);
				sleep(1);
				//点击确定
//				opr.JsClick(pNat.buttonOKService());
			}else if(Service.equals("自定义服务对象")) {
				opr.ClickToState(pNat.checkUserServiceObj(), true);
				sleep(1);
				opr.Select(pNat.selUserServiceObj(), object);
				sleep(1);
				//点击确定
//				opr.JsClick(pNat.buttonOKService());
			}else if(Service.equals("预定义服务对象")) {
				opr.ClickToState(pNat.checkPreServiceObject(), true);
				sleep(1);
				opr.Select(pNat.selPreServiceObject(), object);
				sleep(1);	
			}	
			//点击确定
			opr.JsClick(pTree.btnOK());
			//点击确认
			opr.clickConfirm();
		  return true;
		} catch (Exception e) {
			Error("修改源NAT服务异常");
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	//修改源Nat状态是启用还是禁用
	public boolean modifySourceNatState(String name, String state) throws Exception {
		try {
			// 进入源NAT页面
			opr.SwitchToDefault();
			goSourceNatPage();
			opr.SwitchToFrame();
			//确定要更改的是哪一行
			int con = CommonTable.getRowByColString(pNat.tblSourceNat(), name, 1);
			opr.Click(CommonTable.getCellObject(pNat.tblSourceNat(), con, 10));
			sleep(1);
			opr.Select(pNat.selState(), state);	
			sleep(1);
			opr.Click(CommonTable.getCellObject(pNat.tblSourceNat(), con, 1));
			//点击确认
			opr.clickConfirm();
			return true;
		}catch (Exception e) {
			Error("修改源NAT异常");
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	public boolean verifySourceNat(String name) throws Exception {
		try {
			// 进入源NAT页面
			opr.SwitchToDefault();
			goSourceNatPage();
			opr.SwitchToFrame();
			
			return CommonTable.isStringExsited(pNat.tblSourceNat(), name, 1);
		} catch (Exception e) {
			Error("查找源NAT异常");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteSourceNat(String name) throws Exception {
		try {
			// 进入源NAT页面
			opr.SwitchToDefault();
			goSourceNatPage();
			opr.SwitchToFrame();
			
			int row = CommonTable.getRowByColString(pNat.tblSourceNat(), name, 1);
			
			Debug("删除nat： " + name);
			opr.Click(pNat.spnDelete(row));
			
			Debug("点击确认");
			opr.Click(pTree.btnConfirm());
			
			return true;
		} catch (Exception e) {
			Error("删除源NAT异常");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean goDestNatPage() throws Exception {
		try {
			// 切换到左侧windows
			opr.SwitchToDefault();

			Debug("进入 目的NAT 页面");
			Debug("点击 防火墙 → 目的NAT");
			opr.ClickToOpen(pTree.liFireWall(), pTree.lnkFireWall());
			Thread.sleep(1000);
			// 根据源NAT定位链接，有两个元素，取第二个操作
			opr.Click(pTree.lnkDestNats().get(1));			
			Thread.sleep(1000);
			
			return true;
		} catch (Exception e) {
			Error("进入 目的NAT页面异常");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean addDestNat(String name, String inIntf, String pubIP, String minIP, String maxIP) throws Exception {
		try {
			opr.SwitchToDefault();
			// 进入目的NAT页面
			goDestNatPage();
			opr.SwitchToFrame();
			
			// 获取第一行nat名称，判断nat列表是否为空
			String firstName = CommonTable.getCellString(pNat.tblDestNat(), 0, 1);
			
			if (firstName.contains("请配置名称")){

			// 点击 name 输入名称
			opr.Click(CommonTable.getCellObject(pNat.tblDestNat(), 0, 1));				
			opr.SendKeys(pNat.txtDestName(), name);
			opr.Click(pNat.topDestNat());
			
			// 选择入接口
			opr.Click(CommonTable.getCellObject(pNat.tblDestNat(), 0, 2));	
			opr.Select(pNat.sltInInterface(), inIntf);
			
			// 输入公网IP
			opr.Click(CommonTable.getCellObject(pNat.tblDestNat(), 0, 3));	
			opr.SendKeys(pNat.txtPublicIP(), pubIP);
			
			// 输入内网IP
			opr.Click(CommonTable.getCellObject(pNat.tblDestNat(), 0, 5));
			sleep(1);
			opr.SendKeys(pNat.txtMinIP(), minIP);
			opr.SendKeys(pNat.txtMaxIP(), maxIP);
			
			}else{
				// 点击 复制
				opr.Click(pNat.spnDestCopy());
				
				//获取行
				int row = CommonTable.getRowByColString(pNat.tblDestNat(), "请配置名称", 1);
				
				// 点击 name 输入名称
				opr.Click(CommonTable.getCellObject(pNat.tblDestNat(), row, 1));				
				opr.SendKeys(pNat.txtDestName(), name);
				
				// 选择入接口
				opr.Click(CommonTable.getCellObject(pNat.tblDestNat(), row, 2));	
				opr.Select(pNat.sltInInterface(), inIntf);
				
				// 输入公网IP
				opr.Click(CommonTable.getCellObject(pNat.tblDestNat(), row, 3));	
				opr.SendKeys(pNat.txtPublicIP(), pubIP);
				
				// 输入内网IP
				opr.Click(CommonTable.getCellObject(pNat.tblDestNat(), row, 5));
				sleep(1);
				opr.SendKeys(pNat.txtMinIP(), minIP);
				opr.SendKeys(pNat.txtMaxIP(), maxIP);
			}			
			
			// 点击确定
			opr.Click(pTree.btnOK());
			
			// 点击确认
			opr.Click(pTree.btnConfirm());	
			
			return true;
		} catch (Exception e) {
			Error("增加 目的NAT异常 \n" + e);
			return false;
		}
	}
	
	public boolean verifyDestNat(String name) throws Exception {
		try {
			opr.SwitchToDefault();
			// 进入源NAT页面
			goDestNatPage();
			opr.SwitchToFrame();
			
			return CommonTable.isStringExsited(pNat.tblDestNat(), name, 1);
		} catch (Exception e) {
			Error("查找目的NAT异常 \n" + e);
			return false;
		}
	}
	
	public boolean deleteDestNat(String name) throws Exception {
		try {
			opr.SwitchToDefault();
			// 进入源NAT页面
			goDestNatPage();
			opr.SwitchToFrame();
			
			int row = CommonTable.getRowByColString(pNat.tblDestNat(), name, 1);
			
			opr.Click(pNat.spnDestDelete(row));
			
			opr.Click(pTree.btnConfirm());
			
			return true;
		} catch (Exception e) {
			Error("删除目的NAT异常 \n " + e);
			return false;
		}
	}
	
	//修改目的NAT入接口
	public boolean modifyDestNatInInterf(String name , String Interf) throws Exception {
		try {
			//进入到默认配置界面
			opr.SwitchToDefault();
			goDestNatPage();
			opr.SwitchToFrame();
			
			//根据名称确定要修改的在第几行
			int row = CommonTable.getRowByColString(pNat.tblDestNat(), name, 1);
			
			//点击入接口
			opr.Click(CommonTable.getCellObject(pNat.tblDestNat(), row, 2));
			
			//选择接口
			opr.Select(pNat.sltInInterface(), Interf);
			sleep(1);
			opr.Click(CommonTable.getCellObject(pNat.tblDestNat(), row, 3));
				
			//点击确认
			opr.Click(pTree.btnConfirm());
			
			return true;
		}catch (Exception e) {
			Error("改变目的NAT入接口异常 \n " + e);
			return false;
	}	
}
	
	//修改目的NAT公网IP地址
	public boolean modifyDestNatPubIP(String name ,String NETIP) throws Exception {
		try {
			//进入到默认配置界面
			opr.SwitchToDefault();
			goDestNatPage();
			opr.SwitchToFrame();
			
			//根据名称确定要修改的在第几行
			int row = CommonTable.getRowByColString(pNat.tblDestNat(), name, 1);
			
			//点击公网IP
			opr.Click(CommonTable.getCellObject(pNat.tblDestNat(), row, 3));
			
			//下发公网IP
			opr.SendKeys(pNat.txtPublicIP(), NETIP);
			opr.Click(CommonTable.getCellObject(pNat.tblDestNat(), row, 2));
			
			//点击确认
			opr.Click(pTree.btnConfirm());;
			
			return true;
		}catch (Exception e) {
			Error("修改目的NAT公网IP异常 \n " + e);
			return false;
	}	
	}
	
	//修改目的NAT服务
	public boolean modifyDestNatService(String name ,String service) throws Exception {
		try {
			//进入到默认配置界面
			opr.SwitchToDefault();
			goDestNatPage();
			opr.SwitchToFrame();
			
			//根据名称确定要修改的在第几行
			int row = CommonTable.getRowByColString(pNat.tblDestNat(), name, 1);
			
			//点击公网IP
			opr.Click(CommonTable.getCellObject(pNat.tblDestNat(), row, 4));
			sleep(1);
			
			//修改服务
			if(service.equals("All")) {
				opr.ClickToState(pNat.checkAllDestNat(), true);	
				sleep(1);
			}else if(service.equals("ftp")){
				opr.ClickToState(pNat.checkSelectService(), true);
				sleep(1);
				opr.ClickToState(pNat.ftpServ(), true );
				sleep(1);
			}else if(service.equals("telnet")) {
				opr.ClickToState(pNat.checkSelectService(), true);
				sleep(1);
				opr.ClickToState(pNat.telnetServ(), true);
				sleep(1);
			}else if(service.equals("smtp")) {
				opr.ClickToState(pNat.checkSelectService(), true);
				sleep(1);
				opr.ClickToState(pNat.smtpServ(), true);
				sleep(1);
			}else if(service.equals("http")) {
				opr.ClickToState(pNat.checkSelectService(), true);
				sleep(1);
				opr.ClickToState(pNat.httpServ(), true);
				sleep(1);
			}else if(service.equals("https")) {
				opr.ClickToState(pNat.checkSelectService(), true);
				sleep(1);
				opr.ClickToState(pNat.httpsServ(), true);
				sleep(1);
			}else if(service.equals("icmp")) {
				opr.ClickToState(pNat.checkSelectService(), true);
				sleep(1);
				opr.ClickToState(pNat.icmpServ(),true);
				sleep(1);
			}
					
			//点击确定
			opr.JsClick(pNat.OKDestNatServ());
			 
			//点击确认
			opr.clickConfirm();	
			return true;
		}catch (Exception e) {
			Error("修改目的NAT服务异常\n" + e);
			return false;
		}
	}
	
	//修改目的NAT内网地址
	public boolean modifyDestNATInAddr(String name ,String minIP,String maxIP) throws Exception{
		try{
			opr.SwitchToDefault();
			goDestNatPage();
			opr.SwitchToFrame();
			
			//根据名称确定要修改的在第几行
			int row = CommonTable.getRowByColString(pNat.tblDestNat(), name, 1);
			
			//点击内网地址
			opr.Click(CommonTable.getCellObject(pNat.tblDestNat(), row, 5));
			sleep(1);
			
			//输入最小IP地址
			opr.SendKeys(pNat.txtMinIP(), minIP);
			sleep(1);
			opr.SendKeys(pNat.txtMaxIP(), maxIP);
			sleep(1);
			
			//点击确定
			opr.JsClick(pTree.btnOK());
			
			//点击确认
			opr.Click(pTree.btnConfirm());
			return true;
		}catch(Exception e) {
			Error("修改目的NAT内网地址异常\n" +e);
			return false ;
		}
		
	}
	
	//修改目的NAT高级配置,添加内网端口
	public boolean modefyDestNATAdvanceConfigAdd(String name ,int port) throws Exception {
		try {
			opr.SwitchToDefault();
			goDestNatPage();
			opr.SwitchToFrame();
			
			//根据名称确定要修改的在第几行
			int row = CommonTable.getRowByColString(pNat.tblDestNat(), name, 1);
			
			//点击高级配置
			opr.Click(CommonTable.getCellObject(pNat.tblDestNat(), row, 6));
			sleep(1);
			
			//勾选内网端口框
			opr.ClickToState(pNat.checkInnerPort(), true);
			sleep(1);
			
			//内网端口文本输入框中输入端口
			opr.SendKeys(pNat.textInnerPort(), ""+port+"");
			
			//点击确定
			opr.Click(pTree.btnOK());
			
			//点击确认
			opr.Click(pTree.btnConfirm());
			return true;
		}catch(Exception e) {
			Error("修改目的NAT高级配置异常\n" +e);
			return false;
		}
	}
	
	//修改目的NAT高级配置，删除内网端口
	public boolean modifyDestAdvanceConfDelete(String name) throws Exception {
		try {
			opr.SwitchToDefault();
			goDestNatPage();
			opr.SwitchToFrame();
			
			//根据名称确定要修改的在第几行
			int row = CommonTable.getRowByColString(pNat.tblDestNat(), name, 1);
			
			//点击高级配置
			opr.Click(CommonTable.getCellObject(pNat.tblDestNat(), row, 6));
			sleep(1);
			
			//去勾选内网端口框
			opr.ClickToState(pNat.checkInnerPort(), false);
			sleep(1);
					
			//点击确定
			opr.Click(pTree.btnOK());;
			
			//点击确认
			opr.Click(pTree.btnConfirm());
			return true;
		}catch(Exception e) {
			Error("修改目的NAT高级配置异常\n" +e);
			return false;
		}
	}
	
	//修改目的NAT状态
	public boolean modifyDestNATState(String name ,String state) throws Exception {
		try {
			opr.SwitchToDefault();
			goDestNatPage();
			opr.SwitchToFrame();
			
			//根据名称确定要修改的在第几行
			int row = CommonTable.getRowByColString(pNat.tblDestNat(), name, 1);
			
			//点击高级配置
			opr.Click(CommonTable.getCellObject(pNat.tblDestNat(), row, 8));
			sleep(1);
			
            //选择状态
			opr.Select(pNat.selectDestNATStates(), state);
			opr.Click(CommonTable.getCellObject(pNat.tblDestNat(), row, 1));
			
			//点击确认
			opr.Click(pTree.btnConfirm());
			return true;
		}catch(Exception e) {
			Error("修改目的NAT高级配置异常\n" +e);
			return false;
		}
	}

	
}
