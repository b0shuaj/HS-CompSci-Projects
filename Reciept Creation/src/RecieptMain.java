import java.util.Scanner;

/**
 * 
 * @author Josh Babbitt
 * Project Receipt Creation
 * Still looks weird
 *
 */
public class RecieptMain 
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		
		System.out.print("Please enter the name of the appetizer: ");
		String app = in.nextLine();
		
		System.out.print("\nPlease enter the price of the appetizer: ");
		Double priceA = in.nextDouble();
		in.nextLine();
		
		System.out.print("\nPlease enter the name of the entree: ");
		String ent = in.nextLine();

		System.out.print("\nPlease enter the price of your entree: ");
		Double priceE = in.nextDouble();
		in.nextLine();
		
		System.out.print("\nPlease enter the name of the drink: ");
		String dri = in.nextLine();

		System.out.print("\nPlease enter the price of the drink: ");
		Double priceDr = in.nextDouble();
		in.nextLine();
		
		System.out.print("\nPlease enter the name of the dessert: ");
		String des = in.nextLine();
		
		System.out.print("\nPlease enter the price of the desert: ");
		Double priceDe = in.nextDouble();
		in.nextLine();
		
		Double total = ReceiptCalculator.calcSubtotal(priceA, priceE, priceDr, priceDe);
		Double tax = ReceiptCalculator.calcTax(priceA, priceE, priceDr, priceDe);
		String sub = "Subtotal";
		String taxs = "Tax";
		String tot = "Total";
		
		System.out.print("\n");
		System.out.printf("%-10s%20.2f", app, priceA);
		System.out.print("\n");
		System.out.printf("%-10s%20.2f", ent, priceE);
		System.out.print("\n");
		System.out.printf("%-10s%20.2f", dri, priceDr);
		System.out.print("\n");
		System.out.printf("%-10s%20.2f", des, priceDe);
		System.out.print("\n");
		
		System.out.printf("%-10s%20.2f", sub, total);
		System.out.print("\n");
		System.out.printf("%-10s%20.2f", taxs, tax);
		System.out.print("\n");
		System.out.println("******************************");
		System.out.printf("%-10s%20.2f", tot, (total + tax));

		in.close();
	}

}
