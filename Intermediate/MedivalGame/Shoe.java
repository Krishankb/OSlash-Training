package org.example;

import java.io.Serializable;

public class Shoe extends Armour implements Serializable {

    private static final long serialVersionUID = 1L;
    public class someClass implements Serializable {
        // class body
    }
    /* Constructors */
    public Shoe(String name, int durability, int defenseRating) {
        super(name, durability, defenseRating);
    } }
