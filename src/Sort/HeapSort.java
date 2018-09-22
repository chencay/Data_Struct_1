package Sort;

//1、任意一节点指针 i：父节点：i==0 ? null : (i-1)/2
//左孩子：2*i + 1
//右孩子：2*i + 2

public class HeapSort {
	//构建大根堆
	private int[] buildMaxHeap(int[] array){
		//从最后一个节点（即array.length-1）的父节点[（array.length-1）-1]/2开始，直到根节点0.反复调整堆
		for(int i=(array.length-2)/2;i>=0;i--){
			adjustMaxHeap(array, i, array.length);
		}
		return array;
	}
	//将i节点的元素自下往上逐步调整，实现大根堆
	private void adjustMaxHeap(int[] array,int i,int length){
		int tmp=array[i];//初始化i为父节点，tmp为父节点数值
		for(int j=2*i+1;j<length-1;j=2*j+1){//取父节点i的左儿子，并沿着节点较大的子节点（因为发生了变化）向下调整
			if(j<length&&array[j]<array[j+1])//比较左右儿子大小
				j++;//如果右儿子大，j++即取右儿子的节点下标
			if(tmp>array[j])//在上一个判断取到左右儿子的最大一个，与父节点比较
				break;//如果父节点大直接退出循环
			else{//父节点<左右儿子中的大者
				array[i]=array[j];//将大儿子赋给父节点
				i=j;//【关键】修改父节点i值，即此时将j作为父节点继续向下调整
			}
		}
		array[i]=tmp;//将初始父节点的值赋给最终调整的节点，实现交换；若最大一直是初始父节点则无变化
		
	}
	//堆排序
	private int[] heapsort(int[] array){
		array=buildMaxHeap(array);//首先创建一个大根堆
		for(int i=array.length-1;i>1;i--){
			int tmp=array[0];//将堆顶元素和堆底元素交换，即得到当前最大元素正确的排序位置
			array[0]=array[i];
			array[i]=tmp;
			adjustMaxHeap(array, 0, i);//整理，将剩余的元素整理成堆
		}
		return array;
	}
	//删除堆顶元素
	private int[] deleteMax(int[] array){
		array[0]=array[array.length-1];//将堆底的元素覆盖堆顶的最大值
		array[array.length-1]=-999;//将堆底数值设为-999，尽可能随意的最小值
		//然后，在进行调整重构最大堆
		adjustMaxHeap(array, 0, array.length);
		return array;
	}
	//输出
	public void tostring(int[] array){
		for(int i:array){
			System.out.print(i+" ");
		}
	}
	public static void main(String[] args) {
		HeapSort hs=new HeapSort();
		int[] array={87,45,78,32,17,65,53,9,122};
		hs.tostring(hs.buildMaxHeap(array));
		System.out .println("");
		hs.tostring(hs.heapsort(array));
		System.out .println("");
		hs.tostring(hs.deleteMax(array));
		
	}

}
