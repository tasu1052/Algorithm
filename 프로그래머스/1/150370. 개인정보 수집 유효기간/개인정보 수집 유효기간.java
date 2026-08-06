import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> termMap = new HashMap<>();

        for (String term : terms) {
            String[] parts = term.split(" ");

            String type = parts[0];
            int month = Integer.parseInt(parts[1]);

            termMap.put(type, month);
        }

        int todayDays = convertToDays(today);

        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < privacies.length; i++) {
            String[] parts = privacies[i].split(" ");

            String privacyDate = parts[0];
            String type = parts[1];

            int collectedDays = convertToDays(privacyDate);
            int expirationDays =
                    collectedDays + termMap.get(type) * 28;

            // 만료일 당일부터 파기
            if (todayDays >= expirationDays) {
                answer.add(i + 1);
            }
        }

        int[] result = new int[answer.size()];

        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }

    static int convertToDays(String date) {
        String[] parts = date.split("\\.");

        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        return year * 12 * 28
                + month * 28
                + day;
    }
}