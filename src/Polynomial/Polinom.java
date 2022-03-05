package Polynomial;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class Polinom {
    ArrayList<Monom> listaMonoame = new ArrayList<>();

    public ArrayList<Monom> getlistaMonoame() {
        return listaMonoame;
    }

    public void setlistaMonoame(ArrayList<Monom> listaMonoame) {
        this.listaMonoame = listaMonoame;
    }

    public void crearePolinom(String s){
        ArrayList<Monom> listaRezultat = new ArrayList<>();
        String s_modified = s.replace("-", "+-");
        String[] monoame_string = s_modified.split("\\+");

        for (String iterator : monoame_string){
            String[] numere_monom = iterator.split("x\\^");
            float coeficient;
            int putere = 0;
            if ( numere_monom[0].equals("")){
                coeficient = 1;
            }
            else{
                coeficient = Float.parseFloat(numere_monom[0]);

            }

            if ( numere_monom.length > 1 ){
                putere = Integer.parseInt(numere_monom[1]);
            }
            Monom m = new Monom(coeficient, putere);
            listaRezultat.add(m);
        }
        this.setlistaMonoame(listaRezultat);

        this.simplificare();
        this.normalizare();
    }

    private void simplificare(){
        Collections.sort(listaMonoame);
        int i = 0;
        while ( i < listaMonoame.size() - 1 ){
            //se verifica daca urmatorul element din lista are aceeasi putere cu elementul curent
            if (listaMonoame.get(i).getPutere() == listaMonoame.get(i+1).getPutere()){
                //memoram indexul primului element pentru a putea aduna in el ceilalti coeficienti
                int putere = listaMonoame.get(i).getPutere();
                int initialIndex = i;
                i++;
                //parcurgem lista pana ajungem la finalul ei sau pana puterea monomului e diferita de cea de la care am pornit (e mai mica)
                while ( i < listaMonoame.size() && listaMonoame.get(i).getPutere() == putere ){
                    float newCoeficient = listaMonoame.get(initialIndex).getCoeficient();
                    newCoeficient += listaMonoame.get(i).getCoeficient();
                    listaMonoame.get(initialIndex).setCoeficient(newCoeficient);
                    listaMonoame.get(i).setCoeficient(0);
                    i++;
                }
            }
            else{
                i++;
            }
        }
    }

    private void normalizare(){
        for ( int i = 0; i < listaMonoame.size(); i++ ){
            if ( listaMonoame.get(i).getCoeficient() == 0 ){
                listaMonoame.remove(i);
                i--;
            }
        }
    }

    public void afis_polinom(){
        for ( Monom iterator : listaMonoame ){
            float coeficient = iterator.getCoeficient();
            int putere = iterator.getPutere();

            //daca nu ne aflam la primul element si acesta este pozitiv ii afisam un + in fata
            if ( !listaMonoame.get(0).equals(iterator) ){
                if ( coeficient >= 0 )
                    System.out.print("+");
            }
            if ( coeficient != Float.MIN_VALUE){
                System.out.print(coeficient);
            }
            else{
               System.out.print("C");
            }
            if ( putere != 0 && putere != Integer.MIN_VALUE ){
                System.out.print("x^" + putere);
            }
        }
        System.out.println();
    }

    public String toString(){
        String result = "";
        for ( Monom iterator : listaMonoame ){
            float coeficient = iterator.getCoeficient();
            int putere = iterator.getPutere();

            //daca nu ne aflam la primul element si acesta este pozitiv ii afisam un + in fata
            if ( !listaMonoame.get(0).equals(iterator) ){
                if ( coeficient >= 0 )
                    result += "+";
            }
            if ( coeficient != Float.MIN_VALUE ){
                if ( coeficient != 1 && coeficient != -1){
                    DecimalFormat frmt = new DecimalFormat();
                    frmt.setMaximumFractionDigits(2);
                    if ( (int)coeficient == coeficient ){
                        result += (int)coeficient;
                    }
                    else{
                        result += frmt.format(coeficient);
                    }
                }else if ( coeficient == -1 ){
                    result += "-";
                }
            }
            else{
                result += "C";
            }
            if ( putere != 0 && putere != Integer.MIN_VALUE ){
                if ( putere == 1 ){
                    result += "x";
                }
                else{
                    result += "x^" + putere;
                }
            }
        }
        return result;
    }

    public void adunarePolinom(Polinom pol1, Polinom pol2){
        ArrayList<Monom> listaRezultat = new ArrayList<>();
        this.copiere2Liste(pol1, pol2, listaRezultat, listaRezultat);

        this.setlistaMonoame(listaRezultat);

        this.simplificare();
        this.normalizare();
    }

    private void inversareCoeficienti(){
        for (Monom iterator : listaMonoame ){
            iterator.setCoeficient(-iterator.getCoeficient());
        }
    }

    public void scaderePolinom(Polinom pol1, Polinom pol2){
        pol2.inversareCoeficienti();
        this.adunarePolinom(pol1, pol2);
        pol2.inversareCoeficienti();
    }

    public void inmultirePolinom(Polinom pol1, Polinom pol2){
        ArrayList<Monom> listaRezultat = new ArrayList<>();
        for ( Monom iterator1 : pol1.getlistaMonoame() ){
            for ( Monom iterator2 : pol2.getlistaMonoame() ){
                float coeficient = iterator1.getCoeficient() * iterator2.getCoeficient();
                int putere = iterator1.getPutere() + iterator2.getPutere();
                listaRezultat.add(new Monom(coeficient, putere));
            }
        }
        this.setlistaMonoame(listaRezultat);

        this.simplificare();
        this.normalizare();
    }

    private void inmultireCuMonom(Polinom pol, Monom m){
        ArrayList<Monom> listaRezultat = new ArrayList<>();
        for ( Monom iterator: pol.getlistaMonoame() ){
            float coeficient = iterator.getCoeficient() * m.getCoeficient();
            int putere = iterator.getPutere() + m.getPutere();
            listaRezultat.add(new Monom(coeficient, putere));
        }
        this.setlistaMonoame(listaRezultat);

        this.simplificare();
        this.normalizare();
    }


    public void impartirePolinom(Polinom pol1, Polinom pol2, Polinom cat, Polinom rest){
        cat.getlistaMonoame().clear();
        Polinom copy1 = new Polinom();
        //copiem listele de monoame din pol1
        //pentru a le putea modifica pe parcursul calculelor
        this.copiereListe(pol1, copy1.getlistaMonoame());

        while(copy1.getlistaMonoame().get(0).getPutere() >= pol2.getlistaMonoame().get(0).getPutere()){
            float rezCoef = copy1.getlistaMonoame().get(0).getCoeficient() / pol2.getlistaMonoame().get(0).getCoeficient();
            int rezPutere = copy1.getlistaMonoame().get(0).getPutere() - pol2.getlistaMonoame().get(0).getPutere();

            Monom rez = new Monom(rezCoef, rezPutere);
            cat.getlistaMonoame().add(rez);

            Polinom auxiliar = new Polinom();
            auxiliar.inmultireCuMonom(pol2, rez);

            copy1.scaderePolinom(copy1, auxiliar);
        }
        rest.setlistaMonoame(copy1.getlistaMonoame());
    }

    private void copiere2Liste(Polinom pol1, Polinom pol2, ArrayList<Monom> lista1, ArrayList<Monom> lista2){
        for ( Monom iterator : pol1.getlistaMonoame() ){
            lista1.add(new Monom(iterator.getCoeficient(), iterator.getPutere()));
        }
        for ( Monom iterator : pol2.getlistaMonoame() ){
            lista2.add(new Monom(iterator.getCoeficient(), iterator.getPutere()));
        }
    }

    private void copiereListe(Polinom pol, ArrayList<Monom> lista){
        for ( Monom iterator : pol.getlistaMonoame() ){
            lista.add(new Monom(iterator.getCoeficient(), iterator.getPutere()));
        }
    }

    public Polinom derivata(){
        Polinom copy = new Polinom();
        for ( Monom iterator : listaMonoame ){
            float coeficient = iterator.getPutere() * iterator.getCoeficient();
            int putere;
            putere = iterator.getPutere()-1;

            copy.listaMonoame.add(new Monom(coeficient, putere));
        }
        copy.normalizare();
        return copy;
    }

    public Polinom integrala(){
        Polinom copy = new Polinom();
        for ( Monom iterator : listaMonoame ){
            float coeficient = iterator.getCoeficient() / (iterator.getPutere() + 1);
            int putere = iterator.getPutere() + 1;
            copy.listaMonoame.add(new Monom(coeficient, putere));
        }
        copy.listaMonoame.add(new Monom(Float.MIN_VALUE, Integer.MIN_VALUE));
        return copy;
    }

}
