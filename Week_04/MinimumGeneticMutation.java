package com.hbq.aop.algorithm.week04;

import java.util.*;

public class MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) {
            return 0;
        }

        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));

        char[] charSet = { 'A', 'C', 'G', 'T' };
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        visited.add(start);
        queue.offer(start);

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String curr = queue.poll();
                if (curr.equals(end)) {
                    return level;
                }

                char[] curCharArr = curr.toCharArray();
                for (int i = 0; i < curCharArr.length; i++) {
                    char old = curCharArr[i];
                    for (char c : charSet) {
                        curCharArr[i] = c;
                        String next = new String(curCharArr);
                        if (!visited.contains(next) && bankSet.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    curCharArr[i] = old;
                }
            }
            level++;
        }

        return -1;
    }

    public static void main(String[] args) {
        String start = "AACCGGTT";
        String end = "AAACGGTA";
        String[] bank = { "AACCGGTA","AACCGCTA","AAACGGTA" };
        System.out.println(new MinimumGeneticMutation().minMutation(start, end, bank));
    }
}
