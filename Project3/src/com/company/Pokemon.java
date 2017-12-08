package com.company;

public class Pokemon {
    private String pkmnSpecies;
    private int pkmnAttack;
    private int pkmnDefense;
    private int pkmnSpeed;

    public Pokemon() {
        this.pkmnSpecies = "";
        this.pkmnAttack = 0;
        this.pkmnDefense = 0;
        this.pkmnSpeed = 0;
    }

    public Pokemon(String species, int attack, int defense, int speed) {
        this.pkmnSpecies = species;
        this.pkmnAttack = attack;
        this.pkmnDefense = defense;
        this.pkmnSpeed = speed;
    }

    //Setter method for speed stat
    public void setSpeed(int speed) {
         this.pkmnSpeed = speed;
    }

    //Setter method for attack stat
    public void setAttack(int attack) {
        this.pkmnAttack = attack;
    }

    //Setter method for defense stat
    public void setDefense(int defense) {
        this.pkmnDefense = defense;
    }

    //Setter method for Pokemon species name
    public void setSpecies(String species) {
        this.pkmnSpecies = species;
    }

    //Getter method for speed stat
    public int getSpeed() {
        return this.pkmnSpeed;
    }

    //Getter method for attack stat
    public int getAttack() {
        return this.pkmnAttack;
    }

    //Getter method for pokemon species name
    public String getSpecies() {
        return this.pkmnSpecies;
    }

    //Getter method for defense stat
    public int getDefense() {
        return this.pkmnDefense;
    }

    /*
     * Method used to evolve pokemon; it increases the selected Pokemon's
     * stats using the specified formula and calls the setter methods to
     * set the new ststs for the Pokemon.
     */
    public void evolve() {
        pkmnDefense = this.pkmnDefense * 5;
        pkmnSpeed = this.pkmnSpeed * 2;
        pkmnAttack = this.pkmnAttack * 3;
        setSpeed(pkmnSpeed);
        setAttack(pkmnAttack);
        setDefense(pkmnDefense);
    }

}
