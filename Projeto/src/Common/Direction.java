package Common;

/* Autor: Paulo Vieira*/

public enum Direction {
    NORTH("N"), EAST("E"), WEST("W"), SOUTH("S");

    private String initials;

    //Construtor
    Direction(String initials) {
        this.initials = initials;
    }


    public String toString() {
        return this.initials;
    }

    //direção a partir da String
    public static Direction fromString(String text) {

        //se texto direferente de vazio
        if (text != null) {

            //Para cada direção (b)  nos (:) valores ()
            for (Direction b : Direction.values()) {
                //verifica se string iguais, independente de maiusculo/minisculo
                if (text.equalsIgnoreCase(b.initials)) {
                    return b;
                }
            }
        }

        //se direção invalida ou vazia, lançar exceção
        throw new IllegalArgumentException("Invalid direction value!");
    }
}
