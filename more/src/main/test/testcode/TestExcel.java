package testcode;

import java.util.List;

/**
 * @author fxf
 * @create 2017-10-24 16:22
 **/

public class TestExcel {

	public static void main(String[] args) throws Exception {

		CreatAndReadExcel creatAndReadExcel = new CreatAndReadExcel();
//		String excel2007Path = "D:\\temp\\style_2007.xlsx";
//		String excel2003Path = "D:\\temp\\style_2003.xls";
		String demo1 = "D:\\lhx\\demo1.xlsx";
//		String demo2 = "D:\\lhx\\demo2.xlsx";

//		creatAndReadExcel.creatExcel(excel2007Path, "2007");// 创建2007版Excel文件
//		creatAndReadExcel.creatExcel(excel2003Path, "2003");// 创建2003版Excel文件

//      List<List<Object>> excel2007List = creatAndReadExcel.readExcel(excel2007Path);// 读取2007版Excel文件
//		List<List<Object>> excel2003List = creatAndReadExcel.readExcel(excel2003Path);// 读取2003版Excel文件
//		List<List<Object>> demo1List = creatAndReadExcel.readExcel(demo1,0);
//		List<List<Object>> demo2List = creatAndReadExcel.readExcel(demo2,0);

		String filePath = "D:\\lhx\\2017年08月业务贡献值表\\业务贡献值底稿.xlsx";
		int index = 0;//主表
		YWGXZDGExcelImpl ywgxzdgExcel = new YWGXZDGExcelImpl();
		YXFYTZExcelImpl yxfytzExcel = new YXFYTZExcelImpl();
		List<List<Object>> ywgxzdgListMaster = yxfytzExcel.readExcelMaster(demo1,10,10);
		for(List<Object> list:ywgxzdgListMaster){
			for (Object o:list){
				System.out.printf(o.toString());
			}
			System.out.println("");
		}
//		System.out.println(ywgxzdgListMaster.toString());
	}
}