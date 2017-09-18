package 笔试.大疆;

import java.util.Scanner;

public class 出门最佳 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int m = in.nextInt();
			int start_row = in.nextInt();
			int start_col = in.nextInt();
			int target_row = in.nextInt();
			int target_col = in.nextInt();
			int[][] martix = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					martix[i][j] = in.nextInt();
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (martix[i][j] > 1) {
						int flag = martix[i][j];
						for (int k = i - 1; k >= 0 && k >= i - flag - 1; k--) {
							martix[k][j] = flag * -1;
						}
						for (int k = i + 1; k < n && k <= i + flag - 1; k++) {
							martix[k][j] = flag * -1;
						}
						for (int k = j - 1; k >= 0 && k >= j - flag - 1; k--) {
							martix[i][k] = flag * -1;
						}
						for (int k = j + 1; k < m && k <= j + flag - 1; k++) {
							martix[i][k] = flag * -1;
						}
					}
				}
			}

			// for(int i=0;i<n;i++) {
			// for(int j=0;j<m;j++) {
			// System.out.print(martix[i][j]+" ");
			// }
			// System.out.println();
			// }

			int[][] dp = new int[n + 1][m + 1];

			for (int i = 0; i <= n; i++) {
				dp[i][0] = -1;
			}
			for (int i = 0; i <= m; i++) {
				dp[0][i] = -1;
			}

			dp[1][1] = 0;

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					if (i != 1 || j != 1) {
						if (martix[i - 1][j - 1] == 0) {
							if (dp[i - 1][j] != -1 && dp[i][j - 1] != -1)
								dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
							else if (dp[i - 1][j] == -1 && dp[i][j - 1] != -1)
								dp[i][j] = dp[i][j - 1] + 1;
							else if (dp[i - 1][j] != -1 && dp[i][j - 1] == -1)
								dp[i][j] = dp[i - 1][j] + 1;
							else
								dp[i][j] = -1;
						} else
							dp[i][j] = -1;
					}
				}
			}

			for (int i = 0; i <= n; i++) {
				for (int j = 0; j <= m; j++) {
					System.out.print(dp[i][j] + " ");
				}
				System.out.println();
			}
			//
			if (martix[target_row][target_col] != 0)
				System.out.println(-1);
			else if (dp[target_row + 1][target_col + 1] != -1)
				System.out.println(dp[target_row + 1][target_col + 1]);
			else
				System.out.println(-1);

		}
	}
}
