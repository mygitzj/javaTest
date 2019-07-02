package dp.devweb.FW.tasks;

import dp.devweb.FW.appobject.PacketFilterPage;
import dp.devweb.FW.appobject.TreeMenuPage;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;
import dp.devweb.common.CommonTable;

/**
 * @Title: PacketFilter.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author w01866
 * @date 2015年1月5日 下午2:27:14
 * @version V4.4
 */

/**
 * 
* @Title: PacketFilter.java 
* @Description: TODO(增加修改包过滤策略方法，修改增加包过滤策略方法) 
* @author z01674 
* @date 2015年4月11日 下午3:05:22 
* @version V4.4
 */
public class PacketFilter extends CommonObjectScript {
	public PacketFilterPage pPacket = new PacketFilterPage();
	public TreeMenuPage pTree = new TreeMenuPage();
	public CommonOperator opr = new CommonOperator();

	/**
	 * 进入包过滤策略页面
	 * 
	 * @return 成功true 失败false
	 * @throws Exception
	 */
	public boolean goPacketFilter() throws Exception {
		try {
			opr.SwitchToDefault();
			Debug("防火墙 → 包过滤策略");
			opr.ClickToOpen(pTree.liFireWall(), pTree.lnkFireWall());
			sleep(1);
			pTree.lnkPacketFilter().click();
			return true;
		} catch (Exception e) {
			Error("进入包过滤策略页面异常");
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 
	 * @return 进入防火墙界面适用于DPX设备
	 * @throws Exception
	 */
	public boolean goFirWall() throws Exception {
		try {
			Debug("进入防火墙界面");
			opr.Click(pTree.topFirWall());
			return true;
		}catch (Exception e) {
			Error("进入防火墙界面错误");
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * @return 进入包过滤界面(适用于DPX设备)
	 * @throws Exception
	 */
	public boolean goPacketFilterPageDPX() throws Exception {
		try {
			opr.SwitchToDefault();
			sleep(1);
			Debug("进入防火墙界面");
			opr.Click(pTree.topFirWall());
			opr.SwitchToMenuFrame();
			Debug("打开防火墙菜单");
			sleep(1);
			opr.ClickToOpen(pTree.liFireWallDPX(), pTree.lnkFireWall());
			Debug("点击包过滤");
			pTree.lnkPacketFilter().click();
			return true;
		}catch (Exception e) {
			Error("进入DPX设备包过滤策略异常");
			e.printStackTrace();
			return false ;
		}
	}
	
	
	
	
	
	
	
	//判断第一行第一列的内容
	public  boolean  panduan( ) throws Exception {
		boolean flag = false;
		try {
			opr.SwitchToDefault();
			// 进入包过滤策略页面
			goPacketFilter();

			// 切换到右侧frame
			opr.SwitchToFrame();
		
			Info("判断是否存在包过滤策略");
			String str = CommonTable.getCellString(pPacket.tblPacketFilter(), 0, 2);
			System.out.println(str);
			Info("返回结果是" + str);
		
			if (str.equals("Name") ) {
				Info("123");
				flag = true;		
			}
			System.out.print(flag);
			return true;
		}catch (Exception e) {
			Error("判断异常");
			e.printStackTrace();
			return false;
		}
		
	}

	/**
	 * 增加包过滤策略
	 * 
	 * @param name
	 *            名称
	 * @param sZone
	 *            源域
	 * @param dZone
	 *            目的域
	 * @param sName
	 *            源地址
	 * @param dName
	 *            目的地址
	 * @param service
	 *            服务类型
	 * @param serviceNames
	 *            服务名
	 * @param time
	 *            生效时间
	 * @param action
	 *            动作
	 * @param state
	 *            状态
	 * @return 成功true 失败false
	 * @throws Exception
	 */
	public boolean addPacketFilter(String name, String sZone, String dZone,
			String sName, String dName, String[] service,
			String[] serviceNames, String time, String action, String state)
			throws Exception {
		try {
			
			// 进入包过滤策略页面
			goPacketFilter();

			// 切换到右侧frame
			opr.SwitchToFrame();

			Debug("点击 向下复制");
			pPacket.spnCopyDown().click();

			// 确定新增加的包过滤策略所在行
			int row = CommonTable.getRowByColString(pPacket.tblPacketFilter(),
					"New Name", 2);

			Debug("输入名称： " + name);
			CommonTable.getCellObject(pPacket.tblPacketFilter(), row, 2)
					.click();
			opr.SendKeys(pPacket.txtName(), name);

			// 源域、目的域
			Debug("选择源域： " + sZone + "\t" + "选择目的域： " + dZone);
			CommonTable.getCellObject(pPacket.tblPacketFilter(), row, 4)
					.click();
			opr.Select(pPacket.sltZone(), sZone);
			CommonTable.getCellObject(pPacket.tblPacketFilter(), row, 5)
					.click();
			opr.Select(pPacket.sltZone(), dZone);

			// 源地址、目的地址
			Debug("选择源地址： " + sName + "\t" + "选择目的地址： " + dName);
			if (sName != null) {
				CommonTable.getCellObject(pPacket.tblPacketFilter(), row, 8)
						.click();
				sleep(1);
				opr.ClickToState(pPacket.chkAny(), false);
				sleep(1);
				opr.Select(pPacket.sltOptionAddrLeft(), sName);
				pPacket.btnAddNet().click();
				sleep(1);
				opr.JsClick(pTree.btnOK());
				sleep(2);
			}
			if (dName != null) {
			CommonTable.getCellObject(pPacket.tblPacketFilter(), row, 9)
					.click();
			sleep(1);
			opr.ClickToState(pPacket.chkAny(), false);
			sleep(1);
			opr.Select(pPacket.sltOptionAddrLeft(), dName);
			pPacket.btnAddNet().click();
			sleep(1);
			}
			
//			if (sName != null) {
//				opr.Select(pPacket.sltOptionAddrRight(), sName);
//				pPacket.btnDelNet().click();
//				sleep(1);
//			}
//			opr.JsClick(pTree.btnOK());
//			}
//			sleep(2);

			// 更改服务方法，实现选择多个服务的方法
			if (serviceNames != null) {
				CommonTable.getCellObject(pPacket.tblPacketFilter(), row, 12)
					.click();
			for (int i = 0; i < service.length; i++) {
				sleep(2);
				Debug("选择： " + service[i] + "\t" + serviceNames);
				if (service[i].equals("预定义服务对象")) {
					opr.Select(pPacket.sltOptionService(), service[i]);
				}
			}
			for (int m = 0; m < serviceNames.length; m++) {
				sleep(2);
				if(serviceNames[m] !=null) {
					opr.Select(pPacket.sltOptionServiceLeft(), serviceNames[m]);
					pPacket.btnAddService().click();
					sleep(1);
				}
			}
				// if (service[i].equals("自定义服务对象")) {
				// opr.Select(pPacket.sltServiceKind(), service[i]);
				// opr.Select(pPacket.sltUserdefindService(), serviceNames[i]);
				// pPacket.btnAddService().click();
				// }
				// if (service[i].equals("服务组")) {
				// opr.Select(pPacket.sltServiceKind(), service[i]);
				// opr.Select(pPacket.sltService(), serviceNames[i]);
				// pPacket.btnAddService().click();
				// }
		
			Debug("点击 确定");
			opr.JsClick(pTree.btnOK());
			}
			sleep(2);

			Debug("生效时间选择： " + time);
			if (time != null) {
			CommonTable.getCellObject(pPacket.tblPacketFilter(), row, 14)
					.click();
			sleep(1);
			pPacket.rdoTime(time).click();
			pTree.btnOK().click();
			}
			sleep(2);
		
			
			Debug("动作选择： " + action);
			if (action != null) {
			CommonTable.getCellObject(pPacket.tblPacketFilter(), row, 15)
					.click();
			sleep(1);
			pPacket.rdoAction(action).click();
			pTree.btnOK().click();
			}
			sleep(2);
		

			Debug("状态选择： " + state);
			
			if (state != null)  {
			CommonTable.getCellObject(pPacket.tblPacketFilter(), row, 16)
					.click();
			opr.Select(pPacket.sltState(), state);
			sleep(2);
			}

			Debug("点击 确认");
			pTree.btnConfirm().click();
			return true;
		} catch (Exception e) {
			Error("增加包过滤策略异常");
			e.printStackTrace();
			return false;
		}
	}
	
	
	//更改包过滤策略中，向左移除不同的服务
	public boolean deleteService(String name, String delService ,String[] delServiceName) throws Exception {
		try {
			opr.SwitchToDefault();
			//进入包过滤策略界面
			goPacketFilter();
			
			//切换到右侧frame
			opr.SwitchToFrame();
			
			Info("删除服务");			
			if (delServiceName != null) {	
				CommonTable.getCellObjByColString(pPacket.tblPacketFilter(), name, 2, 12).click();	
				opr.Select(pPacket.sltOptionService(),delService);
				for(int i = 0;  i < delServiceName.length;  i++) {	
					if (delServiceName[i] != null) {	
						opr.Select(pPacket.sltOptionServiceRight(), delServiceName[i]);	
						pPacket.btnDelNet().click();
						sleep(1);
					}
				}
				Debug("点击 确定");
				opr.JsClick(pTree.btnOK());
				Debug("点击 确认");
				pTree.btnConfirm().click();		
			}return true;
		} catch (Exception e) {
			Error("删除服务异常");
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 验证包过滤策略是否存在
	 * 
	 * @param name
	 *            名称
	 * @return 成功true 失败false
	 * @throws Exception
	 */
	public boolean verifyPacketFilter(String name) throws Exception {
		try {
			opr.SwitchToDefault();
			// 进入包过滤策略页面
			goPacketFilter();

			// 切换到右侧frame
			opr.SwitchToFrame();
			Debug("查看包过滤策略是否存在：" + name);
			return CommonTable.isStringExsited(pPacket.tblPacketFilter(), name,
					2);
		} catch (Exception e) {
			Error("查看包过滤策略是否存在异常");
			e.printStackTrace();
			return false;
		}
	}
	
	//修改包过滤策略
	/**
	 * 
	 * @param name   给定要修改的包过滤策略名称
	 * @param sZone  给定修改的源域值
	 * @param dZone  给定修改的目的域值
	 * @param sAddr  给定修改的源地址值
	 * @param dAddr  给定修改的目的地址值
	 * @param service  给定修改的服务值
	 * @param serviceNames 给定修改的服务名称值
	 * @param time     给定修改的时间值
	 * @param action 	给定修改的动作
	 * @param state		给定修改的状态	
	 * @return        成功true，失败faile
	 * @throws Exception
	 */
		public boolean modifyPacketFilter(String name, String sZone, String dZone,
				String sAddr, String dAddr, String[] service,
				String[] serviceNames, String time, String action, String state) throws Exception {
			
			try {
				//进入到默认配置界面
				opr.SwitchToDefault();
				
				//进入到包过滤策略页面
				goPacketFilter();
				
				//切换到右侧frame
				opr.SwitchToFrame();
				
				//更改源域
				if (sZone != null) {
					Info("修改源域");
				CommonTable.getCellObjByColString(pPacket.tblPacketFilter(), name, 2, 4).click();
				opr.Select(pPacket.sltZone(), sZone);
				sleep(1);
				CommonTable.getCellObjByColString(pPacket.tblPacketFilter(), name, 2, 5).click();
				sleep(1);
				}
				
				//更改目的域
				if (dZone != null) {
					Info("修改目的域");
					CommonTable.getCellObjByColString(pPacket.tblPacketFilter(), name, 2, 5).click();
					opr.Select(pPacket.sltZone(), dZone);
					sleep(1);
					CommonTable.getCellObjByColString(pPacket.tblPacketFilter(), name, 2, 4).click();
					sleep(1);
				}
				
				//更改源地址  
				if (sAddr == "any") {
					Info ("修改源地址为any");
					CommonTable.getCellObjByColString(pPacket.tblPacketFilter(), name, 2, 8).click();
					sleep(1);
					opr.ClickToState(pPacket.chkAny(), true);
					sleep(1);
					opr.JsClick(pTree.btnOK());
					sleep(2);
				}else if (sAddr != null) {
					Info("修改源地址");
					CommonTable.getCellObjByColString(pPacket.tblPacketFilter(), name, 2, 8).click();
					sleep(1);
					opr.ClickToState(pPacket.chkAny(), false);
					sleep(1);
					opr.Select(pPacket.sltOptionAddrLeft(), sAddr);
					pPacket.btnAddNet().click();
					sleep(1);
					opr.JsClick(pTree.btnOK());
					sleep(2);
				}
				
				//更改目的地址
				if(dAddr == "any") {
					Info("修改目的地址为any");
					CommonTable.getCellObjByColString(pPacket.tblPacketFilter(), name, 2, 9).click();
					sleep(1);
					opr.ClickToState(pPacket.chkAny(), true);
					sleep(1);
					opr.JsClick(pTree.btnOK());
					sleep(2);
				}else if (dAddr != null) {
					Info("修改目的地址");
					CommonTable.getCellObjByColString(pPacket.tblPacketFilter(), name, 2, 9).click();
					sleep(1);
					opr.ClickToState(pPacket.chkAny(), false);
					sleep(1);
					opr.Select(pPacket.sltOptionAddrLeft(), dAddr);
					pPacket.btnAddNet().click();
					sleep(1);
					opr.JsClick(pTree.btnOK());
					sleep(2);
					}
				
				//修改服务 
				if (service != null) {
					Info ("修改服务");
					CommonTable.getCellObjByColString(pPacket.tblPacketFilter(), name, 2, 12).click();
					for (int m = 0; m <service.length; m++ ) {
						sleep(2);			
						if (service[m].equals("预定义服务对象")) {
							opr.Select(pPacket.sltOptionService(), service[m]);
							opr.Select(pPacket.sltOptionServiceLeft(), serviceNames[m]);
							pPacket.btnAddService().click();
							sleep(1);
							opr.JsClick(pTree.btnOK());
							sleep(2);
						}				
					}
				}
				
				if(time !=null) {
					Info("修改时间");
					CommonTable.getCellObjByColString(pPacket.tblPacketFilter(), name, 2, 14).click();
					sleep(1);
					pPacket.rdoTime(time).click();
					pTree.btnOK().click();
					sleep(2);		
				}
				
				if(action != null) {
					CommonTable.getCellObjByColString(pPacket.tblPacketFilter(), name, 2, 15).click();
					sleep(1);
					pPacket.rdoAction(action).click();
					pTree.btnOK().click();
					sleep(1);
				}
				
				if(state != null) {
					CommonTable.getCellObjByColString(pPacket.tblPacketFilter(), name, 2, 16).click();
					opr.Select(pPacket.sltState(), state);
					sleep(1);
					CommonTable.getCellObjByColString(pPacket.tblPacketFilter(), name, 2, 4).click();
					
				}
	
				Debug("点击确认");
				opr.Click(pTree.btnConfirm());
				sleep(1);
				return true;
			}catch (Exception e) {
				Error("修改包过滤策略是否存在异常");
				e.printStackTrace();
				return false;
			}
			
		}
	

	/**
	 * 删除包过滤策略
	 * 
	 * @param name
	 *            名称
	 * @return 成功true 失败false
	 * @throws Exception
	 */
	public boolean delPacketFilter(String name) throws Exception {
		try {
			opr.SwitchToDefault();
			// 进入包过滤策略页面
			goPacketFilter();

			// 切换到右侧frame
			opr.SwitchToFrame();

			Debug("删除包过滤策略：" + name);
			int row = CommonTable.getRowByColString(pPacket.tblPacketFilter(),
					name, 2) + 1;
			pPacket.spnDelPacket(String.valueOf(row)).click();

			Debug("点击 确认");
			pTree.btnConfirm().click();

			return true;
		} catch (Exception e) {
			Error("查看包过滤策略是否存在异常");
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean addPacketFilterDPX(String name, String sZone, String dZone,
			String sName, String dName, String[] service,
			String[] serviceNames, String time, String action, String state)
			throws Exception {
		try {
			
			// 进入包过滤策略页面
			goPacketFilterPageDPX();
			sleep(1);
			// 切换到右侧frame
			opr.SwitchToFrame1();
			sleep(1);
			Debug("点击 向下复制");
			pPacket.spnCopyDown().click();
			sleep(1);
			// 确定新增加的包过滤策略所在行
			int row = CommonTable.getRowByColString(pPacket.tblPacketFilter(),
					"New Name", 2);

			Debug("输入名称： " + name);
			CommonTable.getCellObject(pPacket.tblPacketFilter(), row, 2)
					.click();
			opr.SendKeys(pPacket.txtName(), name);

			// 源域、目的域
			Debug("选择源域： " + sZone + "\t" + "选择目的域： " + dZone);
			CommonTable.getCellObject(pPacket.tblPacketFilter(), row, 4)
					.click();
			opr.Select(pPacket.sltZone(), sZone);
			CommonTable.getCellObject(pPacket.tblPacketFilter(), row, 5)
					.click();
			opr.Select(pPacket.sltZone(), dZone);

//			// 源地址、目的地址
//			Debug("选择源地址： " + sName + "\t" + "选择目的地址： " + dName);
//			if (sName != null) {
//				CommonTable.getCellObject(pPacket.tblPacketFilter(), row, 8)
//						.click();
//				sleep(1);
//				opr.ClickToState(pPacket.chkAny(), false);
//				sleep(1);
//				opr.Select(pPacket.sltOptionAddrLeft(), sName);
//				pPacket.btnAddNet().click();
//				sleep(1);
//				opr.JsClick(pTree.btnOK());
//				sleep(2);
//			}
//			if (dName != null) {
//			CommonTable.getCellObject(pPacket.tblPacketFilter(), row, 9)
//					.click();
//			sleep(1);
//			opr.ClickToState(pPacket.chkAny(), false);
//			sleep(1);
//			opr.Select(pPacket.sltOptionAddrLeft(), dName);
//			pPacket.btnAddNet().click();
//			sleep(1);
//			}
			
//			if (sName != null) {
//				opr.Select(pPacket.sltOptionAddrRight(), sName);
//				pPacket.btnDelNet().click();
//				sleep(1);
//			}
//			opr.JsClick(pTree.btnOK());
//			}
//			sleep(2);

//			// 更改服务方法，实现选择多个服务的方法
//			if (serviceNames != null) {
//				CommonTable.getCellObject(pPacket.tblPacketFilter(), row, 12)
//					.click();
//			for (int i = 0; i < service.length; i++) {
//				sleep(2);
//				Debug("选择： " + service[i] + "\t" + serviceNames);
//				if (service[i].equals("预定义服务对象")) {
//					opr.Select(pPacket.sltOptionService(), service[i]);
//				}
//			}
//			for (int m = 0; m < serviceNames.length; m++) {
//				sleep(2);
//				if(serviceNames[m] !=null) {
//					opr.Select(pPacket.sltOptionServiceLeft(), serviceNames[m]);
//					pPacket.btnAddService().click();
//					sleep(1);
//				}
//			}
//				// if (service[i].equals("自定义服务对象")) {
//				// opr.Select(pPacket.sltServiceKind(), service[i]);
//				// opr.Select(pPacket.sltUserdefindService(), serviceNames[i]);
//				// pPacket.btnAddService().click();
//				// }
//				// if (service[i].equals("服务组")) {
//				// opr.Select(pPacket.sltServiceKind(), service[i]);
//				// opr.Select(pPacket.sltService(), serviceNames[i]);
//				// pPacket.btnAddService().click();
//				// }
//		
//			Debug("点击 确定");
//			opr.JsClick(pTree.btnOK());
//			}
//			sleep(2);
//
//			Debug("生效时间选择： " + time);
//			if (time != null) {
//			CommonTable.getCellObject(pPacket.tblPacketFilter(), row, 14)
//					.click();
//			sleep(1);
//			pPacket.rdoTime(time).click();
//			pTree.btnOK().click();
//			}
//			sleep(2);
//		
//			
//			Debug("动作选择： " + action);
//			if (action != null) {
//			CommonTable.getCellObject(pPacket.tblPacketFilter(), row, 15)
//					.click();
//			sleep(1);
//			pPacket.rdoAction(action).click();
//			pTree.btnOK().click();
//			}
			sleep(1);
//		
//
			Debug("状态选择： " + state);
			
			if (state != null)  {
			CommonTable.getCellObject(pPacket.tblPacketFilter(), row, 16)
					.click();
			opr.Select(pPacket.sltState(), state);
			sleep(2);
			}

			Debug("点击 确认");
			pTree.btnConfirm().click();
			return true;
		} catch (Exception e) {
			Error("增加包过滤策略异常");
			e.printStackTrace();
			return false;
		}
	}
	
	
	
}
