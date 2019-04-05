# 로또 게임
* StartLottoGame : 게임 실행을 담당한다. (메인 클래스)
    * 변수
        1. (상수) ONE_LOTTO_PRICE - 1장의 로또 가격은 천원(구매 가능한 로또 개수를 알기 위해)
        2. (객체) userLotto[]     - 구매 가능한 로또의 개수만큼 자동으로 생성
    * 메서드
        1. gameStart - 게임을 실행한다.                    (return void)
        2. inputCost - 구매하는 금액을 입력받는다.         (return int)
        3. buyLotto  - 구매 가능한 숫자 만큼 로또 구매하기 (return void)

* Lotto : 로또 한 장을 의미한다.
    * 변수
        1. (상수) numbers - 로또 한 장의 숫자들을 저장한다.
    * 생성자
        1. Lotto(List<Integer> numbers) - 생성과 동시에 로또 숫자 출력하기
    * 메서드
        1. printComma - 콤마 또는 비어있는 값을 만든다. (return String)

* AutoLotto : 자동으로 번호를 생성한다.
    * 변수
        1. (변수) numbers - 랜덤 숫자를 임시로 저장한다.
    * 메서드
        1. makeAutoNumber   - 랜덤으로 6개의 숫자를 생성한다.       (return list)
        2. oneRandomNum     - 1부터 45까지의 랜덤 숫자 만든다.      (return int)
        3. changeOverlapNum - 중복된 숫자를 새로 바꾼다.            (return void)
        4. isFindOverlapNum - 해당 숫자가 중복되는지 확인한다.      (return boolean)
        5. isSameNum        - 두 수가 같은지 확인한다.              (return boolean)
        6. isResetNum       - 번호를 다시 생성해야 하는지 확인한다. (return boolean)

* WinningLotto : 당첨 번호를 저장한다.

* Rank : 등수를 관리한다.