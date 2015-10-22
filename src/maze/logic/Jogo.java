package maze.logic;

import maze.logic.Labirinto;
import java.util.Random;

/**
 * Jogo.java - Uma classe que agrupa todas as funcoes necessarias ao funcionamento da logica do jogo, nomeadamente mover as pecas e coloca-las no tabuleiro
 * 
 * @author Admin
 * 
 */

public class Jogo
{
	public Celula[][] labirinto;
	public Heroi heroi;
	public Dragao dragao;
	public  Espada espada;
	static Random r = new Random();
	public  Labirinto lab;
	
	public Jogo(int n)
	{
		heroi = new Heroi(0,0);
		lab= new Labirinto(n);
		labirinto = new Celula[n][n];
		labirinto=lab.getLabirinto();
		// coloca Heroi

		boolean done = false;
		while (done == false) {
			int n1 = r.nextInt(n);
			int n2 = r.nextInt(n);
			if (labirinto[n1][n2].isParede()==false)
			{
				heroi = new Heroi(n1, n2);
				done = true;
			}
		}

		// coloca Dragao
		done = false; 
		while (done == false) {
			int n1 = r.nextInt(n);
			int n2 = r.nextInt(n);
			if (labirinto[n1][n2].isParede()==true ||
					(heroi.getX()== n1 - 1 && heroi.getY()==n2) ||
					(heroi.getX()==n1 + 1 && heroi.getY()==n2) ||
					(heroi.getX()==n1 && heroi.getY()==n2-1)||
					(heroi.getX()==n1 && heroi.getY()==n2+1)) {

			} else {
				dragao = new Dragao(n1, n2);
				done = true;
			}
		}

		//coloda espada
		done = false;
		while (done == false) {
			int n1 = r.nextInt(n);
			int n2 = r.nextInt(n);
			if (labirinto[n1][n2].isParede()==false)
			{
				espada = new Espada(n1, n2);
				done = true;
				espada.setVisivel(true);
				labirinto[n1][n2].setParede(false);
			}
		}
	}
	
	public void moveHeroi(int dir)
	{
		switch(dir)
		{
		case 0://vira cima
			if(heroi.isArmado()==false)
			{
				if(labirinto[heroi.getX()-1][heroi.getY()].isParede()==true)
				{
					break;
				}
				else if(labirinto[heroi.getX()-1][heroi.getY()].isSaida()==true)
				{
					break;
				}
				else if(heroi.getX()-1==espada.getX() && heroi.getY()==espada.getY())
				{
					heroi.setArmado(true);
					espada.setVisivel(false);
					break;
				}
				else if(heroi.getX()-1==dragao.getX() && heroi.getY()==dragao.getY())
				{
					System.exit(0);
				}
				else
				{
					heroi.setX(heroi.getX()-1);
					heroi.setY(heroi.getY());
					break;
				}
			}
			else if (heroi.isArmado()==true)
			{
				if(labirinto[heroi.getX()-1][heroi.getY()].isParede()==true)
				{
					break;
				}
				else if(labirinto[heroi.getX()-1][heroi.getY()].isSaida()==true)
				{
					System.exit(0);
					break;
				}
				else if(heroi.getX()-1==espada.getX() && heroi.getY()==espada.getY())
				{
					heroi.setArmado(true);
					espada.setVisivel(false);
					break;
				}
				else if(heroi.getX()-1==dragao.getX() && heroi.getY()==dragao.getY())
				{
					heroi.setX(heroi.getX()-1);
					heroi.setY(heroi.getY());
					dragao.setMorto(true);
					break;
				}
				else
				{
					heroi.setX(heroi.getX()-1);
					heroi.setY(heroi.getY());
					break;
				}
			}
		case 1://vira baixo
			if(heroi.isArmado()==false)
			{
				if(labirinto[heroi.getX()+1][heroi.getY()].isParede()==true)
				{
					break;
				}
				else if(labirinto[heroi.getX()+1][heroi.getY()].isSaida()==true)
				{
					break;
				}
				else if(heroi.getX()+1==espada.getX() && heroi.getY()==espada.getY())
				{
					heroi.setArmado(true);
					espada.setVisivel(false);
					break;
				}
				else if(heroi.getX()+1==dragao.getX() && heroi.getY()==dragao.getY())
				{
					System.exit(0);
				}
				else
				{
					heroi.setX(heroi.getX()+1);
					heroi.setY(heroi.getY());
					break;
				}
			}
			else if (heroi.isArmado()==true)
			{
				if(labirinto[heroi.getX()+1][heroi.getY()].isParede()==true)
				{
					break;
				}
				else if(labirinto[heroi.getX()+1][heroi.getY()].isSaida()==true)
				{
					System.exit(0);
					break;
				}
				else if(heroi.getX()+1==espada.getX() && heroi.getY()==espada.getY())
				{
					heroi.setArmado(true);
					espada.setVisivel(false);
					break;
				}
				else if(heroi.getX()+1==dragao.getX() && heroi.getY()==dragao.getY())
				{
					heroi.setX(heroi.getX()+1);
					heroi.setY(heroi.getY());
					dragao.setMorto(true);
					break;
				}
				else
				{
					heroi.setX(heroi.getX()+1);
					heroi.setY(heroi.getY());
					break;
				}
			}
		case 2://vira esquerda
			if(heroi.isArmado()==false)
			{
				if(labirinto[heroi.getX()][heroi.getY()-1].isParede()==true)
				{
					break;
				}
				else if(labirinto[heroi.getX()][heroi.getY()-1].isSaida()==true)
				{
					break;
				}
				else if(heroi.getX()==espada.getX() && heroi.getY()-1==espada.getY())
				{
					heroi.setArmado(true);
					espada.setVisivel(false);
					break;
				}
				else if(heroi.getX()==dragao.getX() && heroi.getY()-1==dragao.getY())
				{
					System.exit(0);
				}
				else
				{
					heroi.setX(heroi.getX());
					heroi.setY(heroi.getY()-1);
					break;
				}
			}
			else if (heroi.isArmado()==true)
			{
				if(labirinto[heroi.getX()][heroi.getY()-1].isParede()==true)
				{
					break;
				}
				else if(labirinto[heroi.getX()][heroi.getY()-1].isSaida()==true)
				{
					System.exit(0);
					break;
				}
				else if(heroi.getX()==espada.getX() && heroi.getY()-1==espada.getY())
				{
					heroi.setArmado(true);
					espada.setVisivel(false);
					break;
				}
				else if(heroi.getX()==dragao.getX() && heroi.getY()-1==dragao.getY())
				{
					heroi.setX(heroi.getX());
					heroi.setY(heroi.getY()-1);
					dragao.setMorto(true);
					break;
				}
				else
				{
					heroi.setX(heroi.getX());
					heroi.setY(heroi.getY()-1);
					break;
				}
			}
		case 3://vira para direita
			if(heroi.isArmado()==false)
			{
				if(labirinto[heroi.getX()][heroi.getY()+1].isParede()==true)
				{
					break;
				}
				else if(labirinto[heroi.getX()][heroi.getY()+1].isSaida()==true)
				{
					break;
				}
				else if(heroi.getX()==espada.getX() && heroi.getY()+1==espada.getY())
				{
					heroi.setArmado(true);
					espada.setVisivel(false);
					break;
				}
				else if(heroi.getX()==dragao.getX() && heroi.getY()+1==dragao.getY())
				{
					System.exit(0);
				}
				else
				{
					heroi.setX(heroi.getX());
					heroi.setY(heroi.getY()+1);
					break;
				}
			}
			else if (heroi.isArmado()==true)
			{
				if(labirinto[heroi.getX()][heroi.getY()+1].isParede()==true)
				{
					break;
				}
				else if(labirinto[heroi.getX()][heroi.getY()+1].isSaida()==true)
				{
					System.exit(0);
					break;
				}
				else if(heroi.getX()==espada.getX() && heroi.getY()+1==espada.getY())
				{
					heroi.setArmado(true);
					espada.setVisivel(false);
					break;
				}
				else if(heroi.getX()==dragao.getX() && heroi.getY()+1==dragao.getY())
				{
					heroi.setX(heroi.getX());
					heroi.setY(heroi.getY()+1);
					dragao.setMorto(true);
					break;
				}
				else
				{
					heroi.setX(heroi.getX());
					heroi.setY(heroi.getY()+1);
					break;
				}
			}
		}
	}
	
	public void moveDragao()
	{
		int dir = r.nextInt(4);
		switch(dir)
		{
		case 0://vira à esquerda
			if(dragao.isMorto()==true)
			{
				break;
			}
			else if(dragao.isDormir()==true)
			{
				break;
			}
			else
			{
				if(labirinto[dragao.getX()-1][dragao.getY()].isParede()==true)
				{
					break;
				}
				else if(labirinto[dragao.getX()-1][dragao.getY()].isSaida()==true)
				{
					break;
				}
				else if(dragao.getX()-1==heroi.getX() && dragao.getY()==heroi.getY())
				{
					System.exit(0);
				}
				else
				{
					dragao.setX(dragao.getX()-1);
					dragao.setY(dragao.getY());
					break;
				}
			}
		case 1://vira à direita
			if(dragao.isMorto()==true)
			{
				break;
			}
			else if(dragao.isDormir()==true)
			{
				break;
			}
			else
			{
				if(labirinto[dragao.getX()+1][dragao.getY()].isParede()==true)
				{
					break;
				}
				else if(labirinto[dragao.getX()+1][dragao.getY()].isSaida()==true)
				{
					break;
				}
				else if(dragao.getX()+1==heroi.getX() && dragao.getY()==heroi.getY())
				{
					System.exit(0);
				}
				else
				{
					dragao.setX(dragao.getX()+1);
					dragao.setY(dragao.getY());
					break;
				}
			}
		case 2://vira a cima
			if(dragao.isMorto()==true)
			{
				break;
			}
			else if(dragao.isDormir()==true)
			{
				break;
			}
			else
			{
				if(labirinto[dragao.getX()][dragao.getY()-1].isParede()==true)
				{
					break;
				}
				else if(labirinto[dragao.getX()][dragao.getY()-1].isSaida()==true)
				{
					break;
				}
				else if(dragao.getX()==heroi.getX() && dragao.getY()-1==heroi.getY())
				{
					System.exit(0);
				}
				else
				{
					dragao.setX(dragao.getX());
					dragao.setY(dragao.getY()-1);
					break;
				}
			}
		case 3://vira a baixo
			if(dragao.isMorto()==true)
			{
				break;
			}
			else if(dragao.isDormir()==true)
			{
				break;
			}
			else
			{
				if(labirinto[dragao.getX()][dragao.getY()+1].isParede()==true)
				{
					break;
				}
				else if(labirinto[dragao.getX()][dragao.getY()+1].isSaida()==true)
				{
					break;
				}
				else if(dragao.getX()==heroi.getX() && dragao.getY()+1==heroi.getY())
				{
					System.exit(0);
				}
				else
				{
					dragao.setX(dragao.getX());
					dragao.setY(dragao.getY()+1);
					break;
				}
			}
		}
	}
	
	public Celula[][] getLabirinto(){
		
		return labirinto;
	}
	
	public Heroi getHeroi()
	{
		return heroi;
	}
	
	public Espada getEspada()
	{
		return espada;
	}
	
	public Dragao getDragao()
	{
		return dragao;
	}
	
}