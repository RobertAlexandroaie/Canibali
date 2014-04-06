package model;

import java.util.LinkedList;

public class State {
	private Shore leftShore;
	private Shore rightShore;
	private LinkedList<State> childStates;
	private Boat boat;

	public State() {
		childStates = new LinkedList<>();
		leftShore = new Shore(3, 3);
		rightShore = new Shore(0, 0);
		boat = new Boat();
	}

	public State(State state) {
		this();
		leftShore = new Shore(state.getLeftShore());
		rightShore = new Shore(state.getRightShore());
	}

	/**
	 * @return the leftShore
	 */
	public Shore getLeftShore() {
		return leftShore;
	}

	/**
	 * @param leftShore
	 *            the leftShore to set
	 */
	public void setLeftShore(Shore leftShore) {
		this.leftShore = leftShore;
	}

	/**
	 * @return the rightShore
	 */
	public Shore getRightShore() {
		return rightShore;
	}

	/**
	 * @param rightShore
	 *            the rightShore to set
	 */
	public void setRightShore(Shore rightShore) {
		this.rightShore = rightShore;
	}

	public boolean isSafe() {
		return (leftShore.isSafe() && rightShore.isSafe());
	}

	/**
	 * @return the childStates
	 */
	public LinkedList<State> getChildStates() {
		return childStates;
	}

	/**
	 * @param childStates
	 *            the childStates to set
	 */
	public void setChildStates(LinkedList<State> childStates) {
		this.childStates = childStates;
	}  

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((boat == null) ? 0 : boat.hashCode());
		result = prime * result
				+ ((leftShore == null) ? 0 : leftShore.hashCode());
		result = prime * result
				+ ((rightShore == null) ? 0 : rightShore.hashCode());
		return result;
	}
	
	

	/**
	 * @return the boat
	 */
	public Boat getBoat() {
		return boat;
	}

	/**
	 * @param boat the boat to set
	 */
	public void setBoat(Boat boat) {
		this.boat = boat;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		State other = (State) obj;
		if (boat == null) {
			if (other.boat != null)
				return false;
		} else if (!boat.equals(other.boat))
			return false;
		if (leftShore == null) {
			if (other.leftShore != null)
				return false;
		} else if (!leftShore.equals(other.leftShore))
			return false;
		if (rightShore == null) {
			if (other.rightShore != null)
				return false;
		} else if (!rightShore.equals(other.rightShore))
			return false;
		return true;
	}

	public boolean move(int cannibals, int missionaries, Boat boat) {
		this.boat=new Boat(boat);
		int shoreC = 0;
		int shoreM = 0;
		if (boat.isOnLeft()) {
			shoreC = leftShore.getCannibals();
			shoreM = leftShore.getMissionaries();

			if (shoreC < cannibals)
				return false;
			if (shoreM < missionaries)
				return false;

			leftShore.setMissionaries(shoreM - missionaries);
			leftShore.setCannibals(shoreC - cannibals);
			rightShore.setMissionaries(rightShore.getMissionaries()
					+ missionaries);
			rightShore.setCannibals(rightShore.getCannibals() + cannibals);
		} else {
			shoreC = rightShore.getCannibals();
			shoreM = rightShore.getMissionaries();

			if (shoreC < cannibals)
				return false;
			if (shoreM < missionaries)
				return false;

			rightShore.setMissionaries(shoreM - missionaries);
			rightShore.setCannibals(shoreC - cannibals);
			leftShore.setMissionaries(leftShore.getMissionaries()
					+ missionaries);
			leftShore.setCannibals(leftShore.getCannibals() + cannibals);
		}
		this.boat.pass();
		return true;
	}

	public boolean isFinal() {
		return rightShore.isFull();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[l:" + leftShore + ", r:" + rightShore  +", "+boat+ "]";
	}

}
