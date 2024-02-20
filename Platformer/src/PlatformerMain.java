import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class PlatformerMain extends JFrame implements ActionListener
{
	private Character hero;
	private Key k;
	private int frictionCounter, currentLvl;
	private boolean jumping, movingLeft, movingRight;
	private ArrayList<Level> game;
	private BufferedImage animeB, marioB, sunsetB, howlB, beachB;
	private Door door;
	private Timer t;
	JLabel kC;
	JLabel background;


	
	public PlatformerMain()
	{
		setLayout(null);
		this.setBounds(0,0,Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height
			- Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration()).bottom
			- Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration()).top);
	
		
//		 Music music = new Music("/gff.wav");
//	        music.play();
       
       Music key = new Music("/getkey");
       key.play();
       
//  try{
// 			sunsetB = ImageIO.read(PlatformerMain.class.getResource("/images/sunset.png"));
// 		}
// 		catch(IOException e)
// 		{
// 			e.printStackTrace();
// 		}
// 	try{
// 		animeB = ImageIO.read(PlatformerMain.class.getResource("/images/anime.jpg"));
// 	}
// 	catch(IOException e)
// 	{
// 		e.printStackTrace();
// 	}
// 	try{
// 		howlB = ImageIO.read(PlatformerMain.class.getResource("/images/howl.png"));
// 	}
// 	catch(IOException e)
// 	{
// 		e.printStackTrace();
// 	}
	try{
		beachB = ImageIO.read(PlatformerMain.class.getResource("/images/beach.jpg"));
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
// 	try{
// 		marioB = ImageIO.read(PlatformerMain.class.getResource("/images/mario"));
// 	}
// 	catch(IOException e)
// 	{
// 		e.printStackTrace();
// 	}
		
//		background = new JLabel();
//		changeBackground(beachB);
//		setContentPane(background);
		
	
		hero = new Character(0,0);
		hero.setLocation(0,0);
		add(hero);
		
		k= new Key(100,600);
		add(k);
		
		kC = new JLabel("Key Collected!");
		kC.setBounds(500,250,100,100);
		
		currentLvl = 0;
		
		t = new Timer(25, this);
		t.start();
		
		door = new Door();
		add(door);
		
		game = new ArrayList<Level>();
		buildLevel();
		
		
		jumping = false;
		movingLeft = false;
		movingRight = false;
		
		
		
		this.addKeyListener(new KeyListener()
				{

					
					public void keyTyped(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}

					public void keyPressed(KeyEvent e) 
					{
					
						if (!(hero.getDy() < 0) && e.getKeyCode() == e.VK_W)
						{
							jumping = true;
						}
						else if (e.getKeyCode() == e.VK_A)
						{
							movingLeft = true;
							movingRight  = false;
							
						}
						else if (e.getKeyCode() == e.VK_D)
						{
							movingRight = true;
							movingLeft = false;
							
						}
						
						if(e.getKeyCode() == e.VK_ESCAPE)
						{
							System.exit(0);
						}
					}

					
					public void keyReleased(KeyEvent e) 
					{
						if (e.getKeyCode() == e.VK_A)
							movingLeft = false;

						else if (e.getKeyCode() == e.VK_D)
							movingRight = false;
					}
			
				});
		
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) 
	{
		new PlatformerMain();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		k.bobbing();
		
		//REMOVE THIS, ONLY FOR LVL BUILDING
		
		
		platformPhysics(10,1,10);
		if (hero.getY() > getHeight()-20)
		{
			k.uncollect();
			hero.setLocation(0,0);
			hero.setDy(0);
			hero.setDx(0);
			jumping = false;
		}
		else if (touchingThis(door) && k.isCollected())
		{
			hero.setLocation(0,0);
			currentLvl++;
			buildLevel();
		}
		if(touchingThis(k))
		{
			k.collect();
		}
		
		
	}
	public void changeBackground(BufferedImage b)
	{
		background.setIcon(new ImageIcon(b));
		background.setBounds(0,0,1920,1080);
		setContentPane(background);
		background.repaint();
		//code no worky work :(
		//code might worky work later?? who knowsy knows
	}
	public void platformPhysics(int jumpHeight, int gravity, int movementSpeed)
	{
		hero.updateY();
		
		if (touchingGround())
		{
			for (int i = 0; i< Math.abs(hero.getDy()); i++) 
			{
				if (touchingGround())
					hero.changeY(-1 * (Math.abs(hero.getDy())) /hero.getDy());
			}
			
			if (jumping)
			{
				jumping = false;
				hero.setDy(-jumpHeight);
				
			}
			else
				hero.setDy(0);
		}
		else
			hero.setDy(hero.getDy() + gravity);
		
		if (movingLeft)
		{
			hero.setDx(-movementSpeed);
			frictionCounter = 0;
		}
		else if (movingRight)
		{
			hero.setDx(movementSpeed);
			frictionCounter = 0;
		}
		
		if (!(hero.getDx() == 0))
		{
			if (frictionCounter > -1)
			{
				frictionCounter = 0;
				if (hero.getDx() > 0)
					hero.setDx((int)(hero.getDx() -1));
				else
					hero.setDx((int)(hero.getDx() +1));
			}
			else
				frictionCounter++;
			
		}
		
		hero.updateX();
		
		if (touchingGround())
		{
			int oldY = hero.getY();
			for (int i = 0; i < (Math.abs(hero.getDx())) +1; i++)
			{
				if (touchingGround())
					hero.changeY(1);
			}
			
			if (touchingGround())
			{
				hero.setLocation(hero.getX(), oldY);
				for (int j = 0; j< Math.ceil(Math.abs(hero.getDx())); j++)
				{
					if (touchingGround())
						hero.changeX(-1 * (Math.abs(hero.getDx())) /hero.getDx());
				}
			}
		}
	}
	
	
	private boolean touchingGround()
	{
		for (GroundPiece p : game.get(currentLvl).getArray())
		{
			if  (hero.getY() + hero.getHeight() > p.getY() && hero.getY() < p.getY() + p.getHeight() &&
					!(hero.getX() + hero.getWidth() < p.getX() || hero.getX() > p.getX() + p.getWidth()))
				return true;
		}
		return false;
			
	}
	
	private boolean touchingThis(JComponent e)
	{
		if  (hero.getY() + hero.getHeight() > e.getY() && hero.getY() < e.getY() + e.getHeight() &&
				!(hero.getX() + hero.getWidth() < e.getX() || hero.getX() > e.getX() + e.getWidth()))
			return true;
		return false;
	}
	
	
	
	private void buildLevel()
	{
		game.add(new Level());
		k.uncollect();
		Level thisLevel = game.get(currentLvl);
		switch (currentLvl)
		{
		case 0:
			
			thisLevel.addPlatform(new GroundPiece(0,getHeight()-90,500,70));
			thisLevel.addPlatform(new GroundPiece(650,getHeight()-90,150,70));
			thisLevel.addPlatform(new GroundPiece(730,getHeight()-140,70,70));
			thisLevel.addPlatform(new GroundPiece(1000,getHeight()-90,500,70));
			k.setLocation(685,658);
			door.setLocation(this.getWidth()-door.getWidth()+1,getHeight()-89 - door.getHeight());
			break;
			
		case 1:
//			thisLevel.addPlatform(new GroundPiece(, , , 70));
			thisLevel.addPlatform(new GroundPiece(0,getHeight()-100, 2000, 70));
			thisLevel.addPlatform(new GroundPiece(800, 900, 300, 70));
			thisLevel.addPlatform(new GroundPiece(800, 300, 50 , 550)); //pillar left
			thisLevel.addPlatform(new GroundPiece(1050, 300, 50, 100)); //pillar right
			thisLevel.addPlatform(new GroundPiece(1050, 450, 50, 450));
			thisLevel.addPlatform(new GroundPiece(800, 300, 300, 30));
			
			thisLevel.addPlatform(new GroundPiece(850, 800, 50, 20)); //left plats
			thisLevel.addPlatform(new GroundPiece(850, 700, 50, 20));
			thisLevel.addPlatform(new GroundPiece(850, 600, 50, 20));
			
			thisLevel.addPlatform(new GroundPiece(925, 750, 50, 20)); //mid plats
			thisLevel.addPlatform(new GroundPiece(925, 500, 50, 20));
			
			thisLevel.addPlatform(new GroundPiece(1000, 850, 50, 20)); //right plats
			thisLevel.addPlatform(new GroundPiece(1000, 650, 50, 20));
			thisLevel.addPlatform(new GroundPiece(1000, 550, 50, 20));
			thisLevel.addPlatform(new GroundPiece(1000, 450, 50, 20));

			door.setLocation(100,600);
			break;
		case 2:
			thisLevel.addPlatform(new GroundPiece(0,200,500,300));
			thisLevel.addPlatform(new GroundPiece(0,550,500,100));
			thisLevel.addPlatform(new GroundPiece(0,500,420,50));
			thisLevel.addPlatform(new GroundPiece(0,650,500,50));
			thisLevel.addPlatform(new GroundPiece(0,750,500,100));
			thisLevel.addPlatform(new GroundPiece(0,700,420,50));
			k.setLocation(450,512);
			door.setLocation(430,707);
	
		}
		
		
		if (currentLvl != 0)
		{
			for (GroundPiece p : game.get(currentLvl-1).getArray())
				remove(p);
			repaint();
		}
		
		for (GroundPiece p : game.get(currentLvl).getArray())
			add(p);
		
	}

}
