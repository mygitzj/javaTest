package dp.devweb.FW.appobject;

import org.openqa.selenium.WebElement;

import dp.devweb.common.CommonObject;
import dp.devweb.common.CommonObjectScript;

/**   
 * @Title: PimPage.java 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author w01866 
 * @date 2014年12月4日 上午9:31:07 
 * @version V4.4   
 */
public class PimPage extends CommonObjectScript{
	
	// 公共对象类
	public CommonObject objCom = new CommonObject();
	
	/**
	 * 
	 * @return top PIM
	 * @throws Exception
	 */
	public WebElement tblTopPim() throws Exception {
		return objCom.getElementById("T_Manage_MV4Route_PIM");
	}
	
	/**
	 * 
	 * @return top BSR状态
	 * @throws Exception
	 */
	public WebElement tblTopBsrState() throws Exception {
		return objCom.getElementById("T_Manage_MV4Route_PIM_BSR_SHOW");
	}
	
	/**
	 * 
	 * @return top RP状态
	 * @throws Exception
	 */
	public WebElement tblTopRpInfo() throws Exception {
		return objCom.getElementById("T_Manage_MV4Route_PIM_RP_SHOW");
	}
	
	/**
	 * 
	 * @return 候选BSR状态
	 * @throws Exception
	 */
	public WebElement tblCandidacyBsrConf() throws Exception {
		return objCom.getElementById("Cbsr_Config");
	}
	
	/**
	 * 
	 * @return 静态RP配置
	 * @throws Exception
	 */
	public WebElement tblStaticRpConf() throws Exception {
		return objCom.getElementById("Strp_Config");
	}
	
	/**
	 * 
	 * @return 候选RP配置
	 * @throws Exception
	 */
	public WebElement tblCandidacyRpConf() throws Exception {
		return objCom.getElementById("Crp_Config");
	}
	
	/**
	 * 
	 * @return PIM接口配置
	 * @throws Exception
	 */
	public WebElement tblPimIntfConf() throws Exception {
		return objCom.getElementById("Interface_Config");
	}
	
	/**
	 * 
	 * @return BSR状态
	 * @throws Exception
	 */
	public WebElement tblBsrState() throws Exception {
		return objCom.getElementById("bsr_show");
	}
	
	/**
	 * 
	 * @return 查询组地址
	 * @throws Exception
	 */
	public WebElement txtGrpAddr() throws Exception {
		return objCom.getElementById("sub_text");
	}
	
	/**
	 * 
	 * @return RP信息
	 * @throws Exception
	 */
	public WebElement tblRpInfo() throws Exception {
		return objCom.getElementById("rp_show");
	}
	
	/**
	 * 
	 * @return 候选BSR接口，选择框
	 * @throws Exception
	 */
	public WebElement sltBsrIntf() throws Exception {
		return objCom.getElementById("cbsr_ifm_select");
	}
	
	
	/**
	 * 
	 * @return 静态RP地址，文本框
	 * @throws Exception
	 */
	public WebElement txtStaticRp() throws Exception {
		return objCom.getElementByXpath("(//input[@id='strp_addr_input'])[2]");
	}
	
	/**
	 * 选择状态：启用、禁用
	 * @return 状态选择框
	 * @throws Exception
	 */
	public WebElement sltState() throws Exception {
		return objCom.getElementByXpath("(//select[@id='state_select'])[2]");
	}
	
		/**
	 * 选择状态：启用、禁用
	 * @return 状态选择框
	 * @throws Exception
	 */
	public WebElement sltMode() throws Exception {
		return objCom.getElementByXpath("(//select[@id='int_state_select'])[2]");
	}
}
