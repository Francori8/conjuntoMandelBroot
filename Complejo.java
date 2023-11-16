public class Complejo {
    double real;
    double imaginario;

    public Complejo(double real, double imaginario){
        this.real = real;
        this.imaginario = imaginario;
    }

    public double getReal(){
        return this.real;
    }

     public double getImaginario(){
        return this.imaginario;
    }

    public Complejo sumar(Complejo n){
        return new Complejo(this.real + n.getReal() , this.imaginario + n.getImaginario()) ; 
    }

    public Complejo elevarAlCuadrado(){
        return new Complejo( ((this.real * this.real) - (this.imaginario * this.imaginario)) , (2* this.real * this.imaginario));
    } 
    
    public double calcularDistancia(){
        return Math.sqrt(this.real * this.real + this.imaginario * this.imaginario) ;
    }
}
