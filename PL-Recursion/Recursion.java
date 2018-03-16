
// 201402415 , 장진우

public class Recursion {

	/* 피보나치 수열 */
	public static int fibonacci(int n) {

		if (n > 2) {
			return fibonacci(n - 1) + fibonacci(n - 2); // n-1번 째 수 + n-2번 째 수 =
														// n번째의 수
		} else // 첫번째,두번째는 1
			return 1;
	}

	/* 개미수열 */
	public static String recursiveAnt(int n) {
		
		if (n == 1) {    
			return "1";
		}
		else if (n > 1) {
			return makeResult(recursiveAnt(n - 1));    //순환 이용
		}
		else {
			return "잘못된 경우입니다.(양수를 입력해주세요.)"; //잘못된 경우
		}
	}

	public static String makeResult(String previous) {
		int count = 1;
		char Box = previous.charAt(0); //젤 처음문자.
		String print = "";
		if (previous.length() == 1) { // 문자가 하나인 경우
			print = print + Box;
			print = print + count;
		} 
		else if (previous.length() > 1) { //문자가 하나 이상인 경우
			
			for (int i = 1; i < previous.length(); i++) {
				if (Box != previous.charAt(i)) { 
					print = print + Box;
					print = print + count;
					Box = previous.charAt(i); //새로운 문자
					count = 1; // 갯수 초기화
					if (i + 1 == previous.length()) { //맨 마지막 문자일 경우
						print = print + Box;
						print = print + count;
					}
				}
				else if (Box == previous.charAt(i) && i + 1 == previous.length()) { // 문자가 같은 경우 && 마지막인경우 
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
