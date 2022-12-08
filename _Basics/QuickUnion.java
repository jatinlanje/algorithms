public class QuickUnion { 
    public static void main(String[] args) {
        quickUnion(10);
        System.out.println(connected(1,2));
        union(1,2);
        System.out.println(connected(1,2));
    }
    private static int[] id;

    public static void quickUnion(int N){
        id = new int [N];
        for(int i = 0; i < N; i++){
            id[i] = i;
        }
    }

    private static int root(int i){
        while (i != id[i]){
            i = id[i];
        }
        return i;
    }
    public static boolean connected(int p, int q){
        return root(p) == root(q);
    }
    public static void union(int p, int q){
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }
}
