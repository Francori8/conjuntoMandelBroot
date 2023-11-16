public class ThreadPool {

    private Worker[] workers;
    private Buffer buffer;

    public ThreadPool(int cantWorkers, Buffer buf){
        buffer = buf;
        workers = new Worker[cantWorkers];
        this.crearWorkers(cantWorkers);
        
        
    };

    public void crearWorkers(int cant){
        for(int i = 0; i < cant ; i++){
            this.workers[i] = new Worker(this.buffer) ;
        }
    };

    public void startWorkers(){
        for(int i = 0; i < this.workers.length ; i ++){
            this.workers[i].start();
        }
      
    }


}
   