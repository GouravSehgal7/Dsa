public class viras {

    public static void countVirus(int a,int b, int c){
        // a = days
        // b = grow by 1 after b days
        // c =  killed on c dat
        int virus = 1;

        for(int i = 1; i <= a;i++){
            if(i%b == 0){
                virus*=2;
            }else if(i%c == 0){
                virus/=2;
            }
        }
        System.out.println(virus);
        return;
    }

    public static void main(String[] args) {
        countVirus(5, 1, 5);
    }
}


// docker
// nix
// e2b
// webcontainer
// webassembly
