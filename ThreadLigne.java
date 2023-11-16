public class ThreadLigne extends Thread{
    private Matrice matrice1, matrice2, matriceRes;
    private int numLigne;

    public ThreadLigne(Matrice matrice1, Matrice matrice2, Matrice matriceRes, int numLigne){
        this.matrice1 = matrice1;
        this.matrice2 = matrice2;
        this.matriceRes = matriceRes;
        this.numLigne = numLigne;;
    }

    public void run(){
        int n = this.matrice1.getN();
        for(int j = 0; j < n; j++){
            int res = 0;
            for(int k = 0; k < n; k++){
                res += this.matrice1.getCase(numLigne, k) * this.matrice2.getCase(k, j);
            }
            this.matriceRes.setCase(numLigne, j, res);
        }
    }
}
