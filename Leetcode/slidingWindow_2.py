# 1695. Maximum Erasure Value
class Solution:
        #Obj: Encontrar substring con elem. diferentes con mayor suma
        # 1. Iteramos con dos punteros para encontrar cadenas sin repetición
        # Manteniendo track de letras y posiciones en la que se encuentran
        # 2. Actualizar mayor suma si la nueva suma es max
    def maximumUniqueSubarray(self, nums: List[int]) -> int:
        left = 0
        right = 0
        sumaMax = 0
        currentSuma = 0
        track = {}
        for i, elem in enumerate(nums):
            if(elem in track):
                newLeft = track[elem]+1
                # Actualizar current sum y track
                for j in range(left,newLeft):
                    currentSuma -= nums[j]
                    track.pop(nums[j],None)
                left = newLeft
            track[elem]=i # Aniadir al track y currentSuma
            currentSuma += elem 
            if(currentSuma > sumaMax):
                sumaMax = currentSuma
        return sumaMax