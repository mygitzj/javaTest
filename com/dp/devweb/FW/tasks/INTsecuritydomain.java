package dp.devweb.FW.tasks;
import dp.devweb.FW.appobject.INTsecuritydomainPage;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;
import dp.devweb.common.CommonTable;

/**   
 * @Title: INTsecuritydomain.java 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author z01674 
 * @date 2015年2月11日 下午4:19:20 
 * @version V4.4   
 */

/**
 * 继承
 */
public class INTsecuritydomain extends CommonObjectScript{
	//实例化对象
	public INTsecuritydomainPage pINT = new INTsecuritydomainPage();
	//实例化公共操作方法
	public CommonOperator opr = new CommonOperator();

	
	public void goSecurityDomain() throws Exception {
		try{
			// 进入组网管理页面
			Debug("网络管理 -> 网络对象 -> 安全域");
			opr.ClickToOpen(pINT.liNetManagement(), pINT.lnkNetManagement());
			sleep(1);
			opr.ClickToOpen(pINT.liNetObj(), pINT.NetObj());
			sleep(1);
			opr.Click(pINT.lnkSecurityDomain());
			sleep(1);
		}catch(Exception e){
			Error("进入安全域页面异常\n" + e);
			e.printStackTrace();
		}
	}	
	
   public boolean addSecurityDomain(String name, String intf) throws Exception {

	   try {
		   opr.SwitchToDefault();
		   goSecurityDomain();
		   opr.SwitchToFrame();
		   // 获取无所在trust那一行的哪一列
		   opr.Click(CommonTable.getCellObjByColString(pINT.tblSecurityDomain(), name, 1, 2));
		   sleep(1);
		   opr.Click(pINT.labIntf(intf));
		   
		   opr.clickOK();
		   opr.clickConfirm();
		   return true;   
	   }catch (Exception e) {
		   Error("");
		   e.printStackTrace();
		   return false;
	   }
  
	}
}


