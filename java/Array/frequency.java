public class frequency {

    public static int MaxElement(int arr[]){
        int current=0;
        int freq  = 0;
        int answer = 0;
        int maxfrequency = 0;
        for (int i = 0;  i<arr.length; i++) {
            current = arr[i];
            if(current == answer){
                continue;
            }
            for (int j = 0;  j<arr.length; j++) {
                if(arr[j] == current){
                    freq++;
                }
            }
             if(freq>maxfrequency){
                maxfrequency = freq;
                answer = current;
            }
            freq = 0;
        }
        return answer;
    }
    
    // public static int MaxElementfreq2(int arr[]){
    //     // 
    // }  

    public static void dnf(int arr[]){
        int i = 0;
        int j = arr.length-1;
        int x = 0;
        while (x<=j){
            if(arr[i]>arr[x]){
                // swap
                int t = arr[i];
                arr[i] = arr[x];
                arr[x] = t;
                i++;
                x++;
            } else if(arr[x]>arr[j]){
                // swap
                int t = arr[i];
                arr[i] = arr[x];
                arr[x] = t;
                j--;
            }else{
                x++;
            }
        }
    }

    public static void dnf2(int arr[]){
        int i = 0;
        int j = arr.length-1;
        int k = 0;
        while (k<=j) {
            if(arr[i]>arr[k]){
                // swap
                int t = arr[i];
                arr[i] = arr[k];
                arr[k] = t;
                i++;
                k++;
            }else if(arr[k]>arr[j]){
                // swap
                int t = arr[j];
                arr[j] = arr[k];
                arr[k] = t;
                j--;
            }else{
                k++;
            }
        }
    }

    public static int kaddans(int arr[]){
        if(arr.length <=0) return -1;
        int currsum = arr[0];
        int maxsum = arr[0];
        for(int i = 1;i<arr.length;i++){
            int n = arr[i];
            currsum = Math.max(currsum+n, n);
            maxsum = Math.max(maxsum, currsum);
        }
        return maxsum;
    }

    public static int kaddans2(int arr[]){
        int maxsum = arr[0];
        int cursum = arr[0];
        for(int i = 1;i<arr.length;i++){
            int n = arr[i];
            cursum = Math.max(cursum+n,n);
            maxsum = Math.max(maxsum, cursum);
        }
        return maxsum;
    }
    
    public static int kaddans3(int arr[]){
        int cursum = 0;
        int maxsum = 0;
        for(int i = 0;i<arr.length;i++){
            int n = arr[i];
            cursum = Math.max(cursum+n, n);
            maxsum = Math.min(maxsum, cursum);
        }
        return maxsum;
    }

    // val >= n/k so k - 1 elem possible 
    public static int borismorry1(int arr[]){
        int n = arr.length;
        int k = 2;
        // option count frequency and get the n/ k comparision and all 
        // option 2
        int cnt = 0;
        int prev = 0;
        for(int i = 0;i<n;i++){
            if(cnt == 0){
                prev = arr[i];
                cnt++;
            }else if(arr[i] == prev) cnt++;
            else if(arr[i] != prev) cnt--;
        }

        int ct = 0;
        for(int x : arr){
            if(x == prev) ct++;
        }
        if(ct>n/k) return prev;
        return -1;
    }

    public static int borismoray(int arr[]){
            int cand = -1;
            int cnt = 0;
            for(int i = 0;i<arr.length;i++){
                if(cnt==0){
                    cand = arr[i];
                    cnt=1;
                }else if(arr[i]==cand)cnt++;
                else{
                    cnt--;
                }
            }
            int ct = 0;
            for(int x : arr){
                if(x==cand) ct++;
            }
            if (ct>arr.length/2){
                return cand;
            }
            return -1;
        }

    public static int[] borismoray11(int arr[]){
        int cand1 = 0;
        int cand2 = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        for(int i = 0;i<arr.length;i++){
            if (arr[i] == cand1) {
                cnt1++;
            }
            else if (arr[i] == cand2) {
                cnt2++;
            }
            else if (cnt1 == 0) {
                cand1 = arr[i];
                cnt1 = 1;
            }
            else if (cnt2 == 0) {
                cand2 = arr[i];
                cnt2 = 1;
            }
            else {
                cnt1--;
                cnt2--;
            }
        }
        int ct1 = 0;
        int ct2 = 0;
        for(int x : arr){
            if(x == cand1) ct1++;
            else if (x == cand2) ct2++;
        }
        int size = 0;
        if(ct1> arr.length/3) size++;
        if(ct2>arr.length/3) size++;
        int ar[] = new int[size];
        int j = 0;
        if (cnt1 > arr.length / 3) {
            ar[j++] = cand1;
        }
        if (cnt2 > arr.length / 3) {
            ar[j++] = cand2;
        }
        return ar;
    }

    




    public static void main(String[] args) {

    }
}
