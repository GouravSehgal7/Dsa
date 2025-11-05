

function printoneton(i,n){
    if(i>n) return;
    printoneton(i+1,n)
    console.log(i)
}

function arrayprint(i,arr) {
    if(i == arr.length) return;
    arrayprint(i+1,arr)
    console.log(arr[i]);
}

function sumoneton(i,n,sum) {
    if(i >n) return sum;
    console.log(i);
    sum=sum+i
    return sumoneton(i+1,n,sum)
}

function sumarray(i,arr,sum) {
    if(i==arr.length) return sum
    let s = arr[i]
    sum = sum+s
    return sumarray(i+1,arr,sum)
}

function lltraverse(head) {
    let node = head
    console.log(node.val);
    lltraverse(node.next)
}

function reversearray(i,array) {
    if(i>=array.length/2){
        console.log(array);
        return
    }
    [array[i],array[array.length -i-1]] = [array[array.length-i-1],array[i]]
    reversearray(i+1,array)
}

function digitinnumber(num){
    if(num<1) return;
    let n = Math.floor(num%10);
    num = num/10
    console.log(n);
    digitinnumber(num)
}

// let arr = [1,2,3,4,5,6]
// let s = "abcdefghijklmnopqrstuvwxyz"

let num = 12302;
digitinnumber(num)

// console.log(s);


