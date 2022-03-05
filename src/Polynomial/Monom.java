package Polynomial;

class Monom implements Comparable{
    private int putere;
    private float coeficient;

    public Monom(float coeficient, int putere){
        this.coeficient = coeficient;
        this.putere = putere;
    }

    public int getPutere() {
        return putere;
    }

    public float getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(float coeficient) {
        this.coeficient = coeficient;
    }

    @Override
    public int compareTo (Object o){
        Monom m = (Monom)o;
        return m.getPutere()-putere;
    }
}
