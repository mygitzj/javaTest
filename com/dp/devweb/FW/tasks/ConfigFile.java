package dp.devweb.FW.tasks;

import dp.devweb.FW.appobject.ConfigFilePage;
import dp.devweb.FW.appobject.TreeMenuPage;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;

public class ConfigFile extends CommonObjectScript{
	public CommonOperator opr = new CommonOperator();
	public TreeMenuPage pTree = new TreeMenuPage();
	public ConfigFilePage pConFil = new ConfigFilePage();
	
	
	/**
	 * 进入配置文件界面
	 */
	public boolean goCongifFilePage() throws Exception {
		try {
			opr.SwitchToDefault();
			opr.Click(pTree.linConfigFile());
			return true;
		}catch (Exception e) {
			Error("设备进入配置文件页面异常");
			return false;
		}
	}
	
     public boolean openWinExe() throws Exception{
    	 Runtime rn =  Runtime.getRuntime();
    	 Process p = null;
    	 try {
    		 p = rn.exec("\"D:/安装软件/upfile.exe\"");
    		 return true;
    	 }catch (Exception e) {
    		 Error("调用上传文件程序异常");
    		 return false;
    	 }
     }
	
	
	
	public boolean importFile(String path) throws Exception {
		try {
			opr.SwitchToDefault();
			goCongifFilePage();
			opr.SwitchToFrame();
//			//点击打开文件上传
//			Debug("点击文件上传");
//			opr.JsClick(pConFil.textFilePath());
//			sleep(1);
			//调用upfile.exe上传程序
//            openWinExe();
			
			Debug("导入文件");
			pConFil.textFilePath().sendKeys(path);
			sleep(1);
			Debug("点击下载配置文件");
			opr.Click(pConFil.buttDownload());
			
			
			return true;
		}catch (Exception e) {
			Error("导入文件异常");
			return false;
		}
		
//		public boolean export
	}
	
	
	
	
	
}
