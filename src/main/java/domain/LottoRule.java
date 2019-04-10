package domain;

public enum LottoRule {
	BEGINNUM(1),
	ENDNUM(45),
	LottoLENGTH(6),
	PRICE(1000),
	REWARDS(new int[]{5000, 50000, 1500000, 30000000, 2000000000}),
	RANKNAMES(new String[] {"3개 일치(5000원) - ", "4개 일치(50000원) - ", "5개 일치(1500000원) - ",
			"5개일치,보너스볼일치(30000000원) - ", "6개일치(2000000000원) - " });
	
	int numericVal;
	String[] strArrVal;
	int[] numArrVal;
	private LottoRule(int num) {
		this.numericVal = num;
	}
	private LottoRule(String[] strArr) {
		this.strArrVal = strArr;
	}
	private LottoRule(int[] numArr) {
		this.numArrVal = numArr;
	}
	
	public int getNum() {
		return numericVal;
	}
	public String[] getNames() {
		return strArrVal;
	}
	public int[] getNums() {
		return numArrVal;
	}
}
