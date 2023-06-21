class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int result =0;
        for(int i=1;i<=mainTank;i++){
            if(additionalTank!=0 && i%5==0){
                additionalTank-=1;
                result+=10;
                mainTank+=1;
            }
            else{
                result+=10;
            }
        }
        return result;
     }
}