public class Oaquestion {
    

    public static boolean solve1(String s1, String s2, String s3, int ps1 , int ps2, int ps3, Boolean dp[][]){
        if(ps3 >= s3.length()){
            return true;
        }
        if(dp[ps1][ps2] != null){
            return dp[ps1][ps2];
        }
        boolean v1 = false;
        boolean v2 = false;
        if(ps1 < s1.length()){
            if(s1.charAt(ps1) == s3.charAt(ps3)){
                v1 = solve1(s1, s2, s3, ps1+1, ps2, ps3+1,dp);
            }
        }
        if(ps2 < s2.length()){
            if(s2.charAt(ps2) == s3.charAt(ps3)){
                v2 = solve1(s1, s2, s3, ps1, ps2+1, ps3+1,dp);
            }
        }
        return dp[ps1][ps2]=  v1 || v2;
    }
    
    
    public static void main(String[] args) {
        String s1 = "ambcd";
        String s2 = "fgbkd";
        String s3 = "afmgbkbdcd";
        if(s1.length() + s2.length() != s3.length()){
            System.out.println(false);
        }else{
            Boolean dp[][] = new Boolean[s1.length()+1][s2.length()+1];
            boolean b = solve1(s1, s2, s3, 0, 0, 0,dp);
            System.out.println(b);
        }

    }
}
