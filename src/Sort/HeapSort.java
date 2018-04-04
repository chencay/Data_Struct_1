package Sort;

//1������һ�ڵ�ָ�� i�����ڵ㣺i==0 ? null : (i-1)/2
//���ӣ�2*i + 1
//�Һ��ӣ�2*i + 2

public class HeapSort {
	//���������
	private int[] buildMaxHeap(int[] array){
		//�����һ���ڵ㣨��array.length-1���ĸ��ڵ�[��array.length-1��-1]/2��ʼ��ֱ�����ڵ�0.����������
		for(int i=(array.length-2)/2;i>=0;i--){
			adjustMaxHeap(array, i, array.length);
		}
		return array;
	}
	//��i�ڵ��Ԫ�����������𲽵�����ʵ�ִ����
	private void adjustMaxHeap(int[] array,int i,int length){
		int tmp=array[i];//��ʼ��iΪ���ڵ㣬tmpΪ���ڵ���ֵ
		for(int j=2*i+1;j<length-1;j=2*j+1){//ȡ���ڵ�i������ӣ���������֧��2j+1�����µ���
			if(j<length&&array[j]<array[j+1])//�Ƚ����Ҷ��Ӵ�С
				j++;//����Ҷ��Ӵ�j++��ȡ�Ҷ��ӵĽڵ��±�
			if(tmp>array[j])//����һ���ж�ȡ�����Ҷ��ӵ����һ�����븸�ڵ�Ƚ�
				break;//������ڵ��ֱ���˳�ѭ��
			else{//���ڵ�<���Ҷ����еĴ���
				array[i]=array[j];//������Ӹ������ڵ�
				i=j;//���ؼ����޸ĸ��ڵ�iֵ������ʱ��j��Ϊ���ڵ�������µ���
			}
		}
		array[i]=tmp;//����ʼ���ڵ��ֵ�������յ����Ľڵ㣬ʵ�ֽ����������һֱ�ǳ�ʼ���ڵ����ޱ仯
		
	}
	//������
	private int[] heapsort(int[] array){
		array=buildMaxHeap(array);//���ȴ���һ�������
		for(int i=array.length-1;i>1;i--){
			int tmp=array[0];//���Ѷ�Ԫ�غͶѵ�Ԫ�ؽ��������õ���ǰ���Ԫ����ȷ������λ��
			array[0]=array[i];
			array[i]=tmp;
			adjustMaxHeap(array, 0, i);//������ʣ���Ԫ������ɶ�
		}
		return array;
	}
	//ɾ���Ѷ�Ԫ��
	private int[] deleteMax(int[] array){
		array[0]=array[array.length-1];//���ѵ׵�Ԫ�ظ��ǶѶ������ֵ
		array[array.length-1]=-999;//���ѵ���ֵ��Ϊ-999���������������Сֵ
		//Ȼ���ڽ��е����ع�����
		adjustMaxHeap(array, 0, array.length);
		return array;
	}
	//���
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
