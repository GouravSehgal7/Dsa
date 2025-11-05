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

function linearRecursive(array,i,max) {
    if(i == array.length) return max;
    max = Math.max(max,array[i]);
    return linearRecursive(array,i+1,max);
}

function xtothepowern(x,n,ans,cntr) {
    if(cntr == n){
        console.log(x," to the power ",n," is ",ans);
        return
    }
    ans = ans *x;
    cntr++;
    xtothepowern(x,n,ans,cntr)
}

function binarysearch(arr,sti,ede,target) {
    if (sti > ede) return false;
    const midi = Math.floor((sti+ede)/2);
    if(arr[midi] === target){
        return true;
    }else if(arr[midi]>target){
        ede = midi-1;
        return binarysearch(arr,sti,ede,target);
    }else if(arr[midi]<target){
        sti=midi+1;
        return binarysearch(arr,sti,ede,target);
    }else{
        return false
    }
}



let arr = [1,23,3,4,5,6]
// let s = "abcdefghijklmnopqrstuvwxyz"

// let num = 12302;
// let m = linearRecursive(arr,0,arr[0]);
// console.log(m);
// xtothepowern(2,10,1,0);
let isnum = binarysearch(arr,0,arr.length-1,5)
console.log(isnum);



// digitinnumber(num)

// console.log(s);


