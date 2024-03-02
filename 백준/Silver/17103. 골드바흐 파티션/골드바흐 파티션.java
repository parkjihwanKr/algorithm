import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    // 소수 판별 결과를 저장하기 위한 HashMap
    static HashMap<Integer, Boolean> primeCache = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        // test case input
        int input = Integer.parseInt(st.nextToken());

        for (int i = 0; i < input; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            System.out.println(isPrimeSum(number));
        }
    }

    static int isPrimeSum(int number) {
        int count = 0;
        for (int i = 2; i <= number / 2; i++) {
            int a = number - i;
            if (isPrime(a) && isPrime(i)) {
                //System.out.println("해당 숫자는 소수가 맞습니다!");
                count++;
            }
        }
        return count;
    }

    // 소수 판별 메서드에 메모이제이션 적용
    static boolean isPrime(int number) {
        // 1은 소수가 아님
        if (number == 1) {
            return false;
        }

        // 이미 계산된 결과가 있는지 확인
        if (primeCache.containsKey(number)) {
            return primeCache.get(number);
        }

        // 소수 판별 로직
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                primeCache.put(number, false);
                return false;
            }
        }

        primeCache.put(number, true);
        return true;
    }
}
