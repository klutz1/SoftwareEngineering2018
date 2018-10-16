package edu.nd.se2018.homework.homework6.states;

public class NeedsMorePieces implements State {

	StateImplementation currState;
	public NeedsMorePieces(StateImplementation curr) {
		this.currState = curr;
	}
	
	@Override
	public int incrementPiecesHeld(int currentPieces) {
		//do nothing because does not need more pieces
		return currentPieces + 1;
	}

	@Override
	public int grabbedAllPieces(int val) {
		if (val == 0) {
			currState.setState(currState.getHasEnoughPiecesState());
			return 2;
		}
		else
			return 0;
		
	}
	
	
	@Override
	public int resetPiecesHeld() {
		// impossible: needs more pieces to complete level
		return 0;
	}
	
	
}