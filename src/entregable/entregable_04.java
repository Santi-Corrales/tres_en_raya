package entregable;

import java.util.Scanner;
import java.util.Random;

public class entregable_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		System.out.println("¡Bienvenido al tres en raya!");
		System.out.println(" ");
		System.out.println("¿Desea conocer las reglas del juego? (Sí/No)");
		String conocer = sc.nextLine();
		//preguntamos si desea conocer las reglas y en estos condicionales se printará lo que haya elegido el usuario
		if (conocer.equalsIgnoreCase("Sí")) {
			System.out.println("1. Se lanzará una moneda para elegir quien empazará primero.");
			System.out.println("2. El jugador 1 siempre será cara y el jugador 2 siempre será cruz");
			System.out.println("3. Los jugadores irán poniendo las fichas hasta que:");
			System.out.println("-Uno de los dos jugadores haya conseguido poner 3 fichas en línea, ya sea horizontalmente, verticalmente o diagonalmente.");
			System.out.println("Haya un empate debido a que no quedan más huecos libres en el tablero");
			System.out.println("4. Cuando termine el juego se preguntará si se desea revancha o finalizar el juego");
			System.out.println(" ");
			System.out.println("Ahora que conocemos las reglas.... ¡A jugar!");
		} else if (conocer.equalsIgnoreCase("No")) {
			System.out.println("¡De acuerdo, comenzemos con el juego!");
		} else {
			System.out.println("Ninguna opción elegida");
			System.out.println("¡A jugar!");
		}
		System.out.println(" ");
		System.out.println("Jugador 1 será cara"); //especificamos como se hará la selección de la moneda y seguidamente preguntamos los nombres
		System.out.println("Jugador 2 será cruz");
		System.out.println(" ");
		System.out.println("Introduzca el nombre del jugador 1: ");
		String jugador1 = sc.nextLine();
		System.out.println("Introduzca el nombre del jugador 2:");
		String jugador2 = sc.nextLine();
		System.out.println(" ");
		System.out.println("Tiraremos una moneda para saber que jugador empezará...");
		Random random = new Random();
		int moneda = random.nextInt(2);
		//con el random elegimos quien empieza y según lo que salga correspondrá a jugador 1 o jugador 2
		if (moneda == 0) {
			System.out.println("Ha salido cara," + " " + jugador1 + " " + "empezará");
			System.out.println("Se empieza con 'x'");
		} else if (moneda == 1) {
			System.out.println("Ha salido cruz," + " " + jugador2 + " " + "empezará");
			System.out.println("Se empieza con 'x'");

		}
		
		
		
	}

}
