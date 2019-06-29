SELECT * -- selected fields
FROM record; -- table name
-- record(id, name, message, datetime)
WHERE name = -- ;

GROUP BY name --
HAVING -- filter after request

create table record(
    id identity,
    name varchar(255),
    message varchar(255),
    datetime timestamp
);