package edu.nd.se2018.homework.homework6.states;

public class StateImplementation {
	
	State hasEnoughPieces;
	State needsMorePieces;
	
	private State state;
	
	public StateImplementation() {
		hasEnoughPieces = new HasEnoughPieces(this);
		needsMorePieces = new NeedsMorePieces(this);
		this.state = needsMorePieces;
	}
	
	
	void setState(State state) {
		this.state = state;
	}
	
	public State getNeedsMorePiecesState() {
		return needsMorePieces;
	}
	
	public int getState(int num) {
		int value = state.grabbedAllPieces(num);
		return value;
	}
	
	public State getHasEnoughPiecesState() {
		return hasEnoughPieces;
	}
}