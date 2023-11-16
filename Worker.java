public class Worker extends Thread{
    
   private Buffer buffer ;
   
   public Worker ( Buffer buffer ) {
    this.buffer = buffer ;
    }
    
    public void run () {
        try {
            while (true) {
                Task ob = buffer.read();
                ob.run();
            }
        }catch ( InterruptedException e ) {}
    }
}