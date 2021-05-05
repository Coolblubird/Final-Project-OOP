# Final Project OOP: Exportable and Importable RPG Battler

## Overview
This project is akin to the (likely) hundreds and hundreds of battlers you have seen. But the one thing that makes this unique is it's ability to Export and Import 
both the characters and the enemies. You can make hundreds of them and use any amount you need at a time, and save the rest tucked away in .TXT file somewhere.


## How to Run
The program is (I think atleast) fairly simple to run. You need to start with the file called "RPGBattleSim.Java". After which, you want to control the menu with
numbers that are given to you when necessary, and input strings when names or classes or races are needed. 

## Code Example
I love the idea for the exporting so much, so I wanted to share this section of it, this one is used in the exporting of enemies, It should export something akin to "The_ultimate_angel_of_death 999 999 999" when it is properly exported.
``` java
							System.out.println();
							System.out.println("Please enter a slot (1-10) for which the enemy we are exporting is.");
							select = (input.nextInt() - 1);
							System.out.println("Please copy the following information into your respective text storage device and press enter when you are done: " + enemies[select].toString2());
							input.nextLine();
							input.nextLine();
```

## Contributors
I'd love to see other people's contributions to this project, such as more advanced systems or ways that make the program run smoother/better.
