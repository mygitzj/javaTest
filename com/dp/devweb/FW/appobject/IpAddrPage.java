package dp.devweb.FW.appobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dp.devweb.common.CommonObject;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonTable;

/**
 * @Title: IpAddrPage.java
 * @Description: 基本 → 网络管理 → 网络对象 → IP地址
 * @author w01866
 * @date 2014年12月8日 上午10:59:00
 * @version V4.4
 */

/**
 * 
* @Title: IpAddrPage.java 
* @Description: TODO(在此基础上做更改，增加配置地址对象) 
* @author z01674 
* @date 2015年3月24日 下午3:14:02 
* @version V4.4
 */
public class IpAddrPage extends CommonObjectScript {

	// 公共对象类
	public CommonObject objCom = new CommonObject();

	/**
	 * 
	 * @return top 地址对象
	 * @throws Exception
	 */
	public WebElement tblTopAddrObject() throws Exception {
		return objCom.getElementById("T_Network_Address_obj");
	}

	/**
	 * 
	 * @return top 地址对象组
	 * @throws Exception
	 */
	public WebElement tblTopAddrObjectGrp() throws Exception {
		return objCom.getElementById("T_Network_Address_objgroup2");
	}                              

	/**
	 * 
	 * @return 地址对象表格
	 * @throws Exception
	 */
	public WebElement tblAddrObject() throws Exception {
		return objCom.getElementById("netaddr_obj");
	}

	/**
	 * 
	 * @return 地址对象组表格
	 * @throws Exception
	 */
//	public WebElement tblAddrObjectGrp() throws Exception {
//		return objCom.getElementById("netadddr_group_grid");
//	}
	
	public WebElement tblAddrObjectGrp() throws Exception {
		return objCom.getElement(By.id("netadddr_group_grid"));
	}                                 
//	                              
	/**
	 * 
	 * @return 地址对象名称文本框
	 * @throws Exception
	 */
	public WebElement txtAddrObjectName() throws Exception {
		return objCom.getElementById("input_name");
	}

	/**
	 * IP范围
	 * 
	 * @return 地址对象起始IP文本框
	 * @throws Exception
	 */
	public WebElement txtRangeStartIp() throws Exception {
		return objCom.getElementById("ip_area_start_id");
	}

	/**
	 * IP范围
	 * 
	 * @return 地址对象结束IP文本框
	 * @throws Exception
	 */
	public WebElement txtRangeEndIp() throws Exception {
		return objCom.getElementById("ip_area_end_id");
	}
	
	/**
	 * 例外IP范围
	 * 
	 * @return 地址对象起始例外IP文本框
	 * @throws Exception
	 */
	public WebElement txtExpRangeStartIp() throws Exception {
		return objCom.getElementById("exp_ip_area_start_id");
	}

	/**
	 * 例外IP范围
	 * 
	 * @return 地址对象结束例外IP文本框
	 * @throws Exception
	 */
	public WebElement txtExpRangeEndIp() throws Exception {
		return objCom.getElementById("exp_ip_area_end_id");
	}
	
	/**
	 * IP地址范围 
	 * @return 单选按键
	 * @throws Exception
	 */
	public WebElement rdoIpArea() throws Exception {
		return objCom.getElementById("ip_area_id");
	}

	/**
	 * IP地址/掩码
	 * @return 单选按键
	 * @throws Exception
	 */
	public WebElement rdoIpAndMask() throws Exception {
		return objCom.getElementById("ip_mask_id");
	}

	/**
	 * 
	 * @return IP地址文本框
	 * @throws Exception
	 */
	public WebElement txtIp() throws Exception {
		return objCom.getElementById("ip_id");
	}

	/**
	 * 
	 * @return 子网掩码文本框
	 * @throws Exception
	 */
	public WebElement sltMask() throws Exception {
		return objCom.getElementById("mask_id");
	}

	/**
	 * 
	 * @return 全部删除按钮
	 * @throws Exception
	 */
	public WebElement btnDelAll() throws Exception {
		return objCom.getElementById("delall");
	}

	/**
	 * 
	 * @return 地址对象组名称文本框
	 * @throws Exception
//	 */
	public WebElement txtAddrObjectGrpName() throws Exception {
		return objCom.getElementById("group_name_input");
	}
	

	
	/**
	 * 
	 * @return 地址对象组 → 地址对象
	 * @throws Exception
	 */
	public WebElement sltAddrObject() throws Exception {
		return objCom
				.getElementByXpath(".//*[@id='group_items_div']/table[3]/tbody/tr[2]/td[1]/select");
	}
	
		/**
	 * 
	 * @return 地址对象组 → 地址对象
	 * @throws Exception
	 */
	public WebElement sltAddrObjectSelected() throws Exception {
		return objCom
				.getElementByXpath(".//*[@id='group_items_div']/table[3]/tbody/tr[2]/td[3]/select");
	}

	/**
	 * 
	 * @return 向右增加按钮
	 * @throws Exception
	 */
	public WebElement btnAdd() throws Exception {
		return objCom
				.getElementByXpath(".//*[@id='group_items_div']/table[3]/tbody/tr[2]/td[2]/button[1]");
	}

	/**
	 * 
	 * @return 向左移除按钮
	 * @throws Exception
	 */
	public WebElement btnDel() throws Exception {
		return objCom.getElementByXpath(".//*[@id='group_items_div']/table[3]/tbody/tr[2]/td[2]/button[2]");
	}

	/**
	 * 
	 * @return 增加一条地址对象数据
	 * @throws Exception
	 */
	public WebElement spnAddIpAddr() throws Exception {
		WebElement cell = CommonTable.getCellObject(tblAddrObject(), 0, 5);
		return objCom.getElementByXpath(cell, "//span[@class='gop GOP_COPY']");
	}
	
		/**
	 * 
	 * @return 增加一条地址对象组数据
	 * @throws Exception
	 */
	public WebElement spnAddIpAddrGrp() throws Exception {
		WebElement cell = CommonTable.getCellObject(tblAddrObjectGrp(), 0, 5);
		return objCom.getElementByXpath(cell, "//span[@class='gop GOP_COPY']");
	}	
	
	/**
	 * 删除IP地址数据
	 * @return 按键对象
	 * @throws Exception
	 */
	public WebElement spnDel(String str) throws Exception{
		return objCom.getElementByXpath(".//*[@value='"+ str +"']/td[6]/span[2]");
	}
	
	
	
	/**
	 * 例外IP地址
	 * @return 文本对象
	 * @throws Exception
	 */
	public WebElement txtExpIp() throws Exception{
		return objCom.getElementById("exp_ip_id");
	}
	
	/**
	 * IP地址/掩码 → “添加”按键
	 * @return 按键对象
	 * @throws Exception
	 */
	public WebElement btnAppend2() throws Exception{
		return objCom.getElementByXpath("(//input[@value='添加'])[2]");
	}	
	
	/**
	 * IP地址范围 → “添加”按键
	 * @return 按键对象
	 * @throws Exception
	 */
	public WebElement btnAppend1() throws Exception{
		return objCom.getElementByXpath("(//input[@value='添加'])[1]");
	}
	
	/**
	 * “浏览”按键
	 * @return input对象
	 * @throws Exception
	 */
	public WebElement btnSelectFile() throws Exception{
		return objCom.getElementById("select_file");
	}
	
	/**
	 * “导入”按键
	 * @return input对象
	 * @throws Exception
	 */
	public WebElement btnImport() throws Exception{
		return objCom.getElementById("import");
	}
	
	/**
	 * 导出
	 */
	public WebElement btnExport() throws Exception {
		return objCom.getElement(By.id("export"));
	}
	
	/**
	 * 全部删除
	 */
	public WebElement deleAll() throws Exception {
		return objCom.getElement(By.id("delall"));
	}
	
//	/**
//	 * 地址对象组导入文件输入路径
//	 */
	public WebElement filePathAddrGrp() throws Exception {
		return objCom.getElement(By.xpath(".//*[@id='select_file']"));
	}
}
