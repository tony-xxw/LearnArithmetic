package thread;


import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;

public class ExecutorPoolMain {
    static int i = 1;

    public static void main(String[] args) {


//        FutureTask futureTask = new FutureTask(new MyCallThread());
//        Thread task = new Thread(futureTask, "task");
//
//        System.out.println("state : " + task.getState().name());
//        task.start();
//        System.out.println("state : " + task.getState().name());
//
//
//        try {
//            System.out.println("result : " + futureTask.get());
//            System.out.println("state : " + task.getState().name());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("a","b");
    }



}

class MyCallThread implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(100);
        return "i go it ";
    }
}


