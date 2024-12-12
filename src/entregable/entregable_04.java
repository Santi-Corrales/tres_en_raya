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
	
		System.out.println(" ");
		char [][] tablero = { //printamos el tablero con una variable de tipo matriz que tendra carácteres
				{'·','·','·','·','·'},
				{'·','-','-','-','·'},
				{'·','-','-','-','·'},
				{'·','-','-','-','·'},
				{'·','·','·','·','·'},
		};
		
		char [][] tablero_revancha = { //variable de repuesto para reiniciar la inicial por si hay revancha
				{'·','·','·','·','·'},
				{'·','-','-','-','·'},
				{'·','-','-','-','·'},
				{'·','-','-','-','·'},
				{'·','·','·','·','·'},
		};
		
		int contador = 0;
		String revancha = "Sí"; //variable que usaremos al final para pedir revancha
		
		for(int i = 0; i < tablero.length; i++){ //con este bucle FOR mostramos el tablero
			contador++;
			for(int j = 0; j < tablero[i].length; j++){ 
				System.out.print(tablero[i][j] + " ");	
			}
			System.out.println(" ");
		}
		
		do { //usaremos un DO-WHILE para poder repetir nuestro bucle principal en caso de que haya revancha 
		
		while (moneda == 0) { //para el caso de JUGADOR 1 
			
			int rondas = 6;
			int turno = 1;
			int terminar = 5;
			int cortar = 0;
			
			for (int ronda = 1; ronda < rondas; ronda++) {//bucle para las rondas 
				System.out.println("----------Ronda" + ronda + "----------");
				
				System.out.println(jugador1 + " " + "introduzca en que fila desea poner la ficha:");
				int fila1 = sc.nextInt();
				System.out.println(" ");
				System.out.println("Ahora introduzca en que columna desea poner la ficha:");
				int columna1 = sc.nextInt();
						
				if (tablero[fila1][columna1] == '-') { //transformamos la posición de carácter en X
					tablero[fila1][columna1] = 'X';
				} 
				
				for(int i = 0; i < tablero.length; i++){ //mostramos el tablero con la modificación de la ficha
					contador++;
					for(int j = 0; j < tablero[i].length; j++){ 
						System.out.print(tablero[i][j] + " ");	
					}
					System.out.println(" ");
				}
				//condiciones para GANADOR JUGADOR 1 
				if (tablero[1][1] == 'X' && tablero[1][2] == 'X' && tablero[1][3] == 'X'|| 
					tablero[2][1] == 'X' && tablero[2][2] == 'X' && tablero[2][3] == 'X'|| 
					tablero[3][1] == 'X' && tablero[3][2] == 'X' && tablero[3][3] == 'X'|| 
					tablero[1][1] == 'X' && tablero[2][1] == 'X' && tablero[3][1] == 'X'|| 
					tablero[1][2] == 'X' && tablero[2][2] == 'X' && tablero[3][2] == 'X'||
					tablero[1][3] == 'X' && tablero[2][3] == 'X' && tablero[3][3] == 'X'||
					tablero[1][1] == 'X' && tablero[2][2] == 'X' && tablero[3][3] == 'X'||
					tablero[1][3] == 'X' && tablero[2][2] == 'X' && tablero[3][1] == 'X') {
					System.out.println("¡" + jugador1 + "," + " has ganado la partida!");
					break;
				}
		
				cortar++;
				if (cortar == terminar) { //si se llega a 5 rondas el juego se para ya que no hay más espacios disponibles
					System.out.println("El juego ha terminado,¡Ha habido empate!");
					break;
				}
				//para jugador 2 
				System.out.println(jugador2 + " " + "introduzca en que fila desea poner la ficha:");
				int fila2 = sc.nextInt();
				System.out.println(" ");
				System.out.println("Ahora introduzca en que columna desea poner la ficha:");
				int columna2 = sc.nextInt();
				
				
				for (int i = 0; i < turno; i++) {
					if (tablero[fila2][columna2] == '-') {
						tablero[fila2][columna2] = 'O';
					} 
				}
				for(int i = 0; i < tablero.length; i++){ 
					contador++;
					for(int j = 0; j < tablero[i].length; j++){ 
						System.out.print(tablero[i][j] + " ");	
					}
					System.out.println(" ");
					
				}
				//condiciones para GANADOR JUGADOR 2 
				if (tablero[1][1] == 'O' && tablero[1][2] == 'O' && tablero[1][3] == 'O'|| 
					tablero[2][1] == 'O' && tablero[2][2] == 'O' && tablero[2][3] == 'O'|| 
					tablero[3][1] == 'O' && tablero[3][2] == 'O' && tablero[3][3] == 'O'|| 
					tablero[1][1] == 'O' && tablero[2][1] == 'O' && tablero[3][1] == 'O'|| 
					tablero[1][2] == 'O' && tablero[2][2] == 'O' && tablero[3][2] == 'O'||
					tablero[1][3] == 'O' && tablero[2][3] == 'O' && tablero[3][3] == 'O'||
					tablero[1][1] == 'O' && tablero[2][2] == 'O' && tablero[3][3] == 'O'||
					tablero[1][3] == 'O' && tablero[2][2] == 'O' && tablero[3][1] == 'O') {
					System.out.println("¡" + jugador2 + "," + " has ganado la partida!");
						break;
					}	
			}
			break;
		}
		
		
		
	}

}
