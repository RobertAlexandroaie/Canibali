package model;

public class Boat {
	private Boolean onLeft = true;
	private Boolean onRight = false;

	public Boat() {

	}

	public Boat(Boat boat) {
		onLeft = boat.isOnLeft();
		onRight = boat.isOnRight();
	}

	/**
	 * @return the isOnLeft
	 */
	public Boolean isOnLeft() {
		return onLeft;
	}

	/**
	 * @param isOnLeft
	 *            the isOnLeft to set
	 */
	public void setOnLeft(Boolean isOnLeft) {
		this.onLeft = isOnLeft;
	}

	/**
	 * @return the isOnRight
	 */
	public Boolean isOnRight() {
		return onRight;
	}

	/**
	 * @param isOnRight
	 *            the isOnRight to set
	 */
	public void setOnRight(Boolean isOnRight) {
		this.onRight = isOnRight;
	}

	public void pass() {
		onLeft = !onLeft;
		onRight = !onRight;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((onLeft == null) ? 0 : onLeft.hashCode());
		result = prime * result + ((onRight == null) ? 0 : onRight.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		Boat other = (Boat) obj;
		if (onLeft == null) {
			if (other.onLeft != null)
				return false;
		} else if (!onLeft.equals(other.onLeft))
			return false;
		if (onRight == null) {
			if (other.onRight != null)
				return false;
		} else if (!onRight.equals(other.onRight))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (isOnLeft()) {
			return "left";
		} else {
			return "righ";
		}
	}

}
