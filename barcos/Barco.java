package barcos;
/**
 * Clase para definir barcos.
 * @author Jose Manuel Pastor Lledó
 */
public abstract class Barco implements ICurable {

    private String nombre;
    private int tripulacion;
    protected int potenciaAtaque;
    protected int vida;

    /**
     * Constructor parametrizado de la clase barcos.
     * @param nombre Nombre del barco.
     */
    public Barco(String nombre) {
        this.tripulacion = 100;
        this.nombre = nombre;
        this.potenciaAtaque = 20;
        this.vida = 100;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPotenciaAtaque() {
        return potenciaAtaque;
    }

    public int getTripulacion() {
        return tripulacion;
    }

    public int getVida() {
        return vida;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPotenciaAtaque(int potenciaAtaque) {
        this.potenciaAtaque = potenciaAtaque;
    }

    public void setTripulacion(int tripulacion) {
        this.tripulacion = tripulacion;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + " Tripulación: " + this.tripulacion + " Potencia de ataque: "
                + this.potenciaAtaque + " Vida: " + this.vida;
    }

    /**
     * Metodo para atacar a oto barco.
     * @param barco Barco que va a tacar.
     * @return devuelve true si puede atacar y false si no.
     */
    public abstract boolean atacar(Barco barco);

    /**
     * Método para cambiar la vida de los barcos.
     * @param cantidad cantidad de vida que va a perder el barco.
     * Si la vida es inferior a 0, la vida será igual a 0.
     */
    public void actualizarVida(int cantidad) {
        this.vida -= cantidad;
        if (this.vida < 0) {
            this.vida = 0;
        }
    }

}
