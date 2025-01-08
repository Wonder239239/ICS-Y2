public class ParasiteSimulation1 {

	private static final char SYMBOL_GREEN = 'G';
	private static final char SYMBOL_INFECTED = 'I';
	private static final char SYMBOL_DEFOLIATED = 'D';
	
	// 获取行数
	public static int rowCount = 5;
	// 获取列数
	public static int colCount = 5;

	public static int now = 1;

	private static final char[][] DEFAULT_FOREST_1 = { // forest for task 1
			{ SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN } //
			, { SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_INFECTED, SYMBOL_GREEN, SYMBOL_GREEN } //
			, { SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_DEFOLIATED, SYMBOL_DEFOLIATED, SYMBOL_GREEN } //
			, { SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN } //
			, { SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN } //
	};

	private static final char[][] DEFAULT_FOREST_2 = { // forest for task 2
			{ SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_INFECTED, SYMBOL_GREEN, SYMBOL_DEFOLIATED } //
			, { SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN } //
			, { SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN } //
			, { SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN } //
			, { SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN } //
	};

	public static void printarray(){
		System.out.println( "===================");
		System.out.println("Simulation state #"+now);
		System.out.println("-------------------");
		for(int i=0;i<rowCount;i++){
			for(int j=0;j<colCount;j++){
				if(j==colCount-1) System.out.println(DEFAULT_FOREST_1[i][j]+" ");
				else System.out.print(DEFAULT_FOREST_1[i][j]+" ");
			}

		}
		now+=1;
	}


	public static void changearray(){
		char a[][] = new char[5][5];
		for(int i=0;i<rowCount;i++){
			for(int j=0;j<colCount;j++){
				a[i][j]=DEFAULT_FOREST_1[i][j];
			}
		}

		for(int i=0;i<rowCount;i++){
			for(int j=0;j<colCount;j++){
				if(a[i][j]=='I'){
					if(i+1<5&&a[i+1][j]!='D') DEFAULT_FOREST_1[i+1][j]='I';
					if(i-1>=0&&a[i-1][j]!='D') DEFAULT_FOREST_1[i-1][j]='I';
					if(j-1>=0&&a[i][j-1]!='D') DEFAULT_FOREST_1[i][j-1]='I';
					if(j+1<5&&a[i][j+1]!='D') DEFAULT_FOREST_1[i][j+1]='I';
					DEFAULT_FOREST_1[i][j]='D';
				}
				
				if(a[i][j]=='D') DEFAULT_FOREST_1[i][j]='G';
			}
		}
	}

	public static boolean stop(){
		boolean m= false;
		for(int i=0;i<rowCount;i++){
			for(int j=0;j<colCount;j++){
				if(DEFAULT_FOREST_1[i][j]=='G') m = true;
				if(DEFAULT_FOREST_1[i][j]!='G') return false;
			}
		}


		return true;
	}




	public static void main(String[] args) {
		System.out.println("\nParasite Simulation\n");

		// initial states of the forest
		char[][] forestState = DEFAULT_FOREST_1;
		// forestState = DEFAULT_FOREST_2; // for task 2

		// number of generations to be simulated
		int numOfGenerations = 30;
		// your code start here!
		System.out.println( "=============");
		System.out.println("Initial state");
		System.out.println("-------------");
		for(int i=0;i<rowCount;i++){
			for(int j=0;j<colCount;j++){
				if(j==colCount-1) System.out.println(DEFAULT_FOREST_1[i][j]+" ");
				else System.out.print(DEFAULT_FOREST_1[i][j]+" ");
			}
		}



		while(true){
			ParasiteSimulation1.changearray();
			ParasiteSimulation1.printarray();
			if(now==31) break;
			if(stop()) break;

		}
	}

	
}
