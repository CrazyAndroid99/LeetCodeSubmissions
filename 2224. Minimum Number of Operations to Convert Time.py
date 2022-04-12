class Solution:
    def convertTime(self, current: str, correct: str) -> int:
        
        #increase = [1,5,15,60]
        #2:30 to 4:35 - 60, 60, 5
        #2:30 to 4 : 55 - 60 ,60 , 15 ,5,5
        
        #start from max - 60
        
        h1, m1 = current.split(":")
        h2, m2 = correct.split(":")
        
        h= int(h2) - int(h1)
        m = int(m2) - int(m1)
        
        #tot = (hours * 60)+ minutes
        
        ans = 0
        
        if m<0:
            h-=1
            m+=60
            
        ans = m//15
        m%=15
        b = m//5
        m%=5
        
            
            
            
            
        
        return ans+b+h+m
