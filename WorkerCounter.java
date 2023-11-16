public class WorkerCounter{
    private int nroBarrera;
    private int contador = 0;

    public WorkerCounter(int nro){
        this.nroBarrera = nro;
    }

    public synchronized void revisarParaTerminar(){
        while(contador<nroBarrera){
            try{
               
                wait();
            }catch(InterruptedException e){}
        }
    }
    public synchronized void aumentar(){
        this.contador++ ;
        if(contador == nroBarrera){
            notify();
        }
    }
}