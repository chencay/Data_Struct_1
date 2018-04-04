package Sort;

//希尔排序（缩减增量排序）
//比较相距一定间隔的元素，各趟比较所用的距离随着算法的进行而减小，直到只比较相邻元素为止
//与插入排序相比代码只多了增量循环的部分
public class ShellSort {
	public int[] shellsort(int[] a){
		int tmp,j;
		for(int gap=a.length/2;gap>0;gap/=2){
			//gap即增量大小，一般取数组长度的一半，逐半递减
			for(int i=0;i<a.length;i++){
				tmp=a[i];
				for(j=i;j>=gap&&a[j-gap]>tmp;j-=gap){
					//此处与插入排序基本相同，插入排序是j-1;希尔排序是（j-增量大小）
					//判断的时候最终要大于增量，避免出错
					a[j]=a[j-gap];
				}
				a[j]=tmp;
			}
		}
		return a;
	}
	public static void main(String[] args) {
		ShellSort sh=new ShellSort();
		int[] a={81,94,11,96,12,35,17,95,28,58,41,75,15};
		int[] m=sh.shellsort(a);
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}

}
