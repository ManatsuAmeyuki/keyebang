package com.shg.keyebang.services.account;

import com.shg.keyebang.model.User;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class AccountSystem {

    public static void signUp(final User user, SignUpLogInListener listener){

        user.signUp(new SaveListener<User>() {
            @Override
            public void done(User u, BmobException e) {
                if(e == null) listener.onSuccess(u, u.getUsername());
                else listener.onFailure(e.toString());
            }
        });
    }

    public static void login(final User user, SignUpLogInListener listener){

        user.login(new SaveListener<User>() {
            @Override
            public void done(User user, BmobException e) {
                if(e == null) listener.onSuccess(user, user.getUsername());
                else listener.onFailure(e.toString());
            }
        });
    }
}
