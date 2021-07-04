package com.socialMediaApplication.SocialMedia.util;

public class PermitAllUrl {
    private static String allPrefix = "/*";
    public static String permitAllUrl[] = {
            UrlConstraint.AuthManagement.ROOT + allPrefix,
            UrlConstraint.AuthManagement.ROOT + UrlConstraint.UserManagement.CREATE_USER,
            UrlConstraint.PostManagement.ROOT+UrlConstraint.PostManagement.GET_ALL,
            UrlConstraint.LocationManagement.ROOT+UrlConstraint.LocationManagement.GET_BY_KEY
    };
}
