
# 3주차 미션 - 로또
---
## 기능 요구사항
###### baseball game 으로 다음과 같은 규칙을 따르는 게임을 실행한다.
1. 로또 게임 기능을 구현해야 한다. 규칙을 모르면 검색해 로또 규칙을 찾아본다.
1. 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
1. 로또 1장의 가격은 1000원이다.
1. 로또 담청 금액은 고정되어 있는것으로 가정한다.
1. 수익률을 계산해 출력해야 한다.
---
## 구성
- Main.java
- Lotto.java
    * public List<Integer> getNumbers()
    * public void printNo()
    * private void printComma(int i)
- WinningLotto.java
    * public Rank match(Lotto userLotto)
    * private boolean bonusMatch(Lotto userLotto)
    * private int getMatch(Lotto userLotto)
- Rank.java   
- PlayLotto.java
    * public void start()
    * private void printStatistics()
    * private void setWinCheak(int i)
    * private void getStatistics()
    * private void getWinningNo()
    * private void getMasterLottoNo(String winningNo, int bonusNo)
    * private void getUserLottos()
    * private void addLotto()
    * private void getDifferentNumber()
    * private void listSort()

---

## Class & Method 설명

| Main.java | 프로그램을 실행시키기 위한 Class  |
| ----------- | ------------ |
| public static void main(String[] args) |   PlayLotto class 를 생성해 Lotto를 실행시킨다.|

| Lotto.java | Lotto 객체 클래스로 Lotto숫자를 저장하고 출력할 수 있다.|
| ----------- | ------------ |
| public List<Integer> getNumbers()  | 로또 객체의 Numbers 리스트를 리턴한다.  |
| public void printNo()  | 입력받은 로또의 숫자를 출력한다.  |
| private void printComma(int i) | ','출력을 위한 매서드 |


| WinningLotto.java | WinningLotto 객체 클래스로 Lotto숫자를 저장하고 출력할 수 있다.|
| ----------- | ------------ |
| public Rank match(Lotto userLotto) | 유저의 Lotto번호와 당첨 번호를 비교하여 등수를 반환 한다.|
| private boolean bonusMatch(Lotto userLotto)| 유저의 로또와 당첨 번호를 비교하셔 보너스 숫자 유무 채크한다. |
| private int getMatch(Lotto userLotto) |유저의 Lotto번호와 당첨 번호를 비교하여 같은 숫개 개수를 반환한다. |


| PlayLotto.java | PlayLotto 클래스로 Lotto를 실행한다. |
| ----------- | ------------ |
| public void start() | Lotto를 실행하는 매서드  |
| private void printStatistics() | 당첨 통계를 출력하는 매서드 |
| private void setWinCheak(int i)| 당첨 등수들과 당첨 총액수를 저장하는 매서드   |
| private void getStatistics()| 당첨번호와 구입한 Lotto를 비교하는 매서드. |
| private void getWinningNo()| 지난주 당첨번호를 입력받는다. |
| private void getMasterLottoNo(String winningNo, int bonusNo)| 입력받은 당첨번호를 저장한다.|
| private void getUserLottos()| 입력받은 금액 만큼의 Lotto를 구입한다. |
| private void addLotto()| Lotto 한장을 얻는 함수.  |
| private void getDifferentNumber()| 6개의 서로 다른 숫자를 얻어 List에 저장한다.|
| private void listSort() | 6개의 숫자가 저장된 List를 정렬한다.|


---
### 프로그래머
 권경동 (fancyartisan@gmail.com / rudehd10@naver.com)
---
### 체인지로그


