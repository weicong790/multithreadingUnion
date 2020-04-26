package Project5_FutureAndCallable;

import java.util.concurrent.*;

/**
 * ExecutorService的submit(Callable<T>)与Future的get方法配合使用
 * Future.get()方法具有阻塞特性
 * submit() VS execute():
 *          execute没有返回值，submit具有返回值。
 *          execute出现异常直接打印堆栈信息，submit可以捕获；通过线程池设置UncaughtExceptionHandler，执行execute也可以捕捉异常
 */
class  MyCallable implements Callable<String>{
    private int age;

    public MyCallable(int age){
        super();
        this.age = age;
    }
    @Override
    public String call() throws Exception {
        Thread.sleep(3000);
        return "返回值 年龄是"+age;
    }
}
class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("打印信息");
    }
}
public class Test {


    public static void main(String[] args) {
        try{
            //创建一个自定义Callable类
            MyCallable callable = new MyCallable(100);
            //创建一个ThreadPoolExecutor
            ThreadPoolExecutor executor = new ThreadPoolExecutor(2,3,5L, TimeUnit.SECONDS,new LinkedBlockingDeque<>());

            //1、将Callable作为参数传入，打开线程执行Callable重写的Call()方法，并且返回类型为Future
            System.out.println("----1----");
            Future<String> future = executor.submit(callable);
            //通过Future的get方法获取任务返回值，此方法阻塞
            System.out.println(future.get());


            //2、将Runnable传入submit()方法
            System.out.println("----2----");
            Future future2 = executor.submit(new MyRunnable());
            //如果submit传入的是Runnable
            System.out.println(future2.get() + ","+future.isDone());


            //3、将Runnable和result参数传入submit，result可以作为执行结果的返回值，替代Future的get方法
            System.out.println("----3----");
            UserInfo userInfo = new UserInfo();
            Future<UserInfo> future3 = executor.submit(new SetUserInfoRunnable(userInfo),userInfo);
            userInfo = future3.get();
            System.out.println("结果："+userInfo.getUsername()+","+userInfo.getPassword());

        }catch (Exception e){

        }
    }
}
