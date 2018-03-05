package WashingMachine;

public class WashingMachineDriver {
	public static void main(String[] args) {
		WashingMachine washingMachine = new WashingMachine(1);
		
		washingMachine.insertQuarter(2);
		washingMachine.insertQuarter(2);
		
		System.out.println(washingMachine);
		
		washingMachine.start();
		
		washingMachine.insertQuarter(8);
		
		washingMachine.cancel();
		
		washingMachine.start();
		washingMachine.cancel();
		washingMachine.insertQuarter(2);
		washingMachine.start();
		washingMachine.insertQuarter(3);
		washingMachine.start();
		washingMachine.cancel();
		washingMachine.cancel();
		washingMachine.cancel();
		washingMachine.start();
		washingMachine.cancel();
		washingMachine.insertQuarter(14);
		washingMachine.ejectQuarters();
		washingMachine.ejectQuarters();
		washingMachine.start();
		washingMachine.insertQuarter(1);
		washingMachine.insertQuarter(1);
		washingMachine.insertQuarter(1);
		washingMachine.insertQuarter(1);
		washingMachine.cancel();
		washingMachine.start();
		washingMachine.insertQuarter(5);
		washingMachine.start();
	}
}
