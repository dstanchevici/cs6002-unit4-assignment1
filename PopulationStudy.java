// Unit 4, Assignment 1

public class PopulationStudy {

    public static void main (String[] argv)
    {
	DrawTool.display ();
	DrawTool.setXYRange (0,10, 0,10);

	DrawTool.startAnimationMode ();

	int step = 0;
	int maxSteps = 100;

	while (step < maxSteps) {
	    DrawTool.writeTopString ("Step: " + step);
	    DrawTool.animationPause (100);

	    DrawTool.drawCircle (step,step, 0.2);
	    
	    step++;
	}
    }
    
}
