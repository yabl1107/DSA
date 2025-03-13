#LeetCode 547. Number of Provinces
class UnionFind:
    def __init__(self,size):
        self.root = [i for i in range(size)] #Inicialmente apuntando a uno mismo
        self.rank = [1]*size #Todos los grupos de tam 1
    
    def find(self,i):
        if(self.root[i]==i):
            return i
        else:
            self.root[i] = self.find(self.root[i]) #Path Compression
            return self.root[i]
    
    def connected(self,p,q):
        root1 = self.find(p)
        root2 = self.find(q)
        return root1==root2

    def union(self,p,q):
        if(self.connected(q,p)):
            return #Pertenecen al mismo grupo
        if(self.rank[p]>self.rank[q]):
            # p será raiz y rank[p] no será afectado
            self.root[q] = p
        elif(self.rank[q]>self.rank[p]):
            self.root[p] = q
        else:
            #Son iguales, cualquiera será raiz y el rank aumenta en 1
            self.root[p] = q
            self.rank[p]+=1

        
        

