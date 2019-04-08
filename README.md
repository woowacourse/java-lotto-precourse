# java-lotto
1000원 짜리 로또 n장을 구매한 뒤, 당첨 금액에 따른 수익률을 계산하는 프로그램

## 프로그래밍 요구사항
* 다음 Lotto class를 활용해 구현한다. **(단, 아래의 제약 조건을 준수해야 한다.)**
    * numbers의 접근 제어자를 변경할 수 없다
    * Lotto 기본 생성자를 추가할 수 없다
    * Lotto에 필드(인스턴스 변수)를 추가할 수 없다

```$java 
import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private final List<Integer> numbers;
   
    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }
    // 추가 기능 구현
}
```
* 다음 WinningLotto 객체를 활용해 구현한다. **(단, 아래의 제약 조건을 준수해야 한다.)**
    * match() 메소드의 반환 값인 Rank는 미리 제공된 클래스를 사용한다
    * WinningLotto 기본 생성자를 추가할 수 없다
    * lotto, bonusNo의 접근 제어자를 변경할 수 없다
    * WinningLotto에 필드(인스턴스 변수)를 추가할 수 없다
    
```$java
/**
 * 당첨 번호를 담당하는 객체
 */
public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNo;
    
    public WinningLotto(Lotto lotto, int bonusNo) {
        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    public Rank match(Lotto userLotto) {
        // TODO 로직 구현
        return null;
    }
}
```
* 여러 개의 클래스를 분리한 후, 서로 관계를 맺어 프로그램을 완성한다.
* 다양한 예외 케이스를 고려하여 구현한다

## 기능 요구사항
* 로또 게임 기능을 구현해야 한다.
* 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
* 로또 1장의 가격은 1000원이다.
* 로또 당첨 금액은 고정되어 있는 것으로 가정한다.
* 수익률을 계산해 출력해야 한다.

## 구현할 기능 목록
* 구입한 로또와 당첨 로또를 비교하여 당첨 여부를 판별한다
* 당첨 통계와 수익률을 출력한다

## 구현된 기능 목록
1. 입력값은 오로지 숫자로 이루어져 있어야 한다
    * 정규식을 이용해 입력값이 문자를 포함하는지 확인
        * 이 기능을 사용해 구입 금액, 당첨 번호(쉼표로 구분 된), 보너스 번호가 숫자인지 확인한다.
    * 특이 사항
        * '-'도 문자이므로, 이 기능을 사용하면 양수만 입력 받을 수 있다.
        * '.'도 문자이므로, 이 기능을 사용하면 정수만 입력 받을 수 있다.
2. 입력값은 null이 아니어야 한다
3. 구입 금액은 로또 가격의 배수여야 한다
    * *기능 요구사항*에 거스름 돈을 주는 행위가 존재하지 않기 때문에, 구입 금액이 로또 가격의 배수가 아니라면 잘못된 입력이다.
4. 1~45 범위의 로또 번호를 생성한다
    * (참고) 여기서 로또 번호란, 하나의 로또에 존재하는 6개의 난수를 의미한다. 
5. 유효한 로또 구입 금액을 입력받는다
6. 여러 *로또 번호*들로 구성된 하나의 로또를 생성한다
    * (참고) 여기서 *로또 번호*란, 하나의 로또에 존재하는 6개의 난수를 의미한다.
7. 구입 금액에 해당하는 갯수의 로또를 발행한다
8. 각 당첨 번호는 null이 아니어야 한다
    * 이 기능은 보너스 번호 검증에도 사용한다
9. 각 당첨 번호는 1~45 범위여야 한다
    * 이 기능은 보너스 번호 검증에도 사용한다
10. 유효한 당첨 번호를 구분기호로 구분하여 입력받는다, 리팩토링 수행
    * 구분기호는 쉼표를 사용한다
    * 리팩토링 내용
        * 기존에는 LottoInputHandler가 LottoInputValidator를 사용해 로또 행사의 모든 input을 검증하는 형태로 구현했다
            * input 검증: 입력은 숫자여야 한다, 입력은 양수여야 한다, 입력은 null이 아니여야 한다.
        * **이제 LottInputHandler는 input 검증을 신경쓰지 않는다. 단지 유효한 구입 금액, 당첨 번호를 가져오기만 한다.**
            * PurchaseAmountValidator/WinningNumValidator가 LottoInputValidator를 사용해 입력값을 검증한다.
11. 유효한 보너스 번호를 입력받는다
    * 이제 WinningNumValidator는 BonusNumValidator를 사용해 각 로또 번호가 1~45 범위의 숫자인지 검증한다
12. 입력받은 당첨 번호, 보너스 번호를 사용해 당첨 로또를 생성한다

