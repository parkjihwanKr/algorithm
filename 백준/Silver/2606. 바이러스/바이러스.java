import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int count;
	static int[] check;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		int vertex = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int edge = Integer.parseInt(st.nextToken());
		check = new int[vertex+1];
		for(int i = 0; i<vertex+1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i<edge; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int k = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			graph.get(k).add(l);
			graph.get(l).add(k);
		}
		
		for(int i = 1; i<graph.size(); i++) {
			Collections.sort(graph.get(i));
		}
		count =1;
		dfs(1);

		System.out.println(count-1);
	}
	static void dfs(int start) {
		check[start] = count;
		for(int i = 0; i<graph.get(start).size(); i++) {
			int newNode = graph.get(start).get(i);
			if(check[newNode] == 0) {
				count++;
				dfs(newNode);
			}
		}
	}
}
