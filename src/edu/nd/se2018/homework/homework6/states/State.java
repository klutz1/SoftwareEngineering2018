package edu.nd.se2018.homework.homework6.states;

public interface State {
	public int incrementPiecesHeld(int num);

	public int grabbedAllPieces(int val);
	public int resetPiecesHeld();
}