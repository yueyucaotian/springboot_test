findUserByName
===
    select * from sys_account where login_name=#loginName#
    
findUserById
===
    select * from sys_account where id = #userId#
    
selectUsers
===
    select
    @pageTag(){
        *
    @}
    from sys_account 
    
    @if(!isEmpty(id) && id!=""){
        Where id = #id#
    @}
