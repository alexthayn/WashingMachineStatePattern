package WashingMachine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

class StateTests {

	/***************************************************************
	The next four tests will test the notFullyPaidState operations
	***************************************************************/
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
		
		//Check that the count of quarters in machine is zero
		assertEquals(0, machine1.getNumQuarters());
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
		
		//Check that the count of quarters in machine is zero
		assertEquals(0, machine1.getNumQuarters());
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
	
	/***********************************************
	The next four test will test the hasPaidState
	***********************************************/
	@Test
	void InsertQuarterHasPaidStateTest() {
		WashingMachine machine1 = new WashingMachine(1);
		
		machine1.setState(machine1.getHasPaidState());
		
		//Check that the state has changed to hasPaidState
		assertSame(machine1.getHasPaidState(),machine1.getState());
		
		//Attempt to insert quarters into machine
		machine1.insertQuarter(10);
		
		//Check that the state has changed from notPaid to hasPaid
		assertSame(machine1.getHasPaidState(), machine1.getState());
		
		//Check that we returned the extra quarters inserted and still have 4 left
		assertEquals(4,machine1.getNumQuarters());
	}

	@Test
	void EjectQuartersHasPaidStateTest() {
		WashingMachine machine1 = new WashingMachine(1);
				
		machine1.setState(machine1.getHasPaidState());
		
		//Check that the state has changed to hasPaidState
		assertSame(machine1.getHasPaidState(),machine1.getState());
		
		//Attempt to eject quarters
		machine1.ejectQuarters();
		
		//Check that there are no quarters left in the machine
		assertEquals(0, machine1.getNumQuarters());	
		
		//Check that the state has changed
		assertSame(machine1.getNotFullyPaidState(), machine1.getState());
	}
	
	@Test 
	void CancelHasPaidStateTest() {
		WashingMachine machine1 = new WashingMachine(1);
		
		machine1.setState(machine1.getHasPaidState());
		
		//Check that the state has changed to hasPaidState
		assertSame(machine1.getHasPaidState(),machine1.getState());
		
		//Attempt to cancel 
		machine1.cancel();
		
		//Check that the state has changed to notFullyPaidState
		assertSame(machine1.getNotFullyPaidState(), machine1.getState());
		
		//Check that numbers of quarters is zero
		assertEquals(0, machine1.getNumQuarters());
	}
	
	@Test
	void StartHasPaidStateTest() {
		WashingMachine machine1 = new WashingMachine(1);
		
		machine1.setState(machine1.getHasPaidState());
		
		//Check that the state has changed to hasPaidState
		assertSame(machine1.getHasPaidState(),machine1.getState());
		
		//Attempt to start machine
		machine1.start();
		
		//Check that the state has changed to notFullyPaid because we haven't inserted quarters yet
		assertSame(machine1.getNotFullyPaidState(), machine1.getState());
		
		//Insert 4 quarters
		machine1.insertQuarter(4);
		
		//Check state has changed back to HasPaid state
		assertSame(machine1.getHasPaidState(), machine1.getState());
		
		//now attempt to start machine again
		machine1.start();
		
		//Check that the state has changed to running
		assertSame(machine1.getInUseState(), machine1.getState());
		
		//Check that it ate the quarters
		assertEquals(0, machine1.getNumQuarters());
	}
	
	/***********************************************
	The next four test will test the inUse state
	***********************************************/
	@Test
	void StartInUseStateTest() {
		WashingMachine machine1 = new WashingMachine(1);
		machine1.setState(machine1.getInUseState());
		
		//Check that the state has changed to inUse state
		assertSame(machine1.getInUseState(), machine1.getState());
		
		//Attempt to start an already running machine
		machine1.start();
		
		//check that the state has not changed
		assertSame(machine1.getInUseState(), machine1.getState());
	
		//Check that numbers of quarters is zero
		assertEquals(0, machine1.getNumQuarters());
	}
	
	@Test
	void EjectQuartersInUseStateTest() {
		WashingMachine machine1 = new WashingMachine(1);
		machine1.setState(machine1.getInUseState());
		
		//Check that the state has changed to inUse state
		assertSame(machine1.getInUseState(), machine1.getState());
		
		//Attempt to eject quarters from machine
		machine1.ejectQuarters();
		
		//Check that the state has not changed
		assertSame(machine1.getInUseState(), machine1.getState());
		
		//Check that numbers of quarters is zero
		assertEquals(0, machine1.getNumQuarters());
	}
	
	@Test 
	void InsertQuartersInUseState() {
		WashingMachine machine1 = new WashingMachine(1);
		machine1.setState(machine1.getInUseState());
		
		//Check that the state has changed to inUse state
		assertSame(machine1.getInUseState(), machine1.getState());
		
		//Attempt to insert quarters into machine
		machine1.insertQuarter(8);
		
		//Check that that state has not changed
		assertSame(machine1.getInUseState(), machine1.getState());
		
		//Check that the count of quarters in machine is zero
		assertEquals(0, machine1.getNumQuarters());
	}
	
	@Test
	void CancelInUseStateTest() {
		WashingMachine machine1 = new WashingMachine(1);
		machine1.setState(machine1.getInUseState());
		
		//Check that the state has changed to inUse state
		assertSame(machine1.getInUseState(), machine1.getState());
		
		//Attempt to cancel the machine
		machine1.cancel();
		
		//Check that the state has changed
		assertSame(machine1.getNotFullyPaidState(), machine1.getState());
		
		//Check that the count of quarters in machine is zero
		assertEquals(0, machine1.getNumQuarters());
	}
}
