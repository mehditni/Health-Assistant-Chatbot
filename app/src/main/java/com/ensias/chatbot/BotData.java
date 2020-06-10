package com.ensias.chatbot;

import android.view.View;

import java.util.ArrayList;
import java.util.Random;

public class BotData {
    public static int state = 0; // 1 begin, 2 diagnostic, 3 finish!

    public static int BotStep = 0;
    /** Dictionnaire **/
    private static String HELLO = "Bonjour,salut,slt,bjr,bonsoir,hola,afin,salam,salu,bonjr,bnjr,salt";
    private static String THANKYOU = "Bonjour,salut,slt,bjr,bonsoir,hola,afin,salam,salu,bonjr,bnjr,salt";

    private static String rhume = "fièvre,chaud,mal,gorge,éternuements,écoulement,nasal,légère,fatigue,rouge,fatigué";
    private static String allergie = "plaques,rouges,blanches,peau,démangeaisons,enflure,yeux,respiration,sifflante,nez,pique,nez,coule,serrement,gorge";
    private static String asthme = "difficulté,respirer,essoufflement,dyspnée,respiration,sifflante,sensation,serrement,oppression,thoracique,toux,sèche";
    private static String arthrite = "douleur,raideur,articulation,enflure,rougeur,articulations";
    private static String cystite = "douleurs,brûlures,urinant,fréquence,anormalement,élevée,mictions,sentiment,persistant,uriner,urines,troubles,odeur,désagréable,pesanteur,bas-ventre,sang,l’urine,fièvre";
    private static String depression = "humeur,dépressive,perte,d'intérêt,plaisir,quasiment,activités,fatigue,manque,énergie,agitation,problèmes,sommeil,appétit,gain,poids,diminution,perte,intérêt,sexuel";
    private static String diabète = "augmentation,soif,faim,perte,poids,vision,floue,engourdissement,fourmillement,mains,pied";
    private static String fiévre = "état,fébrile,douleurs,musculaires,dos,céphalées,perte,d'appétit,nausées,vomissements";
    private static String grippe = "fièvre,élevée,accélération,rythme,fatigué,cardiaque,frissons,fatigue,abattement,somnolence,manque,d’appétit,nez,coule,mal,gorge,difficultés,avaler,voix,voilée,brûlures,thorax,toux,sèche.";
    private static String gale = "prurit,diffus,démangeaisons,diffuses,s’aggrave,nuit,perturber,sommeil,prédominance,nocturne,poignets,aisselles,seins,,ventre";
    private static String herpès = "signes,avant-coureurs,sensibilité,picotements,démangeaisons,région,génitale,crise,fièvre,maux,tête,apparition,vésicules,transparentes,ulcères,vif,croûtes,";
    private static String hépatite = "fièvre,sueurs,perte,d’appétit,amaigrissement,nausées,malaises,abdominaux,jaunisse,urine,foncée";
    private static String hypertension = "maux,tête,fatigue,nuque,tôt,matin,vertiges,fatigué,bourdonnements,d'oreilles,palpitations,saignements,nez,confusion,somnolence,engourdissements,fourmillements,pieds";
    private static String méningite = "mal,tête,vomissements,raideur,nuque,sueurs,frissons,douleurs,musculaires,rhinopharyngite,sinusite,otite,éruption,peau,fievre";
    private static String thyroidite = "fatigue,l’effort,cérébral,prise,poids,Visage,fatigué,bouffi,doigts,boudinés,Constipation,Douleurs,articulaires,Sautes,d'humeur,Intolérance,tachycardies,Ralentissements,psychomoteurs,Maux,gorge";


    /** dictionnaire end **/
    private static int bjr = 0;
    private static int thankyouvar = 0;
    private static int allergievar = 0;
    private static int rhumevar = 0;
    private static int asthmevar = 0;
    private static int arthritevar = 0;
    private static int cystitevar = 0;
    private static int depressionvar = 0;
    private static int diabètevar = 0;
    private static int fiévrevar = 0;
    private static int grippevar = 0;
    private static int galevar = 0;
    private static int herpèsvar = 0;
    private static int hépatitevar = 0;
    private static int hypertensionvar = 0;
    private static int méningitevar = 0;
    private static int thyroiditevar = 0;

    public static  void DELETEALL(){
        Maladies.Maladie = 0;
        rhumevar = 0;
        allergievar = 0;
        thankyouvar = 0;
        asthmevar = 0;
        arthritevar = 0;
        cystitevar = 0;
        depressionvar = 0;
        diabètevar = 0;
        fiévrevar = 0;
        grippevar = 0;
        galevar = 0;
        herpèsvar = 0;
        hépatitevar = 0;
        hypertensionvar = 0;
        méningitevar = 0;
        thyroiditevar = 0;
    }
    public static void RESET(){

    }

    public static void VerifyQuestion(String message){

        if(message.equalsIgnoreCase("merci") || message.equalsIgnoreCase("d'accord") || message.equalsIgnoreCase("ok") || message.equalsIgnoreCase("ok merci"))
            thankyouvar +=1;
        for(String i : message.split(" ")){ // split message
            /** BIENVENUE ET GOOD BYE HERE! ***/
            for(String t : HELLO.split(","))
                if(t.equalsIgnoreCase(i))
                    bjr += 1;

                if(bjr >0)break;
            /** **/
            for(String t : rhume.split(","))
            if(i.equalsIgnoreCase(t))
                rhumevar += 1;

            for(String t : allergie.split(","))
                if(i.equalsIgnoreCase(t))
                    allergievar +=1;

            for(String t : asthme.split(","))
                if(i.equalsIgnoreCase(t))
                asthmevar += 1;

            for(String t : arthrite.split(","))
                if(i.equalsIgnoreCase(t))
                arthritevar += 1;

            for(String t : cystite.split(","))
                if(i.equalsIgnoreCase(t))
                cystitevar += 1;

            for(String t : depression.split(","))
                if(i.equalsIgnoreCase(t))
                depressionvar += 1;


            for(String t : diabète.split(","))
                if(i.equalsIgnoreCase(t))
                diabètevar += 1;


            for(String t : fiévre.split(","))
                if(i.equalsIgnoreCase(t))
                fiévrevar += 1;


            for(String t : grippe.split(","))
                if(i.equalsIgnoreCase(t))
                grippevar += 1;

            for(String t : gale.split(","))
                if(i.equalsIgnoreCase(t))
                galevar += 1;

            for(String t : herpès.split(","))
                if(i.equalsIgnoreCase(t))
                herpèsvar += 1;


            for(String t : hépatite.split(","))
                if(i.equalsIgnoreCase(t))
                hépatitevar += 1;


            for(String t : hypertension.split(","))
                if(i.equalsIgnoreCase(t))
                hypertensionvar += 1;


            for(String t : méningite.split(","))
                if(i.equalsIgnoreCase(t))
                méningitevar += 1;


            for(String t : thyroidite.split(","))
                if(i.equalsIgnoreCase(t))
                thyroiditevar += 1;
        }
        if(bjr > 0){
            if(state == 0){
                Maladies.Maladie = 996;
                bjr = 0;
            } else {

            }


        } else

        /** comparaison des variables **/
        switch (BotStep){
            case 0:
                BotStep += 1;
                Maladies.Maladie = 998;
                break;
            case 1:
                BotStep +=1;
                Maladies.Maladie = 997;
                break;
            case 2:
                BotStep +=1;
                Maladies.Maladie = 990; // Combien de temps
                break;
            default:
                if(thankyouvar != 0) {
                    Maladies.Maladie = 999;
                } else {
                    getMaladie();
                }
                break;
        }
        if(state == 3)
            DELETEALL();


    }

    public static void getMaladie() {
        ArrayList<Integer> key = new ArrayList<Integer> ();
        ArrayList<Integer> list = new ArrayList<Integer> ();
        for (int k = 1 ; k < 16; k++)
            key.add(1);
        list.add(rhumevar);
        list.add(allergievar);
        list.add(asthmevar);
        list.add(arthritevar);
        list.add(cystitevar);
        list.add(depressionvar);
        list.add(diabètevar);
        list.add(fiévrevar);
        list.add(grippevar);
        list.add(galevar);
        list.add(herpèsvar);
        list.add(hépatitevar);
        list.add(hypertensionvar);
        list.add(méningitevar);
        list.add(thyroiditevar);

        int max = 0;
        for (int k = 0; k < list.size()-1; k++) {
            if (list.get(k) > max) {
                max = list.get(k);
                Maladies.Maladie = key.get(k);
            }
        }
    }

    public static String GetBestAnswer(String str){
        VerifyQuestion(str);
        //getMaladie();
        if(Maladies.Maladie != 996 || Maladies.Maladie != 997 ||Maladies.Maladie != 998 ||Maladies.Maladie != 999 && state != 3)
            state =+ 1;


        switch(Maladies.Maladie){
            case Maladies.TYPE_MALADIE_RHUME:
                return MainActivity.username.getText()+", Evidemment tu as un rhume, alors il faut se laver régulièrement les mains et ne pas porter les mains au visage, Et si possible, rester à la maison lorsqu’on est malade pour ne pas contaminer les autres. ";
            case Maladies.TYPE_MALADIE_ALLERGIE:
                return MainActivity.username.getText()+", Evidemment tu as une allergie, alors Pour le moment, la seule mesure préventive reconnue consiste à éviter le tabagisme et la fumée secondaire. La fumée de tabac créerait un terrain propice à diverses formes d’allergies. Autrement, on ne connaît pas d’autres mesures qui permettent de s’en prémunir : il n’existe pas de consensus médical à cet égard.";
            case Maladies.TYPE_MALADIE_ASTHME:
                return MainActivity.username.getText()+", Evidemment tu as un asthme, alors Pour le moment, la seule mesure préventive de base reconnue consiste à éviter le tabagisme actif et passif. La fumée de tabac irrite les voies respiratoires, ce qui crée un terrain propice aux maladies respiratoires.";
            case Maladies.TYPE_MALADIE_ARTHRITE:
                return MainActivity.username.getText()+", Evidemment tu as de l'arthrite, alors la première arme contre la douleur arthritique serait le repos, surtout pour les personnes chez qui le stress, l'anxiété et la fatigue nerveuse sont très présents. Des exercices respiratoires, des techniques mentales de relaxation et la méditation sont autant de manières d'aider l'organisme à atteindre la détente.";
            case Maladies.TYPE_MALADIE_CYSTITE:
                return MainActivity.username.getText()+", Evidemment tu as une cystite, alors pour réduire le risque d'infection urinaire, il faut boire suffisamment, et spécialement de l’eau. Nos sources recommandent de boire de 6 à 8 verres d’eau ou de boissons variées (jus, bouillons, thé, etc.) par jour. Cette mesure sert de barème, mais ne repose pas sur des données scientifiques précises. Le jus de cranberry est une option intéressante en prévention des rechutes puisqu’il empêcherait les bactéries d’adhérer aux parois des voies urinaires.";
            case Maladies.TYPE_MALADIE_DEPRESSION:
                return MainActivity.username.getText()+", Evidemment tu as une depression, alors parfois, dans les cas de signes de dépression sans dépression majeure, ou dans les cas de dysthymie, il suffit d’organiser un régime de vie plus sain pendant un certain temps, comme se coucher tôt, faire plus d’exercice et manger de façon équilibrée, pour se sentir mieux. Mais d’autres moyens peuvent aider à ne pas sombrer dans la dépression, et surtout à éviter les rechutes après une première dépression.";
            case Maladies.TYPE_MALADIE_DIABETE:
                return MainActivity.username.getText()+", Evidemment tu es diabétique, mais à ce jour, on n'a pas encore trouvé de cure permettant de guérir le diabète. Le traitement proposé vise à rétablir des valeurs normales de glycémie. Le respect du traitement ainsi que le suivi médical est cependant crucial pour éviter les complications aiguës et chroniques.";
            case Maladies.TYPE_MALADIE_FIEVRE:
                return MainActivity.username.getText()+", Evidemment tu as de la fiévre, Le meilleur moyen de prévenir la fièvre jaune est le vaccin préventif. Ce vaccin est efficace durant la vie entière de l'individu, cependant aucun traitement curatif et spécifique de la fièvre jaune n'a encore été développé.";
            case Maladies.TYPE_MALADIE_GRIPPE:
                return MainActivity.username.getText()+", Evidemment tu as une grippe, alors il faut se faire vacciner si possible avant la période épidémique ou au tout début si on ne l’a pas fait si on est une personne à risque ou si on est exposé à des facteurs de risque, et aussi faut se rappeler que les personnes grippées demeurent contagieuses tant que leurs symptômes persistent.";
            case Maladies.TYPE_MALADIE_GALE:
                return MainActivity.username.getText()+", Evidemment tu as de la gale, alors lors des soins, porter des gants, se laver régulièrement les mains (avant et après, ainsi que plusieurs fois par jour), car cela élimine les parasites qui pourraient s’y trouver. Pour Le traitement médical de la gale se fait soit par voie orale, soit par voie locale, les études ne permettant pas de déterminer laquelle de ces modalités est la plus efficace.";
            case Maladies.TYPE_MALADIE_HERPES:
                return MainActivity.username.getText()+", Evidemment tu as de l'herpès génital, alors comme prévention, il faut pas avoir de relations sexuelles génitales, anales ni orales avec une personne qui a des lésions, tant que celles-ci ne sont pas complètement guéries, et surtout faut Renforcer le système immunitaire, car une alimentation saine, un sommeil suffisant et l’activité physique font partie des facteurs qui contribuent à une bonne immunité.";
            case Maladies.TYPE_MALADIE_HEPATITE:
                return MainActivity.username.getText()+", Evidemment tu as de l'épatite, alors il faut se laver les mains systématiquement après être allé à la selle, avant de manipuler des aliments et avant de manger; cela, pour éviter toute contagion, et comme prévention, faut éviter deboire l’eau du robinet, et surtout d'étre vacciné.";
            case Maladies.TYPE_MALADIE_HYPERTENSION:
                return MainActivity.username.getText()+", Evidemment tu as une hypertension artérielle, alors il faut maintenir un poids santé, étre actif, porter attention aux signes de stress chronique et surtout consommer avec modération les aliments très salés.";
            case Maladies.TYPE_MALADIE_MENINGITE:
                return MainActivity.username.getText()+", Evidemment tu as de la méningite, alors on vous conseille de laver les mains fréquemment, porter un masque Ne pas partager aliments, boissons, brosses à dents, cigarettes, rouges à lèvres, etc; et surtout d'etre vacciné.";
            case Maladies.TYPE_MALADIE_THYROIDITE:
                return MainActivity.username.getText()+", Evidemment tu as de la thyroïdite, alors on vous conseille de surveiller la TSH avant, pendant et après un traitement, ne pas fumer, gérer le stress à l’aide de techniques de relaxation, et il faut aussi savoir que Chaque thyroïdite présentant des étiologies spécifiques, un traitement adapté sera proposé en fonction du diagnostic effectué.";
            case 996:
                String helo = "";
                try {
                    if(state == 0)
                        helo = "\uD83D\uDC4B Salut "+MainActivity.username.getText()+", je tiens à vous remercier pour la confiance que vous m'avez témoigné.\nPouvez-vous me citez vos symptomes pour commencer? ";
                    else
                        helo = "Vous êtes trop gentil "+MainActivity.username.getText()+", merci mais pouvez-vous me citez vos symptomes pour commencer?";
                    botChat.istyping.setVisibility(View.VISIBLE);
                    Thread.sleep(2300);
                    botChat.istyping.setVisibility(View.INVISIBLE);
                }catch (Exception e){
                    e.printStackTrace();
                }

                return helo;
            case 990:
                String tmp = "";

                try {
                    botChat.istyping.setVisibility(View.VISIBLE);
                    Thread.sleep(2300);
                    tmp = "D'accord, depuis quand est-ce que tu ne te sens pas bien ?";
                    botChat.istyping.setVisibility(View.INVISIBLE);
                }catch (Exception e){
                    e.printStackTrace();
                }
                BotStep +=1;
                RESET();
                return tmp;
            case 997:
                String lol = "";

                try {
                botChat.istyping.setVisibility(View.VISIBLE);
                Thread.sleep(2300);
                lol = "\uD83D\uDC4C Niquel, on y presque.\nAimeriez-vous signaler d'autre pour nous aider à bien préciser la maladie.";
                botChat.istyping.setVisibility(View.INVISIBLE);
                }catch (Exception e){
                    e.printStackTrace();
                }
                RESET();
                return lol;
            case 999:
                return  MainActivity.username.getText()+", Derien. Mais, n'hésitez pas de consulter un docteur.";
            case 998:
                String mssgs = "";
                try {
                    botChat.istyping.setVisibility(View.VISIBLE);
                    Thread.sleep(2300);

                    mssgs = "\uD83D\uDC4D Les symptomes cités sont enregistrés.\nQu'aimeriez-vous signaler d'autre?. "+BotData.rhumevar+"";
                    botChat.istyping.setVisibility(View.INVISIBLE);
                    //BotData.RESET();
                }catch (Exception e){
                    e.printStackTrace();
                }
                return mssgs;
                default:
                    String mssg="";
                try {
                    botChat.istyping.setVisibility(View.VISIBLE);
                    Thread.sleep(2300);
                    switch(getRandomValue(1,3)){
                        case 1:
                            mssg = "\uD83D\uDE22 Désolé "+MainActivity.username.getText()+", mais je n'ai pas compris.\n" +
                                    "Veuillez nommer vos symptômes en utilisant un langage simple. "+BotData.rhumevar+"";
                            break;
                        case 2:
                            mssg = "\uD83D\uDE22 Désolé "+MainActivity.username.getText()+", mais je n'ai pas compris.\n" +
                                    "Veuillez nommer vos symptômes les plus importants, par exemple: je me sens mal, j'ai mal à l'abdomen.";
                            break;
                        case 3:
                            mssg = "\uD83D\uDE22 Désolé "+MainActivity.username.getText()+", mais je n'ai pas compris.\n" +
                                    "Je suis juste une machine. Essayez d'utiliser des phrases simples. ";
                            break;
                    }
                    botChat.istyping.setVisibility(View.INVISIBLE);
                    BotData.RESET();
                }catch (Exception e){
                    e.printStackTrace();
                }
                return mssg;
        }



    }




    public static int getRandomValue(int i1,int i2)
    {
        Random rand = new Random();
        if(i1 > i2)
        {
            int i = i1;
            i1 = i2;
            i2 = i;
        }
        return (rand.nextInt((i2-i1)+1))+i1;
    }


}
