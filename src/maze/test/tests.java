package maze.test;

import static org.junit.Assert.assertEquals;
import maze.logic.Dragao;
import maze.logic.Jogo;
import maze.logic.Heroi;
import maze.logic.Espada;
import maze.logic.Pecas;

import org.junit.Test;


public class tests
{
	
	public static Jogo j = new Jogo(10);

	
	@Test public void HeroiPertoDragao() {
		Dragao d = new Dragao(2,1);
		Heroi h = new Heroi(1,1);
		assertEquals(true,(h.getX() == d.getX() && h.getY() == d.getY()-1) || 
						(h.getX() == d.getX()-1 && h.getY() == d.getY()-1) || 
						(h.getX() == d.getX()+1 && h.getY() == d.getY()-1) || 
						(h.getX() == d.getX()-1 && h.getY() == d.getY())||
						(h.getX() == d.getX()+1 && h.getY() == d.getY()) || 
						(h.getX() == d.getX() && h.getY() == d.getY()+1) || 
						(h.getX() == d.getX()-1 && h.getY() == d.getY()+1) || 
						(h.getX() == d.getX()+1 && h.getY() == d.getY()+1));
	}


	@Test public void HeroiLongeDoDragao()
	{
		Dragao d = new Dragao(3,1);
		Heroi h = new Heroi(1,1);
		assertEquals(false,(h.getX() == d.getX() && h.getY() == d.getY()-1) || 
						(h.getX() == d.getX()-1 && h.getY() == d.getY()-1) || 
						(h.getX() == d.getX()+1 && h.getY() == d.getY()-1) || 
						(h.getX() == d.getX()-1 && h.getY() == d.getY())||
						(h.getX() == d.getX()+1 && h.getY() == d.getY()) || 
						(h.getX() == d.getX() && h.getY() == d.getY()+1) || 
						(h.getX() == d.getX()-1 && h.getY() == d.getY()+1) || 
						(h.getX() == d.getX()+1 && h.getY() == d.getY()+1));
	}

	@Test public void HeroiComEspadaMataDragao() {
		
		Heroi h = new Heroi(1,1);
		Dragao d = new Dragao(2,1);
		Espada e=new Espada(1,1);
		h.setArmado(true);
		j.moveHeroi(3);
		
		
		assertEquals(true,d.isMorto());
	}
	
	@Test public void HeroiNaoPassaParedeEsquerda()
	{
		boolean control = false;
		
		Heroi h = new Heroi(1,1);
		Dragao d = new Dragao(5,1);
		Espada e=new Espada(9,9);
		
		j.moveHeroi(2);
		
		if(h.getX()==1)
		{
			control = true;
		}
		assertEquals(true,control);
	}
	
	@Test public void HeroiNaoPassaParedeDeCima()
	{
		boolean control = false;
		
		Heroi h = new Heroi(1,1);
		Dragao d = new Dragao(5,1);
		Espada e=new Espada(9,9);
		
		j.moveHeroi(0);
		
		
		if(h.getY() == 1){
			control = true;
		}
		assertEquals(true,control);
	}
	
	@Test public void HeroiNaoPassaParedeDireita()
	{
		boolean control = false;
		
		Heroi h = new Heroi(8,1);
		Dragao d = new Dragao(5,1);
		Espada e=new Espada(9,9);
		
		j.moveHeroi(3);
		
		if(h.getX()==8){
			control = true;
		}
		assertEquals(true,control);
		
		
	}
	
	@Test public void HeroiNaoPassaParedeDeBaixo() {
		boolean control = false;
		
		Heroi h = new Heroi(1,8);
		Dragao d = new Dragao(5,1);
		Espada e=new Espada(9,9);
		
		j.moveHeroi(1);
		
		if(h.getY()==8){
			control = true;
		}
		assertEquals(true,control);
	}
	
	@Test public void HeroiNaoSaiSemEspada() {
		boolean aqui = false;
		Heroi h = new Heroi(8,5);
		Dragao d = new Dragao(5,1);
		Espada e=new Espada(9,9);
		h.setArmado(false);

		j.moveHeroi(3);
	
		if(h.getX()==8){
			aqui = true;
		}
		assertEquals(true,aqui);
	}
}