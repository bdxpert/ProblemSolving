-- display city where male patient is greater than female patient
select city
     , count( case when gender='M'
                       then 1 end ) as Male
     , count( case when gender='F'
                       then 1 end ) as Female
from patients

group
    by city
    having Male > Female