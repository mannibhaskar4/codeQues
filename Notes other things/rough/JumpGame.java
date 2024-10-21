class JumpGame{
    public static boolean canJump(int[] n) {
        // for(int i=0;i<nums.length;i++){

        // }
        int i=0;
        while(i<n.length){
            if(n[i]==0&&i!=n.length-1){
                return false;
            }
            i=n[i]+i;
            if(i==n.length-1){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int a[]={1};
        System.out.println(canJump(a));
    }


}