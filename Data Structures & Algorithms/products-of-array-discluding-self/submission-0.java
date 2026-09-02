class Solution {
    public int[] productExceptSelf(int[] nums) {
        /*
         MY TOUGHTS:

         approach 1: 1.1 we can product the a*b*c and total/nums[i] , problem when it was zero(0) - add additional condition 
                     1.2 if it contains more than one zeros we can return zero 
         approach 2: prefix sum and suffix sum 
        


        Notes:

        Prefix & Suffix — How to Identify

Main idea: Prefix/Suffix is used when the answer for an index i depends on information from the elements before or after that index. When solving an array problem, ask: “Do I need information from the LEFT, RIGHT, or BOTH sides of i?” If I repeatedly calculate something on the left/right using a loop, prefix/suffix can often reduce the time complexity from O(n²) to O(n) by precomputing the required information.

🔑 Remember
LEFT / BEFORE i → PREFIX
RIGHT / AFTER i → SUFFIX
LEFT + RIGHT → PREFIX + SUFFIX
Before every index → Think Prefix
After every index → Think Suffix
Maximum/Minimum on the left → Prefix Max/Min
Maximum/Minimum on the right → Suffix Max/Min
Sum on the left/right → Prefix/Suffix Sum
Product on the left/right → Prefix/Suffix Product
Many range-sum queries → Prefix Sum
If I see nested loops repeatedly scanning left/right → Ask “Can Prefix/Suffix optimize this?”
Prefix/Suffix is not only for sums; it can store sum, product, maximum, minimum, count/frequency, etc.
🧠 Quick Mental Trick
              i
              ↓
[ LEFT SIDE | i | RIGHT SIDE ]

    PREFIX         SUFFIX

Memory sentence:

“Looking backward → Prefix. Looking forward → Suffix. Looking both ways → Prefix + Suffix.”

🚨 Before Coding

Ask these 3 questions:

What information do I need for index i?
Does it come from the left, right, or both?
Am I repeatedly calculating that information? If yes, precompute it using Prefix/Suffix.

Examples:

Left sum + Right sum → Prefix/Suffix
Product Except Self → Prefix + Suffix
Maximum on left + maximum on right → Prefix Max + Suffix Max
Range sum queries → Prefix Sum
“All elements before i” → Prefix
“All elements after i” → Suffix
        
        */
        
        int zeroscount = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0) zeroscount++;
        }
        if (zeroscount > 1) 
        {
            Arrays.fill(nums, 0);
            return nums;
        }


        int prefix [] = new int[nums.length];
        prefix[0] = 1;

        int prod = 1;
        for(int i=1;i<nums.length; i++){
            prod*= nums[i-1];
            prefix[i] = prod;
        }
        int sufix[] = new int[nums.length];
        sufix[nums.length-1] = 1;
        int prod1 = 1;
        for(int i = nums.length -1 ; i>0; i--){
            prod1 *= nums[i];
            sufix[i-1] = prod1;
        }
        for(int i=0; i<nums.length; i++){
            nums[i] = prefix[i]*sufix[i];
        }
        return nums;

        

        


        
    }
}  
