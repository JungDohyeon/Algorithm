import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> playCount = new HashMap<>();    // 장르 별 playCount
        HashMap<String, HashMap<Integer, Integer>> playInfo = new HashMap<>();   // 장르 내 곡 저장
        
        int count = genres.length;
        
        // 장르 별 play Count 저장
        for (int i = 0; i < count; i++)  {
            if (!playCount.containsKey(genres[i])) { 
                HashMap<Integer, Integer> songInfo = new HashMap<>();
                songInfo.put(i, plays[i]);
                playInfo.put(genres[i], songInfo);
            } else {
                playInfo.get(genres[i]).put(i, plays[i]);   // 고유번호, 음악 재생 수 저장
            }
            
            playCount.put(genres[i], playCount.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        // 장르 Play 수에 따른 내림차순 정렬
        ArrayList<String> genreList = new ArrayList<>(playCount.keySet());
        Collections.sort(genreList, (o1, o2) -> playCount.get(o2) - playCount.get(o1));
        
        // 답을 담을 ArrayList
        ArrayList<Integer> answerList = new ArrayList<>();
        
        for(String genre: genreList) {
            // 해당 장르에 있는 곡 리스트 (Key: 곡 고유번호, Value: 노래 play 수)
            HashMap<Integer, Integer> genreSongList = playInfo.get(genre);
            
            // 노래 고유번호를 play 수 내림차순으로 정렬
            ArrayList<Integer> songList = new ArrayList<>(genreSongList.keySet());
            Collections.sort(songList, (o1, o2) -> genreSongList.get(o2) - genreSongList.get(o1));
        
            // 답 ArrayList에 추가.
            answerList.add(songList.get(0));
            
            if (songList.size() > 1) {
                answerList.add(songList.get(1));
            }
        }
        
        // ArrayList -> Array
        int answerLen = answerList.size();
        int[] answer = new int[answerLen];
        
        for (int i = 0; i < answerLen; i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}