package maze.logic;
/**
 * Pecas.java - Uma classe que agrupa todas as funcoes necessarias à criacao de um objecto do tipo peça, ou seja, uma peça do tabuleiro que pode ser o Herói, a Espada ou um Dragao 
 * 
 * @author Admin
 *
 */
public class Pecas
{
	private int x;
	private int y;
	
	public Pecas(int x, int y)
	{
		this.x=x;
		this.y=y;
	}
	public int getX()
	{
		return this.x;
		
	}
	public int getY()
	{
		return this.y;
	}
	public void setX(int x)
	{
		this.x=x;
	}
	public void setY(int y)
	{
		this.y=y;
	}
};
