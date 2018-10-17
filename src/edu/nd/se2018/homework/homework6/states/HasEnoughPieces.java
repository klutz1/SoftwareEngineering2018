package edu.nd.se2018.homework.homework6.states;


public class HasEnoughPieces implements State {

	private StateImplementation currState;
	public HasEnoughPieces(StateImplementation curr) {
		this.currState = curr;
	}
	
	@Override
	public int incrementPiecesHeld(int currentPieces) {
		//do nothing because does not need more pieces
		return currentPieces;
	}

	@Override
	public int resetPiecesHeld() {
		currState.setState(currState.getNeedsMorePiecesState());
		return 0;
	}

	@Override
	public int grabbedAllPieces(int val) {
		return 2;
		// TODO Auto-generated method stub
	}
	
	
}