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
        //Dette er bare en konstant.
        int multiplier = 2;
        //dette er vores float som kun bliver brugt i mellem regningerne, denne bliver typecasted til int result længere nede.
        float result = 0;
        //Her vælger vi og tage carportens indtastede længde og minuser det med, det stykke som den foreste og bagerste stolpe skal sidde inde.
        actualLength = ((int)length - frontPost - backPost);
        //Her tager vi minimums kravet til spacing mellem hver stolpe og dividerer det med den faktiske længde på vore carport
        result = (minimumPostSpacing / actualLength);
        //her tager vi og runder result op til det tætteste hel tal.
        Math.round(result);
        //Her ganger vi med 2 så vi får begge sider med af carporten.
        result = (result * multiplier);
        //Nu typecaster vi vores result som er en float om til en int.
        int numberOfPosts = (int)result ;
        //Dett her er det endelige resultat.
        return numberOfPosts;
    }

    //TODO: Evt. sætte en maks længde på de bjælker der er på lageret.
    //TODO: fks. hvis længden på carporten er 800cm men vi kun tilbyder 600cm bjælker skal der være 2x af 600cm og 2x af 200cm.
    public int calcBeams (double length) {

        //Dette er bare en konstant.
        int multiplier = 2;
        //Dette er vores endelige resultat.
        int numberOfBeams;
        //Vi tager bare ganger længden med 2, så vi har begge sider af vores carport.
        //Vi går ud fra at lageret altid har den længde bjælke på lager der skal bruges.
        numberOfBeams = ((int)length * multiplier);

    return numberOfBeams;
    }

    //TODO: Kundens indtastede width til sin carport skal matche med den witdh vores spær har.
    public int calcRafters (double width, double length) {

        //Dette er afstanden der skal være imellem hver spær.
        double rafterSpacing = 0.55;
        //Dette er længden af vores spær. Dette skal helst være lig med den længde der bliver givet til carporten.
        int lengthOfRafters;
        //Dette er det endelige resultat.
        int numberOfRafters;
        //Vi tager bare og dividerer længden med, den bestemte afstand der skal være, for at få antal spær.
        numberOfRafters = ((int)length / (int)rafterSpacing );

        return numberOfRafters;
    }
}
