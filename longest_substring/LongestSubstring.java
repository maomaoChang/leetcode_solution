/**
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 * 示例：
 * 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
 * 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
 * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
 */

import java.util.HashSet;

public class LongestSubstring{
	public static void main(String[] args) {
		String str = "abcdefa";

		System.out.println(lengthOfLongestSubstring(str));
	}


    public static int lengthOfLongestSubstring(String s) {
		if(s.length() == 0){
			return 0;
		}        
		int L = s.length();
		HashSet<Character> set = new HashSet();
		int maxLen = 1;
		boolean flag = true;

		for(int i = L; i >= 1; i--){
			for(int j = 0; i+j <= L; j++){
				char[] array = s.substring(j,i+j).toCharArray();
				for(Character c : array){
					set.add(c);
				}
				
				if(set.size() == array.length){
					maxLen = array.length;
					flag = false;
					break;
				}
				set.clear();
			}
			if(!flag){
				break;
			}
		}

		return maxLen;        
    }
}