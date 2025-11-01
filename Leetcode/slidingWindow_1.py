# 3. Longest Substring Without Repeating Characters
class Solution:
    #Establecer dos punteros
    #1er puntero al inicio y 2do puntero avanza hasta encontrar una letra que ya haya aparecido
    #Guardar longitud encontrada si es mayor a la long max guardada
    #Mover puntero 1 a la posición donde apareció la letra coincidente por 1era vez dentro del rango evaluado +1
    #Repetir hasta que puntero 2 llegue al final
    def lengthOfLongestSubstring(self, s: str) -> int:
        slen = len(s)
        if(slen>1):
            punt1 = 0
            punt2 = 1
            maxLong = 0
            records = {s[punt1]:0}
            while(punt2 < slen):
                letter = s[punt2]
                if(letter in records and records[letter]>=punt1):
                    # Mover puntero 1 
                    punt1 = records[letter]+1
                records[letter]=punt2
                #Calcular longitud
                lon = punt2-punt1
                maxLong = max(maxLong, lon+1)
                punt2+=1
            return maxLong    
        else:
            return len(s)