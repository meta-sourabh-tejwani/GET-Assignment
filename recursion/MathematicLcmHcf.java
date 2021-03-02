class LcmHcf
{
	public int getHighestCommonFactor(int x, int y) {
		if (y == 0) {
			return x;
		}
		return getHighestCommonFactor(y, x % y);
	}

	public int getLowestCommomFactor(int x, int y) {
		return (x / getHighestCommonFactor(x, y)) * y;
	}
}

