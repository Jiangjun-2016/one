package code.threadimpl;

public class SysThreadImpl {

	/**
	 * 线程调用方法
	 */
	public void threadDo(String id, String info) {
		System.out.printf(id + info);
		System.out.printf("启动线程调用程序!");
	}
}
