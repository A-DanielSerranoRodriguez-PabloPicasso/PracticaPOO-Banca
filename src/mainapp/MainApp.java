package mainapp;

import java.util.ArrayList;
import java.util.Scanner;

import models.CuentaCorriente;
import models.Persona;

public class MainApp {
	static Scanner sc = new Scanner(System.in);
	static String menu1;
	static int menu2;
	static int cont = 0;
	static Persona per1 = new Persona("Dani", "Serra", "12345678Z", 2700);
	static Persona per2 = new Persona("Jose", "Lopez", "98765432A", 1000);
	static Persona per3 = new Persona("Pedro", "Martinez", "01928374G", 2000);
	static CuentaCorriente cc1 = new CuentaCorriente(1234, 0, per1);
	static CuentaCorriente cc2 = new CuentaCorriente(5678, 0, per2);
	static CuentaCorriente cc3 = new CuentaCorriente(9012, 0, per3);
	static ArrayList<Persona> gente = new ArrayList<Persona>();
	static int contador = 1;

	public static void main(String[] args) {

		do {
			System.out.println("a. Anadir persona");
			System.out.println("b. Elegir persona");
			System.out.println("c. Borrar persona");
			System.out.println("d. Salir");
			System.out.print(": ");
			menu1 = sc.next();
			opciones();
		} while (menu1 != "d");

		sc.close();
	}

	private static void opciones() {
		switch (menu1) {
		case "a":
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
			CuentaCorriente cuenta = new CuentaCorriente(contador, 0, persona);
			persona.setCuenta(cuenta);
			gente.add(persona);
			System.out.println();
			break;

		case "b":
			System.out.println();
			if (gente.size() > 0) {
				int cont1 = 1;
				for (Persona pers : gente) {
					System.out.println(cont1++ + ". " + pers.getDni() + " " + pers.getNombre());
				}
				System.out.print("Elige a la persona: ");
				menu2 = Integer.parseInt(sc.next());
				cont1 = 1;
				try {
					menuPersona(gente.get(menu2 - 1));
				} catch (Exception e) {
					System.out.println("Elige un numero válido");
				}
			} else {
				System.out.println("No hay gente");
			}
			System.out.println();
			break;

		case "c":
			int cont2 = 1;
			System.out.println();
			for (Persona pers : gente) {
				System.out.println(cont2++ + ". " + pers.getDni() + " " + pers.getNombre());
			}
			System.out.print("¿Que cuenta quieres borrar? ");
			menu2 = Integer.parseInt(sc.next());
			gente.remove(menu2 - 1);
			cont2 = 1;
			System.out.println();
			break;

		case "d":
			System.out.println();
			menu1 = "d";
			System.out.println("Ta luego figura");
			break;

		default:
			break;
		}
	}

	private static void menuPersona(Persona persona) {
		do {
			System.out.println("1. Cobrar sueldo");
			System.out.println("2. Sacar pasta");
			System.out.println("3. Subir sueldo");
			System.out.println("4. Mostrar detalles de la persona");
			System.out.println("5. Salir");
			System.out.print(": ");
			menu2 = Integer.parseInt(sc.next());
			accionesPersona(persona);
		} while (menu2 != -2);
	}

	private static void accionesPersona(Persona persona) {
		switch (menu2) {
		case 1:
			persona.cobrarSueldo();
			System.out.println();
			break;

		case 2:
			System.out.println();
			System.out.println("¿Cuanta pasta? ");
			persona.sacarPasta(Integer.parseInt(sc.next()));
			System.out.println();
			break;

		case 3:
			System.out.println();
			System.out.println("¿Cuanto quieres subirlo? ");
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
			menu2 = -2;
			System.out.println();
			break;

		default:
			System.out.println("Introduce una opcion correcta");
			break;
		}
	}

}
