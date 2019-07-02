package dp.devweb.FW.tasks;

import dp.devweb.FW.appobject.DomainNamePage;
import dp.devweb.FW.appobject.TreeMenuPage;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;
import dp.devweb.common.CommonTable;

/**
 * 
* @Title: DomainName.java 
* @Description: TODO(域名页面操作) 
* @author z01674 
* @date 2015年6月17日 下午7:45:47 
* @version V4.4
 */
public class DomainName extends CommonObjectScript{
	public CommonOperator opr = new CommonOperator();
	public DomainNamePage pDomainName = new DomainNamePage();
	public TreeMenuPage pTree = new TreeMenuPage();
	
	//进入域名配置界面
	public boolean goDomainName() throws Exception {
		try {
			opr.SwitchToDefault();
			//网络管理-网络对象-域名
			opr.ClickToOpen(pTree.liNetManagement(), pTree.lnkNetManagement());
			sleep(1);
			opr.ClickToOpen(pTree.liNetObject(), pTree.lnkNetObject());
			sleep(1);
			opr.Click(pTree.lnkDomainName());
			return true;
		}catch (Exception e) {
			Error("进入域名配置界面错误");
			return false;
		}
	}
	
	//增加域名
	public boolean addDomainName(String name) throws Exception {
		try{
			goDomainName();
			sleep(1);
			opr.SwitchToFrame();
			//判断是否已经存在域名
//			String str = CommonTable.getCellString(pDomainName.tablDomainName(), 0, 1);
//			if(str.equals("请输入域名")) {
//				Debug("在第一行中输入域名");
//				opr.JsClick(CommonTable.getCellObject(pDomainName.tablDomainName(), 0, 1));
////				CommonTable.getCellObject(pDomainName.tablDomainName(), 0, 1).click();
//				pDomainName.textName().sendKeys(name);
//				sleep(1);
//				CommonTable.getCellObject(pDomainName.tablDomainName(), 0, 2).click();
//				//点击确认
//				Debug("点击确认");
//				pTree.btnConfirm().click();
////				opr.JsClick(pTree.btnConfirm());
////				opr.Click(pTree.btnConfirm());
//			}else {
				Debug("点击复制");
				opr.JsClick(pDomainName.buttonCopy());
				//确定复制的在哪一行
				int count = CommonTable.getRowByColString(pDomainName.tablDomainName(), "请输入域名", 1);
				Debug("输入域名");
				opr.JsClick(CommonTable.getCellObject(pDomainName.tablDomainName(), count, 1));
				pDomainName.textName().sendKeys(name);
				sleep(1);
//				CommonTable.getCellObject(pDomainName.tablDomainName(), 1, 2).click();
//				opr.JsClick(CommonTable.getCellObject(pDomainName.tablDomainName(), 1, 2));	
//				opr.JsClick(CommonTable.getCellObject(pDomainName.tablDomainName(), count, 2));	
				sleep(2);
				//点击确认
				Debug("点击确认");
//				pTree.btnConfirm().click();
				opr.JsClick(pTree.btnConfirm());
//				opr.Click(pTree.btnConfirm());
				sleep(1);
//			}
			
			return true;
		}catch (Exception e) {
			Error("增加域名异常");
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 文件导出
	 */
	public boolean fileExport() throws Exception {
		try {
			goDomainName();
			opr.SwitchToFrame();
			Debug("导出文件");
			opr.JsClick(pDomainName.buttonExport());		
			return true;
		}catch (Exception e) {
			Error("文件导出错误");
			return false;
		}
	}
	
	/**
	 * 文件导入
	 */
	public boolean fileImport(String path) throws Exception {
		try{
			goDomainName();
			opr.SwitchToFrame();
			Debug("输入导入文件路径");
			pDomainName.filePath().sendKeys(path);
			sleep(1);
			Debug("点击导入");
			pDomainName.buttonImport().click();	
			return true;
		}catch(Exception e) {
			Error("导入文件错误");
			return false;
		}
	}
	
}
