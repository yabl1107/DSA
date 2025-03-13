
public class UnionFind {

    // Numero de elementos en union-find
    private int size;

    // Usado para contabilizar el numero de nodos en cada grupo
    private int[] sz;

    // id[i] apunta al padre de i, if id[i] = i then i es raiz
    private int[] root;

    // Lleva cuenta del numero de grupos dentro de union-find
    private int numComponents;

    public UnionFind(int size) {

        if (size <= 0) throw new IllegalArgumentException("Size <= 0 not allowed");

        this.size = numComponents = size; //En un inicio cada elemento es raiz, NroGrupos = NroElementos

        sz = new int[size];
        root = new int[size];

        for (int i = 0; i < size; i++) {
            root[i] = i; //  (self root)
            sz[i] = 1; // Tamaño 1 inicialmente
        }
    }

    // Encontrar a que grupo pertenece 'p'
    public int find(int p) {

        //Encontrar la raiz
        int trav = p;
        while(!(trav==root[trav])){
            trav=root[trav];
        }
        // "Path Compression" -> Los elementos del camino empleado hacia root
        // apuntarán ahora directamente a root.
        // También se puede implementar recursivamente
        // trav es ahora la raiz
        while(p!=trav){
            int next = root[p];
            root[p] = trav;
            p = next;
        }
        return trav;
    }

    // This is an alternative recursive formulation for the find method
    // public int find(int p) {
    //   if (p == root[p]) return p;
    //   return root[p] = find(root[p]);
    // }

    // Verificar si pertenecen al mismo grupo/set
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int componentSize(int p) {
        return sz[find(p)];
    }

    // Numero de elementos en el union-find
    public int size() {
        return size;
    }

    // Numero de grupos o sets
    public int components() {
        return numComponents;
    }

    // Unify the components/sets containing elements 'p' and 'q'
    public void unify(int p, int q) {
        //Utiliza optimización union by size
        //Se puede implementar usando union by rank, donde se compara el recorrido maximo de cada grupo
        //en lugar del numero de elementos que contiene
        //https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3879/

        if(connected(p,q)) return ; //Ya estan en el mismo grupo

        int rootp = find(p);
        int rootq = find(q);

        if(sz[rootp]>sz[rootq]){
            //Unir rootq a rootp
            sz[rootp]+=sz[rootq];
            sz[rootq] = 0;
            root[rootq] = rootp;
        }
        else{ //Unir rootp a rootq
            sz[rootq]+=sz[rootp];
            sz[rootp] = 0;
            root[rootp] = rootq;
        }
        numComponents--;
    }
}