import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        TimeTable[] timeTables = new TimeTable[n];
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            timeTables[i] = new TimeTable(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(timeTables);

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.add(timeTables[0].end);

        for (int i = 1; i < n; i++) {
            if (queue.peek() <= timeTables[i].start) {
                queue.poll();
            }

            queue.add(timeTables[i].end);
        }

        System.out.println(queue.size());

    }
}

class TimeTable implements Comparable<TimeTable> {
    int start;
    int end;

    public TimeTable(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(TimeTable o) {
        if (this.start == o.start) {
            return this.end - o.end;
        }
        return this.start - o.start;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TimeTable{");
        sb.append("start=").append(start);
        sb.append(", end=").append(end);
        sb.append('}');
        return sb.toString();
    }
}