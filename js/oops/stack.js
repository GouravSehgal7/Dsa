class Stack{
    constructor(){
        this.arr = [];
        this.minelem = [];
        this.min = 10000000000000000000000000n;
    }
    isEmpty(){
        return this.arr.length === 0;
    }
    add(val){

        this.arr.push(val);
        // this will work only if no element is removed
        if(this.peek() !== null){
            const num = this.peek()
            this.min = Math.min(val,num)
        }else{
            this.min = val
        }

        // for allowing min elem to be discovered while pop of elem use this
        if(this.arr[this.arr.length-1] == null || val<this.arr[this.arr.length -1]){
            this.minelem.push(val)
        }

        
        return;
    }
    peek(){
        return this.arr[this.arr.length -1];
    }
    pop(){
        if(this.isEmpty()!==false) return null;
        if(this.minelem[this.minelem.length-1] === this.arr[this.arr.length-1]){
            this.minelem.pop()
        }
        this.arr.pop()
    }
    getmin(){
        return this.minelem[this.minelem.length-1]
    }
    
}