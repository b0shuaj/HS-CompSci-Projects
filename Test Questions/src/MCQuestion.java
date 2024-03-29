
public class MCQuestion extends TestQuestion
{
	
	String[] choices;
	
	/*
	 * Write a constructor for MCQuestion which takes
	 * a string for the text, an array of Strings for answer choices
	 * and a string for the correct answer
	 */
	public MCQuestion(String text, String[] choices, String answer)
	{
		super(text, answer);
		this.choices = choices;
	}
	
	
	/*
	 * Override the toString method to display the question in the
	 * form:
	 * 
	 * 2.   This is the text for question number 2. What's your answer?
	 * 		A. answer choice one
	 * 		B. answer choice two
	 * 		C. answer choice three
	 * 		D. answer choice four
	 * 
	 * Keep in mind there are no restrictions on the number of answer
	 * choices.  Your method should work no matter the answer array.
	 * As a reminder, you may increment a char using ++ as it is primitive.
	 */
	
	public String toString()
	{
		String ques = number() + ". " + text() + "\n\t";
		char ch = 'A';
	
		for(int i = 0; i < choices.length; i++)
		{
			ques += ch + ". " + choices[i] + "\n\t";
			ch++;
		}
		return ques;
	}

}
