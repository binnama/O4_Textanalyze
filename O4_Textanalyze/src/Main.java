import module.TreeCounter;

public class Main {
    public static void main(String[] args) {
        TreeCounter oL = new TreeCounter();
        oL.OrdLeser("src/ga.txt");
        String ord = oL.nesteOrd();
        while (ord != null)
        {
            oL.addNode(ord);
            //System.out.println(ord); // Kan jeg bytte ut denne delen med
            ord = oL.nesteOrd(); // TreeCounter coden for så å printe den ut?

        }
        //System.out.println("EOF");

        oL.inOrderTraverse(oL.root);

        //oL.preorderTraverse(oL.root);
    }
}
