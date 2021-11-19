package mainapp;

import java.util.ArrayList;
import java.util.Scanner;

import models.CuentaCorriente;
import models.Persona;

public class MainApp {
	static Scanner sc = new Scanner(System.in);
	static String menu1;
	static int menu2 = 0;
	static int cont = 1;
	static Persona per1 = new Persona("Dani", "Serra", "12345678Z", 2700);
	static Persona per2 = new Persona("Jose", "Lopez", "98765432A", 1000);
	static Persona per3 = new Persona("Pedro", "Martinez", "01928374G", 2000);
	static CuentaCorriente cc1 = new CuentaCorriente(1234, 0, per1);
	static CuentaCorriente cc2 = new CuentaCorriente(5678, 0, per2);
	static CuentaCorriente cc3 = new CuentaCorriente(9012, 0, per3);
	static ArrayList<Persona> gente = new ArrayList<Persona>();
	static String[] array = new String[0];
	static int count = gente.size();

	public static void main(String[] args) {

//		Persona per1 = new Persona("Dani", "Serra", "12345678Z", 2700, cc1);
//		Persona per2 = new Persona("Jose", "Lopez", "98765432A", 1000, cc2);
//		Persona per3 = new Persona("Pedro", "Martinez", "01928374G", 2000, cc3);

//		
//		per1.cobrarSueldo();
//		per1.sacarPasta(300);
//		try {
//			per1.subirSueldo(3000);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

//		System.out.println(per1 + "\n" + per2 + "\n" + per3);
//		System.out.println(cc1 + "\n" + cc2 + "\n" + cc3);
//		System.out.println(per1);
//		System.out.println(cc);

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
			System.out.println("Introduce los datos de la persona\n");
			System.out.print("Nombre: ");
			String nom = sc.next();
			System.out.print("Apellido: ");
			String ape = sc.next();
			System.out.print("DNI: ");
			String dni = sc.next();
			System.out.print("Sueldo: ");
			Double sueldo = Double.parseDouble(sc.next());

			Persona arr = new Persona(nom, ape, dni, sueldo);
			gente.add(arr);
			break;

		default:
			break;
		}
	}

//	private static void menuPersona() {
//		do {
//			System.out.println("1. Cobrar sueldo");
//			System.out.println("2. Sacar pasta");
//			System.out.println("3. Subir sueldo");
//			System.out.println("4. Mostrar detalles de la persona");
//			System.out.println("5. Salir");
//			System.out.print(": ");
//			menu2 = Integer.parseInt(sc.next());
//			accionesPersona();
//		} while (menu2 != -2);
//	}
//
//	private static void accionesPersona() {
//		switch (menu2) {
//		case 1:
//			per1.cobrarSueldo();
//			break;
//
//		case 2:
//			System.out.println("¿Cuanta pasta? ");
//			per1.sacarPasta(Integer.parseInt(sc.next()));
//			break;
//
//		case 3:
//			System.out.println("¿Cuanto quieres subirlo? ");
//			per1.sacarPasta(Integer.parseInt(sc.next()));
//			break;
//
//		case 4:
//			System.out.println(per1);
//			break;
//
//		case 5:
//			menu2 = -2;
//			break;
//
//		default:
//			System.out.println("Introduce una opcion correcta");
//			break;
//		}
//	}

}
