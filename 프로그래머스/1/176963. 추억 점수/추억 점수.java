import java.util.HashMap;
import java.util.Map;

class Solution {
    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        // 그리워하는 사람 String[] name
        // 각 사람별 그리움 점수를 담은 정수 배열 yearning 
        // 각 사진에 찍힌 인물의 이름을 담은 이차원 문자열 배열 photo
        Map<String, Integer> personYearningMap = new HashMap<String, Integer>();
        
        int personNum = name.length;
        for (int i = 0; i < personNum; i++) {    
            personYearningMap.put(name[i], yearning[i]);
        }
    
        int photoNum = photo.length;
        
        int[] result = new int[photoNum];
        for (int i = 0; i < photoNum ; i++) {
            int photoYearningSum = 0;
            for (String person : photo[i]) {
                Integer score = personYearningMap.get(person);
                if (score != null)
                    photoYearningSum += score;
            }
            result[i] = photoYearningSum;
        }
        return result;
    }
}