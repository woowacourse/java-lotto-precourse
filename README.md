로또
===
>우아한 테크코스 3주차 미션

기능 요구사항
---
* 로또 게임 기능을 구현해야 한다. 
* 규칙을 모르면 검색해 로또 규칙을 찾아본다.
* 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
* 로또 1장의 가격은 1000원이다.
* 로또 당첨 금액은 고정되어 있는 것으로 가정한다.
* 수익률을 계산해 출력해야 한다.

프로그래밍 요구사항
---


```java
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
* 다음 Lotto 객체를 활용해 구현해야 한다.
* Lotto 기본 생성자를 추가할 수 없다.
* numbers 변수의 접근 제어자인 private을 변경할 수 없다. •
* Lotto에 필드(인스턴스 변수)를 추가할 수 없다.
---
```java
/**
 * 당첨 번호를 담당하는 객체
*/
    public class WinningLotto {     
    private final Lotto lotto;
    private final int bonusNo;
    
    public WinningLotto(Lotto lotto,int bonusNo) {  
        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }
    public Rank match(Lotto userLotto) {
        // TODO 로직 구현
        return null;
    }
 }
```
* 다음 WinningLotto 객체를 활용해 구현해야 한다.
* match() 메소드의 반환 값인 Rank는 저장소에서 제공한다. 
* WinningLotto 기본 생성자를 추가할 수 없다.
* lotto, bonusNo 변수의 접근 제어자인 private을 변경할 수 없다. 
* WinningLotto에 필드(인스턴스 변수)를 추가할 수 없다.

---

* 자바 코드 컨벤션 지키며 프로그래밍한다.
* else 예약어 사용하지 않는다.
* public/protected/private/package 접근 제어자를 용도에 적합하게 사용해 구현한다.
* 함수(또는 메소드)의 길이가 **10라인**을 넘어가지 않도록 구현한다.
* 인덴트를 1까지 허용한다.
* 함수의 인자 수를 3개까지 허용한다.
---
기능 구현 목록
---
* [x] 로또 구입 금액 입력
    1. [x] 정수 외 입력 금지
    2. [x] 정수 표현 범위 초과하지 않는 범위 지정
* [x] 로또 구입 숫자 구함
* [x] 1부터 45까지의 숫자가 겹치지 않게 6개 숫자 생성
* [x] 구입 로또 만큼의 로또 객체 생성
    1. [x] 구입 금액이 1000원 단위 아닐시 잔돈 출력
* [x] 내 로또 숫자 출력
* [x] 당첨 번호 입력
    1. [x] 5개 숫자가 맞는지 확인
    2. [x] 범위 내 숫자인지 확인
* [x] 당첨 보너스 번호 입력
    1. [x] 정수 외 입력 금지
    2. [x] 앞의 로또 숫자와 일치하는 숫자 없는지 확인
* [x] 등수 별 당첨 갯수 구함
    1. [x] 5등 (3개 일치, 5000원)
    2. [x] 4등 (4개 일치, 50000원)
    3. [x] 3등 (5개 일치, 1500000원)
    4. [x] 2등 (5개 일치 + 보너스 볼 일치, 30000000원)
    5. [x] 1등 (6개 일치, 2000000000원)
* [x] 당첨 목록 출력
* [x] 총 수익금 산출
* [ ] 수익률 산출 (수익금/당첨금)
* [ ] 수익률 출력