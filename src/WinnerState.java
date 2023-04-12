public class WinnerState implements State{

    GumballMachine gumballMachine;

    public WinnerState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {

    }

    @Override
    public void ejectQuarter() {

    }

    @Override
    public void turnCrank() {

    }

    @Override
    public void dispense() {
        if (gumballMachine.count > 1){
            gumballMachine.count = gumballMachine.count -2;
            System.out.println("Dispensing two gumballs");
            if (gumballMachine.count > 0){
                gumballMachine.setState(gumballMachine.noQuarterState);
            } else {
                gumballMachine.setState(gumballMachine.soldOutState);
            }
        }
    }
}
