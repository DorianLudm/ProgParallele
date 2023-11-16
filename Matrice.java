import java.util.ArrayList;
import java.util.List;

public class Matrice{
    public int n;
    public int[][] matrice;

    public Matrice(int n){
        this.n = n;
        this.matrice = new int[n][n];
    }

    public void initialisation(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matrice[i][j] = (int)(Math.random() * 100);
            }
        }
    }

    public void afficher(){
        n = getN();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(matrice[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    public int[][] getMatrice(){
        return this.matrice;
    }

    public int getN(){
        return this.n;
    }

    public void setMatrice(int[][] matrice){
        this.matrice = matrice;
    }

    public void setCase(int i, int j, int val){
        this.matrice[i][j] = val;
    }

    public int getCase(int i, int j){
        return this.matrice[i][j];
    }

    public int[][] multiplier(Matrice m){
        int[][] matrice = m.getMatrice();
        int[][] matriceResultat = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int res = 0;
                for(int k = 0; k < n; k++){
                    res += this.matrice[i][k] * matrice[k][j];
                }
                matriceResultat[i][j] = res;
            }
        }
        return matriceResultat;
    }

    public int[][] multiplierPar(Matrice m) throws InterruptedException{
        Matrice matriceResultat = new Matrice(n);
        List<Thread> listeThread = new ArrayList<>();
        for(int i = 0; i < n; i++){
            ThreadLigne thread = new ThreadLigne(this, m, matriceResultat, i);
            thread.start();
        }
        for(Thread elem: listeThread){
            elem.join();
        }
        return matriceResultat.getMatrice();
    }
}