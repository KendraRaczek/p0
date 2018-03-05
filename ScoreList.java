////////////////////////////////////////////////////////////////////////////////
// Semester:         CS367 Spring 2017 
// PROJECT:          p0
// FILE:             ScoreList.java
//
// Author: Kendra Raczek
//
// ---------------- OTHER ASSISTANCE CREDITS 
// 
// Online sources: 
// http://stackoverflow.com/questions/14666611/how-do-i-shift-array-elements-
// up-one-position-in-java : description of how to shift elements in array 
// after removing an element
////////////////////////////////////////////////////////////////////////////////

/**
 * An implementation of ScoreListADT that contains references to instances of 
 * Score objects in a contiguous and ordered list.
 *
 * <p>Bugs: none
 *
 * @author Kendra Raczek
 */
public class ScoreList implements ScoreListADT {

	// List of Score objects
	private Score[] scores;
	
	/**
	 * Constructs a ScoreList object and initializes a new list of Score 
	 * objects
	 *
	 * @throws IllegalArgumentException
	 */
	public ScoreList() {
		scores = new Score[0];
	}
	
	/** 
	 * Returns the size as the number of Scores currently in the list
	 * 
	 * @return the number of scores in the list
	 */
	@Override
	public int size() {
		return scores.length;
	}

	/**
	 * Adds score to the end of this list, expanding the array to keep the
	 * list contiguous
	 *
	 * PRECONDITIONS: 
	 * 
	 * POSTCONDITIONS: the list is expanded and stores the new score at the
	 * end of the list
	 *
	 * @param s: the score to add as the last Score object in the list
	 * @throws IllegalArgumentException
	 */
	@Override
	public void add(Score s) throws IllegalArgumentException {
		if (s == null) {
			throw new IllegalArgumentException();
		}
		
		expandList();
		scores[scores.length-1] = s;
	}

	/**
	 * Removes and returns the Score object at given index position.
	 * If i is less than zero or greater than size()-1,
	 * will throw an IndexOutOfBoundsException.
	 *
	 * PRECONDITIONS:
	 * 
	 * POSTCONDITIONS: the Score list references a new array that holds the 
	 * same objects except for the removed Score
	 *
	 * @param i: the index at which the Score is being removed in the list
	 * @return the indicated Score to remove at index i
	 * @throws IndexOutOfBoundsException
	 */
	@Override
	public Score remove(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i > size() - 1) {
			throw new IndexOutOfBoundsException();
		}
		
		// Score to remove
		Score removeScore = scores[i];
		// New list that original wanted scores will be copied to
		Score[] newScores = new Score[scores.length-1];
		
	    int k = 0;
	    for (int j = 0; j < scores.length; ++j) {
	        if (scores[j] != removeScore) {
	            newScores[k] = scores[j];
	            ++k;
	        }  
	    }
	    scores = newScores;
		return removeScore;
	}

	/**
	 * Returns the Score object at given index i.
	 * If i is less than zero or greater than size()-1,
	 * will throw an IndexOutOfBoundsException.
	 * 
	 * PRECONDITIONS: the index i is assumed to be non-null
	 * 
	 * POSTCONDITIONS: returns accessed score, does not alter list
	 *
	 * @param i: the position of the accessed Score object in the list
	 * @return the indicated Score at index i
	 * @throws IndexOutOfBoundsException
	 */
	@Override
	public Score get(int i) throws IndexOutOfBoundsException {
		if (i > scores.length - 1 || i < 0) {
			throw new IndexOutOfBoundsException();
		}
		return scores[i];
	}
	
	/**
	 * Changes list of Score objects by adding an additional space at the 
	 * end of the list while storing the same original scores
	 *
	 * PRECONDITIONS: the Score list is non-null
	 * 
	 * POSTCONDITIONS: Score list references new list that holds the same 
	 * Score objects and an empty last index of the array
	 */
	private void expandList() {
		// New list 1 index larger that original scores will be copied to
	    Score[] newScores = new Score[scores.length + 1];

	    for(int i = 0; i < scores.length; i++)
	        newScores[i] = scores[i];
	    this.scores = newScores;
	}
}
