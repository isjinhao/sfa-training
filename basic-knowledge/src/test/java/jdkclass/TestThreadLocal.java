package jdkclass;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/4
 */
public class TestThreadLocal  {

    public static void main(String[] args) {
        // 为每个线程生成一个唯一的局部标识
        ExecuteThread t1 = new ExecuteThread("custom-thread-1");
        ExecuteThread t2 = new ExecuteThread("custom-thread-2");
        ExecuteThread t3 = new ExecuteThread("custom-thread-3");
        t1.start();
        t2.start();
        t3.start();
    }

}


class ExecuteThread extends Thread{

    ThreadLocal<Integer> uniqueNum = ThreadLocal.withInitial(() -> 0);

    public ExecuteThread(String threadName) {
        this.setName(threadName);
    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            try {
                uniqueNum.set(uniqueNum.get() + 1);
                int value = uniqueNum.get();
                System.out.println("thread[ " + Thread.currentThread().getName() +
                    " ] --> uniqueNum[ " + value + " ]");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

// thread[ custom-thread-2 ] --> uniqueId[ 1 ]
// thread[ custom-thread-1 ] --> uniqueId[ 1 ]
// thread[ custom-thread-3 ] --> uniqueId[ 1 ]
// thread[ custom-thread-1 ] --> uniqueId[ 2 ]
// thread[ custom-thread-2 ] --> uniqueId[ 2 ]
// thread[ custom-thread-1 ] --> uniqueId[ 3 ]
// thread[ custom-thread-3 ] --> uniqueId[ 2 ]
// thread[ custom-thread-1 ] --> uniqueId[ 4 ]
// thread[ custom-thread-2 ] --> uniqueId[ 3 ]
// thread[ custom-thread-3 ] --> uniqueId[ 3 ]
// thread[ custom-thread-2 ] --> uniqueId[ 4 ]
// thread[ custom-thread-3 ] --> uniqueId[ 4 ]
// 每个线程之间的uniqueNum是互不干扰的