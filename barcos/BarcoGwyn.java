package barcos;

/**
 * Clase que hereda de la clase barcos, para crear un barco Gwyn.
 * @author José Manuel Pastor Lledó
 */
public class BarcoGwyn extends Barco {

    private int cantidadRayos;

    /**
     * Constructor parametrizado de la clase barcoGwyn
     * @param nombre Nombre del barco.
     */
    public BarcoGwyn(String nombre) {
        super(nombre);
        this.cantidadRayos = 3;
    }

    public int getCantidadRayos() {
        return cantidadRayos;
    }

    public void setCantidadRayos(int cantidadRayos) {
        this.cantidadRayos = cantidadRayos;
    }

    @Override
    public String toString() {
        return super.toString() + " Cantidad de rayos: " + this.cantidadRayos;
    }

    /**
     * Método atacar de la clase barcoGwyn.
     * @param barco Nombre del barco.
     * Devuelve false en caso de que la cantidad de rayos o de vida sea inferior a 0
     * y devuelve true si no, además de disminuir la cantidad de rayos.
     * 
     */
    @Override
    public boolean atacar(Barco barco) { 
        if (cantidadRayos <= 0)
            return false;
        if (getVida() <= 0)
            return false;

        cantidadRayos--;

        barco.actualizarVida(getPotenciaAtaque());
        return true;
    }

    /**
     * Método para hacer una pequeña cura.
     */
    public void curaLigera() {
        this.vida += this.vida * 0.25f;
    }

    /**
     * Método para hacer una gran cura.
     */
    public void curaLenta() {
        this.vida += this.vida * 0.5f;
    }

}
