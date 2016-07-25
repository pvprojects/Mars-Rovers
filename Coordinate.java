package Common;
/* Autor: Paulo Vieira - 19/07/16
 * Criar plano cartesiano para movimentar robo em MARTE
 * Coordenadas central (0,0)
 * Movimentos:  R - Girar 90 º para direita (Right) 
 * 				L - Girar 90 º para esquerda (Left)
 * 				M - Avançar 1 um ponto  de grade em 90º (North) (x,y+1) se 0 > x <=180º
 * 														        (x,y-1) se 180> x <=360
 * */
public class Coordinate {
	//pontos cartesianos
	public int x; 
	public int y;
	//construtor
	public Coordinate(int x, int y) { 
	    this.x = x; 
	    this.y = y; 
	} 
}
