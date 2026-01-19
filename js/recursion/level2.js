class Recursion_problem {

    SubSetPrint(arr=[],newarr=[],i= 0){
        // base case
        if(i==arr.length){
            console.log(newarr);
            return;
        }
        // program
        // include
        let val = arr[i];
        newarr.push(val)
        // recursion
        this.SubArray(arr,newarr,i+1);
        // backtrack
        // exclude
        newarr.pop()
        // exclude backtrack
        this.SubArray(arr,newarr,i+1);
    }

    SubsetArray(arr = [],newarr = [],final = [], i = 0){
        if(i === arr.length){
            final.push([...newarr]);
            return
        }
        newarr.push(arr[i])
        this.SubsetArray(arr,newarr,final,i+1)
        newarr.pop();
        this.SubsetArray(arr,newarr,final,i+1)
    }

    SubArray(arr=[],newarr=[],st = 0,ed = 0){
        if(st == arr.length){
            return;
        }
        if (ed === arr.length) {
            this.SubArray(arr, [], st + 1, st + 1);
            return;
        }
        newarr.push(arr[ed]);
        console.log(newarr);
        this.SubArray(arr,newarr,st,ed+1);
    }

    ArrayPermutation(arr=[],i=0,out=[]){
        // base
        if(i>=arr.length){
            out.push([...arr]);
            console.log(out);
            return;
        }
        for (let j = 0; j <arr.length; j++) {
            [arr[i],arr[j]] = [arr[j],arr[i]]
            this.ArrayPermutation(arr,i+1,out);
            [arr[i],arr[j]] = [arr[j],arr[i]]
        }
    }

    SubsequencesString(s="",ar=[],r="",i=0){
        if(i === s.length){
            ar.push(r)
            return;
        }
        r+=s[i];
        this.SubsequencesString(s,ar,r,i+1);
        r = r.substring(0, r.length - 1);
        this.SubsequencesString(s,ar,r,i+1);
    }

    PermuttionString(s = "",arr = [],r = "",i = 0){

    }
    
}

let rec = new Recursion_problem();
let val = [1,2,3]

s = "abc"
ar  = [];
rec.SubArray(val,ar)
// console.log(ar)

