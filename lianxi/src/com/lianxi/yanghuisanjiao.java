package com.lianxi;

/*

 需求：打印杨辉三角形(行数可以键盘录入)

 1
 1 1	
 1 2 1
 1 3 3 1
 1 4 6 4 1 
 1 5 10 10 5 1

 分析：看这种图像的规律
 A:任何一行的第一列和最后一列都是1
 B:从第三行开始，每一个数据是它上一行的前一列和它上一行的本列之和。

 步骤：
 A:首先定义一个二维数组。行数如果是n，我们把列数也先定义为n。
 这个n的数据来自于键盘录入。
 B:给这个二维数组任何一行的第一列和最后一列赋值为1
 C:按照规律给其他元素赋值
 从第三行开始，每一个数据是它上一行的前一列和它上一行的本列之和。
 D:遍历这个二维数组。
 */
public class yanghuisanjiao {
	public static void main(String[] args) {
		int n = 10;
		int[][] str = new int[n][n];
		// 将每一行的第一个和最后一个赋值为1
		for (int x = 0; x < str.length; x++) {
			str[x][0] = 1;
			str[x][x] = 1;

		}
		for (int x = 2; x < str.length; x++) {
			for (int y = 1; y < x; y++) {
				str[x][y]=str[x-1][y-1]+str[x-1][y];
			}
		}

		for (int i = 0; i < str.length; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(str[i][j] + "\t");
			}
			System.out.println("");
		}
	}
}
