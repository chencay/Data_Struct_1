package Sort;

//归并排序

public class MergeSort {
	public void merge(int[] a,int left,int mid,int right){
		//mid是左分治数组的终点，right是右分治数组的终点
		int lstart=left;//左分治数组的起点
		int rstart=mid+1;//右分治数组的起点
		int num=0;//用于tmp数组下标的记录
		int[] tmp=new int[right-left+1];//创建一个新的数组用于比较大小后的临时装载
		//左、右分治数组进行比较，小的放进tmp中临时存储
		while(lstart<=mid&&rstart<=right){
			if(a[lstart]<a[rstart])
				tmp[num++]=a[lstart++];
			else
				tmp[num++]=a[rstart++];
		}
		//左分治数组若有剩余则赋给tmp
		while(lstart<=mid){
			tmp[num++]=a[lstart++];
		}
		//右分治数组若有剩余则赋给tmp
		while(rstart<=right){
			tmp[num++]=a[rstart++];
		}
		//将tmp临时数组中的数据复制回数组a中
		for(int i=0;i<tmp.length;i++){
			a[i+left]=tmp[i];
		}
	}
	public int[] mergesort(int[] a,int left,int right){
		int mid=(left+right)/2;
		if(left<right){
			//左半边递归
			mergesort(a, left, mid);
			//右半边递归
			mergesort(a,mid+1,right);
			//左右合并
			merge(a,left,mid,right);
		}
		return a;
	}
	public static void main(String[] args) {
		int a[] = { 51, 46, 20, 18, 65, 97, 82, 30, 77, 50 };
		MergeSort ms=new MergeSort();
		int[] array=ms.mergesort(a, 0, a.length-1);
		for(int i:array){
			System.out.print(i+" ");
		}
	}

}
