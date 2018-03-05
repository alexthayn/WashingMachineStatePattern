package WashingMachine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

class StateTests {

	//The next four tests will test the notFullyPaidState operations
	@Test
	void StartNotFullyPaidStateTest() {
		WashingMachine machine1 = new WashingMachine(1);
		
		//Check initial state is set correctly
		assertSame(machine1.getNotFullyPaidState(),machine1.getState());
		
		//Attempt to start machine
		machine1.start();
		
		//Check that machine was not started and is still in notFullyPaid State
		assertSame(machine1.getNotFullyPaidState(),machine1.getState());
	}
	
	@Test 
	void CancelNotFullyPaidStateTest() {
		WashingMachine machine1 = new WashingMachine(1);
		
		//Check initial state is set correctly
		assertSame(machine1.getNotFullyPaidState(),machine1.getState());
		
		//Attempt to cancel machine
		machine1.cancel();
		
		//Check that the machine was not canceled and is still in notFullyPaid State
		assertSame(machine1.getNotFullyPaidState(),machine1.getState());
	}
	
	@Test
	void EjectNotFullyPaidStateTest() {
		WashingMachine machine1 = new WashingMachine(1);
		
		//Check initial state is set correctly
		assertSame(machine1.getNotFullyPaidState(),machine1.getState());
		
		//Attempt to eject quarters when there are none inserted
		machine1.ejectQuarters();
		
		//Check that machine state is still in notFullyPaid state
		assertSame(machine1.getNotFullyPaidState(),machine1.getState());
	}
	
	@Test
	void InsertQuarterNotFullyPaidStateTest() {
		WashingMachine machine1 = new WashingMachine(1);
		
		//Check initial state is set correctly
		assertSame(machine1.getNotFullyPaidState(), machine1.getState());
		
		//Attempt to insert one quarter
		machine1.insertQuarter(1);
		
		//Check that the quarter count is 1
		assertEquals(1,machine1.getNumQuarters());
		
		//Insert another 3 quarters
		machine1.insertQuarter(3);
		
		//Check that we have 4 quarters in the machine now
		assertEquals(4, machine1.getNumQuarters());
		
		//Check that the state has changed to hasPaidState
		assertSame(machine1.getHasPaidState(),machine1.getState());
		
		//Check still have 4 quarters in the machine
		assertEquals(4,machine1.getNumQuarters());
	}
	
	//The next four test will test the hasPaidState
	@Test
	void InsertQuarterHasPaidStateTest() {
		WashingMachine machine1 = new WashingMachine(1);
		
		//Check initial state is set correctly
		assertSame(machine1.getNotFullyPaidState(),machine1.getState());
		
		//Insert 4 quarter to get machine into hasPaid State
		machine1.insertQuarter(4);
		
		//Check that the state has changed to hasPaidState
		assertSame(machine1.getHasPaidState(),machine1.getState());
		
		//Attempt to insert quarters into machine
		machine1.insertQuarter(10);
		
		//Check that we returned the extra quarters inserted and still have 4 left
		assertEquals(4,machine1.getNumQuarters());
	}

	@Test
	void EjectQuartersHasPaidStateTest() {
		WashingMachine machine1 = new WashingMachine(1);
		
		//Check initial state is set correctly
		assertSame(machine1.getState(),machine1.getNotFullyPaidState());
		
		//Insert 4 quarter to get machine into hasPaid State
		machine1.insertQuarter(4);
		
		//Attempt to eject 4 quarters
		machine1.ejectQuarters();
		
		//Check that there are no quarters left in the machine
		assertEquals(0, machine1.getNumQuarters());		
	}
}
