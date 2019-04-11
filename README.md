3주차 미션 - 로또🤑
=======================

### 프로그래밍 요구사항

1. 자바 코드 컨벤션을 지키면서 프로그래밍한다.
2. indent(인덴트, 들여쓰기) depth를 1~~3~~이 넘지 않도록 구현한다. ~~2까지만 허용한다.~~
    + 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다. 
    + 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
3. 함수(또는 메소드)의 길이가 10~~15~~라인을 넘어가지 않도록 구현한다.
    + 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라.
4. else 예약어를 쓰지 않는다.
    + 힌트 : if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    + else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
5. public/protected/private/package 접근 제어자를 용도에 적합하게 사용해 구현한다.
6. 함수(또는 메소드)의 인자 수를 3개까지만 허용한다. 4개 이상은 허용하지 않는다.

### 기능 요구사항

1. 로또 게임 기능을 구현해야 한다. 규칙을 모르면 검색해 로또 규칙을 찾아본다.
2. 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
3. 로또 1장의 가격은 1000원이다.
4. 로또 당첨 금액은 고정되어 있는 것으로 가정한다.
5. 수익률을 계산해 출력해야 한다.

### 객체 요구사항

1. 객체 1
    ```java
    public class Car {
        private final List<Integer> numbers;

        public Lotto(List<Integer> numbers) {
            this.numbers = numbers;
        }
        // 추가 기능 구현
    }
    ```
    + 다음 Lotto 객체를 활용해 구현해야 한다.
    + Lotto 기본 생성자를 추가할 수 없다.
    + numbers 변수의 접근 제어자인 private을 변경할 수 없다.
    + Lotto에 필드(인스턴스 변수)를 추가할 수 없다.

2. 객체 2
    ```java
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
    + 다음 WinningLotto 객체를 활용해 구현해야 한다.
    + match() 메소드의 반환 값인 Rank는 저장소에서 제공한다.
    + WinningLotto 기본 생성자를 추가할 수 없다.
    + lotto, bonusNo 변수의 접근 제어자인 private을 변경할 수 없다.
    + WinningLotto에 필드(인스턴스 변수)를 추가할 수 없다.

### 기능 정리

+ 사용자에게 받은 금액 만큼의 로또를 발급한다.
+ 로또 한장의 금액은 1000원이다.
+ 금액 입력값은 1000원 단위로 이루어 진다.
+ 금액 입력값은 숫자로만 이루어 진다.
+ 로또는 한장에 6개의 서로 다른 숫자로 이루어 진다.
+ 1개의 숫자는 1~45중 하나이다.
+ 당첨 번호는 사용자에게 입력 받는다.
+ 당첨 번호 역시 1~45의 서로 다른 6개의 숫자이다.
+ 당첨 번호 6개를 제외한 1~45의 숫자 하나를 보너스 넘버로 입력 받는다.
+ 발급한 로또와 입력 받은 로또를 비교해 등수를 가린다.
+ 등수 결과값을 통해 통계를 내서 수익률을 계산한다.
