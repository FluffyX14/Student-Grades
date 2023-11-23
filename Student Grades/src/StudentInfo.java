public class StudentInfo {
	
	String name;
	double finalAverage;
	
	//default constructor
	public StudentInfo(String n, double[] t, double[] q, double h, int tCounter, int qCounter) {
		name = n;
		
		double testAverage = 0;
		for (int i = 0; i < tCounter; i++) {
			testAverage += t[i];
		}
		testAverage /= tCounter;
		
		double quizAverage = 0;
		for (int i = 0; i < qCounter; i++) {
			quizAverage += q[i];
		}
		quizAverage /= qCounter;
		
		finalAverage = .5 * testAverage + .3 * quizAverage + .2 * h;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getFinalAverage() {
		return finalAverage;
	}

	public void setFinalAverage(double finalAverage) {
		this.finalAverage = finalAverage;
	}

}