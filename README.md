# java-chess
체스 게임 구현을 위한 저장소

## Getting Started

- 실행하기 전에 아래의 SQL을 실행하여 데이터베이스와 테이블을 만듭니다.

```sql
CREATE DATABASE chess CHARACTER SET utf8 COLLATE utf8_general_ci;

use chess;

CREATE TABLE users (
                       name varchar(255) NOT NULL PRIMARY KEY,
                       win int(11) NOT NULL default 0,
                       lose int(11) NOT NULL default 0
);

CREATE TABLE room (
                      id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
                      name varchar(255) NOT NULL,
                      is_opened boolean NOT NULL,
                      white varchar(255) NOT NULL,
                      black varchar(255) NOT NULL
);

CREATE TABLE play_log (
                          id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
                          board json NOT NULL,
                          game_status json NOT NULL,
                          room_id int NOT NULL,
                          last_played_time timestamp default NOW()
);
```

- SQL을 직접 작성하는 대신 `./create_chess_db.sql`을 사용할 수도 있습니다.

## 요구 사항

- [x] 체스판 구현
    - [x] 기본 세팅
        - ![체스 기본 세팅](https://mblogthumb-phinf.pstatic.net/20160119_249/xzizazhz2_14531957418980athc_JPEG/7_00001.jpg?type=w2 )
    - [x] 현재 위치의 상태 관리
- [x] 체스 말 구현
    - [x] 각 말의 이동 전략 관리
    - [x] pawn
        - 기본적으로 백은 위로 한칸, 흑은 아래로 한 칸만 이동 가능
        - 처음 시작시에는 2칸 직진 가능
        - 직진 시 도착지에 적 또는 아군이 있다면 이동 불가
        - 대각선 방향으로 적이 있는 경우, 대각선으로 이동이 가능
    - [x] king
        - 8방으로 한 칸 이동 가능
        - 도착지에 아군이 있을 경우 이동 불가
    - [x] queen
        - 8방으로 여러 칸 이동 가능
        - 도착지에 아군이 있을 경우 이동 불가
        - 이동 경로에 적 또는 아군이 있다면 이동 불가
    - [x] bishop
        - 대각선으로 여러 칸 이동 가능
        - 도착지에 아군이 있을 경우 이동 불가
        - 이동 경로에 적 또는 아군이 있다면 이동 불가
    - [x] knight
        - 2*3 방향으로 8방 이동 가능
        - 도착지에 아군이 있을 경우 이동 불가
    - [x] rook
        - 상하좌우 4방으로 여러 칸 이동 가능
        - 도착지에 아군이 있을 경우 이동 불가
        - 이동 경로에 적 또는 아군이 있다면 이동 불가
- [x] 체스 말 이동 기능 구현
    - [x] 체스 말의 이동 전략에 만족하지 않는 이동인 경우 예외 처리
      - [x] king
      - [x] queen
      - [x] bishop
      - [x] knight
      - [x] rook
      - [x] pawn
    - [x] 체스 판의 범위를 넘어간 경우 예외 처리
    - [x] source 위치가 빈 공간일 경우 예외 처리
    - [x] destination 에 같은 편 말이 있는 경우 예외 처리
    - [x] 다른 팀의 말을 이동하려고 한 경우 예외 처리
- [x] TURN 관리 기능
- [x] KING 이 잡혔을 때 게임 종료
- [x] 명령어 입력 기능
    - [x] start
    - [x] end
    - [x] move `source` `destination`
    - [x] status
    - [x] 이 외의 입력은 예외 처리
- [x] 현재 상태의 점수 계산 기능
    - [x] 각 말에 대한 점수를 관리
    - [x] 각 말의 점수 계산 규칙은 [링크](https://techcourse.woowahan.com/s/zmAj9jfu/ls/LM7qbRaj )를 확인 한다.
- [x] 체스 게임 출력 기능
    - [x] 검은색은 대문자, 흰색은 소문자로 표현한다.
    
## 체스 웹 게임
- [x] 사이트 전체 틀 만들기
- [x] 체스판 보이기
- [x] 체스말 보이기
- [x] 체스말 이동 구현 하기
  - [x] 원하는 체스말 클릭시 가능한 이동 보이기
  - [x] 가능한 이동 클릭시 말 이동
- [x] 왕이 잡히면 게임 종료

### 리소스
* 배경: https://www.toptal.com/designers/subtlepatterns/tag/paper/
* 체스판 및 말: http://www.dreampencil.com/2013/01/paper-chess.html