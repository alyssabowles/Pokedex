package com.company;

public class Pokedex extends Pokemon {

    private String[] pkmnList;
    private int listVal = -1;
    private int[] stat;
    private String[] pokemons;
    Pokemon[] myPokemon;

    //Pokedex constructor
    public Pokedex(int dexVal) {
        super();
        this.myPokemon = new Pokemon[dexVal];
        this.pkmnList = new String[dexVal];
        this.stat = new int[3];
        this.pokemons = new String[dexVal];
    }

    //Lists all Pokemon in the Pokedex.
    public String[] listPokemon() {
        if(myPokemon[0] == null) {
            System.out.println("No Pokemon");
        }
        return pkmnList;
    }

    //Checks if the Pokemon the user entered is in the Pokedex
    public boolean pokemonMatch(String species) {
        boolean match = false;
        for (int i = 0; i < pkmnList.length; i++) {
            if (species.equalsIgnoreCase(pkmnList[i])) {
                match = true;
                break;
            }
        }
        return match;
    }

    //Adds Pokemon into Pokedex if there is space on Pokedex. It also checks to see if the Pokemon is already in the Dex.
    public boolean addPokemon(String species) {
        listVal++;
        boolean samePokemon = false;
        boolean maxPokemon = false;


        if (!samePokemon && !maxPokemon) {
            for (int i = 0; i < pkmnList.length; i++) {
                if (species.equalsIgnoreCase(pkmnList[i])) {
                    samePokemon = true;
                    System.out.println("Duplicate");
                    listVal--;
                }
            }
            if (listVal == pkmnList.length && !samePokemon) {
                System.out.println("Max");
                listVal--;
                maxPokemon = true;
            }
        }
        if (!samePokemon && !maxPokemon) {
            pkmnList[listVal] = species;
            myPokemon[listVal] = new Pokemon(species, (species.length()*4) + 2 , (species.length()*2)+7 , (species.length()*3)+5);

        }
        System.out.println("");
        return !samePokemon;
    }

    //Checks the attack, defense, and speed stats of a specified Pokemon
    public int[] checkStats (String species) {
        int pkmnNum = 0;
        for (int i = 0; i < pkmnList.length; i++) {
            if (species.equalsIgnoreCase(pkmnList[i])) {
                pkmnNum = i;
                break;
            }
        }
        this.stat[0] = myPokemon[pkmnNum].getAttack();
        this.stat[1] = myPokemon[pkmnNum].getDefense();
        this.stat[2] = myPokemon[pkmnNum].getSpeed();
        return this.stat;
    }

    //Sorts Pokedex in alphabetical order
    public void sortPokedex() {
        String temp;
        for (int i = 0; i < pkmnList.length- 1; i++) {
            for (int j = 1 + i; j < pkmnList.length; j++) {
                if (pkmnList[j] != null) {
                    if (pkmnList[i].compareToIgnoreCase(pkmnList[j]) > 0) {
                        temp = pkmnList[i];
                        pkmnList[i] = pkmnList[j];
                        pkmnList[j] = temp;
                    }
                }
            }
        }
    }

    //Evolves the specified pokemon by calling the evolve method in the Pokemon class
    public boolean evolvePokemon(String species) {
        boolean canEvolve = false;
        for (int i = 0; i < pkmnList.length; i++) {
            if (species.equalsIgnoreCase(pkmnList[i])) {
                canEvolve = true;
                myPokemon[i].evolve();
                break;
            }
        }
        return canEvolve;
    }
}
