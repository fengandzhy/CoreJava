package com.citi.hz41382.datastructure.array.md03;
/**
* <p>className: InsertSort</p>
* <p>Description: 插入法排序 </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2018年10月4日
*/
public class InsertSort {
	
	/**
	 * 
	 * <p>Title: insertSortAsc</p>
	 * <p>Description: 插入法排序 </p>
	 * @param array
	 * 拿升序排序做比方，假设第一个元素是有序的,它和第二个元素比，如果第一元素比第二元素大
	 * 那么彼此交换，此时1,2两个元素也是有序的了.此时拿第三个元素和第二个元素比，那么第三个元素就
	 * 没有必要去跟第一个元素比了.反之，如果第三个元素比第二个元素小，则和第二个元素交换后，再用
	 * 第二个元素(被原来的第三个元素交换过了)和第一个元素比，如果还比第一个元素小，就彼此交换否则不交换
	 */
	public void insertSortAsc(int[] array){
		int count =0;
		for(int i=0;i<array.length-1;i++){
			for(int j=i+1;j>0;j--){
				if(array[j]<array[j-1]){					
					swap(array,j,j-1);
				}else{
					break;
				}
				count++;
			}
		}
		System.out.println("一共进行了"+count+"次排序");
	}
	
	private void swap(int[] as,int aIndex,int bIndex){
		int temp = as[aIndex];
		as[aIndex] = as[bIndex];
		as[bIndex] = temp;
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
