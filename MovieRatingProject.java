
import java.util.*;

public class MovieRatingProject {

    // This is a list of every person's rating of each movie.
    static LinkedList<MovieRating> allRatings;

    // Write code to extract all the movies and all the people
    // into separate lists.
    static LinkedList<String> movies;
    static LinkedList<String> people;

    public static void main (String[] argv)
    {
	
	allRatings = MovieRatings.getRatings ();
	MovieRating r = allRatings.get (2);
	System.out.println ("Example: " + r.name + " has rating " + r.rating + " for " + r.movie);

	// 1. Walk through the list of ratings and extract unique
	// person names, and unique movie titles.
	extractMoviesAndPeople ();
	System.out.println ("All people: " + people);
	System.out.println ("All movies: " + movies);
	
	// 2a. Example of getting movies watched by an individual.
	System.out.println ("Movies watched by Ella: " + getMovies("Ella"));

	
	// 2b. Example of getting people who've watched a certain movie.
	System.out.println ("People who've seen Terminator: " + getPeople("Terminator"));
	
	//3a. Which is the most watched movie?
	System.out.println ("Most watched movie: " + mostWatched());

	
	// 3b. Which is the least?
	System.out.println ("Least watched movie: " + leastWatched());

	// 4a. Which movie has the highest average rating?
	System.out.println ("Movie with highest average rating: " + highestRated());

	// 4b. Which movie has the lowest average rating?
	System.out.println ("Movie with lowest average rating: " + lowestRated());
	/*
	// 5a. Find the two people with the most movies in common.
	mostInCommon ();

	// 5b. Find the two with the fewest movies in common.
	leastInCommon ();
	*/
    }

    static void extractMoviesAndPeople ()
    {
	movies = new LinkedList<> (); // Why not initialize these at global level?
	people = new LinkedList<> ();
	for (MovieRating r: allRatings) {
	    if ( !movies.contains(r.movie) )  movies.add (r.movie);
	    if ( !people.contains(r.name) ) people.add (r.name);
	} 

    }

    
    static LinkedList<String> getMovies (String person)
    {
        LinkedList<String> personMovies = new LinkedList<> ();
	for (MovieRating r: allRatings) {
	    if ( r.name.equals(person) ) personMovies.add (r.movie);
	}
	return personMovies;
    }

    
    static LinkedList<String> getPeople (String movie)
    {
	LinkedList<String> moviePeople = new LinkedList<> ();
	for (MovieRating r: allRatings) {
	    if ( r.movie.equals(movie) ) moviePeople.add (r.name);
	}
	return moviePeople;
    }

    
    static String mostWatched ()
    {
	String mostWatched = "";
	int greatestFrequency = 0;
	
	for (String m: movies) {
	    
	    int mFrequency = 0;
	    for (MovieRating r: allRatings) {
		if ( r.movie.equals(m) ) {
		    mFrequency++;
		} 
	    }
	    
	    if (mFrequency > greatestFrequency) {
		greatestFrequency = mFrequency;
		mostWatched = m;
	    }

	    //System.out.println (m + " has been watched " + mFrequency + " times.");
	}
	
	return mostWatched;
    }

    
    static String leastWatched ()
    {
	String leastWatched = "";
	int lowestFrequency = people.size();
	
	for (String m: movies) {
	    
	    int mFrequency = 0;
	    for (MovieRating r: allRatings) {
		if ( r.movie.equals(m) ) {
		    mFrequency++;
		} 
	    }
	    
	    if (mFrequency < lowestFrequency) {
		lowestFrequency = mFrequency;
		leastWatched = m;
	    }

	    //System.out.println (m + " has been watched " + mFrequency + " times.");
	}
	
	return leastWatched; 

    }

    
    static String highestRated ()
    {
	String highestRated = "";
	double highestAverage = 0.0;
	
	for (String m: movies) {
	    
	    double mRatingSum = 0.0;
	    int numOfRatings = 0;
	    for (MovieRating r: allRatings) {
		if ( r.movie.equals(m) ) {
		    mRatingSum += r.rating;
		    numOfRatings++;
		} 
	    }
	    double mAverage = mRatingSum / numOfRatings;
	    
	    if (mAverage > highestAverage) {
		highestAverage = mAverage;
		highestRated = m;
	    }

	    //System.out.println (m + " has average rating of  " + mAverage + ".");
	}
	
	return highestRated;
    }

    
    static String lowestRated ()
    {
	String lowestRated = "";
	double lowestAverage = 5.0; // Assuming this is the highest possible rating
	
	for (String m: movies) {
	    
	    double mRatingSum = 0.0;
	    int numOfRatings = 0;
	    for (MovieRating r: allRatings) {
		if ( r.movie.equals(m) ) {
		    mRatingSum += r.rating;
		    numOfRatings++;
		} 
	    }
	    double mAverage = mRatingSum / numOfRatings;
	    
	    if (mAverage < lowestAverage) {
		lowestAverage = mAverage;
		lowestRated = m;
	    }

	    //System.out.println (m + " has average rating of  " + mAverage + ".");
	}
	
	return lowestRated;
    }

    /*
    static void mostInCommon ()
    {
	// WRITE YOUR CODE HERE

    }


    static void leastInCommon ()
    {
	// WRITE YOUR CODE HERE

    }
    */

}
