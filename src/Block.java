import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Block {
	int strength;
	int var;
	int x;
	int y;
	int width;
	int height;
	boolean active;
	
	Rectangle hitBox;
	
	
	Block(int x, int y, int width, int height, int v){
		this.var = v;
		this.active = true;
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		
		hitBox= new Rectangle(x, y, width, height);
		
		switch(v) {
		case 1:
			strength =10;
			break;
		case 2:
			strength =20;
			break;
		case 3:
			strength =30;
			break;
		}
		
	}
	
	public void draw(Graphics2D gtd) {
//		gtd.setColor(Color.BLACK);
		gtd.drawRect(x, y, width, height);
		switch(var) {
		case 1:
			gtd.setColor(Color.green);
			break;
		case 2: 
			gtd.setColor(Color.yellow);
			break;
		case 3:
			gtd.setColor(Color.RED);
			break;
		}
		
		if(!this.active) {
			gtd.drawRect(0, 0, 0, 0);
			gtd.setColor(Color.WHITE);
		}
		
//		gtd.setColor(Color.RED);
		gtd.fillRect(x+1, y+1, width-2, height-2);
	}

	
	public void destroy() {
		if (!this.active) {
			hitBox= new Rectangle(0, 0, 0, 0);

			
		}
	}
	
	

}
