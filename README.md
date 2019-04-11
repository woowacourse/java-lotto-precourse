# 로또 _ 우아한 테크코스 3주차 미션



#### 기능 요구사항

- 로또 게임 기능을 구현한다.
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 한장의 가격은 1000원이다.
- 로또 당첨 금액은 고정되어있다.
- 수익률을 계산해 출력한다.



#### 프로그래밍 요구사항

- 자바 코드 컨벤션을 준수한다.

- else 예약어를 사용하지 않는다.

- 접근제어자를 용도에 맞게 사용한다.

- 메소드의 길이가 10라인을 넘어가지 않도록 구현한다.

- indent를 1까지 허용한다.

- 메소드의 인자 수를 3개 까지 허용한다.

- 아래의 객체에 다음과 같은 요구사항을 만족시킨다.

  - ~~~java
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
    ~~~

    - 다음 Lotto 객체를 활용해 구현해야 한다.
    - Lotto 기본 생성자를 추가할 수 없다.
    - numbers 변수의 접근 제어자인 private을 변경할 수 없다.
    - Lotto에 필드(인스턴스 변수)를 추가할 수 없다.

    

  - ~~~java
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
    ~~~

    - 다음 WinningLotto객체를 활용해 구현해야 한다.
    - match() 메소드의 반환 값인 Rank는 저장소에서 제공한다.
    - WinningLotto 기본생성자를 추가할 수 없다.
    - lotto, bonusNo변수의 접근 제어자인 private을 변경할 수 없다.
    - WinningLotto에 필드(인스턴스변수)를 추가할 수 없다.



#### 구현 기능 목록

1. 로또 구입 금액 입력

   1-1. 입력된 금액이 정상적인지 확인

2. 입력된 금액에 따른 로또 발급

   2-1. 로또 발급 시 각 번호는 중복 불가

   2-2. 로또 발급 시 각 번호는 1~45 사이

3. 당첨 번호 입력

   3-1. 입력된 번호들이 1~45 사이인지 확인

   3-2. 입력된 번호들은 중복될 수 없음

4. 보너스 번호 입력

   4-1. 입력된 번호가 1~45 사이인지 확인

5. 당첨 통계 출력

   5-1. 당첨된 복권의 개수를 확인한다

   5-2. 그에 따른 수익률을 계산 및 출력한다.



main class // 메인

Game class // 로또 게임 시작

init // 모든 클래스 초기화

IO class // 입출력

Lotto class // 로또 한장을 의미하는 객체

Rank class // 로또 등수를 의미하는 enum

WinningLotto // 당첨 번호를 담당하는 객체



​	

