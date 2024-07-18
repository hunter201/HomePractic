public class MyThread implements Runnable {
    private long x = 1000;

    @Override
    public void run() {
        for (int i = 0; i <=x; i++) {
           if(i%2 == 0) {
               System.out.println(i);
           }
        }

    }
}
