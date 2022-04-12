class Solution:
    def canMakeArithmeticProgression(self, arr: List[int]) -> bool:
     
        
        #d , z = 0, 0 
        
        re = False
        
        if len(arr) <2:
            return re
        arr.sort()
        print(arr)
        
        d = (max(arr) - min(arr))//(len(arr)-1)
        
        for i in range(len(arr)-1,-1,-1):
           # print("i",arr[i])
            #print("i-1",arr[i-1])
            
            arr[i] = arr[i]-arr[i-1]
            
            if(i==0):
                arr[i] = d
            
        
        print("sec",arr)
        print("min", min(arr))
        print("max", max(arr))
        
        if min(arr)==0 and max(arr)==0 and d==min(arr) and d==max(arr):
            
            re = True
            return re
            
        for i in range(len(arr)-1,-1,-1):
            
            if(arr[i]==arr[i-1] and d==arr[i]):
                re = True
                continue
                #break
                
            else:
                re = False
                break
            
        return re
                
