package maze.logic;

/**
 * Heroi.java - Uma classe que agrupa todas as funcoes necessarias à criacao de um objecto do tipo Heroi 
 * 
 * @author Admin
 *
 * @see Pecas 
 */

public class Heroi extends Pecas
{
	private boolean armado;
	
	public Heroi(int x, int y)
	{
		super(x, y);
		this.armado=false;
	}

	public boolean isArmado()
	{
		return armado;
	}

	public void setArmado(Boolean armado)
	{
		this.armado = armado;
	}
	
}
