package myRegex;

import java.util.regex.*;

public class RegexTest {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		// 简单的匹配例子
		String content = "I am noob " + "from runoob.com.";
		String pattern = ".*runoob.*";

		boolean isMatch = Pattern.matches(pattern, content);
		System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);

		// 给定字符串找数字串
		// 按指定模式在字符串查找
		String line = "This order was placed for QT3000! OK?";
		pattern = "(\\D*)(\\d+)(.*)";
		// 创建 Pattern 对象
		Pattern r = Pattern.compile(pattern);
		// 现在创建 matcher 对象
		Matcher m = r.matcher(line);
		if (m.find()) {
			System.out.println("Found value: " + m.group(0));
			System.out.println("Found value: " + m.group(1));
			System.out.println("Found value: " + m.group(2));
			System.out.println("Found value: " + m.group(3));
		} else {
			System.out.println("NO MATCH");
		}

		// CAT 出现次数 atart和end
		final String REGEX = "\\bcat\\b";
		final String INPUT = "cat cat cat cattie cat";
		Pattern p = Pattern.compile(REGEX);
		m = p.matcher(INPUT); // 获取 matcher 对象
		int count = 0;

		while (m.find()) {
			count++;
			System.out.println("Match number " + count);
			System.out.println("start(): " + m.start());
			System.out.println("end(): " + m.end()); // 完成后自动加1

		}

		// looking at 和matches
		final String REGEX2 = "foo";
		final String INPUT2 = "fooooooooooooooooo";
		Pattern pattern2;
		Matcher matcher2;
		pattern2 = Pattern.compile(REGEX2);
		matcher2 = pattern2.matcher(INPUT2);

		System.out.println("Current REGEX is: " + REGEX2);
		System.out.println("Current INPUT is: " + INPUT2);

		System.out.println("lookingAt(): " + matcher2.lookingAt()); // 不要求整个匹配
		System.out.println("matches(): " + matcher2.matches()); // 要求整个匹配

		// 代替 全部replaceAll replaceFirst
		String REGEX3 = "dog";
		String INPUT3 = "The dog says meow. " + "All dogs say meow.";
		String REPLACE = "cat";

		Pattern p3 = Pattern.compile(REGEX3);
		// get a matcher object
		Matcher m3 = p3.matcher(INPUT3);
		INPUT3 = m3.replaceAll(REPLACE);
		System.out.println(INPUT3);

		// appendReplacement和appendTail代替
		String REGEX4 = "a*b";
		String INPUT4 = "aabfooaabfooabfoob";
		String REPLACE4 = "-";

		Pattern p4 = Pattern.compile(REGEX4);
		// 获取 matcher 对象
		Matcher m4 = p4.matcher(INPUT4);
		StringBuffer sb4 = new StringBuffer();

		while (m4.find()) {
			m4.appendReplacement(sb4, REPLACE4);
		}
		m4.appendTail(sb4);
		System.out.println(sb4.toString());

	}

}
