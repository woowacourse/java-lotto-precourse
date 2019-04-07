# java-lotto
1000원 짜리 로또 n장을 구매한 뒤, 당첨 금액에 따른 수익률을 계산해본다.

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
0. 입력값은 null이 아니어야 한다
1. 로또 구입 금액 입력값 검증
    1. 구입 금액은 양의 정수여야 한다
    2. 구입 금액은 1000원 단위여야 한다(거스름 돈을 줄 수 없다고 가정)
2. 로또 구입 금액을 입력받는다
3. 로또 번호 생성
    1. 1~45 범위의 로또 번호를 생성한다
4. 구입 금액에 해당하는 갯수의 로또를 발급한다
5. 당첨 번호 입력값 검증
    1. 각 당첨 번호는 1~45 범위여야 한다
    2. 당첨 번호는 총 6개여야 한다
6. 당첨 번호를 쉼표로 구분하여 입력받는다
## 구현된 기능 목록
1. 입력값은 오로지 숫자로 이루어져 있어야 한다
    * 정규식을 이용해 입력값이 숫자인지 확인