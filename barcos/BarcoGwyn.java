package barcos;

public class BarcoGwyn extends Barco {

    private int cantidadRayos;

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

    public void curaLigera() {
        this.vida += this.vida * 0.25f;
    }

    public void curaLenta() {
        this.vida += this.vida * 0.5f;
    }

}
