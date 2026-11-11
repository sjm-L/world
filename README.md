# 세계 — 접속하지 않아도 시간이 흐르는 NPC 마을 서버

Java·Spring Boot로 만드는 NPC 마을 시뮬레이션 서버입니다. 사용자가 접속하지 않아도 서버 안에서 시간이 흐르고, NPC가 스스로 생활하는 세계를 목표로 합니다.

## 진행 상황 (2026.10 ~ 진행 중)
- [x] 세계 시계: Quartz로 5초마다 게임 시간 10분 경과
- [x] 경계 상황 테스트: 윤년 2/29 → 3/1, 10분 경과, 시작 시각 범위 (JUnit 5)
- [x] Docker Compose로 MySQL 8.4 환경 구성
- [ ] 세계 시각을 MySQL에 저장해서 서버를 재시작해도 시간 이어가기
- [ ] NPC 상태 저장과 행동 규칙
- [ ] NPC 조회 API, 서버 배포

## 기술
Java 25, Spring Boot 4, Quartz, JUnit 5, MySQL 8.4, Docker Compose, Gradle

## 실행 방법
1. `.env` 파일을 만들고 `MYSQL_ROOT_PASSWORD=원하는비밀번호` 를 적습니다
2. `docker compose up -d`   # MySQL 실행
3. `./gradlew bootRun`      # 서버 실행

## 테스트
./gradlew test

## 개발 기록
막혔던 문제와 해결 과정: https://deep-c.dev
