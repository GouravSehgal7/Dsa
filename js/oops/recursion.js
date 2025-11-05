

function sum(n) {
    if(n==0 || n == 1){
        return 1;
    }
    let x = n+sum(n-1)
    let y = n*sum(n-1)
    return {x,y}
}

let {x,y} = sum(5) 
console.log(x);
console.log(y);

