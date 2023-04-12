import java.util.Random;

public class HasQuarterState implements State{
    GumballMachine gumballMachine;

    Random random = new Random();

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You cannot insert another quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quarter returned");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("Crank turned");
        int luck = random.nextInt(2);
        if (luck == 1){
            System.out.println("Hurray, you are the lucky winner");
            gumballMachine.setState(gumballMachine.getWinnerState());
        } else {
            System.out.println("No luck today, try again tomorrow");
            gumballMachine.setState(gumballMachine.getSoldState());
        }
    }

    @Override
    public void dispense() {
        System.out.println("Cannot dispense without crank");
    }
}
