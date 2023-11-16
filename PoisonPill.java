
public class PoisonPill extends Task{
    private WorkerCounter wc;

    public PoisonPill(WorkerCounter wc){
        this.wc = wc ;
    }

    public void run() {
        this.wc.aumentar();
        throw new RuntimeException("mori");
    }

}