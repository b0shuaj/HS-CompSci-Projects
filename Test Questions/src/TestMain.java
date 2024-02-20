import java.util.ArrayList;
import java.util.Scanner;

public class TestMain
{
		public static void main(String[] args)
		{
			ArrayList<TestQuestion> questions = new ArrayList<TestQuestion>();
			
			Scanner in = new Scanner(System.in);
			String answer = "";
			//for mc
			String mcQues = "";
			int mcAns = 0;
			String[] mcChoices;
			String correctMC = "";
			char ch = 'A';
			char ans = 'A';
			String ansLetter = "";
			int temp = 0;
			//TF
			String tfQues = "";
			String tfAns = "";
			//again
			boolean again = true;
			String andrewTemp = "";
			
		
			while(again == true)
			{
					System.out.print("Would you like to input a Multiple Choice Question (MC) or " +
				"a True or False Question (TF): ");
						answer = in.nextLine();
						
					if(answer.equals("TF"))
					{
						System.out.print("Please input the question: ");
						tfQues = in.nextLine();
						System.out.print("Is this True or False? ");
						tfAns = in.nextLine();
						
						questions.add(new TrueFalse(tfQues, tfAns));
					}
						
					if(answer.equals("MC"))
					{
						System.out.print("Please input the question: ");
						mcQues = in.nextLine();
						System.out.print("How many answers will there be ?: ");
						mcAns = in.nextInt();
						in.nextLine();
						mcChoices = new String[mcAns];
						
						for(int i = 0; i < mcAns; i++)
						{
							System.out.print("What is your answer for " + ch + "? ");
							mcChoices[i] = in.nextLine();
							ch++;
						}
						System.out.print("Which answer is the correct one? (ex. A, B, C...): ");
						ansLetter = in.nextLine();
						ans = ansLetter.charAt(0);
						temp = Character.getNumericValue(ans);
						temp -=10;
						correctMC = mcChoices[temp];
						
						questions.add(new MCQuestion(mcQues, mcChoices, correctMC));
					}
					
					System.out.print("Would you like to add another Question? Y or N: ");
					andrewTemp = in.nextLine();
					if(andrewTemp.equals("Y"))
					{
						again = true;
					}
					else if(andrewTemp.equals("N"))
					{
						again = false;
					}
					
			}
			for(TestQuestion a: questions)
			{
				System.out.println(a.toString());
			}
				
				
				in.close();
		}

	}


