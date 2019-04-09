# 우아한 테크코스 프리코스 미션 진행 저장소
우아한 테크코스 과정에 참여하기 위해 Delf(이상훈)가 3주간 주어진 미션을 열심히 수행하는 저장소입니다.
- 1주차 미션 - [과정 및 느낀점](https://github.com/Delf-Lee/study-archive/blob/master/woowacourse/tech-corce-mission-1.md) / [repository](https://github.com/Delf-Lee/java-baseball/tree/delf)
- 2주차 미션 - [과정 및 느낀점](https://github.com/Delf-Lee/study-archive/blob/master/woowacourse/tech-corce-mission-2.md) / [repository](https://github.com/Delf-Lee/java-racingcar/tree
- **3주차 미션** - [과정](https://github.com/Delf-Lee/study-archive/blob/master/woowacourse/tech-corce-mission-3.md)

# 2주차 미션 - 로또
# 요구사항
## 기능 요구사항
- 로또 게임 기능을 구현해야 한다. 규칙을 모르면 검색해 로또 규칙을 찾아본다. 
  - https://ko.wikipedia.org/wiki/로또_6/45#당첨_여부_판정_방법
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.
- 로또 당첨 금액은 고정되어 있는 것으로 가정한다.
- 수익률을 계산해 출력해야 한다.

## 프로그래밍 요구사항
- 객체 구현 - `Lotto`, `WinningLotto`
    - 기본 생성자 금지
    - 접근 지정자 변경 금지
    - 필드 추가 금지
- 자바 컨벤션 지키지
- `else` 사용 금지
- 메서드의 길이 10라인 초과 금지
- indent depth 2 초과 금지
- 메서드 인지 4개 이상 금지

## 기능 목록
- 난수 생성기 구현
  - 중복 없는 6개의 숫자 생성
- 시뮬레이터 구현
  - 로또 배열, 당청 로또, 입출력 객체로 구성
- 로또 로직 구현
  - 숫자 비교 후 적절한 값 반환
- 사용자 입력 구현
  - 숫자 범위 예외처리
  - 남은 돈 예외처리