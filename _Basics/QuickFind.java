public class QuickFind {
    public static void main(String[] args) {
        quickFind(10);
        System.out.println(connected(1,2));
        union(1,2);
        System.out.println(connected(1,2));
    }
    private static int[] id;

    //set id of each object to itself
    public static void quickFind(int N){
        id=new int[N];
        for(int i=0; i<N; i++){
            id[i]=i;
        }
    }

    //to check whether q and q are in same component
    public static boolean connected(int p, int q){
        return id[p]==id[q];
    }

    //change all entries with id[p] to id[q]
    public static void union(int p, int q){
        int pid = id[p];
        int qid = id[q];
        for(int i=0; i<id.length; i++){
            if(id[i]==pid){
                id[i]=qid;
            }
        }
    }
}
