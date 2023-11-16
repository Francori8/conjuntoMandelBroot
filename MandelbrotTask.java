import java.awt.image.WritableRaster ;

public class MandelbrotTask extends Task{
   
    private double pseudoPixelY ;
    private int pixelY ;
    private double pseudoPixelX ;
    private double rangoX;
    private int width;
    private WritableRaster raster;
    private int cantIteraciones;
    private Convertor convertor;
    
    public MandelbrotTask(double pseudoPixelY, int pixelY,double pseudoPixelX, double rangoX,WritableRaster raster, int width, int cantIteraciones, Convertor convertor){
        this.pseudoPixelY = pseudoPixelY ;
        this.pixelY = pixelY ;
        this.pseudoPixelX = pseudoPixelX;
        this.width = width ;
        this.rangoX = rangoX ;
        this.raster = raster ;
        this.cantIteraciones = cantIteraciones;
        this.convertor = convertor;
    }

    public void run(){
        
        for( int xx = 0 ; xx < this.width ; xx++ ){
                
            int n = 0;
            Complejo numero = new Complejo(this.pseudoPixelX, this.pseudoPixelY);
            Complejo resul = new Complejo(0.0, 0.0);
            while( n < cantIteraciones && resul.calcularDistancia() <= 2.0 ){

                resul = resul.elevarAlCuadrado() ;
                resul = resul.sumar(numero);
                n++;
            }; 

            this.pseudoPixelX = this.pseudoPixelX + ((this.rangoX) / this.width); 
            
           

            raster.setPixel(xx,this.pixelY,this.convertor.devolverColores(n));

        }
    }
}