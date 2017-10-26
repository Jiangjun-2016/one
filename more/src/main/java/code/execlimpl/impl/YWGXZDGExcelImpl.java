package code.execlimpl.impl;

import code.execlimpl.CreatAndReadExcel;

import java.io.IOException;
import java.util.List;

/**
 * @author fxf
 * @create 2017-10-26 14:20
 **/

public class YWGXZDGExcelImpl {

	private CreatAndReadExcel creatAndReadExcel = new CreatAndReadExcel();

	/**
	 * 主表(index = 0)
	 * fileNamePath:文件路劲
	 * index：文件第几个sheet
	 */
	public List<List<Object>> readExcelMaster(String fileNamePath, int index) {
		List<List<Object>> listExcel = null;
		try {
			listExcel = creatAndReadExcel.readExcel(fileNamePath, index);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listExcel;
	}

}