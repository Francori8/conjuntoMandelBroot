import java.awt.Color;
public  class Convertor
{
    private int[][] colores;

    public Convertor(int cant_iteraciones){
        this.colores = convertir(cant_iteraciones);
    }

    public int[][] convertir(int cant_iteraciones){
        int[] r = new int[ cant_iteraciones+1];
        int[] g = new int[ cant_iteraciones+1];
        int[] b = new int[ cant_iteraciones+1];
        r[cant_iteraciones]=0;
        g[cant_iteraciones]=0;
        b[cant_iteraciones]=0;
        for (int i =0; i < cant_iteraciones ; i ++) { 
            int argb = Color.HSBtoRGB( i/256f  , 1 , 1);
            
            r [ i ] = argb >> 16;
            g [ i ] = ( argb >> 8) & 255;
            b [ i ] = argb & 255;
        }
        int colores[][] = {r, g, b};
        return colores;
        
    }

    public int[] devolverColores(int iteraciones){
        int coloresRGB[] = {colores[0][iteraciones], colores[1][iteraciones], colores[2][iteraciones]};
        return coloresRGB ;
    }
}