public final class PR430Main {
    private static PR430Main _instance;
    private final String _nom;
    private final String _cognom;
    private final int _edat;

    private PR430Main(String _nom, String _cognom, int _edat){
        this._nom = _nom;
        this._cognom = _cognom;
        this._edat = _edat;
    }

    public static PR430Main getInstance(String nom, String cognom, int edat){
        if (_instance == null){
            _instance = new PR430Main(nom, cognom, edat);
        }
        return _instance;
    }

    @Override
    public String toString(){
        return "Nom: " + _nom + " Cognom: " + _cognom + " edat: " + _edat;
    }

    public static void main(String[] args) throws InterruptedException {
        PR430Main instance1 = PR430Main.getInstance("Alex", "Chica", 20);
        System.out.println("Iniciant 0");
        Thread.sleep(3000);
        PR430Main instance2 = PR430Main.getInstance("Juan", "Garcia", 22);
        System.out.println("Iniciant 1");
        Thread.sleep(3000);
        PR430Main instance3 = PR430Main.getInstance("Pedro", "Sanchez", 51);
        System.out.println("Iniciant 2");
        Thread.sleep(3000);

        System.out.println(instance1.toString());
        System.out.println(instance2.toString());
        System.out.println(instance3.toString());
    }
}
