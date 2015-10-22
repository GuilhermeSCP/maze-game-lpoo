package maze.logic;

/**
 * Espada.java - Uma classe que agrupa todas as funcoes necessarias à criacao de um objecto do tipo Espada
 * 
 * @author Admin
 *
 * @see Pecas 
 */

public class Espada extends Pecas
{
	private boolean visivel;
	
	public Espada(int x, int y)
	{
		super(x, y);
	}
	public boolean isVisivel()
	{
		return visivel;
	}
	public void setVisivel(boolean visivel)
	{
		this.visivel = visivel;
	}
}
