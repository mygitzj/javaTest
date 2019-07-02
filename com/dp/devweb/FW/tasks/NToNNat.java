package dp.devweb.FW.tasks;

import dp.devweb.FW.appobject.NToNNatPage;
import dp.devweb.FW.appobject.TreeMenuPage;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;
import dp.devweb.common.CommonTable;

/**
 * 
* @Title: NToNNat.java 
* @Description: TODO(多对多NAT页面操作方法) 
* @author z01674 
* @date 2015年4月27日 上午11:23:29 
* @version V4.4
 */

public class NToNNat extends CommonObjectScript{
	public TreeMenuPage  pTree = new TreeMenuPage();
    public CommonOperator opr = new CommonOperator();
    public NToNNatPage pNtoN = new NToNNatPage();
    
    /**
     * @return 多对多配置界面
     * @throws Exception
     */
    public boolean goNToNNat() throws Exception {
    	try {
    	    //切换到左侧窗口
    		opr.SwitchToDefault();
    		
    		Info("基本--防火墙--多对多NAT");
    		opr.ClickToOpen(pTree.liFireWall(), pTree.lnkFireWall());
    		sleep(1);
    		opr.Click(pTree.lnkNtoNNat());
    		sleep(1);	
    		return true;
    	}catch (Exception e) {
			Error("进入多对多NAT页面异常");
			e.printStackTrace();
			return false;
    	}
    }
    
    /**
     * @return 增加多对多NAT
     * @throws Exception
     */
    public boolean addNToNNat(String interf, String inAddress, String natAddress) throws Exception {
    	try {
    		opr.SwitchToDefault();
    		//进入到表格界面
    		goNToNNat();
    		opr.SwitchToFrame();
    	    
    		Info ("获取第0行第1列单元格的内容，判断是否存在多对多NAT");
    		String str = CommonTable.getCellString(pNtoN.tablNToNNat(), 0, 1);
    		if (str.equals("请选择公网接口")) {
    			
    			Info("不存在多对多NAT");
    			Debug ("点击配置接口,选择接口" + interf);
    			
    			opr.Click(CommonTable.getCellObject(pNtoN.tablNToNNat(), 0, 1));
    			sleep(1);
    			opr.Select(pNtoN.textNetInterface(), interf);
    			sleep(1);
    			
    			Debug ("配置内网IP地址" + inAddress);
    			opr.Click(CommonTable.getCellObject(pNtoN.tablNToNNat(), 0, 2));
    			sleep(1);
    			opr.SendKeys(pNtoN.textInAddr(), inAddress);
    			
    			Debug ("配置公网IP地址" + natAddress);
    			opr.Click(CommonTable.getCellObject(pNtoN.tablNToNNat(), 0, 3));
    			sleep(1);
    			opr.SendKeys(pNtoN.textNetAddr(), natAddress);
    			sleep(1);
    			
    			//点击空白处
    			pNtoN.xuhao().click();
    			
    		}else {
    			Info("已经存在多对多NAT，点击复制");
    			opr.Click(pNtoN.spnCopy());
    			
    			//获取新增加的一行所在的行数
    			int row = CommonTable.getRowByColString(pNtoN.tablNToNNat(), "请输入内网地址", 2);
    			opr.Click(CommonTable.getCellObject(pNtoN.tablNToNNat(), row, 1));
    			sleep(1);
    			opr.Select(pNtoN.textNetInterface(), interf);
    			sleep(1);
    			
    			Debug ("配置内网IP地址" + inAddress);
    			opr.Click(CommonTable.getCellObject(pNtoN.tablNToNNat(), row, 2));
    			sleep(1);
    			opr.SendKeys(pNtoN.textInAddr(), inAddress);
    			
    			Debug ("配置公网IP地址" + natAddress);
    			opr.Click(CommonTable.getCellObject(pNtoN.tablNToNNat(), row, 3));
    			sleep(1);
    			opr.SendKeys(pNtoN.textNetAddr(), natAddress);
    			sleep(1);
    			
    			//点击空白处
    			pNtoN.black().click();	
    		}  
    		
    		Info ("点击确认");
    		opr.Click(pTree.btnConfirm());
    		return true;
    	}catch (Exception e) {
			Error("增加多对多NAT异常");
			e.printStackTrace();
			return false;
    	}	
    }
    
//    /**
//     * @param interf
//     * @param inAddr
//     * @param natAddr
//     * @return 修改多对多NAT
//     * @throws Exception
//     */
//    public boolean modifyNtoNNat(String interf, String inAddr ,String natAddr) throws Exception {
//    	try {
//    		opr.SwitchToDefault();
//    		goNToNNat();
//    		opr.SwitchToFrame();
//    		if (interf != null) {
//    			
//    		}
//    		
//    		return true;
//    	}catch (Exception e) {
//			Error("修改多对多NAT异常");
//			e.printStackTrace();
//			return false;
//    	}	
//    }
    
    /**
     * @return 每次都删除第一个
     * @throws Exception
     */
    public boolean delNTNNat() throws Exception {
    	try {
    		opr.SwitchToDefault();
    		goNToNNat();
    		opr.SwitchToFrame();
    		opr.Click(pNtoN.spnDelet());
    		opr.Click(pTree.btnConfirm());
    		return true;
    	}catch (Exception e) {
			Error("删除多对多NAT异常");
			e.printStackTrace();
			return false;
    	}
    }
   
}
