addToken
===
    insert into token values (user_id,token,create_time) values (#userId#,#token#,#createTime#)
    
updateToken
===
    update token set token=#token# where id = #id#
    
findByUserId
===
    select * from token where id = #id#