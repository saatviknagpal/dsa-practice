class Solution {
    public int largestRectangleArea(int[] arr) {
    int[] rightBoundary = new int[arr.length];
    Stack<Integer> st = new Stack<>();
    st.push(arr.length-1);
    rightBoundary[arr.length-1] = arr.length;

    for(int i = arr.length - 2; i >= 0; i--){
       while(st.size() > 0 && arr[i] <= arr[st.peek()]){
          st.pop();
       }
       if(st.size() == 0){
          rightBoundary[i] = arr.length;
       } else { 
          rightBoundary[i] = st.peek(); 
       }
       st.push(i);
    }

    int[] leftBoundary = new int[arr.length];
    st = new Stack<>();
    st.push(0);
    leftBoundary[0] = -1;
    for(int i = 1; i  < arr.length; i++){
       while(st.size() > 0 && arr[i] <= arr[st.peek()]){
          st.pop();
       }
       if(st.size() == 0){
          leftBoundary[i] = -1;
       } else { 
          leftBoundary[i] = st.peek(); 
       }
       st.push(i);
    }

    int maxArea = 0;
    for(int i =0; i < arr.length; i++){
       int width = rightBoundary[i] - leftBoundary[i] - 1;
       int area = arr[i] * width;
       if(area > maxArea){
          maxArea = area;
       }
    }
    return maxArea;
    }
}