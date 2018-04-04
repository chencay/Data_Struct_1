package Sort;

//�鲢����

public class MergeSort {
	public void merge(int[] a,int left,int mid,int right){
		//mid�������������յ㣬right���ҷ���������յ�
		int lstart=left;//�������������
		int rstart=mid+1;//�ҷ�����������
		int num=0;//����tmp�����±�ļ�¼
		int[] tmp=new int[right-left+1];//����һ���µ��������ڱȽϴ�С�����ʱװ��
		//���ҷ���������бȽϣ�С�ķŽ�tmp����ʱ�洢
		while(lstart<=mid&&rstart<=right){
			if(a[lstart]<a[rstart])
				tmp[num++]=a[lstart++];
			else
				tmp[num++]=a[rstart++];
		}
		//�������������ʣ���򸳸�tmp
		while(lstart<=mid){
			tmp[num++]=a[lstart++];
		}
		//�ҷ�����������ʣ���򸳸�tmp
		while(rstart<=right){
			tmp[num++]=a[rstart++];
		}
		//��tmp��ʱ�����е����ݸ��ƻ�����a��
		for(int i=0;i<tmp.length;i++){
			a[i+left]=tmp[i];
		}
	}
	public int[] mergesort(int[] a,int left,int right){
		int mid=(left+right)/2;
		if(left<right){
			//���ߵݹ�
			mergesort(a, left, mid);
			//�Ұ�ߵݹ�
			mergesort(a,mid+1,right);
			//���Һϲ�
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
