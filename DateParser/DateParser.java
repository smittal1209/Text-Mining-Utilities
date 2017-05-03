package DateParser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DateParser 
{
//	Enter the Location of the Files where DateFormats.txt and UnparsedDates.txt files are kept
	String FilesLocation = "";
	public Date parseADate(String date) throws IOException
	{
		String input = date;
		Date result = null;
		SimpleDateFormat formatter = null;
		
//		Position of the patterns in array is important
		BufferedReader br = new BufferedReader(new FileReader(new File(FilesLocation+"DateFormats.txt")));
		PrintWriter pw = new PrintWriter(new FileOutputStream(new File(FilesLocation+"UnparsedDates.txt"),true));
		ArrayList<String> dateList = new ArrayList<String>();
		String line = br.readLine();
		while(line!=null)
		{
			String dataFormat = line.trim();
			dateList.add(dataFormat.trim());
			line = br.readLine();
		}
		String datePatterns[] = new String[dateList.size()];
		for(int k=0;k<datePatterns.length;k++)
		{
			datePatterns[k]=dateList.get(k).trim();
		}
		int i=0;
		date = date.replaceAll("[^\\x00-\\x7F\\s]", "");
		while(i<datePatterns.length)
		{
			try 
			{
				formatter = new SimpleDateFormat(datePatterns[i].trim());
				formatter.setLenient(false);
				result = formatter.parse(date);
				break;
			}
			catch (ParseException e) 
			{
				i++;
				if(i==datePatterns.length)
				{
					break;
				}
			}
		}
		if(result==null)
		{
			pw.println(input);
			pw.close();
			br.close();
			return null;
		}
		pw.close();
		br.close();
		return result;
	}
}
