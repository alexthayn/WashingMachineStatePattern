package WashingMachine;

public class WashingMachine {
	State notFullyPaid;
	State hasPaid;
	State inUse;
	
	State state;
	
	//This variable stores the number of quarters inserted into the machine
	int countQuarters;
	
	//This variable stores the machine number
	int machineNum;

	//Washing machine constructor
	public WashingMachine(int num) {
		notFullyPaid = new NotFullyPaidState(this);
		hasPaid = new HasPaidState(this);
		inUse = new InUseState(this);
		
		state = notFullyPaid;
		machineNum = num;
	}
	
	//returns num of quarters in machine
	public int getNumQuarters() {
		return countQuarters;
	}
	
	//set number of quarters
	public void setNumQuarters(int numQuarters) {
		if(numQuarters >= 0)
			this.countQuarters = numQuarters;
	}

	//This function takes the num of quarters as an argument
	//It calls the insertQuarter function for the current state we are in 
	public void insertQuarter(int numQtrs) {
		countQuarters += numQtrs ;
		state.insertQuarters();
	}
	
	//This function call ejectQuarters() on the current state we are in
	public void ejectQuarters() {
		state.ejectQuarters();
	}
	
	//This function calls start() on the current state we are in
	public void start() {
		state.start();
	}
	
	//This function calls cancel() on the current state we are in
	public void cancel() {
		state.cancel();
	}
	
	//This function allows us to set the state for the washing machine
	public void setState(State state) {
		this.state = state;
	}
	
	//State getter functions
	public State getState() {
		return state;
	}
	
	public State getNotFullyPaidState() {
		return notFullyPaid;
	}
	
	public State getHasPaidState() {
		return hasPaid;
	}
	
	public State getInUseState() {
		return inUse;
	}
	
	
	//Override toString() function for the washing machine
	public String toString() {
		StringBuffer result = new StringBuffer();
		
		result.append("\n-------------Alex's Laundromat-------------");
		result.append("\nMachine Number: " + machineNum);
		result.append("\nMachine "+ machineNum + " " + state + ".\n");
		return result.toString();
	}
}
