import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main{
	public static void main(String[] args) {
		String str1 = "나는 소년입니다";
		String str2 = "I am a boy ㅎ";

		Pattern p1 = Pattern.compile("[ㄱ-ㅎ|ㅏ-ㅣ|가-힣][a-z]");
		Matcher m1 = p1.matcher(str2);

		Pattern p2 = Pattern.compile("[ㄱ-ㅎㅏ-ㅣ가-힣]|[a-z]");
		Matcher m2 = p2.matcher(str2);

		while (m1.find()){
			System.out.println(m1.group());
		}
		System.out.println("-------------------");
		while (m2.find()){
			System.out.println(m2.group());
		}

	}


}