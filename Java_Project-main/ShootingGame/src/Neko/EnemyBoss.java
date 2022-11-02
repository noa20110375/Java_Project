package Neko;
import java.awt.Image;

import javax.swing.ImageIcon;

public class EnemyBoss{
	 Image image = new ImageIcon("src/images/enemy.png").getImage();
	    int x, y;
	    int width = image.getWidth(null);
	    int height = image.getHeight(null);
	    int hp = 10;

	    public EnemyBoss(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }

	    public void move() {
	         this.y -= 0;
	    }
}
