package secure.entity.enums;

public enum UserRoleEnum {
    ADMIN(1, "Админ"),
    USER(2, "Покупатель");

    private final int roleId;
    private final String roleName;

    UserRoleEnum(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    /**
     * Get ID of UserRole
     * @return roleId
     */
    public int getRoleId(){
        return roleId;
    }

    /**
     * Print Name of UserRole
     * @return roleName
     */
    public String toString(){
        return roleName;
    }
}
