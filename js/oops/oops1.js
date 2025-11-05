class Human{
    Name;
    Age;
    Gender;
    #Bankbalance;
    constructor(Name,Age,Gender,Bankbalance){
        this.Name = Name;
        this.Age = Age;
        this.Gender = Gender;
        this.#Bankbalance = Bankbalance;
    }
    #doTask=(a,v,w)=>{
        return a*(Math.pow((v+w),2))
    }
}

class Student extends Human{
    Class;
    rollno;
    Admission;
    #secretno
    constructor(Name,Age,Class,rollno,Admission,secretno){
        super(Name,Age);
        this.Class = Class;
        this.rollno = rollno;
        this.Admission = Admission;
        this.#secretno = secretno;
    }
    printall = ()=>{
        console.log(this.Name,this.Age,this.Class,this.Gender,this.Admission,this.#secretno);
    }
}





let main = ()=>{
    const hm = new Human("Eevan",20,"M",2342343)
    console.log(hm.Age);
    console.log(hm.Name);
    console.log(hm.doTask(1,1,1));
    const student = new Student("eevan",10,"2nd",2,2345,343)
    let arr = []
    arr.push(hm,hm)
    console.log(arr);
}


main()
