package models;

public class Persona {
	private String nombre, apellidos, dni;
	private double sueldo;
	private CuentaCorriente cuenta;

	// Const
	public Persona(String nombre, String apellidos, String dni, double sueldo) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.sueldo = sueldo;
		this.cuenta = null;
	}

	// Getters - Setters
	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getDni() {
		return dni;
	}

	public double getSueldo() {
		return sueldo;
	}

	public CuentaCorriente getCuenta() {
		return cuenta;
	}

	public void setCuenta(CuentaCorriente cuenta) {
		this.cuenta = cuenta;
	}

	// Methods
	public void cobrarSueldo() {
		try {
			this.cuenta.sumarCantidad(this.sueldo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sacarPasta(double cantidad) {
		try {
			this.cuenta.restarCantidad(cantidad);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void subirSueldo(double nuevoSueldo) throws Exception {
		if (nuevoSueldo < 0)
			throw new Exception("Introduce una cantidad real");
		else
			this.sueldo += nuevoSueldo;
	}

	// toString
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", sueldo=" + sueldo
				+ ", saldo=" + this.cuenta.getSaldo() + "]";
	}

}
