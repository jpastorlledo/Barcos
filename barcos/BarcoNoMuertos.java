package barcos;

/**
 * Clase que hereda de la clase barcos, para crear un barco de no muertos.
 * @author José Manuel Pastor Lledó
 */
public class BarcoNoMuertos extends Barco {

    private int barrera;

    /**
     * Constructor parametrizado de la clase barcoNoMuertos
     * @param nombre Nombre del barco.
     */
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

    /**
     * Método para hacer una pequeña cura.
     */
    public void curaLigera() { 
        this.vida -= this.vida * 0.5f;
        this.potenciaAtaque += this.potenciaAtaque * 0.4f;
    }

    /**
     * Método para hacer una gran cura.
     */
    public void curaLenta() { 
        this.vida -= this.vida * 0.75f;
        this.potenciaAtaque += this.potenciaAtaque * 0.7f;
    }

    /**
     * Método para cambiar la barrera del barco.
     * @param cantidad Cantidad de la barrera que va a perder el barco.
     * @return Devuelve el valor de la nueva barrera, que será el valor
     * de la antigua barrera menos la cantidad que va a perder.
     */
    public int actualizarEscudo(int cantidad) {
        this.barrera -= cantidad;
        return this.barrera;
    }

    /**
     * Método para modificar la vida del barco.
     * @param cantidad Cantidad de vida que va a perder el barco.
     * Si la barrera es mayor que 0 llama al método actualizarEscudo, y si no
     * devuele la nueva cantidad de vida.
     * 
     */
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
