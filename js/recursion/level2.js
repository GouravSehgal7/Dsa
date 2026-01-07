class Recursion_problem {

    SubSet(arr=[],newarr=[],i= 0){
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


    


}

let rec = new Recursion_problem();
let val = [1,2,3]
rec.ArrayPermutation(val)

