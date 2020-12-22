package com.switchfully.youcoach.user_management.user_domain.entity;

public enum UserRole {
    COACHEE ("coachee"),
    COACH ("coach"),
    ADMIN ("admin");

    private String roleName;

    UserRole(String roleName) {
        this.roleName = roleName;
    }

    public static UserRole checkRole(User user){
        if(user.getCoach() != null) {
            return COACH;
        }
        return COACHEE;
    }

    @Override
    public String toString() {
        return roleName;
    }
}
