/**
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 * 示例：
 * 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
 * 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
 * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
 * 官方解答：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/
 */
import java.util.Set;
import java.util.HashSet;

public class LongestSubstring{
	public static void main(String[] args) {
		String str = "abadefa";

		System.out.println(lengthOfLongestSubstring2(str));
	}


	//这种方式不行,时间复杂度为O(N^3),提交通过不了
    public static int lengthOfLongestSubstring1(String s) {
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


    //优化方案,对于[i,j)的滑动窗口,可以检测S[j+1]是否在滑动窗口中
    public static int lengthOfLongestSubstring2(String s){
    	int n = s.length();
    	Set<Character> set = new HashSet<>();
    	int ans = 0; //最大长度初始化
    	int i = 0; 
    	int j = 0;

    	while(i < n && j < n){
    		if(!set.contains(s.charAt(j))){
    			set.add(s.charAt(j++));
    			ans = Math.max(ans,j-i);
    		}
    		else{
    			set.remove(s.charAt(i++)); //移除第i个元素,进行下次循环
    		}
    	}

    	return ans;
    }
}