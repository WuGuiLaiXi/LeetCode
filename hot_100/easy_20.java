public class easy_20 {
/*
 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
 
示例 1：
输入：s = "()"
输出：true

示例 2：
输入：s = "()[]{}"
输出：true

示例 3：
输入：s = "(]"
输出：false

示例 4：
输入：s = "([)]"
输出：false

示例 5：
输入：s = "{[]}"
输出：true
 
提示：
1 <= s.length <= 104
s 仅由括号 '()[]{}' 组成
* */
	
	 public boolean isValid(String s) {
		 Stack<Character> st = new Stack<Character>();
		 for (char ch : s.toCharArray())
		 {
			 if(ch == ')' && !st.empty()) {
				 if(st.peek() == '(') {
					 st.pop();
					 continue;
				 }
				 else
					 return false;
			 }
			 else if(ch == ']' && !st.empty()) {
				 if(st.peek() == '[') {
					 st.pop();
					 continue;
				 }
				 else
					 return false;
			 }
			 else if(ch == '}' && !st.empty()) {
				 if(st.peek() == '{') {
					 st.pop();
					 continue;
				 }
				 else
					 return false;
			 }
			 else {
				 st.push(ch);
			 }
		 }
		 return st.empty() ? true : false;	 
	 }
}
