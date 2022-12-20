package org.example;

import java.io.Serializable;

public class Trouser extends Armour implements Serializable {

    private static final long serialVersionUID = 1L;
    public class someClass implements Serializable {
        // class body
    }
    /* Constructors */
    public Trouser(String name, int durability, int defenseRating) {
        super(name, durability, defenseRating);
    }
}
