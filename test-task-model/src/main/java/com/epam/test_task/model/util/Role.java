package com.epam.test_task.model.util;

public enum Role {
    ROLE_USER("ROLE_USER"), ROLE_ADMIN("ROLE_ADMIN");

    Role(String role) {
        this.role = role;
    }

    String role;

    public String getRole() {
        return this.role;
    }

    public static Role findByName(String name) throws EnumConstantNotPresentException {
        for (Role userRole : Role.values()) {
            if (userRole.getRole().equals(name)) {
                return userRole;
            }
        }
        throw new EnumConstantNotPresentException(Role.class, "Error with searching user role");
    }
}
