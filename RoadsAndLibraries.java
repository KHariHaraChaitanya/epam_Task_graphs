/*
 * Author- K.HariHaraChaitanya 
 */
import java.io.*;
import java.math.*;
import java.util.*;

public class RoadsAndLibraries{

    public static long solve(int cities, long costLib, long costRoad, ArrayList<TreeSet<Integer>> adj) {
        if (costLib <= costRoad) { return (costLib * cities); }
        long cost = 0;
        boolean[] visited = new boolean[cities];
        for (int i = 0; i < cities; i++) {
            if (!visited[i]) {
                long tmpCost = costLib;
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                visited[i] = true;
                while (!stack.empty()) {
                    int u = stack.pop();
                    Iterator<Integer> it = adj.get(u).iterator();
                    while (it.hasNext()) {
                        int v = it.next();
                        if (!visited[v]) {
                            stack.push(v);
                            visited[v] = true;
                            tmpCost += costRoad;
                        }
                    }
                }
                cost += tmpCost;
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int queries = in.nextInt();
        for(int q = 0; q < queries; q++){
            int cities = in.nextInt();
            int roads = in.nextInt();
            long costLib = in.nextLong();
            long costRoad = in.nextLong();
            ArrayList<TreeSet<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < cities; i++) { adj.add(new TreeSet<Integer>()); }
            for(int a1 = 0; a1 < roads; a1++){
                int u = in.nextInt();
                u--;
                int v = in.nextInt();
                v--;
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            System.out.println(RoadsAndLibraries.solve(cities, costLib, costRoad, adj));
        }
    }
}
