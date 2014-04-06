package model;

import java.util.LinkedList;
import java.util.Stack;

public class Engine {
	private LinkedList<State> states;
	private int []visited;
	LinkedList<State> solution;

	public Engine() {
		states = new LinkedList<State>();
		setSafeStateTree();

		visited = new int[states.size()];
		solution = new LinkedList<>();

		for (int i = 0; i < states.size(); i++) {
			visited[i] = 0;
		}
	}

	private void setSafeStateTree() {
		State initialState = new State();
		LinkedList<State> queue = new LinkedList<>();
		queue.add(initialState);
		states.add(initialState);

		while (!queue.isEmpty()) {
			State poll = queue.pollFirst();
			setSafeStateChildsFor(poll, poll.getBoat());
			for (State state : poll.getChildStates()) {
				if (!states.contains(state)) {
					queue.add(state);
					states.add(state);
				}
			}
		}
	}

	private void setSafeStateChildsFor(State state, Boat boat) {
		if (state.isSafe()) {
			for (int cannibals = 0; cannibals <= 2; cannibals++) {
				for (int missionaries = 0; missionaries <= 2; missionaries++) {
					if (cannibals + missionaries > 0
							&& cannibals + missionaries <= 2) {
						State newState = new State(state);

						if (newState.move(cannibals, missionaries, boat)) {
							if (newState.isSafe()) {
								state.getChildStates().add(newState);
							}
						}
					}
				}
			}
		}
	}

	private void DFSSolution(int[] visited, LinkedList<State> solution, State initialState) {
		if (initialState.isFinal()) {
			System.out.println(solution);
		} else {
			for (State state : initialState.getChildStates()) {
				int index = states.indexOf(state);
				if (visited[index] == 0) {
					visited[index]=1;
					solution.add(state);
					DFSSolution(visited, solution, state);
					visited[index]=0;
					solution.remove(state);
				}
			}
		}
	}

	public void showSolution() {
		solution.add(states.getFirst());
		visited[0]=1;
		
		DFSSolution(visited, solution, states.getFirst());
	}
}
