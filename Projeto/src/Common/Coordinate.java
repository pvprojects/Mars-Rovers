package Common;

/* Autor: Paulo Vieira - 19/07/16
 * Criar plano cartesiano para movimentar robo em MARTE
 * Coordenadas central (0,0)
 * Movimentos:  R - Girar 90º para direita (Right)
 * 				L - Girar 90º para esquerda (Left)
 * 				M - Avançar 1 um ponto  de grade em 90º (North) (x,y+1) se 0 > x <=180º
 * 														        (x,y-1) se 180º > x <=360º
 * */
public class Coordinate {

    public int x;
    public int y;

    //construtor
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
