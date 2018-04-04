package Sort;

//ϣ������������������
//�Ƚ����һ�������Ԫ�أ����˱Ƚ����õľ��������㷨�Ľ��ж���С��ֱ��ֻ�Ƚ�����Ԫ��Ϊֹ
//�����������ȴ���ֻ��������ѭ���Ĳ���
public class ShellSort {
	public int[] shellsort(int[] a){
		int tmp,j;
		for(int gap=a.length/2;gap>0;gap/=2){
			//gap��������С��һ��ȡ���鳤�ȵ�һ�룬���ݼ�
			for(int i=0;i<a.length;i++){
				tmp=a[i];
				for(j=i;j>=gap&&a[j-gap]>tmp;j-=gap){
					//�˴���������������ͬ������������j-1;ϣ�������ǣ�j-������С��
					//�жϵ�ʱ������Ҫ�����������������
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
