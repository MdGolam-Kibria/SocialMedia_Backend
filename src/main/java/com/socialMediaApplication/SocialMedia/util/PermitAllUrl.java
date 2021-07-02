package com.socialMediaApplication.SocialMedia.util;

public class PermitAllUrl {
    private static String allPrefix = "/*";
    public static String permitAllUrl[] = {
            UrlConstraint.AuthManagement.ROOT + allPrefix,
            UrlConstraint.AuthManagement.ROOT + UrlConstraint.UserManagement.CREATE_USER,
    };
}
