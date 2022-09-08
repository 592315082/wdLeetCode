package LeetCode;

import java.util.*;

public class Test355 {
    public static void main(String[] args) {

        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        twitter.getNewsFeed(1);
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        twitter.getNewsFeed(1);
        twitter.unfollow(1, 2);
        twitter.getNewsFeed(1);

        LinkedHashMap<Integer, Integer> hashMap = new LinkedHashMap<>();
        hashMap.put(1, 1);
        hashMap.put(3, 3);
        hashMap.put(2, 2);
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() +":"+ entry.getValue());
        }

        System.out.println("=============================");
        Iterator<Map.Entry<Integer, Integer>> entries = hashMap.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<Integer, Integer> entry = entries.next();
            System.out.println(entry.getKey() +":"+ entry.getValue());
        }

        System.out.println("=============================");
        ListIterator<Map.Entry<Integer, Integer>> listIterator = new ArrayList<Map.Entry<Integer, Integer>>(hashMap.entrySet()).listIterator(hashMap.size());
        while (listIterator.hasPrevious()) {
            Map.Entry<Integer, Integer> entry = listIterator.previous();
            System.out.println(entry.getKey() +":"+ entry.getValue());
        }
    }
}

class Twitter {

    LinkedHashMap<Integer, Integer> hashMap = null;

    HashMap<Integer, List<String>> followMap = null;

    public Twitter() {
        hashMap = new LinkedHashMap<>();

        followMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        hashMap.put(tweetId, userId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new LinkedList<>();
        List<String> followlist = followMap.getOrDefault(userId, new ArrayList<>());
        ListIterator<Map.Entry<Integer, Integer>> listIterator = new ArrayList<Map.Entry<Integer, Integer>>(hashMap.entrySet()).listIterator(hashMap.size());
        while (listIterator.hasPrevious()) {
            Map.Entry<Integer, Integer> entry = listIterator.previous();
            int mapUserId = entry.getValue();
            String mapUserIdStr = String.valueOf(mapUserId);
            if (mapUserId == userId || followlist.contains(mapUserIdStr)) {
                result.add(entry.getKey());
            }
            if (result.size() == 10) {
                break;
            }
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        List<String> followlist = followMap.getOrDefault(followerId, new ArrayList<>());
        String followeeIdStr = String.valueOf(followeeId);
        if (!followlist.contains(followeeIdStr)) {
            followlist.add(followeeIdStr);
        }
        followMap.put(followerId, followlist);
    }

    public void unfollow(int followerId, int followeeId) {
        List<String> followlist = followMap.getOrDefault(followerId, new ArrayList<>());
        String followeeIdStr = String.valueOf(followeeId);
        followlist.remove(followeeIdStr);
        followMap.put(followerId, followlist);
    }
}