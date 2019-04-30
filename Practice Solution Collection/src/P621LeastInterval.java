public class P621LeastInterval {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int maxFreq = Integer.MIN_VALUE;
        int maxFreqCount = 0;
        for (char c : tasks) {
            freq[c - 'A']++;
        }
        for (int i = 0; i < freq.length; i++) {
            if(maxFreq < freq[i]) {
                maxFreq = freq[i];
                maxFreqCount = 1;
            } else if(maxFreq == freq[i]) {
                maxFreqCount++;
            }
        }
        return Math.max(tasks.length, (maxFreq -1) * (n + 1) + maxFreqCount);
    }
}
