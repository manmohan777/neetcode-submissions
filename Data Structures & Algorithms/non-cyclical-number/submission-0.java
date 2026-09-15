class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet();
        while(n>1){
            int temp = n;                  //2
            int sum = 0;                  
            while(temp>0){
                int digit = temp%10;       //2  
                sum += (digit*digit);      //sum = 4
                temp=temp/10;              //2     
            }
            if(set.contains(sum)) return false;
            set.add(sum);
            n=sum;
        }
        return true;
    }
}
