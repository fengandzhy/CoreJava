package com.citi.hz41382.datastructure.array.md03;
/**
* <p>className: BubbleSort</p>
* <p>Description: 冒泡法排序</p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2018年10月4日
*/
public class BubbleSort {
	
	/**
	 * 
	 * <p>Title: bubbleSort</p>
	 * <p>Description: 冒泡法排序</p>
	 * @param array
	 * 冒泡法排序其第一层循环(i=0),挑出里面最小的那个元素. 
	 * 其思想是拿第一个元素先跟第二个元素比，如果比它大，彼此换位置,
	 * 接着再拿第一个元素与第三个元素比,比它大，换位置,这样以此比下来,最小的元素就到了第一个
	 * 一个N个元素的数组,经过N-1轮的排序就可以完成冒泡法排序
	 */
	public void bubbleSortAsc(int[] array){
		int count =0;
		for(int i=0;i<array.length-1;i++){
			for(int j = i+1;j<array.length;j++){
				if(array[i]>array[j]){					
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
				count++;
			}
		}
		System.out.println("一共进行了"+count+"次排序");
	}
	
	public void bubbleSortDesc(int[] array){
		int count =0;
		for(int i=array.length-1;i>-1;i--){
			for(int j = i-1;j>-1;j--){
				if(array[i]>array[j]){					
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
				count++;
			}
		}
		System.out.println("一共进行了"+count+"次排序");
	}
	/**
	 * 
	 * <p>Title: bubbleSortAsc2</p>
	 * <p>Description: 第一轮把最大的那个数放到数组末尾</p>
	 * @param array
	 */
	public void bubbleSortAsc2(int[] array){
		int count =0;
		for(int i=1;i<array.length;i++){
			for(int j = 0;j<array.length-i;j++){
				if(array[j]>array[j+1]){					
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
				count++;
			}
		}
		System.out.println("一共进行了"+count+"次排序");
	}
	
	public void printData(int[] array){
		for(int i = 0;i<array.length;i++){
			System.out.print(array[i]+",");
			if(i%10==9){
				System.out.println("");
			}
		}
		System.out.println("==================================");
	}	
}
