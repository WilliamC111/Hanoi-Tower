import java.util.Stack;

public class Tower {
    private Stack<Disk> disks;

    public Tower() {
        disks = new Stack<>();
    }

    public boolean addDisk(Disk disk) {
        if (disks.isEmpty() || disk.getSize() < disks.peek().getSize()) {
            disks.push(disk);
            return true;
        }
        return false;
    }

    public Disk removeDisk() {
        if (!disks.isEmpty()) {
            return disks.pop();
        }
        return null;
    }

    public boolean isEmpty() {
        return disks.isEmpty();
    }

    @Override
    public String toString() {
        return disks.toString();
    }

    public  Stack<Disk> getDisks(){
        return disks;
    }
    
}
   

