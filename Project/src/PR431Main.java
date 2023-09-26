import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class PR431Main {
    private static PR431Main _instance;
    private final String _nom;
    private final String _cognom;
    private final int _edat;

    private PR431Main(String _nom, String _cognom, int _edat){
        this._nom = _nom;
        this._cognom = _cognom;
        this._edat = _edat;
    }

    public static PR431Main getInstance(String nom, String cognom, int edat){
        if (_instance == null){
            _instance = new PR431Main(nom, cognom, edat);
        }
        return _instance;
    }

    @Override
    public String toString(){
        return "Nom: " + _nom + " Cognom: " + _cognom + " edat: " + _edat;
    }

    public static void main(String[] args) throws InterruptedException {
        PR431Main instance1 = PR431Main.getInstance("Alex", "Chica", 20);
        PR431Main instance2 = null;
        PR431Main instance3 = null;
        System.out.println("Iniciant 0");
        Thread.sleep(3000);
        try {
            Constructor[] constructors = PR431Main.class.getDeclaredConstructors();
            for (Constructor constructor : constructors){
                constructor.setAccessible(true);
                instance2 = (PR431Main) constructor.newInstance("Juan", "Antonio", 32);
                System.out.println("Iniciant 1");
                Thread.sleep(3000);
                instance3 = (PR431Main) constructor.newInstance("Pedro", "Sanchez", 51);
                System.out.println("Iniciant 2");
                Thread.sleep(3000);

                System.out.println(instance1);
                System.out.println(instance2);
                System.out.println(instance3);
            }
        } catch (InvocationTargetException | IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }
}
