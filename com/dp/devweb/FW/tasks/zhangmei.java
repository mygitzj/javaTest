package dp.devweb.FW.tasks;

import dp.devweb.FW.appobject.zhangmeiPage;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;
import dp.devweb.common.CommonTable;

/**   
 * @Title: zhangmei.java 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Administrator 
 * @date 2015年2月11日 上午9:48:43 
 * @version V4.4   
 */
public class zhangmei extends CommonObjectScript{
	// 实例化对象
	public zhangmeiPage pZhang = new zhangmeiPage();
	
	// 实例化公共操作方法
	public CommonOperator opr = new CommonOperator();
	
	public boolean goNetConfigPage() throws Exception {
		try{
			// 进入组网管理页面
			Debug("网络管理 -> 接口管理 -> 组网配置");
			opr.ClickToOpen(pZhang.liNetManagement(), pZhang.lnkNetManagement());
			sleep(1);
			opr.ClickToOpen(pZhang.liIntfManagement(), pZhang.lnkIntfManagement());
			sleep(1);
			opr.Click(pZhang.lnkNetConfig());
			sleep(1);	
			
			return true;
		}catch(Exception e){
			Error("进入组网配置页面异常\n" + e);
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean configNet(String name, String type, String ip, int mask) throws Exception {
		try{
			// 进入组网配置页面
			goNetConfigPage();
			opr.SwitchToFrame();
			
			// 配置组网
			opr.Click(CommonTable.getCellObjByColString(pZhang.tblNetConfig(), name, 0, 4));
			sleep(1);
			opr.Select(pZhang.sltIPAddr(), type);
			opr.SendKeys(pZhang.txtIP(), ip);
			opr.Select(pZhang.sltMask(), mask + "");
			
			// 点击确定
			opr.Click(pZhang.spnOK());
			
			//点击确认
			opr.Click(pZhang.btnConfirm());
			
			return true;
		}catch(Exception e){
			Error("配置组网异常\n" + e);
			e.printStackTrace();
			return false;
		}
	}
}
