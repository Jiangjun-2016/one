package testcode;

import code.execlimpl.CreatAndReadExcel;

import java.util.List;

/**
 * @author fxf
 * @create 2017-10-24 16:22
 **/

public class TestExcel {

	public static void main(String[] args) throws Exception {

		String excel2007Path = "D:\\temp\\style_2007.xlsx";
		String excel2003Path = "D:\\temp\\style_2003.xls";
		
		CreatAndReadExcel creatAndReadExcel = new CreatAndReadExcel();
		creatAndReadExcel.creatExcel(excel2007Path, "2007");// 创建2007版Excel文件
		creatAndReadExcel.creatExcel(excel2003Path, "2003");// 创建2003版Excel文件

//        List<List<Object>> excel2007List = creatAndReadExcel.readExcel(excel2007Path);// 读取2007版Excel文件
		List<List<Object>> excel2003List = creatAndReadExcel.readExcel(excel2003Path);// 读取2003版Excel文件
		System.out.println(excel2003List.toString());
	}
}