package maze.logic;

/**
 * Celula.java - Uma classe que identifica cada uma das celulas do labirinto, sendo o labirinto uma matriz de celulas
 * 
 * @author Admin
 *
 */
public class Celula
{
	private int x;
	private int y;
	private boolean parede;
	private boolean saida;
	
	public Celula(int x, int y)
	{
		this.x=x;
		this.y=y;
		this.parede=true;
		this.saida=false;
	}

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public boolean isParede()
	{
		return parede;
	}

	public void setParede(boolean paredee)
	{
		parede = paredee;
	}

	public boolean isSaida()
	{
		return saida;
	}

	public void setSaida(boolean saidaa)
	{
		saida = saidaa;
	}
}
