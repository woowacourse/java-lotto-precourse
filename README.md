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

## 잘못된 입/출력 예시

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
|getLottoCountFromUser|유저로부터 로또갯수를 받는 로직|
|createLottos| 특정갯수의 로또객체를 생성해 반환|
|printLottos|특정갯수의 로또객체정보를 출력|
|calculateLottoMatch|로또 당첨결과를 계산|
|createSortAppliedRankCounter|countOfMatch수의 오름차순으로 항상 정렬되도록 sort함수적용된 Map 생성|
|addAllRankTypes|로또 당첨결과에 미리 모든 종류의 결과(Rank)를 입력해 0으로 초기화|
|calculateProfitRate|수익률 계산|
|printLottoResult|로또 당첨 결과를 출력(당첨로또 현황, 수익률)|
|createWinningLotto|당첨로또 생성|
|compareRank|Rank를 countOfMatch의 오름차순으로 정렬하기위한 비교 함수|

|Lotto|로또 1장 객체|
|---|---|
|createPossibleNumbers|로또넘버로 가능한 숫자들을 반환|
|createRandomLotto|랜덤하게 로또한개를 생성해 반환|
|printLottoNumbers|로또넘버를 출력|

|WinningLotto|당첨 로또 객체|
|---|---|

|Rank|당첨결과 객체|
|---|---|
|printRank|당첨결과 출력|

|Validator|값이 에러를 갖는지 확인하는 로직을 담당|
|---|---|
|checkIsInteger|해당값이 정수로 변환가능한지 확인|
|checkInputLottoMoneyLengthIsTooLong|로또구입금액이 너무 긴지 확인(오버플로우 방지 목적)|
|checkLottoNumbersInputLengthIsValid|6개 로또번호입력이 갯수가 맞는지 확인|
|checkLottoNumbersInputHasNoInvalidValue|6개 로또번호입력이 모두 유효한지 확인|
|checkDuplicationIfHasPrintWarning|6개 로또번호입력이 중복이 있는지 확인. 있다면 Warning을 출력|
|checkLottoNumbersHasDuplication|6개 로또번호 입력이 중복이 있는지 확인 후 반환|
|checkIsLottoNumberInRange|로또번호가 범위안에 있는 값인지 확인|
|checkIsLottoNumberValid|로또번호가 유효한지 확인|
|checkBonusLottoNumberValid|보너스로또넘버가 유효한지 확인|
|checkIsAlreadyInLottoNumbers|입력이 이미 로또번호에 포함된 번호인지 확인해 반환|

|GameSetting|게임의 세팅값을 담당|
|---|---|

|DataReceiver|유저로부터 데이터 입력받는 로직 담당|
|---|---|
|getLottoMoneyFromUser|유저로부터 로또구입금액을 입력받음|
|getWinningLottoNumbersFromUser|유저로부터 유효한 로또넘버 6개를 받음|
|transformWinningNumberInputToIntegerList|유저로부터 받은 로또넘버6개 입력을 리스트로 변환해서 반환|