
import java.util.Scanner;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster ;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;



public class Main
{
	public static void main(String[] args ) {
       
	    Scanner lectura = new Scanner (System.in);
        System.out.println("Ingrese tamaño de imagen (valor sin pixeles):");
    
        int tamaño = lectura.nextInt();
        int width = tamaño;
        int height = tamaño ;

        System.out.println("Ingrese nro de Threads: ");
        
        int threads = lectura.nextInt();

        System.out.println("Ingrese cantidad de iteraciones: ");
        
        int cantIteraciones = lectura.nextInt();

        lectura.close();
	    double inicio = System.currentTimeMillis();
        
        double xInicial = -1.6; //valores para verlo completo -1.6
        double yInicial = -1 ;  // -1
        double rangoX = 2.2; // 2.2
        double rangoY = 2.2; //2.2
        
        System.out.println(inicio);
		BufferedImage bi = new BufferedImage(width , height , BufferedImage.TYPE_INT_RGB );
        WritableRaster raster = bi.getRaster();
        Convertor cover = new Convertor(cantIteraciones);
        Buffer buffer = new Buffer(5);
        ThreadPool pool = new ThreadPool(threads, buffer) ;
        WorkerCounter workerCounter = new WorkerCounter(threads) ;
        
       pool.startWorkers();
        
       double yUsada = yInicial;
    
        // Producir las MandelBrotTask
       for(int yy = 0 ; yy < height ; yy++){
            MandelbrotTask task = new MandelbrotTask(yUsada,yy,xInicial,rangoX,raster,width,cantIteraciones,cover) ;
            try{
                buffer.write(task);
            }catch(InterruptedException e) {}
            
            yUsada = yUsada + ((rangoY)/height); 

        }

        //Producir las poisonPIll
        for(int x = 0; x < threads; x++){
            PoisonPill task = new PoisonPill(workerCounter) ;
            try{
                buffer.write(task);
            }catch(InterruptedException e) {}
        }

        workerCounter.revisarParaTerminar();
        
       
    
        File outputfile = new File ("salida.png");
        try {
            ImageIO.write( bi, "png", outputfile );
        } catch ( IOException e ) {
        
            e.printStackTrace ();
        }
       

        double actual = System.currentTimeMillis();
        double tiempoEspera = actual - inicio ;
        double tiempoEsperaSeg  = tiempoEspera / 1000 ;
       
        System.out.println("El tiempo que se tardo es de: " + tiempoEspera + " milisegundos" ) ;
        System.out.println("El tiempo que se tardo es de: " + tiempoEsperaSeg + " segundos") ;
	}



}


