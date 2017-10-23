package code.threadimpl;

public class SyncSysThread extends Thread {

	private String id;
	private String info;

	@Override
	public void run() {
		try {
			SysThreadImpl ds = new SysThreadImpl();
			ds.threadDo(id, info);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
