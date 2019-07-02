package dp.devweb.FW.tasks;

import dp.devweb.FW.appobject.Nat64Page;
import dp.devweb.FW.appobject.TreeMenuPage;
import dp.devweb.common.CommonObjectScript;
import dp.devweb.common.CommonOperator;
import dp.devweb.common.CommonTable;

/**
 * 
* @Title: Nat64.java 
* @Description: TODO(对NAT64页面进行操作) 
* @author z01674 
* @date 2015年6月3日 下午5:29:38 
* @version V4.4
 */
public class Nat64  extends CommonObjectScript {
	public CommonOperator opr = new CommonOperator();
	public TreeMenuPage pTree = new TreeMenuPage();
	public Nat64Page pNat64 = new Nat64Page();
	
	/**
	 * 进入配置界面
	 */
	public boolean goNat64Config() throws Exception {
		try {
			opr.SwitchToDefault();			
			//基本-防火墙
			Debug("进入NAT64配置界面");
			opr.ClickToOpen(pTree.liFireWall(), pTree.lnkFireWall());
			sleep(1);
			Debug("点击NAT64");
			opr.Click(pTree.lnkNAT64());
			return true;
		}catch (Exception e) {
		Error("进入NAT64页面异常");
		e.printStackTrace();
		return false;
		}
		
	}
	
	/**
	 * 增加NAT64 前缀配置
	 */
	public boolean addPrefix(String IPv6,String mask) throws Exception {
		try {
			opr.SwitchToDefault();
			goNat64Config();
			opr.SwitchToFrame();
			sleep(1);
			Debug("开启NAT64");
			opr.ClickToState(pNat64.checkNat64enable(), true);
			sleep(1);
			//判断是否存在前缀配置，如果存在则点击复制增加前缀配置，如果不存在直接配置
			String str =CommonTable.getCellString(pNat64.tablePrefixConf(), 0, 1);
			if (str.equals("请输入合法的IPV6地址前缀")) {
				opr.Click(CommonTable.getCellObject(pNat64.tablePrefixConf(), 0, 1));
				opr.SendKeys(pNat64.textIpv6Prefix(), IPv6);
				opr.Click(CommonTable.getCellObject(pNat64.tablePrefixConf(), 0, 2));
				opr.Select(pNat64.selectLenIp6Prefix(), mask);
				sleep(1);
				opr.Click(CommonTable.getCellObject(pNat64.tablePrefixConf(), 0, 1));
			}else {
				//点击第一行中的复制
				opr.Click(pNat64.butonCopyIp6Prefix());
				sleep(1);
				//确认复制的前缀配置所在行数
				int con = CommonTable.getRowByColString(pNat64.tablePrefixConf(), "请输入合法的IPV6地址前缀", 1);
				opr.Click(CommonTable.getCellObject(pNat64.tablePrefixConf(), con, 1));
				opr.SendKeys(pNat64.textIpv6Prefix(), IPv6);
				opr.Click(CommonTable.getCellObject(pNat64.tablePrefixConf(), con, 2));
				opr.Select(pNat64.selectLenIp6Prefix(), mask);	
				sleep(1);
				opr.Click(CommonTable.getCellObject(pNat64.tablePrefixConf(), con, 1));
			}
			//点击确认
			opr.Click(pTree.btnConfirm());						
			return true;
		}catch (Exception e) {
			Error("增加NAT64异常");
			e.printStackTrace();
			return false;		
		}
		 
	}

}
