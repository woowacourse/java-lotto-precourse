package domain;

public enum ErrMsg {
	InputMismatchErr("자연수를 입력해야 합니다!"),
	InputTooSmallErr("0보다 큰 수를 입력해야 합니다."),
	NotEnoughMoneyErr("로또를 살 수 없는 금액입니다."),
	OutOfRangeErr("1 - 45 사이 수를 입력해야 합니다."),
	NumLengthErr("6개의 수를 입력해야 합니다.");
	
	String errMsg;
	private ErrMsg(String errMsg){
		this.errMsg = errMsg; 
	}
	
	public String getMsg() {
		return errMsg;
	}
}
