package WashingMachine;

public class HasPaidState implements State{
	WashingMachine washingMachine;
	
	public HasPaidState(WashingMachine wm) {
		this.washingMachine = wm;
	}
	
	public void insertQuarters() {
		System.out.println("You have already paid.");
		System.out.println("Returning extra quarters.");
		washingMachine.setNumQuarters(4);
	}
	public void ejectQuarters() {
		System.out.println("Returning your payment.");
		washingMachine.setNumQuarters(0);
		washingMachine.setState(washingMachine.getNotFullyPaidState());
		washingMachine.setNumQuarters(0);
	}
	public void start() {
		if(washingMachine.getNumQuarters() == 4) {
			System.out.println("Starting the washing machine!");
			washingMachine.setState(washingMachine.getInUseState());
			washingMachine.setNumQuarters(0);
		}else {
			System.out.println("Error you have not paid");
			washingMachine.setState(washingMachine.getNotFullyPaidState());
		}
	}
	public void cancel() {
		System.out.println("Canceling and returning your payment.");
		washingMachine.setState(washingMachine.getNotFullyPaidState());
		washingMachine.setNumQuarters(0);
	}
	
	public String toString() {
		return "has payment and is ready to be started";
	}
}
