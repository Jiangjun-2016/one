package jdk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author fxf
 * @create 2018-06-20 11:05
 * 线程池的使用
 **/

public class ExecutorServiceDemo {

	public static void main(String[] args) {

		// 可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程
		// 线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程。
		// ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		// for (int i = 0; i < 10; i++) {
		// 	final int index = i;
		// 	try {
		// 		Thread.sleep(index * 1000);
		// 	} catch (InterruptedException e) {
		// 		e.printStackTrace();
		// 	}
		// 	cachedThreadPool.execute(new Runnable() {
		// 		public void run() {
		// 			System.out.println(index);
		// 		}
		// 	});
		// }


		System.out.println("go");
		//每次都使用同一个线程
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					System.out.println("主Thread");
					try {
						Thread.currentThread();
						Thread.sleep(1000);
						System.out.println("主Thread" + Thread.currentThread().hashCode());
						// 可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程
						ExecutorService cachedThreadPool = Executors
								.newCachedThreadPool();
						//每次都使用不同的线程
						cachedThreadPool.execute(new Runnable() {
							public void run() {
								// 开始执行Service方法 或  业务逻辑
								System.out.println("cachedThreadPool");
								System.out.println("cachedThreadPool" + Thread.currentThread().hashCode());
							}
						});
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
}