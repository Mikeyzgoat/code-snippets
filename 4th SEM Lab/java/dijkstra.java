import java.util.Scanner;

public class dijkstra {
    static int mindist(int dist[],Boolean sptset[],int n){
        int index = -1;
        int min = 999;
        for(int i=0;i<n;i++){
            if((sptset[i] == false) && (dist[i] <= min)){
                min = dist[i];
                index = i; 
            }
        }
        return index;
    }
    static void short_path(int am[][],int src,int n){
        int dist[] = new int[n];
        Boolean sptset[] = new Boolean[n];
        for(int i=0;i<n;i++){
            dist[i] = 999;
            sptset[i] = false;
        }

        dist[src-1] = 0;
        for(int cnt = 0;cnt <(n-1);cnt++){
            int u = mindist(dist,sptset,n);
            sptset[u] = true;

            for(int i =0;i<n;i++){
                if((!sptset[i]) && (am[u][i]!=0) && (dist[u]!= 999) && (dist[u] + am[u][i] < dist[i]))
                    dist[i] = dist[u] + am[u][i];
            }
        }
        
        println("-----------------------------------------------------");
        println("Source\t\tVertex\t\tDistance from Source");
        println("-----------------------------------------------------");
        for(int i=0;i<n;i++){
            println(""+(src)+"\t\t "+(i+1)+"\t\t "+dist[i]);
        }
    }
    static void println(Object line){
        System.out.println(line);
    }
    static void print(Object line){
        System.out.print(line);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        print("Enter number of vertices : ");
        int n = sc.nextInt();
        sc.nextLine();
        int am[][] = new int[n][n];
        println("Enter adjacency matrix : ");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                am[i][j] = sc.nextInt();
            }
        }
        println("");
        println("Shortest path to all vertices from every vertex : ");
        for(int i=0;i<n;i++)
        {
            int src = i+1;
            short_path(am, src, n);
        }
        sc.close();
    }    
}
/*
output : 
Enter number of vertices : 5
Enter adjacency matrix :
0 3 999 7 999
3 0 4 2 999
999 4 0 5 6
7 2 5 0 4
999 999 6 4 0

Shortest path to all vertices from every vertex :
-----------------------------------------------------
Source          Vertex          Distance from Source
-----------------------------------------------------
1                1               0
1                2               3
1                3               7
1                4               5
1                5               9
-----------------------------------------------------
Source          Vertex          Distance from Source
-----------------------------------------------------
2                1               3
2                2               0
2                3               4
2                4               2
2                5               6
-----------------------------------------------------
Source          Vertex          Distance from Source
-----------------------------------------------------
3                1               7
3                2               4
3                3               0
3                4               5
3                5               6
-----------------------------------------------------
Source          Vertex          Distance from Source
-----------------------------------------------------
4                1               5
4                2               2
4                3               5
4                4               0
4                5               4
-----------------------------------------------------
Source          Vertex          Distance from Source
-----------------------------------------------------
5                1               9
5                2               6
5                3               6
5                4               4
5                5               0
 */