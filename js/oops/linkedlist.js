
// node class
class node{
    constructor(integer){
        this.integer = integer;
        this.next = null;
    }
}
class LL {
    // head
    constructor(){
        this.head = null;
        this.cnt = 0;
    }
    isEmpty(){
        return this.head === null;
    }
    AddSt(val) {
        const nn = new node(val);
        if(this.isEmpty()){
            this.head = nn
        }else{
            nn.next = this.head;
            this.head = nn;
        }

    }
    AddEd(val){
        const nn = new node(val);
        if(this.isEmpty()){
            this.head = nn;
            return;
        }
        let st = this.head;
        while(st.next!==null){
            st=st.next;
        }
        st.next = nn
        return;
        
    }
}