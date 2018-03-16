
// 201402415 , ������

public class Recursion {

	/* �Ǻ���ġ ���� */
	public static int fibonacci(int n) {

		if (n > 2) {
			return fibonacci(n - 1) + fibonacci(n - 2); // n-1�� ° �� + n-2�� ° �� =
														// n��°�� ��
		} else // ù��°,�ι�°�� 1
			return 1;
	}

	/* ���̼��� */
	public static String recursiveAnt(int n) {
		
		if (n == 1) {    
			return "1";
		}
		else if (n > 1) {
			return makeResult(recursiveAnt(n - 1));    //��ȯ �̿�
		}
		else {
			return "�߸��� ����Դϴ�.(����� �Է����ּ���.)"; //�߸��� ���
		}
	}

	public static String makeResult(String previous) {
		int count = 1;
		char Box = previous.charAt(0); //�� ó������.
		String print = "";
		if (previous.length() == 1) { // ���ڰ� �ϳ��� ���
			print = print + Box;
			print = print + count;
		} 
		else if (previous.length() > 1) { //���ڰ� �ϳ� �̻��� ���
			
			for (int i = 1; i < previous.length(); i++) {
				if (Box != previous.charAt(i)) { 
					print = print + Box;
					print = print + count;
					Box = previous.charAt(i); //���ο� ����
					count = 1; // ���� �ʱ�ȭ
					if (i + 1 == previous.length()) { //�� ������ ������ ���
						print = print + Box;
						print = print + count;
					}
				}
				else if (Box == previous.charAt(i) && i + 1 == previous.length()) { // ���ڰ� ���� ��� && �������ΰ�� 
					count++;
					print = print + Box;
					print = print + count;

				} else {
					count++;
				}
			}
		}
		return print;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	System.out.println(fibonacci(10));
	System.out.println(recursiveAnt(10));

	}

}
