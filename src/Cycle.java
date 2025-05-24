public class Cycle {
    private final Integer cycleID;
    public Cycle(Integer cycleID) {
        this.cycleID = cycleID;
    }

    public void run(){
        try{
            Thread.sleep(1000);
        }
        catch(Exception e){
            throw new RuntimeException("Error in sleep");
        }
    }

    public Integer getCycleID() {
        return cycleID;
    }
}