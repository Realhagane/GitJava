package ejercicio;



import java.io.Serializable;

public class Vehiculo implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 7296733561555284563L;
	private String matricula;
    private String marca;
    private String modelo;
    private int anioFabricacion;

    public Vehiculo(String matricula, String marca, String modelo, int anioFabricacion) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    @Override
    public String toString() {
        return "matricula=" + matricula +
                ", marca=" + marca +
                ", modelo=" + modelo +
                ", anioFabricacion=" + anioFabricacion;
    }
}
