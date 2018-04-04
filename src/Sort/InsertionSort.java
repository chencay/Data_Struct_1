package Sort;

//插入排序

public class InsertionSort {
	public int[] insertionsort(int[] a){
		int tmp;
		for(int i=1;i<a.length;i++){//遍历整个序列每个数值
			for(int j=i;j>0&&a[j-1]>a[j];j--){
				//从第i个数即a[i]开始，如果a[i]数值比前一位的数值小，则持续向前移动（j--保证持续与前一位作比较）a[i]直到正确的大小位置
				//持续交换到正确位置,即a[i]比前一位数值大
				tmp=a[j];
				a[j]=a[j-1];
				a[j-1]=tmp;
			}
		}
		return a;
	}
	//优化后的算法:其上tmp是被反复赋值为要插值的数，即a[i]在比较过程中是不变的
	public int[] insertionsort_1(int[] a){
		int tmp,j;
		for(int i=1;i<a.length;i++){//遍历整个序列每个数值
			tmp=a[i];//令a[i]独立出来，在比较过程中保持数值不变
			for(j=i;j>0&&a[j-1]>tmp;j--){
				//持续向前移动与a[i]比较直到正确位置
				//前一位比a[i]大则向当前位置j赋值，即后移一位
				a[j]=a[j-1];
			}
			//跳出循环即已到正确位置，将a[i]赋值给当前位置即j
			a[j]=tmp;
		}
		return a;
	}
	public static void main(String[] args) {
		InsertionSort ins=new InsertionSort();
		int[] a={34,8,64,51,32,21};
		int[] n=ins.insertionsort_1(a);
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}

}
