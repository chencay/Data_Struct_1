package Sort;

//��������

public class InsertionSort {
	public int[] insertionsort(int[] a){
		int tmp;
		for(int i=1;i<a.length;i++){//������������ÿ����ֵ
			for(int j=i;j>0&&a[j-1]>a[j];j--){
				//�ӵ�i������a[i]��ʼ�����a[i]��ֵ��ǰһλ����ֵС���������ǰ�ƶ���j--��֤������ǰһλ���Ƚϣ�a[i]ֱ����ȷ�Ĵ�Сλ��
				//������������ȷλ��,��a[i]��ǰһλ��ֵ��
				tmp=a[j];
				a[j]=a[j-1];
				a[j-1]=tmp;
			}
		}
		return a;
	}
	//�Ż�����㷨:����tmp�Ǳ�������ֵΪҪ��ֵ��������a[i]�ڱȽϹ������ǲ����
	public int[] insertionsort_1(int[] a){
		int tmp,j;
		for(int i=1;i<a.length;i++){//������������ÿ����ֵ
			tmp=a[i];//��a[i]�����������ڱȽϹ����б�����ֵ����
			for(j=i;j>0&&a[j-1]>tmp;j--){
				//������ǰ�ƶ���a[i]�Ƚ�ֱ����ȷλ��
				//ǰһλ��a[i]������ǰλ��j��ֵ��������һλ
				a[j]=a[j-1];
			}
			//����ѭ�����ѵ���ȷλ�ã���a[i]��ֵ����ǰλ�ü�j
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
