package dp.devweb.common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @Title: CommonTable.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author w01866
 * @date 2014年12月2日 下午2:45:29
 * @version V4.4
 */
public class CommonTable extends CommonObjectScript{	
	
	/**
	 * 根据行、列获取单元格对象
	 * @param table 表格对象
	 * @param row 行
	 * @param col 列
	 * @return 单元格对象
	 */
	public static WebElement getCellObject(WebElement table, int row, int col){
		// 得到table表中所有行对象，并得到所要查询的行对象
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		WebElement theRow = rows.get(row);
		System.out.println(theRow);
		
//		String test =theRow.getAttribute("id");
//		System.out.println("===================="+test);
		
		
		// 得到行中所有对象，并确定列对象，返回单元格
		List<WebElement> cols = theRow.findElements(By.tagName("td"));
		WebElement oCell = cols.get(col);
		return oCell;
	}
	
	
	/**
	 * 根据行、列获取单元格文本
	 * @param table 表格对象
	 * @param row 行
	 * @param col 列
	 * @return 单元格文本
	 */
	public static String getCellString(WebElement table, int row, int col) {		
		String str = getCellObject(table, row, col).getText();
		return str;
	}
	
	/**
	 * 根据指定列和列文本，确定行，获取该行目标列的单元格对象
	 * @param table 表格对象
	 * @param str 列文本
	 * @param oCol 文本所在列
	 * @param dCol 目标单元格所在列
	 * @return 单元格对象
	 * @throws Exception
	 */
	public static WebElement getCellObjByColString(WebElement table, String str, int oCol, int dCol) {
		int row = -1;
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for(int i = 0; i < rows.size(); i++){
			if(getCellString(table, i, oCol).equals(str)){
				row = i;
				break;
			}
		}
		WebElement oCell = getCellObject(table, row, dCol);
		return oCell;
	}
	
	/**
	 * 根据指定的列和列文本，确定行，根据行确定这一行的id值
	 * @param table 表格对象
	 * @param str   列文本
	 * @param oCol  文本所在列
	 * @param dCol  目标单元格所在的列
	 * @return      删除按钮
	 */
	public static int getId(WebElement table, String str, int oCol, int dCol) {
		int row = -1;
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for(int i = 0; i < rows.size(); i++){
			if(getCellString(table, i, oCol).equals(str)){
				row = i;
				break;
			}
		}
		WebElement rrrr = rows.get(row);
		
		String id =rrrr.getAttribute("id");
		
		return Integer.parseInt(id);	
	}
	
	
	/**
	 * 根据指定列和列文本，确定行，返回所在行
	 * @param table 表格对象
	 * @param str 列文本
	 * @param oCol 文本所在列
	 * @return 所在行
	 * @throws Exception
	 */
	public static int getRowByColString(WebElement table, String str, int oCol) {
		int row = -1;
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for(int i = 0; i < rows.size(); i++){
			if(getCellString(table, i, oCol).equals(str)){
				row = i;
				break;
			}
		}		
		return row;
	}
	
	/**
	 * 获取表格行数
	 * @param table 表格对象
	 * @return 表格行数
	 */
	public static int getRowCounts(WebElement table){
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int counts = rows.size();
		return counts;
	}
	
	/**
	 * 【精确查询】根据名称判断表格中是否存在数据
	 * @param table 表格对象
	 * @param str 要查找的字符串
	 * @param col 字符串所在列
	 * @return
	 */
	public static boolean isStringExsited(WebElement table, String str, int col) throws Exception{
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for (int i = 0; i < rows.size(); i++){
			String realStr = CommonTable.getCellString(table, i, col);
			if (realStr.equals(str)){
				Debug(str + " 已存在");
				return true;
			}				
		}
		Debug(str + " 不存在");
		return false;
	}
	
	/**
	 * 【模糊查询】根据名称判断表格中是否存在数据
	 * @param table 表格对象
	 * @param str 要查找的字符串
	 * @param col 字符串所在列
	 * @return
	 */
	public static boolean isStringExsitedFuzzy(WebElement table, String str, int col) throws Exception{
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for (int i = 0; i < rows.size(); i++){
			String realStr = CommonTable.getCellString(table, i, col);
			if (realStr.contains(str)){
				Debug("已存在 ---> 实际值： " + realStr + "\t预期值： " + str);
				return true;
			}				
		}
		Error(str + " 不存在");
		return false;
	}
	
	
}

