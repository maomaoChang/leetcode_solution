/*
解决方案：
1. 枚举
2.
 */

public class IntegerToRoman{
	//main method
	public static void main(String[] args) {
		int number = 1994;
		System.out.println(number + "转换为Roman数字表示为: " + intToRoman(number));
	}

	//方案1：枚举法
	public static String intToRoman(int num) {

	    String M[] = {"", "M", "MM", "MMM"};
	    String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
	    String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
	    String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
	    
	    return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];		
	}
}