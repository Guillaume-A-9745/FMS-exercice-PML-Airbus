import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/* Projet «PLM AIRBUS »
 * 
 * @author Anselme Guillaume
 * 
 * 
 */
public class lifeCycle {

	public static void main(String[] args) {
		//tableau des avions
		HashMap<String, List<String>> planes = new HashMap<String, List<String>>();
			planes.put("A320", Arrays.asList("ID987321654","PLM_AIRBUS_IN_SERVICE","Passenger"));
			planes.put("A400M", Arrays.asList("ID789456123","PLM_AIRBUS_DEFINITION","Cargo"));
			planes.put("A350", Arrays.asList("ID456789123","PLM_AIRBUS_FEASIBILTY","Passenger"));
			planes.put("A380", Arrays.asList("ID1234567889","PLM_AIRBUS_STOPPED","passenger"));
		//tableau des pièces
		HashMap<String, List<String>> AddAirplanePart = new HashMap<String, List<String>>();
			AddAirplanePart.put("A320-jauge de pression", Arrays.asList("Jauge de pression","Capteurs, Contrôleurs de pression","200 €"));
			AddAirplanePart.put("A350-jauge de pression", Arrays.asList("Jauge de pression","Capteurs, Contrôleurs de pression","210 €"));
			AddAirplanePart.put("A380-jauge de pression", Arrays.asList("Jauge de pression","Capteurs, Contrôleurs de pression","220 €"));
			AddAirplanePart.put("A320-Connecteur Twinax", Arrays.asList("Connecteur twinax","Accessoires de connexion, connecteurs","100 €"));
			AddAirplanePart.put("A350-Connecteur Twinax", Arrays.asList("Connecteur twinax","Accessoires de connexion, connecteurs","150 €"));
			AddAirplanePart.put("A380-Connecteur Twinax", Arrays.asList("Connecteur twinax","Accessoires de connexion, connecteurs","200 €"));
			AddAirplanePart.put("A320-Connecteur ultra-haute vitesse", Arrays.asList("Connecteur ultra-haute vitesse","Accessoires de connexion, connecteurs","80 €"));
			AddAirplanePart.put("A350-Connecteur ultra-haute vitesse", Arrays.asList("Connecteur ultra-haute vitesse","Accessoires de connexion, connecteurs","85 €"));
			AddAirplanePart.put("A380-Connecteur ultra-haute vitesse", Arrays.asList("Connecteur ultra-haute vitesse","Accessoires de connexion, connecteurs","90 €"));
			AddAirplanePart.put("A320-Conduit d'air", Arrays.asList("Conduit d'air","Tuyaux","150 €"));
			AddAirplanePart.put("A350-Conduit d'air", Arrays.asList("Conduit d'air","Tuyaux","150 €"));
			AddAirplanePart.put("A380-Conduit d'air", Arrays.asList("Conduit d'air","Tuyaux","150 €"));
		
		Scanner scan = new Scanner(System.in);
		int userChoice = 0;
		while(userChoice != 5) {
			System.out.println("Bienvenue dans l'application de gestion du cycle de vie d'avions Airbus.");
			System.out.println("Faites votre choix dans le menu, saisissez le chiffre correspondant :\n1 : Afficher tous les avions\n2 : Afficher tous les avions contenant un mot clé dans le programme. \n3 : Ajouter ou supprimer une pièce pour un avion donné\n4 : Afficher un avion avec les infos détaillées de chaque pièces\n5 : Quitter l'application");
			while(scan.hasNextInt() == false)	scan.next();
			userChoice = scan.nextInt();
			
			//Afficher tous les avions avec "id" "programme" "phase" "type"
			if(userChoice == 1) {
				int counter = 0;
				for(String i : planes.keySet()) {
					System.out.print( i += "");
					counter = planes.get(i).size();
					for(int j = 0; j < counter; j++) {
						System.out.print(" - " + planes.get(i).get(j) );
					}	
					System.out.println();
				}
			//Recherche liste d'avion à partir d'un mot clé
			} else if(userChoice == 2) {
				System.out.println("Quel avions rechercher vous ?");
				String userPlane = scan.next();
				int counter = 0;
				boolean wordpresent = false;
				for(String i : planes.keySet()) {
					counter = planes.get(i).size();
					if(userPlane.toLowerCase().equals(i.toLowerCase())) {
						System.out.println( i + planes.get(i) );
						System.out.println();
						wordpresent = true;
					}else {
						for(int j = 0; j < counter; j++) {	
							if(userPlane.toLowerCase().equals(planes.get(i).get(j).toLowerCase())) {
								System.out.print( i + planes.get(i) );
								System.out.println();
								wordpresent = true;
							}
						}
					}	
				}
				if(wordpresent == false) {
					System.out.println("Le mot " + userPlane + " n'est pas dans le programme!");
				}
				System.out.println();
			//Ajouter et supprimer une pièce pour un avion
			} else if(userChoice == 3) {
				String userPlaneChoice = "",namePartChoice,categoryPartChoice,pricePieceChoice;
				boolean planePresent = false;
				
				System.out.println("Souttez vous \n>1 -Ajouter une pièce  \n>2 -Suppriemer une pièce");
				while(scan.hasNextInt() == false)	scan.next();
				int addDelChoice = scan.nextInt();
				//Ajout
				if(addDelChoice == 1) {
					while(planePresent == false) {
						System.out.println("Pour quel avion du programme souhaitez vous ajouter une pièce ?");
						for(String i : planes.keySet()) System.out.print( i += " ");
						userPlaneChoice = scan.next();
						for(String i : planes.keySet()) {
							if((userPlaneChoice.toLowerCase()).equals(i.toLowerCase())) {
							planePresent = true;
							}	
						}
						if(planePresent == false) System.out.println("Cet avion n'est pas dans le programme.");
					}	
					System.out.println("Quel est le nom de la pièce :");
					namePartChoice = scan.next();
					System.out.println("Dans quelle catégorye :");
					pricePieceChoice = scan.next();
					System.out.println("Sont prix :");
					categoryPartChoice = scan.next();
					AddAirplanePart.put(userPlaneChoice.toUpperCase() + "-" +namePartChoice, Arrays.asList(namePartChoice,categoryPartChoice,pricePieceChoice));
					System.out.println("La pièce a bien "+ namePartChoice +" été ajouter enbase de donnée.");	
				//Suppression	
				} else if( addDelChoice == 2) {
					while(planePresent == false) {
						System.out.println("Pour quel avion du programme souhaitez vous supprimmer une pièce ?");
						for(String i : planes.keySet()) System.out.print( i += " ");
						userPlaneChoice = scan.next();
						int counter = 0;
						for(String i : AddAirplanePart.keySet()) {
							if(i.toLowerCase().contains(userPlaneChoice.toLowerCase())) {
								planePresent = true;
								System.out.print( i += "");
								counter = AddAirplanePart.get(i).size();
							for(int j = 0; j < counter; j++) {
								System.out.print(" - " + AddAirplanePart.get(i).get(j) );
								}	
							System.out.println();
							}
						}
						if(planePresent == false) System.out.println("Cet avion n'est pas dans le programme.");
					}	
					
				} else {
					System.out.println("Entrez 1 pour ajouter une pièce  2 pour en suppimer une.");
				}
				
				//for(String i : AddAirplanePart.keySet()) {
				//System.out.println(i);
				//}
				
				
			//5 Afficher les infos détaillées d'un avion
			} else if(userChoice == 4) {
				
				
				
			} else if(userChoice == 5) {
				System.out.println("Fin du programme !!");
				System.exit(0);
				
			} else {
				System.out.println("Entrez une valeur entre 1 et 5 !!");
				
			}
		}
		
		
		
		
		
		
		
		
		
		scan.close();
	}

}
