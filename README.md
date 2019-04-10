## 우아한테크코스 : 로또
- 우아한 테크코스 3번째 미션 "로또" 를 구현한 프로젝트 입니다.
- "로또" 게임이란 사용자가 로또를 여러장 구매한 후, 로또의 당첨번호를 입력해 수익률을 확인할수있는 간단한 게임입니다.

## 기능 요구사항
1. 로또 게임 기능을 구현해야 한다.
2. 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
3. 로또 1장의 가격은 1000원 이다
4. 로또 당첨 금액은 고정되어 있는 것으로 가정한다.
5. 수익률을 계산해 출력해야 한다.

## 바람직한 입/출력 예시
```
구입금액을 입력해 주세요.
100000
```
```
100개를 구매했습니다.
[11,32,2,39,5,28]
[35,25,31,37,39,10]
.  
.  
.  
[24,31,23,41,6,10]
[11,22,34,41,4,40]
```
```
지난 주 당첨 번호를 입력해주세요.
1,2,3,4,5,6
```
```
보너스 볼을 입력해 주세요.
7
```
```
3개 일치.(5000 원) - 5개
4개 일치.(50000 원) - 0개
5개 일치.(1500000 원) - 0개
5개 일치. 보너스볼 일치.(30000000 원) - 0개
6개 일치.(2000000000 원) - 0개
총 수익률은 0.3입니다
```
## 잘못된 입/출력 예시
아래는 잘못된 입력의 예시를 나타낸 것 입니다.  
  
**1. 구입금액입력 예외처리**  
    - 정수가 아닌 입력: "", asdf  
    - 최소금액보다 작은 입력: 500, -30  
  
**2. 당첨번호입력 예외처리**  
    - (,)로 파싱했을때 6개가 아닌경우: 1,2,3,4,5   1,2,3,4,5,6,7  
    - 1~45를 벗어나는 숫자가 있는경우: 1,2,3,49,5,6  
    - 중복숫자가 있는경우: 1,1,2,3,4,5  
    - 정수가아닌 입력이 있는경우: a,2,3,4,5,6  

**3. 보너스번호 예외처리**  
    - 정수가 아닌 입력: "", asdf  
    - 1~45를 벗어나는 숫자: 49,-500
    - 당첨번호와 중복된 숫자인 경우

## 구현로직 분류
- [x] 메인로직 1: 사용자로부터 로또 구입 금액 입력받기
    - [x] 서브로직 1-1: 입력이 정수로 변환가능한지 확인
    - [x] 서브로직 1-2: 입력이 특정 길이를 초과하는지 확인
    - [x] 서브로직 1-3: 입력이 최소 로또구입금액보다 작은지 확인
- [x] 메인로직 2: 특정갯수의 로또를 생성하고 출력하기
    - [x] 서브로직 2-1: 임의의 로또를 생성
    - [x] 서브로직 2-2: 로또정보를 출력
    - [x] 서브로직 2-3: 특정갯수의 로또 생성하기
    - [x] 서브로직 2-4: 특정갯수의 로또 출력하기
- [x] 메인로직 3: 사용자로부터 당첨로또번호 6개 입력받기
    - [x] 서브로직 3-1: 당첨로또번호입력값이 6개 인지 확인
    - [x] 서브로직 3-2: 당첨로또번호입력값 6개가 모두 모두 1~45 인지 확인
    - [x] 서브로직 3-3: 당첨로또번호입력값 6개가 모두 중복된것이 없는지 확인
- [x] 메인로직 4: 사용자로부터 보너스번호 입력받기
    - [x] 서브로직 4-1: 보너스번호가 유효한지 확인
- [x] 메인로직 5: 당첨로또, 수익률 계산하기
    - [x] 서브로직 5-1: 로또 당첨결과 계산 로직 만들기
    - [x] 서브로직 5-2: 수익률 계산 로직 만들기
- [x] 메인로직 6: 당첨로또, 수익률 결과 출력하기
- [x] 메인로직 7: 전체 게임 진행 로직 구현

## 클래스별 세부 기능

|LottoGame|로또게임 진행을 담당|
|---|---|
|getLottoCountFromUser|유저로부터 로또갯수 입력받기|
|createLottos| 특정갯수의 로또객체를 생성해 반환|
|printLottos|특정갯수의 로또객체정보를 출력|
|createWinningLotto|당첨로또 생성|
|transformWinningNumberInputToIntegerList|유저로부터 받은 로또넘버6개 입력을 리스트로 변환해서 반환|
|createInitializedRankCounter|로또 당첨결과 계산하기위한 자료구조(Map)생성 후 반환|
|calculateLottoMatch|로또 당첨결과를 계산|
|calculateProfitRate|수익률 계산|
|printLottoResult|로또 당첨 결과를 출력(당첨로또 현황, 수익률)|
|playGame|게임 실행 함수|

|Lotto|로또 1장 객체|
|---|---|
|getNumbers|로또넘버 반환|
|getCountOfMatch|로또넘버 일치갯수 반환|
|checkNumberContain|입력된 로또넘버 포함 여부 반환|
|createPossibleNumbers|로또넘버로 가능한 숫자들을 반환|
|createRandomLotto|랜덤하게 로또한개를 생성해 반환|
|printLottoNumbers|로또넘버를 출력|

|WinningLotto|당첨 로또 객체|
|---|---|
|match|특정 로또객체의 당첨결과를 반환|

|Rank|당첨결과 객체|
|---|---|
|printRank|당첨결과 출력|

|Validator|값이 에러를 갖는지 확인하는 로직을 담당|
|---|---|
|checkIsInteger|정수로 변환가능한지 확인|
|checkIsLottoNumberInRange|범위안에 있는 값인지 확인|
|checkNumbersLengthIsValid|당첨로또입력의 갯수 확인|
|checkEachStringIsInteger|당첨로또입력의 모든숫자가 정수로 변환가능한지 확인|
|checkEachStringInRange|당첨로또입력의 모든숫자가 1~45인지 확인|
|checkEachStringDontOverlap|당첨로또입력이 중복 없는지 확인|
|checkIsAlreadyInLottoNumbers|입력이 이미 로또번호에 포함된 번호인지 확인해 반환|
|checkInputLottoMoneyIsUnderMinvalue|인풋 금액이 로또1장금액보다 낮은지 체크|
|checkWinningLottoNumbers|당첨로또번호 입력에 오류가있는지 종합 체크|

|GameSetting|게임의 세팅값을 담당|
|---|---|

|UserView|게임의 출력을 담당|
|---|---|

|DataReceiver|유저로부터 데이터 입력받는 로직 담당|
|---|---|
|getLottoMoneyFromUser|유저로부터 로또구입금액을 입력받음|
|getWinningLottoNumbersFromUser|유저로부터 유효한 로또넘버 6개를 받음|
|getBonusNumberFromUser|유저로부터 보너스넘버를 입력받음|