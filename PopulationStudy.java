// Unit 4, Assignment 1

import java.util.*;

class Creature {
    String color = "";
    double x=0, y=0;
    boolean isAlive = true;
}

public class PopulationStudy {

    static double moveDistance = 0.1;
    static double eatDistance = 0.3;

    static int numPredators = 10;
    static int numPrey = 20;
    static int numFoodSources = 30;

    static LinkedList<Creature> predators;
    static LinkedList<Creature> prey;
    static LinkedList<Creature> food;

    public static void main (String[] argv)
    {
	DrawTool.display ();
	DrawTool.setXYRange (0,10, 0,10);

	DrawTool.startAnimationMode ();

	int step = 0;
	int maxSteps = 100;

	// Make one list each of predators, prey, and food
	makeCreatureLists ();

	while (step < maxSteps) {
	    DrawTool.writeTopString ("Step: " + step);
	    DrawTool.animationPause (100);

	    // DrawTool.drawCircle (step,step, 0.2);

	    // Move prey toward food
	    movePrey ();
	    // Move predators toward prey
	    movePredators ();
	    // Draw the creatures
	    draw ();
	    //Stop if prey-list is emty
	    if (preyAllEaten()) break;
	    
	    step++;
	}

	DrawTool.endAnimationMode ();
    }


    static void makeCreatureLists ()
    {
	Random rand = new Random ();
	
	predators = new LinkedList<> ();
	for (int i=0; i<numPredators; i++) {
	    Creature c = new Creature ();
	    c.x = 10 * rand.nextDouble ();
	    c.y = 10 * rand.nextDouble ();
	    c.color = "red";
	    predators.add (c); // Note "(L)" in script. A typo?
	}

	// prey (color "blue")
	prey = new LinkedList<> ();
	for (int i=0; i<numPrey; i++) {
	    Creature c = new Creature ();
	    c.x = 10 * rand.nextDouble ();
	    c.y = 10 * rand.nextDouble ();
	    c.color = "blue";
	    prey.add (c); 
	}
	
	// food (color "green")
	food = new LinkedList<> ();
	for (int i=0; i<numFoodSources; i++) {
	    Creature c = new Creature ();
	    c.x = 10 * rand.nextDouble ();
	    c.y = 10 * rand.nextDouble ();
	    c.color = "green";
	    food.add (c); // Note "(L)" in script. A typo?
	}
    }

    
    static void movePrey ()
    {
	// For each prey
	for (Creature p: prey) {
	    // Find closest food
	    Creature goal = null;
	    double bestDistance = 10000; // Some large initial number
	    for (Creature F: food) {
		if ( (F.isAlive) && (distance(p,F) < bestDistance) ) {
		    goal = F;
		    bestDistance = distance(p,F);
		}
	    }

	    // Move toward goal.
	    if (goal != null) {
		if (goal.x > p.x) {
		    p.x = p.x + moveDistance;
		}
		else {
		    p.x = p.x - moveDistance;
		}
		if (goal.y > p.y) {
		    p.y = p.y + moveDistance;
		}
		else {
		    p.y = p.y - moveDistance;
		}
	    }
	    // What about if x's or y's are equal?

	    // Check if it can be eaten
	    if ( (goal!=null) && (distance(p,goal) < eatDistance) ) {
		goal.isAlive = false;
	    }

	}
    } // end-of-movePrey

    
    static void movePredators ()
    {
	for (Creature P: predators) {
	    // Find closest prey
	    Creature goal = null;
	    double bestDistance = 10000; // Some large initial number
	    for (Creature p: prey) {
		if ( (p.isAlive) && (distance(P,p) < bestDistance) ) {
		    goal = p;
		    bestDistance = distance(P,p);
		}
	    }

	    // Move toward goal.
	    if (goal != null) {
		if (goal.x > P.x) {
		    P.x = P.x + moveDistance;
		}
		else {
		    P.x = P.x - moveDistance;
		}
		if (goal.y > P.y) {
		    P.y = P.y + moveDistance;
		}
		else {
		    P.y = P.y - moveDistance;
		}
	    }
	    // What about if x's or y's are equal?

	    // Check if it can be eaten
	    if ( (goal!=null) && (distance(P,goal) < eatDistance) ) {
		goal.isAlive = false;
	    }
	}
    } // end-of-movePredators

    
    static double distance (Creature a, Creature b)
    {
	return Math.sqrt(
			  ( (b.x-a.x)*(b.x-a.x) ) +
			  ( (b.y-a.y)*(b.y-a.y) )

			 );
    }

    
    static void draw () {
	for (Creature c: predators) {
	    DrawTool.setCircleColor (c.color);
	    DrawTool.drawCircle (c.x, c.y, 0.1);
	}

	for (Creature c: prey) {
	    if (c.isAlive) {
		DrawTool.setCircleColor (c.color);
		DrawTool.drawCircle (c.x, c.y, 0.1);
	    }
	}

	for (Creature c: food) {
	    if (c.isAlive) {
		DrawTool.setCircleColor (c.color);
		DrawTool.drawCircle (c.x, c.y, 0.1);
	    }
	}

    }
    

    static boolean preyAllEaten ()
    {
	for (Creature p: prey) {
	    if (p.isAlive) return false;
	}
	return true;
    }
    
}
