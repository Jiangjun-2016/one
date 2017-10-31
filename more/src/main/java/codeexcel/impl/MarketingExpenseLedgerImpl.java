package codeexcel.impl;

import codeexcel.util.CreatAndReadExcel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
 * 营销费用台账
 *
 * @author fxf
 * @create 2017-10-27 13:28
 **/

public class MarketingExpenseLedgerImpl {

	private Logger logger = LoggerFactory.getLogger(MarketingExpenseLedgerImpl.class);

	private CreatAndReadExcel creatAndReadExcel = new CreatAndReadExcel();

	/**
	 * 台账sheet
	 */
	public List<List<Object>> readExcelMaster(String fileNamePath, int rowNo, int cellNo) {
		List<List<Object>> listExcel = null;
		try {
			listExcel = creatAndReadExcel.readExcel(fileNamePath, 0, 2, 2);
		} catch (Exception e) {
			logger.error("error", e);
			e.printStackTrace();
		}
		return listExcel;
	}

	/**
	 * 透视sheet
	 */
	public List<List<Object>> readExcelTwo(String fileNamePath) {
		List<List<Object>> listExcel = null;
		try {
			listExcel = creatAndReadExcel.readExcel(fileNamePath, 1);
		} catch (IOException e) {
			logger.error("error", e);
			e.printStackTrace();
		}
		return listExcel;
	}


}