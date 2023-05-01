class Solution {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        double avg = 0;
        for(int i = 0; i < salary.length; i++){
            if(salary[i] < min){
                min = salary[i];
            }
            if(salary[i] > max){
                max = salary[i];
            }
            
            avg+= salary[i];
        }
        
        avg = (avg - min - max) / (salary.length - 2);
        
        return avg;
    }
}