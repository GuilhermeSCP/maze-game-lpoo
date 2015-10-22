package maze.logic;

import java.util.Random;

/**
 * Labirinto.java - Uma classe que agrupa todas as funcoes necessarias à criacao do Labirinto, uma matriz de Celulas 
 * 
 * @author Admin
 * 
 */

public class Labirinto
{
	private Celula[][] labirinto;
	Random r = new Random();
	
	public Labirinto(int n)
	{
		int x=0, y=0;
		labirinto = new Celula[n][n];
		
		for(int j = 0 ; j<n; j++)
		{
			for(int i =0; i<n ; i++)
			{
				labirinto[j][i] = new Celula(i,j);
			}
		}
		
		System.out.println(labirinto[1][1]);
		// paredes exteriores
		for (int i = 0; i < n; i++)
		{
			(labirinto[0][i]).setParede(true);
		}
		for (int i = 0; i < n; i++) {
			labirinto[i][0].setParede(true);
		}
		for (int i = 0; i < n; i++) {
			labirinto[n - 1][i].setParede(true);
		}
		for (int i = 0; i < n; i++) {
			labirinto[i][n - 1].setParede(true);
		}

		// coloca casas de dentro todas com 'x'
		for (int i = 1; i < labirinto.length - 1; i++) {
			for (int j = 1; j < labirinto[i].length - 1; j++) {
				labirinto[i][j].setParede(true);
			}
		}

		// colocar 'S' aleatoriamente
		int num1 = r.nextInt(4);
		int num2 = r.nextInt(n);
		while (num2 == 0 || num2 == n - 1) {
			num2 = r.nextInt(n);
		}

		if (num1 == 0 && num2 != 0 && num2 != n - 1) {
			labirinto[0][num2].setSaida(true);
			labirinto[0][num2].setParede(false);
			x = num2;
			y = 1;
		} else if (num1 == 1 && num2 != 0 && num2 != n - 1) {
			labirinto[num2][n - 1].setSaida(true);
			labirinto[num2][n - 1].setParede(false);
			x = n - 2;
			y = num2;
		} else if (num1 == 2 && num2 != 0 && num2 != n - 1) {
			labirinto[n - 1][num2].setSaida(true);
			labirinto[n - 1][num2].setParede(false);
			x = num2;
			y = n - 2;
		} else if (num1 == 3 && num2 != 0 && num2 != n - 1) {
			labirinto[num2][0].setSaida(true);
			labirinto[num2][0].setParede(false);
			x = 1;
			y = num2;
		}

		// colocar primeira casa a branco
		labirinto[y][x].setParede(false);
		
		while (verifica3x3Parede()) {
			num1 = r.nextInt(4);
			if (num1 == 0)
			{
				if (y - 1 > 0)
				{
					if (labirinto[y - 1][x].isParede()==true && verifica2x2Branco(y - 1, x) == false)
					{
						y--;
						labirinto[y][x].setParede(false);
					}
					else
					{
						if (labirinto[y - 1][x].isParede()==true)
						{
							y--;
						}
					}
				}
			}
			else if (num1 == 1)
			{
				if (x + 1 < labirinto.length - 1) {
					if (labirinto[y][x + 1].isParede()==true && verifica2x2Branco(y, x + 1) == false)
					{
						x++;
						labirinto[y][x].setParede(false);
					}
					else
					{
						if (labirinto[y][x + 1].isParede()==false)
						{
							x++;
						}
					}
				}
			}
			else if (num1 == 2)
			{
				if (y + 1 < labirinto.length - 1)
				{
					if (labirinto[y + 1][x].isParede()==true && verifica2x2Branco(y + 1, x) == false)
					{
						y++;
						labirinto[y][x].setParede(false);
					}
					else
					{
						if (labirinto[y + 1][x].isParede()==false)
						{
							y++;
						}
					}
				}
			}
			else if (num1 == 3)
			{
				if (x - 1 > 0)
				{
					if (labirinto[y][x - 1].isParede()==true && verifica2x2Branco(y, x - 1) == false) {
						x--;
						labirinto[y][x].setParede(false);
					}
					else
					{
						if (labirinto[y][x - 1].isParede()==false)
						{
							x--;
						}
					}
				}
			}
		}
	}

	public boolean verifica2x2Branco(int y, int x)
	{
		if (labirinto[y - 1][x - 1].isParede()==false && labirinto[y - 1][x].isParede()==false && labirinto[y][x - 1].isParede()==false)
		{
			return true;
		}
		if (labirinto[y - 1][x + 1].isParede()==false && labirinto[y - 1][x].isParede()==false && labirinto[y][x + 1].isParede()==false)
		{
			return true;
		}
		if (labirinto[y + 1][x + 1].isParede()==false && labirinto[y][x + 1].isParede()==false && labirinto[y + 1][x].isParede()==false)
		{
			return true;
		}
		if (labirinto[y + 1][x - 1].isParede()==false && labirinto[y + 1][x].isParede()==false && labirinto[y][x - 1].isParede()==false)
		{
			return true;
		}
		return false;
	}

	public boolean verifica3x3Parede()
	{
		for (int i = 1; i <= labirinto.length - 2; i++)
		{
			for (int j = 1; j <= labirinto.length - 2; j++)
			{
				if (labirinto[j][i].isParede()==true && labirinto[j - 1][i - 1].isParede()==true && labirinto[j - 1][i].isParede()==true && 
						labirinto[j - 1][i + 1].isParede()==true	&& labirinto[j][i - 1].isParede()==true && labirinto[j][i + 1].isParede()==true && 
						labirinto[j + 1][i + 1].isParede()==true	&& labirinto[j + 1][i].isParede()==true && labirinto[j + 1][i - 1].isParede()==true)
					return true;
			}
		}
		return false;
	}

	public boolean verificaDiagonal(int x, int y)
	{
		if (x < 1 || y < 1)
		{
			return false;
		}
		if (labirinto[y - 1][x - 1].isParede()==false && labirinto[y][x].isParede()==false && 
				labirinto[y][x - 1].isParede()==true && labirinto[y - 1][x].isParede()==true)
		{
			return true;
		}
		else if (labirinto[y - 1][x - 1].isParede()==true && labirinto[y][x].isParede()==true && 
				labirinto[y][x - 1].isParede()==false && labirinto[y - 1][x].isParede()==false)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public Celula[][] getLabirinto()
	{
		return labirinto;
	}
	
	public void setLabirinto(Celula[][] labirinto)
	{
		this.labirinto=labirinto;
	}
}