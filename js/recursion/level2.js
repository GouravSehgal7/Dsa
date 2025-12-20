class Recursion_problem {

    partitionElementArray(arr,resopnce){
        // base case

        // program

        // recursion
        
        // backtrack logic

    }

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
        // this.SubArray(arr,[],st+1,st+1)
    }

    ArrayPermutation(arr=[]){
        // base

        // program

        // recursion

        // backtrack logic

    }

}
let rec = new Recursion_problem();
let val = [1,2,3]
rec.SubArray(val)

