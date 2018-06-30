/*
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true

Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

Follow up:
Coud you solve it without converting the integer to a string?

解决思路：
1.数字转字符串--->逆序--->转数字--->与原数据比较
2.拿到字符串以后,针对第i位的字符,比较其与str.length-1-i位置的字符串是否相等
3.官方解答：Revert half of the number(待实现)
 */

public class PalindromeNumber{
	public static void main(String[] args) {
		int testInt = 211111;

		System.out.println(testInt + "是回文数吗？ ：" + (isPalindrome2(testInt)?"是":"否"));
	}

	//思路1
	public static boolean isPalindrome1 (int x){
		return true;
	}

	//思路2
	public static boolean isPalindrome2 (int x){
		String str = x + ""; //此处使用toString()会有风险吗？

		int len = str.length();

		boolean isPalindrome = true;

		for(int i = 0; i <= (len-1)/2+1; i++){
			if(str.charAt(i) != str.charAt(len-1-i)){
				isPalindrome = false;
				break;
			}
		}
		return isPalindrome;
	}	
}