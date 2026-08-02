-- 코드를 작성해주세요
select SUM(SCORE) AS SCORE, e.EMP_NO, e.EMP_NAME, e.POSITION, e.EMAIL
from HR_EMPLOYEES e
join HR_GRADE g
on e.EMP_NO = g.EMP_NO
WHERE g.YEAR = 2022
GROUP BY e.EMP_NO
HAVING SUM(g.SCORE) = (
    SELECT MAX(total_score)
    FROM (
        SELECT SUM(SCORE) AS total_score
        FROM HR_GRADE
        WHERE YEAR = 2022
        GROUP BY EMP_NO
    ) t
);