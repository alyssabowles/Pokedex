import java.util.*;

public class Main {

    public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    int pokemonNum;
	String pokemonName;
	int[] pokeStats;
	int optionNum;
	String[] sortedList;
	String[] pokeList;

    System.out.println("Welcome to your new PokeDex!");
    System.out.print("How many Pokemon are in your region: ");
    pokemonNum = scan.nextInt();

    Pokedex myDex = new Pokedex(pokemonNum);

    System.out.println("");
    System.out.println("Your new Pokedex can hold " + pokemonNum + " Pokemon. Let's start using it!");
    System.out.println("");

    optionNum = 1;

    while(optionNum > 0 && optionNum <7) {

    System.out.println("1. List Pokemon");
    System.out.println("2. Add Pokemon");
    System.out.println("3. Check a Pokemon's Stats");
    System.out.println("4. Evolve Pokemon");
    System.out.println("5. Sort Pokemon");
    System.out.println("6. Exit");

    System.out.println("");
    System.out.print("What would you like to do? ");

    try {
        optionNum = scan.nextInt();
    }
    catch (InputMismatchException a) {
            System.out.println("\nThat is not a valid choice. Try again.\n");
            scan.nextLine();
            continue;
    }

    //If user selects 1, program will list all Pokemon in the Pokedex
    if(optionNum == 1) {
        pokeList = myDex.listPokemon();
        for (int i = 0; i < pokeList.length; i++) {
                if(pokeList[i] != null) {
                System.out.println(i+1 + ". " + pokeList[i]);
            }
        }
        System.out.println("");
    }

    //If user selects 2, program will prompt the use to enter a Pokemon into Pokedex
    if(optionNum == 2) {
        System.out.println("");
        System.out.print("Please enter the Pokemon's Species: ");
        scan.nextLine();
        pokemonName = scan.nextLine();
        myDex.addPokemon(pokemonName);
    }

    //If user selects 3, it will list the stats of a specific pokemon the user identifies
    if (optionNum == 3) {
        System.out.println("");
        System.out.print("Please enter the Pokemon of interest: ");
        scan.nextLine();
        pokemonName = scan.nextLine();
        if (myDex.pokemonMatch(pokemonName)) {
            System.out.println("");
            pokeStats = myDex.checkStats(pokemonName);
            System.out.println("The stats for " + pokemonName + " are:");
            System.out.println("Attack: " + pokeStats[0]);
            System.out.println("Defense: " + pokeStats[1]);
            System.out.println("Speed: " + pokeStats[2]);
        }
        else
            System.out.println("Missing");
            //Will print missing if there is no pokemon in the Pokedex with the name the user specifies
        System.out.println("");
    }

    //If user selects 4, the user can evolve a Pokemon of their choice
    if (optionNum == 4) {
        System.out.println("");
        System.out.print("Please enter the Pokemon of interest: ");
        scan.nextLine();
        pokemonName = scan.nextLine();
        if (myDex.pokemonMatch(pokemonName)) {
            myDex.evolvePokemon(pokemonName);
            System.out.println(pokemonName + " has evolved!");
            System.out.println("");
        }
        else {
            System.out.println("Missing");
            System.out.println("");
        }
    }

    //If user selects 5, the Pokedex will get sorted in alphabetical order
    if (optionNum == 5) {
        myDex.sortPokedex();
        System.out.println("");
    }

    //If user selects 6, it exits out of the program
    if (optionNum == 6) {
        return;
    }

    if (optionNum < 1 || optionNum > 6) {
        System.out.println("");
        System.out.println("That is not a valid choice. Try again.");
        optionNum = 1;
        System.out.println("");
    }
    }

    }
    }

