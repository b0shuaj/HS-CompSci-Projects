import javax.swing.JButton;

public class thing extends JButton
{
	private int dx;
	private int dy;
	
	public thing()
	{
		setBounds(300,300,150,50);
		setText(":)");
		dx = 0;
		dy = 0;
		this.setFocusable(false);
	}
	public void setDx(int x)
	{
		dx = x;
	}
	public void setDy(int y)
	{
		dy = y;
	}
	
	public void update()
	{
		setLocation(getX() + dx, getY() + dy);
	}
}

