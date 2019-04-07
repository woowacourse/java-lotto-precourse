
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
    * public void printLotto() 
- WinningLotto.java
- Rank.java   

---

## Class & Method 설명

| Main.java | 프로그램을 실행시키기 위한 Class  |
| ----------- | ------------ |
| public static void main(String[] args) |   PlayLotto class 를 생성해 Lotto를 실행시킨다.|

| Lotto.java | Lotto 객체 클래스로 Lotto숫자를 저장하고 출력할 수 있다.|
| ----------- | ------------ |
| public List<Integer> getNumbers()  | 로또 객체의 Numbers 리스트를 리턴한다.  |
| public void printLotto()  | 입력받은 로또의 숫자를 출력한다.  |

| WinningLotto.java | WinningLotto 객체 클래스로 Lotto숫자를 저장하고 출력할 수 있다.|
| ----------- | ------------ |
| public Rank match(Lotto userLotto) | 유저의 Lotto번호와 당첨 번호를 비교하여 등수와 당첨금을 계산한다.|


| Rank.java | Rank 객체 클래스로 Lotto의 등수와 배당금이 정해져있다. |
| ----------- | ------------ |
|  |   |


---
### 프로그래머
 권경동 (fancyartisan@gmail.com / rudehd10@naver.com)
---
### 체인지로그


