package sort;

import java.util.Arrays;

public class MergeSort {

	public void mergesort(int a[], int l, int r){
		if(r>l){
			int m=(l+r)/2;
			mergesort(a,l,m);
			mergesort(a,m+1,r);
			merge(a,l,m,r);
		}
	}

	public void merge(int a[], int l, int m, int r){
		int end1=m-l+1;
		int end2=r-m;
		
		int temp1[]=new int[end1];
		int temp2[]=new int[end2];
		
		for(int i=0; i<end1; i++){
			temp1[i]=a[l+i];
		}
		for(int i=0; i<end2; i++){
			temp2[i]=a[m+1+i];
		}
		
		int i=0;
		int j=0;
		int k=l;
		
		while (i<end1 && j<end2){
			if(temp1[i]<=temp2[j]){
				a[k]=temp1[i];
				i++;
			}else {
				a[k]=temp2[j];
				j++;
			}
			k++;
		}
		while(i<end1){
			a[k]=temp1[i];
			i++;
			k++;
		}
		while(j<end2){
			a[k]=temp2[j];
			j++;
			k++;
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {38,27,43,3,9,82,10};
		 
        System.out.println("Given Array");
        System.out.println(Arrays.toString(arr));
 
        MergeSort ob = new MergeSort();
        ob.mergesort(arr, 0, arr.length-1);
 
        System.out.println("\nSorted array");
        System.out.println(Arrays.toString(arr));
	}
}
