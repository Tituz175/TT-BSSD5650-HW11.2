public class SoldState implements State{

    GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Please wait. Already dispensing a gumball");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Sorry, you already turned the crank");
    }

    @Override
    public void turnCrank() {
        System.out.println("Turning twice done nothing");
    }

    @Override
    public void dispense() {
        if (gumballMachine.count > 0){
            gumballMachine.count--;
            System.out.println("Dispensing gumball");
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        } else {
            System.out.println("Oops, no gumballs");
            gumballMachine.hasQuarterState.ejectQuarter();
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }
}
