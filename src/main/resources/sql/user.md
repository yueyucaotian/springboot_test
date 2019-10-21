findUserByName
===
    select * from sys_account where login_name=#username#
    
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
    
    @if(!isEmpty(id)){
        Where id = #id#
    @}
