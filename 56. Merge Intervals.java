class Solution {
  public int[][] merge(int[][] intervals) {
      Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
      LinkedList<int[]> list=new LinkedList<>();
      for(int[] a:intervals){
          if(list.isEmpty()||list.getLast()[1]<a[0]){
              list.add(a);
          }else{
              list.getLast()[1]=Math.max(a[1],list.getLast()[1]);
          }
      }
      return list.toArray(new int[list.size()][2]);
  }
}
