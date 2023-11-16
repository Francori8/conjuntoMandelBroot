
public class Buffer{
    private Task[] data ;
    private int maximo ;
    private int begin = 0, end = 0;
    
    public Buffer(int n){
        this.maximo = n;
       this.data = new Task [n +1];
    }
    
    synchronized void write (Task o) throws InterruptedException {
        while ( isFull ()) { wait (); }
            data [ begin ] = o;
            begin = next ( begin );
            notifyAll ();
        }
            
    synchronized Task read () throws InterruptedException {
        while ( isEmpty ()) { wait (); }
            Task result = data[end];
            end = next ( end );
            notifyAll ();
            return result ;
        }
    private boolean isEmpty () { return begin == end ; }
    private boolean isFull () { return next ( begin ) == end ; }
    private int next ( int i) { return (i +1) %( this.maximo +1); }

}