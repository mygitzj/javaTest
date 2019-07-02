package dp.devweb.FW.appobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dp.devweb.common.CommonObject;
import dp.devweb.common.CommonTable;

/**
 * @Title: StaticRoutePage.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author w01866
 * @date 2015年1月16日 下午2:35:01
 * @version V4.4
 */
public class StaticRoutePage {

	public CommonObject obj = new CommonObject();

	/**
	 * 基本 → 网络管理 → 单播IPv4路由 → 静态路由 → 静态路由table
	 * 
	 * @return table对象
	 */
	public WebElement tblStaticRoute() {
		return obj.getElement(By.id("Route_List"));
	}

	public WebElement txtIpSegment() {
		return obj.getElement(By.id("ip_input"));
	}

	public WebElement sltMask() {
		return obj.getElement(By.id("netmask_select"));
	}

	public WebElement sltGateway() {
		return obj.getElement(By.id("interface_select"));
	}

	public WebElement txtNexthop() {
		return obj.getElement(By.id("nexthop_input"));
	}

	public WebElement spnCopy() {
		WebElement cell = CommonTable.getCellObject(tblStaticRoute(), 0, 5);
		return obj.getElement(cell,
				By.xpath("//span[contains(@class,'gop GOP_COPY')]"));
	}

	public WebElement spnDelete(int row) {
		return obj.getElement(By
				.xpath("//*[@id='Route_List']/tbody/tr[" + (row + 1)
						+ "]/td[6]/span[2]"));
	}

}
