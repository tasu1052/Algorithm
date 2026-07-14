import java.util.*;

class Solution {

    public int[] solution(String[] genres, int[] plays) {

        // 장르별 총 재생 횟수
        Map<String, Integer> genreTotal = new HashMap<>();

        // 장르별 노래 목록
        // int[] = {고유번호, 재생 횟수}
        Map<String, List<int[]>> songs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];

            genreTotal.put(
                genre,
                genreTotal.getOrDefault(genre, 0) + plays[i]
            );

            songs.putIfAbsent(genre, new ArrayList<>());
            songs.get(genre).add(new int[]{i, plays[i]});
        }

        // 장르를 총 재생 횟수 내림차순으로 정렬
        List<String> genreList = new ArrayList<>(genreTotal.keySet());

        genreList.sort((g1, g2) ->
            genreTotal.get(g2) - genreTotal.get(g1)
        );

        List<Integer> result = new ArrayList<>();

        // 많이 재생된 장르부터 순회
        for (String genre : genreList) {

            List<int[]> songList = songs.get(genre);

            // 장르 내부 노래 정렬
            songList.sort((a, b) -> {
                // 재생 횟수가 같으면 고유번호가 낮은 순서
                if (a[1] == b[1]) {
                    return a[0] - b[0];
                }

                // 재생 횟수가 많은 순서
                return b[1] - a[1];
            });

            // 장르별 최대 2곡 선택
            result.add(songList.get(0)[0]);

            if (songList.size() >= 2) {
                result.add(songList.get(1)[0]);
            }
        }

        int[] answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}