public class basicsort{
    // public static void bubblesort(int arr[]){
    //     for(int i = 0; i< arr.length-1;i++){
    //         for(int j = 0; j<arr.length-i-1; j++){
    //             if(arr[j]>arr[j+1]){
    //                 System.out.println(arr[j]+" > "+arr[j+1]);
    //                 int temp = arr[j];
    //                 arr[j]= arr[j+1];
    //                 arr[j+1] = temp;
    //             }
    //         }
    //     }
    //     // print(arr);
    // }


    public static void bubble(int arr[]){

        for(int i = 0; i<arr.length;i++){
            for(int j = 0;j<arr.length - i -1;j++){
                if(arr[j+1]<arr[j]){
                    int swap = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = swap;
                }
            }
        }

    }

    public static void print(int arr[]){
        int i = 0;
        while(i < arr.length-1){
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,4,2,7,5,4,3};
        // bubblesort(arr);
    }
}