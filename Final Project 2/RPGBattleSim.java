import java.util.*;
import java.lang.*;

//Jordan Ashe Month-Day-21

public class RPGBattleSim {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int mode = 0;
		int tempMode=0;
		int select = 0;
		String choice = " ";
		String temp1 = " ";
		String temp2 = " ";
		String temp3 = " ";
		int temp4 = 0;
		int temp5 = 0;
		int temp6 = 0;
		PartyMem blank = new PartyMem("Empty", " ", " ", 0, 0, 0);
		Enemy blankE = new Enemy("Empty", 0, 0, 0);
		PartyMem[] characters = new PartyMem[10];
		characters[0] = new PartyMem("Blanky", "Blankerton", "No Class", 10, 10, 5);
		characters[1] = new PartyMem("Foo", "Bar", "Placeholder", 15, 15, 20);
		characters[2] = new PartyMem("M.T.Mann", "Machine", "A Robot", 30, 20, 7);
		characters[3] = blank;
		characters[4] = blank;
		characters[5] = blank;
		characters[6] = blank;
		characters[7] = blank;
		characters[8] = blank;
		characters[9] = blank;
		PartyMem[] party = new PartyMem[4];
		addToGroup(characters[0], party, 0);
		addToGroup(blank, party, 1);
		addToGroup(blank, party, 2);
		addToGroup(blank, party, 3);
		
		Enemy[] enemies = new Enemy[10];
		enemies[0] = new Enemy("Gobblin' Goblin", 5, 6, 8);
		enemies[1] = new Enemy("The ultimate angel of death", 999, 999, 999);
		enemies[2] = new Enemy("Empty", 0,0,0);
		enemies[3] = new Enemy("Empty", 0,0,0);
		enemies[4] = new Enemy("Empty", 0,0,0);
		enemies[5] = new Enemy("Empty", 0,0,0);
		enemies[6] = new Enemy("Empty", 0,0,0);
		enemies[7] = new Enemy("Empty", 0,0,0);
		enemies[8] = new Enemy("Empty", 0,0,0);
		enemies[9] = new Enemy("Empty", 0,0,0);
		Enemy[] enemiesInBattle = new Enemy[4];
		addToGroup(enemies[0], enemiesInBattle, 0);
		addToGroup(blankE, enemiesInBattle, 1);
		addToGroup(blankE, enemiesInBattle, 2);
		addToGroup(blankE, enemiesInBattle, 3);
		
		while (mode != 5) {
			switch (mode){
				default:
					System.out.println("----------------------");
					System.out.println(" Simple RPG Simulator");
					System.out.println("----------------------");
					System.out.println("Select a menu:");
					System.out.println("1) Character Builder");
					System.out.println("2) Enemy Builder");
					System.out.println("3) Import or Export a Battler!");
					System.out.println("4) Battle!");
					System.out.println("5) Exit (NOTE YOUR CHARACTERS IN USE WILL NOT BE SAVED, PLEASE EXPORT THEM!)");
					System.out.println();
					System.out.println("Please select a number.");
					try {
						mode = input.nextInt();
					} catch (Exception e) {
						System.out.println("There seems to have been a problem with the code, please reload the program again.");
						System.exit(0);
					}
					break;
				case 1:
//Character Builder
					tempMode=0;
					while (tempMode!=3) {
						System.out.println();
						System.out.println("----------------------");
						System.out.println("   Character Builder");
						System.out.println("----------------------");
						System.out.println("Select a menu:");
						System.out.println("1) Create a Character");
						System.out.println("2) Edit a Character");
						System.out.println("3) Return to Main Menu");
						System.out.println();
						System.out.println("Please select a number.");
						try {
							tempMode = input.nextInt();
							if (tempMode == 1) {
								System.out.println();
								System.out.println("Please enter a slot (1-10) for which the character will be residing in. (NOTE: THIS ERASES THE CHARACTER THAT IS RESIDING IN THIS CURRENT SPOT!)");
									select = (input.nextInt() - 1);
									characters[select] = createChar();
							}
							else if (tempMode == 2) {
								System.out.println("----------------------(Stats left to right are: Name, Race, Class, Max Health, Damage, Speed.)");
								for(int i=0; i<10; i++){
									System.out.println((i+1) + ") " + characters[i].toString());
								}
								System.out.println("-------------------------------------------------------------");
								System.out.println();
								System.out.println("Please input which character you would like to edit (0 to cancel).");
								select = (input.nextInt() - 1);
								
								if (select != -1){
									characters[select] = changeChar(characters[select]);
								}
							}
							else if (tempMode==3) {
								mode=0;
							}
						} catch (Exception e) {
							System.out.println("There seems to have been a problem with the code, please reload the program again.");
							System.exit(0);
						}
					}
					if (mode!=0)
						mode=1;
					break;
				case 2:
					tempMode=0;
					System.out.println();
					System.out.println("----------------------");
					System.out.println("    Enemy Builder");
					System.out.println("----------------------");
					System.out.println("Select a menu:");
					System.out.println("1) Create an Enemy");
					System.out.println("2) Edit an Enemy");
					System.out.println("3) Return to Main Menu");
					System.out.println();
					System.out.println("Please select a number.");
					try {
						tempMode = input.nextInt();
						if (tempMode == 1) {
							System.out.println();
							System.out.println("Please enter a slot (1-10) for which the enemy will be residing in. (NOTE: THIS ERASES THE ENEMY THAT IS RESIDING IN THIS CURRENT SPOT!)");
								select = (input.nextInt() - 1);
								enemies[select] = createEnemy();
						}
						else if (tempMode == 2) {
							System.out.println("----------------------(Stats left to right are: Name, Max Health, Damage, Speed.)");
							for(int i=0; i<10; i++){
								System.out.println((i+1) + ") " + enemies[i].toString());
							}
							System.out.println("-------------------------------------------------------------");
							System.out.println();
							System.out.println("Please input which enemy you would like to edit (0 to cancel).");
							select = (input.nextInt() - 1);
							
							if (select != -1){
								enemies[select] = changeEnemy(enemies[select]);
							}
						}
						else if (tempMode==3) {
							mode=0;
						}
					} catch (Exception e) {
						System.out.println("There seems to have been a problem with the code, please reload the program again.");
						System.exit(0);
					}
					if (mode!=0)
						mode=2;
					break;
				case 3:
					tempMode=0;
					System.out.println();
					System.out.println("----------------------");
					System.out.println("   Export and Import");
					System.out.println("----------------------");
					System.out.println("Select a menu:");
					System.out.println("1) Export a Character");
					System.out.println("2) Import a Character");
					System.out.println("3) Export an Enemy");
					System.out.println("4) Import an Enemy");
					System.out.println("5) Return to Main Menu");
					System.out.println();
					System.out.println("Please select a number.");
					try {
						tempMode = input.nextInt();
						if (tempMode == 1) {
							System.out.println();
							System.out.println("Please enter a slot (1-10) for which the character we are exporting is.");
							select = (input.nextInt() - 1);
							System.out.println("Please copy the following information into your respective text storage device and press enter when you are done: " + characters[select].toString2());
							input.nextLine();
							input.nextLine();
						}
						else if (tempMode == 2) {
							System.out.println();
							System.out.println("Please enter a slot (1-10) for which the character we are importing will be. (NOTE THIS ERASES THE CHARACTER CURRENTLY OCCUPING THE SLOT!)");
							select = (input.nextInt() - 1);
							System.out.print("Please paste the information from your respective text storage device and press enter when you are done: ");
							input.nextLine();
							String[] tempTable = input.nextLine().split(" ");
							temp1 = tempTable[0];
							temp2 = tempTable[1];
							temp3 = tempTable[2];
							temp4 = Integer.parseInt(tempTable[3]);
							temp5 = Integer.parseInt(tempTable[4]);
							temp6 = Integer.parseInt(tempTable[5]);
							characters[select] = new PartyMem(temp1.replaceAll("_", " "),temp2.replaceAll("_", " "),temp3.replaceAll("_", " "),temp4,temp5,temp6);
						}
						else if (tempMode == 3) {
							System.out.println();
							System.out.println("Please enter a slot (1-10) for which the enemy we are exporting is.");
							select = (input.nextInt() - 1);
							System.out.println("Please copy the following information into your respective text storage device and press enter when you are done: " + enemies[select].toString2());
							input.nextLine();
							input.nextLine();
						}
						else if (tempMode == 4) {
							System.out.println();
							System.out.println("Please enter a slot (1-10) for which the character we are importing will be. (NOTE THIS ERASES THE CHARACTER CURRENTLY OCCUPING THE SLOT!)");
							select = (input.nextInt() - 1);
							System.out.print("Please paste the information from your respective text storage device and press enter when you are done: ");
							input.nextLine();
							String[] tempTable = input.nextLine().split(" ");
							temp1 = tempTable[0];
							temp4 = Integer.parseInt(tempTable[1]);
							temp5 = Integer.parseInt(tempTable[2]);
							temp6 = Integer.parseInt(tempTable[3]);
							enemies[select] = new Enemy(temp1.replaceAll("_", " "),temp4,temp5,temp6);
						}
						else if (tempMode==5) {
							mode=0;
						}
					} catch (Exception e) {
						System.out.println("There seems to have been a problem with the code, please reload the program again.");
						System.exit(0);
					}
					if (mode!=0)
						mode=3;
					break;
				case 4:
					tempMode=0;
					System.out.println();
					System.out.println("----------------------");
					System.out.println("     Battle Mode!");
					System.out.println("----------------------");
					System.out.println("Select a menu:");
					System.out.println("1) Party Members");
					System.out.println("2) Enemy Team");
					System.out.println("3) Battle!");
					System.out.println("4) Return to Main Menu");
					System.out.println();
					System.out.println("Please select a number.");
					try {
						tempMode = input.nextInt();
						if (tempMode == 1) {
							System.out.println();
							System.out.println("The Party currently is this: ");
							System.out.println("----------------------");
							for(int i=0; i<4; i++){
								System.out.println((i+1) + ") " + party[i].toString());
							}
							System.out.println("----------------------");
							System.out.println("Would you like to change this party? (Y)es or (N)o: ");
							input.nextLine();
							choice = input.nextLine();
							if (choice.toLowerCase().charAt(0) == 'y'){
								System.out.println("----------------------");
								for(int i=0; i<10; i++){
									System.out.println((i+1) + ") " + characters[i].toString());
								}
								System.out.println("----------------------");
								System.out.println("Please enter the value of the first Party Member.");
								select = (input.nextInt() - 1);
								addToGroup(characters[select], party, 0);
								System.out.println("Please enter the value of the second Party Member. (or 0 to finish making a party.) ");
								select = (input.nextInt() - 1);
								if (select!=-1){
									addToGroup(characters[select], party, 1);
									System.out.println("Please enter the value of the third Party Member. (or 0 to finish making a party.) ");
									select = (input.nextInt() - 1);
									if (select!=-1){
										addToGroup(characters[select], party, 2);
										System.out.println("Please enter the value of the final Party Member. (or 0 to finish making a party.) ");
										select = (input.nextInt() - 1);
										if (select!=-1){
											addToGroup(characters[select], party, 3);
										}
										else{
											addToGroup(blank, party, 3);
										}
									}
									else{
										addToGroup(blank, party, 2);
										addToGroup(blank, party, 3);
									}
								}
								else{
									addToGroup(blank, party, 1);
									addToGroup(blank, party, 2);
									addToGroup(blank, party, 3);
								}
							}
						}
						else if (tempMode == 2) {
							System.out.println();
							System.out.println("The Enemy Group currently is this: ");
							System.out.println("----------------------");
							for(int i=0; i<4; i++){
								System.out.println((i+1) + ") " + enemiesInBattle[i].toString());
							}
							System.out.println("----------------------");
							System.out.println("Would you like to change this? (Y)es or (N)o: ");
							input.nextLine();
							choice = input.nextLine();
							if (choice.toLowerCase().charAt(0) == 'y'){
								System.out.println("----------------------");
								for(int i=0; i<10; i++){
									System.out.println((i+1) + ") " + enemies[i].toString());
								}
								System.out.println("----------------------");
								System.out.println("Please enter the value of the first Party Member.");
								select = (input.nextInt() - 1);
								addToGroup(enemies[select], enemiesInBattle, 0);
								System.out.println("Please enter the value of the second Party Member. (or 0 to finish making a party.) ");
								select = (input.nextInt() - 1);
								if (select!=-1){
									addToGroup(enemies[select], enemiesInBattle, 1);
									System.out.println("Please enter the value of the third Party Member. (or 0 to finish making a party.) ");
									select = (input.nextInt() - 1);
									if (select!=-1){
										addToGroup(enemies[select], enemiesInBattle, 2);
										System.out.println("Please enter the value of the final Party Member. (or 0 to finish making a party.) ");
										select = (input.nextInt() - 1);
										if (select!=-1){
											addToGroup(enemies[select], enemiesInBattle, 3);
										}
										else{
											addToGroup(blankE, enemiesInBattle, 3);
										}
									}
									else{
										addToGroup(blankE, enemiesInBattle, 2);
										addToGroup(blankE, enemiesInBattle, 3);
									}
								}
								else{
									addToGroup(blankE, enemiesInBattle, 1);
									addToGroup(blankE, enemiesInBattle, 2);
									addToGroup(blankE, enemiesInBattle, 3);
								}
							}
						}
						else if (tempMode == 3) {
							startBattle(party, enemiesInBattle);
						}
						else if (tempMode==4) {
							mode=0;
						}
					} catch (Exception e) {
						System.out.println("There seems to have been a problem with the code, please reload the program again.");
						System.exit(0);
					}
					if (mode!=0)
						mode=4;
					break;
			}
		}
		
		System.out.println();
		System.out.println("Thanks for playing!");
	}
	
	public static PartyMem changeChar(PartyMem p){
		Scanner input = new Scanner(System.in);
		PartyMem newP = p;
		String choice = "N";
		String temp = "uhh";
		
		System.out.print("Change the race? (Y)es or (N)o: ");
		choice = input.nextLine();
		if (choice.toLowerCase().charAt(0) == 'y'){
			System.out.print("Please enter the new race: ");
			temp = input.nextLine();
			newP.setRace(temp);
		}
		
		System.out.print("Change the class? (Y)es or (N)o: ");
		choice = input.nextLine();
		if (choice.toLowerCase().charAt(0) == 'y'){
			System.out.print("Please enter the new class: ");
			temp = input.nextLine();
			newP.setPClass(temp);
		}
		
		System.out.print("Change the Damage stat? (Y)es or (N)o: ");
		choice = input.nextLine();
		if (choice.toLowerCase().charAt(0) == 'y'){
			System.out.print("Please enter the new number: ");
			temp = input.nextLine();
			newP.setDMG(Integer.parseInt(temp));
		}
			
		System.out.print("Change the Speed stat? (Y)es or (N)o: ");
		choice = input.nextLine();
		if (choice.toLowerCase().charAt(0) == 'y'){
			System.out.print("Please enter the new number: ");
			temp = input.nextLine();
			newP.setSPD(Integer.parseInt(temp));
		}
			
		return newP;
	}
	public static PartyMem createChar(){
		Scanner input = new Scanner(System.in);
		PartyMem newP;
		String choice = "N";
		String temp1 = "uhh";
		String temp2 = "you";
		String temp3 = "wont";
		int temp4 = 0;
		int temp5 = 0;
		int temp6 = 0;
		
		System.out.println();
		System.out.print("Please give this character a name: ");
		temp1 = input.nextLine();
		
		System.out.println();
		System.out.print("Please give this character a race: ");
		temp2 = input.nextLine();
		
		System.out.println();
		System.out.print("Please give this character a class: ");
		temp3 = input.nextLine();
		
		System.out.println();
		System.out.print("Please give this character an HP Max (we recommend between 1-999, but you can go outside of this value): ");
		temp4 = input.nextInt();
		
		System.out.println();
		System.out.print("Please give this character a Damage modifier (we recommend between 1-999, but you can go outside of this value): ");
		temp5 = input.nextInt();
		
		System.out.println();
		System.out.print("Please give this character a Speed modifier (we recommend between 1-999, but you can go outside of this value): ");
		temp6 = input.nextInt();
		
		newP = new PartyMem(temp1, temp2, temp3, temp4, temp5, temp6);
		return newP;
	}
	public static Enemy changeEnemy(Enemy e){
		Scanner input = new Scanner(System.in);
		Enemy newE = e;
		String choice = "N";
		String temp = "uhh";
		
		System.out.print("Change the Damage stat? (Y)es or (N)o: ");
		choice = input.nextLine();
		if (choice.toLowerCase().charAt(0) == 'y'){
			System.out.print("Please enter the new number: ");
			temp = input.nextLine();
			newE.setDMG(Integer.parseInt(temp));
		}
			
		System.out.print("Change the Speed stat? (Y)es or (N)o: ");
		choice = input.nextLine();
		if (choice.toLowerCase().charAt(0) == 'y'){
			System.out.print("Please enter the new number: ");
			temp = input.nextLine();
			newE.setSPD(Integer.parseInt(temp));
		}
			
		return newE;
	}
	
	public static void addToGroup(Battler p, Battler[] b, int i){
		boolean switch1=false;
		
		for(int c = 0; c<4; c++)
			if ((b[c] == p) && (p.getName()!="Empty"))
				switch1=true;
		
		if (switch1 == false)
			b[i]=p;
	}
	
	public static Enemy createEnemy(){
		Scanner input = new Scanner(System.in);
		Enemy newE;
		String choice = "N";
		String temp1 = "uhh";
		int temp4 = 0;
		int temp5 = 0;
		int temp6 = 0;
		
		System.out.println();
		System.out.print("Please give this Enemy a name: ");
		temp1 = input.nextLine();
		
		System.out.println();
		System.out.print("Please give this Enemy an HP Max (we recommend between 1-999, but you can go outside of this value): ");
		temp4 = input.nextInt();
		
		System.out.println();
		System.out.print("Please give this Enemy a Damage modifier (we recommend between 1-999, but you can go outside of this value): ");
		temp5 = input.nextInt();
		
		System.out.println();
		System.out.print("Please give this Enemy a Speed modifier (we recommend between 1-999, but you can go outside of this value): ");
		temp6 = input.nextInt();
		
		newE = new Enemy(temp1, temp4, temp5, temp6);
		return newE;
	}
	
	public static void startBattle(PartyMem[] p, Enemy[] e){
		Scanner input = new Scanner(System.in);
		int partyAlive=4;
		int enemyAlive=4;
		int tempAlive=4;
		int target=1;
		int action=0;
		boolean pTurn;
		
		if ((p[0].getSPD() + p[1].getSPD() + p[2].getSPD() + p[3].getSPD()) >= (e[0].getSPD() + e[1].getSPD() + e[2].getSPD() + e[3].getSPD())){
			pTurn = true;
		}
		else{
			pTurn = false;
		}
		
		System.out.println("----------------------");
		System.out.println("    Begin the Game!");
		System.out.println("----------------------");
		
		for (int i=0; i<4; i++){
			e[i].setCHP(e[i].getMHP());
			p[i].setCHP(p[i].getMHP());
		}
		
		partyAlive=4;
		enemyAlive=4;
		
		
		while ((partyAlive!=0) && (enemyAlive!=0)){
			if (pTurn==true){
				//player turn
				
				
					for (int i=0;(i<4 && (enemyAlive!=0));i++){	
						if ((p[i].getName().equals("Empty")==false) && (p[i].getCHP()>0) && (enemyAlive!=0)){
							System.out.println("----------------------");
							for(int b=0; b<4; b++){
								if ((p[b].getCHP()>0) || (p[b].getName().equals("Empty")==false)){
									System.out.println((b+1) + ") " + p[b].toString());
								}
							}
							System.out.println("----------------------");
							System.out.println("1) Attack");
							System.out.println("2) Block");
							System.out.println();
							System.out.println("What will " + p[i].getName() + " be doing?");
							action = input.nextInt();
							if (action==1){
								System.out.println("----------------------");
								for(int b=0; b<4; b++){
									if ((e[b].getCHP()>0) && (e[b].getName().equals("Empty")==false)){
										System.out.println((b+1) + ") " + e[b].toString());
									}
								}
								System.out.println("----------------------");
								System.out.println();
								System.out.println("Who will be your target for the attack?");
								target = (input.nextInt()-1);
								if (e[target].isBlocking()==false){
									e[target].setCHP(e[target].getCHP()-p[i].getDMG());
								}
								else {
									e[target].setCHP(e[target].getCHP()-(p[i].getDMG()/2));
								}
							}
							else {
								p[i].setBlock(true);
							}
						}
					}
				
				
				e[0].setBlock(false);
				e[1].setBlock(false);
				e[2].setBlock(false);
				e[3].setBlock(false);
				
				for (int i=0;i<4;i++){
					if (((e[i].getCHP()>0) && (e[i].getName().equals("Empty")==false))!=true){
						tempAlive-=1;
					}
				}
				enemyAlive=tempAlive;
				tempAlive=4;
				
				pTurn=false;
			}
			else{
				//enemy turn
				
				if (partyAlive!=0) {
					for (int i=0;i<4;i++){	
						if ((e[i].getName().equals("Empty")==false) && (e[i].getCHP()>0)){
							action = ((int)((Math.random()*2)));
							if (action==1){
								while (p[target].getName().equals("Empty") == true){ 
									target = (int)(Math.random()*4);
								}
								
								if (p[target].isBlocking()==false){
									p[target].setCHP(p[target].getCHP()-e[i].getDMG());
								}
								else{
									p[target].setCHP(p[target].getCHP()-(e[i].getDMG()/2));
								}
								
								System.out.println(e[i].getName() + " attacks " + p[target].getName() + "!");
							}
							else{
								e[i].setBlock(true);
								System.out.println(e[i].getName() + " blocks!");

							}
						}
					}
				}
					
				p[0].setBlock(false);
				p[1].setBlock(false);
				p[2].setBlock(false);
				p[3].setBlock(false);
				
				
				for (int i=0;i<4;i++){
					if (((p[i].getCHP()>0) && (p[i].getName().equals("Empty")==false))!=true){
						tempAlive-=1;
					}
				}
				
				partyAlive=tempAlive;
				tempAlive=4;
				
				pTurn=true;
			}
		}
		
		if (partyAlive==0){
			System.out.println("Ohhh no! The party has lost! (press enter to move back to the menu)");
			input.nextLine();
			input.nextLine();
		}
		
		if (enemyAlive==0){
			System.out.println("Yeah! Victory for the party! (press enter to move back to the menu)");
			input.nextLine();
			input.nextLine();
		}
		
	}
}