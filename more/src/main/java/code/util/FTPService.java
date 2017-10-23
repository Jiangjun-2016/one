package code.util;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Service
public class FTPService {

	private Logger logger = LoggerFactory.getLogger(FTPService.class);

	/**
	 * @Description: 上传文件, 可以指定文件名和子文件夹
	 * @return String 返回文件在ftp服务器上的URL地址
	 */
	public String ftpUpLoad(String subfolder, String fileName, byte[] data) {
		try {
			// 本地字符编码
			String LOCAL_CHARSET = "GBK";
			// FTP协议里面，规定文件名编码为iso-8859-1
			String SERVER_CHARSET = "ISO-8859-1";
			String ip = PropertiesUtil.getFTPProperty("ip");
			String userName = PropertiesUtil.getFTPProperty("username");
			String passWord = PropertiesUtil.getFTPProperty("password");
			String path = PropertiesUtil.getFTPProperty("path");//存放根目录 /ftptest

			if (subfolder != null && !subfolder.equals("")) {
				path += "/" + subfolder;
			}
			path = new String(path.getBytes("UTF-8"), "iso-8859-1");
			FTPClient ftp = new FTPClient();
			ftp.connect(ip);
			ftp.login(userName, passWord);

			if (FTPReply.isPositiveCompletion(ftp.sendCommand("OPTS UTF8", "ON"))) {// 开启服务器对UTF-8的支持，如果服务器支持就用UTF-8编码，否则就使用本地编码（GBK）.
				LOCAL_CHARSET = "UTF-8";
			}
			ftp.setControlEncoding(LOCAL_CHARSET);
			//在ftp服务器上创建目录
			changeFtpWorkDir(ftp, path);
			ByteArrayInputStream is = new ByteArrayInputStream(data);
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			String s = new String(fileName.getBytes(LOCAL_CHARSET), SERVER_CHARSET);
			ftp.storeFile(s, is);
			is.close();
			ftp.disconnect();
			// 如果不转码，path中的中文返回到前端会变成乱码
			path = new String(path.getBytes("iso-8859-1"), "UTF-8");
			String retUrl = path + "/" + fileName;
			return retUrl;
		} catch (Exception e) {
			logger.error("error",e);
			e.printStackTrace();
		}
		return "error";
	}

	/**
	 * 切换ftp目录
	 *
	 * @param @param ftp @param @param path 设定文件
	 * @return void 返回类型
	 * @throws
	 * @Title: changeFtpWorkDir
	 */
	private void changeFtpWorkDir(FTPClient ftp, String path) {
		String[] pathArr = path.split("/");
		FTPFile[] ftpFiles = null;
		for (String ftpPath : pathArr) {
			if (ftpPath == null || ftpPath.equals("")) {
				continue;
			}
			try {
				ftpFiles = ftp.listDirectories(ftpPath);
				if (ftpFiles == null || ftpFiles.length == 0) {
					ftp.makeDirectory(ftpPath);
				}
				ftp.changeWorkingDirectory(ftpPath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 下载ftp文件到本地
	 *
	 * @param ip：ftp地址
	 * @param user：用户名
	 * @param password：密码
	 * @param dirPath：ftp目录
	 * @param fileName：文件名
	 * @param localPath：本地目录
	 */
	private File ftpDownloadFile(String ip, String user, String password, String dirPath, String fileName,
								 String localPath) {
		try {

			FTPClient ftpClient = new FTPClient();
			ftpClient.connect(ip);
			ftpClient.login(user, password);
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			File localFile = new File(localPath + "/" + fileName);
			String remoteFilePath = dirPath + "/" + fileName;
			// 因windows ftp服务器，这里需要硬转码否则中文文件名的文档下载不下来
			String chanFilePath = new String(remoteFilePath.getBytes("GBK"), "ISO-8859-1");
			System.out.println(remoteFilePath);
			System.out.println(chanFilePath);
			FileOutputStream is = new FileOutputStream(localFile);
			ftpClient.retrieveFile(chanFilePath, is);
			is.close();
			ftpClient.logout();
			ftpClient.disconnect();
			return localFile;
		} catch (IOException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

	/**
	 * @param @param ts @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 * @Title: timestamp2Str
	 * @Description: 将timestamp转换成字符串
	 */
	public String timestamp2Str(Timestamp ts) {
		String tsStr = "";
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		try {
			tsStr = sdf.format(ts);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tsStr;
	}

}
