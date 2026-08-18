
public class algosrepetation {

    public static void swap1(int a,int b){
        int temp = a;
        a = b;
        b = temp;
        return;
    }

    public static void swap2(int a, int b){
        a = a ^ b;
        b = a ^ b ;
        a = a ^ b;
    }

    public static void swap3(int a, int b){
        a=a+b;
        b = a-b;
        a = a - b;
    }

    // binary search

    public static int bsrep(int arr[], int st, int ed, int x){
        if (st > ed) {
            return -1;
        }
        int mid = (st+ed)/2;
        if(arr[mid] == x) return mid;
        if(arr[mid]>x){
            return bsrep(arr, st, mid-1, x);
        }
        return bsrep(arr, mid+1, ed, x);
    }

    public static int bsrep2(int arr[], int st, int ed, int x){
        if(st>ed) return -1;
        int mid = st+(ed-st)/2;
        if(arr[mid] == x) return mid;
        if(arr[mid]>x) return bsrep(arr, st, mid-1, x);
        return bsrep(arr, mid+1, ed, x);
    }

    public static int bsiter(int arr[],int x){
        int st = 0;
        int ed = arr.length-1;
        while (st<=ed) {
            int mid = st +(ed-st)/2;
            if(arr[mid] == x) return mid;
            else if(arr[mid]>x) ed = mid-1;
            else{
                st = mid+1;
            }
        }
        return -1;
    }

    public static int bslowerbound(int arr[], int x){
        int st = 0;
        int ed = arr.length-1;
        while(st<ed){
            int mid = st + (ed-st)/2;
            if(arr[mid]>=x) ed = mid;
            else{
                st = mid+1;
            }
        }
        return st;
    }

    public static int upperrecrep(int arr[], int x , int st , int ed){
        if(st>ed) return -1;
        if (st == ed) {
            return st;
        }
        int mid = st + (ed-st)/2;
        if(arr[mid]>x) return upperrecrep(arr, x, st, mid);
        return upperrecrep(arr, x, mid+1, ed);
    }


    // mergesort
    public static void merge(int arr[],int st, int ed ,int mid){
        int temp[] = new int[ed-st+1];
        int i = st;
        int j = mid+1;
        int k = 0;
        while(i<=mid && j<=ed){
            // check which is big
            if(arr[i]<arr[j]){
                temp[k] = arr[i];
                k++;
                i++;
            }else if(arr[i]>arr[j]){
                temp[k] = arr[j];
                k++;
                j++;
            }
        }
        // left empty
        while(i>mid && j <= ed){
            temp[k] = arr[j];
            k++;
            j++;
        }
        // right empty
        while(i<=mid && j > ed){
            temp[k] = arr[i];
            k++;
            i++;
        }
        for(int x = 0;i<temp.length;x++){
            arr[x+st] = temp[x];
        }
    }
    public static void mergesort(int arr[],int st, int ed){
        if(st>=ed){
            return;
        }
        int mid = st + (ed-st)/2;
        mergesort(arr, st, mid);
        mergesort(arr, mid+1, ed);
        merge(arr,st,ed,mid);
    }

    public static void merge2(int arr[],int temp[],int st, int ed, int mid){
        int i = st;
        int j = mid + 1;
        int k = st;
        while(i<=mid&&j<=ed){
            if(arr[i]>arr[j]){
                temp[k] = arr[j];
                k++;
                j++;
            }else if(arr[i]<=arr[j]){
                temp[k] = arr[i];
                k++;
                i++;
            }
        }
        while(i>mid && j <= ed){
            temp[k] = arr[j];
            k++;
            j++;
        }
        while(i<=mid && j > ed){
            temp[k] = arr[i];
            k++;
            i++;
        }
        for(int x = st;x<=ed;x++){
            arr[x] = temp[x];
        }
    }
    public static void mergesort2(int arr[], int temp[], int st, int ed ){
        if(st>=ed) return;
        int mid = st + (ed-st)/2;
        mergesort2(arr, temp, st, mid);
        mergesort2(arr, temp, mid+1, ed);
        if (arr[mid] <= arr[mid + 1]) {
            return;
        }
        merge2(arr,temp,st,ed,mid);
    }

    public static void merge3(int arr[], int temp[], int st ,int ed ,int mid){
        int i = st;
        int j = mid+1;
        int k = st;
        while (i<=mid&&j<=ed) {
            if(arr[i]>arr[j]){
                temp[k++] = arr[j++];
            }else if(arr[i]<=arr[j]){
                temp[k++] = arr[i++];
            }
        }
        while (i<=mid) {
            temp[k++] = arr[i++];
        }
        while (j<=ed) {
            temp[k++] = arr[j++];
        }
        for(int x = st;x<=ed;x++){
            arr[x]  =  temp[x];
        }
    }
    public static void mergesort3(int arr[], int temp[], int st, int ed){
        if(st>=ed) return;
        int mid = st + (ed-st)/2;
        mergesort3(arr, temp, st, mid);
        mergesort3(arr, temp, mid+1, ed);
        if(arr[mid]<=arr[mid+1]){
            return;
        }
        merge3(arr,temp,st,ed,mid);
    }
    
    // quicksort
    public static int partetion(int arr[], int st , int ed){
        int mid = st + (ed - st)/2;
        int piv = arr[mid];
        int i = st;
        int j = ed;
        while (i<=j) {
            while (arr[i]<piv) {
                i++;
            }
            while (arr[j]>piv) {
                j--;
            }
            if(i<=j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        return i;
    }
    public static void quicksort(int arr[], int st , int ed){
        if(st>=ed) return;
        int pivot = partetion(arr, st ,ed);
        quicksort(arr, st, pivot-1);
        quicksort(arr, pivot, ed);
    }
     
    
    public static int partetion2(int arr[], int st, int ed){
        int mid = st + (ed-st)/2;
        int pivelem = arr[mid];
        int i = st;
        int j = ed;
        while (i<=j) {
            while (arr[i]<=pivelem) {
                i++;
            }
            while (arr[j]>=pivelem) {
                j--;
            }
            if(i<=j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        return i;
    }
    public static void quicksort2(int arr[], int st , int ed){
        if(st>=ed){
            return;
        }
        int piv = partetion2(arr,st,ed);
        quicksort2(arr, st, piv-1);
        quicksort2(arr, piv, ed);
    }



    // quickselect

    public static void main(String[] args) {
        
    }

}
