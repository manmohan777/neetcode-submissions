class Solution {
    public int[] plusOne(int[] digits) {
        int rem = 1;
        List<Integer> list = new ArrayList();
        for(int i=digits.length-1; i>=0; i--){

            int sum = digits[i]+rem;
            list.add(sum%10);
            rem = sum/10;
        }
        if(rem>0) list.add(rem);
        Collections.reverse(list);
        int res[] = new int[list.size()];
        for(int i= 0; i<list.size(); i++){
            res[i] = list.get(i);
        }
        return res;

    }
}
