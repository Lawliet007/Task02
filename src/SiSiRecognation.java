import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SiSiRecognation {

	public static void main(String[] args) {
		Pattern pattern;
		Matcher matcher;
		String regex = "(\\d){2}[BDMbdm][12]((seas)|(sas)|(SEAS)|(SAS)|(sob)|(SOB)|(law)|(LAW))(\\d){4}";
		Scanner reader = new Scanner(System.in);
		String input = reader.next();
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(input);
		System.out.println(matcher.matches());	
	}

}
