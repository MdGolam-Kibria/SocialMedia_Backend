package com.socialMediaApplication.SocialMedia.util;

public class UrlConstraint {
    private UrlConstraint() {
    }

    private static final String VERSION = "/v1";
    private static final String API = "/api";


    public static class AuthManagement {
        public static final String ROOT = API + "/auth";
        public static final String LOGIN = "/login";
    }

    public static class UserManagement {
        public static final String CREATE_USER = "CreateUser";
    }

    public class PostManagement {
        public static final String ROOT = API + VERSION + "/Post";
        public static final String CREATE = "/Create";
        public static final String UPDATE = "/Update";
        public static final String DELETE = "/Delete" + "/{id}";
        public static final String GET = "/GetPost" + "/{id}";
        public static final String GET_ALL = "/GetAllPost";
    }
    public class LocationManagement {
        public static final String ROOT = API + VERSION + "/Location";
        public static final String CREATE = "/Create";
        public static final String UPDATE = "/Update";
        public static final String DELETE = "/Delete" + "/{id}";
        public static final String GET = "/GetLocation" + "/{id}";
        public static final String GET_ALL = "/GetAllLocation";
        public static final String GET_BY_KEY = "/getLocation"+"/{key}";
    }
}
