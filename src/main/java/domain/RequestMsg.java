package domain;

public enum RequestMsg {
	WinningLotto("지난 주 당첨 번호를 입력해 주세요.(예: 1,2,3,4,5,6)"),
	BonusNum("보너스 볼을 입력해 주세요."),
	SetNum("구입 금액을 입력해주세요.(개당 천원입니다.)"),
	Result("개를 구매했습니다.");
	
	String requestMsg;
	private RequestMsg(String requestMsg) {
		this.requestMsg = requestMsg;
	}
	
	public String getMsg() {
		return requestMsg;
	}
}
