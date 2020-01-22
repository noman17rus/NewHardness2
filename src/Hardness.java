public class Hardness {

    public static void main (String args[]){

        int volume=50; //объём пробы
        double concentration=0.00971; // концентрация трилона Б
        float volimeHARD1= (float) 7.9;
        float volimeHARD2= (float) 8.0;
        float volumecalcium1= (float) 3.5;
        float volumecalcium2= (float) 3.6;
        float hardRES=0;
        float calciumRES;
        float magnesiumRES;

        hardRES = (float)(((2*volimeHARD1*concentration*1000)/volume)+((2*volimeHARD2*concentration*1000)/volume))/2;
        calciumRES = (float)(((40.08*concentration*volumecalcium1*1000)/volume)+((40.08*concentration*volumecalcium2*1000)/volume))/2;
        magnesiumRES = (float)((((volimeHARD1-volumecalcium1)*concentration*24.32*1000)/volume)+(((volimeHARD2-volumecalcium2)*concentration*24.32*1000)/volume))/2;

        float normHARD = (float) (hardRES * 0.06);
        float normCalc;
        if (calciumRES<=2) {
            normCalc = (float) (calciumRES*0.22);
        } else {
            if (calciumRES <=10){
                normCalc = (float) (calciumRES*0.14);
            } else {
                normCalc = (float) (calciumRES*0.08);
            }
        }
        float normMagnesium = (float) (magnesiumRES*0.02);
        float deltaHard = Math.abs(volimeHARD1-volimeHARD2);
        float deltaCalc = Math.abs(volumecalcium1 - volumecalcium2);
        float deltaMagnesium = (float)Math.abs((((volimeHARD1-volumecalcium1)*concentration*24.32*1000)/volume)-(((volimeHARD2-volumecalcium2)*concentration*24.32*1000)/volume));

        boolean truecalc;
        boolean trueHard;
        boolean truMagnesium;
        if (deltaHard<=normHARD){
            trueHard = true;
        } else trueHard = false;
        if (deltaCalc<=normCalc){
            truecalc = true;
        } else truecalc = false;
        if (deltaMagnesium <= normMagnesium){
            truMagnesium = true;
        } else truMagnesium = false;

        float pogreshnost;
        if (calciumRES <= 2) {
            pogreshnost = (float)(calciumRES*0.25);
        } else {
            if (calciumRES <=10) {
                pogreshnost = (float)(calciumRES*0.15);
            } else {
                pogreshnost = (float)(calciumRES *0.11);
            }
        }

        if (trueHard == true && truecalc == true && truMagnesium == true) {
            System.out.println("Жесткость " +hardRES +" погрешность " +(float)(hardRES*0.09));
            System.out.println("Кальций " +calciumRES +" погрешность " +pogreshnost);
            System.out.println("Магний " +magnesiumRES +" погрешность " +(float)(magnesiumRES*0.02));
        } else System.out.println("не удовлетворяет условию сходимости");
    }
}
