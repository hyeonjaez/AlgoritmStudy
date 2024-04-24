import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int testCaseCount = Integer.parseInt(br.readLine());
            StringTokenizer st;

            for (int i = 0; i < testCaseCount; i++) {
                st = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(st.nextToken());
                int M = Integer.parseInt(st.nextToken());

                Deque<Document> queue = new ArrayDeque<>();

                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    queue.add(new Document(j, Integer.parseInt(st.nextToken())));
                }

                int count = 0;
                while (!queue.isEmpty()) {
                    Document current = queue.poll();

                    boolean hasHigherPriority = false;
                    for (Document document : queue) {
                        if (document.getImportance() > current.getImportance()) {
                            hasHigherPriority = true;
                            break;
                        }
                    }

                    if (hasHigherPriority) {
                        queue.addLast(current);
                    } else {
                        count++;
                        if (current.getIndex() == M) {
                            System.out.println(count);
                            break;
                        }
                    }
                }
            }
        }
    }

    static class Document {
        private final int index;
        private final int importance;

        public Document(int index, int importance) {
            this.index = index;
            this.importance = importance;
        }

        public int getIndex() {
            return index;
        }

        public int getImportance() {
            return importance;
        }
    }
}