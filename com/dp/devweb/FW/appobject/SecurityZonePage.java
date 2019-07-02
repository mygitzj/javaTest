package dp.devweb.FW.appobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dp.devweb.common.CommonObject;
import dp.devweb.common.CommonTable;

/**
 * @Title: SecurityZonePage.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author w01866
 * @date 2014年12月12日 下午4:26:36
 * @version V4.4
 */
public class SecurityZonePage {

	// 公共对象类
	public CommonObject obj = new CommonObject();

	/**
	 * 基本 → 网络管理 → 网络对象 → 安全域 → table
	 * 
	 * @return
	 * @throws Exception
	 */
	public WebElement tblSecurityZone() throws Exception {
		return obj.getElement(By.id("securityzone"));
	}

	/**
	 * 增加一条安全域数据
	 * 
	 * @return 按键对象
	 * @throws Exception
	 */
	public WebElement spnAdd() throws Exception {
		WebElement ele = CommonTable.getCellObject(tblSecurityZone(), 0, 6);
		return obj.getElement(ele, By.xpath("//span[@class='gop GOP_COPY']"));
	}

	/**
	 * 删除一条安全域数据
	 * 
	 * @return 按键对象
	 * @throws Exception
	 */
	public WebElement spnDel(int row) throws Exception {
		return obj.getElement(By.xpath(".//*[@id='securityzone']/tbody/tr["
				+ row + "]/td[7]/span[2]"));
	}

	/**
	 * 安全域名称
	 * 
	 * @return 文本对象
	 * @throws Exception
	 */
	public WebElement txtSecurityZone() throws Exception {
		return obj.getElement(By.id("input_name"));
	}

	/**
	 * 优先级
	 * 
	 * @return 文本对象
	 * @throws Exception
	 */
	public WebElement txtPriority() throws Exception {
		return obj.getElement(By.id("input_priority"));
	}

	/**
	 * 描述
	 * 
	 * @return 文本对象
	 * @throws Exception
	 */
	public WebElement txtDescribe() throws Exception {
		return obj.getElement(By.id("input_desc"));
	}

	/**
	 * 接口
	 * 
	 * @return div对象
	 * @throws Exception
	 */
	public WebElement divInterface() throws Exception {
		return obj.getElement(By.id("popup_win_security_face"));
	}

	/**
	 * 得到所有接口列表，用getText可匹配并操作
	 * 
	 * @return label对象列表
	 * @throws Exception
	 */
	public WebElement chkInterface(String str) throws Exception {
		return obj.getElement(By
				.xpath("//*[@id='popup_win_checkbox']/label[text()='" + str	+ "']/input"));
	}

	/**
	 * “浏览”按键
	 * 
	 * @return input对象
	 * @throws Exception
	 */
	public WebElement btnSelectFile() throws Exception {
		return obj.getElement(By.id("select_file"));
	}

	/**
	 * “导入”按键
	 * 
	 * @return input对象
	 * @throws Exception
	 */
	public WebElement btnImport() throws Exception {
		return obj.getElement(By.id("import"));
	}
	
	/**
	 * 
	 * @return 导出
	 * @throws Exception
	 */
	public WebElement butExport() throws Exception {
		return obj.getElement(By.id("export"));
	}

	/**
	 * “全选”复选框
	 * 
	 * @return checkbox对象
	 * @throws Exception
	 */
	public WebElement chkSelectAll() throws Exception {
		return obj.getElement(By.id("if_select_all"));
	}
	
	/**
	 * top“安全域”
	 * @return
	 */
	public WebElement topSecurityZone() {
		return obj.getElement(By.id("T_Network_Security_Zone2"));
	}
}