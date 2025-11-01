class Solution:
    def subarraysWithKDistinct(self, nums: List[int], k: int) -> int:
        # Obtener los <= k , y luego los <= k-1. La diff es todos los k. Esto dentro de subaary validos
        # Recorrer arreglo con dos punteros mientras set tenga k valores
        # Si llegamos a un valor con k >, entonces ir al menor idx de los caracteres en set
        # a partir de ahí se considerará un nuevo arreglo válido
        #El numero de subarreglos con k-1 elementos son aquellos que incluyan al ultimo elemento (left pointer)
        track = {}
        numArrValidos = 0
        left = 0
        right = 0

        track2 = {}
        numArrValidos2 = 0
        left2 = 0
        right2 = 0


        #Calcular para <= k 
        for i, elem in enumerate(nums):
            
            track[elem]=i
            
            if(len(track)>k): #Array no valido, convertir a valido
                minKey = min(track, key=track.get)
                left = track[minKey]+1
                track.pop(minKey) #Volvemos a tener k elementos
            #Contar subarrays <=k en array valido
            valid = right - left +1
            numArrValidos+=valid

            right+=1

            track2[elem]=i

            if(len(track2)>k-1): #Array no valido, convertir a valido
                minKey = min(track2, key=track2.get)
                left2 = track2[minKey]+1
                track2.pop(minKey) #Volvemos a tener k elementos
            #Contar subarrays <=k en array valido
            valid2 =right2 -left2 +1
            numArrValidos2+=valid2
            right2+=1

        return numArrValidos-numArrValidos2
