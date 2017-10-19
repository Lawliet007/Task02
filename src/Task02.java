import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author Davka
 *
 */
public class Task02 {
	static String regex1 = "(\\d){1,100}(/)(\\d){1,100}";
	static String regex2 = "[/+*]";
	static String regex3 = regex2 + regex1;
	static String regex4 = regex2 + "(\\d){1,100}";
	static String regex5 = regex1;
	static Matcher matcher;
	static Pattern pattern;
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		String input;
		String[] operators;
		String[] numbers;
		Rational result;
		input = reader.next();
		operators = input.split(regex1);
		numbers = input.split(regex2);

		tokens(input);
		boolean bools = check(input,operators);

		if(bools == false) {
			for(int i = 0; i <operators.length - 1; i++) {
				regex5 = regex5 + regex4;
			}
			pattern = Pattern.compile(regex5);
			matcher = pattern.matcher(input);
			if(matcher.matches()==true) {
				System.out.println(0);
			}
			else {
				System.out.println(-1);
			}
		}

		else {
			int[] number = new int[numbers.length];
			for(int i = 0; i < numbers.length; i++) {
				number[i] = Integer.valueOf(numbers[i]);
			}
			ArrayList<Rational> rational = new ArrayList<Rational>(number.length/2);
			int j = 0;

			for(int i = 0; i < number.length; i+=2) {
				rational.add(new Rational(number[i],number[i+1]));
				j++;
			}

			for(int i = 0; i < rational.size(); i++) {
				System.out.println("Rational number: " + rational.get(i));
			}

			ArrayList<String> operator = new ArrayList<String>();
			for(int i = 0; i < operators.length; i++) {
				operator.add(operators[i]);
			}
			System.out.println("final result is: " + calcute(rational,operator));
		}
	}

	public static boolean check(String input, String[] operators) {
		for(int i = 0; i <operators.length - 1; i++) {
			regex1 = regex1 + regex3;
		}
		pattern = Pattern.compile(regex1);
		matcher = pattern.matcher(input);
		return matcher.matches();
	}

	public static Rational calcute(ArrayList<Rational> rational, ArrayList<String> operator) {
		while(operator.contains("*") || operator.contains("/")) {
			for(int i = 1; i < operator.size(); i++) {
				if(operator.get(i).equals("*")) {
					rational.set(i-1, rational.get(i-1).multiply(rational.get(i)));
					rational.remove(i);
					operator.remove(i);
				}
				else if(operator.get(i).equals("/")) {
					rational.set(i-1, rational.get(i-1).divide(rational.get(i)));
					rational.remove(i);
					operator.remove(i);
				}
			}
		}

		while(operator.contains("+")) {
			for(int i = 0; i < operator.size(); i++) {
				if(operator.get(i).equals("+")) {
					rational.set(i-1, rational.get(i-1).add(rational.get(i)));
					rational.remove(i);
					operator.remove(i);
				}
			}
		}
		return rational.get(0);
	}

	public static void tokens(String input) {
		String tokens = input;
		tokens = tokens.replaceAll(regex1, "NUM ");
		tokens = tokens.replaceAll("[+]", "OPP_ADD ");
		tokens = tokens.replaceAll("[*]", "OPP_MUL ");
		tokens = tokens.replaceAll("[/]", "OPP_DIV ");
		tokens = tokens.replaceAll("[^((NUM)||(OPP_ADD)||( )||(OPP_MUL)||(OPP_DIV))]" , "UNKNOWN ");
		System.out.println("Tokens: " + tokens);
	}
}
