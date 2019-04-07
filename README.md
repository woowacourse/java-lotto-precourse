로또
=================

실행 과정
----------------
1. 구매 금액을 입력한다.
2. 자동 혹은 수동 금액을 선택한다.
3. 구매한 번호가 출력된다.
4. 당첨 번호와 보너스 번호를 입력한다.
5. 당첨 통계 및 수익률이 계산된다.
6. 당첨 통계가 출력된다.

기능 요구
---------
* 로또 게임 기능을 구현해야 한다. 규칙을 모르면 검색해 로또 규칙을 찾아본다.
* 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급 해야한다.
* 로또 1장의 가격은 1000원이다.
* 로또 당첨금액은 고정 되어있는것으로 가정한다.
* 수익률을 계산해 출력해야 한다

기능 프리뷰 (Refactoring 이후 수정 버전)
-------------
* Config - 환경 (클래스에서 공통적으로 사용하는 변수를 담은 클래스)
    * Variable
        * public final int INITIAL_VALUE - 가격 메소드의 초기값(0)
        * public final int LOTTO_PRICE  - 로또 한장 가격(1000)
        * public final int LOTTO_NUMBER_SIZE - 로또 한게임의 크기(6)
        * public final int LOTTO_MAX_VALUE -로또에서 선택할 수 있는 가장 큰 수(45)
        * public final int LOTTO_MIN_VALUE - 로또에서 선택할 수 있는 가장 작은 수(0)
    * Constructor
        *
    * Method
        * public Scanner resetScanner() - 유효성 검사시에 Scanner객체를 초기화하는 함수

* Program - 프로그램 (로또 프로그램에 사용되는 메소드를 담은 클래스) 
    * Variable
        *
    * Constructor
        *
    * Method
        * public Lotto[] typeSelect(Machine machine, Shop shop, int buyingCash) - 자동, 혹은 수동 선택
        * public int inputPrice() - 금액 입력 받기
        * public float calculateEarningrate(float amount, Rank[] rank) - 수익률 계산하기
        * public Rank[] createRankBundle(Lotto[] lottobundle, WinningLotto winningLotto) - 결과를 담은 배열 생성
        * public void printLottoResult(Rank[] rankbundle, float Earningrate) - 로또 결과 출력하기
        * public void printLotto(Lotto[] lottobundle) - 구매한 로또 갯수 출력
        * private int checkPriceValidation(int price) - 입력받은 금액의 유효성 검사
        * private int checkPrice(int price) - 금액이 0원 이상 1000원 단위인지 검사
        * private int createCountOfMatchAmount(Rank[] rank, int winningMoney) - 당첨된 결과 세기
        * private int pulsCountOfMatchAmount(int userWinningMoney, int winningMoney) - 당첨된 결과 하나 추가하기
    
* Lotto - 로또 (로또 하나를 의미하는 객체)
    * Variable
        * private final List<Integer> number - 로또 번호를 담을 리스트
    * Constructor
        * public Lotto(List<Integer> number) - 번호를 담은 리스트를 받아 변수에 할당한다.
    * Method
        * public List<Integer> getLottoNumber() - 로또 리스트 얻기
        * public String printLottoNumber() - 로또 출력하기
        
* WinningLotto - 당첨 번호 (당첨 번호를 의미하는 객체)
    * Variable
        * private final Lotto lotto - 정답 번호를 가지고 있는 로또 클래스
        * private final int bonusNo - 보너스 번호를 가지고 있는 정수형 변수   
    * Constructor
        * WinningLotto(Lotto lotto, int bonusNo) - 로또 하나와 보너스번호를 받아 변수에 각각 할당한다.         
    * Method
        * public Rank match(Lotto userLotto) - 유저의 로또를 받아 당첨번호와 맞춰보고 그 결과를 통해 Rank객체를 생성하는 함수
        * public Lotto getWinningLotto() - 당첨 번호 리턴
        * public int getBonusNumber() - 보너스 번호 리턴
        
* Rank - 등수 (로또 등수 상수를 가지는 객체) 
    * Variable
        * private static final int WINNING_MIN_COUNT - 상금을 받을 수 있는 최소한의 수
        * private int countOfMatch - 맞춘 로또의 수
        * private int winningMoney - 상금
    * Constructor        
        * private Rank(int countOfMatch, int WinningMoney) - 맞춘 수와 상금을 받아 변수에 각각 할당한다.
    * method
        * public getCountOfMatch() - 맞춘 로또의 수를 반환
        * public getWinningMoney() - 상금 값 반환
        * public static Rank valueOf(int countOfMatch, boolean matchBonus) - 맞춘 로또의 수에 따른 Rank enum 반환, 반환할 수 없다면 예외값에 대한 결과 출력         
             
* LottoPaper - 로또 종이(로또 객체 생성을 위해 필요한 List를 가지는 객체)
    * Variable
        * private String[] lottoString - 로또 번호를 담은 문자열 배열
        * private int[] lottoNumber -로또 번호를 담은 정수형 배열
    * Constructor
        * public LottoPaper() - 유효성 검사 후 로또 배열을 할당
    * Method
        * public int[] getLottoNumber() - 로또 번호를 담은 배열 얻기
        * private void settingConstructor() - 생성자 셋팅
        * private String[] createStringArray() - 문자열을 받아 split으로 나눈 문자열 배열로 생성
        * private int[] changeIntegerArrayfromStringArray(String[] lottoString) - 문자열 배열을 int 배열로 리턴
        * private boolean checkLottoSize(int[] numberArray) - 로또 게임의 크기에 대한 유효성 검사
        * private boolean checkDuplicate(int[] numberArray) - 중복된 번호에 대한 유효성 검사
        * private boolean checkMaxMinLottoNumber(int[] numberArray) - 로또 번호 하나의 크기에 대한 검사(1이상 45이하)
        
* BonusNumber - 보너스 번호(당첨 보너스 번호 객체)
    * Variable
        * private int bonusNumber - 보너스 번호
    * Constructor
        * public BonusNumber(List<Integer> winningNumber) - 유효성 검사후 보너스 번호 할당
    * Method
        * private void checkBonusNumberValidation(List<Integer> winningNumber) - 유효성 검사 및 보너스 번호 할당
        * private boolean checkBonusNumberRange() - 보너스 번호 범위 체크(1이상 45이하)
        * private boolean checkDuplicateBonusNumber(List<Integer> winningNumber) - 당첨 번호와의 중복 체크
        
* User - 로또를 구매하는 자
    * Variable
        * private final int buyingCash - 구매한 금액
    * Constructor
        * User(int price) - 구매 금액을 할당한다.
    * Method
        public int getBuyingCash() - 금액 리턴
        
* Machine - 기계 (자동 로또를 생성하는 곳)
    * Variable
        * private List<Integer> lottoMachineNumber = new ArrayList<>() - 1~45를 담은 리스트
        * private Lotto[] lottoBundle - 로또 객체를 담을 배열
        * private int count - 자동 로또를 생성할 횟수
    * Constructor
        * public Machine(int price) - 구입 금액에 따른 자동 로또 할당
    * Method
        * public Lotto[] sellLotto(int price) - 자동 로또 생성
        * private List<Integer> getRandomLottoNumber() - 랜덤 로또 번호를 가진 리스트 생성
        * private int createRandomNumber(int size) - 랜덤한 인덱스 생성
        * private Lotto createLotto(List<Integer> lottoNumber) - 로또 객체 생성
        * private void fillLottoNumber() - lottoMachineNumber를 1~45까지 채우기
        
* Shop - 상점 (수동 로또를 생성하고 로또를 판매하는 곳)
    * Variable
        * private Lotto[] lottoBundle - 로또 객체를 담을 배열
        * private int count - 수동 로또를 생성할 횟수
    * Constructor
        * public Shop(int price) - 구입 금액에 따른 수동 로또 할당
    * Method
        * public Lotto[] sellLotto(int price) - 수동 로또 생성  
        * public WinningLotto createWinningLotto() - 당첨 번호 생성
        * private Lotto createLotto(List<Integer> lottoNumber) - 로또 객체 생성
        * private ArrayList<Integer> getLottoNumber() - 로또 번호를 담은 리스트 생성      
        
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
- [x] 수익률 계산 하기
- [x] 당첨 통계 출력 하기 
- [x] 자동 로또 생성하기

리팩토링 계획 Commit 체크
-------------------------
- [x] Shop과 Machine의 공통 인자를 가지는 부모 클래스 생성
- [x] LottoPaper클래스 생성으로 로또 번호 객체 생성
- [x] BonusNumber 생성
- [x] Program 생성
- [x] Shop의 예외처리 중 재귀함수 단순화
- [ ] 변수명 수정