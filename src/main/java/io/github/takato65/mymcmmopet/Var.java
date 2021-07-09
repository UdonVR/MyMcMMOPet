package io.github.takato65.mymcmmopet;

public enum Var {

    //<editor-fold desc="Vars" defaultstate="collapsed">
    petAttackGetExp(0, varType.BOOL, "petAttackGetExp","Does player get McMMO Taming Experience when a MyPet attacks"),
    petFallDamage(1, varType.BOOL, "petFallDamage","Does a MyPet take fall damage"),
    petLeashGetExp(2, varType.BOOL, "petLeashGetExp","Does player get McMMO Taming Experience when Leashing a MyPet"),
    petReleaseLoseExp(3, varType.BOOL, "petReleaseLoseExp","Does player lose McMMO Taming Experience when Releasing a MyPet"),
    ;
    //</editor-fold>
    final int id;
    final varType type;
    final boolean boolValue;
    final String name;
    final String description;

    Var(int id, varType type, String name, String description) {
        this.id = id;
        this.type = type;
        this.boolValue = MyMCMMOPet.config.getBoolean(name);
        this.name = name;
        this.description = description;
    }


    enum varType {
        BOOL,
        STRING,
        INT,
        DOUBLE,
    }
}
