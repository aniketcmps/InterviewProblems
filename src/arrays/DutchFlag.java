package arrays;

import java.util.Arrays;

public class DutchFlag {

	public void partition(int a[]){
		int n=a.length;
		int low=0;
		int mid=0;
		int high=n-1;
		
		while(mid<=high){
			switch(a[mid]){
				case 0: int temp=a[low];
						a[low]=a[mid];
						a[mid]=temp;
						low++;
						mid++;
						break;
				case 1: mid++;
						break;
				case 2: int temp1=a[high];
						a[high]=a[mid];
						a[mid]=temp1;
						high--;
						break;
			}
		}
	}
	
	public static void main(String[] args) {
		DutchFlag d=new DutchFlag();
		int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		
		System.out.println("Before "+Arrays.toString(arr));
		d.partition(arr);
		System.out.println("After "+Arrays.toString(arr));
	}

}
