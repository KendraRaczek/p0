////////////////////////////////////////////////////////////////////////////////
// Semester:         CS367 Spring 2017 
// PROJECT:          p0
// FILE:             Score.java
//
// Author: Kendra Raczek
//
// ---------------- OTHER ASSISTANCE CREDITS 
// 
////////////////////////////////////////////////////////////////////////////////

/**
 * Creates and deals with instances of Score objects that store a name, points 
 * earned, and points possible for each Score instance. 
 *
 * <p>Bugs: none
 *
 * @author Kendra Raczek
 */
public class Score {
	
	// Name of assignment
	private String name;
	// Number of points earned
	private double ptsEarned;
	// Number of total points possible
	private double ptsPossible;
	
	/**
	 * Constructs a new Score object, initializing name, points earned, and 
	 * points possible for each instance of Score.
	 *
	 * PRECONDITIONS: the points earned and points possible are assumed to be 
	 * non-null
	 * 
	 * POSTCONDITIONS: the fields of the Score instance are initialized
	 *
	 * @param name: the name of the assignment the score is being used for
	 * @param ptsEarned: the number of points earned
	 * @param ptsPossible: the total number of points possible for each
	 * assignment
	 * @throws IllegalArgumentException
	 */
	public Score(String name, double ptsEarned, double ptsPossible) 
			throws IllegalArgumentException{
		
		if (name == null || ptsEarned < 0 || ptsPossible < 0 || 
				ptsEarned > ptsPossible) {
			throw new IllegalArgumentException();
		}
		
		this.name = name;
		this.ptsEarned = ptsEarned;
		this.ptsPossible = ptsPossible;
		
	}
	
	/**
	 * Allows access to the name of the assignment of a Score instance
	 *
	 * @return the name of the assignment
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Allows access to the number of points earned of a Score instance
	 *
	 * @return the number of points earned
	 */
	public double getPoints() {
		return ptsEarned;
	}
	
	/**
	 * Allows access to the total number of points possible of a Score instance
	 *
	 * @return the total number of points possible
	 */
	public double getMaxPossible() {
		return ptsPossible;
	}
	
	/**
	 * Allows access to the category of a Score instance, which is the first
	 * character in the name
	 *
	 * @return the first character in the name of the assignment
	 */
	public String getCategory() {
		return name.substring(0,1);
	}
	
	/**
	 * Allows access to the total percentage of points earned vs. points
	 * possible of a Score instance
	 *
	 * @return the percentage of points earned
	 */
	public double getPercent() {
		return (ptsEarned / ptsPossible) * 100;
	}
}
