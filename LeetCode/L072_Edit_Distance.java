package LeetCode;

public class L072_Edit_Distance {

	public static int minDistance(String word1, String word2) {

		if (word1.equals(word2)) {
			return 0;
		}

		if (word1.length() == 0) {
			return word2.length();
		}

		if (word2.length() == 0) {
			return word1.length();
		}

		char[] w1 = word1.toCharArray();
		char[] w2 = word2.toCharArray();

		// (m+1)*(n+1)�ľ���
		int[][] d = new int[w1.length + 1][w2.length + 1];

		// ��ʼ����0��
		for (int i = 0; i <= w1.length; i++) {
			d[i][0] = i;
		}

		// ��ʼ����0��
		for (int i = 0; i <= w2.length; i++) {
			d[0][i] = i;
		}

		for (int i = 1; i <= w1.length; i++) {
			for (int j = 1; j <= w2.length; j++) {

				if (w1[i - 1] == w2[j - 1]) {
					d[i][j] = d[i - 1][j - 1];
				} else {
					d[i][j] = Math.min(d[i - 1][j] + 1,// ɾ������
							Math.min(d[i][j - 1] + 1,// �������
									d[i - 1][j - 1] + 1));// �滻����
				}
			}
		}

		return d[w1.length][w2.length];
	}
}
