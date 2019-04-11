package validation;

/**
 * 입력값의 유효성을 검사하고 원하는 값으로 변환하는 인터페이스
 */
public interface Validation<T> {
	boolean check(String value);
	T convert(String value);
}
