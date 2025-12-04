### SpringFramework DB 연동 3가지 방법

#### 1. JDBC
#### 2. MyBatis (2가지 중 택 1)
<pre>
  1) Mapper Interface + MapperXml(SQL 쿼리 작성)
  2) Mapper Interface(SQL 쿼리 작성)
</pre>
#### 3. JPA


### DB
| 구분 | RDBMS | MongoDB |
| --- |------- | --------- |
| 데이터 베이스 | 관계형 데이터베이스 | NoSQl 데이터베이스 |
| 저장 단위 | Table | Collection |
| 데이터 단위 | Row | Document |
| 데이터 속성 | Column | Field |

### 데이터 형태 3가지
<pre>
  정형 데이터 : ORACLE, mySQL 처럼 테이블 형태로 데이터 저장

  비정형 데이터 : 유튜브 자막 데이터, 사진 텍스트 데이터...

  반정형 데이터 : JSON 처럼 {키 : 값} 형태로 저장
</pre>
