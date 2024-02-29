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
    - 1~9 의 숫자를 무작위로 섞은 뒤 3개 숫자를 통해 단일 숫자 리스트를 저장한 Answer 반환

---

### dto

- #### ComparisonResult: Answer 간의 비교 결과를 저장

---

## 어플리케이션 서비스

## view

### InputView

- [ ] 정답 입력
- [ ] 재시작 여부 입력

### OutputView

- [ ] 게임 시작 안내문 출력
- [ ] 입력한 정답에 대한 결과(게임 종료 포함) 출력

### parser

- ### InputParser
    - #### 정답 값 파싱 및 Answer 객체 반환
        - validator 를 통한 입력 값 검증
    - [ ] 정답 객체를 생성할 단일 숫자 객체로 변환

    - #### 재시도 값 파싱 및 Boolean 반환
        - [ ] 재시도 입력 결과 반환
            - 입력 값 검증
                - [ ] null 이면 `IllegalArgumentException` 예외 처리
                - [ ] 값이 1 또는 2 인 한 자리 숫자로만 이루어진 값이 아니라면 `IllegalArgumentException` 예외 처리

### validator

- ### InputValidator
    - #### 입력된 정답 값 검증
        - [ ] 세 자리 숫자(0이 포함되지 않은)로만 이루어진 값이 아니라면 `IllegalArgumentException` 예외 처리

        - #### 입력된 재시도 값 검증
    - [ ] 한 자리 숫자(0이 포함되지 않은)로만 이루어진 값이 아니라면 `IllegalArgumentException` 예외 처리
