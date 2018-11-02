
public class FloydWarshall implements CaminosCostoMinimo{

	@Override
	public int[][] calculateMinimumCost(int[][] costosEjes) {
		// TODO Auto-generated method stub
		int[][] resp = new int[costosEjes.length][costosEjes.length];
		for (int k = 0; k < costosEjes.length; k++) {
			for (int i = 0; i < costosEjes.length; i++) {
				for (int j = 0; j < costosEjes.length; j++) {
					if (k == 0) {
						resp[i][j]=0;
					}
					else {
						resp[i][j] = Math.min(costosEjes[i][j], costosEjes[k][j]+costosEjes[i][k]);
					}
				}
			}
		}
		return null;
	}

}
