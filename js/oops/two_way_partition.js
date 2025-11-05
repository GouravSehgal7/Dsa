

function Two_Way_partition(arr,a){
    let st = 0;
    let ed = arr.length-1;
    while (ed>st) {
        if(arr[st]>=a && arr[ed]<a){
            let temp = arr[st]
            arr[st] = arr[ed]
            arr[ed] = temp
            st++;
            ed--;
        }
        if(arr[st] <a){
            st++;
        }
        if(arr[ed]>=a){
            ed--;
        }
    }
    console.log(arr);
}
// Two_Way_partition()


function Three_Way_Partition(){
    let arr = [9,1, 33,14, 5, 20, 4, 2, 54, 1,10, 8,5]
    let a = 7
    let b = 14
    let st = 0;
    let ed = arr.length-1;
    Two_Way_partition(arr,a)
    while (st<ed) {
        if(arr[st]>b && arr[ed]<=b){
            let temp = arr[st]
            arr[st] = arr[ed]
            arr[ed] = temp
        }
        if(arr[st] < a || arr[st] <= b ){
            st++
        }
        if(arr[ed]>b){
            ed--
        }  
  
    }
    console.log(arr);
}
// Three_Way_Partition()

// Dutch national flag algo
function DNF(arr,a,b){
    let low = 0;
    let mid = 0;
    let high = arr.length-1;
    while(mid<=high){
        if(arr[mid]<a){
            let temp = arr[mid];
            arr[mid] = arr[low];
            arr[low] = temp;
            mid++;
            low++;
        }else if(arr[mid]<=b && arr[mid]>=a){
            mid++;
        }else{
            let temp = arr[mid];
            arr[mid] = arr[high];
            arr[high] = temp;
            high--;
        }
    }
    console.log(arr);
    
}

let arr = [9,1, 33,14, 5, 20, 4, 2, 54, 1,10, 8,5];
let a = 7;
let b = 14;
DNF(arr,a,b)