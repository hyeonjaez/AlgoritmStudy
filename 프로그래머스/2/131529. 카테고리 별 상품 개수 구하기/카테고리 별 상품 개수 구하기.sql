-- 코드를 입력하세요
SELECT SUBSTR(product_code, 1,2) as category,  count(*) as products from product
group by SUBSTR(product_code, 1,2)