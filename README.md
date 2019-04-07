# 로또

## 기능 요구사항
- 로또 게임 기능을 구현해야 한다. 규칙을 모르면 검색해 로또 규칙을 찾아본다.
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.
- 로또 당처ㅁ 금액은 고정되어 있는 것으로 가정한다.
- 수익률을 계산해 출력해야 한다.

## 프로그래밍 요구사항 - 객체 1

> public class Lotto {  
&nbsp;private final List<Integer> numbers;  
&nbsp;  
&nbsp;public Lotto(List<Integer> numbers){  
&nbsp;&nbsp;this.numbers = numbers;  
&nbsp;}  
}
- Lotto에 기본 생성자를 추가할 수 없다.
- numbers 변수의 접근 제어자인 private을 바꿀 수 없다.
- Lotto에 필드(인스턴스 변수)를 추가할 수 없다.

## 프로그래밍 요구사항 - 객체 2

> public class WinningLotto {  
&nbsp;private final Lotto lotto;  
&nbsp;private final int bonusNo;  
&nbsp;  
&nbsp;public WinningLotto(Lotto lotto, int bonusNo){  
&nbsp;&nbsp;this.lotto = lotto;  
&nbsp;&nbsp;this.bonusNo = bonusNo;  
&nbsp;}  
&nbsp;public Rank match(Lotto userLotto){  
&nbsp;&nbsp;return null;  
&nbsp;}  
}

- match() 메소드의 반환 값인 Rank는 저장소에서 제공한다.
- WinningLotto 기본 생성자를 추가할 수 없다.
- lotto, bonusNo변수의 접근 제어자인 private을 변경할 수 없다.
- WinningLotto에 필드(인스턴스 변수)를 추가할 수 없다.

## 프로그래밍 요구사항

- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- else예약어를 쓰지 않는다.
- public/protected/private/package접근 제어자를 용도에 적합하게 사용해 구현한다.
- 함수(또는 메소드)의 길이가 10라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
- indent(인덴트, 들여쓰기) depth를 2가 넘지 않도록 구현한다. 1까지만 허용한다.
- 함수(또는 메소드)의 인자 수를 3까지만 허용한다. 4개 이상은 허용하지 않는다.

## 구현해야될 객체

랜덤숫자를 뽑는 기능 구현 => array에 숫자를 넣은 다음 shuffle해서
뽑는다.

- Lotto
  - getNumbers() // Lotto의 numbers을 반환하는 기능
  - toString() // Lotto 인스턴스를 String으로 변환하는 기능
  
- WinningLotto
  - match() // 지난주 당첨번호와 얼마나 일치하는지 확인하는 기능 

- Rank
  
- PickingNumbers
  - makeNumbers() // 로또의 6개의 숫자를 뽑는 기능
  - shuffle() // 랜덤으로 숫자 배열을 섞는 기능
  - fillNumbers() // 숫자(1~45)를 채우는 기능

- Display
  - showBoughtLotto() // 구입한 로또를 보여주는 기능 
  - inputMoney() // 구입 금액을 입력하는 기능
  - inputLastWeekWinningNumbers() // 지난주 당첨 숫자를 입력하는 기능
  - inputBonusNumber() // 보너스 번호를 입력하는 기능
  - showProfitRate() // 수익률을 보여주는 기능
  - changeMoneyIntoLottos() // 구입 금액으로 몇 개를 살 수 있는 지 보여주는 기능

- Game
  - Lotto makeLotto() // 로또는 만드는 기능
  - WinningLotto makeWinningLotto() // 당첨 번호를 만드는 기능
  - void initShow() // 로또 당첨 쇼를 시작하는 기능
  - convertIntoNum(Rank) // Rank의 당첨금액을 숫자로 바꿔주는 기능
  - long long calculateWinningMoney() // 당첨금 계산하는 기능
  - double calculateProfitRate // 수익률 계산하는 기능