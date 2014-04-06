/**
 * 
 */
package model;

/**
 * @author Robert
 * 
 */
public class Shore {
	private int cannibals;
	private int missionaries;

	public Shore(int cannibals, int missionaries) {
		this.cannibals = cannibals;
		this.missionaries = missionaries;
	}

	public Shore(Shore shore) {
		cannibals = shore.getCannibals();
		missionaries = shore.getMissionaries();
	}

	/**
	 * @return the cannibals
	 */
	public int getCannibals() {
		return cannibals;
	}

	/**
	 * @param cannibals
	 *            the cannibals to set
	 */
	public void setCannibals(int cannibals) {
		this.cannibals = cannibals;
	}

	/**
	 * @return the missionaries
	 */
	public int getMissionaries() {
		return missionaries;
	}

	/**
	 * @param missionaries
	 *            the missionaries to set
	 */
	public void setMissionaries(int missionaries) {
		this.missionaries = missionaries;
	}

	public boolean isSafe() {
		if (missionaries == 0) {
			return true;
		} else {
			return missionaries >= cannibals;
		}
	}

	public boolean isFull() {
		return cannibals == 3 && missionaries == 3;
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
		result = prime * result + cannibals;
		result = prime * result + missionaries;
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
		Shore other = (Shore) obj;
		if (cannibals != other.cannibals)
			return false;
		if (missionaries != other.missionaries)
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
		return ""+cannibals + missionaries;
	}

}
