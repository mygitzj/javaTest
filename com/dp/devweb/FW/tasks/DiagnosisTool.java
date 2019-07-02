package dp.devweb.FW.tasks;

import org.testng.Assert;

import dp.devweb.FW.appobject.DiagnosisToolPage;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;
import dp.devweb.common.CommonTable;

/**
 * 
* @Title: DiagnosisTool.java 
* @Description: TODO(用一句话描述该文件做什么) 
* @author z01674 
* @date 2015年4月8日 下午6:52:26 
* @version V4.4
 */

public class DiagnosisTool extends CommonObjectScript {
	
	//实例化对象
	public DiagnosisToolPage pDiag = new DiagnosisToolPage();
	
	//实例化公共对象
	public CommonOperator opr = new CommonOperator();
	

	
	
	
	
	public void goDiagnosisTool() throws Exception {
		try{
			
//			// 让浏览器访问 web
//			Debug("URL： " + webUrl);
//			driver.get(webUrl);
//			Thread.sleep(3000);
//			// 获取 网页的 title
//			log("打开页面:  " + driver.getTitle());
			//进入到默认配置界面
			opr.SwitchToDefault();
			Debug("基本——网络管理——诊断工具");
			opr.ClickToOpen(pDiag.liNetManagement(), pDiag.lnkNetManagement());
			sleep (1);
			pDiag.lnkDiagnoseTool().click();
			sleep (1);	
				}catch(Exception e){
			Error("进入安全域页面异常\n" + e);
			e.printStackTrace();	
			}
	}
	
	public void Diagnosis(String number,String ip) throws Exception {
		try{
			//进入到默认配置界面
			opr.SwitchToDefault();
			goDiagnosisTool();
			Debug("切换表格");
			opr.SwitchToFrame();
			sleep(1);
		
			Debug("输入参数");
			if (number != null) {
				pDiag.parameterText().sendKeys( number);
				sleep(1);}
		
			Debug("输入要ping的IP地址");
			pDiag.ipAddressText().sendKeys( ip);
			sleep(1);
		
			Debug("点击测试");
			pDiag.btnTest().click();
			sleep(5);
	
			}catch(Exception e){
				Error("诊断操作异常" + e);
				e.printStackTrace();	
				}	
	
	}
	
	//判断诊断结果是否正确
	public boolean resultDianosis(String keywords) throws Exception {
		
		try{
		Debug("获取结果文本框中的字符串");
		String str = CommonTable.getCellObject(pDiag.tabDiagnose(), 3, 1).getText();

		//如果包含给定的字符串，则测试结果正确，否则就测试不通过
		if(str.contains(keywords)) {	
			Debug("测试结果正确");
		  } else {
			  Assert.fail("ping结果错误");
		  }
		return true;
		} catch (Exception e) {
//		e.printStackTrace("诊断错误);
		return false;	
		}
	
	}

}








