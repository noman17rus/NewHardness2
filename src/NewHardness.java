public class NewHardness {



    int vol=50;
    double trillonB=0.00971; //концентрация триллона Б
    float volimeHARD1=11; // объём триллона Б ушедший на титрование жесткости
    float volimeHARD2=11; // объём триллона Б ушедший на титрование жесткости
    float volumecalcium1= (float) 6.5; // объём триллона Б ушедший на титрование Кальция
    float volumecalcium2= (float) 6.5;// объём триллона Б ушедший на титрование Кальция

    static double deltaHardness (double i) {
        return i*0.09;
    }

    double concHardness() {
        return (((2 * volimeHARD1 * trillonB * 1000) / vol) + ((2 * volimeHARD2 * trillonB * 1000) / vol)) / 2;
    }

    double concCalcium() {
        return (((40.08*trillonB*volumecalcium1*1000)/vol)+((40.08*trillonB*volumecalcium2*1000)/vol))/2;
    }
    double concMagmium () {
        return ((((volimeHARD1-volumecalcium1)*trillonB*24.32*1000)/vol)+(((volimeHARD2-volumecalcium2)*trillonB*24.32*1000)/vol))/2;
    }



    public static void main (String[] args) {
        NewHardness proba = new NewHardness();
        double vol1 = proba.concHardness();  //концентрация жесткости
        double vol2 = proba.concCalcium();   //концентрация кальция
        double vol3 = proba.concMagmium();   //концентрация магния
        double deltaH = deltaHardness(vol1); //погрешность жесткости

        System.out.println("результат равен " +vol1 + " погрешность равна " +deltaH);
        System.out.println(vol2);
        System.out.println(vol3);
    }



}
