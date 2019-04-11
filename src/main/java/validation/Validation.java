package validation;

/**
 * Validation 객체는 입력받은 데이터를 검증하고 변환을 해준다.
 *
 * @author 조남균
 */
public interface Validation<T> {
	boolean check(String value);
	T convert(String value);
}
