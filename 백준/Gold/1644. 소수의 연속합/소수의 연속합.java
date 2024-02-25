import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int number = Integer.parseInt(st.nextToken());
		
		// 1일 때, 출력 값 : 0
		if(number == 1) {
			System.out.println(0);
			return;
		}
		
		// 2이상일 때, 출력 값 : ~~
		List<Integer> array = new ArrayList<>();
		
		for(int i = 2; i<=number; i++) {
			// 소수 일때
			if(isPrime(i)) {
				array.add(i);
			}
		}
		int answer = sumPrimeNumber(number, array);
		System.out.print(answer);
	}
	
	static boolean isPrime(int number) {
		for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
	}
	
	static int sumPrimeNumber(int number, List<Integer> primeNumberArray) {
		int count = 0;
		int tmpNumber = 0;
		if(number == primeNumberArray.get(primeNumberArray.size()-1)) {
			count++;
		}
		
		for(int i = 0; i<primeNumberArray.size(); i++) {
			tmpNumber = primeNumberArray.get(i);
			for(int j = i+1; j<primeNumberArray.size(); j++) {
				tmpNumber += primeNumberArray.get(j);
				if(tmpNumber < number) {
					continue;
				}else if(tmpNumber == number) {
					count++;
					break;
				}else {
					break;
				}
			}
		}
		return count;
	}
}
