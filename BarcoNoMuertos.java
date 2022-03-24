package barcos;

public class BarcoNoMuertos extends Barco {

    private int barrera;

    public BarcoNoMuertos(String nombre) {
        super(nombre);
        this.barrera = 20;
    }

    public int getBarrera() {
        return barrera;
    }

    public void setBarrera(int barrera) {
        this.barrera = barrera;
    }

    @Override
    public String toString() {
        return super.toString() + " Barrera: " + this.barrera;
    }

    @Override
    public boolean atacar(Barco barco) { 
        if (this.barrera > 0) {
            barco.actualizarVida(getPotenciaAtaque() * 2);
            return true;
        }
        barco.actualizarVida(getPotenciaAtaque() / 2);
        return true;
    }

    public void curaLigera() { 
        this.vida -= this.vida * 0.5f;
        this.potenciaAtaque += this.potenciaAtaque * 0.4f;
    }

    public void curaLenta() { 
        this.vida -= this.vida * 0.75f;
        this.potenciaAtaque += this.potenciaAtaque * 0.7f;
    }

    public int actualizarEscudo(int cantidad) {
        this.barrera -= cantidad;
        return this.barrera;
    }

    @Override
    public void actualizarVida(int cantidad) {
        if (this.barrera > 0) {
            actualizarEscudo(cantidad);
            if (this.barrera < 0) {
                this.barrera = 0;
            }
        } else {
            this.vida -= cantidad;
        }
    }

}
