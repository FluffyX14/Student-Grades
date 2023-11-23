public class AllStudents {
	 
	String name;
	double finalAverage;
	
	public AllStudents(String n, double f) {
		name = n;
		finalAverage = f;
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

	public AllStudents [] sortByFinal(AllStudents arr[], int nameCounter){
		int n = nameCounter;
		// One by one move boundary of unsorted subarray
		for (int i = 0; i < n-1; i++) {
			// Find the minimum element in unsorted array
			int min_idx = i;
			for (int j = i+1; j < n; j++){
				if (arr[j].getFinalAverage() > arr[min_idx].getFinalAverage())
	                   min_idx = j;
			}
			// Swap the found minimum element with the first element
			AllStudents temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
		}
		return arr;
	}
	
	public AllStudents [] sortByAlphabet(AllStudents arr[], int nameCounter){
		int n = nameCounter;
		// One by one move boundary of unsorted subarray
		for (int i = 0; i < n-1; i++) {
			// Find the minimum element in unsorted array
			int min_idx = i;
			for (int j = i+1; j < n; j++){
				if (arr[j].getName().compareTo(name) < arr[min_idx].getName().compareTo(name))
	                   min_idx = j;
			}
			// Swap the found minimum element with the first element
			AllStudents temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
		}
		return arr;
	}
}
