/**
 * 
 * @author Josh Babbitt
 * Project Receipt Creation
 * Why does receipt look so weird?
 *
 */
public class ReceiptCalculator
{
	public static double calcSubtotal(double a, double b, double c, double d)
	{
		return a+b+c+d;
	}
	public static double calcTax(double a, double b, double c, double d)
	{
		double tax = 0.06;
		return (a+b+c+d) * tax;
	}
}
