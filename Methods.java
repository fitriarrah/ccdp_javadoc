import java.util.Scanner;
public class Methods
{
	public static int checkForError(int value,int start,int end,String message)
	{
		Scanner scan=new Scanner(System.in);
		while(value<start || value >end)
		{
			System.out.println("WRONG INPUT!");
			System.out.print(message);
			value=scan.nextInt();
		}
		return value;
	}

	public static int checkForError(int value,int start,String message)
	{
		Scanner scan=new Scanner(System.in);
		while(value<start)
		{
			System.out.println("WRONG INPUT!");
			System.out.print(message);
			value=scan.nextInt();
		}
		return value;
	}

	public static int getQuestionType()
	{
		int questionType;
		Scanner scan=new Scanner(System.in);
		System.out.printf("1) +\n2) -\n3) *\n4) /\n5) random\n");
		System.out.println("Note that if it's a division question then your answer should be the quotient and the remainder separated by a space\nEX: 7 / 3 = 2 1");
		System.out.print("Enter the number of your desired type of questions :");
		questionType=scan.nextInt();
		questionType=Methods.checkForError(questionType,1,5,"Enter the number of your desired type of questions :");
		return questionType;
	}

	public static void delay()
	{
		Scanner scan=new Scanner(System.in);
		System.out.print("Press Enter to begin:");
		String buff=scan.nextLine();
	}

	public static void displayAnswers(int noOfQuestions,String playerTotalResult)
	{
		System.out.println("Your Answers was:");
		int index=0,saver;
		for(int k=1;k<=noOfQuestions;k++)
			{
				if(k==1)
					saver=index;
				else
					saver=index+1;
				index=playerTotalResult.indexOf("$",index+1);
				System.out.println(playerTotalResult.substring(saver,index));
			}
		System.out.println("\n\n");
	}

	public static void printArray(int[] totalscore,String[] names,int noOfPlayers)
	{
	System.out.println("Rank\tName\t\tScore\ttime");
	for(int i=0,j=1;i<2*noOfPlayers;i+=2,j++)
	{
		System.out.println(j+"\t"+names[i/2]+"\t\t"+totalscore[i]+"\t"+totalscore[i+1]);
	}	
	}

	public static void rankArray(int[] totalscore,String[] names,int noOfPlayers)
	{
	int temp1;
	String temp="";
	//sorting array before printing
	for(int i=0;i<=2*noOfPlayers-4;i+=2)
	{
		for(int j=i+2;j<=2*noOfPlayers-2;j+=2)
		{
			if( (totalscore[j]>totalscore[i]) || (totalscore[j]==totalscore[i] && totalscore[j+1]<=totalscore[i+1]) )
			{
			//swap
			temp1=totalscore[i];
			totalscore[i]=totalscore[j];
			totalscore[j]=temp1;
			
			temp1=totalscore[i+1];
			totalscore[i+1]=totalscore[j+1];
			totalscore[j+1]=temp1;
			
			temp=names[i/2];
			names[i/2]=names[j/2];
			names[j/2]=temp;
			}
		}
	}
	printArray(totalscore,names,noOfPlayers);
	}

	public static void rank(int score1,int time1,String name1)
	{
		System.out.println("1\t"+name1+"\t\t"+score1+"\t"+time1);
	}

}





























