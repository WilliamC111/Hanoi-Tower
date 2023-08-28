public class ModelTower {
    private Tower torreA;
    private Tower torreB;
    private Tower torreC;
    private int numDisks;

    public ModelTower(int numDisks) {
        this.numDisks = numDisks;
        torreA = new Tower();
        torreB = new Tower();
        torreC = new Tower();

        for (int i = numDisks; i > 0; i--) {
            torreA.addDisk(new Disk(i));
        }
    }

    public Tower getTorreA() {
        return torreA;
    }

    public Tower getTorreB() {
        return torreB;
    }

    public Tower getTorreC() {
        return torreC;
    }

    public int getNumDisks() {
        return numDisks;
    }
    public void getSolution(int numDisks,Tower torreOrigen ,Tower torreAuxiliar , Tower torreDestino){
        if(numDisks>0){
            
            this.getSolution(numDisks-1,torreOrigen,torreDestino, torreAuxiliar);
            this.doMovement(torreOrigen, torreDestino);
            this.getSolution(numDisks-1,torreAuxiliar, torreOrigen, torreDestino);
        }
    }

    public void doMovement(Tower torreOrigen, Tower torreDestino){
        torreDestino.addDisk(torreOrigen.getDisks().pop());
    }
    public boolean moveDisk(Tower torreOrigen, Tower torreDestino) {
        Disk disk = torreOrigen.removeDisk();
        if (disk != null && torreDestino.addDisk(disk)) {
            return true;
        }
        if (disk != null) {
            torreOrigen.addDisk(disk);
        }
        return false;
    }
    public boolean verifyWin() {
        return torreC.isEmpty() && torreB.isEmpty() && torreA.isEmpty();
    }
    
}