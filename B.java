import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

/*


let x = final grade

x = sum of N - 2 scores
  = a[1] + a[2] + ... a[N-2]

basically, exclude the lowest & highest

goal:
- min score that you must earn in round N
- final grade should be >= x

0 <= score in round N <= 100

--------------------

5 180
40 60 80 50

ans: 70

--------------------

10 480
59 98 88 54 70 24 8 94 46

sorted:
8 24 46 54 59 70 88 94 98



ans: 45

--------------------

 */

public class B {
	
	public static void main(String[] args) {
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
//		T = fs.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = fs.nextInt(), x = fs.nextInt();
			int[] a = fs.readArray(n - 1);
			int[] temp = new int[n];
			int min = -1;
			for (int i = 0; i <= 100; i++) {
				for (int j = 0; j < n - 1; j++) {
					temp[j] = a[j];
				}
				temp[n-1] = i;
				shuffleSort(temp);
				int sum = 0;
				for (int j = 1; j < n - 1; j++) {
					sum += temp[j];
				}
				if (sum >= x) {
					min = i;
					break;
				}
			}
			System.out.println(min);
		}
		out.close();
	}
	
	static final Random rnd = new Random();
	static void shuffleSort(int[] a) { //change this
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int newInd = rnd.nextInt(n);
			int temp = a[newInd]; //change this
			a[newInd] = a[i];
			a[i] = temp;
		}
		Arrays.sort(a);
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long[] readLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextLong();
			}
			return a;
		}
		
		double[] readDoubleArray(int n) {
			double[] a = new double[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextDouble();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				if (st.hasMoreTokens()) {
					str = st.nextToken("\n");
				} else {
					str = br.readLine();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
