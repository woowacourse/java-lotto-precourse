# 로또

* #### 프로그램 소개

  원하는 만큼의 로또를 구입하고 구입한 로또의 수익률을 계산하는 프로그램

  

* #### 프로그램 진행 방식

  * 원하는 만큼 돈을 입력하여 로또를 구입(한장에 1000원)
  * 구매한 장 수 만큼 자동(컴퓨터가 알아서 번호 지정)으로 로또 번호를 부여하여 사용자에게 알려줌
  * 당첨 번호와 보너스 번호를 입력
  * 구입한 로또 번호들과 당첨 번호를 비교하여 수익률을 계산 후, 출력

---

* #### 구현할 기능

  * 구입 금액 받기

    >예외 상황
    >
    >1. 금액이 1000원 단위로 입력 받지 않은 경우
    >2. 숫자 이외의 값을 입력 받는 경우

  * 금액에 따라 몇 장을 뽑아야하는지 계산

  * 장 수 만큼 로또 번호를 랜덤으로 생성

  * 생성된 로또 출력

  * 당첨 번호 입력(6자리, 형식 : num~1~,num~2~,num~3~,num~4~,num~5~,num~6~)

    > 예외 상황
    >
    > 1. 6자리를 입력 하지 않았을 경우
    > 2. ',' 을 사용하지 않았을 경우
    > 3. 입력된 수가 45(최대 번호)가 넘어간 경우
    > 4. 숫자가 이외의 값을 입력한 경우
    > 5. 중복인 숫자가 있을 경우

  * 당첨 번호를 ',' 기준으로 나누기

  * 보너스 번호 입력

    > 예외 상황
    >
    > 1. 입력된 수가 45(최대 번호)가 넘어간 경우
    > 2. 숫자가 이외의 값을 입력한 경우
    > 3. 중복인 숫자가 있을 경우

  * 당첨 번호와 생성된 로또 번호 비교

  * 비교된 정보로 수익률 계산 후 출력

---

* #### 구현 클래스 및 메소드

  * Lotto

    > 로또를 관리하는 객체
    >
    > * getLottoNumbers : 로또 번호 가져오기

  * WinningLotto

    > 당첨 번호를 담당하는 객체
    >
    > * match : 유저 로또와 당첨 번호를 비교하여 등수 출력

  * Inputter

    > 사용자의 입력을 받는 객체
    >
    > * inputPurchaseAmount : 사용자에게 금액을 입력 받기
    > * inputWinningNumber : 당첨 번호 입력 받기
    > * inputBonusNumber : 보너스 번호 입력 받기

  * Validator

    > 입력 받은 내용에 유효성을 검사하는 객체
    >
    > * isPossibleAmountUnit : 입력 받은 내용이 정확한 단위인지 검사
    > * isNumeric : 입력 받은 내용이 숫자인지 검사
    > * isProperNumberDigit : 입력 받은 내용이 당첨 번호의 형식과 맞는지 검사
    > * checkingMatching : 정규표현식을 사용하여 유효성 검사후 틀리다면 에러 메세지 출력
    > * isDuplicateAndNumOverValue : 당첨 번호끼리의 중복 확인 및 최대값 넘김 검사
    > * isBonusDuplicateAndNumOverValue : 보너스 번호와 당첨 번호들과의 중복 확인 및 최대값 넘김 검사
    > * isExistNumInList : 유저가 뽑은 로또 번호에 당첨 번호가 하나 있는지 검사

  * LottoCreator

    > 로또들을 생성하는 객체
    >
    > * createWinningLotto : 당첨 번호 로또를 생성
    > * purchaseLottoForAmount : 구매한 개수만큼 로또 랜덤 생성
    > * createLotto : 로또 생성
    > * createRandomNumbers : 랜덤 번호 생성
    > * createRandomNumAndCheckingExistNumInList : 생성된 랜덤 번호가 중복인지 확인하고 재생성
    > * splitWinningNumAndCheckingReInput : 나누어진 당첨 번호가 중복인지 확인 후에 재입력
    > * winningNumSplit : 당첨 번호를 ',' 기준으로 나누기
    > * reInputWinningNumbers : 당첨 번호 다시 입력 받기
    > * changeStrListToIntList : String형 리스트를 Integer형 리스트로 형변환

  * StatisticalAnalyzer

    >생성된 로또들의 당첨 통계와 수익성을 계산하는 객체
    >
    >* calcWinningStatistical : 당첨 통계 계산
    >* checkingRank : 유저 로또와 당첨 번호를 비교하여 나온 등수로 저장소 값 갱신
    >* printWinningStatistical : 당첨 통계 메세지 출력
    >* winningStatisticalMessageIntro : 당첨 통계 시작 메세지
    >* winningStatisticalMessage : 당첨 통계 메세지 생성
    >* printEarningRate : 수익률 계산
    >* initWinningRankMap : 당첨 정보를 저장할 맵 객체 생성
    >* calcTotalEarning : 총 수입 계산

  * LottoGame

    > 로또 게임에 하기 위해 필요한 것들(사용자 입력)을 생성하는 객체
    >
    > * run : 로또 게임 진행
    > * inputLottoAmount : 로또 금액 입력
    > * createLottoList : 로또 생성
    > * inputWinningLotto : 당첨 번호 입력
    > * splitWinningNumAndCheckReInput : 당첨 번호 확인 및 재입력
    > * inputBonusNum : 보너스 번호 입력
    > * createWinningLotto : 당첨 번호 생성

  * GameRunner

    > 로또 게임을 실행하는 객체

    