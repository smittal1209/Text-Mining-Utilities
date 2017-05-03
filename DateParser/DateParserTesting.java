package DateParser;

import java.io.IOException;
import java.util.Date;

public class DateParserTesting 
{
	public static void main(String[] args) throws IOException 
	{
		DateParser dateParser = new DateParser();
		String inputDate = "05 May 2017";
		Date outputDate = dateParser.parseADate(inputDate);
		if(outputDate!=null)
		{
			System.out.println("Date Parsed Successfully.");
			System.out.println("Date Converted to String : "+outputDate.toString());
		}
		else
		{
			System.out.println("Date can not be Parsed.\nPlease check UnparsedDates.txt File for all Unparsed Dates");
		}
	}
}
