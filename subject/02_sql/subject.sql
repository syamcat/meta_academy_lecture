# s1
SELECT
    DEPARTMENT_NAME AS '학과명',
    CATEGORY AS '계열'
FROM
    tb_department;

# s2
SELECT
    CONCAT(DEPARTMENT_NAME, '의 정원은 ', CAPACITY, ' 명 입니다.') AS '학과별 정원'
FROM
    tb_department;

# s3
SELECT
    STUDENT_NAME
FROM
    tb_student
WHERE
    DEPARTMENT_NO = (SELECT DEPARTMENT_NO FROM tb_department WHERE DEPARTMENT_NAME = '국어국문학과')
    AND ABSENCE_YN = 'Y';

# s4
SELECT
    STUDENT_NAME
FROM
    tb_student
WHERE
    STUDENT_NO = 'A513079' OR STUDENT_NO = 'A513090' OR STUDENT_NO = 'A513091' OR STUDENT_NO =  'A513110' OR STUDENT_NO = 'A513119'
ORDER BY
    STUDENT_NAME DESC;

# s5

