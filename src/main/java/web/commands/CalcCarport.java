package web.commands;

public class CalcCarport {

    //TODO: Vi skal have 2 resultater med ... måske?
    //TODO: Noget ifht. hvor høje vores stolper er, vi har udregnet hvor mange der skal bruges men intet med højden?
    //TODO: Går vi udfra at vi kun har X antal stolper af 300 cm?
    public int calcPosts ( double length) {

        //Den foreste stolpe skal sidde en meter inde.
        int frontPost = 100;
        //Den bagerste stolpe skal sidde 20 cm meter inde.
        int backPost = 20;
        //dette er den faktiske længde efter vi har minusset med 'frontpost' og 'backpost'.
        int actualLength = 0;
        //Dette er minimums kravet for hvor meget plads der skal være mellem hver stolpe.
        int minimumPostSpacing = 310;
        //dette er vores float som kun bliver brugt i mellem regningerne, denne bliver typecasted til int result længere nede.
        float calc = 0;
        //Her vælger vi og tage carportens indtastede længde og minuser det med, det stykke som den foreste og bagerste stolpe skal sidde inde.
        actualLength = ((int)length - frontPost - backPost);
        //Her tager vi minimums kravet til spacing mellem hver stolpe og dividerer det med den faktiske længde på vore carport
        calc = (minimumPostSpacing / actualLength);
        //her tager vi og runder result op til det tætteste hel tal.
        Math.round(calc);
        //Her ganger vi med 2 så vi får begge sider med af carporten.
        calc = (calc * 2);
        //Nu typecaster vi vores result som er en float om til en int.
        int result = (int)calc ;
        //Detter er det endelige resultat.
        return result;
    }

    public int calcBeams () {


    }


    //Beams

    //rafters

}
