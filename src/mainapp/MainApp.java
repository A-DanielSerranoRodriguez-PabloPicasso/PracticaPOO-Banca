package mainapp;

import java.util.ArrayList;
import java.util.Scanner;

import models.CuentaCorriente;
import models.Persona;

public class MainApp {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Persona> gente = new ArrayList<Persona>();
	static ArrayList<CuentaCorriente> cuentas = new ArrayList<CuentaCorriente>();
	static int contador = 1;

	public static void main(String[] args) {
		// EJEMPLOS RAPIDOS
		Persona per1 = new Persona("Dani", "Serra", "12345678Z", 2700);
		Persona per2 = new Persona("Jose", "Lopez", "98765432A", 1000);
		Persona per3 = new Persona("Pedro", "Martinez", "01928374G", 2000);
		gente.add(per1);
		gente.add(per2);
		gente.add(per3);
		CuentaCorriente cc1 = new CuentaCorriente((int) Math.random() * 7, 0, per1);
		CuentaCorriente cc2 = new CuentaCorriente((int) Math.random() * 7, 0, per2);
		CuentaCorriente cc3 = new CuentaCorriente((int) Math.random() * 7, 0, per3);
		cuentas.add(cc1);
		cuentas.add(cc2);
		cuentas.add(cc3);
		per1.setCuenta(cc1);
		per2.setCuenta(cc2);
		per3.setCuenta(cc3);

		do {
			System.out.println("a. Anadir persona");
			System.out.println("b. Elegir persona");
			System.out.println("c. Borrar persona");
			System.out.println("d. Salir");
			System.out.print(": ");
		} while (menuPersona(sc.next()));

		sc.close();
	}

	private static boolean menuPersona(String menu1) {
		int cont = 1;
		int opc;

		switch (menu1) {
		case "a": // Recogemos todos los datos de la persona que queremos crear
			System.out.println("\nIntroduce los datos de la persona");
			System.out.print("Nombre: ");
			String nom = sc.next();
			System.out.print("Apellido: ");
			String ape = sc.next();
			System.out.print("DNI: ");
			String dni = sc.next();
			System.out.print("Sueldo: ");
			Double sueldo = Double.parseDouble(sc.next());
			Persona persona = new Persona(nom, ape, dni, sueldo);
			CuentaCorriente cuenta = new CuentaCorriente(contador++, 0, persona);
			persona.setCuenta(cuenta); // Le asignamos la nueva cuenta creada. En el constructor se pone a NULL
			gente.add(persona); // Metemos la persona en un ArrayList
			cuentas.add(cuenta); // Metemos la cuenta en un ArrayList
			System.out.println("\n");
			break;

		// Mostramos el contenido del ArrayList de las personas, mostrando su contenido
		// y permitiendo al usuario elegir con quien quiere iniciar sesion
		case "b":
			System.out.println("\n");
			if (gente.size() > 0) {
				// Recorremos el array, mostrando las personas
				for (Persona pers : gente) {
					System.out.println(cont++ + ". " + pers.getDni() + " " + pers.getNombre());
				}
				System.out.println();
				System.out.println(cont + ". Salir\n");
				System.out.print("Elige a la persona: ");
				opc = Integer.parseInt(sc.next());
				if (opc == cont) {
					System.out.println("\n");
					break;
				} else // Vamos al menu con la cuenta seleccionada
					try {
						opcionesCuentaPersona(gente.get(opc - 1));
					} catch (Exception e) {
						System.out.println("Elige un numero válido");
					}
				cont = 1;
			} else {
				System.out.println("No hay gente");
			}
			System.out.println();
			break;

		// Mostramos el contenido del ArrayList de las personas y borramos el usuario
		// seleccionado
		case "c":
			System.out.println("\n");
			for (Persona pers : gente) {
				System.out.println(cont++ + ". " + pers.getDni() + " " + pers.getNombre());
			}
			System.out.println();
			System.out.println(cont + ". Salir\n");
			System.out.print("¿Que cuenta quieres borrar? ");
			opc = Integer.parseInt(sc.next());
			if (opc == cont) {
				System.out.println("\n");
				break;
			} else {
				gente.remove(opc - 1);
				cuentas.remove(opc - 1);
			}
			cont = 1;
			System.out.println();
			break;

		case "d":
			System.out.println("\nTa luego figura");
			return false;

		default:
			System.out.println("\nIntroduce una opcion correcta\n");
			break;
		}
		return true;
	}

	// Menu con lo que podemos hacer con la cuenta bancaria de la persona con la que
	// hemos accedido
	private static void opcionesCuentaPersona(Persona persona) {
		System.out.println();
		System.out.println("Bienvenid@ " + persona.getNombre());
		do {
			System.out.println("1. Cobrar sueldo");
			System.out.println("2. Sacar pasta");
			System.out.println("3. Subir sueldo");
			System.out.println("4. Mostrar detalles de la persona");
			System.out.println("5. Salir");
			System.out.print(": ");
		} while (accionesCuenta(Integer.parseInt(sc.next()), persona));
	}

	private static boolean accionesCuenta(int opcion, Persona persona) {
		switch (opcion) {
		case 1:
			persona.cobrarSueldo();
			System.out.println();
			break;

		case 2:
			System.out.print("\n¿Cuanta pasta? ");
			persona.sacarPasta(Integer.parseInt(sc.next()));
			System.out.println();
			break;

		case 3:
			System.out.println("\n¿Cuanto quieres subirlo? ");
			try {
				persona.subirSueldo(Double.parseDouble(sc.next()));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println();
			break;

		case 4:
			System.out.println(persona);
			System.out.println();
			break;

		case 5:
			System.out.println();
			return false;

		default:
			System.out.println("\nIntroduce una opcion correcta\n");
			break;
		}
		return true;
	}

}
