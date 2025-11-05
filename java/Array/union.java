public class union {

    public int[] unionArray(int[] nums1, int[] nums2) {
        
        // via stack avoid duplicate number
        // one array and one stack only one pass
        Stack<Integer> st = new Stack<>();
        int cnt = 0;
        int ptr1 = nums1.length-1;
        int ptr2 = nums2.length-1;
        while(ptr1 >= 0 || ptr2 >= 0){
            
            if(ptr1 >= 0 && ptr2 >= 0 ){
                if(st.isEmpty()){

                    if(nums1[ptr1]>=nums2[ptr2]){
                        st.push(nums1[ptr1])
                        ptr1--;
                        cnt++;
                    }else{
                        st.push(nums2[ptr2])
                        ptr2--;
                        cnt++;
                    }

                }else{
                    
                    if(nums1[ptr1]>=nums2[ptr2]){
                        int val = nums1[ptr1]
                        if(val != st.peek()) {
                            st.push(val);
                            cnt++;
                        }
                        ptr1--;
                    }else{
                        int val = nums2[ptr2]
                        if(val != st.peek()) {
                            st.push(val);
                            cnt++;
                        }
                        ptr2--;
                    }

                }
            }else if(ptr1<0){
                if(st.isEmpty()){
                    st.push(nums2[ptr2]);
                    ptr2--;
                    cnt++;
                    return;
                }
                int val = nums2[ptr2]
                if(val != st.peek()) {
                    st.push(val);
                    cnt++;
                }
                ptr2--;
            }else if(ptr2<0){
                if(st.isEmpty()){
                    st.push(nums1[ptr1]);
                    ptr1--;
                    cnt++;
                    return;
                }
                int val = nums1[ptr1]
                if(val != st.peek()) {
                    st.push(val);
                    cnt++;
                }
                ptr1--;
            }
        }

        int ar[] = new int[cnt];
        int i = 0;
        while(!st.isEmpty()){
            int val = st.pop();
            ar[i] = val;
            i++;
        }
        
        // via one set and one array
    }

    
    
}
