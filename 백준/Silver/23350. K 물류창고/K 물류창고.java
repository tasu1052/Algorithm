import java.io.*;
import java.util.*;

public class Main {
	static int[][] containers;
	static int cost;
	static boolean canLoad(Queue<int[]> queue, int[] base) {
		for (int[] i: queue) {
			if (i[0] > base[0]) {
				return false;
			}
		}
		return true;
	}
	
	static void reposition(List<int[]> list, int[] base) {
		if (list.isEmpty()) {
			list.add(base);
			cost += base[1];
			return;
		}
		int i;
		boolean isTop = true;
		for (i = 0; i < list.size(); i++) {
			if (list.get(i)[0] == base[0] && list.get(i)[1] < base[1]) {
				list.add(i, base);
				isTop = false;
				break;
			}
		}
		if (isTop) {
			list.add(base);
			
		} else {
			for (int j = i + 1; j < list.size(); j++) {
				cost += 2 * list.get(j)[1];
			}
		}
		cost += base[1];
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
				
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		containers = new int[N][2];
		cost = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			containers[i][0] = Integer.parseInt(st.nextToken());
			containers[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Queue<int[]> railQueue = new ArrayDeque<>();
		List<int[]> loadList = new ArrayList<>();
		
		for (int i = 0; i < containers.length; i++) {
			railQueue.offer(containers[i]);
		}
		
		while(!railQueue.isEmpty()) {
			int[] container = railQueue.poll();
			if (!canLoad(railQueue, container)) {
				railQueue.offer(container); 
				cost += container[1]; 
			} else {
				reposition(loadList, container);
			}
		}
		System.out.println(cost);
		br.close();
	}
}

