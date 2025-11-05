class Human{
    name;
    age;
    gender;
    constructor(name,age,gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}


class student extends (Human,result){
    #admissionno;
    Typeof;
    sem;
    constructor(name,age,gender,Typeof,sem,admissionnumber){
        super(name,age,gender);
        this.Typeof = Typeof;
        this.#admissionno =admissionnumber;
        this.sem = sem;
    }
    getdata = ()=>{
        console.log(this.name,this.age,this.gender,this.sem,this.Typeof);
    }

    getadmissionNo=()=>{
        console.log(this.#admissionno);
    }

}


class subjectwisemarks{
    admissionnumber;
    subjectname;
    marks;
    constructor(admissionnumber,subjectname,marks){
        this.marks = marks;
        this.admissionnumber = admissionnumber;
        this.subjectname =subjectname;
    }
}

class result extends subjectwisemarks{
    admissionnumber;
    sem;
    gpa;
    constructor(admissionnumber,sem,gpa){
        
    }
}

class teacher extends Human{
    elegibility;
    coursesAssigned;
    classAssigned;
    department
    #salary;
    constructor(name,age,gender,elegibility,coursesAssigned,classAssigned,department,salary){
        super(name,age,gender);
        this.elegibility = elegibility;
        this.coursesAssigned = coursesAssigned;
        this.classAssigned = classAssigned;
        this.department = department;
        this.#salary = salary;
    }

    getdata = ()=>{
        console.log(this.name,this.age,this.gender,this.elegibility,this.coursesAssigned,this.classAssigned,this.department);
    }

    getselary = ()=>{
        console.log(this.#salary);
    }
}


class room{
    id;
    allocatedto;
    space_count_room;
}


class hostal extends room{
    name;
    id;
    location;
    wardname;
    type;
    room_count;
}



let st = new student("Eevan",20,"M","Dayscholer",4,342234)
st.getdata()