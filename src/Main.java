public class Main {
    public static void main(String[] args){
        View v = new View();
        Model m = new Model(v);
        Controller c = new Controller(v,m);
    }
}
