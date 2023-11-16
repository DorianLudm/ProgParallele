public class Executable{
    public static void main(String[] args){
        Integer n = Integer.parseInt(args[0]);
        Integer nbMatrice = Integer.parseInt(args[1]);

        //Calcul du temps d'éxécution séquentiel
        long startTime = System.currentTimeMillis();

        for(int i = 0; i < nbMatrice; i++){
            Matrice m1 = new Matrice(n);
            Matrice m2 = new Matrice(n);
            m1.initialisation();
            m2.initialisation();
            m2.multiplier(m1);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("That took " + (endTime - startTime) + " milliseconds");
        //n = 1000 en séquentiel: Pour 10 mesures, on as un average de 1.2400sec


        //Calcul du temps d'éxécution parallèle
        startTime = System.currentTimeMillis();

        for(int i = 0; i < nbMatrice; i++){
            Matrice m1 = new Matrice(n);
            Matrice m2 = new Matrice(n);
            m1.initialisation();
            m2.initialisation();
            try {
                m2.multiplierPar(m1);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        endTime = System.currentTimeMillis();
        System.out.println("That took " + (endTime - startTime) + " milliseconds");
        //n = 1000 en parallèle: Pour 10 mesures, on as un average de 0.6329sec
    }
}