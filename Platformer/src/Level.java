import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JComponent;

public class Level
{
	private ArrayList<GroundPiece> aLevel;
	
	public Level() 
	{
		aLevel = new ArrayList<GroundPiece>();
	}
	
	public void addPlatform(GroundPiece p)
	{
		aLevel.add(p);
	}
	
	public ArrayList<GroundPiece> getArray()
	{
		return aLevel;
	}
	
	public GroundPiece getPlatform(int index)
	{
		return aLevel.get(index);
	}
}
