class  BasicMath {
    // LCM(a,b){

    // }


    // greatest number which divide both a and b
    // 16, 4 = 4
    // algo 1: - pick up smaller number and start dividing both
    GCD1(a,b){
        if (a === 0 || b === 0) return Math.max(a, b);
        for(let i = Math.min(a,b);i>0;i--){
            if(a%i == 0 && b%i==0){
                console.log(i);
                return i;
            }
        }
        return 0;
    }

    // subtract small from large every time and any one become 0 then other will be the gcd
    GCD2(a,b){
        if (a === 0 || b === 0) return Math.max(a, b);
        if(a>b){
            a = a-b;
        }else{
            b=b-a;
        }
        return this.GCD2(a,b);
    }


}


let math = new BasicMath()
let o = math.GCD2(4,16)
console.log(o);
