import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterRecognation {

	public static void main(String[] args) {
		Pattern pattern;
		Matcher matcher;
		boolean boo = false;
		String regex = "[ФЦУЖЭНГШҮЗКЪЕЩЙЫБӨАХРОЛДПЯЧЁСМИТЬВЮфцужэнгшүзкъещйыбөахролдпячёсмитьвю]{2}(\\d){2}[0-1]{1}[1-9]{1}[0-3]{1}[1-9]{1}(\\d){2}";
		Scanner reader = new Scanner(System.in);
		String input = reader.next();
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(input);
		System.out.println(regex); // ne96021915
		boo = matcher.matches();
		if(boo == true) {
			if(input.charAt(6) == 3 && input.charAt(7) > 1) {
				boo = false;
			}
			else if(input.charAt(5) == 2 && input.charAt(6) == 3) {
				boo = false;
			}
			else if(input.charAt(4) == 0 && input.charAt(5) > 2) {
				boo = false;
			}
		}
		System.out.println(boo);
	}
}
