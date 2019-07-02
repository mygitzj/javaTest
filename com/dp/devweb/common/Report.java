package dp.devweb.common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Title: Report.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author w01866
 * @date 2014年12月11日 下午5:18:29
 * @version V4.4
 */
public class Report extends CommonObjectScript {

	public static String fileNameTime = null;

	// 测试报告
	public static void start() throws IOException {
		// 获取测试集开始时间，做文件名用
		startTime();

		File file = new File("./reports/" + "report " + fileNameTime + ".css");
		file.createNewFile();
		BufferedWriter output = new BufferedWriter(new FileWriter(file, true));
		output.newLine();
		output.write("测试用例" + "\t" + "耗时" + "\t" + "测试结果");
		output.close();
	}

	public static void report(String str) throws Exception {
		// 创建新的文件：
		String className = null;
		String time = null;
		String result = null;
		String export = null;

		// 分离字符串
		className = str.substring(0, str.indexOf("&"));
		time = str.substring(str.indexOf("&") + 1, str.lastIndexOf("&"));
		result = str.substring(str.lastIndexOf("&") + 1);

		export = className + "\t" + time + "\t" + result;

		// 建立报告文件
		File file = new File("./reports/" + "report " + fileNameTime + ".css");
		file.createNewFile();
		BufferedWriter output = new BufferedWriter(new FileWriter(file, true));

		output.newLine();
		output.write(export);
		output.close();

	}

	public static void startTime() {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HHmmss");
		String time = format.format(date);
		fileNameTime = time;
	}
}
