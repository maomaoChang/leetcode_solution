public class ZigZagConversion{
	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		System.out.println("字符串长度为:" + s.length() );
		int numRows = 4;

		System.out.println(convert(s,numRows));
	}

	//解法1：遍历存放在数组中
	public static String convert(String str, int numRows){
		int numCol = str.length()+1;
		System.out.println("数组列长度为:" + numCol );
		char[][] arr = new char[numRows][];
		char[] arrTemp = str.toCharArray();
		System.out.println("一维数组首字符：" + arrTemp[0]);

		//在对应的zigzag位置上填补二维数组
		for(int j=0,k=0; k < arrTemp.length; ){
			//全排列
			if(j%(numRows-1)==0){
				for(int m = 0; m < numRows-1; m++){
					arr[m][j] = arrTemp[k++];
				}
				j++;
				continue;
			}
			//单元素排列
			else{
				arr[(numRows-1)-j%(numRows-1)][j] = arrTemp[k++];
				j++;
				continue;
			}
		}

		//数组拼接
		String s="";
		for(int i=0; i < numRows; i++){
			for(int j=0; j < numCol; j++){
				s += arr[i][j];
			}
		}

		return s;

	}
	
}