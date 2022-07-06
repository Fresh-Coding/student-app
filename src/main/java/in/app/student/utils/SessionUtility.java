package in.app.student.utils;

import in.app.student.common.StudentAppConstants;
import in.app.student.common.URLConstants;

import javax.servlet.http.HttpSession;

public class SessionUtility {
    public static final String KEY_USER_ID = "USER_ID";
    public static final String KEY_NAME = "NAME";
    public static final String KEY_LOGIN_TYPE = "LOGIN_TYPE";

    // 2 method, setUserIdInto session, getUserIdFrom session

    public static void setUserId(Integer userId, HttpSession session){
        session.setAttribute(KEY_USER_ID, userId);
    }

    public static Integer getUserId(HttpSession session){
        Integer userId = (Integer) session.getAttribute(KEY_USER_ID);
        return userId;
    }

    public static void setName(String name, HttpSession session){
        session.setAttribute(KEY_NAME, name);
    }

    public static String getName(HttpSession session){
        String name = (String) session.getAttribute(KEY_NAME);
        return name;
    }

    public static void setLoginType(String LoginType, HttpSession session){
        session.setAttribute(KEY_LOGIN_TYPE, LoginType);
    }

    public static String getLoginType(HttpSession session){
        String loginType = (String) session.getAttribute(KEY_LOGIN_TYPE);
        return loginType;
    }

    public static boolean isAdmin(HttpSession session){
        String loginType = getLoginType(session);
        return loginType!=null && loginType.equals(StudentAppConstants.LOGIN_TYPE_ADMIN);
    }

    public static boolean isStudent(HttpSession session){
        String loginType = getLoginType(session);
        return loginType!=null && loginType.equals(StudentAppConstants.LOGIN_TYPE_STUDENT);
    }
}
