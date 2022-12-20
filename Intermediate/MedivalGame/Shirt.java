package org.example;

import java.io.Serializable;

public class Shirt extends Armour implements Serializable {

    private static final long serialVersionUID = 1L;
    public class someClass implements Serializable {
        // class body
    }
    /* Constructors */
    public Shirt(String name, int durability, int defenseRating) {
        super(name, durability, defenseRating);
    }
}
