package maze.logic;

/**
 * Dragao.java - Uma classe que agrupa todas as funcoes necessarias à criacao de um objecto do tipo Dragao 
 * 
 * @author Admin
 *
 * @see Pecas 
 */
public class Dragao extends Pecas
{
	private boolean morto;
	private boolean dormir;
	public Dragao(int x, int y)
	{
		super(x, y);
		this.morto=false;
		this.dormir=false;
	}
	public boolean isMorto()
	{
		return morto;
	}
	public void setMorto(boolean morto)
	{
		this.morto = morto;
	}
	public boolean isDormir()
	{
		return dormir;
	}
	public void setDormir(boolean dormir)
	{
		this.dormir = dormir;
	}

}
