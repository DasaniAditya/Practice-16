// Longest Turbulent Subarray

class Solution {
    public int maxTurbulenceSize(int[] arr) {
        if(arr.length == 0 || arr == null) {
            return 0;
        }
        int result = 0;
        if(arr.length == 1) {
            return 1;
        }
        
        for(int i = 0 ; i < arr.length-1; i++) {
            int temp = 1;
            int j = i+1;
            int count = 0;
            int tempi = i;
            if(arr[i] > arr[j]) {
                count = 0;
            } else {
                count = 1;
            }
            //System.out.print(arr[i]);
            while(j < arr.length && i < arr.length) {
                if(count % 2 == 0 && arr[i] > arr[j]) {
                    temp++;
                    count++;
                } else if(count % 2 != 0 && arr[i] < arr[j]) {
                    temp++;
                    count++;
                } else {
                    
                    break;
                }
                j++;
                i++;
            }
            //System.out.println(" ->"+ temp);
            i = tempi;
            if(temp > result) {
                result = temp;
               // System.out.println("indexi " + i + "->"+ arr[i] +" break " +arr[j] +" indexj " + j);
            }
            result = Math.max(temp , result);
        }
        return result;
    }
}

//Number of visible People in a Queue

class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        if(heights == null || heights.length == 0) {
            return new int[0];
        }
       Stack<Integer> stack = new Stack<>();
	   int[] result = new int [heights.length];
	   for(int i = heights.length - 1; i >= 0; i--) {
		   while(!stack.isEmpty() && heights[i]>stack.peek()) {
			 stack.pop();
			 result[i]++;
		   }
		   if(!stack.isEmpty()){
               result[i]++;
           }
		   stack.push(heights[i]);
	   }
	   return result;
    }
}