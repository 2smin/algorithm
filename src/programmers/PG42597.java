package programmers;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
public class PG42597 {

        class Album {
            public int index;
            public int played;

            public int getIndex(){
                return index;
            }

            public int getPlayed(){
                return played;
            }
        }

        class Genre {
            public String name;
            public int played = 0;

            public int getPlayed(){
                return played;
            }
        }

        static Map<String,Queue<Album>> genreMap = new HashMap<>();
        static Map<String,Genre> genreMap2 = new HashMap<>();
        static Queue<Genre> genreQueue = new PriorityQueue<Genre>(Comparator.comparing(Genre::getPlayed, Comparator.reverseOrder()));

        public int[] solution(String[] genres, int[] plays) {

            //1. genre별로 갯수 세면서 genreCount에 넣고 queue에 넣는다

            for(int i=0; i<genres.length; i++){
                if(!genreMap.containsKey(genres[i])){
                    genreMap.put(genres[i],
                            new PriorityQueue<Album>(
                                    Comparator.comparing(Album::getPlayed, Comparator.reverseOrder())
                                            .thenComparing(Album::getIndex)));

                    Genre genre = new Genre();
                    genre.name = genres[i];
                    genre.played = plays[i];

                    genreMap2.put(genres[i],genre);

                }else{
                    Genre genre = genreMap2.get(genres[i]);
                    genre.played += plays[i];
                }

                Album album = new Album();
                album.index = i;
                album.played = plays[i];

                genreMap.get(genres[i]).offer(album);
            }

            for(Map.Entry<String,Genre> entry : genreMap2.entrySet()){
                genreQueue.offer(entry.getValue());
            }

            List<Integer> indexList = new ArrayList<>();
            while(!genreQueue.isEmpty()){

                Genre genre = genreQueue.poll();
                System.out.println("genre played :" + genre.name + "," + genre.played);
                Queue<Album> albumQueue = genreMap.get(genre.name);

                Album firstAlbum = albumQueue.poll();
                indexList.add(firstAlbum.index);

                if(!albumQueue.isEmpty()){
                    Album secondAlbum = albumQueue.poll();
                    indexList.add(secondAlbum.index);
                }
            }

            int[] answer = indexList.stream().mapToInt(i->i).toArray();

            return answer;
        }

}
