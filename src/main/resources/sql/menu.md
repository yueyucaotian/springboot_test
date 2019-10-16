selectAllMenu
===
    SELECT * FROM sys_menu
    @if(!isEmpty(username)){
        LEFT JOIN sys_role_access ON sys_role_access.resource_id = sys_menu.id
        LEFT JOIN sys_role_account ON sys_role_account.role_id = sys_role_access.role_id
        WHERE sys_role_account.account_id = #userId# AND sys_role_access.type = 1
    @}
    ORDER BY sys_menu.orderby