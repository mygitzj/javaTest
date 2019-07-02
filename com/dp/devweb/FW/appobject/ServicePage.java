package dp.devweb.FW.appobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dp.devweb.common.CommonObject;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonTable;

/**   
 * @Title: ServicePage.java 
 * @Description: 基本 → 系统管理 → 网络管理 → 网络对象 → 服务
 * @author w01866 
 * @date 2014年12月9日 下午4:19:32 
 * @version V4.4   
 */
public class ServicePage extends CommonObjectScript{
	
	// 公共对象类
	public CommonObject objCom = new CommonObject();
	
	/**
	 * 
	 * @return Top 预定义服务对象
	 */
	public WebElement tblPredefineService() {
		return objCom.getElementById("T_Network_Service_Pre_Obj");
	}
	
	/**
	 * 
	 * @return Top 自定义服务对象
	 */
	public WebElement tblUserdefineService() {
		return objCom.getElementById("T_Network_Service_Usr_Obj");
	}                                  
	
	/**
	 * 
	 * @return Top 服务组对象
	 */
	public WebElement toplServiceGrp() {
		return objCom.getElementById("T_Network_Service_Objgroup");
	}
	
	/**
	 * 
	 * @return 自定义服务对象表格
	 */
	public WebElement tblUserdefine() {
//		return objCom.getElementById("usr_obj_grid");
		return objCom.getElement(By.id("usr_obj_grid"));
	}
	
	/**
	 * 
	 * @return 增加一条自定义服务对象数据
	 */
	public WebElement spnAddUserdefine() {
		WebElement cell = CommonTable.getCellObject(tblUserdefine(), 0, 5);
		return objCom.getElementByXpath(cell, "//span[@class='gop GOP_COPY']");
	}
	
	/**
	 * 
	 * @return 自定义服务对象名称
	 */
	public WebElement txtUserdefineName() {
		return objCom.getElementById("service_name_input");
	}
	
	/**
	 * 
	 * @return 服务对象组表格
	 */
	public WebElement tblServiceGrp() {
		return objCom.getElementById("netservice_objgroup_grid");
	}
	
	/**
	 * 
	 * @return 增加一条服务对象组数据
	 */
	public WebElement spnAddServiceGrp() {
		WebElement cell = CommonTable.getCellObject(tblServiceGrp(), 0, 5);
		return objCom.getElementByXpath(cell, "//span[@class='gop GOP_COPY']");
	}
	
	/**
	 * 
	 * @return 服务对象组名称
	 */
	public WebElement txtServiceName() {
		return objCom.getElementById("group_name_input");
	}
	
	/**
	 * @return 服务对象组-成员列表-服务选择框
	 */
	public WebElement selService() throws Exception {
		return objCom.getElement(By.xpath(".//*[@id='group_items_div']/table[2]/tbody/tr/td[1]/select"));
	}
	
	/**
	 * @return 服务对象-成员列表-备选项
	 */
	public WebElement selAvailable() throws Exception {
		return objCom.getElement(By.xpath(".//*[@id='group_items_div']/table[3]/tbody/tr[2]/td[1]/select[1]"));
	}
	
	/**
	 * @return 服务对象-成员列表-已选项
	 */
	public WebElement selSelected() throws Exception {
		return objCom.getElement(By.xpath(".//*[@id='group_items_div']/table[3]/tbody/tr[2]/td[3]/select"));
	}
	
	/**
	 * @return 服务对象-成员列表-向右增加
	 */
	public WebElement addButton() throws Exception {
		return objCom.getElement(By.xpath(".//*[@id='group_items_div']/table[3]/tbody/tr[2]/td[2]/button[1]"));
	}
	
	/**
	 * @return 服务对象-成员列表-向左移除
	 */
	public WebElement delButton() throws Exception {
		return objCom.getElement(By.xpath(".//*[@id='group_items_div']/table[3]/tbody/tr[2]/td[2]/button[2]"));
	}
	
	/**
	 * @return 服务对象-成员列表-确定按钮
	 */
	public WebElement buttonOK() throws Exception {
		return objCom.getElement(By.xpath("html/body/div[5]/div[3]/div/button[1]"));
	}
        
	/**
	 * @return 服务对象-成员列表-确定按钮(多条配置时)
	 */
	
	public WebElement buttonOK1() throws Exception {
		return objCom.getElement(By.xpath("html/body/div[6]/div[3]/div/button[1]"));
	}
	
	/**
	 * 
	 * @return 协议类型
	 */
	public WebElement sltProtocol() {
		return objCom.getElementById("protocol_id");
	}
	
	/**
	 * 
	 * @return 源端口范围起始
	 */
	public WebElement txtSportStart() {
		return objCom.getElementById("sport_start_id");
	}
	
	/**
	 * 
	 * @return 源端口范围结束
	 */
	public WebElement txtSportEnd() {
		return objCom.getElementById("sport_end_id");
	}
	
	/**
	 * 
	 * @return 目的端口范围起始
	 */
	public WebElement txtDportStart() {
		return objCom.getElementById("dport_start_id");
	}
	
	/**
	 * 
	 * @return 目的端口范围结束
	 */
	public WebElement txtDportEnd() {
		return objCom.getElementById("dport_end_id");
	}
	
	/**
	 * 文件导入路径
	 */
	public WebElement selFilePath() throws Exception{
		return objCom.getElement(By.xpath(".//*[@id='ex-import']/input[2]"));
	}                                       
	                                     
	/**
	 * 文件导入按钮
	 */
	public WebElement buttonImport() throws Exception {
		return objCom.getElement(By.xpath(".//*[@id='ex-import']/input[3]"));
	}
	
	/**
	 * 文件导出按钮
	 */
	public WebElement buttonExport() throws Exception {
		return objCom.getElement(By.xpath(".//*[@id='ex-import']/input[4]"));
	}
}
