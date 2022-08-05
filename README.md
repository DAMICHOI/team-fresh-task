# Team Fresh 온라인 사전 과제

## Tech Stack

- Spring Boot 2.7.2
- Java 1.8
- Gradle
- H2 Database
- Spring Data JPA

## VOC 시나리오

1. 전일 문제가 생긴 배송 건들에 대해 고객사에서 클레임 인입 시, VOC 로 등록
2. 귀책 당사자 설정
    - 운송사 : 운송사의 기사님이 배송을 잘못 보냈거나, 기사님의 실수로 배송이 늦어지는 경우
    - 고객사 : 운송사의 기사님이 정상 배송을 했으나, 고객사에서 물건을 누락해서 보냈을 경우
3. 고객사에서 배상 청구 시, 배상 접수 및 귀책 확인
4. 운송사의 귀책일 경우, 접수 후 바로 배상 시스템에 적용됨
    - 기사님의 귀책일 경우, 기사님에게 패널티(비용 청구) 접수 및 APP Push 를 통한 알림
    - 기사님의 귀책 인정 시, 사인
    - 기사님의 귀책 불인정 시, 이의 제기
5. 패널티 프로세스 완료 후, 배상 금액을 배상 시스템에 포함
    - 배상 금액을 기사님의 월급에서 차감
6. 배상 작업 완료

## 요구사항

1. VOC 목록 API
    - VOC의 귀책 당사자, 귀책 내용, 패널티 내용, 기사 확인 여부, 이의제기 여부, 배상 정보 등이 포함되어야 함
2. 배상 목록 API
    - 배상 정보의 VOC 정보, 배상 금액 정보 등이 포함되어야 함.
3. 공통
    - VOC 등록 기능
    - 패널티 등록 기능
    - 배송 기사의 패널티 확인 여부 등록
    - 배상 정보 등록
        - 배상 정보의 부모 정보인 VOC 정보를 참조할 수 있게 관계를 고려해서 개발해야 함
4. 고려 사항
    - VOC, 패널티, 배상 정보 등이 서로 **참조 관계**여야 함
5. 기타
    - 데이터는 임의의 정보를 만들어서 사용
    - 귀책 당사자는 고객사/운송사 2개의 코드를 사용하여야 함.

## DB 접속 정보

- URL : `http://localhost:8080/h2-console`
- USERNAME : `voc`
- PASSWORD : 

## DB Schema
```
-- 고객사
CREATE TABLE customer (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '고객사 ID',
    company_name VARCHAR(30) NOT NULL COMMENT '고객사명',
    manager_name VARCHAR(5) NOT NULL COMMENT '담당자명',
    contact VARCHAR(11) NOT NULL COMMENT '연락처',
    created_at TIMESTAMP NOT NULL COMMENT '등록일시',
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일시'
);

-- 운송기사
CREATE TABLE carrier (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '운송기사 ID',
    carrier_name VARCHAR(5) NOT NULL COMMENT '운송기사명',
    company_name VARCHAR(30) NOT NULL COMMENT '운송사명',
    created_at TIMESTAMP NOT NULL COMMENT '등록일시',
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일시'
);

-- 패널티 정보
CREATE TABLE penalty (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '패널티 ID',
    voc_id BIGINT NOT NULL COMMENT 'VOC ID',
    is_confirm TINYINT NOT NULL DEFAULT 'N' COMMENT '패널티 확인 여부',
    is_objection TINYINT NOT NULL DEFAULT 'N' COMMENT '이의제기 여부',
    created_at TIMESTAMP NOT NULL COMMENT '등록일시',
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일시'
);

-- 배상 정보
CREATE TABLE reparation (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '배상 ID',
    voc_id BIGINT NOT NULL COMMENT 'VOC ID',
    amount NUMERIC(19,2) NOT NULL COMMENT '배상금액',
    created_at TIMESTAMP NOT NULL COMMENT '등록일시',
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일시'
);

-- VOC 정보
CREATE TABLE voc (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'VOC ID',
    type VARCHAR(8) NOT NULL COMMENT '귀책 당사자',
    contents VARCHAR(255) NULL COMMENT '귀책 내용',
    status VARCHAR(10) NOT NULL COMMENT '진행 상태',
    customer_id BIGINT NOT NULL COMMENT '고객사 ID',
    carrier_id BIGINT NOT NULL COMMENT '운송기사 ID',
    penalty_id BIGINT NULL COMMENT '패널티 정보 ID',
    reparation_id BIGINT NULL COMMENT '배상 정보 ID',
    created_at TIMESTAMP NOT NULL COMMENT '등록일시',
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일시'
);
```

## API Swagger
- URL : `http://localhost:8080/swagger-ui/index.html`