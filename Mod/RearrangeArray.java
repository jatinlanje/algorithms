class RearrangeArray{
    static void rearrange(long arr[], int n){
        for(int i=0; i<n; i++){
            arr[i]=arr[i]+(arr[(int)arr[i]]%n)*n;
        }
        for(int j=0; j<n; j++){
            arr[j]=arr[j]/n;
        }
    }
}
