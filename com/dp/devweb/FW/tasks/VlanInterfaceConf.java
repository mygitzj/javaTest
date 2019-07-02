package dp.devweb.FW.tasks;

import org.openqa.selenium.WebElement;

import dp.devweb.FW.appobject.TreeMenuPage;
import dp.devweb.FW.appobject.VlanInterfaceConfPage;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;
import dp.devweb.common.CommonTable;
/**
 *
* @Title: VlanInterfaceConf.java 
* @Description: TODO(用一句话描述该文件做什么) 
* @author z01674 
* @date 2015年3月18日 下午2:44:41 
* @version V4.4
 */

public class VlanInterfaceConf extends CommonObjectScript {
	public TreeMenuPage pTree = new TreeMenuPage();
	public VlanInterfaceConfPage pVlanInt  =  new  VlanInterfaceConfPage();
	public CommonOperator opr = new CommonOperator();
	
	public boolean goVlanInterfaceIP() throws Exception {
		try{
			opr.SwitchToDefault();
			//网络管理——接口管理——Vlan接口配置
			opr.ClickToOpen(pTree.liNetManagement(), pTree.lnkNetManagement());
			sleep(1);
			opr.ClickToOpen(pTree.liIntfManagement(), pTree.lnkIntfManagement());
			sleep(1);
			opr.Click(pVlanInt.vlanConfig());
			return true;
		}catch (Exception e){
			Error("进入VLAN接口配置页面错误");
			e.printStackTrace();
			return false;
		}
	}

/**
 * 进入VLAN接口配置界面配置ip地址
 * id vlan接口的编号
 * ip vlan接口的IP地址
 * mask vlan接口IP地址的子网掩码
 */

public boolean addVlanInterfaceIP(String id, String ip, String mask) throws Exception{
	try{
		opr.SwitchToDefault();
		//进入VLAN接口配置界面 
		goVlanInterfaceIP();
		
		//切换到右侧frame
		opr.SwitchToFrame();
		
		Debug("复制");
		opr.Click(pVlanInt.copy());
		
		Debug("vlan id 配置" + id);
       WebElement obj = CommonTable.getCellObjByColString(pVlanInt.tablVlanInt(), "请配置", 0, 0);
    //	pVlanInt.idConf().click();
        opr.Click(obj);
		pVlanInt.textId().sendKeys(id);
		sleep(1);
		
		Debug ("点击空白出，使配置下发");
		pVlanInt.blank().click();
		
		Debug("点击要输入ip地址的表格");
		 WebElement obj1 = CommonTable.getCellObjByColString(pVlanInt.tablVlanInt(), id, 0, 4);
		opr.Click(obj1);
		sleep(1);
		
		
		Debug("配置接口ip/掩码 文本框" + ip);
		pVlanInt.textIP().sendKeys(ip);
		sleep(1);
		
		Debug("配置的ip地址的mask" + mask);
		opr.Select(pVlanInt.sltmask(), mask);
		sleep(1);
		
		Debug("点击确定");
		pTree.btnOK().click();
		sleep(1);
		
		Debug("点击确认");
		pTree.btnConfirm().click();
		sleep(1);
		
		return true;
	}catch (Exception e) {
		e.printStackTrace();
		Error("配置vlan接口ip地址异常");
		return false;
	}
}



//验证vlan接口 ip是否配置成功
public boolean verifyVlanIntIp (String id, String expectedIP) throws Exception {
	try{
		opr.SwitchToDefault();
	
		//进入VLAN接口配置界面 
		goVlanInterfaceIP();
	
		//切换到右侧frame
		opr.SwitchToFrame();
		
		//判断对应表格的字符串是否存在
		String actualText = CommonTable.getCellObjByColString(pVlanInt.tablVlanInt(), id, 0, 4).getText();
		if (actualText.equals("无")) {
		return true;
		}else {
	    	String actualIP = actualText.substring(0, 8);
	    	if (actualIP.contains(expectedIP)) {
	    		Debug("期望值：" + expectedIP + "\t"+ "实际值:" + actualIP  +"\t"+ "相等，配置下发正确");
	    		return true;
	    	} else {
	    		Debug("期望值：" +expectedIP + "\t" +"实际值：" + actualIP + "\t" + "不相等，配置下发错误");
	    		return false;
	    	}	
		}			
	}catch (Exception e) {
		e.printStackTrace();
		Error("配置vlan接口ip地址异常");
		return false;
	}
}


//删除已经配置的vlan接口
public boolean deleateVlanIntIp() throws Exception {
	try{
		opr.SwitchToDefault();
		//进入VLAN接口配置界面 
		goVlanInterfaceIP();
				
		//切换到右侧frame
		opr.SwitchToFrame();
		
		//根据给出的vlan id删除相应的vlan接口
		Debug("点击删除按钮");
		pVlanInt.deletButton().click();
		
		Debug("点击确认按钮");
		pTree.btnConfirm().click();	
		return true;
	}catch (Exception  e) {
		e.printStackTrace();
		Error("删除vlan接口错误");
		return false;
	}
		
	}
	
}

		

	
	
	




