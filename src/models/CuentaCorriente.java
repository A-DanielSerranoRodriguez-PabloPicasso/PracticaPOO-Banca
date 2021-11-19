package models;

public class CuentaCorriente {
	private int numeroCuenta;
	private double saldo;
	private Persona titular;

	// Const
	public CuentaCorriente(int numeroCuenta, double saldo, Persona titular) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
		this.titular = titular;
	}

	// Getters - Setters
	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Persona getTitular() {
		return titular;
	}

	// Methods
	public void sumarCantidad(double cantidad) throws Exception {
		if (cantidad < 0)
			throw new Exception("Introduce una cantidad real");
		else
			this.saldo += cantidad;
	}

	public void restarCantidad(double cantidad) throws Exception {
		if (cantidad > this.saldo)
			throw new Exception("No tienes tanto dinero");
		else if (cantidad < 0)
			throw new Exception("Introduce una cantidad real");
		else
			this.saldo -= cantidad;
	}

	// toString
	@Override
	public String toString() {
		return "CuentaCorriente [numeroCuenta=" + numeroCuenta + ", saldo=" + saldo + "]";
	}

}
