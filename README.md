자동차 경주 게임
=================

실행 과정
----------------

기능 요구
---------
* 로또 게임 기능을 구현해야 한다. 규칙을 모르면 검색해 로또 규칙을 찾아본다.
* 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급 해야한다.
* 로또 1장의 가격은 1000원이다.
* 로또 당첨금액은 고정 되어있는것으로 가정한다.
* 수익률을 계산해 출력해야 한다
 

용어 설명
--------------
* Lotto - 로또 (로또 한장을 의미하는 객체)
* Rank - 등수 (로또 등수를 나타내는 객체) 
* WinningLotto - 당첨 번호 (당첨 번호를 의미하는 객체) 
* Shop - 상점 (로또를 판매하는 곳)
* User - 고객 (로또를 구매하는 자)

기능 프리뷰
-------------
* Lotto - 리스트로 번호를 받아 생성되는 로또 한장
    * Constructor
        * public Lotto(List<Integer> number) - 번호를 담은 리스트를 받아 변수에 할당한다.
    * Variable
        * private final List<Integer> number - 로또 번호를 담을 리스트
        * public List<Integer> getLottoNumber() - 로또 리스트 얻기
        * public String printLottoNumber() - 로또 출력하기
        
* Rank - 당첨된 수와, 당첨금액을 통해 생성되는 결과
    * Constructor        
        * private Rank(int countOfMatch, int WinningMoney) - 맞춘 수와 상금을 받아 변수에 각각 할당한다.
    * Variable
        * private static final int WINNING_MIN_COUNT - 상금을 받을 수 있는 최소한의 수
        * private int countOfMatch - 맞춘 로또의 수
        * private int winningMoney - 상금
    * method
        * public getCountOfMatch() - 맞춘 로또의 수를 반환
        * public getWinningMoney() - 상금 값 반환
        * public static Rank valueOf(int countOfMatch, boolean matchBonus) - 맞춘 로또의 수에 따른 Rank enum 반환, 반환할 수 없다면 예외값에 대한 결과 출력         

* WinningLotto - 당첨번호를 담은 로또와 보너스 번호를 받아 생성되는 당첨 번호
    * Constructor
        * WinningLotto(Lotto lotto, int bonusNo) - 로또 하나와 보너스번호를 받아 변수에 각각 할당한다.
    * Variable
        * private final Lotto lotto - 정답 번호를 가지고 있는 로또 클래스
        * private final int bonusNo - 보너스 번호를 가지고 있는 정수형 변수            
    * Method
        * public Rank match(Lotto userLotto) - 유저의 로또를 받아 당첨번호와 맞춰보고 그 결과를 통해 Rank객체를 생성하는 함수
        * public Lotto getWinningLotto() - 당첨 번호 리턴
        * public int getBonusNumber() - 보너스 번호 리턴
        
        
* User - 로또를 구매하는 자
    * Constructor
        * User(int price) - 구매 금액을 할당한다.
    * Variable
        * private final int buyingCash - 구매한 금액
    * Method
        public int payCash() - 로또 금액을 지불
        public List<Integer> selectLottoNumber() - 수동으로 로또 값을 선택한다.
        private void checkLottoNumber() - 로또 값이 45를 초과하거나 1미만일 경우를 대처한다.

* Shop - 로또를 판매
    * Variable
        * private final int INITIAL_VALUE - 데이터 체크를 위한 초기 값
        * private final int LOTTO_PRICE - 로또 한장의 가격
        * private final int LOTTO_NUMBER_SIZE - 체크할 로또번호의 개수
        * private final int LOTTO_MAX_VALUE - 로또에서 선택할 수 있는 최고 번호
        * private final int LOTTO_MIN_VALUE - 로또에서 선택할 수 있는 최저 번호
     * Method
        * public Lotto sellLotto(int cash) - 지불한 금액에 따른 로또 판매
        * public int inputPrice() - 금액을 입력 받음
        * public void printLotto(Lotto[] lottobundle) - 구매한 모든 로또를 형식에 맞춰 출력
        * createWinningLotto() - 당첨 번호 생성
        * private int createBonusNumber(List<Integer> winningNumber) - 보너스 번호를 생성
        * private int checkBonusNumberValidation(int bonusNumber, List<Integer> winningNumber) - 보너스 번호 유효성 검사
        * private int checkBonusNumberRange(int bonusNumber, List<Integer> winningNumber) - 보너스 번호 범위 검사
        * private int checkDuplicateBonusNumber(int bonusNumber, List<Integer> winningNumber) - 보너스 번호 중복 검사
        * private ArrayList<Integer> getLottoNumber() - 로또 하나의 번호들을 얻음
        * private String[] getStringLottoNumber() - 로또 번호를 문자열로 받음
        * private Lotto createLotto(ArrayList<Integer> lottoNumber) - 로또 객체 하나를 생성
        * private int[] changeIntegerArrayfromStringArray(String[] numberStringArray) - 문자열로 받은 배열을 int형 배열로 변환
        * private int[] checkDuplicate(int[] numberArray) - 로또의 중복값 제거
        * private int[] checkMaxMinLottoNumber(int[] numberArray) - 로또번호가 1이상 45이하인지 체크
        * private int[] checkLottoSize(int[] numberArray) - 로또번호가 6개인지 체크
        * private int checkInputData(int price) - 데이터를 체크함
        * private int checkPrice(int price) - 금액이 1000원 단위이며, 0이상인지 체크함
        * private Scanner resetScanner() - 값이 유효하지 않을 경우 Scanner객체 초기화
        
* Bank - 로또 결과에 대한 처리
    * Variable
        * private int earningRate - 수익률
    * Method
        * private int calculateEarningrate(int buyingCash, int WinningMoney) - User의 구매금액과 Rank의 당첨금액으로 수익률 계산 
        * public void printResult() - 당첨 결과 출력하기
        
* Index - main함수를 실행하는 클래스
                    
         
        
기능 단위 Commit 체크
-----------------------
- [x] 마크다운 작성
- [x] 각각의 클래스 파일 생성
- [x] 구입 금액 입력 받기
- [x] 구입 금액에 따른 로또 발권하기
- [x] 로또 번호 입력 받기
- [x] 로또 생성하기
- [x] 생성된 로또 출력하기
- [x] 지난 주 당첨 번호 입력 받기
- [x] 보너스 볼 입력 받기
- [x] 당첨 비교 하기
- [ ] 수익률 계산 하기
- [ ] 당첨 통계 출력 하기 