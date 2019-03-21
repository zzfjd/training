package com.lianxi;

public class Sort {
	/*
	 * 冒泡排序基本概念是： 依次比较相邻的两个数，将小数放在前面，大数放在后面。 即在第一趟：首先比较第1个和第2个数，将小数放前，大数放后。
	 * 然后比较第2个数和第3个数，将小数放前，大数放后，如此继续， 直至比较最后两个数，将小数放前，大数放后。至此第一趟结束，
	 * 将最大的数放到了最后。在第二趟：仍从第一对数开始比较 （因为可能由于第2个数和第3个数的交换，使得第1个数不再小于第2个数），
	 * 将小数放前，大数放后，一直比较到倒数第二个数（倒数第一的位置上已经是最大的）， 第二趟结束，在倒数第二的位置上得到一个新的最大数
	 * （其实在整个数列中是第二大的数）。如此下去，重复以上过程，直至最终完成排序。
	 */

	public static void BubbleSort(int[] data) {
		for (int i = 0; i < data.length - 1; i++) {
			for (int j = 0; j < data.length - 1 - i; j++) {
				if (data[j] > data[j + 1]) {
					swap(data, j, j + 1);
				}
			}
		}
	}

	/*
	 * 插入排序基本思想 将n个元素的数列分为已有序和无序两个部分，如插入排序过程示例下所示： 　　 {{a1}，{a2，a3，a4，…，an}} 　　
	 * {{a1⑴，a2⑴}，{a3⑴，a4⑴ …，an⑴}} 　 {{a1(n-1），a2(n-1) ，…},{an(n-1)}} 　　
	 * 每次处理就是将无序数列的第一个元素与有序数列的元素从后往前逐个进行比较， 找出插入位置，将该元素插入到有序数列的合适位置中。
	 */

	public static void InsertSort(int[] data) {
		for (int i = 1; i < data.length; i++) {
			for (int j = i; (j > 0) && (data[j] < data[j - 1]); j--) {
				swap(data, j, j - 1);
			}
		}

	}

	/*
	 * 交换数组中的两个元素
	 */
	public static void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

}
