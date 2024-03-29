# 미션 - 숫자 야구 설계

## domain

### Controller

- #### GameController: 게임 상태 관리
    - view 를 통해 게임 안내문 출력 및 사용자 정답 입력 수행
    - generator 를 통해 자동 정답 생성
    - 정답 비교 및 결과 출력
    - 게임 재시작 입력 결과에 따라 재시작 수행

### model

- #### SingleNumber: 정답에 포함되는 단일 숫자 원시 값을 저장
    - 입력 받은 값을 검증한다.
        - [x] 제한 범위 내에 포함되는 값이 아니라면 `IllegalArgumentException` 예외 처리

- #### Answer: 3개의 단일 숫자를 가지는 리스트를 저장
    - 입력 받은 값을 검증한다.
        - [x] 개수 제한 조건을 충족하지 않으면 `IllegalArgumentException` 예외 처리
        - [x] 중복된 숫자가 존재하면 `IllegalArgumentException` 예외 처리
    - [x] Answer 간의 비교 결과를 반환한다.

### generator

- #### AutoAnswerGenerator
    - `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용하여 1~9 중 중복되지 않는 무작위 숫자 3개를 추출한다.
    - 추출된 3개의 랜덤 숫자를 통해 Answer 를 반환한다.

---

### dto

- #### ComparisonResult: Answer 간의 비교 결과를 저장

---

## 어플리케이션 서비스

## view

### InputView

- [x] 정답 입력
- [x] 재시작 여부 입력

- ### util

    - ### InputParser
        - 각 기능별 validator 를 통한 입력 값 검증
            - #### 정답 값 파싱 및 Answer 객체 반환
                - [x] 정답 객체를 생성할 단일 숫자 객체로 변환

            - #### 재시도 값 파싱 및 Boolean 반환
                - [x] 재시도 입력 결과 반환: Boolean

    - ### InputValidator
        - #### 입력된 정답 값 검증
            - [x] 세 자리 숫자(0이 포함되지 않은)로만 이루어진 값이 아니라면 `IllegalArgumentException` 예외 처리

        - #### 입력된 재시도 값 검증
            - [x] 한 자리 숫자(0이 포함되지 않은)로만 이루어진 값이 아니라면 `IllegalArgumentException` 예외 처리

### OutputView

- [x] 게임 최초 시작 안내문 출력
- [x] 입력한 정답에 대한 결과 메시지 출력
- [x] 게임 종료 메시지 출력

    - ### ComparisonResultFormat: 정답 비교 결과에 대한 출력문 포맷 저장
        - [x] ComparisonResult 에 따라 적절한 출력문 반환