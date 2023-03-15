import module.TreeCounter;

public class Main {
    public static void main(String[] args) {
        TreeCounter oL = new TreeCounter();
        oL.OrdLeser("src/ga.txt");
        String ord = oL.nesteOrd();
        while (ord != null)
        {
            oL.addNode(ord);
            ord = oL.nesteOrd(); // TreeCounter coden for så å printe den ut?
        }
        oL.inOrderTraverse(oL.root);
    }
}