public class Main {
    public static void main(String[] args) {
        int numDisks = 5; 

        ModelTower modelo = new ModelTower(numDisks);

        
        System.out.println("Estado inicial de las torres:");
        System.out.println("Torre A: " + modelo.getTorreA());
        System.out.println("Torre B: " + modelo.getTorreB());
        System.out.println("Torre C: " + modelo.getTorreC());

        
        modelo.moveDisk(modelo.getTorreA(), modelo.getTorreC());

       
        System.out.println("\nEstado después del movimiento:");
        System.out.println("Torre A: " + modelo.getTorreA());
        System.out.println("Torre B: " + modelo.getTorreB());
        System.out.println("Torre C: " + modelo.getTorreC());

        
        if (modelo.verifyWin()) {
            System.out.println("\n¡Has ganado!");
        } else {
            System.out.println("\nEl juego aún no ha sido completado.");
        }
    }
}