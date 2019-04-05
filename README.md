# 로또 게임
* StartLottoGame : 게임 실행을 담당한다. (메인 클래스)
    * 변수
        1. (상수) ONE_LOTTO_PRICE - 1장의 로또 가격은 천원(구매 가능한 로또 개수를 알기 위해)
        2. (객체) userLotto[] - 구매 가능한 로또의 개수만큼 자동으로 생성
    * 메서드
        1. inputCost - 구매하는 금액을 입력받는다. (return int)
        2. buyLotto - 구매 가능한 숫자 만큼 로또 구매하기
* Lotto : 로또 한 장을 의미한다.
    * 생성자
        1. Lotto(List<Integer> numbers) - 생성과 동시에 로또 숫자 출력하기
    * 메서드
        1. printComma - 콤마 또는 비어있는 값을 만든다. (return String)

* AutoLotto : 자동으로 번호를 생성한다.
    * 메서드
        1. makeAutoNumber - 랜덤으로 6개의 숫자를 생성한다.
        2. oneRandomNum - 1부터 45까지의 랜덤 숫자 만든다. (return int)

* WinningLotto : 당첨 번호를 저장한다.

* Rank : 등수를 관리한다.